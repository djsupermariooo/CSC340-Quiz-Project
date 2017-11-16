import java.awt.Toolkit;
import java.awt.event.WindowEvent;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * UserInfoFrame Class
 * 
 * This class is responsible for gathering information about the user.
 * 
 * @author Augustine, Mario, Cody
 */
public class UserInfoFrame extends javax.swing.JFrame {
    // Private fields
    private String firstNameText;
    private String lastNameText;
    private int numRobLionsOwned;
    private Quiz quiz;
    private Participant user;

    // Constructor
    public UserInfoFrame(Quiz quiz, Participant user) {
        initComponents();
        this.quiz = quiz;
        this.user = user;
    }

    // Initialize GUI components
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        firstnameTextField = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        popUpMessage = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        lastnameTextField = new javax.swing.JTextField();
        submitButton = new javax.swing.JButton();
        lionsOwned = new javax.swing.JComboBox();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);
        getContentPane().setLayout(null);

        jPanel1.setLayout(null);

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("First Name");
        jPanel1.add(jLabel1);
        jLabel1.setBounds(170, 230, 150, 30);
        jPanel1.add(firstnameTextField);
        firstnameTextField.setBounds(400, 230, 190, 30);

        jLabel6.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Robotic Lions Owned");
        jPanel1.add(jLabel6);
        jLabel6.setBounds(170, 190, 240, 30);

        popUpMessage.setFont(new java.awt.Font("Tempus Sans ITC", 1, 14)); // NOI18N
        popUpMessage.setForeground(new java.awt.Color(255, 255, 255));
        jPanel1.add(popUpMessage);
        popUpMessage.setBounds(140, 404, 450, 30);

        jLabel5.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Last Name");
        jPanel1.add(jLabel5);
        jLabel5.setBounds(170, 270, 130, 40);
        jPanel1.add(lastnameTextField);
        lastnameTextField.setBounds(400, 280, 190, 30);

        submitButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/submit.png"))); // NOI18N
        submitButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                submitButtonActionPerformed(evt);
            }
        });
        jPanel1.add(submitButton);
        submitButton.setBounds(400, 340, 140, 40);

        lionsOwned.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "0", "1", "2", "3", "4", "5", "6", "7", "8", "9" }));
        jPanel1.add(lionsOwned);
        lionsOwned.setBounds(400, 190, 110, 30);

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/voltron1.png"))); // NOI18N
        jPanel1.add(jLabel4);
        jLabel4.setBounds(-10, 0, 710, 460);

        getContentPane().add(jPanel1);
        jPanel1.setBounds(-10, -10, 710, 470);

        setSize(new java.awt.Dimension(694, 478));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Used to get the first name entered by the user
     * @return a String of the user's first name that was entered
     */
    public String getFirstNameText() {
        return firstNameText;
    }
    
    /**
     * Used to get the last name entered by the user
     * @return a String of the user's last name that was entered
     */
    public String getLastNameText() {
        return lastNameText;
    }
    
    // Private helper method for submitButton GUI event
    private void submitButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_submitButtonActionPerformed
        firstNameText = firstnameTextField.getText();
        lastNameText = lastnameTextField.getText();
        numRobLionsOwned = lionsOwned.getSelectedIndex();
        popUpMessage.setText("");
        close();
        user.setFirstName(firstNameText);
        user.setLastName(lastNameText);
        user.setRobLions(numRobLionsOwned);
        try {
            quiz.nextQuestion();
        } catch (IOException ex) {
            Logger.getLogger(UserInfoFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_submitButtonActionPerformed

    // Private helper method for closing the window
    private void close()
    {
        WindowEvent windowClosingEvent = new WindowEvent(this,WindowEvent.WINDOW_CLOSING);
        Toolkit.getDefaultToolkit().getSystemEventQueue().postEvent(windowClosingEvent);
        
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField firstnameTextField;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField lastnameTextField;
    private javax.swing.JComboBox lionsOwned;
    private javax.swing.JLabel popUpMessage;
    private javax.swing.JButton submitButton;
    // End of variables declaration//GEN-END:variables
}
