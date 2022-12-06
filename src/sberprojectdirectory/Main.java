package sberprojectdirectory;


import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        CityListOperation max = new CityListOperation(InputOutput.inputOutput());   //getting information from a file
        System.out.println("[" + max.getMaxIdCityByPopulation() + "] = " + max.getMaxPopulationCityByPopulation());  //output of the maximum population
    }
}
//C:\Users\БЭГ\Downloads\_данные_Сбер_Java_20210407090226\city_ru.csv