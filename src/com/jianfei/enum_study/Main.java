package com.jianfei.enum_study;


public class Main {
    public static void main(String[] args) {
//        for (EnumTest enumTest : EnumTest.values()) {
//            System.out.println("枚举遍历->" + enumTest.toString());
//        }
        insertLogisticStatus(LogisticsStatusEnum.CUSTOMER_TAKE_OFF);
        System.out.println("---------");
        System.out.println("enum->" + EnumTest.MON);
        System.out.println("GoodsStatus->" + GoodsStatus.分拣中.name());
        System.out.println("GoodsStatus->" + GoodsStatus.配货中.name());
        System.out.println("GoodsStatus->" + GoodsStatus.出货中.name());
        System.out.println("GoodsStatus->" + GoodsStatus.运输途中.name());
        System.out.println("GoodsStatus->" + GoodsStatus.到达香港自取点.name());
        System.out.println("GoodsStatus->" + GoodsStatus.客人已取走.name());
        String a = "分拣中";
        System.out.println("equals->" + a.equals(GoodsStatus.分拣中.name()));
    }

    public static void insertLogisticStatus(LogisticsStatusEnum logisticsStatusEnum) {
        String nowState = "";
        switch (logisticsStatusEnum.getCode()) {
            case 1:
                nowState = LogisticsStatusEnum.DISTRIBUTION_GOODS.getMessage();
                break;
            case 2:
                nowState = LogisticsStatusEnum.PREPARE_OUT_GOODS.getMessage();
                break;
            case 3:
                nowState = LogisticsStatusEnum.OUTING_GOODS.getMessage();
                break;
            case 4:
                nowState = LogisticsStatusEnum.ARRIVED_SELF_HELP_SPOT.getMessage();
                break;
            case 5:
                nowState = LogisticsStatusEnum.CUSTOMER_TAKE_OFF.getMessage();
                break;
        }
        System.out.println("打印switch-case->" + nowState);
    }
}
