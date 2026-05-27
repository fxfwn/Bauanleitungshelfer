package Entities;

public class Bauanleitung {
    private int id;
    private String name;

    public Bauanleitung(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {return id;}
    public String getName() {return name;}
}
