/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.DiliverSystem.view.Casher;

import java.awt.Color;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;
import lk.ijse.DiliverSystem.controller.MangeSubmitOrderController;
import lk.ijse.DiliverSystem.dto.SubmitOrderDTO;

/**
 *
 * @author Viraj jayasanka
 */
public class PadingOrder extends javax.swing.JPanel {

    /**
     * Creates new form PadingOrder
     */
    public PadingOrder() {
        initComponents();
        jPanel2.setBackground(new Color(228,239,186,110));
        jPanel3.setBackground(new Color(228,239,186,110));
        jPanel4.setBackground(new Color(228,239,186,110));
        loadAllCustomers();
    }
 private void loadAllCustomers(){
        
//        SubmitOrder submitOrder= new SubmitOrder();
        
        DefaultTableModel dtm = (DefaultTableModel) jTable1.getModel();
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
                
               // ArrayList<TakeOrderDTO> list =takeOrderDTO.?uComboBox2.getSelectedItem());
            }

        } catch (Exception ex) {
            Logger.getLogger(PadingOrder.class.getName()).log(Level.SEVERE, null, ex);
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
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        GetOrdertabel = new javax.swing.JTable();
        jPanel4 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jLabel4 = new javax.swing.JLabel();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("sansserif", 3, 24)); // NOI18N
        jLabel2.setText("Panding Order");
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 10, 180, -1));

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Submit Order ID", "Order ID", "T.O.N", "Customer ID", "Totoal", "Discrption", "Time", "Date"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        jPanel2.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, 1180, 100));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, 1200, 170));

        jPanel3.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setFont(new java.awt.Font("sansserif", 3, 24)); // NOI18N
        jLabel3.setText("Takeing Orders");
        jPanel3.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 10, 180, -1));

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
        jScrollPane4.setViewportView(GetOrdertabel);

        jPanel3.add(jScrollPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, 1170, 140));

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 220, 1200, 210));

        jPanel4.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("sansserif", 3, 24)); // NOI18N
        jLabel1.setText("Save Orders");
        jPanel4.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 20, 180, -1));

        jTable2.setBorder(null);
        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4", "Title 5", "Title 6", "Title 7"
            }
        ));
        jScrollPane2.setViewportView(jTable2);

        jPanel4.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, 1170, 150));

        jPanel1.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 460, 1200, 240));

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/lk/ijse/DiliverSystem/image/OrdermanuImage.jpg"))); // NOI18N
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1230, 720));

        add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1230, 720));
    }// </editor-fold>//GEN-END:initComponents

    private void GetOrdertabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_GetOrdertabelMouseClicked
//        jButton7.setEnabled(true);
    }//GEN-LAST:event_GetOrdertabelMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable GetOrdertabel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    // End of variables declaration//GEN-END:variables
}
