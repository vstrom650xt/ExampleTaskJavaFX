package es.ieslavereda.demojavafx.model;

public class Tenedor {


    private String name;

    private boolean inUse;


    public Tenedor(String name) {
        this.name = name;
        this.inUse = false;
    }
    public boolean isInUse() {
        return inUse;
    }

    public void setInUse(boolean inUse) {
        this.inUse = inUse;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
