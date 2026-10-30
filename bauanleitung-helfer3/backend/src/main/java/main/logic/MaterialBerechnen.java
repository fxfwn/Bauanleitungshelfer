package main.logic;

import main.entities.JavaRezeptposition;

import java.util.*;

public interface MaterialBerechnen {
    LinkedHashMap<String, Integer> materialBerechnen(String name);
    List<JavaRezeptposition> sucheMaterial(String name);
}
