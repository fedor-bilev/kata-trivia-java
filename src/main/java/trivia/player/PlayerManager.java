package trivia.player;


import java.util.ArrayDeque;
import java.util.Queue;

public class PlayerManager {

    private final Queue<Player> players = new ArrayDeque<>();

    public void addPlayer(String playerName) {
        Player player = new Player(playerName);
        players.add(player);
    }

    public Player getCurrentPlayer() {
        return players.peek();
    }

    public void setNextPlayer() {
        players.add(players.remove());
    }

    public int getPlayersCount() {
        return players.size();
    }
}
