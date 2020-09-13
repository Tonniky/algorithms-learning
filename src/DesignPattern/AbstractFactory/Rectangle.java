package DesignPattern.AbstractFactory;

import DesignPattern.Factory.Shape;

public class Rectangle implements Shape {
    @Override
    public void drow() {
        System.out.printf("Rectangle method");
    }
}
