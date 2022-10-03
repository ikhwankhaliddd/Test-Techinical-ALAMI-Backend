package org.eod.helper;

import org.eod.model.Nasabah;

public class ThreadRunner2 implements Runnable {

    Nasabah nasabah;
    public ThreadRunner2(Nasabah nasabah) {
        this.nasabah = nasabah;
    }

    @Override
    public void run() {
        // Task No. 2
        double MIN_BENEFIT_2A = 100;
        double MAX_BENEFIT_2A = 150;
        double MIN_BENEFIT_2B = 150;
        int FREE_TRANSFER_2A = 5;
        int BALANCED_ADDITION_2B = 25;

        nasabah.thread2a = Thread.currentThread().getName();
        nasabah.thread2b = Thread.currentThread().getName();

        if (nasabah.saldo.getSaldo() >= MIN_BENEFIT_2A && nasabah.saldo.getSaldo() <= MAX_BENEFIT_2A) {
            // 2A
            nasabah.saldo.updateGratisTransfer(FREE_TRANSFER_2A);
        } else if (nasabah.saldo.getSaldo() > MIN_BENEFIT_2B) {
            // 2B
            nasabah.saldo.tambahSaldo(BALANCED_ADDITION_2B);
        }

    }
}
