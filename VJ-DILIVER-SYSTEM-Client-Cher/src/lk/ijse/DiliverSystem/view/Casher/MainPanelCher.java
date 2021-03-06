/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.DiliverSystem.View.Casher;

import com.jtattoo.plaf.BaseIcons;
import com.sun.corba.se.pept.transport.Connection;
import com.sun.javafx.applet.Splash;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.spi.DirStateFactory;
import javax.swing.JOptionPane;
import javax.swing.Timer;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableModel;
import lk.ijse.DiliverSystem.controller.ManageTakeOrderController;
import lk.ijse.DiliverSystem.controller.MangeCallSenterController;
import lk.ijse.DiliverSystem.dto.CallSenterDTO;
import lk.ijse.DiliverSystem.dto.TakeOrderDTO;

/**
 *
 * @author Viraj jayasanka
 */
public class MainPanelCher extends javax.swing.JFrame {
 private static OrderManu orderManu;
    /**
     * Creates new form MainPanel
     */
    public MainPanelCher() {
        initComponents();
        setTime();
        setDate();
       // loadData();
        Vaildshion();
       // setSize(1365, 771);
        //jPanel3.setSize(1230, 680);
        //jPanel3.setBackground(new Color(228,239,186,110));
       // jPanel2.setBackground(new Color(228,239,186,110)); 
        //jPanel.setBackground(new Color(228,239,186,110));
        jPanel2.setBackground(new Color(228,239,186,110)); 
       //jCalendarCombo1.setBackground(new Color(228,239,186,110)); 
    }
    public MainPanelCher(String name) {
       initComponents();
        CallSenterNametxt.setText(name);
        setTime();
        setDate();
        //loadData();
        Vaildshion();
       // setSize(1365, 771);
        //jPanel3.setSize(1230, 680);
        //jPanel3.setBackground(new Color(228,239,186,110));
       // jPanel2.setBackground(new Color(228,239,186,110)); 
        //jPanel.setBackground(new Color(228,239,186,110));
        jPanel2.setBackground(new Color(228,239,186,110)); 
    }
    
     public static OrderManu getOrder(){
        if(orderManu == null){
            orderManu = new OrderManu();
        }
        return orderManu;
    }
    private void Vaildshion(){
        jCalendarCombo1.setEnabled(false);
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
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy / MM / dd");
       // DateLabel.setText(sdf.format(d));
        
        
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        LadPanelMain = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        TimeLabel = new javax.swing.JLabel();
        CallSenterNametxt = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
        jButton9 = new javax.swing.JButton();
        jButton10 = new javax.swing.JButton();
        jButton11 = new javax.swing.JButton();
        jButton12 = new javax.swing.JButton();
        jButton13 = new javax.swing.JButton();
        jButton14 = new javax.swing.JButton();
        jButton15 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jProgressBar1 = new javax.swing.JProgressBar();
        jCalendarCombo1 = new org.freixas.jcalendar.JCalendarCombo();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        LadPanelMain.setBackground(new java.awt.Color(255, 255, 255));
        LadPanelMain.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel10.setFont(new java.awt.Font("sansserif", 3, 30)); // NOI18N
        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/lk/ijse/DiliverSystem/image/figure_running_letter_500_wht_5696.gif"))); // NOI18N

        jLabel1.setFont(new java.awt.Font("sansserif", 3, 48)); // NOI18N

        javax.swing.GroupLayout LadPanelMainLayout = new javax.swing.GroupLayout(LadPanelMain);
        LadPanelMain.setLayout(LadPanelMainLayout);
        LadPanelMainLayout.setHorizontalGroup(
            LadPanelMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(LadPanelMainLayout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 532, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(99, 99, 99)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 641, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        LadPanelMainLayout.setVerticalGroup(
            LadPanelMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(LadPanelMainLayout.createSequentialGroup()
                .addGap(93, 93, 93)
                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 469, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(LadPanelMainLayout.createSequentialGroup()
                .addGap(218, 218, 218)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        getContentPane().add(LadPanelMain, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 40, 1220, 690));

        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/lk/ijse/DiliverSystem/image/icomoon_e608(0)_40.png"))); // NOI18N
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 0, -1, 40));

        jLabel9.setFont(new java.awt.Font("sansserif", 3, 12)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Time");
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 10, 80, 20));

        TimeLabel.setFont(new java.awt.Font("sansserif", 3, 12)); // NOI18N
        TimeLabel.setForeground(new java.awt.Color(255, 255, 255));
        TimeLabel.setText("Time");
        getContentPane().add(TimeLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 10, 110, 20));

        CallSenterNametxt.setFont(new java.awt.Font("sansserif", 1, 18)); // NOI18N
        CallSenterNametxt.setForeground(new java.awt.Color(204, 204, 204));
        CallSenterNametxt.setText("Name");
        getContentPane().add(CallSenterNametxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 10, 140, -1));

        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButton1.setFont(new java.awt.Font("sansserif", 1, 12)); // NOI18N
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/lk/ijse/DiliverSystem/image/FontAwesome_f067(0)_32.png"))); // NOI18N
        jButton1.setText(" Customer ");
        jButton1.setToolTipText("Add Customer Panel");
        jButton1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jButton1.setIconTextGap(-7);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, 100, 40));

        jButton3.setFont(new java.awt.Font("sansserif", 1, 12)); // NOI18N
        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/lk/ijse/DiliverSystem/image/ItemPrice (2).png"))); // NOI18N
        jButton3.setText("Price");
        jButton3.setToolTipText("Price Panel");
        jButton3.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jButton3.setIconTextGap(-7);
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 110, 100, 40));

        jButton4.setFont(new java.awt.Font("sansserif", 1, 12)); // NOI18N
        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/lk/ijse/DiliverSystem/image/FontAwesome_f067(0)_32.png"))); // NOI18N
        jButton4.setText("Order");
        jButton4.setToolTipText("Add Order Pane");
        jButton4.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jButton4.setIconTextGap(1);
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 100, 40));

        jButton5.setFont(new java.awt.Font("sansserif", 1, 12)); // NOI18N
        jButton5.setText("Promashion Ditels");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 210, 100, 40));

        jButton6.setFont(new java.awt.Font("sansserif", 1, 12)); // NOI18N
        jButton6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/lk/ijse/DiliverSystem/image/Entypo_e738(0)_48_1.png"))); // NOI18N
        jButton6.setText("Customer");
        jButton6.setToolTipText("Customer Ditails");
        jButton6.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jButton6.setIconTextGap(-7);
        jPanel2.add(jButton6, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 360, 100, 40));

        jButton7.setFont(new java.awt.Font("sansserif", 1, 12)); // NOI18N
        jButton7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/lk/ijse/DiliverSystem/image/online Rider.png"))); // NOI18N
        jButton7.setText(" Rider");
        jButton7.setToolTipText("Online Rider");
        jButton7.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jButton7.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jButton7.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        jButton7.setIconTextGap(-7);
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton7, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 310, 100, 40));

        jButton8.setText("Order");
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton8, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 610, 100, 40));

        jButton9.setFont(new java.awt.Font("sansserif", 1, 12)); // NOI18N
        jButton9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/lk/ijse/DiliverSystem/image/Massage.png"))); // NOI18N
        jButton9.setText("Massage");
        jButton9.setToolTipText("Massage Order Workes");
        jButton9.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jButton9.setIconTextGap(-3);
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton9, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 260, 100, 40));

        jButton10.setFont(new java.awt.Font("sansserif", 1, 12)); // NOI18N
        jButton10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/lk/ijse/DiliverSystem/image/Entypo_e738(0)_48_1.png"))); // NOI18N
        jButton10.setText("Order");
        jButton10.setToolTipText("Order Ditails");
        jButton10.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jButton10.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jButton10.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        jButton10.setIconTextGap(-7);
        jButton10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton10ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton10, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 410, 100, 40));

        jButton11.setText("Party");
        jPanel2.add(jButton11, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 410, 100, 40));

        jButton12.setFont(new java.awt.Font("sansserif", 1, 12)); // NOI18N
        jButton12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/lk/ijse/DiliverSystem/image/Log out (2).png"))); // NOI18N
        jButton12.setText("Out");
        jButton12.setToolTipText("Login Out");
        jButton12.setIconTextGap(-5);
        jButton12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton12ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton12, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 660, 100, 40));

        jButton13.setFont(new java.awt.Font("sansserif", 1, 12)); // NOI18N
        jButton13.setText("Party");
        jPanel2.add(jButton13, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 510, 100, 40));

        jButton14.setFont(new java.awt.Font("sansserif", 1, 12)); // NOI18N
        jButton14.setText("Massage");
        jPanel2.add(jButton14, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 560, 100, 40));

        jButton15.setFont(new java.awt.Font("sansserif", 1, 12)); // NOI18N
        jButton15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/lk/ijse/DiliverSystem/image/Daly Reporats (2).png"))); // NOI18N
        jButton15.setText("Report");
        jButton15.setToolTipText("Report Daliy");
        jButton15.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jButton15.setIconTextGap(-7);
        jButton15.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton15ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton15, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 460, 100, 40));

        jButton2.setFont(new java.awt.Font("sansserif", 1, 12)); // NOI18N
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/lk/ijse/DiliverSystem/image/Paneding.png"))); // NOI18N
        jButton2.setText("Order");
        jButton2.setToolTipText("Panding Order ");
        jButton2.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jButton2.setIconTextGap(-5);
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 160, 100, 40));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 120, 730));

        jProgressBar1.setBackground(new java.awt.Color(255, 0, 0));
        jProgressBar1.setFont(new java.awt.Font("sansserif", 3, 14)); // NOI18N
        jProgressBar1.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        jProgressBar1.setEnabled(false);
        jProgressBar1.setIndeterminate(true);
        jProgressBar1.setInheritsPopupMenu(true);
        jProgressBar1.setOpaque(true);
        jProgressBar1.setString("VJ Delivery System");
        jProgressBar1.setStringPainted(true);
        getContentPane().add(jProgressBar1, new org.netbeans.lib.awtextra.AbsoluteConstraints(980, 10, 370, 20));

        jCalendarCombo1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCalendarCombo1ActionPerformed(evt);
            }
        });
        getContentPane().add(jCalendarCombo1, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 0, 280, 40));

        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/lk/ijse/DiliverSystem/image/OrdermanuImage.jpg"))); // NOI18N
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1360, 770));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
         LadPanelMain.removeAll();
        LadPanelMain.setVisible(true);
        lk.ijse.DiliverSystem.view.Casher.AddCustomerPanel i1 = new lk.ijse.DiliverSystem.view.Casher.AddCustomerPanel();
        i1.setSize(LadPanelMain.getSize());
        LadPanelMain.add(i1);
        LadPanelMain.repaint();
        LadPanelMain.revalidate();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
      lk.ijse.DiliverSystem.View.Casher.MainPanelCher.LadPanelMain.removeAll();
        lk.ijse.DiliverSystem.View.Casher.MainPanelCher.LadPanelMain.setVisible(true);
        lk.ijse.DiliverSystem.view.Casher.PadingOrder order= new lk.ijse.DiliverSystem.view.Casher.PadingOrder();
        order.setSize(lk.ijse.DiliverSystem.View.Casher.MainPanelCher.LadPanelMain.getSize());
        lk.ijse.DiliverSystem.View.Casher.MainPanelCher.LadPanelMain.add(order);
        lk.ijse.DiliverSystem.View.Casher.MainPanelCher.LadPanelMain.repaint();
        lk.ijse.DiliverSystem.View.Casher.MainPanelCher.LadPanelMain.revalidate();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        lk.ijse.DiliverSystem.view.Casher.ItemPricePanel itemPricePanel= new lk.ijse.DiliverSystem.view.Casher.ItemPricePanel(MainPanelCher.this, true);
        itemPricePanel.setVisible(true);
        
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
       LadPanelMain.removeAll();
       LadPanelMain.setVisible(true);
       lk.ijse.DiliverSystem.view.Casher.OrderPanel orderPanel = new lk.ijse.DiliverSystem.view.Casher.OrderPanel(MainPanelCher.this, true);
      orderPanel.setSize(LadPanelMain.getSize());LadPanelMain.add(orderPanel);
      LadPanelMain.repaint();
      LadPanelMain.revalidate();
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
        lk.ijse.DiliverSystem.view.Casher.Massagening massagening = new lk.ijse.DiliverSystem.view.Casher.Massagening(MainPanelCher.this, true);
        massagening.setVisible(true);
    }//GEN-LAST:event_jButton9ActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
    
       lk.ijse.DiliverSystem.view.Casher.orderDetalTabel detalTabel = new lk.ijse.DiliverSystem.view.Casher.orderDetalTabel(MainPanelCher.this, true);
       detalTabel.setVisible(true);
    
       
    
    }//GEN-LAST:event_jButton8ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
//      LadPanelMain.removeAll();
//      LadPanelMain.setVisible(true);
//      lk.ijse.DiliverSystem.view.Casher.AddCustomerPanel addCustomerPanel = new lk.ijse.DiliverSystem.view.Casher.AddCustomerPanel(MainPanel.this, true);
//      addCustomerPanel.setSize(LadPanelMain.getSize());LadPanelMain.add(addCustomerPanel);
//      LadPanelMain.repaint();
//      LadPanelMain.revalidate();
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton15ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton15ActionPerformed
        lk.ijse.DiliverSystem.view.Casher.ReportPanel reportPanel = new lk.ijse.DiliverSystem.view.Casher.ReportPanel (MainPanelCher.this, true);
       reportPanel.setVisible(true);
    }//GEN-LAST:event_jButton15ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        lk.ijse.DiliverSystem.view.Casher.OnlineRider reportPanel = new lk.ijse.DiliverSystem.view.Casher.OnlineRider(MainPanelCher.this, true);
        reportPanel.setVisible(true);
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jCalendarCombo1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCalendarCombo1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jCalendarCombo1ActionPerformed

    private void jButton10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton10ActionPerformed
        LadPanelMain.removeAll();
        LadPanelMain.setVisible(true);
        lk.ijse.DiliverSystem.view.Casher.OrderDitailPanel ditailPanel = new  lk.ijse.DiliverSystem.view.Casher.OrderDitailPanel();
        ditailPanel.setSize(LadPanelMain.getSize());
        LadPanelMain.add(ditailPanel);
        LadPanelMain.repaint();
        LadPanelMain.revalidate();
    }//GEN-LAST:event_jButton10ActionPerformed

    private void jButton12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton12ActionPerformed
        
     
        if(JOptionPane.showConfirmDialog(this,"Are you Swer Exsit ","Main Panel Error",
            JOptionPane.YES_NO_OPTION)==JOptionPane.YES_NO_OPTION){
         lk.ijse.DiliverSystem.view.Casher.CallOpertorLoginPanel callOpertorLoginPanel = new lk.ijse.DiliverSystem.view.Casher.CallOpertorLoginPanel();
        callOpertorLoginPanel.setVisible(true);
        this.dispose();
        }
    }//GEN-LAST:event_jButton12ActionPerformed
      
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
    
        
        MainPanelCher mainPanel = new MainPanelCher();
           mainPanel.setVisible(true);
         
        try {
            for(int i = 0; i<=100; i++){
            Thread.sleep(40);
            mainPanel.jLabel1.setText(Integer.toString(i)+"% Server Serteing............");
            mainPanel.jProgressBar1.setValue(i);
           // mainPanel.jProgressBar1.setValue(i);
          if(i==100){
              mainPanel.setVisible(false);
              //orderManu.setVisible(true);
              mainPanel.jProgressBar1.setEnabled(false);
          }
        }
            
           
        } catch (Exception e) {
                
    }
        
    
     
        
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
//                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
//                    break;

                         UIManager.setLookAndFeel("com.jtattoo.plaf.smart.SmartLookAndFeel");
                        
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MainPanelCher.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainPanelCher.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainPanelCher.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainPanelCher.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainPanelCher().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JLabel CallSenterNametxt;
    public static javax.swing.JPanel LadPanelMain;
    public static javax.swing.JLabel TimeLabel;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton11;
    private javax.swing.JButton jButton12;
    private javax.swing.JButton jButton13;
    private javax.swing.JButton jButton14;
    private javax.swing.JButton jButton15;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    public static org.freixas.jcalendar.JCalendarCombo jCalendarCombo1;
    public static javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel2;
    public static javax.swing.JProgressBar jProgressBar1;
    // End of variables declaration//GEN-END:variables


//private void loadData(){
//        try{
//            ArrayList<CallSenterDTO> allItem =(ArrayList<CallSenterDTO>) MangeCallSenterController.getAllDiliverRiders();
//            if(allItem == null){
//             return ;
//            }
//            for(CallSenterDTO item :allItem){
//                Object[]rowData ={item.getName()};
//                jComboBox1.addItem(item.getName());
//            }
//        } catch (Exception ex) {
//            Logger.getLogger(MainPanelCher.class.getName()).log(Level.SEVERE, null, ex);
//        }
//}
//}
//    public void BindCombo(){
//        DBConnection bConnection = new DBConnection();
//        java.sql.Connection con = bConnection.getConnection();
//        Statement statement;
//        ResultSet rs;
//        
//        
//        try {
//            statement =con.createStatement();
//            rs =statement.executeQuery("SELECT ''")
//        } catch (Exception e) {
//        }
//        
    }


  
