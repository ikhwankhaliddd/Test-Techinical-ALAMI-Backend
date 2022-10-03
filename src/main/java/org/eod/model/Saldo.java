package org.eod.model;

public class Saldo {
    private double saldo;
    private double saldoSebelum;
    private double saldoRataRata;
    private int gratisTransfer;

    public Saldo(double saldo, double saldoSebelum, double saldoRataRata, int gratisTransfer) {
        this.saldo = saldo;
        this.saldoSebelum = saldoSebelum;
        this.saldoRataRata = saldoRataRata;
        this.gratisTransfer = gratisTransfer;
    }

    public double getSaldo() {

        return saldo;
    }

    public double getSaldoSebelum() {

        return saldoSebelum;
    }

    public double getSaldoRataRata() {

        return saldoRataRata;
    }

    public int getGratisTransfer() {

        return gratisTransfer;
    }

    public void hitungSaldoRataRata() {

        saldoRataRata = ( saldo + saldoSebelum ) / 2;
    }

    public void tambahSaldo(double addition) {

        saldo += addition;
    }

    public void updateGratisTransfer(int quantity) {

        gratisTransfer = quantity;
    }
}
