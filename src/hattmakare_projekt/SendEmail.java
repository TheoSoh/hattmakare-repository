
package hattmakare_projekt;

import java.util.ArrayList;
import oru.inf.InfDB;

import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.swing.JOptionPane;
import oru.inf.InfException;
/**
 *
 * @author Josef
 */
public class SendEmail extends javax.swing.JFrame {

    private InfDB idb;
    
    public SendEmail(InfDB idb) {
        initComponents();
        this.idb = idb;
        fillCustomerBox();
    }
    
    private void fillCustomerBox() {
        
         
        String query = "SELECT Name FROM Customer";
        
        ArrayList <String> allaKundNamn;
        
        try {
            allaKundNamn = idb.fetchColumn(query);
            
            for(String name:allaKundNamn) {
                cbCustomer.addItem(name);   
            }
            
        }catch(InfException e) {
            JOptionPane.showMessageDialog(null, "fel");
        }
    }
    
    public void sendEmail() {
        
        double pricePerHat = 104352;
        String customerName = cbCustomer.getSelectedItem().toString();
        
        
        String query = "SELECT Email_address FROM Email WHERE Email.Customer "
                + "IN (SELECT CustomerID FROM Customer WHERE Name = '" + customerName + "')";
                              

        String from = "josef.harknas@gmail.com";

        String host = "smtp.gmail.com";

        Properties properties = System.getProperties();

        properties.put("mail.smtp.host", host);
        properties.put("mail.smtp.port", "465");
        properties.put("mail.smtp.ssl.enable", "true");
        properties.put("mail.smtp.auth", "true");

        // Skickar in användarnamn/mailadress och lösenord
        Session session = Session.getInstance(properties, new javax.mail.Authenticator() {

            protected PasswordAuthentication getPasswordAuthentication() {

                return new PasswordAuthentication("josef.harknas@gmail.com", "xoczocgvotxuwloq");

            }

        });

        session.setDebug(true);

        try {

            String to = idb.fetchSingle(query);
            
            MimeMessage message = new MimeMessage(session);

            // Från
            message.setFrom(new InternetAddress(from));
            // Till
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));

            message.setSubject("Orderbekräftelse");

            message.setText("Hej, " + "\n" + "Tack för din förfrågan om att beställa en hatt från Otto och Judiths hattar. Hatten du önskar kommer att kosta " 
                    + pricePerHat + " kr. För att beställa den vänligen svara på detta meddelande." + "\n" + "\n" + "Mvh Otto och Judith");

            Transport.send(message);
            JOptionPane.showMessageDialog(null, "Meddelandet har skickats till kunden!");
        } catch (MessagingException mex) {
            mex.printStackTrace();
        } catch (InfException ex) {
            Logger.getLogger(SendEmail.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnSend = new javax.swing.JButton();
        cbCustomer = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        btnSend.setText("Skicka");
        btnSend.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSendActionPerformed(evt);
            }
        });

        cbCustomer.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Välj kund..." }));
        cbCustomer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbCustomerActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnSend)
                .addGap(133, 133, 133))
            .addGroup(layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addComponent(cbCustomer, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(350, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(107, 107, 107)
                .addComponent(cbCustomer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 238, Short.MAX_VALUE)
                .addComponent(btnSend)
                .addGap(24, 24, 24))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSendActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSendActionPerformed
       
        sendEmail();
    }//GEN-LAST:event_btnSendActionPerformed

    private void cbCustomerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbCustomerActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbCustomerActionPerformed

    
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSend;
    private javax.swing.JComboBox<String> cbCustomer;
    // End of variables declaration//GEN-END:variables
}
