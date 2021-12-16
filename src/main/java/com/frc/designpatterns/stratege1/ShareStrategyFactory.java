package com.frc.designpatterns.stratege1;

import java.util.HashMap;
import java.util.Map;

public class ShareStrategyFactory {

    enum ShareType{
        Single(1,"single"),
        Multi(2,"Multi"),
        Mixed(3,"Mixed");

        private Integer code;
        private String param;

        ShareType(Integer code, String param) {
            this.code = code;
            this.param = param;
        }

        public Integer getCode(){
            return code;
        }

    }


    /**
     *策略模式初始化, 策略缓存
     */
    private static final Map<String, ShareStrategy> shareStrategies = new HashMap<>();
    static {
        shareStrategies.put("oder", new OrderItemShare());
        // shareStrategies.put("single", new Before().MultiItemShare());
    }

    public static ShareStrategy getShareStrategy(String type){
        if(type == null || type.isEmpty()){
            throw new IllegalArgumentException("fuvck");
        }
        return shareStrategies.get(type);
    }



    public static void main(String[] args) {
        String type = "order";
        ShareStrategy  shareStrategy = ShareStrategyFactory.getShareStrategy(type);
        shareStrategy.algorithm("order");
    }
}
