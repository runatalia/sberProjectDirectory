package sberprojectdirectory;


import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        CityListOperation cityListOperation = new CityListOperation(InputOutput.inputOutput());   //getting information from a file
        cityListOperation.amountСitiesInRegions();  //output of the maximum population
    }
}
//C:\Users\БЭГ\Downloads\_данные_Сбер_Java_20210407100345\city_ru.csv