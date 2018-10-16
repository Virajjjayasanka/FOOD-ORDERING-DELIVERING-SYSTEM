/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.DiliverSystem.view.Rider;

import java.rmi.server.UnicastRemoteObject;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.Observable;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import lk.ijse.DiliverSystem.controller.ManageLastOrderSaveController;
import lk.ijse.DiliverSystem.controller.ManageRiderGetOrderController;
import lk.ijse.DiliverSystem.controller.MangeSubmitOrderController;
import lk.ijse.DiliverSystem.dto.LasetOrderSaveDTO;
import lk.ijse.DiliverSystem.dto.RiderGetOrderDTO;

/**
 *
 * @author Viraj jayasanka
 */
public class SaveOrder extends javax.swing.JFrame implements lk.ijse.DiliverSystem.observer.Observer{

    /**
     * Creates new form GetSaveOrder
     */
    public SaveOrder(java.awt.Frame parent, boolean modal) {
        initComponents();
       
        setSize(953, 324);
        setLocationRelativeTo(null);
        loadGetOrderss();
        valisdasion();
         
         
           try {
            UnicastRemoteObject.exportObject(this, 0);
           //  Mange.getSubject().registerObserver(this);
              ManageRiderGetOrderController.getSubject().registerObserver(this);
        } catch (Exception ex) {
          Logger.getLogger(SaveOrder.class.getName()).log(Level.SEVERE, null, ex);
          
             }

    }
    private void loadGetOrderss(){
        
        DefaultTableModel dtm = (DefaultTableModel) SaveOrderTabel.getModel();
        dtm.setRowCount(0);

        try {
            List<RiderGetOrderDTO> SenterDTOs = ManageRiderGetOrderController.getAllRiderGetOrder();

            if (SenterDTOs == null) {
                return;
            }

            for (RiderGetOrderDTO getOrderDTO : SenterDTOs) {
                Object[] rowData = {
                    getOrderDTO.getSubmitOrderID(),
                    getOrderDTO.getOrderid(),
                    getOrderDTO.getTeleponeOperterName(),
                    getOrderDTO.getCustomerID(),
                    getOrderDTO.getTotal(),
                    getOrderDTO.getRiderName(),
                    getOrderDTO.getTime()
                   
                  
                };
                dtm.addRow(rowData);
                
               // ArrayList<TakeOrderDTO> list =takeOrderDTO.?uComboBox2.getSelectedItem());
            }

        } catch (Exception ex) {
            Logger.getLogger(SaveOrder.class.getName()).log(Level.SEVERE, null, ex);
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

        jPanel2 = new javax.swing.JPanel();
        jComboBox2 = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        SaveOrderTabel = new javax.swing.JTable();
        txtSubmitOderID1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtGetOrderID = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtTeponeOperterName = new javax.swing.JLabel();
        txtCustomerID2 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        txtTotal = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel7 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        RiderName = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Cash", "Visa" }));
        jComboBox2.setToolTipText("");
        jComboBox2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox2ActionPerformed(evt);
            }
        });
        jPanel2.add(jComboBox2, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 230, 180, 30));

        SaveOrderTabel.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "SubmitOrder ID", "Order ID", "Rider Name", "Customer ID", "Total", "T.O.N", "Time"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        SaveOrderTabel.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                SaveOrderTabelAncestorAdded(evt);
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });
        SaveOrderTabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                SaveOrderTabelMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(SaveOrderTabel);

        jPanel2.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, 920, 100));

        txtSubmitOderID1.setFont(new java.awt.Font("sansserif", 1, 12)); // NOI18N
        txtSubmitOderID1.setText("S.O.ID");
        jPanel2.add(txtSubmitOderID1, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 170, -1, -1));

        jLabel3.setText("Submit Order ID");
        jPanel2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 170, -1, -1));

        txtGetOrderID.setFont(new java.awt.Font("sansserif", 1, 12)); // NOI18N
        txtGetOrderID.setText("Order ID");
        jPanel2.add(txtGetOrderID, new org.netbeans.lib.awtextra.AbsoluteConstraints(417, 170, 80, -1));

        jLabel5.setText("Order ID");
        jPanel2.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 170, -1, -1));

        jLabel6.setText("T.O.N");
        jPanel2.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 170, -1, -1));

        txtTeponeOperterName.setFont(new java.awt.Font("sansserif", 1, 12)); // NOI18N
        txtTeponeOperterName.setText("T.O.N");
        jPanel2.add(txtTeponeOperterName, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 170, 90, -1));

        txtCustomerID2.setFont(new java.awt.Font("sansserif", 1, 12)); // NOI18N
        txtCustomerID2.setText("51");
        jPanel2.add(txtCustomerID2, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 170, 50, -1));

        jLabel13.setFont(new java.awt.Font("sansserif", 1, 12)); // NOI18N
        jLabel13.setText("Save Order");
        jPanel2.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, -1, -1));

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/lk/ijse/DiliverSystem/Image/Entypo_d83d(3)_45.png"))); // NOI18N
        jButton2.setText("Save Order");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 230, 210, 40));

        jLabel8.setText("Customer ID");
        jPanel2.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 170, -1, -1));

        jLabel9.setText("Total");
        jPanel2.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 170, -1, -1));

        txtTotal.setFont(new java.awt.Font("sansserif", 1, 12)); // NOI18N
        txtTotal.setText("total");
        jPanel2.add(txtTotal, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 170, 80, -1));

        jSeparator1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel2.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 160, 920, 30));

        jLabel7.setText("Payment");
        jPanel2.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 230, -1, -1));

        jLabel12.setText("Rider Name");
        jPanel2.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 20, -1, -1));

        RiderName.setFont(new java.awt.Font("sansserif", 1, 12)); // NOI18N
        RiderName.setForeground(new java.awt.Color(255, 0, 0));
        RiderName.setText("Rider Name");
        jPanel2.add(RiderName, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 20, 110, -1));

        jLabel1.setFont(new java.awt.Font("sansserif", 1, 12)); // NOI18N
        jLabel1.setText("Time");
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 170, 90, -1));

        jLabel2.setText("Time");
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 170, -1, -1));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 940, 310));
    }// </editor-fold>//GEN-END:initComponents

    private void SaveOrderTabelAncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_SaveOrderTabelAncestorAdded

    }//GEN-LAST:event_SaveOrderTabelAncestorAdded

    private void SaveOrderTabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_SaveOrderTabelMouseClicked
        String customerId  = SaveOrderTabel.getValueAt(SaveOrderTabel.getSelectedRow(), 0).toString();
        String name  = SaveOrderTabel.getValueAt(SaveOrderTabel.getSelectedRow(), 1).toString();
        String address  = SaveOrderTabel.getValueAt(SaveOrderTabel.getSelectedRow(), 2).toString();
        String TelponeNO  = SaveOrderTabel.getValueAt(SaveOrderTabel.getSelectedRow(), 3).toString();
        String otherNo  = SaveOrderTabel.getValueAt(SaveOrderTabel.getSelectedRow(), 4).toString();
        String TxtAriya  = SaveOrderTabel.getValueAt(SaveOrderTabel.getSelectedRow(), 5).toString();
        String Time  = SaveOrderTabel.getValueAt(SaveOrderTabel.getSelectedRow(), 6).toString();

        SaveOrder. txtSubmitOderID1.setText(customerId);
        SaveOrder.txtGetOrderID.setText(name);
        SaveOrder.txtTeponeOperterName.setText(address);
        SaveOrder.txtCustomerID2.setText(TelponeNO);
        SaveOrder.RiderName.setText(TxtAriya);
        SaveOrder.txtTotal.setText(otherNo);
        SaveOrder.jLabel1.setText(Time);
        
         jButton2.setEnabled(true);
         jComboBox2.setEnabled(true);

    }//GEN-LAST:event_SaveOrderTabelMouseClicked

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
     
        LasetOrderSaveDTO lasetOrderSaveDTO = new LasetOrderSaveDTO(
             
              Integer.parseInt(txtSubmitOderID1.getText()),
              Integer.parseInt(txtGetOrderID.getText()),
              Integer.parseInt(txtCustomerID2.getText()),
              txtTeponeOperterName.getText(),
              RiderName.getText(),
              jLabel1.getText(),
              MainPanelRider.TimeLabel.getText(),
              jComboBox2.getSelectedItem().toString(),
              Double.parseDouble(txtTotal.getText()),
              MainPanelRider.jCalendarCombo1.getSelectedItem().toString()

      );
        try {
            boolean resalt = ManageLastOrderSaveController.addLastOrderSave(lasetOrderSaveDTO);
            boolean delete = ManageRiderGetOrderController.deleteRiderGetOrder(Integer.parseInt(txtSubmitOderID1.getText()));
            if(resalt =! true){
                JOptionPane.showMessageDialog(this, "Order is Save SussesFulll");
            }else{
                JOptionPane.showMessageDialog(this, "Order is Save UnSussesFulll");    
                    }
            
        } catch (Exception ex) {
            Logger.getLogger(SaveOrder.class.getName()).log(Level.SEVERE, null, ex);
        }
      
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jComboBox2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox2ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JLabel RiderName;
    private javax.swing.JTable SaveOrderTabel;
    private javax.swing.JButton jButton2;
    private javax.swing.JComboBox<String> jComboBox2;
    public static javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    public static javax.swing.JLabel txtCustomerID2;
    public static javax.swing.JLabel txtGetOrderID;
    public static javax.swing.JLabel txtSubmitOderID1;
    public static javax.swing.JLabel txtTeponeOperterName;
    public static javax.swing.JLabel txtTotal;
    // End of variables declaration//GEN-END:variables

    @Override
    public void updateObservers() throws Exception {
        loadGetOrderss();
    }
    
    public void valisdasion(){
        jButton2.setEnabled(false);
        jComboBox2.setEnabled(false);
    }
}