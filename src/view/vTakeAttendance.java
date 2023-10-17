/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package view;

import dao.AttendanceDAO;
import dao.StudentsDAO;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import models.Attendance;
import models.AttendanceDTO;
import models.Student;
import models.tools.AttendanceHandler;

/**
 *
 * @author usuario
 */
public class vTakeAttendance extends javax.swing.JFrame {

    private StudentsDAO studentsDAO;
    private DefaultTableModel model;
    private AttendanceHandler attendanceHandler;
    private AttendanceDAO attendanceDAO;
    private ArrayList<Attendance> attendanceList;
    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

    public vTakeAttendance() {
    
        attendanceDAO = new AttendanceDAO();
        attendanceHandler = new AttendanceHandler();
        model = new DefaultTableModel() {
            @Override 
            public boolean isCellEditable(int row, int column){
                return false;
            }  
        };
        initComponents();
        
        this.setLocationRelativeTo(null);
        attendancePanel.setVisible(false);
        attendanceTable.setVisible(false);
        
        createTableModel();
        updateTable();
    }
    
    private void updateTable(){
       
        while(model.getRowCount()>0){
            model.removeRow(0); //Borra la lista para cargarla para crearla con la nueva modificacion
        }
        attendanceList = updateList();//Vuelvo a cargar la lista
        
        for(Attendance a : attendanceList){
            Object attendance [] = new Object[5];
            attendance[0] = a.getDate();
            attendance[1] = a.getId();
            attendance[2] = a.getFirstName();
            attendance[3] = a.getLastName();
            attendance[4] = attendanceHandler.convertFromInt(a.getStatus());
            
            model.addRow(attendance);
        }
        attendanceTable.setModel(model);
    }
    
    private void createTableModel(){
        model.addColumn("Date");
        model.addColumn("ID");
        model.addColumn("First name");
        model.addColumn("Last name");
        model.addColumn("Status");
    }
    private ArrayList<Attendance> updateList(){
        ArrayList<AttendanceDTO> newAttendanceList = attendanceDAO.getAllAttendances(lblDate.getText());
        ArrayList<Student> newStudentList = new ArrayList<Student>();
        
        for(AttendanceDTO a : newAttendanceList){
            Student s = new Student();
            s = studentsDAO.getStudentFromId(a.getStudentId());
            System.out.println(s.getId());
            newStudentList.add(s);
        }
        attendanceTable.setVisible(true);
        return attendanceHandler.createAttendances(newStudentList, newAttendanceList);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        attendanceTable = new javax.swing.JTable();
        attendancePanel = new javax.swing.JPanel();
        lbl_id = new javax.swing.JLabel();
        lblFirstName = new javax.swing.JLabel();
        lblLastName = new javax.swing.JLabel();
        lblStatus = new javax.swing.JLabel();
        lblGetId = new javax.swing.JLabel();
        lblGetFirstName = new javax.swing.JLabel();
        lblGetLastName = new javax.swing.JLabel();
        statusComboBox = new javax.swing.JComboBox<>();
        lblDate = new javax.swing.JLabel();
        btnAddStatus = new javax.swing.JButton();
        btnCancel = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        dateChooser = new com.toedter.calendar.JDateChooser();
        btnBack = new javax.swing.JButton();
        btnChangeDate = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        attendanceTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        attendanceTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                attendanceTableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(attendanceTable);

        attendancePanel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 5));

        lbl_id.setText("ID");

        lblFirstName.setText("First name");

        lblLastName.setText("Last name");

        lblStatus.setText("Status");

        lblGetId.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        lblGetFirstName.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        lblGetLastName.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        statusComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Present", "Absent", "Justified" }));
        statusComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                statusComboBoxActionPerformed(evt);
            }
        });

        lblDate.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lblDate.setForeground(new java.awt.Color(0, 0, 0));
        lblDate.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblDate.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        btnAddStatus.setText("Add status");
        btnAddStatus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddStatusActionPerformed(evt);
            }
        });

        btnCancel.setText("Cancel");
        btnCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout attendancePanelLayout = new javax.swing.GroupLayout(attendancePanel);
        attendancePanel.setLayout(attendancePanelLayout);
        attendancePanelLayout.setHorizontalGroup(
            attendancePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, attendancePanelLayout.createSequentialGroup()
                .addContainerGap(35, Short.MAX_VALUE)
                .addComponent(lblDate, javax.swing.GroupLayout.PREFERRED_SIZE, 282, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25))
            .addGroup(attendancePanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(attendancePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnAddStatus, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(attendancePanelLayout.createSequentialGroup()
                        .addGroup(attendancePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(attendancePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(lbl_id, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(lblFirstName, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(lblLastName, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(attendancePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblGetId, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblGetFirstName, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblGetLastName, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(statusComboBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addComponent(btnCancel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        attendancePanelLayout.setVerticalGroup(
            attendancePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(attendancePanelLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(lblDate, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(attendancePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblGetId, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbl_id, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(attendancePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lblGetFirstName, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblFirstName, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(attendancePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblLastName, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblGetLastName, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(attendancePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(statusComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnAddStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnCancel, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(85, 85, 85))
        );

        jLabel1.setText("Choose date");
        jLabel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        dateChooser.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                dateChooserMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                dateChooserMouseEntered(evt);
            }
        });
        dateChooser.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                dateChooserPropertyChange(evt);
            }
        });

        btnBack.setText("Back");
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });

        btnChangeDate.setText("Change date");
        btnChangeDate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnChangeDateActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 729, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(attendancePanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnBack, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(dateChooser, javax.swing.GroupLayout.PREFERRED_SIZE, 265, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnChangeDate)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(dateChooser, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
                    .addComponent(btnChangeDate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 555, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(attendancePanel, javax.swing.GroupLayout.PREFERRED_SIZE, 425, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnBack, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void attendanceTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_attendanceTableMouseClicked
        int fila = attendanceTable.getSelectedRow();
        lblGetId.setText(attendanceTable.getValueAt(fila, 1).toString());
        lblGetFirstName.setText(attendanceTable.getValueAt(fila, 2).toString());
        lblGetLastName.setText(attendanceTable.getValueAt(fila, 3).toString());
        SimpleDateFormat date = new SimpleDateFormat("dd/MM/yyyy");
        lblDate.setText(date.format(dateChooser.getCalendar().getTime()));
        attendancePanel.setVisible(true);
    }//GEN-LAST:event_attendanceTableMouseClicked

    private void statusComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_statusComboBoxActionPerformed
        
    }//GEN-LAST:event_statusComboBoxActionPerformed

    private void btnAddStatusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddStatusActionPerformed
        try{
            int studentId = Integer.parseInt(lblGetId.getText());
            String date = lblDate.getText();
            String attendanceBox = (String) statusComboBox.getSelectedItem();
            int attendanceStatus = attendanceHandler.convertFromString(attendanceBox);
                      
            AttendanceDTO attendanceDTO = new AttendanceDTO(studentId, date, attendanceStatus);
            
            attendanceDTO.setStudentId(studentId);
            attendanceDTO.setDate(date);
            attendanceDTO.setAttendaceStatus(attendanceStatus);
            
            if(attendanceDAO.addStatus(attendanceDTO)){
            JOptionPane.showMessageDialog(null, "Student added succesfully");
            updateTable();
            }
            else{
            JOptionPane.showMessageDialog(null, "Error");
            }
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Fatal error");
            e.printStackTrace();
        }
    }//GEN-LAST:event_btnAddStatusActionPerformed

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        vTakeAttendance window = new vTakeAttendance();
        window.setVisible(false);
        this.dispose();
    }//GEN-LAST:event_btnBackActionPerformed

    private void dateChooserMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_dateChooserMouseClicked
        
    }//GEN-LAST:event_dateChooserMouseClicked

    private void dateChooserMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_dateChooserMouseEntered
        
    }//GEN-LAST:event_dateChooserMouseEntered

    private void dateChooserPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_dateChooserPropertyChange
        attendanceTable.setVisible(true);
    }//GEN-LAST:event_dateChooserPropertyChange

    private void btnCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelActionPerformed
        attendancePanel.setVisible(false);
        updateTable();
    }//GEN-LAST:event_btnCancelActionPerformed

    private void btnChangeDateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnChangeDateActionPerformed
        attendanceTable.setVisible(true);
        updateTable();
    }//GEN-LAST:event_btnChangeDateActionPerformed

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
            java.util.logging.Logger.getLogger(vTakeAttendance.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(vTakeAttendance.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(vTakeAttendance.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(vTakeAttendance.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new vTakeAttendance().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel attendancePanel;
    private javax.swing.JTable attendanceTable;
    private javax.swing.JButton btnAddStatus;
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnCancel;
    private javax.swing.JButton btnChangeDate;
    private com.toedter.calendar.JDateChooser dateChooser;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblDate;
    private javax.swing.JLabel lblFirstName;
    private javax.swing.JLabel lblGetFirstName;
    private javax.swing.JLabel lblGetId;
    private javax.swing.JLabel lblGetLastName;
    private javax.swing.JLabel lblLastName;
    private javax.swing.JLabel lblStatus;
    private javax.swing.JLabel lbl_id;
    private javax.swing.JComboBox<String> statusComboBox;
    // End of variables declaration//GEN-END:variables
}
