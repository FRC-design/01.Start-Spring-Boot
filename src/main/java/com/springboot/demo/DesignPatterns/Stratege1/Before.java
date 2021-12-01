package com.springboot.demo.DesignPatterns.Stratege1;

public class Before {

    public static class SingleItemShare{
        public void algorithm(String param){
            System.out.println("single");
        }
    }

    public class MultiItemShare{
        public void algorithm(String param){
            System.out.println("multi");
        }
    }

    public class MixedItemShare{
        public void algorithm(String param){
            System.out.println("mixed");
        }
    }


    public  static class shareFactory{
        public static void main(String[] args) {
            Integer target = 1;
            if(target.equals(ShareType.Single.getCode())){
                SingleItemShare singleItemShare = new SingleItemShare();
                singleItemShare.algorithm("single");
            }

        }
    }



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

}
