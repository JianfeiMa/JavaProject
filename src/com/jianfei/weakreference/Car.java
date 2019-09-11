package com.jianfei.weakreference;

/**
 * author: JianfeiMa
 * email: majianfei93@163.com
 * created date: 2019-09-07 08:40
 */
public class Car {
    private double price;
    private String colour;

    public Car(double price, String colour) {
        this.price = price;
        this.colour = colour;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getColour() {
        return colour;
    }

    public void setColour(String colour) {
        this.colour = colour;
    }

    @Override
    public String toString() {
        return "Car{" +
                "price=" + price +
                ", colour='" + colour + '\'' +
                '}';
    }
}
