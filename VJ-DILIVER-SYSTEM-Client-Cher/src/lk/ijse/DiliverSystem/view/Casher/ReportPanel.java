/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.DiliverSystem.view.Casher;

/**
 *
 * @author Viraj jayasanka
 */
public class ReportPanel extends javax.swing.JFrame {

    /**
     * Creates new form ReportPanel
     */
    public ReportPanel(java.awt.Frame parent, boolean modal) {
        initComponents();
       
        setSize(980, 636);
        setLocationRelativeTo(null);
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
        jXBusyLabel1 = new org.jdesktop.swingx.JXBusyLabel();
        SearCustomer = new org.jdesktop.swingx.JXSearchField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jXTree1 = new org.jdesktop.swingx.JXTree();
        jButton1 = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jXHeader1 = new org.jdesktop.swingx.JXHeader();
        jCalendarCombo1 = new org.freixas.jcalendar.JCalendarCombo();

        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jXBusyLabel1.setFont(new java.awt.Font("sansserif", 3, 14)); // NOI18N
        jPanel1.add(jXBusyLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 70, 30, -1));

        SearCustomer.setText("Search Order ID");
        SearCustomer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SearCustomerActionPerformed(evt);
            }
        });
        jPanel1.add(SearCustomer, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 60, 300, 30));

        jXTree1.setOpaque(false);
        jScrollPane1.setViewportView(jXTree1);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 120, 610));

        jButton1.setText("Load");
        jButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jButton1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 60, 90, 40));

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "OrderID", "Customer ID", "T.O.N", "Total"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(jTable1);

        jPanel1.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 110, 830, 440));

        jButton2.setText("Show Report");
        jPanel1.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 570, 120, 30));

        jButton3.setText("Save Report");
        jPanel1.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 570, 140, 30));

        jLabel1.setFont(new java.awt.Font("sansserif", 3, 18)); // NOI18N
        jLabel1.setText("Dayle Report");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 10, 120, 30));
        jPanel1.add(jXHeader1, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 10, 840, 30));
        jPanel1.add(jCalendarCombo1, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 60, -1, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 980, 610));
    }// </editor-fold>//GEN-END:initComponents

    private void SearCustomerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SearCustomerActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_SearCustomerActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private org.jdesktop.swingx.JXSearchField SearCustomer;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private org.freixas.jcalendar.JCalendarCombo jCalendarCombo1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private org.jdesktop.swingx.JXBusyLabel jXBusyLabel1;
    private org.jdesktop.swingx.JXHeader jXHeader1;
    private org.jdesktop.swingx.JXTree jXTree1;
    // End of variables declaration//GEN-END:variables
}
