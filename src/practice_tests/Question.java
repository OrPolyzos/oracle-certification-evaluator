package practice_tests;

public class Question {

    private int questionNumber;
    private char[] answers;
    private String answerDescription;

    public Question(int questionNumber, char[] answers, String answerDescription) {
        this.questionNumber = questionNumber;
        this.answers = answers;
        this.answerDescription = answerDescription;
    }

    public int getQuestionNumber() {
        return questionNumber;
    }

    public char[] getAnswers() {
        return answers;
    }

    public String getAnswerDescription() {
        return answerDescription;
    }
}
