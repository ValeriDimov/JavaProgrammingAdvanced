package DefiningClasses.Exercises.T06PokemonTrainer;

import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        Map<String, Trainer> trainersMap = new LinkedHashMap<>();
        Map<String, Trainer> trainersMapWithNamesPok = new LinkedHashMap<>();

        while (!input.equals("Tournament")) {
            String[] inputArr = input.split("\\s+");
            String trainerName = inputArr[0];
            String pokemonName = inputArr[1];
            String pokemonElement = inputArr[2];
            int pokemonHealth = Integer.parseInt(inputArr[3]);
            Pokemon pokemon = new Pokemon(pokemonName, pokemonElement, pokemonHealth);

            Trainer trainer = new Trainer(trainerName, new ArrayList<>());
            trainersMap.putIfAbsent(trainerName, trainer);
            trainersMap.get(trainerName).getPokemons().add(pokemon);
//            trainersMapWithNamesPok.putIfAbsent(trainerName, trainer);
//            trainersMapWithNamesPok.get(trainerName).getPokemons().put(pokemonName, pokemon);

            input = scanner.nextLine();
        }
        String secondCommand = scanner.nextLine();
        System.out.println();

        while (!secondCommand.equals("End")) {
            switch (secondCommand) {
                case "Fire":
                    trainersMap.entrySet().forEach(t -> {
                        t.getValue().getPokemons().stream().forEach(pokemon -> {
                            boolean isHaving = false;
                            if (pokemon.getElement().equals("Fire")) {
                                int currentBadges = t.getValue().getBadges();
                                t.getValue().setBadges(currentBadges + 1);
                                isHaving = true;
                            }
                            if (!isHaving) {
                                int currentHealth = pokemon.getHealth();
                                pokemon.setHealth(currentHealth - 10);
                            }

                        });
                    });
                    break;
                case "Water":
                    trainersMap.entrySet().forEach(t -> {
                        t.getValue().getPokemons().stream().forEach(pokemon -> {
                            if (pokemon.getElement().equals("Water")) {
                                int currentBadges = t.getValue().getBadges();
                                t.getValue().setBadges(currentBadges + 1);
                            }
                        });
                    });
                    break;
                case "Electricity":
                    trainersMap.entrySet().forEach(t -> {
                        t.getValue().getPokemons().stream().forEach(pokemon -> {
                            if (pokemon.getElement().equals("Electricity")) {
                                int currentBadges = t.getValue().getBadges();
                                t.getValue().setBadges(currentBadges + 1);
                            }
                        });
                    });
                    break;
            }

            secondCommand = scanner.nextLine();
        }

        trainersMap.entrySet()
                .stream()
                .sorted((e1, e2) -> Integer.compare(e2.getValue().getBadges(), e1.getValue().getBadges()))
                .forEach(t -> {
                    System.out.printf("%s %d %d%n", t.getKey(), t.getValue().getBadges(), t.getValue().getPokemons().size());
                });
    }
}
