package Logisch;

import Entities.Bauanleitung;

import java.util.List;

public interface UserService {
    List<Bauanleitung> bauanleitungSuchen(String name);
}
