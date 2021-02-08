package org.example.demo01;

public class Proxy implements Rent {
    private Landlord landlord;

    public Proxy() {
    }

    public Proxy(Landlord landlord) {
        this.landlord = landlord;
    }

    public void rent() {
        seeHouse();
        landlord.rent();
        fee();
    }
    public void seeHouse(){
        System.out.println("中介带你看房");
    }
    public void fee(){
        System.out.println("收中介费");
    }
}
