package main.controller;

import main.entities.DbBauanleitung;
import main.logic.MaterialBerechnenImpl;
import main.repository.BauanleitungRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.LinkedHashMap;

@RestController
public class UserController
{
    @GetMapping("/hello")
    public String sayHelloToUser(@RequestParam(value = "myName", defaultValue = "World") String name) {
        return String.format("Hello %s!", name);
    }

    @GetMapping("/calculate")
    @ResponseBody
    public LinkedHashMap<String, Integer> showResult(@RequestParam(value = "queryRecipe") String recipeName) {

        MaterialBerechnenImpl mbi = new MaterialBerechnenImpl();
        return mbi.materialBerechnen(recipeName);
    }

    /*
    @Autowired
    private BauanleitungRepository bauanleitungRepository;

    @PostMapping("/add")
    public String bauanleitungHinzufuegen(@RequestParam String name)
    {
        DbBauanleitung dbBau = new DbBauanleitung();
        dbBau.setName(name);
        bauanleitungRepository.save(dbBau);
        return "Eine weitere Bauanleitung wurde zum Repository hinzugefügt!";
    }

    @GetMapping("/list")
    public Iterable<DbBauanleitung> getBauanleitungen()
    {
        return bauanleitungRepository.findAll();
    }

    @GetMapping("/find/{id}")
    public DbBauanleitung findDbBauanleitungById(@PathVariable Integer id)
    {
        return bauanleitungRepository.findDbBauanleitungById(id);
    }
     */
}
