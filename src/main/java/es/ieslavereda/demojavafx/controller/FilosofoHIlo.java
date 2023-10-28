package es.ieslavereda.demojavafx.controller;

import es.ieslavereda.demojavafx.model.Tenedor;

import java.util.concurrent.Semaphore;

public class FilosofoHIlo implements Runnable {

    private String name;
    private Tenedor tenedor;
    private Tenedor tenedor2;

    public FilosofoHIlo(String name, Tenedor tenedor, Tenedor tenedor2) {
        this.name = name;
        this.tenedor = tenedor;
        this.tenedor2 = tenedor2;

    }

    public void cogerTenedores() {
        if (tenedor.isInUse()) {
            synchronized (tenedor) {
                // tenedor esta bloqueado
                synchronized (tenedor2) {
                    // tenedor2 esta bloqueado
                    System.out.println(name + " ha cogido los tenedores y está comiendo.");
                    try {
                        tenedor.setInUse(true);
                        tenedor2.setInUse(true);
                        Thread.sleep(1000);
                        dejarTenedor();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(name + " ha terminado de comer.");
                }
                // tenedor2 deja de estar bloqueado
            }
            // tenedor deja de estar bloqueado

        } else {
            synchronized (tenedor2) {
                // tenedor esta bloqueado
                synchronized (tenedor) {
                    // tenedor2 esta bloqueado
                    System.out.println(name + " ha cogido los tenedores y está comiendo.");
                    try {
                        tenedor.setInUse(true);
                        tenedor2.setInUse(true);
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(name + " ha terminado de comer.");
                }
                // tenedor2 deja de estar bloqueado
            }
            // tenedor deja de estar bloqueado

        }

    }


    public void dejarTenedor() {
        tenedor.setInUse(false);
        tenedor2.setInUse(false);
    }


    public void siesta() {
        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void run() {
        while (true) {
            cogerTenedores();
            dejarTenedor();
            siesta();

        }
    }
}
