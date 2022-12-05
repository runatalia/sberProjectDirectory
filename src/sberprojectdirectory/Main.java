package sberprojectdirectory;


import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<City> cities = InputOutput.InputOutput();   //getting information from a file
        System.out.println(cities);
        for (City city : cities) {
            System.out.println(city);
        }
    }
}
//C:\Users\БЭГ\Downloads\_данные_Сбер_Java_20210407090226\city_ru.csv