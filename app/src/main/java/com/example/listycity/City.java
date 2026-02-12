package com.example.listycity;

/**
 * Class that defines a city based on its city name and province.
 */
public class City implements Comparable<City> {
    private String city;
    private String province;
    City(String city, String province){
        this.city = city;
        this.province = province;
    }

    /**
     * Returns the name of the city.
     *
     * @return name of this city
     */
    public String getCityName() {
        return this.city;
    }

    /**
     * Returns the name of the province in which the city is located.
     *
     * @return name of the province of this city
     */
    public String getProvinceName() {
        return this.province;
    }

    /**
     * Compares this city with another city lexicographically based on their city names.
     *
     * @param o the City to be compared
     * @return a negative integer, zero, or a positive integer as this city's
     *         name is less than, equal to, or greater than the specified city's name
     */
    @Override
    public int compareTo(City o) {
        City city = (City) o;
        return this.city.compareTo(city.getCityName());
    }
}