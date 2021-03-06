
import java.awt.*;
import java.rmi.Naming;
import java.util.Date;
import java.util.Vector;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Neha
 */
public class My_Classes extends javax.swing.JPanel {

    /**
     * Creates new form My_Classes
     */
    
    String stu_id="";
    String course="";
    String branch="";
    String year="";
    String sem="";
    DefaultTableModel table;
    public My_Classes(String StuId) {
        initComponents();
        
        stu_id=StuId;
        
        jButton1.setEnabled(false);
        table=(DefaultTableModel)jTable1.getModel();
        int count=table.getRowCount();
        for(int i=count-1;i>=0;i--)
            table.removeRow(i);
          
        try{
            Student_Interface mid2=(Student_Interface)Naming.lookup("rmi://localhost/virtual");
            Vector v=mid2.getFullStudentDetails(stu_id);
            course=v.elementAt(0).toString();
            branch=v.elementAt(1).toString();
            year=v.elementAt(2).toString();
            sem=v.elementAt(3).toString();
            System.out.println(course+" "+branch+" "+year+" "+sem);
            }catch(Exception e)
            {
                JOptionPane.showMessageDialog(this, stu_id+" First "+e);
            }
        try{
            Student_Interface mid=(Student_Interface)Naming.lookup("rmi://localhost/virtual");
            Vector v[]=mid.Search_class(course,branch,year,sem);
            for(int i=0;i<v.length;i++)
            {
                table.addRow(v[i]);
            }
            }catch(Exception e)
            {
                JOptionPane.showMessageDialog(this, e);
            }
      
        
        
        }

                   
    
    public void eButton(int st,int tt)
        {
        //boolean b=false;
        Date d=new Date();
        int h=d.getHours();
        int m=d.getMinutes();
        int s=d.getSeconds();
        int currentTime=(h*60*60)+(m*60)+s;
        //JOptionPane.showMessageDialog(this,"current time "+currentTime);
        int startTime=st;
        //JOptionPane.showMessageDialog(this,"start time " +startTime);
        int totalTime=tt;
        //JOptionPane.showMessageDialog(this,"total time "+totalTime);
        if(currentTime>=startTime&&currentTime<=totalTime)
        {
            jButton1.setEnabled(true);
            //b=true;
        }
        else
        {
            jButton1.setEnabled(false);
            //b=false;
        }
        //return b;
        }
    
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setPreferredSize(new java.awt.Dimension(980, 520));

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Faculity id", "Faculity Name", "Course", "Branch", "Year", "Semester", "Subject", "Study Time", "Duration"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable1.setRowHeight(25);
        jTable1.setRowMargin(2);
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jTable1MousePressed(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        jButton1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jButton1.setText("Goto Class");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imac 27 - Copy.png"))); // NOI18N
        jLabel1.setText("  My Classes");
        jLabel1.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jLabel1.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton1)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 591, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 404, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jTable1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MousePressed
        int row=jTable1.getSelectedRow();
        String start=table.getValueAt(row,7).toString();
        String duration=table.getValueAt(row,8).toString();
        
        String st[]=start.split(":");
        int h1=Integer.parseInt(st[0]);
        int m1=Integer.parseInt(st[1]);
        int s1=Integer.parseInt(st[2]);
        //JOptionPane.showMessageDialog(this,"h1="+h1+"m1="+m1+"s1="+s1);
        String dt[]=duration.split(":");
        int h2=Integer.parseInt(dt[0]);
        int m2=Integer.parseInt(dt[1]);
        int s2=Integer.parseInt(dt[2]);
        //JOptionPane.showMessageDialog(this,"h2="+h2+"m2="+m2+"s2="+s2);
        int h3=h1+h2;
        int m3=m1+m2;
        int s3=s1+s2;
        //JOptionPane.showMessageDialog(this,"h3="+h3+"m3="+m3+"s3="+s3);
       int startTime=(h1*60*60)+(m1*60)+s1;
       int totalTime=(h3*60*60)+(m3*60)+s3;
       this.eButton(startTime,totalTime);
       
       /*boolean b=this.eButton(startTime,totalTime);
        if(b)
            JOptionPane.showMessageDialog(this,b);
        else
            JOptionPane.showMessageDialog(this,b);*/
    }//GEN-LAST:event_jTable1MousePressed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        new Go_to_class(stu_id,jTable1.getValueAt(jTable1.getSelectedRow(),0).toString()).setVisible(true);
        Welcome w=new Welcome(stu_id);
        w.dispose();
        
    }//GEN-LAST:event_jButton1ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
