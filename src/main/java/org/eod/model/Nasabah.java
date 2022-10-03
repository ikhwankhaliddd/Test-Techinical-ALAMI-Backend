package org.eod.model;

public class Nasabah {
    int id;
    String name;
    int age;
    public String thread1;
    public String thread2a;
    public String thread2b;
    public String thread3;

    public Saldo saldo;

    public Nasabah(int id, String name, int age, Saldo saldo) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.saldo = saldo;
    }

    public int getId() {

        return id;
    }

    public String getName() {

        return name;
    }

    public int getAge() {

        return age;
    }
}
