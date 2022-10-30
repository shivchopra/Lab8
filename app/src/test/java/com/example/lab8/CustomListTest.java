package com.example.lab8;


import static org.junit.Assert.assertThrows;
import static org.junit.jupiter.api.Assertions.assertEquals;


//import org.junit.Before;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class CustomListTest {

    private CustomList list;
    /**
     * create a mocklist for my citylist
     * @return
     */
    public CustomList MockCityList(){
        list = new CustomList(null,new ArrayList<>());
        return list;
    }


    /**
     * get the size of the list
     * increase the list by adding a new city
     * check if our current size matches the initial size plus
     one
     */
    @Test
    public void addCityTest(){
        list = MockCityList();
        int listSize = list.getCount();
        list.addCity(new City("Estevan", "SK"));
        assertEquals(list.getCount(),listSize + 1);
    }

    /**
     * create a new city
     * add new city to the list
     * check whether the new city is in the list.
     */
    @Test
    public void hasCityTest() {
        list = MockCityList();
        City newCity = new City("Edmonton", "AB");
        list.addCity(newCity);
        assertEquals(true, list.hasCity(newCity));
    }

    @Test
    public void deleteCityTest() {
        list = MockCityList();
        City newCity = new City("Calgary", "AB");
        list.addCity(newCity);
        assertEquals(true, list.hasCity(newCity));
        list.deleteCity(newCity);
        assertEquals(false, list.hasCity(newCity));
        assertThrows(IllegalArgumentException.class, ()-> list.deleteCity(newCity));

    }

    @Test
    public void countCitiesTest() {
        list = MockCityList();
        assertEquals(0, list.countCities());
        int count = list.countCities();
        City newCity = new City("Red Deer", "AB");
        list.addCity(newCity);
        assertEquals(count + 1, list.countCities());

    }
}
