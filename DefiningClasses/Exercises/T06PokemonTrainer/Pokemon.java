package DefiningClasses.Exercises.T06PokemonTrainer;

public class Pokemon {
    private String pokemonName;
    private String element;
    private int health;

    public void setHealth(int health) {
        this.health = health;
    }

    public Pokemon(String name, String element, int health) {
        this.pokemonName = name;
        this. element = element;
        this.health = health;
    }

    public String getPokemonName() {
        return this.pokemonName;
    }

    public String getElement() {
        return element;
    }

    public int getHealth() {
        return health;
    }

}
