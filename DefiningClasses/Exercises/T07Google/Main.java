package DefiningClasses.Exercises.T07Google;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        Map<String, Person> personMap = new LinkedHashMap<>();

        while (!input.equals("End")) {
            String[] info = input.split("\\s+");
            String name = info[0];
            String classType = info[1];

            Company company = null;
            Pokemon pokemon = null;
            Parents parents = null;
            Children children = null;
            Car car = null;

            personMap.putIfAbsent(name, new Person(name, company, new ArrayList<>(), new ArrayList<>(), new ArrayList<>(), car));
            switch (classType) {
                case "company":
                    String companyName = info[2];
                    String department = info[3];
                    double salary = Double.parseDouble(info[4]);
                    company = new Company(companyName, department, salary);
                    personMap.get(name).setCompany(company);
                    break;
                case "pokemon":
                    String pokemonName = info[2];
                    String pokemonType = info[3];
                    pokemon = new Pokemon(pokemonName, pokemonType);
                    personMap.get(name).getPokemonsList().add(pokemon);
                    break;
                case "parents":
                    String parentName = info[2];
                    String parentBirthday = info[3];
                    parents = new Parents(parentName, parentBirthday);
                    personMap.get(name).getParentsList().add(parents);
                    break;
                case "children":
                    String childName = info[2];
                    String childBirthday = info[3];
                    children = new Children(childName, childBirthday);
                    personMap.get(name).getChildrenList().add(children);
                    break;
                case "car":
                    String carModel = info[2];
                    String carSpeed = info[3];
                    car = new Car(carModel, carSpeed);
                    personMap.get(name).setCar(car);
                    break;
            }


            input = scanner.nextLine();
        }
        String resultForName = scanner.nextLine();

        System.out.println(resultForName);
        System.out.println("Company:");
        personMap.entrySet()
                .forEach(p -> {
                    if (p.getKey().equals(resultForName)) {
                        try {
                            System.out.printf("%s %s %.2f%n", p.getValue().getCompany().getCompanyName(),
                                    p.getValue().getCompany().getDepartment(), p.getValue().getCompany().getSalary());
//                            System.out.println(p.getValue().getCompany().getCompanyName() + " "
//                                    + p.getValue().getCompany().getDepartment() + " " +
//                                    p.getValue().getCompany().getSalary());
                        } catch (NullPointerException e) {
                            System.out.print("");
                        }
                    }
                });
        System.out.println("Car:");
        personMap.entrySet()
                .forEach(p -> {
                    if (p.getKey().equals(resultForName)) {
                        try {
                            if (p.getValue().getCar().getCarModel() != null) {
                                System.out.println(p.getValue().getCar().getCarModel() + " "
                                        + p.getValue().getCar().getCarSpeed());
                            }
                        } catch (NullPointerException ignored) {
                            System.out.print("");
                        }
                    }
                });
        System.out.println("Pokemon: ");
        personMap.entrySet()
                .forEach(p -> {
                    if (p.getKey().equals(resultForName)) {
                        try {
                            if (p.getValue().getPokemonsList() != null) {
                                p.getValue().getPokemonsList().forEach(pok -> {
                                    System.out.println(pok.getPokemonName() + " "
                                            + pok.getPokemonType());
                                });
                            }
                        } catch (NullPointerException ignored) {
                            System.out.print("");
                        }
                    }
                });
        System.out.println("Parents:");
        personMap.entrySet()
                .forEach(p -> {
                    if (p.getKey().equals(resultForName)) {
                        try {
                            if (p.getValue().getParentsList() != null) {
                                p.getValue().getParentsList().forEach(pok -> {
                                    System.out.println(pok.getParentName() + " "
                                            + pok.getParentBirthday());
                                });
                            }
                        } catch (NullPointerException ignored) {
                            System.out.print("");
                        }
                    }
                });
        System.out.println("Children:");
        personMap.entrySet()
                .forEach(p -> {
                    if (p.getKey().equals(resultForName)) {
                        try {
                            if (p.getValue().getChildrenList() != null) {
                                p.getValue().getChildrenList().forEach(pok -> {
                                    System.out.println(pok.getChildName() + " "
                                            + pok.getChildBirthday());
                                });
                            }
                        } catch (NullPointerException ignored) {
                            System.out.print("");
                        }
                    }
                });
    }
}
