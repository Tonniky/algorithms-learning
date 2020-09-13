package DesignPattern.AbstractFactory;

import DesignPattern.Factory.Shape;

public class Circle implements Shape {

    @Override
    public void drow() {
        System.out.printf(" Circle method");
    }
}
