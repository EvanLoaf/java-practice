package com.gmail.evanloafakahaitao.hwk.hwk3;

public class Main {

    public static void main(String[] args) {
        CreditCard bsb = new CreditCard(101, 100.44d);
        CreditCard mtb = new CreditCard(102, 200.333d);
        CreditCard pb = new CreditCard(103, 300.1d);

        bsb.deposit(33.333);
        mtb.withdraw(50.322);
        pb.deposit(100.99);

        System.out.println("bsb: \n");
        System.out.println(bsb.toString());
        System.out.println("\nmtb: \n");
        System.out.println(mtb.toString());
        System.out.println("\npb: \n");
        System.out.println(pb.toString());
        System.out.println(Integer.toString(333, 16));
    }
}
