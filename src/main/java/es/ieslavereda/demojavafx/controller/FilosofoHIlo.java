package es.ieslavereda.demojavafx.controller;

import es.ieslavereda.demojavafx.model.Tenedor;

public class FilosofoHIlo implements  Runnable{

    private String name;
    private Tenedor tenedor;
    private Tenedor tenedor2;

    public FilosofoHIlo(String name,Tenedor tenedor, Tenedor tenedor2) {
        this.name = name;
        this.tenedor = tenedor;
        this.tenedor2 = tenedor2;
    }

    public void cogerTenedores() {
        synchronized (tenedor) {
            synchronized (tenedor2) {
                System.out.println(name + " ha cogido los tenedores y está comiendo.");
                tenedor.setInUse(true);
                tenedor2.setInUse(true);
                try {
                    Thread.sleep(1000);
                    dejarTenedor();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(name + " ha terminado de comer.");
            }
        }
    }

//    public void cogerTenedor(){
//        tenedor.setInUse(true);
//        tenedor2.setInUse(true);
//    }

    public void dejarTenedor(){
        tenedor.setInUse(false);
        tenedor2.setInUse(false);
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
            siesta();
            cogerTenedores();
            dejarTenedor();
        }


    }
}
