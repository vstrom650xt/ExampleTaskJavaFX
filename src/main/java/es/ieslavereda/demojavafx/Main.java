package es.ieslavereda.demojavafx;

import es.ieslavereda.demojavafx.controller.FilosofoHIlo;
import es.ieslavereda.demojavafx.model.Tenedor;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Tenedor[] tenedors = new Tenedor[5];
        FilosofoHIlo[] filosofos = new FilosofoHIlo[5];
        for (int i = 0; i < 5; i++) {
            tenedors[i]= new Tenedor("tenedor " + i);
        }

        System.out.println(tenedors.length);
        FilosofoHIlo filosofo1 = new FilosofoHIlo("Filosofo 1", tenedors[5], tenedors[0]);
        FilosofoHIlo filosofo2 = new FilosofoHIlo("Filosofo 2", tenedors[0], tenedors[1]);
        FilosofoHIlo filosofo3 = new FilosofoHIlo("Filosofo 3", tenedors[2], tenedors[3]);
        FilosofoHIlo filosofo4 = new FilosofoHIlo("Filosofo 4", tenedors[0], tenedors[0]);
        FilosofoHIlo filosofo5 = new FilosofoHIlo("Filosofo 5", tenedors[0], tenedors[0]);



        Thread thread1 = new Thread(filosofo1);
        Thread thread2 = new Thread(filosofo2);
        Thread thread3 = new Thread(filosofo3);
        Thread thread4 = new Thread(filosofo4);
        Thread thread5 = new Thread(filosofo5);

        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();
        thread5.start();


//syncronizar los  2tenedores






    }
}
