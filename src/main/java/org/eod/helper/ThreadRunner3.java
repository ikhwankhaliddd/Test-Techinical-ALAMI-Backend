package org.eod.helper;

import org.eod.model.Nasabah;

public class ThreadRunner3 implements Runnable {
    Nasabah nasabah;
    public ThreadRunner3(Nasabah nasabah) {
        this.nasabah = nasabah;
    }

    @Override
    public void run() {
        // Task No.3
        int MIN_ID_3 = 1;
        int MAX_ID_3 = 100;
        double BALANCE_EXTRA_3 = 10;

        nasabah.thread3 = Thread.currentThread().getName();
        if (nasabah.getId() >= MIN_ID_3 && nasabah.getId() <= MAX_ID_3) {
            nasabah.saldo.tambahSaldo(BALANCE_EXTRA_3);
        }
    }
}
