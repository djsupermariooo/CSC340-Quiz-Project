/**
 * Question Class
 * 
 * This class is used to store the questions and correct answers from the quiz.
 * 
 * @author Augustine, Mario, Cody
 */
public class Question {
    // Private fields
    private String question;
    private String correctAnswer;
    
    /**
     * Constructor
     * 
     * Initializes fields to default settings
     */
    public Question()
    {
        question = "";
        correctAnswer = "";
    }
    
    /**
     * Used to compare the answer entered by the user with the correct answer
     * @param userAnswer the answer entered by the user
     * @param correctAnswer the correct answer read from the questions file
     * @return true if the answers match, otherwise false
     */
    public boolean compareAnswers(String userAnswer, String correctAnswer) {
        return (userAnswer.equals(correctAnswer));
    }
    
    /**
     * Used to get a String containing the question
     * @return a String of the current question
     */
    public String getQuestion() {
        return question;
    }
    
    /**
     * Used to get a String containing the correct answer
     * @return a String of the correct answer to the current question
     */
    public String getCorrectAnswer() {
        return correctAnswer;
    }
    
    /**
     * Used to set the current question
     * @param questionText a String containing the question
     */
    public void setQuestion(String questionText) {
        question = questionText;
    }
    
    /**
     * Used to set the correct answer
     * @param correctAnswer a String containing the correct answer
     */
    public void setCorrectAnswer(String correctAnswer) {
        this.correctAnswer = correctAnswer;
    }
}