package sberprojectdirectory;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class InputOutput {
    private ArrayList<City> cities;

    public ArrayList<City> getCities() {
        if (cities == null) {
            System.out.println("Справочник еще не был загружен");
        }
        return cities;
    }

    public static ArrayList<City> inputOutput() {      //reading information from a file
        ArrayList<City> cities = new ArrayList<>();
        Scanner input = new Scanner(System.in);
        System.out.println("Введите адрес файла: ");
        File file = new File(input.nextLine());
        try {
            input = new Scanner(file);
            while (input.hasNextLine()) {
                cities.add(transferToCity(input.nextLine()));   //adding a new city to the list
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } finally {
            input.close();
        }
        return cities;
    }

    public static City transferToCity(String line) {   //adding data to the City object from the received string
        String[] arrCity = line.trim().split(";");
        City city = new City();
        city.setName(arrCity[1].trim());
        city.setRegion(arrCity[2].trim());
        city.setDistrict(arrCity[3].trim());
        try {
            city.setFoundation(arrCity[5].trim());   //some lines do not contain information about Foundation
        } catch (ArrayIndexOutOfBoundsException e) {
            city.setFoundation("Нет информации.");
        }
        try {
            city.setId(Integer.parseInt(arrCity[0].trim()));  //if Id does not consist of numbers, then assign it 0
            city.setPopulation(Integer.parseInt(arrCity[4].trim())); //if Population does not consist of numbers, then assign it 0
        } catch (NumberFormatException e) {
            System.out.println("ERROR in city " + city.getName() + " with id: " + city.getId());
            city.setId(0);
            city.setPopulation(3);
        }
        return city;
    }


}
