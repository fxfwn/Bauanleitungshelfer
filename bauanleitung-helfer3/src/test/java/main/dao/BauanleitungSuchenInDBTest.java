package main.dao;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;


class BauanleitungSuchenInDBTest {

    @Test
    void sucheBauanleitungInDB() {

        BauanleitungSuchenInDB testCase = new BauanleitungSuchenInDB();

        List<String> expected = List.of("Baum", "Bruecke", "Blumenbeet", "Bus", "Bank",
                                    "Brunnen", "Bushaltestelle");
        List<String> result = testCase.sucheBauanleitungNameInDB("Ba%");

        Assertions.assertEquals(expected, result);
    }
}