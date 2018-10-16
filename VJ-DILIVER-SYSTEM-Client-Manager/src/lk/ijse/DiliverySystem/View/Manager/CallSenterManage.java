/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.DiliverySystem.View.Manager;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.Remote;
import java.rmi.server.UnicastRemoteObject;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Observable;
import java.util.Observer;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.Timer;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import lk.ijse.DiliverSystem.dto.CallSenterDTO;
import lk.ijse.DilverSystem.controller.MangeCallSenterController;




/**
 *
 * @author Viraj jayasanka
 */
public class CallSenterManage extends javax.swing.JFrame implements lk.ijse.DiliverSystem.observer.Observer {
    private boolean update = false;
    private String reserId = "";
    /**
     * Creates new form NewJPanel
     */
    public CallSenterManage(java.awt.Frame parent, boolean modal) {
        initComponents();
        loadAllCustomers();
        jPanel2.setBackground(new Color(228,239,186,110));
        setSize(1124, 511);
        setLocationRelativeTo(null);
        setTime();
        setDate();
        
           try {
            UnicastRemoteObject.exportObject((Remote) this, 0);
            MangeCallSenterController.getSubject().registerObserver((lk.ijse.DiliverSystem.observer.Observer) this);
        } catch (Exception ex) {
            
    
            
            Logger.getLogger(RiderManage.class.getName()).log(Level.SEVERE, null, ex);
        }
            tblCallSenter.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            
            @Override
            public void valueChanged(ListSelectionEvent e) {

                if (tblCallSenter.getSelectedRow() == -1) {
                    btnDelete.setEnabled(false);
                    update = false;
                    return;
                }

                try {

                    if (reserId == "") {
                      //  MangeCallSenterController.releaseDiliverRider(reserId);
                    }
                    ///reserId = tblCallSenter.getValueAt(tblCallSenter.getSelectedRow(), 0).toString();
                    boolean reserveCustomer = MangeCallSenterController.reserveDiliverRider(reserId);

                    if (reserveCustomer) {
                        update = true;
                        int row = tblCallSenter.getSelectedRow();
                       // int columns =tblCallSenter.getRowCount();

                        txtCallID.setText(tblCallSenter.getValueAt(row, 0).toString());
                        txtName.setText(tblCallSenter.getValueAt(row, 1).toString());
                        txtAddress.setText(tblCallSenter.getValueAt(row, 2).toString());
                        txtTeleponeNo.setText(tblCallSenter.getValueAt(row, 3).toString());
                        txtAge.setText(tblCallSenter.getValueAt(row, 4).toString());
                        txtNIC.setText(tblCallSenter.getValueAt(row, 5).toString());
                        txtSalary.setText(tblCallSenter.getValueAt(row, 6).toString());
                        TimeLabel.setText(tblCallSenter.getValueAt(row, 7).toString());
                        DateLabel.setText(tblCallSenter.getValueAt(row, 8).toString());
                    } else {
                        update = false;
                        JOptionPane.showMessageDialog(CallSenterManage.this, "Added has been already reserved");
                        tblCallSenter.clearSelection();
                    }

                } catch (Exception ex) {
                    Logger.getLogger(RiderManage.class.getName()).log(Level.SEVERE, null, ex);
                }

            }

           
        });

        
        
        
    }
private void loadAllCustomers(){

        DefaultTableModel dtm = (DefaultTableModel) tblCallSenter.getModel();
        dtm.setRowCount(0);

        try {
            List<CallSenterDTO> SenterDTOs = MangeCallSenterController.getAllDiliverRiders();

            if (SenterDTOs == null) {
                return;
            }

            for (CallSenterDTO callSenterDTO : SenterDTOs) {
                Object[] rowData = {
                    callSenterDTO.getCallSenterID(),
                    callSenterDTO.getName(),
                    callSenterDTO.getAddress(),
                    callSenterDTO.getTeloponeNo(),
                    callSenterDTO.getAge(),
                    callSenterDTO.getNIC(),
                    callSenterDTO.getSalary(),
                    callSenterDTO.getDate(),
                    callSenterDTO.getTime()
                };
                dtm.addRow(rowData);
            }

        } catch (Exception ex) {
            Logger.getLogger(RiderManage.class.getName()).log(Level.SEVERE, null, ex);
        }
}

    
    void setTime(){
        new Timer(0, new ActionListener() {

           
            public void actionPerformed(ActionEvent e) {
                Date dt = new Date();
                SimpleDateFormat sdf = new SimpleDateFormat("hh : mm : ss a");
                TimeLabel.setText(sdf.format(dt));
            }

        } ).start();
    }
     private void setDate(){
        Date d = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat(" yyyy - MM - dd ");
        DateLabel.setText(sdf.format(d));
        
        
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        txtTeleponeNo = new javax.swing.JTextField();
        txtSalary = new javax.swing.JTextField();
        txtAddress = new javax.swing.JTextField();
        txtName = new javax.swing.JTextField();
        jTextField11 = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblCallSenter = new javax.swing.JTable();
        jLabel16 = new javax.swing.JLabel();
        btnDelete = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jLabel17 = new javax.swing.JLabel();
        txtCallID = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        TimeLabel = new javax.swing.JTextField();
        DateLabel = new javax.swing.JTextField();
        jLabel19 = new javax.swing.JLabel();
        jButton6 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        txtNIC = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtAge = new javax.swing.JTextField();

        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel2.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                jPanel2AncestorAdded(evt);
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel10.setFont(new java.awt.Font("sansserif", 1, 12)); // NOI18N
        jLabel10.setText("ID");
        jPanel2.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 110, 20, -1));

        jLabel11.setFont(new java.awt.Font("sansserif", 1, 12)); // NOI18N
        jLabel11.setText("Address");
        jPanel2.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 200, -1, -1));

        jLabel12.setFont(new java.awt.Font("sansserif", 1, 12)); // NOI18N
        jLabel12.setText("Name");
        jPanel2.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 150, -1, -1));

        jLabel13.setFont(new java.awt.Font("sansserif", 1, 12)); // NOI18N
        jLabel13.setText("Telepone NO");
        jPanel2.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 240, -1, -1));

        jLabel15.setFont(new java.awt.Font("sansserif", 1, 12)); // NOI18N
        jLabel15.setText("Salary");
        jPanel2.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 360, -1, -1));

        txtTeleponeNo.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        txtTeleponeNo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTeleponeNoActionPerformed(evt);
            }
        });
        jPanel2.add(txtTeleponeNo, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 230, 220, 30));

        txtSalary.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        txtSalary.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSalaryActionPerformed(evt);
            }
        });
        jPanel2.add(txtSalary, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 350, 220, 30));

        txtAddress.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel2.add(txtAddress, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 190, 220, 30));

        txtName.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        txtName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNameActionPerformed(evt);
            }
        });
        jPanel2.add(txtName, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 150, 220, 30));

        jTextField11.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jTextField11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField11ActionPerformed(evt);
            }
        });
        jPanel2.add(jTextField11, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 100, 210, 30));

        tblCallSenter.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Name", "Address", "TelePone NO", "Age", "NIC", "Salary", "Date", "Time"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tblCallSenter);

        jPanel2.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 150, 670, 330));

        jLabel16.setFont(new java.awt.Font("sansserif", 1, 12)); // NOI18N
        jLabel16.setText("Search");
        jPanel2.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 110, -1, -1));

        btnDelete.setBackground(new java.awt.Color(255, 0, 0));
        btnDelete.setFont(new java.awt.Font("sansserif", 1, 12)); // NOI18N
        btnDelete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/lk/ijse/DiliverSystem/image/delete customer ican1.png"))); // NOI18N
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });
        jPanel2.add(btnDelete, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 410, 90, 50));

        jButton2.setFont(new java.awt.Font("sansserif", 1, 12)); // NOI18N
        jButton2.setText("Update");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 410, 80, 50));

        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/lk/ijse/DiliverSystem/image/CLOSE.png"))); // NOI18N
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 10, 60, 50));

        jButton4.setFont(new java.awt.Font("sansserif", 1, 12)); // NOI18N
        jButton4.setText("ADD");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 410, 80, 50));

        jLabel17.setFont(new java.awt.Font("sansserif", 1, 12)); // NOI18N
        jLabel17.setText("Time");
        jLabel17.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        jPanel2.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 20, -1, -1));

        txtCallID.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        txtCallID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCallIDActionPerformed(evt);
            }
        });
        jPanel2.add(txtCallID, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 110, 220, 30));

        jLabel18.setFont(new java.awt.Font("sansserif", 1, 12)); // NOI18N
        jLabel18.setText("Date");
        jLabel18.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        jPanel2.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 20, -1, -1));

        TimeLabel.setFont(new java.awt.Font("sansserif", 3, 12)); // NOI18N
        TimeLabel.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        TimeLabel.setText("Time");
        TimeLabel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        TimeLabel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TimeLabelActionPerformed(evt);
            }
        });
        jPanel2.add(TimeLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 20, 110, 30));

        DateLabel.setFont(new java.awt.Font("sansserif", 3, 12)); // NOI18N
        DateLabel.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        DateLabel.setText("Date");
        DateLabel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        DateLabel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DateLabelActionPerformed(evt);
            }
        });
        jPanel2.add(DateLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 20, 110, 30));

        jLabel19.setFont(new java.awt.Font("sansserif", 3, 24)); // NOI18N
        jLabel19.setText("Add Call Center Workes");
        jPanel2.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 20, 290, -1));

        jButton6.setText("Remo All");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton6, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 410, 90, 50));

        jLabel4.setFont(new java.awt.Font("sansserif", 1, 12)); // NOI18N
        jLabel4.setText("NIC");
        jPanel2.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 320, -1, -1));

        txtNIC.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        txtNIC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNICActionPerformed(evt);
            }
        });
        jPanel2.add(txtNIC, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 310, 220, 30));

        jLabel6.setFont(new java.awt.Font("sansserif", 1, 12)); // NOI18N
        jLabel6.setText("Age");
        jPanel2.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 280, -1, -1));

        txtAge.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        txtAge.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtAgeActionPerformed(evt);
            }
        });
        jPanel2.add(txtAge, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 270, 220, 30));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1120, 510));
    }// </editor-fold>//GEN-END:initComponents

    private void txtTeleponeNoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTeleponeNoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTeleponeNoActionPerformed

    private void txtSalaryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSalaryActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSalaryActionPerformed

    private void txtNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNameActionPerformed

    private void jTextField11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField11ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField11ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        //this.dispose();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void TimeLabelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TimeLabelActionPerformed

    }//GEN-LAST:event_TimeLabelActionPerformed

    private void DateLabelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DateLabelActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_DateLabelActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton6ActionPerformed

    private void txtNICActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNICActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNICActionPerformed

    private void txtAgeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtAgeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtAgeActionPerformed

    private void jPanel2AncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_jPanel2AncestorAdded
        TimeLabel.setEnabled(false);
        DateLabel.setEnabled(false);
    }//GEN-LAST:event_jPanel2AncestorAdded

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        CallSenterDTO callSenterDTO = new CallSenterDTO(
            txtCallID.getText(),
            txtName.getText(),
            txtAddress.getText(),
            Integer.parseInt(txtTeleponeNo.getText()),
            Integer.parseInt(txtAge.getText()),
            txtNIC.getText(),
            Double.parseDouble(txtSalary.getText()),
            TimeLabel.getText(),
            DateLabel.getText()
        );
        try {

            boolean result = false;
                        if (!update) {
                                result = MangeCallSenterController.addCallSener(callSenterDTO);
                            } else {
                                result = MangeCallSenterController.updateCallSener(callSenterDTO);
                            }

            if (result) {
                JOptionPane.showMessageDialog(this, "Customer has been saved successfully");
            } else {
                JOptionPane.showMessageDialog(this, "Failed to save the customer");
            }

           //  MangeCallSenterController.releaseDiliverRider(reserId);
            // reserId = "";
            // clearAllTextFields();
             tblCallSenter.clearSelection();
            txtCallID.requestFocusInWindow();
            update = false;
        } catch (Exception ex) {
            Logger.getLogger(RiderManage.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton4ActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
       try {
            boolean result = MangeCallSenterController.deleteCallSener(txtCallID.getText());

            if (result) {
                JOptionPane.showMessageDialog(this, "Customer has been deleted successfully");
            } else {
                JOptionPane.showMessageDialog(this, "Customer has been deleted successfully");
            }

            MangeCallSenterController.releaseDiliverRider(reserId);
            reserId = "";
          //  clearAllTextFields();
            tblCallSenter.clearSelection();
            tblCallSenter.requestFocusInWindow();
            update = false;
        } catch (Exception ex) {
            Logger.getLogger(CallSenterManage.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void txtCallIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCallIDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCallIDActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
       CallSenterDTO callSenterDTO = new CallSenterDTO(
               txtCallID.getText(),
            
            txtName.getText(),
            txtAddress.getText(),
            Integer.parseInt(txtTeleponeNo.getText()),
            Integer.parseInt(txtAge.getText()),
            txtNIC.getText(),
            Double.parseDouble(txtSalary.getText()),
            TimeLabel.getText(),
            DateLabel.getText()
        );
       
      
    }//GEN-LAST:event_jButton2ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField DateLabel;
    private javax.swing.JTextField TimeLabel;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton6;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextField11;
    private javax.swing.JTable tblCallSenter;
    private javax.swing.JTextField txtAddress;
    private javax.swing.JTextField txtAge;
    private javax.swing.JTextField txtCallID;
    private javax.swing.JTextField txtNIC;
    private javax.swing.JTextField txtName;
    private javax.swing.JTextField txtSalary;
    private javax.swing.JTextField txtTeleponeNo;
    // End of variables declaration//GEN-END:variables

   
   

    @Override
    public void updateObservers() throws Exception {
         loadAllCustomers(); 
    }

}
