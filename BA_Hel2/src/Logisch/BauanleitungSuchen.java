package Logisch;

import Entities.Bauanleitung;

import java.util.List;

public interface BauanleitungSuchen {
    List<Bauanleitung> bauanleitungSuchen(String name);
}
