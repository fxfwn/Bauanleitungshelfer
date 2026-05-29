package main.entities;

public class Bauanleitung {
    private int id;
    private String name;

    public Bauanleitung(String name) {
        this.name = name;
    }

    public Bauanleitung(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {return id;}
    public String getName() {return name;}


    @Override
    public String toString()
    {
        return getName();
    }
}
