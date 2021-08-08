
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.util.Vector;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Neha
 */
public class Download extends javax.swing.JPanel {

    /**
     * Creates new form UploadAssignment
     */
String stu_id="";
    int y=30;
    public Download(String StuId) throws NotBoundException {
     initComponents();
     stu_id=StuId;
     try{
     Student_Interface mid=(Student_Interface)Naming.lookup("rmi://localhost/virtual");
     Vector v=mid.download();
     System.out.println(v);
     for(int i=0;i<v.size();i++)
     {
           JLabel l=new JLabel(v.elementAt(i).toString());
           l.setText("<html><a href=\"\">"+v.elementAt(i).toString()+"</a></html>");
           l.addMouseListener(new MouseClass());
           l.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
           l.setBounds(20,y, 300, 40);
           y=y+30;
           jPanel2.add(l);
           Font font=new Font("Tahoma",Font.PLAIN,15);
           l.setFont(font);
           Color c=new Color(0,0,0);
           l.setForeground(c);
           System.out.println(v.elementAt(i).toString());
    }
     }
     catch(Exception e)
    { 
      System.out.println("download "+e);
    }
  }
 
    
    
     public class MouseClass extends MouseAdapter
  {
        @Override
        public void mouseClicked(MouseEvent e) 
        {
            try{
              JLabel l=(JLabel)e.getSource();
              String text=l.getText();
              String temp="<html><a href>";
              text=text.substring(text.indexOf(temp)+temp.length(),text.indexOf("</a></html>"));
              Student_Interface mid=(Student_Interface)Naming.lookup("rmi://localhost/virtual");
              byte b[]=mid.download(text);
              FileOutputStream fout=new FileOutputStream("d:/"+text);
              fout.write(b);
              fout.close();
              JOptionPane.showMessageDialog(null, text+" downloaded Successfully");
            }catch(Exception ex)
            {
                System.out.println(ex);
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

        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jPanel2 = new javax.swing.JPanel();

        setPreferredSize(new java.awt.Dimension(980, 520));

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Downloads folder - Copy.png"))); // NOI18N
        jLabel2.setText("  Download Assignment");
        jLabel2.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 956, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 430, Short.MAX_VALUE)
        );

        jScrollPane1.setViewportView(jPanel2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 960, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 428, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents
    
    String filename;
    FileDialog fd;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
