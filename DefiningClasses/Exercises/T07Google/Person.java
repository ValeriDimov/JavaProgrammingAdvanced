package DefiningClasses.Exercises.T07Google;

import java.util.List;

public class Person {
    private String name;
    private Company company;
    private List<Pokemon> pokemonsList;
    private List<Parents> parentsList;
    private List<Children> childrenList;
    private Car car;

    public Person(String name, Company company, List<Pokemon> pokemonsList, List<Parents> parentsList, List<Children> childrenList, Car car) {
        this.name = name;
        this.company = company;
        this.pokemonsList = pokemonsList;
        this.parentsList = parentsList;
        this.childrenList = childrenList;
        this.car = car;
    }

    public String getName() {
        return name;
    }

      public Company getCompany() {
        return company;
    }

    public List<Pokemon> getPokemonsList() {
        return pokemonsList;
    }

    public List<Parents> getParentsList() {
        return parentsList;
    }

    public List<Children> getChildrenList() {
        return childrenList;
    }

    public Car getCar() {
        return car;
    }

    public Person setCompany(Company company) {
        this.company = company;
        return null;
    }

    public Person setCar(Car car) {
        this.car = car;
        return null;
    }

    @Override
    public String toString() {
        return String.format("%s%nCompany:%n%s%nCar:%n%s%nPokemon:%n%s%nParents:%n%s%nChildren:%n%s%n", this.name,
                this.company,this.car, this.pokemonsList, this.parentsList, this.childrenList);
    }
}
