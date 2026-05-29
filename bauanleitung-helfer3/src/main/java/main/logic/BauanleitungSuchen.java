package main.logic;

import main.entities.Bauanleitung;

import java.util.List;

public interface BauanleitungSuchen {
    List<Bauanleitung> bauanleitungSuchen(String name);
}
