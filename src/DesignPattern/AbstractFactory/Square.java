package DesignPattern.AbstractFactory;

import DesignPattern.Factory.Shape;

public class Square implements Shape {

    @Override
    public void drow() {
        System.out.printf("Square method!");
    }
}
