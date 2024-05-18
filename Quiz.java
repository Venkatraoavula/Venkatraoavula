import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
//Abstract Question class representing a  question
abstract class Question {
    private String questionText;
    //Question method for question initializations
    public Question(String questionText) {
        this.questionText = questionText;
    }
    public String getQuestionText() {
        return questionText;
    }
    //Method for checking answer
    public abstract boolean checkAnswer(String answer);
}
//Defining MultipleChoiceQuestion class for representing the multiple choice questions
class MultipleChoiceQuestion extends Question {
    //Initializations
    private List<String> options;
    private int correctOptionIndex;
    public MultipleChoiceQuestion(String questionText, List<String> options, int correctOptionIndex) {
        super(questionText);
        this.options = options;
        this.correctOptionIndex = correctOptionIndex;
    }
    //Overriding the checkAnswer method for checking correct answer
    @Override
    public boolean checkAnswer(String answer) {
        int selectedOptionIndex;
        try {
            selectedOptionIndex = Integer.parseInt(answer);
        } catch (NumberFormatException e) {
            return false; // Invalid input
        }
        return selectedOptionIndex == correctOptionIndex;
    }
    //Getting options
    public List<String> getOptions() {
        return options;
    }
}
//Defining TrueFalseQuestion class for representing the true/false questions
class TrueFalseQuestion extends Question {
    //Initializations
    private boolean correctAnswer;
    public TrueFalseQuestion(String questionText, boolean correctAnswer) {
        super(questionText);
        this.correctAnswer = correctAnswer;
    }
    //Overriding the checkAnswer method for checking correct answer
    @Override
    public boolean checkAnswer(String answer) {
        boolean userAnswer;
        try {
            userAnswer = Boolean.parseBoolean(answer);
        } catch (IllegalArgumentException e) {
            return false; // Invalid input
        }
        return userAnswer == correctAnswer;
    }
}
//Defining the FillBlankQuestion class representing the fill in the blank questions
class FillBlankQuestion extends Question {
    //Initializations
    private String correctAnswer;
    public FillBlankQuestion(String questionText, String correctAnswer) {
        super(questionText);
        this.correctAnswer = correctAnswer;
    }
    //Overriding the checkAnswer method for checking correct answer
    @Override
    public boolean checkAnswer(String answer) {
        return answer.equalsIgnoreCase(correctAnswer);
    }
}
// Quiz class representing a collection of questions
class Quiz {
    private List<Question> questions;
    public Quiz() {
        this.questions = new ArrayList<>();
    }
    public void addQuestion(Question question) {
        questions.add(question);
    }
    public List<Question> getQuestions() {
        return questions;
    }
    //Calculating the marks percentage for our Quiz performance
    public double calculateMarks(List<String> answers) {
        int correctCount = 0;
        for (int i = 0; i < questions.size(); i++) {
            if (questions.get(i).checkAnswer(answers.get(i))) {
                correctCount++;
            }
        }
        return ((double) correctCount / questions.size()) * 100;
    }
}
//Main class for our platform
public class OnlineQuiz {
    public static void main(String[] args) {
        // Create a example sample quiz
        Quiz quiz = new Quiz();
        quiz.addQuestion(new MultipleChoiceQuestion("What is the capital of India?",List.of("1. Jammu&Kashmir", "2. Delhi", "3. Telangana"), 2));
        quiz.addQuestion(new TrueFalseQuestion("Is Java a programming language?", true));
        quiz.addQuestion(new FillBlankQuestion("The largest planet in the solar system is ________.", "Jupiter"));
        quiz.addQuestion(new MultipleChoiceQuestion("Who is the author of Harry Potter?",List.of("1. J.K.Rowling", "2. William Shakespeare", "3. Russell"), 1));
        quiz.addQuestion(new MultipleChoiceQuestion("What is the Captain Cool of Team India?",List.of("1. Virat Kohli", "2. M.S.Dhoni", "3. Rohit Sharma"), 2));
        quiz.addQuestion(new FillBlankQuestion("The father of the Java Programming Language is ________.", "James Gosling"));
        quiz.addQuestion(new TrueFalseQuestion("The switch selection structure must end with the default case.", false));
        // Taking answers from the user as input
        Scanner scanner = new Scanner(System.in);
        List<String> userAnswers = new ArrayList<>();
        for (Question question : quiz.getQuestions()) {
            System.out.println(question.getQuestionText());
            //Checking if the question is MCQ's it provides all options 
            if (question instanceof MultipleChoiceQuestion) {
                MultipleChoiceQuestion mcq = (MultipleChoiceQuestion) question;
                for (String option : mcq.getOptions()) {
                    System.out.println(option);
                }
            }
            //User input for answer
            System.out.print("Your answer: ");
            String userAnswer = scanner.nextLine();
            userAnswers.add(userAnswer);
            //Checks the user answer is correct or incorrect
            if (question.checkAnswer(userAnswer)) {
                System.out.println("Correct Option!\n");
            } else {
                System.out.println("Incorrect Option!\n");
            }
        }
        scanner.close();
        // Calculate marks
        double marks = quiz.calculateMarks(userAnswers);
        System.out.println("Your marks: " + marks + "%");
    }
                                  }
