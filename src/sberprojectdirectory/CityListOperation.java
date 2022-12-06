package sberprojectdirectory;

import java.util.ArrayList;

public class CityListOperation {  //any operation with List City
    CityListOperation(ArrayList<City> cityList) {
        city = cityList.toArray(new City[0]);
        getMaxCityPopulation();
    }

    private City[] city;
    private int maxPopulation = 0;
    private int max = 0;

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
}

