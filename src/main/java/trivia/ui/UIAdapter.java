package trivia.ui;

import trivia.board.Question;
import trivia.player.Player;

public interface UIAdapter {

    void displayNewPlayer(String playerName, int playersCount);

    void displayPlayerRoll(Player player, int roll);

    void displayPlayerPenaltyBoxStatus(Player player, boolean isPlayerInPenaltyBox);
    void displayPlayerMoved(Player player);
    void displayQuestion(Question question);

    void displayPlayerAnsweredCorrectly(Player player);

    void displayPlayerAnsweredWrongly(Player player);
}
