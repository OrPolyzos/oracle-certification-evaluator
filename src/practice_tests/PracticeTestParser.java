package practice_tests;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class PracticeTestParser {

    private String path;
    private String testName;
    private List<Question> questionsList;

    public PracticeTestParser(String path, PracticeTest practiceTest) {
        this.path = path;
        this.testName = practiceTest.toString();
        questionsList = formTest();
    }

    private List<Question> formTest() {
        List<Question> questionsList = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(new File(path.concat(testName))))) {
            String pattern = "^(\\d*)[.](\\s)[A-Z](, [A-Z])*[.](\\s)(.*)";
            String ignorePattern = "^Chapter (\\d*):(\\s)(.*)|^(\\d*)(\\s)Appendix(\\s)(.*)";
            int questionNumber = 0;
            char[] answers = new char[0];
            StringBuilder answerDescription = new StringBuilder();
            for (String line; (line = br.readLine()) != null; ) {
                if (line.matches(ignorePattern)) continue;
                if (line.matches(pattern)) {
                    if (questionNumber != 0 && answers.length != 0) {
                        questionsList.add(new Question(questionNumber, answers, answerDescription.toString()));
                    }
                    questionNumber = Integer.parseInt(line.split("\\. ")[0]);
                    String[] answersString = line.split("\\. ")[1].split(", ");
                    answers = new char[answersString.length];
                    for (int i = 0; i < answersString.length; i++) {
                        answers[i] = answersString[i].charAt(0);
                    }
                    int firstPartLength = String.valueOf(questionNumber + ". ").length() + (answers.length * 3);
                    answerDescription = new StringBuilder();
                    answerDescription.append(line.substring(firstPartLength).concat("\n"));
                } else {
                    answerDescription.append(line.concat("\n"));
                }
            }
            questionsList.add(new Question(questionNumber, answers, answerDescription.toString()));
        } catch (IOException e) {
            System.err.println("Could not read the file at: '" + this.path.concat(this.testName));
            System.exit(0);
        }
        return questionsList;
    }

    public void runTest() {
        System.out.println(testName);
        System.out.println("Please use single letters to respond (optionally separated by commas) for ex. A,D,F");
        int score = 0;
        int totalCorrectAnswers = 0;
        for (Question question : questionsList) {
            System.out.println("Question " + question.getQuestionNumber() + ":");
            String answerLine = new Scanner(System.in).nextLine();
            while (answerLine.length() < 1) {
                System.out.println("Please use single letters to respond (optionally separated by commas) for ex. A,D,F");
                answerLine = new Scanner(System.in).nextLine();
            }
            String[] answers = answerLine.split(",");
            for (int i = 0, j = 0; i < answers.length && j < question.getAnswers().length; i++, j++) {
                char candidateAnswer = answers[i].toUpperCase().charAt(0);
                char correctAnswer = question.getAnswers()[j];
                if (candidateAnswer == correctAnswer) {
                    System.out.println("Your answer: " + candidateAnswer + " was correct!");
                    score++;
                } else {
                    System.out.println("Your answer: " + candidateAnswer + " was wrong! Correct answer: " + correctAnswer);
                }
            }
            totalCorrectAnswers += question.getAnswers().length;
            System.out.println("Correct answer(s): " + Arrays.toString(question.getAnswers()));
            System.out.println(question.getAnswerDescription());
        }
        System.out.println("You answered " + score + " out of " + totalCorrectAnswers + " questions correct!");
    }
}
