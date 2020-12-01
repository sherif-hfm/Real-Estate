/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package real.estate;

/**
 *
 * @author Sherif
 */

import javax.swing.*;
import java.util.*;
import javax.swing.table.DefaultTableModel;

public class frmContracts extends javax.swing.JFrame {

    /**
     * Creates new form frmContracts
     */
    
    private boolean editMode=false;
    private int rowId;
    
    public frmContracts() {
        initComponents();
        setLocationRelativeTo(null);
        BindTenants();
        BindContractTypes();
        BindData();
    }
    
    private void BindData(){
        BindContracts();
        BindRealEstate();
    }
    
    private void ClearForm(){
        drpTenant.setSelectedItem(null);
        drpRealStates.setSelectedItem(null);
        drpUnits.setSelectedItem(null);
        drpUnits.removeAllItems();
        drpContractType.setSelectedItem(null);
        
        txtStartDate.setText("");
        txtEndDate.setText("");
        txtRent.setText("");
    }
    
    private void  BindContracts(){
        tblData.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
         List<Models.Contract> units=repository.Contracts.GetAllContracts();
        DefaultTableModel model=new javax.swing.table.DefaultTableModel(
            new Object [][] {},
            new String [] {
                "Contract Id", "Unit Desc","Real-Estate Desc","Tenant Name","Contract Type","Start Date","End Date","Amount"
            }
        ){
        public boolean isCellEditable(int rowIndex, int columnIndex) {
                return false;
            }
        };
        units.forEach((row)->{
        model.addRow(row.GetObject());
        });
         tblData.setModel(model);
         tblData.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
    }
    
    public void BindTenants(){
        List<Models.Tenant> data=repository.Tenants.GetAllTenants();
         DefaultComboBoxModel model=new javax.swing.DefaultComboBoxModel<Models.ComboBoxItem>();
         Models.ComboBoxItem r1=new Models.ComboBoxItem(0,"");
         model.addElement(r1);
        data.forEach((row)->{
            Models.ComboBoxItem item=new Models.ComboBoxItem(row.TenantId,row.TenantName);
            model.addElement(item);
        });
        drpTenant.setModel(model);
       
     }
    
    public void BindContractTypes(){
        List<Models.ContractType> data=repository.Contracts.GetContractType();
         DefaultComboBoxModel model=new javax.swing.DefaultComboBoxModel<Models.ComboBoxItem>();
         Models.ComboBoxItem r1=new Models.ComboBoxItem(0,"");
         model.addElement(r1);
        data.forEach((row)->{
            Models.ComboBoxItem item=new Models.ComboBoxItem(row.ContractTypeCode,row.ContractTypeDesc);
            model.addElement(item);
        });
        drpContractType.setModel(model);
       
     }
     
     public void BindRealEstate(){
         List<Models.RealEstate> data=repository.RealEstate.GetAllFreeRealEstates();
         DefaultComboBoxModel model=new javax.swing.DefaultComboBoxModel<Models.ComboBoxItem>();
         Models.ComboBoxItem r1=new Models.ComboBoxItem(0,"");
         model.addElement(r1);
        data.forEach((row)->{
            Models.ComboBoxItem item=new Models.ComboBoxItem(row.RealEstateId,row.RealEstateDesc);
            model.addElement(item);
        });
        drpRealStates.setModel(model);
    }
     
    public void BindUnits(){
        Models.ComboBoxItem realItem=(Models.ComboBoxItem)drpRealStates.getSelectedItem();
        if(realItem == null)
            return;
        List<Models.Unit> data=repository.Units.GetFreeUnitsByRealId(realItem.getId());
         DefaultComboBoxModel model=new javax.swing.DefaultComboBoxModel<Models.ComboBoxItem>();
         Models.ComboBoxItem r1=new Models.ComboBoxItem(0,"");
         model.addElement(r1);
        data.forEach((row)->{
            model.addElement(new Models.ComboBoxItem(row.UnitId,row.UnitDesc));
        });
        drpUnits.setModel(model);
       
     }
    
    private void AddData(){
         Models.Contract data=new Models.Contract();
        data.TenantId=((Models.ComboBoxItem)drpTenant.getSelectedItem()).getId();
        data.RealEstateId=((Models.ComboBoxItem)drpRealStates.getSelectedItem()).getId();
        data.UnitId=((Models.ComboBoxItem)drpUnits.getSelectedItem()).getId();
        data.ContractTypeCode=((Models.ComboBoxItem)drpContractType.getSelectedItem()).getId();
        
        data.StartDate=txtStartDate.getText();
        data.EndDate=txtEndDate.getText();
        data.Amount=Double.parseDouble(txtRent.getText());

        repository.Contracts.AddContract(data);
    }
    
    private void UpdateData(){
         Models.Contract data=new Models.Contract();
        data.ContractId=rowId;
        data.TenantId=((Models.ComboBoxItem)drpTenant.getSelectedItem()).getId();
        data.RealEstateId=((Models.ComboBoxItem)drpRealStates.getSelectedItem()).getId();
        data.UnitId=((Models.ComboBoxItem)drpUnits.getSelectedItem()).getId();
        data.ContractTypeCode=((Models.ComboBoxItem)drpContractType.getSelectedItem()).getId();
        
        data.StartDate=txtStartDate.getText();
        data.EndDate=txtEndDate.getText();
        data.Amount=Double.parseDouble(txtRent.getText());

        repository.Contracts.UpdateContract(data);
    }
    
    private void SetdrpItem(javax.swing.JComboBox drp,int id){
        for(int i=0;i <  drp.getItemCount();i++){
            Object item= drp.getItemAt(i);
            if(item instanceof Models.ComboBoxItem){
                if(((Models.ComboBoxItem)item).getId()==id){
                    drp.setSelectedItem(item);
                    break;
                }
            }
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
        jLabel1 = new javax.swing.JLabel();
        btnCancel = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblData = new javax.swing.JTable();
        drpTenant = new javax.swing.JComboBox<>();
        drpUnits = new javax.swing.JComboBox<>();
        drpRealStates = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        drpContractType = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        txtStartDate = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtEndDate = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txtRent = new javax.swing.JTextField();
        btnSave = new javax.swing.JButton();
        btnEdit = new javax.swing.JButton();
        btnDel = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Contracts");
        setResizable(false);
        setType(java.awt.Window.Type.POPUP);

        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setText("Tenant");

        btnCancel.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnCancel.setText("Cancel");
        btnCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setText("Unit");

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel5.setText("Real Estate");

        tblData.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tblData.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tblData.setFillsViewportHeight(true);
        jScrollPane1.setViewportView(tblData);

        drpTenant.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        drpUnits.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        drpRealStates.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        drpRealStates.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                drpRealStatesActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel4.setText("Contract Type");

        drpContractType.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setText("Start Date");

        txtStartDate.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtStartDate.setToolTipText("");
        txtStartDate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtStartDateActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel6.setText("End Date");

        txtEndDate.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtEndDate.setToolTipText("");
        txtEndDate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtEndDateActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel7.setText("Value");

        txtRent.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtRent.setToolTipText("");
        txtRent.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtRentActionPerformed(evt);
            }
        });

        btnSave.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnSave.setText("Save");
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });

        btnEdit.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnEdit.setText("Edit Row");
        btnEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditActionPerformed(evt);
            }
        });

        btnDel.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnDel.setText("Delete Row");
        btnDel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDelActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel1)
                                    .addComponent(jLabel5))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(drpUnits, 0, 349, Short.MAX_VALUE)
                                    .addComponent(drpRealStates, javax.swing.GroupLayout.Alignment.TRAILING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(drpTenant, javax.swing.GroupLayout.Alignment.TRAILING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(0, 202, Short.MAX_VALUE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(drpContractType, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                            .addComponent(jLabel2)
                                            .addGap(18, 18, 18)
                                            .addComponent(txtStartDate, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addComponent(jLabel4))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel7)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(txtRent, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel6)
                                        .addGap(18, 18, 18)
                                        .addComponent(txtEndDate, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnSave, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(btnDel, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnEdit, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnCancel, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(drpTenant, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(drpRealStates, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(drpUnits, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(drpContractType, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7)
                    .addComponent(txtRent, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(txtStartDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6)
                            .addComponent(txtEndDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(btnSave)
                        .addGap(8, 8, 8)))
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(btnCancel))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(7, 7, 7)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnDel)
                            .addComponent(btnEdit))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtStartDateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtStartDateActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtStartDateActionPerformed

    private void txtEndDateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtEndDateActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtEndDateActionPerformed

    private void txtRentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtRentActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtRentActionPerformed

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        // TODO add your handling code here:
        if(editMode)
        UpdateData();
        else
        AddData();

        BindData();
        ClearForm();
        editMode=false;
    }//GEN-LAST:event_btnSaveActionPerformed

    private void btnEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditActionPerformed
        // TODO add your handling code here:
        ClearForm();
        int row = tblData.getSelectedRow();
        String id = tblData.getModel().getValueAt(row, 0).toString();
        Models.Contract data= repository.Contracts.GetContract(id);
        rowId=data.ContractId;
        SetdrpItem (drpTenant,data.TenantId);
        SetdrpItem (drpContractType,data.ContractTypeCode);
        txtStartDate.setText(data.StartDate);
        txtEndDate.setText(data.EndDate);
        txtRent.setText(Double.toString(data.Amount));
        
        editMode=true;
    }//GEN-LAST:event_btnEditActionPerformed

    private void btnDelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDelActionPerformed
        // TODO add your handling code here:
        int result = JOptionPane.showConfirmDialog(null,"Do you want to delete?", "Real-Estate System",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
        if(result == JOptionPane.NO_OPTION)
            return;
        int row = tblData.getSelectedRow();
        String id = tblData.getModel().getValueAt(row, 0).toString();
        repository.Contracts.DelContract(id);
        System.err.println(id);
        BindData();
    }//GEN-LAST:event_btnDelActionPerformed

    private void btnCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelActionPerformed
        // TODO add your handling code here:
           this.dispose();
    }//GEN-LAST:event_btnCancelActionPerformed

    private void drpRealStatesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_drpRealStatesActionPerformed
        // TODO add your handling code here:
        BindUnits();
    }//GEN-LAST:event_drpRealStatesActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(frmContracts.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmContracts.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmContracts.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmContracts.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmContracts().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancel;
    private javax.swing.JButton btnDel;
    private javax.swing.JButton btnEdit;
    private javax.swing.JButton btnSave;
    private javax.swing.JComboBox<String> drpContractType;
    private javax.swing.JComboBox<String> drpRealStates;
    private javax.swing.JComboBox<String> drpTenant;
    private javax.swing.JComboBox<String> drpUnits;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblData;
    private javax.swing.JTextField txtEndDate;
    private javax.swing.JTextField txtRent;
    private javax.swing.JTextField txtStartDate;
    // End of variables declaration//GEN-END:variables
}
