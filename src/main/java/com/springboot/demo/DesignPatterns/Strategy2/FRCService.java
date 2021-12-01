package com.springboot.demo.DesignPatterns.Strategy2;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

/**
 * 使用MAP与函数式接口实现策略模式
 */
public class FRCService {

    private Map<String, Function<String, String>> checkResultDispatcher = new HashMap<>();

    public void checkResultDispatcherInit(){
        checkResultDispatcher.put("策略1", order-> String.format("业务逻辑1", order));
        checkResultDispatcher.put("策略2", order-> String.format("业务逻辑2", order));
        checkResultDispatcher.put("策略3", order-> String.format("业务逻辑3", order));
        checkResultDispatcher.put("策略4", order-> String.format("业务逻辑4", order));
        /**
         * 抽象一个service放业务逻辑，然后定义中调用
         * checkResultDispatcher.put("strategy from serviced", order->Service.certainService(order));
         **/

    }

    public String getCheckResultSuper(String order, String level){
        String key = logicalJudgment(order, level);

        Function<String, String> result = checkResultDispatcher.get(key);
        if(result != null){
            return result.apply(order);
        }
        return "error";
    }

    public  String logicalJudgment(String order, String level){
        return "logical judgment for key";
    }
}
