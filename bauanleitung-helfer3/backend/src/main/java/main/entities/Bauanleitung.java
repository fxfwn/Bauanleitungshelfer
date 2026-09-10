package main.entities;

public class Bauanleitung {
    private int bau_id;
    private String bau_name;

    public Bauanleitung(String name) {
        this.bau_name = name;
    }

    public int getBau_id() {return bau_id;}
    public String getBau_name() {return bau_name;}


    @Override
    public String toString()
    {
        return getBau_name();
    }
}
