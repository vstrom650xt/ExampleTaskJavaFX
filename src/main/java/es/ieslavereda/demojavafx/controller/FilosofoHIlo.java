package es.ieslavereda.demojavafx.controller;

import es.ieslavereda.demojavafx.model.Tenedor;

import java.util.concurrent.Semaphore;

public class FilosofoHIlo implements  Runnable{
    private int vecesComidas; // Número de veces que el filósofo ha comido
    private static Semaphore semaphore = new Semaphore(4); // Un semáforo con 4 permisos

    private String name;
    private Tenedor tenedor;
    private Tenedor tenedor2;

    public FilosofoHIlo(String name,Tenedor tenedor, Tenedor tenedor2) {
        this.name = name;
        this.tenedor = tenedor;
        this.tenedor2 = tenedor2;
        this.vecesComidas = 5000;

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
        int comidasRealizadas = 0;

        while (true) {
            siesta();
            try {
                semaphore.acquire(); // Un filósofo adquiere un permiso del semáforo
                cogerTenedores();
                dejarTenedor();
                semaphore.release(); // El filósofo libera el permiso
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

    }
}}
