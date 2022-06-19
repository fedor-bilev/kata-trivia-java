package trivia.ui;

import trivia.board.Question;
import trivia.player.Player;

import static java.lang.System.out;
import static java.text.MessageFormat.format;

public class ConsoleUIAdapter implements UIAdapter {

    @Override
    public void displayNewPlayer(String playerName, int playersCount) {
        out.println(playerName + " was added");
        out.println("They are player number " + playersCount);
    }

    @Override
    public void displayPlayerRoll(Player player, int roll) {
        out.println(player.getName() + " is the current player");
        out.println("They have rolled a " + roll);
    }

    @Override
    public void displayPlayerPenaltyBoxStatus(Player player, boolean isPlayerInPenaltyBox) {
        if (isPlayerInPenaltyBox) {
            out.println(player.getName() + " is not getting out of the penalty box");
        } else {
            out.println(player.getName() + " is getting out of the penalty box");
        }
    }

    @Override
    public void displayPlayerMoved(Player player) {
        out.println(
                format(
                    "{0}''s new location is {1}",
                    player.getName(),
                    player.getPosition()));
    }

    @Override
    public void displayQuestion(Question question) {
        out.println("The category is " + question.getTopic().getName());
        out.println(question.getTitle());
    }

    @Override
    public void displayPlayerAnsweredCorrectly(Player player) {
        out.println("Answer was correct!!!!");
        out.println(
                format(
                        "{0} now has {1} Gold Coins.",
                        player.getName(),
                        player.getScore()));
    }

    @Override
    public void displayPlayerAnsweredWrongly(Player player) {
        out.println("Question was incorrectly answered");
        out.println(player.getName() + " was sent to the penalty box");
    }
}
