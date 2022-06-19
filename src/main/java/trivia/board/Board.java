package trivia.board;

import trivia.player.Player;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Map;
import java.util.Queue;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.toCollection;

public class Board {
    private final int BOARD_SIZE = 12;
    private final int QUESTIONS_PER_TOPIC = 50;
    private final Map<QuestionTopic, Queue<Question>> questions = getRandomQuestions();

    public void movePlayer(Player player, int roll) {
        if (!player.isInPenaltyBox()) {
            player.setPosition(getNewPlayerPosition(player, roll));
        }
    }

    public boolean tryReleaseFromPenaltyBox(Player player, int roll) {
        if (canPlayerLeavePenaltyBox(roll)) {
            player.setInPenaltyBox(false);
        }
        return player.isInPenaltyBox();
    }

    public void movePlayerToPenaltyBox(Player player) {
        player.setInPenaltyBox(true);
    }

    public Question getQuestionForPlayer(Player player) {
        QuestionTopic topic = getTopicForPlayer(player);
        return questions.get(topic).remove();
    }

    private QuestionTopic getTopicForPlayer(Player player) {
        QuestionTopic[] topics = QuestionTopic.values();
        int position = player.getPosition();
        return topics[position % topics.length];
    }

    private boolean canPlayerLeavePenaltyBox(int roll) {
        return roll % 2 != 0;
    }

    private int getNewPlayerPosition(Player player, int roll) {
        return (player.getPosition() + roll) % BOARD_SIZE;
    }

    private Map<QuestionTopic, Queue<Question>> getRandomQuestions() {
        return Arrays.stream(QuestionTopic.values())
                .flatMap(topic -> IntStream
                        .range(0, QUESTIONS_PER_TOPIC)
                        .mapToObj(text -> new Question(String.valueOf(text), topic)))
                .collect(groupingBy(
                        Question::getTopic,
                        toCollection(ArrayDeque::new)));
    }
}
