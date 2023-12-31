package es.ieslavereda.demojavafx.controller;

import es.ieslavereda.demojavafx.model.Tenedor;

public class FilosofoHIlo implements  Runnable {

    private String name;
    private Tenedor tenedor;
    private Tenedor tenedor2;

    public FilosofoHIlo(String name, Tenedor tenedor, Tenedor tenedor2) {
        this.name = name;
        this.tenedor = tenedor;
        this.tenedor2 = tenedor2;
    }

    public void cogerTenedores() {

        synchronized (tenedor2) {
            // tenedor esta bloqueado
            synchronized (tenedor) {
                // tenedor 2 esta bloqueado
                System.out.println(name + " ha cogido los tenedores y está comiendo.");
                try {
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




    public  void siesta(){
        try {
            Thread.sleep(4000);
        }catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public void run() {
        while (true) {
            cogerTenedores();
            siesta();

        }


    }
}
