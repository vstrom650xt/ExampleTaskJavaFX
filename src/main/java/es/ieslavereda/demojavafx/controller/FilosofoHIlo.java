package es.ieslavereda.demojavafx.controller;

import es.ieslavereda.demojavafx.model.Tenedor;

public class FilosofoHIlo implements Runnable {


    private String name;
    private Tenedor tenedor;
    private Tenedor tenedor2;

     private  int posicion;
    public FilosofoHIlo(String name, Tenedor tenedor, Tenedor tenedor2) {
        this.name = name;
        this.tenedor = tenedor;
        this.tenedor2 = tenedor2;

    }

    public void cogerTenedores() {
        if (!tenedor.isInUse()&& !tenedor2.isInUse()){
            synchronized (tenedor) {
                tenedor.setInUse(true);
                // tenedor esta bloqueado
                synchronized (tenedor2) {
                    // tenedor2 esta bloqueado
                    tenedor2.setInUse(true);
                    System.out.println(name + " ha cogido los tenedores y está comiendo.");
                    try {
                        Thread.sleep(3000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(name + " ha terminado de comer.");
                }
                // tenedor2 deja de estar bloqueado
                dejarTenedor(tenedor2);
            }
            dejarTenedor(tenedor);
            // tenedor deja de estar bloqueado

        }else{}


        siesta();

    }
    public void dejarTenedor(Tenedor t) {
        t.setInUse(false);
    }
    public void siesta() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void run() {
        while (true) {
            cogerTenedores();
        }
    }
}
