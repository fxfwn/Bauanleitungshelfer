package main.controller;

import main.entities.DbBauanleitung;
import main.repository.BauanleitungRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController
{

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
}
