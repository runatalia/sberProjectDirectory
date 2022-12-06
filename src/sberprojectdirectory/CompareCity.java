package sberprojectdirectory;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.stream.Collectors;

public class CompareCity {
    private Scanner scanner = new Scanner(System.in);
    private ArrayList<City> compareCity;
    private int count = 0;   //invalid selection counter

    public ArrayList<City> compareCity(ArrayList<City> city) {
        System.out.println("Введите цифру 1, если нужна сортировка списка по наименованию в алфавитном порядке.");
        System.out.println("Введите цифру 2, если нужна сортировка списка по федеральному округу по убыванию.");
        System.out.println("Введите цифру 3, если нужно вывести список без сортировки.");
        String choiceOfMethod = scanner.nextLine();
        switch (choiceOfMethod) {
            case ("1"):
                return compareByCity(city);
            case ("2"):
                return compareByRegion(city);
            case ("3"):
                return city;
            default:
                if (count > 1) {
                    System.out.println("Вы не можете выбрать, как должен выглядеть список? Тогда лучше оставить исходную версию: ");
                    return city;
                }
                System.out.println("Ошибка при выборе, попробуйте еще раз.");
                count++;
                compareCity(city);    //choice is given until invalid input more than two times(count>1), or output of an unsorted list
        }
        return city;
    }

    private ArrayList<City> compareByCity(ArrayList<City> city) {   //default sorting: alphabetically by city name
        return (ArrayList) city.stream().sorted().collect(Collectors.toList());
    }

    private ArrayList<City> compareByRegion(ArrayList<City> city) {   //sorting in reverse order by federal district and city names
        return (ArrayList) city.stream().sorted((x, y) -> {
            int compareDistrinct = y.getDistrict().compareTo(x.getDistrict());
            if (compareDistrinct == 0) return y.getName().compareTo(x.getName());
            else return compareDistrinct;
        }).collect(Collectors.toList());
    }
}

