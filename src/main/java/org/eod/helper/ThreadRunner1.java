package org.eod.helper;

import org.eod.model.Nasabah;

public class ThreadRunner1 implements Runnable {

    Nasabah nasabah;
    public ThreadRunner1(Nasabah customer) {
        this.nasabah = nasabah;
    }

    @Override
    public void run() {
        // Task No. 1
        nasabah.thread1 = Thread.currentThread().getName();

        nasabah.saldo.hitungSaldoRataRata();
    }
}
