package DefiningClasses.Exercises.T07Google;

public class Pokemon {
    private String pokemonName;
    private String pokemonType;

    public Pokemon(String pokemonName, String pokemonType) {
        this.pokemonName = pokemonName;
        this.pokemonType = pokemonType;
    }

    public String getPokemonName() {
        return pokemonName;
    }

    public String getPokemonType() {
        return pokemonType;
    }

    @Override
    public String toString() {
        if (this.pokemonName != null) {
            return String.format("%s %s", this.pokemonName, this.pokemonType);
        } else {
            return "";
        }
    }
}
