package DefiningClasses.Exercises.T06PokemonTrainer;

import java.util.List;
import java.util.Map;

public class Trainer {
    private String trainerName;
    private int badges = 0;
    private List<Pokemon> pokemons;

    public void setBadges(int badges) {
        this.badges = badges;
    }

    public Trainer(String trainerName, List<Pokemon> pokemons) {
        this.trainerName = trainerName;
        this.pokemons = pokemons;
    }

    public String getTrainerName() {
        return trainerName;
    }

    public int getBadges() {
        return badges;
    }

    public List<Pokemon> getPokemons() {
        return pokemons;
    }

    @Override
    public String toString() {
        return String.format("%s %d %d", this.trainerName, this.badges, this.pokemons.size());
    }
}
