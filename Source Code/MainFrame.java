import java.awt.Toolkit;
import java.awt.event.WindowEvent;
import java.io.FileNotFoundException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * MainFrame Class
 * 
 * This class is used to display the main frame of the program.
 * 
 * @author Augustine, Mario, Cody
 */
public class MainFrame extends javax.swing.JFrame {

    // Constructor
    public MainFrame() {
        initComponents();
    }

    // Initialize GUI components
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        takeQuizLabel = new javax.swing.JLabel();
        checkScoresLabel = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        exitQuizLabel = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        backgroungLabel = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        exitMenu = new javax.swing.JMenuItem();
        helpMenu = new javax.swing.JMenu();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        devMenu = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);
        getContentPane().setLayout(null);

        jPanel1.setLayout(null);

        takeQuizLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/quizButton.png"))); // NOI18N
        takeQuizLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                takeQuizLabelMouseClicked(evt);
            }
        });
        jPanel1.add(takeQuizLabel);
        takeQuizLabel.setBounds(40, 140, 210, 53);

        checkScoresLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/scoresButton.png"))); // NOI18N
        checkScoresLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                checkScoresLabelMouseClicked(evt);
            }
        });
        jPanel1.add(checkScoresLabel);
        checkScoresLabel.setBounds(40, 200, 210, 53);

        jLabel3.setFont(new java.awt.Font("Times New Roman", 1, 36)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText(" WELCOME TO M.A.C Pro");
        jPanel1.add(jLabel3);
        jLabel3.setBounds(150, 30, 460, 40);

        exitQuizLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/exitButton.png"))); // NOI18N
        exitQuizLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                exitQuizLabelMouseClicked(evt);
            }
        });
        jPanel1.add(exitQuizLabel);
        exitQuizLabel.setBounds(40, 260, 210, 51);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/voltron_playmaker.png"))); // NOI18N
        jPanel1.add(jLabel1);
        jLabel1.setBounds(450, 80, 340, 390);

        backgroungLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/background_image.jpg"))); // NOI18N
        jPanel1.add(backgroungLabel);
        backgroungLabel.setBounds(-10, 0, 800, 480);

        getContentPane().add(jPanel1);
        jPanel1.setBounds(0, -9, 790, 480);

        jMenu1.setText("File");

        exitMenu.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_Q, java.awt.event.InputEvent.CTRL_MASK));
        exitMenu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/close_icon.png"))); // NOI18N
        exitMenu.setText("Exit");
        exitMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitMenuActionPerformed(evt);
            }
        });
        jMenu1.add(exitMenu);

        jMenuBar1.add(jMenu1);

        helpMenu.setText("Help");
        helpMenu.add(jSeparator1);

        devMenu.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_D, java.awt.event.InputEvent.ALT_MASK | java.awt.event.InputEvent.CTRL_MASK));
        devMenu.setText("Developers");
        devMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                devMenuActionPerformed(evt);
            }
        });
        helpMenu.add(devMenu);

        jMenuBar1.add(helpMenu);

        setJMenuBar(jMenuBar1);

        setSize(new java.awt.Dimension(790, 492));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    // Private helper method for the take quiz button being clicked
    private void takeQuizLabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_takeQuizLabelMouseClicked
        close();
        Quiz quiz = null;
        try {
            quiz = new Quiz();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(UserInfoFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
        quiz.setVisible(true);
        quiz.takeQuiz();
    }//GEN-LAST:event_takeQuizLabelMouseClicked

    // Private helper method for exiting through file menu
    private void exitMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitMenuActionPerformed
        System.exit(0);
    }//GEN-LAST:event_exitMenuActionPerformed

    // Private helper method for clicking Developers in Help menu
    private void devMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_devMenuActionPerformed
        DevMenu dev = new DevMenu();
        dev.setVisible(true);
    }//GEN-LAST:event_devMenuActionPerformed

    // Private helper method for clicking Scores button
    private void checkScoresLabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_checkScoresLabelMouseClicked
        Login login = new Login();
        login.setVisible(true);
    }//GEN-LAST:event_checkScoresLabelMouseClicked

    // Private helper method for Exit button being clicked
    private void exitQuizLabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_exitQuizLabelMouseClicked
        close();
    }//GEN-LAST:event_exitQuizLabelMouseClicked

    // Private helper method for closing the window
    private void close()
    {
        WindowEvent windowClosingEvent = new WindowEvent(this,WindowEvent.WINDOW_CLOSING);
        Toolkit.getDefaultToolkit().getSystemEventQueue().postEvent(windowClosingEvent);
        
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel backgroungLabel;
    private javax.swing.JLabel checkScoresLabel;
    private javax.swing.JMenuItem devMenu;
    private javax.swing.JMenuItem exitMenu;
    private javax.swing.JLabel exitQuizLabel;
    private javax.swing.JMenu helpMenu;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JLabel takeQuizLabel;
    // End of variables declaration//GEN-END:variables

}
