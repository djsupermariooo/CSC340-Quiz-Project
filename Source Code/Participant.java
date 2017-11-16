/**
 * Participant Class
 * 
 * This class creates an object of a participant and holds the participant's
 * information.
 * 
 * @author Augustine, Mario, Cody
 */
public class Participant {
    // Private fields
    private String firstName;
    private String lastName;
    private int numRobLions;
    private int score;
    private String userAnswer;
    
    // Constructor
    public Participant() {
        firstName = "";
        lastName = "";
        numRobLions = 0;
        score = 0;
        userAnswer = "";
    }
    
    /**
     * Used to get the participant's first name
     * @return the participant's first name
     */
    public String getFirstName() {
        return firstName;
    }
    
    /**
     * Used to get the participant's last name
     * @return the participant's last name
     */
    public String getLastName() {
        return lastName;
    }
    
    /**
     * Used to get the number of robotic lions the participant owns
     * @return the number of robotic lions
     */
    public int getNumRobLions() {
        return numRobLions;
    }
    
    /**
     * Used to get the participant's current score
     * @return the current score of the participant
     */
    public int getScore() {
        return score;
    }
    
    /**
     * Used to get the current answer entered by the participant
     * @return the participant's current answer
     */
    public String getAnswer() {
        return userAnswer;
    }
    
    /**
     * Used to set the participant's first name
     * @param fn the first name of the participant
     */
    public void setFirstName(String fn) {
        firstName = fn;
    }
    
    /**
     * Used to set the participant's last name
     * @param ln the last name of the participant
     */
    public void setLastName(String ln) {
        lastName = ln;
    }
    
    /**
     * Used to set the participant's amount of robotic lions
     * @param num the number of robotic lions the participant has
     */
    public void setRobLions(int num) {
        numRobLions = num;
    }
    
    /**
     * Used to set the participant's current score
     * @param newScore the number to set the score to
     */
    public void setScore(int newScore) {
        score = newScore;
    }
    
    /**
     * Used to set the participant's current answer
     * @param userAnswer the current answer of the participant
     */
    public void setAnswer(String userAnswer) {
        this.userAnswer = userAnswer;
    }
}