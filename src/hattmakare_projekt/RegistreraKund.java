
package hattmakare_projekt;

import javax.swing.JOptionPane;
import javax.swing.JTextField;
import oru.inf.InfDB;

/**
 *
 * @author Josef
 */
public class RegistreraKund extends javax.swing.JFrame {

    private InfDB idb;
    
    public RegistreraKund(InfDB idb) {
        initComponents();
        this.idb = idb;
        lblSuccess.setVisible(false);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtFieldName = new javax.swing.JTextField();
        txtFieldStreet = new javax.swing.JTextField();
        txtFieldHouseNumber = new javax.swing.JTextField();
        txtFieldEmail = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        btnReg = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        lblSuccess = new javax.swing.JLabel();
        lblError = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Namn:");

        jLabel2.setText("Adress:");

        jLabel3.setText("Husnummer:");

        jLabel4.setText("E-post:");

        btnReg.setText("Registrera");
        btnReg.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegActionPerformed(evt);
            }
        });

        jLabel5.setText("Registrera ny kund");

        lblSuccess.setText("Registreringen lyckades!");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtFieldName, javax.swing.GroupLayout.PREFERRED_SIZE, 221, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtFieldStreet, javax.swing.GroupLayout.PREFERRED_SIZE, 221, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(5, 5, 5)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtFieldEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 221, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtFieldHouseNumber, javax.swing.GroupLayout.PREFERRED_SIZE, 221, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnReg, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(118, 118, 118))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 48, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblSuccess, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblError, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(84, 84, 84))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jLabel5)
                .addGap(47, 47, 47)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtFieldName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(42, 42, 42)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtFieldStreet, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(20, 20, 20)
                .addComponent(lblSuccess, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtFieldHouseNumber, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3))
                        .addGap(48, 48, 48)
                        .addComponent(jLabel4))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblError)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtFieldEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 54, Short.MAX_VALUE)
                .addComponent(btnReg)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    
    public boolean checkEmpty(JTextField aTxtField) {
        boolean isEmpty = false;
        if(aTxtField.getText().isEmpty()) {
            isEmpty = true;
        }
        return isEmpty;
    }
    
    private void btnRegActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegActionPerformed
        
        
        if(checkEmpty(txtFieldName)) {
            lblError.setText("Inga tomma rutor!");
            return;
        }
        if(checkEmpty(txtFieldStreet)) {
            lblError.setText("Inga tomma rutor!");
            return;
        }
        if(checkEmpty(txtFieldHouseNumber)) {
            lblError.setText("Inga tomma rutor!");
            return;
        }
        if(checkEmpty(txtFieldEmail)) {
            lblError.setText("Inga tomma rutor!");
            return;
        }
        
        
        String Name = txtFieldName.getText();
        String Street = txtFieldStreet.getText();
        String HouseNumber = txtFieldHouseNumber.getText();
        String Email = txtFieldEmail.getText();
        
        if (!Name.matches("[a-zA-Z_]+")) {
             JOptionPane.showMessageDialog(null, "Inga specialtecken i namn");
             return;
        }
        if (!Street.matches("[a-zA-Z_]+")) {
             JOptionPane.showMessageDialog(null, "Inga specialtecken i adress");
             return;
        }
        if(!Email.matches("^[A-Za-z0-9+_.-]+@(.+)$"))  {
                JOptionPane.showMessageDialog(null, "Ange en korrekt email-adress");
             return;
            }
        if (!HouseNumber.matches("^[1-9][0-9]?$|^100$")) {
            JOptionPane.showMessageDialog(null, "Ange siffror i husnummer");
             return;
        }

        try {
        
        String queryMaxId = "(SELECT MAX(CustomerID) FROM customer)";
        
        String query = "INSERT INTO customer (Name) VALUES ('" + Name + "')";
        
        String query2 = "INSERT INTO address (Street, House_Number, Customer) VALUES ('" + Street + "', '" + HouseNumber + "', " + queryMaxId + ")";
        
        String query3 = "INSERT INTO email (Email_address, Customer) VALUES ('" + Email + "', " + queryMaxId + ")";
        
        idb.insert(query);
        idb.insert(query2);
        idb.insert(query3);
        
        lblSuccess.setVisible(true);
        lblError.setText("");
        }
        
       
        
        
        catch(Exception e) {
            JOptionPane.showMessageDialog(null, "System error");
            System.out.println("Fel" + e.getMessage());
        }



        
        
    }//GEN-LAST:event_btnRegActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnReg;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel lblError;
    private javax.swing.JLabel lblSuccess;
    private javax.swing.JTextField txtFieldEmail;
    private javax.swing.JTextField txtFieldHouseNumber;
    private javax.swing.JTextField txtFieldName;
    private javax.swing.JTextField txtFieldStreet;
    // End of variables declaration//GEN-END:variables
}
