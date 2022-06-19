package trivia;

import trivia.board.Board;
import trivia.board.Question;
import trivia.player.Player;
import trivia.player.PlayerManager;
import trivia.ui.ConsoleUIAdapter;
import trivia.ui.UIAdapter;

public class GameBetter implements IGame {

    private static final int MAX_SCORE = 6;

    private final PlayerManager playerManager = new PlayerManager();
    private final Board board = new Board();
    private final UIAdapter uiAdapter = new ConsoleUIAdapter();

    @Override
    public boolean add(String playerName) {
        playerManager.addPlayer(playerName);
        uiAdapter.displayNewPlayer(playerName, playerManager.getPlayersCount());
        return true;
    }

    @Override
    public void roll(int roll) {
        Player player = playerManager.getCurrentPlayer();
        uiAdapter.displayPlayerRoll(player, roll);

        if (player.isInPenaltyBox()) {
            boolean isPlayerSillInPenaltyBox = board.tryReleaseFromPenaltyBox(player, roll);
            uiAdapter.displayPlayerPenaltyBoxStatus(player, isPlayerSillInPenaltyBox);
        }
        if (!player.isInPenaltyBox()) {
            board.movePlayer(player, roll);
            Question question = board.getQuestionForPlayer(player);
            uiAdapter.displayPlayerMoved(player);
            uiAdapter.displayQuestion(question);
        }
    }

    @Override
    public boolean wasCorrectlyAnswered() {
        Player player = playerManager.getCurrentPlayer();
        if (!player.isInPenaltyBox()) {
            player.increaseScore();
            uiAdapter.displayPlayerAnsweredCorrectly(player);
        }
        playerManager.setNextPlayer();
        return !didPlayerWin(player);
    }

    @Override
    public boolean wrongAnswer() {
        Player player = playerManager.getCurrentPlayer();
        uiAdapter.displayPlayerAnsweredWrongly(player);
        board.movePlayerToPenaltyBox(player);
        playerManager.setNextPlayer();
        return true;
    }

    private boolean didPlayerWin(Player player) {
        return player.getScore() == MAX_SCORE;
    }
}
