package trivia.board;

import lombok.Getter;

import java.text.MessageFormat;

@Getter
public final class Question {
    private final String title;
    private final QuestionTopic topic;

    Question(String text, QuestionTopic topic) {
        this.topic = topic;
        this.title = MessageFormat.format("{0} Question {1}", topic.getName(), text);
    }
}
