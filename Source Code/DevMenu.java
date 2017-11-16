/**
 * DevMenu Class
 * 
 * This GUI class is used to display a window with the information of the
 * developers.
 * 
 * @author Augustine, Mario, Cody
 */
public class DevMenu extends javax.swing.JFrame {

    // Constructor
    public DevMenu() {
        initComponents();
    }

    // Initialize GUI components
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);
        getContentPane().setLayout(null);

        jPanel1.setLayout(null);

        jTextArea1.setEditable(false);
        jTextArea1.setBackground(new java.awt.Color(0, 0, 0));
        jTextArea1.setColumns(20);
        jTextArea1.setForeground(new java.awt.Color(255, 255, 255));
        jTextArea1.setRows(5);
        jTextArea1.setText("\n\n\n\tProgrammers - Augustine, Cody, Mario\n\tGUI Developer - Augustine\n\tImage Developers - Cody & Mario\n\tProject Manager - Cody,Augustine,Mario");
        jScrollPane1.setViewportView(jTextArea1);

        jPanel1.add(jScrollPane1);
        jScrollPane1.setBounds(40, 40, 400, 220);

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Background2.png"))); // NOI18N
        jPanel1.add(jLabel2);
        jLabel2.setBounds(-10, -16, 520, 340);

        getContentPane().add(jPanel1);
        jPanel1.setBounds(-11, -6, 500, 330);

        setSize(new java.awt.Dimension(475, 335));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea1;
    // End of variables declaration//GEN-END:variables
}
