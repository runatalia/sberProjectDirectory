package sberprojectdirectory;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class CityListOperation {  //any operation with List City
    CityListOperation(ArrayList<City> cityList) {
        city = cityList.toArray(new City[0]);
        getMaxCityPopulation();
    }

    private City[] city;
    private int maxPopulation = 0;
    private int max = 0;
    private Map<String, Integer> numberOfCitiesInRegions = new HashMap<>();

    private void getMaxCityPopulation() {  //searching for a maximum by a population
        for (int i = 0; i < city.length; i++) {
            if (maxPopulation < city[i].getPopulation()) {
                maxPopulation = city[i].getPopulation();
                max = i;
            }
        }
    }

    public int getMaxPopulationCityByPopulation() {
        return city[max].getPopulation();
    }

    public int getMaxIdCityByPopulation() {
        return city[max].getId();
    }

    public String getMaxNameCityByPopulation() {
        return city[max].getName();
    }

    public String getMaxDistrictCityByPopulation() {
        return city[max].getDistrict();
    }

    public String getMaxFoundationCityByPopulation() {
        return city[max].getFoundation();
    }

    public void amountСitiesInRegions() {                                      //number of cities by regions
        Map<String, List<City>> numberOfCitiesInRegions = Arrays.stream(city)  //grouping cities by region
                .collect(Collectors.groupingBy(x -> x.getRegion()));
        for (Map.Entry<String, List<City>> map : numberOfCitiesInRegions.entrySet()) {
            System.out.println(map.getKey() + " - " + map.getValue().size());   //output to the console of the region and the number of cities in it
        }
    }

}
