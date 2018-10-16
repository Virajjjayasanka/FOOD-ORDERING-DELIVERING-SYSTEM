/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.DiliverySystem.View.Manager;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.server.UnicastRemoteObject;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.Timer;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import lk.ijse.DiliverSystem.dto.DiliveryRiderDTO;
import lk.ijse.DiliverSystem.observer.Observer;
import lk.ijse.DilverSystem.controller.ManageRiderController;


/**
 *
 * @author Viraj jayasanka
 */
public class RiderManage extends javax.swing.JFrame implements Observer {
    private boolean update = false;
    private String reserId = "";
    /**
     * Creates new form NewJPanel
     */
    public RiderManage(java.awt.Frame parent, boolean modal) {
        initComponents();
        loadAllCustomers();
        jPanel1.setBackground(new Color(228,239,186,110));
        setSize(941, 561);
        setLocationRelativeTo(null);
        setTime();
        setDate();
        
        try {
            UnicastRemoteObject.exportObject(this, 0);
            ManageRiderController.getSubject().registerObserver(this);
        } catch (Exception ex) {
            
    
            
            Logger.getLogger(RiderManage.class.getName()).log(Level.SEVERE, null, ex);
        }
            tblRider.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {

                if (tblRider.getSelectedRow() == -1) {
                    btnDelete.setEnabled(false);
                    update = false;
                    return;
                }

                try {

                    if (reserId == "") {
                        ManageRiderController.releaseDiliverRider(reserId);
                    }
                    reserId = tblRider.getValueAt(tblRider.getSelectedRow(), 0).toString();
                    boolean reserveCustomer = ManageRiderController.reserveDiliverRider(reserId);

                    if (reserveCustomer) {
                        update = true;
                        int row = tblRider.getSelectedRow();

                        //txtRiderId.setText(tblRider.getValueAt(row, 0).toString());
                        txtRiderName.setText(tblRider.getValueAt(row, 1).toString());
                        txtAddress.setText(tblRider.getValueAt(row, 2).toString());
                        txtTelePoneNO.setText(tblRider.getValueAt(row, 3).toString());
                        txtNIC.setText(tblRider.getValueAt(row, 4).toString());
                        txtSalary.setText(tblRider.getValueAt(row, 5).toString());
                        txtDate.setText(tblRider.getValueAt(row, 6).toString());
                        txtTime.setText(tblRider.getValueAt(row, 7).toString());
                        
                    } else {
                        update = false;
                        JOptionPane.showMessageDialog(RiderManage.this, "Customer has been already reserved");
                        tblRider.clearSelection();
                    }

                } catch (Exception ex) {
                    Logger.getLogger(RiderManage.class.getName()).log(Level.SEVERE, null, ex);
                }

            }
        });


}
   void setTime(){
        new Timer(0, new ActionListener() {

           
            public void actionPerformed(ActionEvent e) {
                Date dt = new Date();
                SimpleDateFormat sdf = new SimpleDateFormat("hh : mm : ss a");
                txtDate.setText(sdf.format(dt));
            }

        } ).start();
    }
     private void setDate(){
        Date d = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat(" yyyy - MM - dd ");
        txtTime.setText(sdf.format(d));  
    }
     
     
      private void loadAllCustomers(){

        DefaultTableModel dtm = (DefaultTableModel) tblRider.getModel();
        dtm.setRowCount(0);

        try {
            List<DiliveryRiderDTO> riderDTOs = ManageRiderController.getAllDiliverRiders();

            if (riderDTOs == null) {
                return;
            }

            for (DiliveryRiderDTO diliveryRiderDTO : riderDTOs) {
                Object[] rowData = {
                    diliveryRiderDTO.getId(),
                    diliveryRiderDTO.getRiderNAme(),
                    diliveryRiderDTO.getRiderAddress(),
                    diliveryRiderDTO.getRiderTelePoneNO(),
                    diliveryRiderDTO.getNIC(),
                    diliveryRiderDTO.getSalary(),
                    diliveryRiderDTO.getDate(),
                    diliveryRiderDTO.getTime()
                };
                dtm.addRow(rowData);
            }

        } catch (Exception ex) {
            Logger.getLogger(RiderManage.class.getName()).log(Level.SEVERE, null, ex);
        }
      }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
      
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtTelePoneNO = new javax.swing.JTextField();
        txtNIC = new javax.swing.JTextField();
        txtSalary = new javax.swing.JTextField();
        txtAddress = new javax.swing.JTextField();
        txtRiderName = new javax.swing.JTextField();
        jTextField7 = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblRider = new javax.swing.JTable();
        jLabel7 = new javax.swing.JLabel();
        btnDelete = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        txtDate = new javax.swing.JTextField();
        txtTime = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jButton6 = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();

        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));
        jPanel1.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                jPanel1AncestorAdded(evt);
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("sansserif", 1, 12)); // NOI18N
        jLabel2.setText("Rider Address");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 140, -1, -1));

        jLabel3.setFont(new java.awt.Font("sansserif", 1, 12)); // NOI18N
        jLabel3.setText("Rider Name");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 100, -1, -1));

        jLabel4.setFont(new java.awt.Font("sansserif", 1, 12)); // NOI18N
        jLabel4.setText("Rider Telepone NO");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 90, -1, -1));

        jLabel5.setFont(new java.awt.Font("sansserif", 1, 12)); // NOI18N
        jLabel5.setText("Rider NIC NO");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 130, -1, -1));

        jLabel6.setFont(new java.awt.Font("sansserif", 1, 12)); // NOI18N
        jLabel6.setText("Rider Salary");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 180, -1, -1));

        txtTelePoneNO.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel1.add(txtTelePoneNO, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 80, 220, 30));

        txtNIC.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel1.add(txtNIC, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 130, 220, 30));

        txtSalary.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel1.add(txtSalary, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 180, 220, 30));

        txtAddress.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel1.add(txtAddress, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 140, 220, 30));

        txtRiderName.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel1.add(txtRiderName, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 100, 220, 30));

        jTextField7.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jTextField7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField7ActionPerformed(evt);
            }
        });
        jPanel1.add(jTextField7, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 230, 150, 30));

        tblRider.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                " ID", "Name", "Address", "TelePone NO", "NIC", "Salary", "Time", "Date"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblRider.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                tblRiderAncestorAdded(evt);
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });
        jScrollPane1.setViewportView(tblRider);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 270, 890, 260));

        jLabel7.setFont(new java.awt.Font("sansserif", 1, 12)); // NOI18N
        jLabel7.setText("Search");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 230, -1, 20));

        btnDelete.setBackground(new java.awt.Color(255, 0, 0));
        btnDelete.setFont(new java.awt.Font("sansserif", 1, 12)); // NOI18N
        btnDelete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/lk/ijse/DiliverSystem/image/delete customer ican1.png"))); // NOI18N
        jPanel1.add(btnDelete, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 140, 80, 50));

        jButton2.setFont(new java.awt.Font("sansserif", 1, 12)); // NOI18N
        jButton2.setText("Update");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 80, 80, 50));

        jButton4.setFont(new java.awt.Font("sansserif", 1, 12)); // NOI18N
        jButton4.setText("ADD");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 20, 80, 50));

        jLabel8.setFont(new java.awt.Font("sansserif", 1, 12)); // NOI18N
        jLabel8.setText("Time");
        jLabel8.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 20, -1, -1));

        jLabel9.setFont(new java.awt.Font("sansserif", 1, 12)); // NOI18N
        jLabel9.setText("Date");
        jLabel9.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 20, -1, -1));

        txtDate.setFont(new java.awt.Font("sansserif", 3, 12)); // NOI18N
        txtDate.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtDate.setText("Time");
        txtDate.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        txtDate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDateActionPerformed(evt);
            }
        });
        jPanel1.add(txtDate, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 20, 110, 30));

        txtTime.setFont(new java.awt.Font("sansserif", 3, 12)); // NOI18N
        txtTime.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtTime.setText("Date");
        txtTime.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        txtTime.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTimeActionPerformed(evt);
            }
        });
        jPanel1.add(txtTime, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 20, 110, 30));

        jLabel11.setFont(new java.awt.Font("sansserif", 3, 24)); // NOI18N
        jLabel11.setText("Add Delivery Reiders");
        jPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 20, 290, -1));

        jButton6.setText("Remo All");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton6, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 210, 80, 50));

        jLabel10.setFont(new java.awt.Font("sansserif", 1, 12)); // NOI18N
        jLabel10.setText("Rider Password");
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 230, -1, -1));

        jTextField1.setFont(new java.awt.Font("sansserif", 1, 12)); // NOI18N
        jTextField1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel1.add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 230, 220, 30));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 940, 560));

        jLabel12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/lk/ijse/DiliverSystem/image/1 (70).jpg"))); // NOI18N
        getContentPane().add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 940, 560));
    }// </editor-fold>//GEN-END:initComponents

    private void jTextField7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField7ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField7ActionPerformed

    private void tblRiderAncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_tblRiderAncestorAdded
        tblRider.setEnabled(false);
    }//GEN-LAST:event_tblRiderAncestorAdded

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        DiliveryRiderDTO diliveryRiderDTO = new DiliveryRiderDTO(
           
            txtRiderName.getText(),
            txtAddress.getText(),
            Integer.parseInt(txtTelePoneNO.getText()),
            txtNIC.getText(),
            Double.parseDouble(txtSalary.getText()),
            txtDate.getText(),
            txtTime.getText()
        );
        
        
        try {

            boolean result = false;
                        if (!update) {
                                result = ManageRiderController.addDiliveryRider(diliveryRiderDTO);
                            } else {
                                result = ManageRiderController.updateDiliverRider(diliveryRiderDTO);
                            }

            if (result) {
                JOptionPane.showMessageDialog(this, "Customer has been saved successfully");
            } else {
                JOptionPane.showMessageDialog(this, "Failed to save the customer");
            }

             ManageRiderController.releaseDiliverRider(reserId);
             reserId = "";
            // clearAllTextFields();
             tblRider.clearSelection();
//            txtRiderId.requestFocusInWindow();
            update = false;
        } catch (Exception ex) {
            Logger.getLogger(RiderManage.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton4ActionPerformed

    private void txtDateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDateActionPerformed

    }//GEN-LAST:event_txtDateActionPerformed

    private void txtTimeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTimeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTimeActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jPanel1AncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_jPanel1AncestorAdded
        txtDate.setEnabled(false);
        txtTime.setEnabled(false);
    }//GEN-LAST:event_jPanel1AncestorAdded

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton2ActionPerformed

    
     private void clearAllTextFields() {
        
//        txtRiderId.setText("");
        txtRiderName.setText("");
        txtAddress.setText("");
        txtTelePoneNO.setText("");
        txtNIC.setText("");
        txtSalary.setText("");
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton6;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField7;
    private javax.swing.JTable tblRider;
    private javax.swing.JTextField txtAddress;
    private javax.swing.JTextField txtDate;
    private javax.swing.JTextField txtNIC;
    private javax.swing.JTextField txtRiderName;
    private javax.swing.JTextField txtSalary;
    private javax.swing.JTextField txtTelePoneNO;
    private javax.swing.JTextField txtTime;
    // End of variables declaration//GEN-END:variables

    @Override
    public void updateObservers() throws Exception {
       loadAllCustomers();  
    }
    
    
}
