import java.awt.Toolkit;
import java.awt.event.WindowEvent;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ButtonGroup;

/**
 * Quiz Class
 * 
 * This class is used to display and run the quiz.
 * 
 * @author Augustine, Mario, Cody
 */
public class Quiz extends javax.swing.JFrame {
    // Class fields
    ButtonGroup tfbuttons = new ButtonGroup();
    ButtonGroup mcbuttons = new ButtonGroup();
    Participant user = new Participant();
    Question question = new Question();
    Scanner scanner;
    
    // Constructor
    public Quiz() throws FileNotFoundException {
        initComponents();
        scanner = new Scanner(new FileInputStream("questions.txt"));
        saAnswerPanel.setVisible(false);
        tfAnswerPanel.setVisible(false);
        mcAnswerPanel.setVisible(false);
        scoreText.setVisible(false);
        finishText.setVisible(false);
        tfbuttons.add(tfanswer1);
        tfbuttons.add(tfanswer2);
        mcbuttons.add(mcanswer1);
        mcbuttons.add(mcanswer2);
        mcbuttons.add(mcanswer3);
        mcbuttons.add(mcanswer4);
    }
    
    /**
     * This method is called when a user clicks the take quiz button and triggers the UserInfoFrame class to gather user data.
     */
    public void takeQuiz() {
        UserInfoFrame userInfo = new UserInfoFrame(this, user);
        userInfo.setVisible(true);
    }
    
    /**
     * This method is called when there are no more questions to ask. It displays the end screen and the user's score.
     * @throws IOException if the program cannot write to the file that stores the scores
     */
    public void quizComplete() throws IOException {
        // Hide all answer panels and submit button
        tfAnswerPanel.setVisible(false);
        saAnswerPanel.setVisible(false);
        mcAnswerPanel.setVisible(false);
        submitButton.setVisible(false);
        
        // Display end screen to user
        questionText.setText("Congratulations " + user.getFirstName() + "!");
        finishText.setText("Your score is:");
        scoreText.setText(Integer.toString(user.getScore()));
        finishText.setVisible(true);
        scoreText.setVisible(true);
        
        // Output user data and score to a text file
        BufferedWriter output = null;
        try {
           output = new BufferedWriter(new FileWriter("results.txt", true));
           output.write("\n" + user.getFirstName() + " " + user.getLastName() + " " + user.getNumRobLions() + " " + user.getScore());
        } catch ( IOException e ) {
           e.printStackTrace();
        } finally {
            output.close();
        }
    }
    
    /**
     * Used to get the next question and answer choices from the text file.
     * @throws IOException if the program cannot read the file
     */
    public void nextQuestion() throws IOException {
        String currentLine;
        if (!scanner.hasNextLine())
            quizComplete();
        else {
            currentLine = scanner.nextLine();
            // It is a true/false question
            if (currentLine.charAt(0) == 'T')
            {
                // Update question text and display true/false answer panel
                question.setQuestion(currentLine.substring(2));
                setQuestionText(question.getQuestion());
                String answer1 = scanner.nextLine();
                String answer2 = scanner.nextLine();
                tfanswer1.setSelected(false);
                tfanswer2.setSelected(false);
                tfanswer1.setText(answer1);
                tfanswer2.setText(answer2);
                mcAnswerPanel.setVisible(false);
                saAnswerPanel.setVisible(false);
                tfAnswerPanel.setVisible(true);
                question.setCorrectAnswer(scanner.nextLine());
            }
            // It is a multiple choice question
            else if (currentLine.charAt(0) == 'M')
            {
                // Update question text and display multiple choice answer panel
                question.setQuestion(currentLine.substring(2));
                setQuestionText(question.getQuestion());
                String answer1 = scanner.nextLine();
                String answer2 = scanner.nextLine();
                String answer3 = scanner.nextLine();
                String answer4 = scanner.nextLine();
                mcanswer1.setSelected(false);
                mcanswer2.setSelected(false);
                mcanswer3.setSelected(false);
                mcanswer4.setSelected(false);
                mcanswer1.setText(answer1);
                mcanswer2.setText(answer2);
                mcanswer3.setText(answer3);
                mcanswer4.setText(answer4);
                tfAnswerPanel.setVisible(false);
                saAnswerPanel.setVisible(false);
                mcAnswerPanel.setVisible(true);
                question.setCorrectAnswer(scanner.nextLine());
            }
            // It is a short answer question
            else if (currentLine.charAt(0) == 'S')
            {
                // Update question text and display short answer panel
                question.setQuestion(currentLine.substring(2));
                setQuestionText(question.getQuestion());
                saTextField.setText("");
                mcAnswerPanel.setVisible(false);
                tfAnswerPanel.setVisible(false);
                saAnswerPanel.setVisible(true);
                saTextField.requestFocus();
                question.setCorrectAnswer(scanner.nextLine());
            }
        }
    }
    
    /**
     * Used to set the question text GUI component to a String containing the current question.
     * @param question a String containing the current question
     */
    public void setQuestionText(String question) {
        questionText.setText(question);
    }

    // Initialize GUI components
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        homeButton = new javax.swing.JButton();
        submitButton = new javax.swing.JLabel();
        scoreText = new javax.swing.JLabel();
        finishText = new javax.swing.JLabel();
        questionText = new javax.swing.JLabel();
        saAnswerPanel = new javax.swing.JPanel();
        saTextField = new javax.swing.JTextField();
        mcAnswerPanel = new javax.swing.JPanel();
        mcanswer1 = new javax.swing.JRadioButton();
        mcanswer2 = new javax.swing.JRadioButton();
        mcanswer3 = new javax.swing.JRadioButton();
        mcanswer4 = new javax.swing.JRadioButton();
        tfAnswerPanel = new javax.swing.JPanel();
        tfanswer1 = new javax.swing.JRadioButton();
        tfanswer2 = new javax.swing.JRadioButton();
        background = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);
        getContentPane().setLayout(null);

        jPanel1.setLayout(null);

        homeButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/home_icon.png"))); // NOI18N
        homeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                homeButtonActionPerformed(evt);
            }
        });
        jPanel1.add(homeButton);
        homeButton.setBounds(40, 400, 40, 30);

        submitButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/submitButton.png"))); // NOI18N
        submitButton.setText("jLabel1");
        submitButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                submitButtonMouseClicked(evt);
            }
        });
        jPanel1.add(submitButton);
        submitButton.setBounds(540, 350, 120, 80);

        scoreText.setFont(new java.awt.Font("Tahoma", 0, 48)); // NOI18N
        scoreText.setForeground(new java.awt.Color(255, 255, 255));
        scoreText.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jPanel1.add(scoreText);
        scoreText.setBounds(0, 180, 670, 150);

        finishText.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        finishText.setForeground(new java.awt.Color(255, 255, 255));
        finishText.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        finishText.setText("Your score is:");
        jPanel1.add(finishText);
        finishText.setBounds(10, 100, 670, 150);

        questionText.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        questionText.setForeground(new java.awt.Color(255, 255, 255));
        questionText.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jPanel1.add(questionText);
        questionText.setBounds(10, 50, 670, 150);

        saAnswerPanel.setEnabled(false);
        saAnswerPanel.setOpaque(false);

        saTextField.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        javax.swing.GroupLayout saAnswerPanelLayout = new javax.swing.GroupLayout(saAnswerPanel);
        saAnswerPanel.setLayout(saAnswerPanelLayout);
        saAnswerPanelLayout.setHorizontalGroup(
            saAnswerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, saAnswerPanelLayout.createSequentialGroup()
                .addGap(154, 154, 154)
                .addComponent(saTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 340, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        saAnswerPanelLayout.setVerticalGroup(
            saAnswerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, saAnswerPanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(saTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(156, 156, 156))
        );

        jPanel1.add(saAnswerPanel);
        saAnswerPanel.setBounds(10, 210, 670, 160);

        mcAnswerPanel.setEnabled(false);
        mcAnswerPanel.setOpaque(false);

        mcanswer1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        mcanswer1.setForeground(new java.awt.Color(255, 255, 255));
        mcanswer1.setOpaque(false);

        mcanswer2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        mcanswer2.setForeground(new java.awt.Color(255, 255, 255));
        mcanswer2.setOpaque(false);

        mcanswer3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        mcanswer3.setForeground(new java.awt.Color(255, 255, 255));
        mcanswer3.setOpaque(false);

        mcanswer4.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        mcanswer4.setForeground(new java.awt.Color(255, 255, 255));
        mcanswer4.setOpaque(false);

        javax.swing.GroupLayout mcAnswerPanelLayout = new javax.swing.GroupLayout(mcAnswerPanel);
        mcAnswerPanel.setLayout(mcAnswerPanelLayout);
        mcAnswerPanelLayout.setHorizontalGroup(
            mcAnswerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mcAnswerPanelLayout.createSequentialGroup()
                .addGap(152, 152, 152)
                .addGroup(mcAnswerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(mcanswer3, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(mcanswer1, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(106, 106, 106)
                .addGroup(mcAnswerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(mcanswer2)
                    .addComponent(mcanswer4))
                .addContainerGap(212, Short.MAX_VALUE))
        );
        mcAnswerPanelLayout.setVerticalGroup(
            mcAnswerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, mcAnswerPanelLayout.createSequentialGroup()
                .addGap(48, 48, 48)
                .addGroup(mcAnswerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(mcanswer2)
                    .addComponent(mcanswer1))
                .addGap(32, 32, 32)
                .addGroup(mcAnswerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(mcanswer3)
                    .addComponent(mcanswer4))
                .addGap(17, 38, Short.MAX_VALUE))
        );

        jPanel1.add(mcAnswerPanel);
        mcAnswerPanel.setBounds(10, 210, 670, 160);

        tfAnswerPanel.setEnabled(false);
        tfAnswerPanel.setOpaque(false);

        tfanswer1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        tfanswer1.setForeground(new java.awt.Color(255, 255, 255));
        tfanswer1.setOpaque(false);

        tfanswer2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        tfanswer2.setForeground(new java.awt.Color(255, 255, 255));
        tfanswer2.setOpaque(false);

        javax.swing.GroupLayout tfAnswerPanelLayout = new javax.swing.GroupLayout(tfAnswerPanel);
        tfAnswerPanel.setLayout(tfAnswerPanelLayout);
        tfAnswerPanelLayout.setHorizontalGroup(
            tfAnswerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, tfAnswerPanelLayout.createSequentialGroup()
                .addGap(152, 152, 152)
                .addComponent(tfanswer1, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(106, 106, 106)
                .addComponent(tfanswer2)
                .addContainerGap(212, Short.MAX_VALUE))
        );
        tfAnswerPanelLayout.setVerticalGroup(
            tfAnswerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, tfAnswerPanelLayout.createSequentialGroup()
                .addContainerGap(68, Short.MAX_VALUE)
                .addGroup(tfAnswerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfanswer1)
                    .addComponent(tfanswer2))
                .addGap(71, 71, 71))
        );

        jPanel1.add(tfAnswerPanel);
        tfAnswerPanel.setBounds(10, 210, 670, 160);

        background.setIcon(new javax.swing.ImageIcon(getClass().getResource("/background_image.jpg"))); // NOI18N
        jPanel1.add(background);
        background.setBounds(-30, -10, 730, 480);

        getContentPane().add(jPanel1);
        jPanel1.setBounds(-10, -10, 690, 460);

        setSize(new java.awt.Dimension(686, 480));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    // Private helper method for the home button GUI events
    private void homeButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_homeButtonActionPerformed
        MainFrame frame = new MainFrame();
            frame.setVisible(true);
            close();
    }//GEN-LAST:event_homeButtonActionPerformed

    // Private helper method for the submit button GUI events
    private void submitButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_submitButtonMouseClicked

        // Get the user's current score
        int score = user.getScore();
        
        // The question was a true/false question so set the user's answer selection accordingly
        if (tfAnswerPanel.isVisible()) {
            if (tfanswer1.isSelected())
                user.setAnswer("True");
            else if (tfanswer2.isSelected())
                user.setAnswer("False");
        }
        // The question was a multiple choice question so set the user's answer selection accordingly
        else if (mcAnswerPanel.isVisible()) {
            if (mcanswer1.isSelected())
                user.setAnswer("A");
            else if (mcanswer2.isSelected())
                user.setAnswer("B");
            else if (mcanswer3.isSelected())
                user.setAnswer("C");
            else if (mcanswer4.isSelected())
                user.setAnswer("D");
        }
        // The question was a short answer question so set the user's answer selection accordingly
        else {
            String saAnswer = saTextField.getText().toLowerCase();
            user.setAnswer(saAnswer);
        }
        
        // Compare the user's selected answer to the correct answer and change the score accordingly
        if (question.compareAnswers(user.getAnswer(), question.getCorrectAnswer()))
            score += 20;
        else
        {
            score -= 10;
            if (score < 0)
                score = 0;
        }
        
        // Update the user's score
        user.setScore(score);
        
        // Move to the next question
        try {
            nextQuestion();
        } catch (IOException ex) {
            Logger.getLogger(Quiz.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_submitButtonMouseClicked

    // Private helper method for closing the window
     private void close()
    {
        WindowEvent windowClosingEvent = new WindowEvent(this,WindowEvent.WINDOW_CLOSING);
        Toolkit.getDefaultToolkit().getSystemEventQueue().postEvent(windowClosingEvent);
        
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel background;
    private javax.swing.JLabel finishText;
    private javax.swing.JButton homeButton;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel mcAnswerPanel;
    private javax.swing.JRadioButton mcanswer1;
    private javax.swing.JRadioButton mcanswer2;
    private javax.swing.JRadioButton mcanswer3;
    private javax.swing.JRadioButton mcanswer4;
    private javax.swing.JLabel questionText;
    private javax.swing.JPanel saAnswerPanel;
    private javax.swing.JTextField saTextField;
    private javax.swing.JLabel scoreText;
    private javax.swing.JLabel submitButton;
    private javax.swing.JPanel tfAnswerPanel;
    private javax.swing.JRadioButton tfanswer1;
    private javax.swing.JRadioButton tfanswer2;
    // End of variables declaration//GEN-END:variables
}
