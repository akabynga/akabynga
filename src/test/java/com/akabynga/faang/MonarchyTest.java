package com.akabynga.faang;

import com.akabynga.faang.monarchy.Monarchy;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class MonarchyTest {


    @Test
    public void givenMonarchy_addedPersonsWithRelationship_thenTwoPersonsDied_returnOrderOfSuccession() {

        // arrange
        Monarchy monarchy = new Monarchy("Jake");

        List<String> expected = List.of("Catherine", "Farah", "Mark", "Tom", "Celine", "Peter");
        // act
        monarchy.birth("Catherine", "Jake");
        monarchy.birth("Jane", "Catherine");
        monarchy.birth("Farah", "Jane");
        monarchy.birth("Tom", "Jake");
        monarchy.birth("Celine", "Jake");
        monarchy.birth("Mark", "Catherine");
        monarchy.birth("Peter", "Celine");

        monarchy.death("Jake");
        monarchy.death("Jane");

        // assert
        Assertions.assertEquals(expected, monarchy.getOrderOfSuccession());
    }
}
