package DesignPattern.createMode.Bridge;

public abstract class Person {

    private Clothing clothing;

    private String type;

    public void setClothing(Clothing clothing) {
        this.clothing = clothing;
    }

    public Clothing getClothing() {
        return clothing;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public abstract void dress();
}
