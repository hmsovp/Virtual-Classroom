
import java.awt.image.BufferedImage;
import java.rmi.Naming;
import javax.imageio.ImageIO;
import javax.swing.JOptionPane;

/*
 * ChatWindow.java
 *
 * Created on August 9, 2012, 4:27 PM
 */



/**
 *
 * @author  hp
 */
public class ChatWindow extends javax.swing.JFrame {
    
    /** Creates new form ChatWindow */
    String from,to;
    ClientRemote cr;
    String stuName;
    String stu_id;
    public ChatWindow(String to,String from,ClientRemote cr) {
        initComponents();
        this.to=to;
        this.cr=cr;
        stu_id=from;
        try{
        Student_Interface mid=(Student_Interface)Naming.lookup("rmi://localhost/virtual");
        stuName=mid.getName1(from);
        this.from=stuName;
        cr.setTextArea(jTextArea1);        
        }catch(Exception e)
        {
            System.out.println(e);
        }
        this.setTitle(to);
        try {
            BufferedImage img = ImageIO.read(getClass().getResourceAsStream("TitleIcon.png"));
            setIconImage(img);
        } catch (Exception ex) {
            System.out.println(ex);
        }
    }
    
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextArea2 = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        jTextArea1.setColumns(20);
        jTextArea1.setEditable(false);
        jTextArea1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        jScrollPane2.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Enter Message", 0, 0, new java.awt.Font("Tahoma", 0, 12), java.awt.Color.black)); // NOI18N

        jTextArea2.setColumns(20);
        jTextArea2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jTextArea2.setRows(5);
        jTextArea2.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jTextArea2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextArea2KeyPressed(evt);
            }
        });
        jScrollPane2.setViewportView(jTextArea2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 459, Short.MAX_VALUE)
            .addComponent(jScrollPane2)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 287, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTextArea2KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextArea2KeyPressed
        int keycode=evt.getKeyCode();
        if(keycode==evt.VK_ENTER)
        {
            try{
            String msg=jTextArea2.getText();
            Student_Interface sr=(Student_Interface)Naming.lookup("rmi://localhost/virtual");
            System.out.println(sr+" "+to+" "+from+" "+"Hello 1");
            sr.sendMsg(to,from, msg);
            jTextArea1.append("Me : "+msg+"\n");
            System.out.println("Hello 2");
            jTextArea2.setText("");
            }catch(Exception e)
            {
                System.out.println(e);
            }
        }
    }//GEN-LAST:event_jTextArea2KeyPressed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        try {
            Student_Interface mid=(Student_Interface)Naming.lookup("rmi://localhost/virtual");
            boolean b=mid.getOffline(stu_id);
            if(b)
            {
                //JOptionPane.showMessageDialog(this,"Logout sucessful");
            }
            else
            {
                JOptionPane.showMessageDialog(this,"No offline");
            }
        }catch(Exception e)
        {
            JOptionPane.showMessageDialog(this, e);
        }
    }//GEN-LAST:event_formWindowClosing
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                //new ChatWindow().setVisible(true);
            }
        });
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextArea jTextArea2;
    // End of variables declaration//GEN-END:variables
    
}