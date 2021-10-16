package guild;

import java.util.*;

public class Guild {
    private Set<Player> roster;
    private String name;
    private int capacity;

    public Guild(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
        this.roster = new LinkedHashSet<>();
    }

    public void addPlayer(Player player) {
        roster.add(player);
    }

    public boolean removePlayer(String name) {
        return roster.removeIf(player -> player.getName().equals(name));
    }

    public void promotePlayer(String name) {
        for (Player player : roster) {
            if (player.getName().equals(name)) {
                if (!player.getRank().equals("Member")) {
                    player.setRank("Member");
                }
            }
        }
    }

    public void demotePlayer(String name) {
        for (Player player : roster) {
            if (player.getName().equals(name)) {
                if (!player.getRank().equals("Trial")) {
                    player.setRank("Trial");
                }
            }
        }
    }

    public Player[] kickPlayersByClass(String clazz) {
        Set<Player> newPlayersSet = new LinkedHashSet<>();
        List<Player> removedPlayers = new ArrayList<>();
        for (Player player : roster) {
            if (!player.getClazz().equals(clazz)) {
                newPlayersSet.add(player);
            } else {
                removedPlayers.add(player);
            }
        }
        roster = newPlayersSet;
       return removedPlayers.toArray(new Player[0]);
    }

    public int count() {
        return roster.size();
    }

    public String report() {
        //o	"Players in the guild: {guildName}:
        //{Player1}
        //{Player2}
        StringBuilder sb = new StringBuilder();
        sb.append("Players in the guild: ").append(this.name).append(System.lineSeparator());
        for (Player player : roster) {
            sb.append(player.toString()).append(System.lineSeparator());
        }
        return sb.toString();
    }
}
