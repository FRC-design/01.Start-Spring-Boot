package com.frc.multithread;

import com.frc.entity.FeeRecord;

import java.util.concurrent.*;

/**
 * @author frc
 */
public class CyclicBarrierDemo {
    /**
     * 订单队列
     */
    ArrayBlockingQueue<FeeRecord> payOrder;
    /**
     *派送单队列
     */
    ArrayBlockingQueue<FeeRecord> deliveryOrder;

    /**
     * 执行回调的线程池
     */
    Executor executor = new ThreadPoolExecutor(1,
            1,
            0L,
            TimeUnit.MILLISECONDS,
            new LinkedBlockingQueue<>(),
            new NamedThreadFactory());

    final CyclicBarrier barrier = new CyclicBarrier(2,
            ()-> executor.execute(this::check));


    private void checkAll(){
        // 循环查询订单库
        new Thread(()->{
            //存在未对账订单
            while(existUncheckedOrder()){
                // 查询订单库
                payOrder.add(getPOrders());
                // 等待
                try {
                    barrier.await();
                } catch (InterruptedException | BrokenBarrierException e) {
                    e.printStackTrace();
                }
            }
        }).start();

        // 循环查询运单库
         new Thread(()->{
            //存在未对账订单
            while(existUncheckedOrder()){
                // 查询运单库
                deliveryOrder.add(getDOrders());
                // 等待
                try {
                    barrier.await();
                } catch (InterruptedException | BrokenBarrierException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }


    private void check(){
        FeeRecord p = payOrder.poll();
        FeeRecord d = deliveryOrder.poll();
        // 执行对账操作
        String diff = checkDiff(p, d);
        // 差异写入差异库
        save(diff);
    }

    private void save(String diff) {
        return;
    }

    private String checkDiff(FeeRecord p, FeeRecord d) {
        return null;
    }

    private boolean existUncheckedOrder(){
        return true;
    }

    private FeeRecord getDOrders() {
        return null;
    }

    private FeeRecord getPOrders() {
        return null;
    }
}
