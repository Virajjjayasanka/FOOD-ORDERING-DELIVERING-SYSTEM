/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.DiliverSystem.view.Casher;


import java.awt.Color;
import java.awt.event.KeyEvent;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import lk.ijse.DiliverSystem.controller.ManageCustomerController;
import lk.ijse.DiliverSystem.controller.ManageTakeOrderController;
import lk.ijse.DiliverSystem.dto.CustomerDTO;
import lk.ijse.DiliverSystem.dto.TakeOrderDTO;
import lk.ijse.DiliverSystem.observer.Observer;
import lk.ijse.DiliverSystem.controller.ManageCustomerDetailControoler;
import lk.ijse.DiliverSystem.controller.ManageOrderDitalController;
import lk.ijse.DiliverSystem.controller.MangeSubmitOrderController;
import lk.ijse.DiliverSystem.dto.AddCustomerDetailsDTO;
import lk.ijse.DiliverSystem.dto.OrderDitailsDTO;
import lk.ijse.DiliverSystem.dto.SubmitOrderDTO;


/**
 *
 * @author Viraj jayasanka
 */
public class AddCustomerPanel extends javax.swing.JPanel implements Observer{
    private boolean update = false;
   // private String reserId = "";
    
    
    /**
     * Creates new form AddCustomerPanel
     */
    public AddCustomerPanel() {
         initComponents();
         loadAllCustomerss();
         loadAlLNameCustomer();
         Valdsion1();
      /// jPanel1.setBackground(new Color(228,239,186,110));
       
         
           try {
            UnicastRemoteObject.exportObject(this, 0);
               ManageCustomerController.getSubject().registerObserver(this);
               ManageTakeOrderController.getSubject().registerObserver(this);
        } catch (Exception ex) {
          Logger.getLogger(AddCustomerPanel.class.getName()).log(Level.SEVERE, null, ex);
          
             }


    }
   
     private void loadAllCustomerss(){

        DefaultTableModel dtm = (DefaultTableModel) OrderTabelAddCustomerPanel.getModel();
        dtm.setRowCount(0);

             try {

                 
            List<TakeOrderDTO> SenterDTOs = ManageTakeOrderController.QureTakeOrder(lk.ijse.DiliverSystem.View.Casher.MainPanelCher.CallSenterNametxt.getText());
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
            Logger.getLogger(orderDetalTabel.class.getName()).log(Level.SEVERE, null, ex);
     }
 }
     
//     private void loadAllCustomersss(){
//
//        DefaultTableModel dtm = (DefaultTableModel) AddCustomerPanelCustomerTabele.getModel();
//        dtm.setRowCount(0);
//
//             try {
//                           
//            List<CustomerDTO> SenterDTOs = ManageCustomerController.getAllCustomers();
//            
//            if (SenterDTOs == null) {
//                return;
//            }
//
//            for (CustomerDTO callSenterDTO : SenterDTOs) {
//                Object[] rowData = {
//                    callSenterDTO.getCustomerID(),
//                    callSenterDTO.getOrderID(),
//                    callSenterDTO.getTeleponeOperterName(),
//                    callSenterDTO.getCustomerName(),
//                    callSenterDTO.getCustomerAddress(),
//                    callSenterDTO.getCustomerTelePoneNO(),
//                    callSenterDTO.getOtherTelePoneNO(),
//                    callSenterDTO.getStringNote(),           
//                    callSenterDTO.getDate(),
//                    callSenterDTO.getTime()
//                };
//                dtm.addRow(rowData);
//               //System.out.print(dtm);
//            }
//
//        } catch (Exception ex) {
//            Logger.getLogger(AddCustomerPanel.class.getName()).log(Level.SEVERE, null, ex);
//        }
// }
     
      private void loadAlLNameCustomer(){

        DefaultTableModel dtm = (DefaultTableModel) AddCustomerPanelCustomerTabele.getModel();
        dtm.setRowCount(0);

             try {
                           
            List<CustomerDTO> SenterDTOs = ManageCustomerController.CustomerNAmeALL(lk.ijse.DiliverSystem.View.Casher.MainPanelCher.CallSenterNametxt.getText());
            
            if (SenterDTOs == null) {
                return;
            }

            for (CustomerDTO callSenterDTO : SenterDTOs) {
                Object[] rowData = {
                    callSenterDTO.getCustomerID(),
                    callSenterDTO.getOrderID(),
                    callSenterDTO.getTeleponeOperterName(),
                    callSenterDTO.getCustomerName(),
                    callSenterDTO.getCustomerAddress(),
                    callSenterDTO.getCustomerTelePoneNO(),
                    callSenterDTO.getOtherTelePoneNO(),
                    callSenterDTO.getStringNote(),           
                    callSenterDTO.getDate(),
                    callSenterDTO.getTime()
                };
                dtm.addRow(rowData);
               //System.out.print(dtm);
            }

        } catch (Exception ex) {
            Logger.getLogger(AddCustomerPanel.class.getName()).log(Level.SEVERE, null, ex);
        }
      }
    
private void Viledashen3(){
         DeleteBtn.setEnabled(true);
         Savebtn.setEnabled(true);
         remobtn.setEnabled(true);
         searchbtn.setEnabled(true);
}
       
      private void Valdsion1(){
          txtCustomerName.setEditable(false);
          txtCustomerAddress.setEditable(false);
          jTextAryNotes.setEditable(false);
          txtTeleponeNO.setEditable(false);
          txtAtherNo.setEditable(false);
          AddCustomerBtn.setEnabled(false);
          RemoAll.setEnabled(false);
          AddCustomerPanelCustomerTabele.setEnabled(false);
          DeleteBtn.setEnabled(false);
          Savebtn.setEnabled(false);
          remobtn.setEnabled(false);
               
              
      }
      
    private void valisdashonTrue(){
         txtCustomerName.setEditable(true);
         txtCustomerAddress.setEditable(true);
         jTextAryNotes.setEditable(true);
         txtTeleponeNO.setEditable(true);
         txtAtherNo.setEditable(true);
         AddCustomerBtn.setEnabled(true);
         RemoAll.setEnabled(true);
         AddCustomerPanelCustomerTabele.setEnabled(true);
         
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
        txtCustomerName = new javax.swing.JTextField();
        txtCustomerAddress = new javax.swing.JTextField();
        txtAtherNo = new javax.swing.JTextField();
        AddCustomerBtn = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        AddCustomerPanelCustomerTabele = new javax.swing.JTable();
        Savebtn = new javax.swing.JButton();
        txtTeleponeNO = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTextAryNotes = new javax.swing.JTextArea();
        RemoAll = new javax.swing.JButton();
        totaltxt = new javax.swing.JButton();
        jScrollPane4 = new javax.swing.JScrollPane();
        OrderTabelAddCustomerPanel = new javax.swing.JTable();
        DeleteBtn = new javax.swing.JButton();
        remobtn = new javax.swing.JButton();
        searchbtn = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton9 = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        txtCustomeriD = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel15 = new javax.swing.JLabel();
        txtTotal = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        txtSubtotal = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        txtpayment = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        txtDis = new javax.swing.JLabel();
        txtDelveryChes = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        jLabel24 = new javax.swing.JLabel();
        txtName = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        txtAddress = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        txtOtherNO = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        txtTextAriya = new javax.swing.JLabel();
        txtTelponeNO = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("sansserif", 1, 12)); // NOI18N
        jLabel2.setText("Customer Name");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 250, -1, -1));

        jLabel3.setFont(new java.awt.Font("sansserif", 1, 12)); // NOI18N
        jLabel3.setText("Address");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 260, -1, -1));

        jLabel4.setFont(new java.awt.Font("sansserif", 1, 12)); // NOI18N
        jLabel4.setText("Notes");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 260, -1, -1));

        txtCustomerName.setFont(new java.awt.Font("sansserif", 1, 12)); // NOI18N
        txtCustomerName.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtCustomerName.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        txtCustomerName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCustomerNameActionPerformed(evt);
            }
        });
        jPanel1.add(txtCustomerName, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 250, 200, 30));

        txtCustomerAddress.setFont(new java.awt.Font("sansserif", 1, 12)); // NOI18N
        txtCustomerAddress.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtCustomerAddress.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        txtCustomerAddress.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCustomerAddressActionPerformed(evt);
            }
        });
        jPanel1.add(txtCustomerAddress, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 250, 210, 30));

        txtAtherNo.setFont(new java.awt.Font("sansserif", 1, 12)); // NOI18N
        txtAtherNo.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtAtherNo.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        txtAtherNo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtAtherNoKeyTyped(evt);
            }
        });
        jPanel1.add(txtAtherNo, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 310, 210, 30));

        AddCustomerBtn.setFont(new java.awt.Font("sansserif", 1, 12)); // NOI18N
        AddCustomerBtn.setText("Add Customer");
        AddCustomerBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddCustomerBtnActionPerformed(evt);
            }
        });
        jPanel1.add(AddCustomerBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(1030, 300, 170, 40));

        jLabel5.setFont(new java.awt.Font("sansserif", 3, 18)); // NOI18N
        jLabel5.setText("Add Customer");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 20, 170, -1));

        AddCustomerPanelCustomerTabele.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "order Id", "T.O.N", " Name", " Address", " Telepone NO", "ather Number", "textAriya"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        AddCustomerPanelCustomerTabele.setSelectionBackground(java.awt.SystemColor.textHighlight);
        AddCustomerPanelCustomerTabele.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                AddCustomerPanelCustomerTabeleMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(AddCustomerPanelCustomerTabele);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 380, 1180, 100));

        Savebtn.setBackground(new java.awt.Color(153, 153, 153));
        Savebtn.setFont(new java.awt.Font("sansserif", 1, 12)); // NOI18N
        Savebtn.setText("Sublit Order");
        Savebtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SavebtnActionPerformed(evt);
            }
        });
        jPanel1.add(Savebtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(960, 620, 160, 50));

        txtTeleponeNO.setFont(new java.awt.Font("sansserif", 1, 12)); // NOI18N
        txtTeleponeNO.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtTeleponeNO.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        txtTeleponeNO.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTeleponeNOActionPerformed(evt);
            }
        });
        txtTeleponeNO.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtTeleponeNOKeyTyped(evt);
            }
        });
        jPanel1.add(txtTeleponeNO, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 310, 200, 30));

        jLabel6.setFont(new java.awt.Font("sansserif", 1, 12)); // NOI18N
        jLabel6.setText("TelePone NO");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 320, -1, -1));

        jLabel7.setFont(new java.awt.Font("sansserif", 1, 12)); // NOI18N
        jLabel7.setText("Other Number");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 320, -1, -1));

        jTextAryNotes.setColumns(20);
        jTextAryNotes.setRows(5);
        jScrollPane3.setViewportView(jTextAryNotes);

        jPanel1.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 250, 240, 100));

        RemoAll.setFont(new java.awt.Font("sansserif", 1, 12)); // NOI18N
        RemoAll.setText("Delete Order");
        RemoAll.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RemoAllActionPerformed(evt);
            }
        });
        jPanel1.add(RemoAll, new org.netbeans.lib.awtextra.AbsoluteConstraints(1030, 250, 170, 40));

        totaltxt.setIcon(new javax.swing.ImageIcon(getClass().getResource("/lk/ijse/DiliverSystem/image/FontAwesome_f064(0)_50.png"))); // NOI18N
        totaltxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                totaltxtActionPerformed(evt);
            }
        });
        jPanel1.add(totaltxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(1150, 620, 50, 50));

        OrderTabelAddCustomerPanel.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "OID", "T.O.N", "Deli.Ch", "Sub.Total", "Total", "Dicrtpition", "Payment", "Date", "Time"
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
        jScrollPane4.setViewportView(OrderTabelAddCustomerPanel);

        jPanel1.add(jScrollPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, 1180, 100));

        DeleteBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/lk/ijse/DiliverSystem/image/delete customer ican1.png"))); // NOI18N
        DeleteBtn.setText("Delete ");
        DeleteBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DeleteBtnActionPerformed(evt);
            }
        });
        jPanel1.add(DeleteBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 550, 190, 40));

        remobtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/lk/ijse/DiliverSystem/image/ResatAll (2).png"))); // NOI18N
        remobtn.setText("Remo All");
        remobtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                remobtnActionPerformed(evt);
            }
        });
        jPanel1.add(remobtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 550, 180, 40));

        searchbtn.setBackground(new java.awt.Color(0, 153, 204));
        searchbtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/lk/ijse/DiliverSystem/image/linecons_e009(0)_50.png"))); // NOI18N
        searchbtn.setText("Search Customer ");
        searchbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchbtnActionPerformed(evt);
            }
        });
        jPanel1.add(searchbtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 550, 190, 40));

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/lk/ijse/DiliverSystem/image/Entypo_d83d(0)_50.png"))); // NOI18N
        jButton2.setText("Dilevery Roles");
        jPanel1.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 550, 200, 40));

        jButton3.setText("Help");
        jPanel1.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(850, 550, 180, 40));

        jButton9.setText("Item Price");
        jPanel1.add(jButton9, new org.netbeans.lib.awtextra.AbsoluteConstraints(1050, 550, 150, 40));

        jLabel9.setFont(new java.awt.Font("sansserif", 1, 12)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(153, 153, 153));
        jLabel9.setText("Order ID");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 190, -1, -1));

        jLabel10.setFont(new java.awt.Font("sansserif", 1, 12)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 0, 51));
        jLabel10.setText("order ID");
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 190, -1, -1));

        jLabel11.setFont(new java.awt.Font("sansserif", 1, 12)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(153, 153, 153));
        jLabel11.setText("Customer Id");
        jPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 510, -1, -1));

        txtCustomeriD.setFont(new java.awt.Font("sansserif", 1, 12)); // NOI18N
        txtCustomeriD.setForeground(new java.awt.Color(255, 0, 51));
        txtCustomeriD.setText("Customer Id");
        jPanel1.add(txtCustomeriD, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 510, -1, -1));

        jSeparator1.setBackground(new java.awt.Color(153, 153, 153));
        jSeparator1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jSeparator1.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N
        jPanel1.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 500, 1180, 30));

        jLabel15.setFont(new java.awt.Font("sansserif", 1, 12)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(153, 153, 153));
        jLabel15.setText("Deleveryches");
        jPanel1.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 190, -1, -1));

        txtTotal.setFont(new java.awt.Font("sansserif", 1, 12)); // NOI18N
        txtTotal.setForeground(new java.awt.Color(102, 102, 102));
        txtTotal.setText("Total");
        jPanel1.add(txtTotal, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 190, 60, -1));

        jLabel17.setFont(new java.awt.Font("sansserif", 1, 12)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(153, 153, 153));
        jLabel17.setText("Sub Total");
        jPanel1.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 190, -1, -1));

        txtSubtotal.setFont(new java.awt.Font("sansserif", 1, 12)); // NOI18N
        txtSubtotal.setForeground(new java.awt.Color(102, 102, 102));
        txtSubtotal.setText("Sub Total");
        jPanel1.add(txtSubtotal, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 190, -1, -1));

        jLabel19.setFont(new java.awt.Font("sansserif", 1, 12)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(153, 153, 153));
        jLabel19.setText("Total");
        jPanel1.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 190, -1, -1));

        txtpayment.setFont(new java.awt.Font("sansserif", 1, 12)); // NOI18N
        txtpayment.setForeground(new java.awt.Color(102, 102, 102));
        txtpayment.setText("Discription");
        jPanel1.add(txtpayment, new org.netbeans.lib.awtextra.AbsoluteConstraints(890, 190, -1, -1));

        jLabel21.setFont(new java.awt.Font("sansserif", 1, 12)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(153, 153, 153));
        jLabel21.setText("Payemnt");
        jPanel1.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(1010, 190, -1, -1));

        jLabel22.setFont(new java.awt.Font("sansserif", 1, 12)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(153, 153, 153));
        jLabel22.setText("Discription");
        jPanel1.add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 190, -1, -1));

        txtDis.setFont(new java.awt.Font("sansserif", 1, 12)); // NOI18N
        txtDis.setForeground(new java.awt.Color(102, 102, 102));
        txtDis.setText("Payement");
        jPanel1.add(txtDis, new org.netbeans.lib.awtextra.AbsoluteConstraints(1080, 190, -1, -1));

        txtDelveryChes.setFont(new java.awt.Font("sansserif", 1, 12)); // NOI18N
        txtDelveryChes.setForeground(new java.awt.Color(102, 102, 102));
        txtDelveryChes.setText("DelveryChes");
        jPanel1.add(txtDelveryChes, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 190, -1, -1));

        jSeparator2.setBackground(new java.awt.Color(153, 153, 153));
        jSeparator2.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jSeparator2.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N
        jPanel1.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 180, 1180, 30));

        jLabel24.setFont(new java.awt.Font("sansserif", 1, 12)); // NOI18N
        jLabel24.setForeground(new java.awt.Color(153, 153, 153));
        jLabel24.setText("Name");
        jPanel1.add(jLabel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 510, -1, -1));

        txtName.setFont(new java.awt.Font("sansserif", 1, 12)); // NOI18N
        txtName.setForeground(new java.awt.Color(102, 102, 102));
        txtName.setText("Name");
        jPanel1.add(txtName, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 510, 70, -1));

        jLabel26.setFont(new java.awt.Font("sansserif", 1, 12)); // NOI18N
        jLabel26.setForeground(new java.awt.Color(153, 153, 153));
        jLabel26.setText("Address");
        jPanel1.add(jLabel26, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 510, -1, -1));

        txtAddress.setFont(new java.awt.Font("sansserif", 1, 12)); // NOI18N
        txtAddress.setForeground(new java.awt.Color(102, 102, 102));
        txtAddress.setText("Address");
        jPanel1.add(txtAddress, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 510, -1, -1));

        jLabel28.setFont(new java.awt.Font("sansserif", 1, 12)); // NOI18N
        jLabel28.setForeground(new java.awt.Color(153, 153, 153));
        jLabel28.setText("TeponeNO");
        jPanel1.add(jLabel28, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 510, -1, -1));

        jLabel29.setFont(new java.awt.Font("sansserif", 1, 12)); // NOI18N
        jLabel29.setForeground(new java.awt.Color(153, 153, 153));
        jLabel29.setText("OtherNO");
        jPanel1.add(jLabel29, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 510, -1, -1));

        txtOtherNO.setFont(new java.awt.Font("sansserif", 1, 12)); // NOI18N
        txtOtherNO.setForeground(new java.awt.Color(102, 102, 102));
        txtOtherNO.setText("Othet NO");
        jPanel1.add(txtOtherNO, new org.netbeans.lib.awtextra.AbsoluteConstraints(920, 510, -1, -1));

        jLabel31.setFont(new java.awt.Font("sansserif", 1, 12)); // NOI18N
        jLabel31.setForeground(new java.awt.Color(153, 153, 153));
        jLabel31.setText("TxtAriya");
        jPanel1.add(jLabel31, new org.netbeans.lib.awtextra.AbsoluteConstraints(1030, 510, -1, -1));

        txtTextAriya.setFont(new java.awt.Font("sansserif", 1, 12)); // NOI18N
        txtTextAriya.setForeground(new java.awt.Color(102, 102, 102));
        txtTextAriya.setText("Txtariya");
        jPanel1.add(txtTextAriya, new org.netbeans.lib.awtextra.AbsoluteConstraints(1100, 510, 90, -1));

        txtTelponeNO.setFont(new java.awt.Font("sansserif", 1, 12)); // NOI18N
        txtTelponeNO.setForeground(new java.awt.Color(102, 102, 102));
        txtTelponeNO.setText("TeleponeNO");
        jPanel1.add(txtTelponeNO, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 510, -1, -1));

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/lk/ijse/DiliverSystem/image/Entypo_e712(0)_50.png"))); // NOI18N
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 620, 50, 50));

        add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1230, 710));
    }// </editor-fold>//GEN-END:initComponents

    private void OrderTabelAddCustomerPanelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_OrderTabelAddCustomerPanelMouseClicked

        String OrderID  = OrderTabelAddCustomerPanel.getValueAt(OrderTabelAddCustomerPanel.getSelectedRow(), 0).toString();
        String DeleverChes  = OrderTabelAddCustomerPanel.getValueAt(OrderTabelAddCustomerPanel.getSelectedRow(), 2).toString();
        String SubTotal  = OrderTabelAddCustomerPanel.getValueAt(OrderTabelAddCustomerPanel.getSelectedRow(), 3).toString();
        String Total  = OrderTabelAddCustomerPanel.getValueAt(OrderTabelAddCustomerPanel.getSelectedRow(), 4).toString();
        String Discrption  = OrderTabelAddCustomerPanel.getValueAt(OrderTabelAddCustomerPanel.getSelectedRow(), 6).toString();
        String Payment  = OrderTabelAddCustomerPanel.getValueAt(OrderTabelAddCustomerPanel.getSelectedRow(), 5).toString();
          
        AddCustomerPanel. jLabel10.setText( OrderID);
        AddCustomerPanel.txtDelveryChes.setText(DeleverChes);       
        AddCustomerPanel.txtSubtotal.setText(SubTotal);      
        AddCustomerPanel.txtTotal.setText(Total);     
        AddCustomerPanel.txtDis.setText(Discrption); 
        AddCustomerPanel.txtpayment.setText(Payment);
        
         
         if(true){
               valisdashonTrue();
         }else{
              Valdsion1();
         }
        

    }//GEN-LAST:event_OrderTabelAddCustomerPanelMouseClicked

    private void totaltxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_totaltxtActionPerformed
        lk.ijse.DiliverSystem.View.Casher.MainPanelCher.LadPanelMain.removeAll();
        lk.ijse.DiliverSystem.View.Casher.MainPanelCher.LadPanelMain.setVisible(true);
        PadingOrder order= new PadingOrder();
        order.setSize(lk.ijse.DiliverSystem.View.Casher.MainPanelCher.LadPanelMain.getSize());
        lk.ijse.DiliverSystem.View.Casher.MainPanelCher.LadPanelMain.add(order);
        lk.ijse.DiliverSystem.View.Casher.MainPanelCher.LadPanelMain.repaint();
        lk.ijse.DiliverSystem.View.Casher.MainPanelCher.LadPanelMain.revalidate();
    }//GEN-LAST:event_totaltxtActionPerformed

    private void RemoAllActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RemoAllActionPerformed
        try {
            boolean Abc = ManageTakeOrderController.deleteTakeOrder(Integer.parseInt(jLabel10.getText()));
            if(Abc){
                JOptionPane.showMessageDialog(this, "Delete is UnSusscess");
            }else{
                 JOptionPane.showMessageDialog(this, "Delete is Susscess");
            }
             Valdsion1();
             ClaerFels();
        } catch (Exception ex) {
            Logger.getLogger(AddCustomerPanel.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_RemoAllActionPerformed

    private void SavebtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SavebtnActionPerformed
       AddCustomerDetailsDTO addCustomerDetailsDTO = new AddCustomerDetailsDTO(
               jLabel10.getText(),
               txtCustomeriD.getText(),
               txtName.getText(),
               txtAddress.getText(),
               Integer.parseInt(txtTelponeNO.getText()),
               Integer.parseInt(txtAtherNo.getText()),
               lk.ijse.DiliverSystem.View.Casher.MainPanelCher.TimeLabel.getText(),
               lk.ijse.DiliverSystem.View.Casher.MainPanelCher.jCalendarCombo1.getSelectedItem().toString()
 
        );
        SubmitOrderDTO submitOrderDTO = new SubmitOrderDTO(
                jLabel10.getText(),
                lk.ijse.DiliverSystem.View.Casher.MainPanelCher.CallSenterNametxt.getText(),
                txtCustomeriD.getText(),
                txtTotal.getText(),
                txtpayment.getText(),
                lk.ijse.DiliverSystem.View.Casher.MainPanelCher.TimeLabel.getText(),
                lk.ijse.DiliverSystem.View.Casher.MainPanelCher.jCalendarCombo1.getSelectedItem().toString()
        
        );
        OrderDitailsDTO orderDitailsDTO = new OrderDitailsDTO(
                jLabel10.getText(),
                txtCustomeriD.getText(),
                lk.ijse.DiliverSystem.View.Casher.MainPanelCher.CallSenterNametxt.getText(),
                Double.parseDouble(txtDelveryChes.getText()),
                Double.parseDouble(txtTotal.getText()),
                lk.ijse.DiliverSystem.View.Casher.MainPanelCher.jCalendarCombo1.getSelectedItem().toString(),
                lk.ijse.DiliverSystem.View.Casher.MainPanelCher.TimeLabel.getText()
       
        );
       
       
        try{
            boolean OrderDatilsAdd = ManageOrderDitalController.addOrderDital(orderDitailsDTO);
            boolean customerAdd = ManageCustomerDetailControoler.addCustomerDetail(addCustomerDetailsDTO);
            boolean SubOrderAdd = MangeSubmitOrderController.addSubmitOrder(submitOrderDTO);
        
            if(customerAdd){
                 JOptionPane.showMessageDialog(this, "Order  has been saved successfully");
            }else{
                 JOptionPane.showMessageDialog(this, "Order  has been saved Unsuccessfully");
            }
        }catch(Exception e){
            
        }
        try {
            boolean result = ManageCustomerController.deleteCustomer(Integer.parseInt(txtCustomeriD.getText()) );
            boolean Abc = ManageTakeOrderController.deleteTakeOrder(Integer.parseInt(jLabel10.getText()));

            //AddCustomerPanelCustomerTabele.clearSelection();
            OrderTabelAddCustomerPanel.requestFocusInWindow();
            AddCustomerPanelCustomerTabele.requestFocusInWindow();
            ClerFeldSaveOrder();
            clearAllTextFields();
            ClaerFels();
            Valdsion1();
           
        } catch (Exception ex) {
            Logger.getLogger(AddCustomerPanel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_SavebtnActionPerformed

    private void AddCustomerPanelCustomerTabeleMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_AddCustomerPanelCustomerTabeleMouseClicked
        Viledashen3();
        String customerId  = AddCustomerPanelCustomerTabele.getValueAt(AddCustomerPanelCustomerTabele.getSelectedRow(), 0).toString();
        String name  = AddCustomerPanelCustomerTabele.getValueAt(AddCustomerPanelCustomerTabele.getSelectedRow(), 3).toString();
        String address  = AddCustomerPanelCustomerTabele.getValueAt(AddCustomerPanelCustomerTabele.getSelectedRow(), 4).toString();
        String TelponeNO  = AddCustomerPanelCustomerTabele.getValueAt(AddCustomerPanelCustomerTabele.getSelectedRow(), 5).toString();
        String otherNo  = AddCustomerPanelCustomerTabele.getValueAt(AddCustomerPanelCustomerTabele.getSelectedRow(), 6).toString();
        String TxtAriya  = AddCustomerPanelCustomerTabele.getValueAt(AddCustomerPanelCustomerTabele.getSelectedRow(), 7).toString();
   
        AddCustomerPanel. txtCustomeriD.setText(customerId);
        AddCustomerPanel.txtName.setText(name);       
        AddCustomerPanel.txtAddress.setText(address);      
        AddCustomerPanel.txtTelponeNO.setText(TelponeNO);     
        AddCustomerPanel.txtOtherNO.setText(otherNo); 
        AddCustomerPanel.txtTextAriya.setText(TxtAriya);
        
        AddCustomerPanel.txtCustomerName.setText(name);
        AddCustomerPanel.txtCustomerAddress.setText(address);          
        AddCustomerPanel.txtTeleponeNO.setText(TelponeNO);     
        AddCustomerPanel.txtAtherNo.setText(otherNo); 
        AddCustomerPanel.jTextAryNotes.setText(TxtAriya);

    }//GEN-LAST:event_AddCustomerPanelCustomerTabeleMouseClicked

    private void AddCustomerBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddCustomerBtnActionPerformed
  
        CustomerDTO customerDTO = new CustomerDTO(
            jLabel10.getText(),
            lk.ijse.DiliverSystem.View.Casher.MainPanelCher.CallSenterNametxt.getText(),
            txtCustomerName.getText(),
            txtCustomerAddress.getText(),
            Integer.parseInt(txtTeleponeNO.getText()),
            Integer.parseInt(txtAtherNo.getText()),
            jTextAryNotes.getText(),
            lk.ijse.DiliverSystem.View.Casher.MainPanelCher.TimeLabel.getText(),
            lk.ijse.DiliverSystem.View.Casher.MainPanelCher.jCalendarCombo1.getSelectedItem().toString()

        );

        try {

            boolean result = false;
            if (!update) {
                result = ManageCustomerController.addCustomer(customerDTO);
            } else {
                result = ManageCustomerController.updateCustomer(customerDTO);
            }
            if (result) {
                JOptionPane.showMessageDialog(this, "Customer has been saved successfully");
            } else {
                JOptionPane.showMessageDialog(this, "Failed to save the customer");
            }
             AddCustomerPanelCustomerTabele.requestFocusInWindow();
            update = false;
        } catch (Exception ex) {
            Logger.getLogger(AddCustomerPanel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_AddCustomerBtnActionPerformed

    private void txtCustomerAddressActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCustomerAddressActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCustomerAddressActionPerformed

    private void txtCustomerNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCustomerNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCustomerNameActionPerformed

    private void OrderTabelAddCustomerPanelMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_OrderTabelAddCustomerPanelMouseExited
         // Valdsion1();
    }//GEN-LAST:event_OrderTabelAddCustomerPanelMouseExited

    private void remobtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_remobtnActionPerformed
      
        if(JOptionPane.showConfirmDialog(this,"Comfrom cler Filed ","ClerFeld Error",
            JOptionPane.YES_NO_OPTION)==JOptionPane.YES_NO_OPTION){
             clearAllTextFields();
        }
    }//GEN-LAST:event_remobtnActionPerformed

    private void DeleteBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DeleteBtnActionPerformed
       if(JOptionPane.showConfirmDialog(this,"Comfrom Delte Customer","Customer Delte Excuze",
            JOptionPane.YES_NO_OPTION)==JOptionPane.YES_NO_OPTION){
          
           try {
               boolean result = ManageCustomerController.deleteCustomer(Integer.parseInt(txtCustomeriD.getText()) );
           } catch (Exception ex) {
               Logger.getLogger(AddCustomerPanel.class.getName()).log(Level.SEVERE, null, ex);
           }
             
            AddCustomerPanelCustomerTabele.requestFocusInWindow();
            ClerFeldSaveOrder();          
            DeleteBtn.setEnabled(false);
            remobtn.setEnabled(false);
            clearAllTextFields();
        }   
        
    }//GEN-LAST:event_DeleteBtnActionPerformed

    private void txtTeleponeNOActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTeleponeNOActionPerformed
       
    }//GEN-LAST:event_txtTeleponeNOActionPerformed

    private void txtTeleponeNOKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTeleponeNOKeyTyped
        NameMathed(evt);
    }//GEN-LAST:event_txtTeleponeNOKeyTyped

    private void txtAtherNoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtAtherNoKeyTyped
        NameMathed(evt);
    }//GEN-LAST:event_txtAtherNoKeyTyped

    private void searchbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchbtnActionPerformed
    SearchCustomer sendItemSet = new SearchCustomer();
         sendItemSet.setVisible(true);
    }//GEN-LAST:event_searchbtnActionPerformed
 
        

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton AddCustomerBtn;
    private javax.swing.JTable AddCustomerPanelCustomerTabele;
    private javax.swing.JButton DeleteBtn;
    private javax.swing.JTable OrderTabelAddCustomerPanel;
    private javax.swing.JButton RemoAll;
    private javax.swing.JButton Savebtn;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton9;
    public static javax.swing.JLabel jLabel10;
    protected static javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    public static javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    public static javax.swing.JTextArea jTextAryNotes;
    private javax.swing.JButton remobtn;
    private javax.swing.JButton searchbtn;
    private javax.swing.JButton totaltxt;
    public static javax.swing.JLabel txtAddress;
    public static javax.swing.JTextField txtAtherNo;
    public static javax.swing.JTextField txtCustomerAddress;
    public static javax.swing.JTextField txtCustomerName;
    public static javax.swing.JLabel txtCustomeriD;
    public static javax.swing.JLabel txtDelveryChes;
    public static javax.swing.JLabel txtDis;
    public static javax.swing.JLabel txtName;
    public static javax.swing.JLabel txtOtherNO;
    public static javax.swing.JLabel txtSubtotal;
    public static javax.swing.JTextField txtTeleponeNO;
    public static javax.swing.JLabel txtTelponeNO;
    public static javax.swing.JLabel txtTextAriya;
    public static javax.swing.JLabel txtTotal;
    public static javax.swing.JLabel txtpayment;
    // End of variables declaration//GEN-END:variables


    @Override
    public void updateObservers() throws Exception {
         loadAlLNameCustomer();
         loadAllCustomerss();
         
         OrderTabelAddCustomerPanel.selectAll();
    }

//ClerFeld
  private void clearAllTextFields() {
        txtCustomerName.setText("");
        txtCustomerAddress.setText("");
        jTextAryNotes.setText("");
        txtTeleponeNO.setText(" ");
        txtAtherNo.setText("");
    }
  private void ClerFeldSaveOrder(){
        txtCustomeriD.setText("Customer Id");
        txtName.setText("Name");       
        txtAddress.setText("Address");      
        txtTelponeNO.setText("TeleponeNO");     
        txtOtherNO.setText("Othet NO"); 
        txtTextAriya.setText("txtTextAriya");
  }   
        
  private void ClaerFels(){      
        jLabel10.setText("order ID");
        txtDelveryChes.setText("DelveryChes");       
        txtSubtotal.setText("Sub Total");      
        txtTotal.setText("Total");     
        txtDis.setText("Discrtion"); 
        txtpayment.setText("Payment");
  
  }
  private void NameMathed(java.awt.event.KeyEvent evt) {                                     
      char number = evt.getKeyChar();
         if(!(Character.isDigit(number))
             ||(number == KeyEvent.VK_BACK_SPACE )
                ||(number == KeyEvent.VK_DELETE )){
                    evt.consume();
            }
    } 
}
