package com.company;

public class BilPark {
    private Bil[] bilPark = new Bil[10];

    public BilPark(){
        for (int i = 0; i < 10; i++) {
            bilPark[i] = new Bil();
        }
    }
}
