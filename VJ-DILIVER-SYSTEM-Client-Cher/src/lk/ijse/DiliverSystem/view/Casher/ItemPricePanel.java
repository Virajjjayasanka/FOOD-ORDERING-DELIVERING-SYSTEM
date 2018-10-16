/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.DiliverSystem.view.Casher;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;
import lk.ijse.DiliverSystem.controller.MangeItemPriceController;
import lk.ijse.DiliverSystem.dto.ItemPriceDTO;

/**
 *
 * @author Viraj jayasanka
 */
public class ItemPricePanel extends javax.swing.JFrame {

    /**
     * Creates new form ItemPricePanel
     */
    public ItemPricePanel(java.awt.Frame parent, boolean modal) {
        initComponents();
        setSize(812, 473);
         setLocationRelativeTo(null);
         loadAllItem();
    }
private void loadAllItem(){

        DefaultTableModel dtm = (DefaultTableModel) jTable1.getModel();
        dtm.setRowCount(0);

        try {
            List<ItemPriceDTO> SenterDTOs = MangeItemPriceController.getAllItemPrice();

            if (SenterDTOs == null) {
                return;
            }

            for (ItemPriceDTO itemPriceDTO : SenterDTOs) {
                Object[] rowData = {
                    itemPriceDTO.getID(),
                    itemPriceDTO.getItemName(),
                    itemPriceDTO.getUnitPrice()
                   
                };
                dtm.addRow(rowData);
            }

        } catch (Exception ex) {
            Logger.getLogger(ItemPricePanel.class.getName()).log(Level.SEVERE, null, ex);
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
        jLabel4 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel4.setFont(new java.awt.Font("sansserif", 3, 12)); // NOI18N
        jLabel4.setText("Item Price");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 20, -1, -1));

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "item id", "Item Name", "Item Price"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTable1);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 70, 750, 350));

        add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 810, 470));
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
