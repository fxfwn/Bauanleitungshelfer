package main.dao;

import main.entities.Bauanleitung;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class BauanleitungSuchenInDBTest {

    @Test
    void sucheBauanleitungInDB() {

        BauanleitungSuchenInDB testCase = new BauanleitungSuchenInDB();

        List<String> expected = List.of("Baum", "Bruecke", "Blumenbeet", "Bus", "Bank",
                                    "Brunnen", "Bushaltestelle");
        List<String> result = testCase.sucheBauanleitungInDB("B%");

        Assertions.assertEquals(expected, result);
    }
}