package DesignPattern.constructMode.Proxy;

public class ProxyTest {
    public static void main(String[] args) {
        Image image = new ProxyImage("test.jpg");
        image.display();

    }
}
