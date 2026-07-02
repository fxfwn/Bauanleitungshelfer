package main.logic;

import main.entities.Bauanleitung;

import java.util.ArrayList;
import java.util.List;

public interface BauanleitungSuchen {
    List<String> bauanleitungSuchen(String begriff);
}
