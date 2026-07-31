package main.logic;

import main.entities.Rezeptposition;

import java.util.HashMap;
import java.util.List;
import java.util.Objects;

public interface MaterialBerechnen {
    HashMap<String, Integer> materialBerechnen(String name);
    List<Rezeptposition> sucheMaterial(String name);
}
