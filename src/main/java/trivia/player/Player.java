package trivia.player;

import lombok.Data;

@Data
public class Player {
    private final String name;
    private int position;
    private boolean inPenaltyBox;
    private int score;

    public void increaseScore() {
        score++;
    }
}
