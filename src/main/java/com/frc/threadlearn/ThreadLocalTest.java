package com.frc.threadlearn;

import java.lang.ref.WeakReference;

public class ThreadLocalTest {
    public static void main(String[] args) {
        /**
         * 弱引用被回收
         */
        WeakReference<String> weakReference1 = new WeakReference<>(new String("ssssss"));
        System.gc();
        if(weakReference1.get() == null){
            System.out.println("weak leak does not happen");
        }else{
            System.out.println(weakReference1.get());;
        }
        /**
         * 弱引用没有被回收
         */
        String str = "memory leak happens";
        WeakReference<String> weakReference = new WeakReference<>(str);
        System.gc();
        if(weakReference.get() == null){
            System.out.println("weak leak does not happen");
        }else{
            System.out.println(weakReference.get());;
        }



    }
}
