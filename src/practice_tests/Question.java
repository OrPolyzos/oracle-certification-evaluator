package practice_tests;

import java.util.Set;

public class Question {

    private int questionNumber;
    private Set<Character> answers;
    private String answerDescription;

    public Question(int questionNumber, Set<Character> answers, String answerDescription) {
        this.questionNumber = questionNumber;
        this.answers = answers;
        this.answerDescription = answerDescription;
    }

    public int getQuestionNumber() {
        return questionNumber;
    }

    public Set<Character> getAnswers() {
        return answers;
    }

    public String getAnswerDescription() {
        return answerDescription;
    }

    @Override
    public String toString() {
        return "Question{" +
                "questionNumber=" + questionNumber +
                ", answers=" + answers +
                '}';
    }
}
