
package hattmakare_projekt;

import java.util.ArrayList;
import java.util.HashMap;
import javax.swing.JOptionPane;
import oru.inf.InfDB;
import oru.inf.InfException;

/**
 *
 * @author Josef
 */
public class showCustomerInfo extends javax.swing.JFrame {

    private InfDB idb;
    public showCustomerInfo(InfDB idb) {
        initComponents();
        this.idb = idb;
        fillCustomerBox();
    }

    
    private void fillCustomerBox() {
        
         
        String query = "SELECT name FROM Customer";
        
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
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        cbCustomer = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtAreaInfo = new javax.swing.JTextArea();
        jLabel1 = new javax.swing.JLabel();
        btnBack = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        cbCustomer.setFont(new java.awt.Font("PMingLiU-ExtB", 1, 14)); // NOI18N
        cbCustomer.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Välj kund..." }));
        cbCustomer.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbCustomerItemStateChanged(evt);
            }
        });
        cbCustomer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbCustomerActionPerformed(evt);
            }
        });

        txtAreaInfo.setEditable(false);
        txtAreaInfo.setColumns(20);
        txtAreaInfo.setRows(5);
        jScrollPane1.setViewportView(txtAreaInfo);

        jLabel1.setFont(new java.awt.Font("PMingLiU-ExtB", 1, 22)); // NOI18N
        jLabel1.setText("Informationssida om kunder");

        btnBack.setFont(new java.awt.Font("PMingLiU-ExtB", 1, 12)); // NOI18N
        btnBack.setText("Tillbaka");
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 505, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbCustomer, javax.swing.GroupLayout.PREFERRED_SIZE, 291, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 477, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(127, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnBack)
                .addGap(29, 29, 29))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 39, Short.MAX_VALUE)
                .addComponent(cbCustomer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(53, 53, 53)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnBack)
                .addGap(7, 7, 7))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cbCustomerItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbCustomerItemStateChanged
        
    }//GEN-LAST:event_cbCustomerItemStateChanged

    private void cbCustomerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbCustomerActionPerformed
        String name = cbCustomer.getSelectedItem().toString();
        
        
        String query = "(SELECT Customer.CustomerID, Customer.name, email.Email_address, address.Street, address.House_number FROM Customer "
                + "JOIN email ON Customer.CustomerID = email.Customer "
                + "JOIN address ON Customer.CustomerID = address.Customer "
                + "WHERE Customer.name = '" + name + "')";
                
        
        ArrayList<HashMap<String, String>> rows = new ArrayList<>();
        
        try {
            
                txtAreaInfo.setText("");
                rows = idb.fetchRows(query);
                

                int i;
                for (i = 0; i < rows.size(); i++) {
                    if ((rows.get(i).get("CustomerID") != null)) {
                        txtAreaInfo.append("Kund ID: " + (rows.get(i).get("CustomerID"))+ "\n");
                        txtAreaInfo.append("Namn: " + (rows.get(i).get("name"))+ "\n");
                        txtAreaInfo.append("Email: " + (rows.get(i).get("Email_address"))+ "\n");
                        txtAreaInfo.append("Gata: " + (rows.get(i).get("Street"))+ "\n");
                        txtAreaInfo.append("Husnummer: " + (rows.get(i).get("House_number"))+ "\n");
                        txtAreaInfo.append("------------------------"+ "\n");
                    }

                }

            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Systemfel!");
                System.out.println(e);

            }
    }//GEN-LAST:event_cbCustomerActionPerformed

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        dispose();
    }//GEN-LAST:event_btnBackActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBack;
    private javax.swing.JComboBox<String> cbCustomer;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea txtAreaInfo;
    // End of variables declaration//GEN-END:variables
}
