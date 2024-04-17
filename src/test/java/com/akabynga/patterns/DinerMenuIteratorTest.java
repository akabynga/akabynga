package com.akabynga.patterns;

import com.akabynga.patterns.iterator.DinerMenu;
import com.akabynga.patterns.iterator.MenuItem;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Iterator;

public class DinerMenuIteratorTest {

    @Test
    public void givenDinerMenu_removeAllMenuItems_expectedZeroElementsInMenu() {

        // arrange
        DinerMenu menu = new DinerMenu();
        Iterator<MenuItem> iterator = menu.iterator();

        // act
        while (iterator.hasNext()) {
            iterator.remove();
        }

        // assert
        Assertions.assertEquals(0, menu.size());
    }
}
