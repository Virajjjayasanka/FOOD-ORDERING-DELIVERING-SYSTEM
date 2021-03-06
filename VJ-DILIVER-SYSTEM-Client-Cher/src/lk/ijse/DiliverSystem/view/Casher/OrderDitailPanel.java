/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.DiliverSystem.view.Casher;

import java.rmi.server.UnicastRemoteObject;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import lk.ijse.DiliverSystem.controller.ManageOrderDitalController;
import lk.ijse.DiliverSystem.dto.OrderDitailsDTO;
import lk.ijse.DiliverSystem.observer.Observer;

/**
 *
 * @author Viraj jayasanka
 */
public class OrderDitailPanel extends javax.swing.JPanel implements Observer {

    /**
     * Creates new form OrderDitailPanel
     */
    public OrderDitailPanel() {
        initComponents();
       loadAlLNameCustomer();
       try {
            UnicastRemoteObject.exportObject(this, 0);
               ManageOrderDitalController.getSubject().registerObserver(this);
        } catch (Exception ex) {
          Logger.getLogger(AddCustomerPanel.class.getName()).log(Level.SEVERE, null, ex);
          
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
        jScrollPane1 = new javax.swing.JScrollPane();
        OrderDitelTabel = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtSaveOrderDitailS = new javax.swing.JTextField();
        txtCustomerID = new javax.swing.JTextField();
        txtOperterNAme = new javax.swing.JTextField();
        txtDeleverChes = new javax.swing.JTextField();
        txtTotalPanel = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jTextField7 = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        txtSaveOrderID = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        OrderDitelTabel.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Order Ditail ID", "Order ID", "Customer id", "T.O.N", "DeleveryChes", "Total", "Date", "Time"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        OrderDitelTabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                OrderDitelTabelMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(OrderDitelTabel);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 130, 1180, 370));

        jLabel1.setFont(new java.awt.Font("sansserif", 1, 12)); // NOI18N
        jLabel1.setText("T.O.P");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 550, 70, 20));

        jLabel3.setFont(new java.awt.Font("sansserif", 1, 12)); // NOI18N
        jLabel3.setText("DeleveryChes");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 620, -1, -1));

        jLabel4.setFont(new java.awt.Font("sansserif", 1, 12)); // NOI18N
        jLabel4.setText("Customer ID");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 550, -1, -1));

        jLabel5.setFont(new java.awt.Font("sansserif", 1, 12)); // NOI18N
        jLabel5.setText("Order ID");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 550, -1, -1));

        jLabel6.setFont(new java.awt.Font("sansserif", 1, 12)); // NOI18N
        jLabel6.setText("Total");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 620, 70, -1));

        txtSaveOrderDitailS.setFont(new java.awt.Font("sansserif", 1, 12)); // NOI18N
        txtSaveOrderDitailS.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel1.add(txtSaveOrderDitailS, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 550, 160, 30));

        txtCustomerID.setFont(new java.awt.Font("sansserif", 1, 12)); // NOI18N
        txtCustomerID.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel1.add(txtCustomerID, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 550, 150, 30));

        txtOperterNAme.setFont(new java.awt.Font("sansserif", 1, 12)); // NOI18N
        txtOperterNAme.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel1.add(txtOperterNAme, new org.netbeans.lib.awtextra.AbsoluteConstraints(890, 550, 190, 30));

        txtDeleverChes.setFont(new java.awt.Font("sansserif", 1, 12)); // NOI18N
        txtDeleverChes.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel1.add(txtDeleverChes, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 620, 150, 30));

        txtTotalPanel.setFont(new java.awt.Font("sansserif", 1, 12)); // NOI18N
        txtTotalPanel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel1.add(txtTotalPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 620, 160, 30));

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/lk/ijse/DiliverSystem/image/ResatAll (2).png"))); // NOI18N
        jButton1.setToolTipText("Update Order");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1090, 540, 100, 40));

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/lk/ijse/DiliverSystem/image/delete customer ican1.png"))); // NOI18N
        jButton2.setToolTipText("Delete Order");
        jPanel1.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(1090, 590, 100, 40));

        jLabel7.setFont(new java.awt.Font("sansserif", 1, 12)); // NOI18N
        jLabel7.setText("Search Customer ID");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 90, -1, -1));

        jTextField7.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel1.add(jTextField7, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 80, 200, 30));

        jLabel8.setFont(new java.awt.Font("sansserif", 3, 14)); // NOI18N
        jLabel8.setText("Order Ditails Panel");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 30, -1, -1));

        jButton3.setText("Search");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 80, 80, 30));

        txtSaveOrderID.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel1.add(txtSaveOrderID, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 550, 160, 30));

        jLabel9.setFont(new java.awt.Font("sansserif", 1, 12)); // NOI18N
        jLabel9.setText("Save  ID");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 550, -1, -1));

        add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1220, 690));
    }// </editor-fold>//GEN-END:initComponents

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        
        String Date  = jTextField7.getText();
        
        DefaultTableModel dtm = (DefaultTableModel) OrderDitelTabel.getModel();
        dtm.setRowCount(0);

             try {
                           
            List<OrderDitailsDTO> SenterDTOs = ManageOrderDitalController.getOrderDeatilsID(Date);
            
            if (SenterDTOs == null) {
                return;
            }

            for (OrderDitailsDTO ditailsDTO : SenterDTOs) {
                Object[] rowData = {
                    ditailsDTO.getOrderDetailID(),
                    ditailsDTO.getOrderID(),
                    ditailsDTO.getCustomerID(),
                    ditailsDTO.getTeleponeOperterName(),
                    ditailsDTO.getDeleiveryChes(),
                    ditailsDTO.getTotal(),
                    ditailsDTO.getDate(),
                    ditailsDTO.getTime()
                };
                dtm.addRow(rowData);
               //System.out.print(dtm);
            }

        } catch (Exception ex) {
            Logger.getLogger(OrderDitailPanel.class.getName()).log(Level.SEVERE, null, ex);
        }
      
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
       OrderDitailsDTO ditailsDTO = new OrderDitailsDTO(
               
               Integer.parseInt(txtSaveOrderDitailS.getText()),
               txtCustomerID.getText(),
               txtCustomerID.getText(),
               txtOperterNAme.getText(),
               Double.parseDouble(txtDeleverChes.getText()),
               Double.parseDouble(txtTotalPanel.getText()),
               lk.ijse.DiliverSystem.View.Casher.MainPanelCher.jCalendarCombo1.getSelectedItem().toString(),
               lk.ijse.DiliverSystem.View.Casher.MainPanelCher.TimeLabel.getText()  
               
       );
       
        try {
            boolean update = ManageOrderDitalController.updateOrderDital(ditailsDTO);
            
            if(update){
                 JOptionPane.showMessageDialog(this,"Order ditails Update is Suessess ") ;
            }else{
                JOptionPane.showMessageDialog(this,"Order ditails Update is Filas") ;
            }
        } catch (Exception ex) {
            Logger.getLogger(OrderDitailPanel.class.getName()).log(Level.SEVERE, null, ex);
        }
       
       
    }//GEN-LAST:event_jButton1ActionPerformed

    private void OrderDitelTabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_OrderDitelTabelMouseClicked
        String SubmitOrderId  = OrderDitelTabel.getValueAt(OrderDitelTabel.getSelectedRow(), 0).toString();
        String OrderID  = OrderDitelTabel.getValueAt(OrderDitelTabel.getSelectedRow(), 1).toString();
        String  CustomerID = OrderDitelTabel.getValueAt(OrderDitelTabel.getSelectedRow(), 2).toString();
        String TOperterNAme  = OrderDitelTabel.getValueAt(OrderDitelTabel.getSelectedRow(), 3).toString();
        String DileveryChes  = OrderDitelTabel.getValueAt(OrderDitelTabel.getSelectedRow(), 4).toString();
        String Total  = OrderDitelTabel.getValueAt(OrderDitelTabel.getSelectedRow(), 5).toString();
   
        OrderDitailPanel. txtSaveOrderID.setText(SubmitOrderId);
        OrderDitailPanel.txtSaveOrderDitailS.setText(OrderID);       
        OrderDitailPanel.txtCustomerID.setText(CustomerID);      
        OrderDitailPanel.txtOperterNAme.setText(TOperterNAme);     
        OrderDitailPanel.txtDeleverChes.setText(DileveryChes); 
        OrderDitailPanel.txtTotalPanel.setText(Total);
        
        
    }//GEN-LAST:event_OrderDitelTabelMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable OrderDitelTabel;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextField7;
    public static javax.swing.JTextField txtCustomerID;
    public static javax.swing.JTextField txtDeleverChes;
    public static javax.swing.JTextField txtOperterNAme;
    public static javax.swing.JTextField txtSaveOrderDitailS;
    public static javax.swing.JTextField txtSaveOrderID;
    public static javax.swing.JTextField txtTotalPanel;
    // End of variables declaration//GEN-END:variables

    private void loadAlLNameCustomer(){

        DefaultTableModel dtm = (DefaultTableModel) OrderDitelTabel.getModel();
        dtm.setRowCount(0);

             try {
                           
            List<OrderDitailsDTO> SenterDTOs = ManageOrderDitalController.getAllOrderDitals();
            
            if (SenterDTOs == null) {
                return;
            }

            for (OrderDitailsDTO ditailsDTO : SenterDTOs) {
                Object[] rowData = {
                    ditailsDTO.getOrderDetailID(),
                    ditailsDTO.getOrderID(),
                    ditailsDTO.getCustomerID(),
                    ditailsDTO.getTeleponeOperterName(),
                    ditailsDTO.getDeleiveryChes(),
                    ditailsDTO.getTotal(),
                    ditailsDTO.getDate(),
                    ditailsDTO.getTime()
                };
                dtm.addRow(rowData);
               //System.out.print(dtm);
            }

        } catch (Exception ex) {
            Logger.getLogger(OrderDitailPanel.class.getName()).log(Level.SEVERE, null, ex);
        }
      }

    @Override
    public void updateObservers() throws Exception {
        loadAlLNameCustomer();
        
    }
}
