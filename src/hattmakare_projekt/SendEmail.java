
package hattmakare_projekt;

import oru.inf.InfDB;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.swing.JOptionPane;
/**
 *
 * @author Josef
 */
public class SendEmail extends javax.swing.JFrame {

    private InfDB idb;
    
    public SendEmail(InfDB idb) {
        initComponents();
        this.idb = idb;
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnSend = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        btnSend.setText("Skicka");
        btnSend.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSendActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(129, 129, 129)
                .addComponent(btnSend)
                .addContainerGap(199, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(249, Short.MAX_VALUE)
                .addComponent(btnSend)
                .addGap(28, 28, 28))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSendActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSendActionPerformed
       
        
        String to = "josefharknas@hotmail.com";

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

            MimeMessage message = new MimeMessage(session);

            // Från
            message.setFrom(new InternetAddress(from));
            // Till
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));

            message.setSubject("Här är ämnesraden");

            message.setText("Här skrivs meddelandet");

            System.out.println("sending...");

            Transport.send(message);
            JOptionPane.showMessageDialog(null, "Meddelandet har skickats till kunden!");
        } catch (MessagingException mex) {
            mex.printStackTrace();
        }
    }//GEN-LAST:event_btnSendActionPerformed

    
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSend;
    // End of variables declaration//GEN-END:variables
}
