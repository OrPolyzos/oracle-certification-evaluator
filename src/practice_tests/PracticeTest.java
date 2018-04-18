package practice_tests;

public enum PracticeTest {

    JAVA_BASICS("JavaBasics"),
    WORKING_WITH_JAVA_DATA_TYPES("WorkingWithJavaDataTypes"),
    USING_OPERATORS_AND_DECISION_CONSTRUCTS("UsingOperatorsAndDecisionConstructs"),
    CREATING_AND_USING_ARRAYS("CreatingAndUsingArrays"),
    USING_LOOP_CONSTRUCTS("UsingLoopConstructs"),
    WORKING_WITH_METHODS_AND_ENCAPSULATION("WorkingWithMethodsAndEncapsulation"),
    WORKING_WITH_INHERITANCE("WorkingWithInheritance"),
    HANDLING_EXCEPTIONS("HandlingExceptions"),
    WORKING_WITH_SELECTED_CLASSES_FROM_THE_JAVA_API("WorkingWithSelectedClassesFromTheJavaApi"),
    OCA_PRACTICE_EXAM("OCA_Practice_Exam"),
    JAVA_BUILDING_BLOCKS("JavaBuildingBlocks");

    private static final String TXT_SUFFIX = ".txt";
    private final String testName;

    PracticeTest(String testName) {
        this.testName = testName;
    }

    @Override
    public String toString() {
        return this.testName.concat(TXT_SUFFIX);
    }
}
