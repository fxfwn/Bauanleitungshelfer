package main.logic;

import main.entities.Rezeptposition;

import java.util.*;

public interface MaterialBerechnen {
    LinkedHashMap<String, Integer> materialBerechnen(String name);
    List<Rezeptposition> sucheMaterial(String name);
}
