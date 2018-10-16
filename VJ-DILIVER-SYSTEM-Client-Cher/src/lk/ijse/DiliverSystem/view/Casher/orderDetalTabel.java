/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.DiliverSystem.view.Casher;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import lk.ijse.DiliverSystem.controller.ManageTakeOrderController;
import lk.ijse.DiliverSystem.dto.TakeOrderDTO;


/**
 *
 * @author Viraj jayasanka
 */
public class orderDetalTabel extends javax.swing.JFrame {

    /**
     * Creates new form orderDetalTabel
     */
    public orderDetalTabel(java.awt.Frame parent, boolean modal){
        initComponents();
        jPanel1.setBackground(new Color(228,239,186,110));
        setSize(1146, 536);
        setLocationRelativeTo(null);
       loadAllCustomerss();
       
        
        
    }
     private void loadAllCustomerss(){

        DefaultTableModel dtm = (DefaultTableModel) takeORderTabel.getModel();
        dtm.setRowCount(0);

             try {
                // String name1 = (String) jComboBox1.getSelectedItem();
//                  String name="";
//            name="viraj";
                 
            List<TakeOrderDTO> SenterDTOs = ManageTakeOrderController.QureTakeOrder(jComboBox1.getSelectedItem().toString());
              //System.out.print(SenterDTOs);
            if (SenterDTOs == null) {
                return;
            }

            for (TakeOrderDTO callSenterDTO : SenterDTOs) {
                Object[] rowData = {
                    callSenterDTO.getOrderID(),
                    callSenterDTO.getTelepOneOperterName(),
                    callSenterDTO.getDilveryCharges(),
                    callSenterDTO.getSubTotal(),
                    callSenterDTO.getTotal(),
                    callSenterDTO.getItemTextAriya(),
                    callSenterDTO.getPayment(),
                    callSenterDTO.getDate(),
                    callSenterDTO.getTime()
                };
                dtm.addRow(rowData);
                System.out.print(dtm);
            }

        } catch (Exception ex) {
            Logger.getLogger(orderDetalTabel.class.getName()).log(Level.SEVERE, null, ex);
        }
     }
    
//       private void loadAllCustomers(){
//
//        DefaultTableModel dtm = (DefaultTableModel) takeORderTabel.getModel();
//        dtm.setRowCount(0);
//
//        try {
//            List<TakeOrderDTO> SenterDTOs = ManageTakeOrderController.getAllTakeOrders();
//
//            if (SenterDTOs == null) {
//                return;
//            }
//
//            for (TakeOrderDTO callSenterDTO : SenterDTOs) {
//                Object[] rowData = {
//                    callSenterDTO.getOrderID(),
//                    callSenterDTO.getTelepOneOperterName(),
//                    callSenterDTO.getDilveryCharges(),
//                    callSenterDTO.getSubTotal(),
//                    callSenterDTO.getTotal(),
//                    callSenterDTO.getItemTextAriya(),
//                    callSenterDTO.getPayment(),
//                    callSenterDTO.getDate(),
//                    callSenterDTO.getTime()
//                };
//                dtm.addRow(rowData);
//            }
//
//        } catch (Exception ex) {
//            Logger.getLogger(orderDetalTabel.class.getName()).log(Level.SEVERE, null, ex);
//        }
//}
       
// private void loadAllCustomerss(){
//
//        DefaultTableModel dtm = (DefaultTableModel) OrelTabel.getModel();
//        dtm.setRowCount(0);
//
//             try {
//                // String name1 = (String) jComboBox1.getSelectedItem();
////                  String name="";
////            name="viraj";
//                 
//            List<TakeOrderDTO> SenterDTOs = ManageTakeOrderController.QureTakeOrder(jLabel1.getText());
//
//            if (SenterDTOs == null) {
//                return;
//            }
//
//            for (TakeOrderDTO callSenterDTO : SenterDTOs) {
//                Object[] rowData = {
//                    callSenterDTO.getOrderID(),
//                    callSenterDTO.getTelepOneOperterName(),
//                    callSenterDTO.getDilveryCharges(),
//                    callSenterDTO.getSubTotal(),
//                    callSenterDTO.getTotal(),
//                    callSenterDTO.getItemTextAriya(),
//                    callSenterDTO.getPayment(),
//                    callSenterDTO.getDate(),
//                    callSenterDTO.getTime()
//                };
//                dtm.addRow(rowData);
//            }
//
//        } catch (Exception ex) {
//            Logger.getLogger(orderDetalTabel.class.getName()).log(Level.SEVERE, null, ex);
//        }
// }
        
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        takeORderTabel = new javax.swing.JTable();
        jScrollPane4 = new javax.swing.JScrollPane();
        OrelTabel = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jButton2 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jTextField7 = new javax.swing.JTextField();
        jTextField6 = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jLabel7 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jComboBox2 = new javax.swing.JComboBox<>();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jTextField5 = new javax.swing.JTextField();
        jTextField8 = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();

        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        takeORderTabel.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Order ID", "Tele.O.Name", "Deleivery Chaegs", "SubTotal", "Total", "Discription", "Payment", "Date", "Time"
            }
        ));
        jScrollPane1.setViewportView(takeORderTabel);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 1120, 200));

        OrelTabel.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Name", "Qty", "Price", "Total"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        OrelTabel.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                OrelTabelAncestorAdded(evt);
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });
        jScrollPane4.setViewportView(OrelTabel);

        getContentPane().add(jScrollPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 220, 410, 300));

        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButton2.setFont(new java.awt.Font("sansserif", 1, 12)); // NOI18N
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/lk/ijse/DiliverSystem/image/delete customer ican1.png"))); // NOI18N
        jButton2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel1.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 220, 90, 40));

        jButton1.setFont(new java.awt.Font("sansserif", 1, 12)); // NOI18N
        jButton1.setText("Update");
        jButton1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 220, 110, 40));

        jTextField7.setFont(new java.awt.Font("sansserif", 1, 12)); // NOI18N
        jTextField7.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel1.add(jTextField7, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 160, 210, 30));

        jTextField6.setFont(new java.awt.Font("sansserif", 1, 12)); // NOI18N
        jTextField6.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel1.add(jTextField6, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 120, 210, 30));

        jLabel4.setFont(new java.awt.Font("sansserif", 1, 12)); // NOI18N
        jLabel4.setText("Total");
        jLabel4.setBorder(null);
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 220, -1, -1));

        jLabel6.setFont(new java.awt.Font("sansserif", 1, 12)); // NOI18N
        jLabel6.setText("Sub Total");
        jLabel6.setBorder(null);
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 170, -1, -1));

        jLabel5.setFont(new java.awt.Font("sansserif", 1, 12)); // NOI18N
        jLabel5.setText("DeleverChacges");
        jLabel5.setBorder(null);
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 120, -1, -1));

        jLabel9.setFont(new java.awt.Font("sansserif", 1, 12)); // NOI18N
        jLabel9.setText("TelePone  Operter");
        jLabel9.setBorder(null);
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, -1, -1));

        jLabel10.setFont(new java.awt.Font("sansserif", 1, 12)); // NOI18N
        jLabel10.setText("Order ID");
        jLabel10.setBorder(null);
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 30, -1, -1));

        jLabel1.setFont(new java.awt.Font("sansserif", 1, 12)); // NOI18N
        jLabel1.setText("viraj");
        jLabel1.setBorder(null);
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 30, -1, -1));

        jComboBox1.setFont(new java.awt.Font("sansserif", 1, 12)); // NOI18N
        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jComboBox1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel1.add(jComboBox1, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 70, 210, -1));

        jLabel7.setFont(new java.awt.Font("sansserif", 1, 12)); // NOI18N
        jLabel7.setText("Discription");
        jLabel7.setBorder(null);
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 80, -1, -1));

        jLabel2.setFont(new java.awt.Font("sansserif", 1, 12)); // NOI18N
        jLabel2.setText("Total");
        jLabel2.setBorder(null);
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 40, -1, -1));

        jLabel8.setFont(new java.awt.Font("sansserif", 1, 12)); // NOI18N
        jLabel8.setText("Payament");
        jLabel8.setBorder(null);
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 170, -1, -1));

        jComboBox2.setFont(new java.awt.Font("sansserif", 1, 12)); // NOI18N
        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jComboBox2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel1.add(jComboBox2, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 170, 190, -1));

        jTextArea1.setColumns(20);
        jTextArea1.setFont(new java.awt.Font("sansserif", 1, 12)); // NOI18N
        jTextArea1.setRows(5);
        jTextArea1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jScrollPane2.setViewportView(jTextArea1);

        jPanel1.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 80, 190, 60));

        jTextField5.setFont(new java.awt.Font("sansserif", 1, 12)); // NOI18N
        jTextField5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel1.add(jTextField5, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 30, 190, 30));

        jTextField8.setFont(new java.awt.Font("sansserif", 1, 12)); // NOI18N
        jTextField8.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel1.add(jTextField8, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 210, 210, 30));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 220, 700, 300));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/lk/ijse/DiliverSystem/image/OrdermanuImage.jpg"))); // NOI18N
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1150, 540));
    }// </editor-fold>//GEN-END:initComponents

    private void OrelTabelAncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_OrelTabelAncestorAdded
        // OrelTabel.setEnabled(false);
    }//GEN-LAST:event_OrelTabelAncestorAdded


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JTable OrelTabel;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JComboBox<String> jComboBox2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
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
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JTextField jTextField6;
    private javax.swing.JTextField jTextField7;
    private javax.swing.JTextField jTextField8;
    public static javax.swing.JTable takeORderTabel;
    // End of variables declaration//GEN-END:variables
}
