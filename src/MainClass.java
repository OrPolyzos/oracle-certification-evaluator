import practice_tests.PracticeTest;
import practice_tests.PracticeTestParser;

public class MainClass {

    private static final String PRACTICE_TEST_FILES_PATH = "practice_tests_files\\oca_ocp_practice_tests\\";
    private static final String OCA_1Z0_808_PATH = "practice_tests_files\\oca_1z0_808\\";

    public static void main(String[] args) {
        new PracticeTestParser(PRACTICE_TEST_FILES_PATH, PracticeTest.CREATING_AND_USING_ARRAYS).runTest();
    }
}
