
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import java.sql.DriverManager;
import java.sql.ResultSet;
import javax.swing.JOptionPane;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author adity
 */
public class login_page extends javax.swing.JFrame {
     Connection conn=null;
       PreparedStatement st=null;
       ResultSet rs=null;

    /**
     * Creates new form login_page
     */
    public login_page() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        t1 = new javax.swing.JTextField();
        b1 = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        t3 = new javax.swing.JTextField();
        t2 = new javax.swing.JPasswordField();
        jButton2 = new javax.swing.JButton();
        l1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(520, 370));
        getContentPane().setLayout(null);

        jLabel1.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 0, 0));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("WELCOME");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(152, 21, 219, 32);

        jLabel2.setFont(new java.awt.Font("Comic Sans MS", 0, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(51, 51, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Enter the login details correctly to access your account");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(10, 70, 490, 27);

        jLabel3.setFont(new java.awt.Font("Comic Sans MS", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 0, 0));
        jLabel3.setText("Username");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(70, 120, 117, 33);

        jLabel4.setFont(new java.awt.Font("Comic Sans MS", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 0, 0));
        jLabel4.setText("Password");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(70, 170, 117, 33);

        t1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                t1ActionPerformed(evt);
            }
        });
        getContentPane().add(t1);
        t1.setBounds(260, 120, 130, 33);

        b1.setBackground(new java.awt.Color(0, 204, 255));
        b1.setFont(new java.awt.Font("Comic Sans MS", 1, 18)); // NOI18N
        b1.setText("LOGIN");
        b1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        b1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b1ActionPerformed(evt);
            }
        });
        getContentPane().add(b1);
        b1.setBounds(154, 276, 97, 35);

        jLabel6.setFont(new java.awt.Font("Comic Sans MS", 1, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 0, 0));
        jLabel6.setText("Employee ID");
        getContentPane().add(jLabel6);
        jLabel6.setBounds(70, 220, 130, 30);
        getContentPane().add(t3);
        t3.setBounds(260, 220, 130, 30);
        getContentPane().add(t2);
        t2.setBounds(260, 170, 130, 30);

        jButton2.setText("Back");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2);
        jButton2.setBounds(10, 290, 60, 30);

        l1.setIcon(new javax.swing.ImageIcon("C:\\Users\\adity\\Desktop\\netbeans images\\login.jpg")); // NOI18N
        l1.setText("Login page");
        l1.setToolTipText("");
        l1.setName("Login page"); // NOI18N
        l1.setPreferredSize(new java.awt.Dimension(454, 344));
        getContentPane().add(l1);
        l1.setBounds(0, 0, 520, 350);

        pack();
    }// </editor-fold>//GEN-END:initComponents
public void test(String username , String password , String e_id)
{
    /*String username=t1.getText();
        String password=t2.getText();
        String e_id=t3.getText();
      */ 
       try{
          
           Class.forName("com.mysql.jdbc.Driver");
           conn=(Connection)DriverManager.getConnection("jdbc:mysql://localhost:3306/employee_payroll?zeroDateTimeBehavior=convertToNull","root","");
           JOptionPane.showMessageDialog(null,"Connection Established");
           st=(PreparedStatement)conn.prepareStatement("select * from employee_login where Username=? and Password=? and E_id=?");
           st.setString(1, username);
           st.setString(2, password);
           st.setString(3, e_id);
           rs=st.executeQuery();
           if(rs.next()){
               JOptionPane.showMessageDialog(null,"Login Successful");
               emp_login log=new emp_login();
               log.l1.setText(username);
               log.l3.setText(e_id);
               log.setVisible(true);
               this.setVisible(false);
               
               
           }
           else
           {
               JOptionPane.showMessageDialog(null,"Login Unsuccessful....... Please try again!");
               t1.setText(null);
               t2.setText(null);
               t3.setText(null);
               
           }
           
       }
       catch(Exception e){
            JOptionPane.showMessageDialog(null,e);
       }
}
    private void t1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_t1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_t1ActionPerformed

    private void b1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b1ActionPerformed
        // TODO add your handling code here:
        String username=t1.getText();
        String password=t2.getText();
        String e_id=t3.getText();
        test(username,password,e_id);
       /*
       try{
          
           Class.forName("com.mysql.jdbc.Driver");
           conn=(Connection)DriverManager.getConnection("jdbc:mysql://localhost:3306/employee_payroll?zeroDateTimeBehavior=convertToNull","root","");
           JOptionPane.showMessageDialog(null,"Connection Established");
           st=(PreparedStatement)conn.prepareStatement("select * from employee_login where Username=? and Password=? and E_id=?");
           st.setString(1, username);
           st.setString(2, password);
           st.setString(3, e_id);
           rs=st.executeQuery();
           if(rs.next()){
               JOptionPane.showMessageDialog(null,"Login Successful");
               emp_login log=new emp_login();
               log.l1.setText(username);
               log.l3.setText(e_id);
               log.setVisible(true);
               this.setVisible(false);
               
               
           }
           else
           {
               JOptionPane.showMessageDialog(null,"Login Unsuccessful....... Please try again!");
               t1.setText(null);
               t2.setText(null);
               t3.setText(null);
               
           }
           
       }
       catch(Exception e){
            JOptionPane.showMessageDialog(null,e);
       }*/
    }//GEN-LAST:event_b1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        login_option opt=new login_option();
        opt.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_jButton2ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(login_page.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(login_page.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(login_page.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(login_page.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new login_page().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton b1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel l1;
    private javax.swing.JTextField t1;
    private javax.swing.JPasswordField t2;
    private javax.swing.JTextField t3;
    // End of variables declaration//GEN-END:variables
}
