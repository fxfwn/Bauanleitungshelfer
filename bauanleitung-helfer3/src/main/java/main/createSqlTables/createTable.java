package main.createSqlTables;

public enum createTable {
    Bauanleitung("""
        CREATE TABLE IF NOT EXISTS Bauanleitung (
            id INTEGER PRIMARY KEY,
            name TEXT NOT NULL
        );
    """),

    Rezeptposition("""
        CREATE TABLE IF NOT EXISTS Rezeptposition (
             id INTEGER PRIMARY KEY,
             bauanleitung_id INTEGER,
             komponente_id INTEGER,
             menge INTEGER,
             FOREIGN KEY (bauanleitung_id) REFERENCES Bauanleitung(id),
             FOREIGN KEY (komponente_id) REFERENCES Komponente(id)
        );
    """),

    Komponent("""
        CREATE TABLE IF NOT EXISTS Komponent (
              id INTEGER PRIMARY KEY,
              name TEXT NOT NULL,
              kategorie TEXT NOT NULL,
              menge INTEGER
        );
    """);

    public final String sql;

    createTable(String sql) {
        this.sql = sql;
    }
}
