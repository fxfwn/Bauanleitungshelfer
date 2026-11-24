package main.controller;

import main.entities.JavaRezeptposition;
import main.logic.MaterialBerechnenImpl;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@RestController
public class UserController
{
    @GetMapping("/hello")
    public String sayHelloToUser(@RequestParam(value = "myName", defaultValue = "World") String name) {
        return String.format("Hello %s!", name);
    }

    @GetMapping("/calculate")
    @ResponseBody
    public String showResult(@RequestParam(value = "queryRecipe") String recipeName) {

        MaterialBerechnenImpl mbi = new MaterialBerechnenImpl();
        LinkedHashMap<String, Integer> showRes = mbi.materialBerechnen(recipeName);
        List<String> materialZurSchau = new ArrayList<>();

        for (Map.Entry<String, Integer> eintrag : showRes.entrySet())
        {
            materialZurSchau.add(String.format("Komponente: %s [%dx]", eintrag.getKey(), eintrag.getValue()));
        }

        return String.format("%s", materialZurSchau);
    }

    /*
    @GetMapping("/search")
    @ResponseBody
    public String getBauanleitung(@RequestParam(value = "searchRecipe") String recipeName)
    {
        MaterialBerechnenImpl mbi = new MaterialBerechnenImpl();
        List<JavaRezeptposition> listPos = mbi.sucheMaterial(recipeName);
        List<String> materialZurSchau = new ArrayList<>();

        //for ()
        return null;
    }
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
