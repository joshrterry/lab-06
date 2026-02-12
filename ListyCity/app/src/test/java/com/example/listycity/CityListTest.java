package com.example.listycity;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CityListTest {
    private CityList mockCityList() {
        CityList cityList = new CityList();
        cityList.add(mockCity());
        return cityList;
    }
    private City mockCity() {
        return new City("Edmonton", "Alberta");
    }

    @Test
    public void testAdd() {
        CityList cityList = mockCityList();
        assertEquals(1, cityList.getCities().size());
        City city = new City("Calgary", "Alberta");
        cityList.add(city);
        assertEquals(2, cityList.getCities().size());
        assertTrue(cityList.getCities().contains(city));
    }

    @Test
    public void testAddException() {
        CityList cityList = mockCityList();
        City city = new City("Winnipeg", "Manitoba");
        cityList.add(city);
        assertThrows(IllegalArgumentException.class, () -> {
            cityList.add(city);
        });
    }

    @Test
    public void testGetCities() {
        CityList cityList = mockCityList();
        assertEquals(0, mockCity().compareTo(cityList.getCities().get(0)));
        City city = new City("Calgary", "Alberta");
        cityList.add(city);
        assertEquals(0, city.compareTo(cityList.getCities().get(0)));
        assertEquals(0, mockCity().compareTo(cityList.getCities().get(1)));
    }

    @Test
    public void testHasCity() {
        CityList cityList = mockCityList();
        City oldCity = cityList.getCities().get(0);
        City newCity = new City("Winnipeg", "Manitoba");
        assertTrue(cityList.hasCity(oldCity));
        assertFalse(cityList.hasCity(newCity));
    }

    @Test
    public void testDeleteCity() {
        CityList cityList = mockCityList();
        City city = cityList.getCities().get(0);
        assertTrue(cityList.getCities().contains(city));
        cityList.delete(city);
        assertFalse(cityList.getCities().contains(city));

    }

    @Test
    public void testDeleteException() {
        CityList cityList = mockCityList();
        City city = new City("Winnipeg", "Manitoba");
        assertThrows(IllegalArgumentException.class, () -> {
            cityList.delete(city);
        });
    }

    @Test
    public void testCountCity() {
        CityList cityList = mockCityList();
        assertEquals(1, cityList.countCities());
        cityList.add(new City("Toronto", "Ontario"));
        assertEquals(2, cityList.countCities());
    }
}
