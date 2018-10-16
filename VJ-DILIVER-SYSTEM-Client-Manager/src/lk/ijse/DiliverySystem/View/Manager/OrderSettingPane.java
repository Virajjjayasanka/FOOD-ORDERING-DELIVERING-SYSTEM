/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.DiliverySystem.View.Manager;

import java.rmi.server.UnicastRemoteObject;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;
import lk.ijse.DiliverSystem.dto.RiderGetOrderDTO;
import lk.ijse.DiliverSystem.dto.SubmitOrderDTO;
import lk.ijse.DiliverSystem.dto.TakeOrderDTO;
import lk.ijse.DiliverSystem.observer.Observer;
import lk.ijse.DilverSystem.controller.ManageRiderGetOrderController;
import lk.ijse.DilverSystem.controller.ManageTakeOrderController;
import lk.ijse.DilverSystem.controller.MangeSubmitOrderController;

/**
 *
 * @author Viraj jayasanka
 */
public class OrderSettingPane extends javax.swing.JPanel implements Observer{

    /**
     * Creates new form OrderSettingPane
     */
    public OrderSettingPane() {
        initComponents();
        loadAllCustomerss();
        loadAllOrderss();
        loadAllCustomers();
        validation();
        
        
           try {
            UnicastRemoteObject.exportObject(this, 0);
               ManageTakeOrderController.getSubject().registerObserver(this);
               MangeSubmitOrderController.getSubject().registerObserver(this);
               ManageRiderGetOrderController.getSubject().registerObserver(this);
        } catch (Exception ex) {
          Logger.getLogger(OrderSettingPane.class.getName()).log(Level.SEVERE, null, ex);
          
             }
    }
    private void validation(){
        jButton3.setEnabled(false);
        jButton4.setEnabled(false);
        jButton1.setEnabled(false);
    }
 
    
    private void loadAllCustomerss(){

        DefaultTableModel dtm = (DefaultTableModel) OrderTabelAddCustomerPanel.getModel();
        dtm.setRowCount(0);

             try {

                 
            List<TakeOrderDTO> SenterDTOs = ManageTakeOrderController.getAllTakeOrders();
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
            }

        } catch (Exception ex) {
            Logger.getLogger(OrderSettingPane.class.getName()).log(Level.SEVERE, null, ex);
     }
    }
     private void loadAllCustomers(){

        DefaultTableModel dtm = (DefaultTableModel) SubmitOrderTabel1.getModel();
        dtm.setRowCount(0);

        try {
            List<SubmitOrderDTO> SenterDTOs = MangeSubmitOrderController.getAllSubmitOrders();

            if (SenterDTOs == null) {
                return;
            }

            for (SubmitOrderDTO customerDTO1 : SenterDTOs) {
                Object[] rowData = {
                    customerDTO1.getSubmitOrderID(),
                    customerDTO1.getOrderID(),
                    customerDTO1.getTeleponeOperterName(),
                    customerDTO1.getCustomerId(),
                    customerDTO1.getTotal(),
                    customerDTO1.getPayment(),
                    customerDTO1.getTime(),
                    customerDTO1.getDate()
                   
                };
                dtm.addRow(rowData);
            }

        } catch (Exception ex) {
            Logger.getLogger(OrderSettingPane.class.getName()).log(Level.SEVERE, null, ex);
        }

 }
  private void loadAllOrderss(){

        DefaultTableModel dtm = (DefaultTableModel) GetOrdertabel.getModel();
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
            }

        } catch (Exception ex) {
            Logger.getLogger(OrderSettingPane.class.getName()).log(Level.SEVERE, null, ex);
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
        jButton3 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        GetOrdertabel = new javax.swing.JTable();
        jButton4 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        SubmitOrderTabel1 = new javax.swing.JTable();
        jScrollPane5 = new javax.swing.JScrollPane();
        OrderTabelAddCustomerPanel = new javax.swing.JTable();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButton3.setText("Update ");
        jPanel1.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(990, 190, 130, 40));

        jButton1.setText("Update ");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1000, 610, 130, 40));

        GetOrdertabel.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Submitorder ID", "OrderID", "T.O.N", "Customer ID", "Total", "RiderName", "Time"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        GetOrdertabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                GetOrdertabelMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(GetOrdertabel);

        jPanel1.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 470, 1130, 110));

        jButton4.setText("Update ");
        jPanel1.add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(990, 400, 130, 40));

        jLabel1.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        jLabel1.setText("Rider  Get Order");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 430, 140, 30));

        jLabel2.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        jLabel2.setText("Cher Save Order");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 140, 30));

        jLabel3.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        jLabel3.setText("Caher Sumit ORder");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 210, 140, 30));

        SubmitOrderTabel1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Submitorder ID", "Order ID", "T.O.N", "Customer ID", "Total", "Dicrption", "Time", "Date"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        SubmitOrderTabel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                SubmitOrderTabel1MouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(SubmitOrderTabel1);

        jPanel1.add(jScrollPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 260, 1130, 130));

        OrderTabelAddCustomerPanel.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "OID", "T.O.N", "Deli.Ch", "Sub.Total", "Total", "Payment", "Dicrtpition", "Date", "Time"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        OrderTabelAddCustomerPanel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                OrderTabelAddCustomerPanelMouseExited(evt);
            }
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                OrderTabelAddCustomerPanelMouseClicked(evt);
            }
        });
        jScrollPane5.setViewportView(OrderTabelAddCustomerPanel);

        jPanel1.add(jScrollPane5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, 1130, 100));

        add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1150, 680));
    }// </editor-fold>//GEN-END:initComponents

    private void GetOrdertabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_GetOrdertabelMouseClicked
       // jButton7.setEnabled(true);
    }//GEN-LAST:event_GetOrdertabelMouseClicked

    private void SubmitOrderTabel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_SubmitOrderTabel1MouseClicked
        jButton1.setEnabled(true);
    }//GEN-LAST:event_SubmitOrderTabel1MouseClicked

    private void OrderTabelAddCustomerPanelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_OrderTabelAddCustomerPanelMouseClicked
         jButton3.setEnabled(true);
//        String OrderID  = OrderTabelAddCustomerPanel.getValueAt(OrderTabelAddCustomerPanel.getSelectedRow(), 0).toString();
//        String DeleverChes  = OrderTabelAddCustomerPanel.getValueAt(OrderTabelAddCustomerPanel.getSelectedRow(), 2).toString();
//        String SubTotal  = OrderTabelAddCustomerPanel.getValueAt(OrderTabelAddCustomerPanel.getSelectedRow(), 3).toString();
//        String Total  = OrderTabelAddCustomerPanel.getValueAt(OrderTabelAddCustomerPanel.getSelectedRow(), 4).toString();
//        String Discrption  = OrderTabelAddCustomerPanel.getValueAt(OrderTabelAddCustomerPanel.getSelectedRow(), 6).toString();
//        String Payment  = OrderTabelAddCustomerPanel.getValueAt(OrderTabelAddCustomerPanel.getSelectedRow(), 5).toString();
//
//        AddCustomerPanel. jLabel10.setText( OrderID);
//        AddCustomerPanel.txtDelveryChes.setText(DeleverChes);
//        AddCustomerPanel.txtSubtotal.setText(SubTotal);
//        AddCustomerPanel.txtTotal.setText(Total);
//        AddCustomerPanel.txtDis.setText(Discrption);
//        AddCustomerPanel.txtpayment.setText(Payment);
//
//        if(true){
//            valisdashonTrue();
//        }else{
//            Valdsion1();
//        }

    }//GEN-LAST:event_OrderTabelAddCustomerPanelMouseClicked

    private void OrderTabelAddCustomerPanelMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_OrderTabelAddCustomerPanelMouseExited
        // Valdsion1();
    }//GEN-LAST:event_OrderTabelAddCustomerPanelMouseExited

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
      jButton1.setEnabled(true);
    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable GetOrdertabel;
    private javax.swing.JTable OrderTabelAddCustomerPanel;
    private javax.swing.JTable SubmitOrderTabel1;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    // End of variables declaration//GEN-END:variables

    @Override
    public void updateObservers() throws Exception {
        loadAllCustomerss();
        loadAllOrderss();
        loadAllCustomers();
    }
}
