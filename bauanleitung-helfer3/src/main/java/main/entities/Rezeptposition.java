package main.entities;

public class Rezeptposition {
    private String bau_name;
    private int kom_id;
    private String kom_name;
    private String kom_kategorie;
    private int rez_menge;

    public String getBau_name() {
        return bau_name;
    }

    public int getKom_id() {
        return kom_id;
    }

    public String getKom_name() {
        return kom_name;
    }

    public String getKom_kategorie() {
        return kom_kategorie;
    }

    public int getRez_menge() {
        return rez_menge;
    }

    public Rezeptposition(String bau_name, int kom_id, String kom_name, String kom_kate, int rez_men) {
        this.bau_name = bau_name;
        this.kom_id = kom_id;
        this.kom_name = kom_name;
        this.kom_kategorie = kom_kate;
        this.rez_menge = rez_men;
    }

    @Override
    public String toString() {
        return "|" + this.kom_id + "|" + this.kom_name + "|" + this.kom_kategorie + "|" + this.rez_menge + "|";
    }
}
