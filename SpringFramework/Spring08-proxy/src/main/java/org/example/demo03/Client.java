package org.example.demo03;

public class Client {
    public static void main(String[] args) {
        Landlord landlord = new Landlord();
        ProxyInvocationHandler handler = new ProxyInvocationHandler();
        handler.setRent(landlord);
        Rent proxy = (Rent) handler.getProxy();
        proxy.rent();
    }
}
