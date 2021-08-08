/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.Timer;

/**
 *
 * @author varargs
 */
public class MainPage extends javax.swing.JFrame {

    /**
     * Creates new form Main
     */
    Timer t;
    static int index = 0;
    static String qus[][] = new String[30][6];
    static int ans[] = new int[30];
    boolean[] bookmarks = new boolean[30];
    String ExamTitle, ip, stu_id;

    public MainPage(String ExamTitle, String ip, String stu_id) {
        initComponents();
        this.ExamTitle = ExamTitle;
        this.ip = ip;
        this.stu_id = stu_id;
        jLabel9.setText("C & " + ExamTitle);
        jLabel4.setText(index + 1 + " of 15 ( C )");
        jLabel12.setText(ExamTitle);
        jButton2.setEnabled(false);
        jPanel2.setVisible(false);
        jRadioButton5.setVisible(false);
        Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
        setSize(d);
        try {
            Student_Interface midPage = (Student_Interface) Naming.lookup("rmi://" + ip + "/virtual");
            String temp1[][] = midPage.qusOth(ExamTitle);
            String temp[][] = midPage.qus();
            System.arraycopy(temp, 0, qus, 0, temp.length);
            System.arraycopy(temp1, 0, qus, temp.length, temp1.length);
            setQus(0);
        } catch (Exception ex) {
            System.out.println(ex);
        }
        t = new Timer(1000, new Listener(this));
        t.start();
    }

    public String setLine(String txt) {
        boolean flag1 = true;
        Scanner sc = new Scanner(txt);
        String temp = "", send = "";
        while ((temp = sc.nextLine()) != null && sc.hasNext()) {
            send += temp + "<br/>";
            flag1 = false;
        }
        send += temp;
        if (flag1) {
            send = txt;
        }
        return "<html>" + send + "</html>";
    }

    public void setQus(int index) {
        try {
            jLabel5.setText(setLine(qus[index][1]));
            jRadioButton1.setText(setLine(qus[index][2]));
            jRadioButton2.setText(setLine(qus[index][3]));
            jRadioButton3.setText(setLine(qus[index][4]));
            jRadioButton4.setText(setLine(qus[index][5]));
        } catch (Exception ex) {
            System.out.println(ex);
        }
    }

    public class Listener implements ActionListener {

        JFrame frame;
        int m = 45, s = 1;

        public Listener(JFrame frame) {
            this.frame = frame;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            if (s == 0 && m != 0) {
                s = 59;
                m--;
            }
            s--;
            switch (s) {
                case 0:
                    jTextField1.setText(m + " : " + s + s);
                    break;
                case 1:
                    jTextField1.setText(m + " : " + 0 + s);
                    break;
                case 2:
                    jTextField1.setText(m + " : " + 0 + s);
                    break;
                case 3:
                    jTextField1.setText(m + " : " + 0 + s);
                    break;
                case 4:
                    jTextField1.setText(m + " : " + 0 + s);
                    break;
                case 5:
                    jTextField1.setText(m + " : " + 0 + s);
                    break;
                case 6:
                    jTextField1.setText(m + " : " + 0 + s);
                    break;
                case 7:
                    jTextField1.setText(m + " : " + 0 + s);
                    break;
                case 8:
                    jTextField1.setText(m + " : " + 0 + s);
                    break;
                case 9:
                    jTextField1.setText(m + " : " + 0 + s);
                    break;
                default:
                    jTextField1.setText(m + " : " + s);
                    break;
            }
            if (m == 0 && s == 0) {
                t.stop();
                jButton4ActionPerformed(null);
                frame.dispose();
            }
            if (m == 5 && s == 0) {
                JOptionPane.showMessageDialog(null, "5 min left", "Time", JOptionPane.INFORMATION_MESSAGE);
            }
        }
    }

    public void setButton(int ind) {
        switch (ans[ind]) {
            case 1:
                jRadioButton1.setSelected(true);
                break;
            case 2:
                jRadioButton2.setSelected(true);
                break;
            case 3:
                jRadioButton3.setSelected(true);
                break;
            case 4:
                jRadioButton4.setSelected(true);
                break;
            default:
                jRadioButton5.setSelected(true);
                break;
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

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jPanel4 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jRadioButton1 = new javax.swing.JRadioButton();
        jRadioButton2 = new javax.swing.JRadioButton();
        jRadioButton3 = new javax.swing.JRadioButton();
        jRadioButton4 = new javax.swing.JRadioButton();
        jRadioButton5 = new javax.swing.JRadioButton();
        jLabel5 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jButton9 = new javax.swing.JButton();
        jButton10 = new javax.swing.JButton();
        jButton11 = new javax.swing.JButton();
        jButton12 = new javax.swing.JButton();
        jButton13 = new javax.swing.JButton();
        jButton14 = new javax.swing.JButton();
        jButton15 = new javax.swing.JButton();
        jButton16 = new javax.swing.JButton();
        jButton17 = new javax.swing.JButton();
        jButton18 = new javax.swing.JButton();
        jButton19 = new javax.swing.JButton();
        jButton20 = new javax.swing.JButton();
        jButton21 = new javax.swing.JButton();
        jButton22 = new javax.swing.JButton();
        jButton23 = new javax.swing.JButton();
        jPanel8 = new javax.swing.JPanel();
        jButton39 = new javax.swing.JButton();
        jButton40 = new javax.swing.JButton();
        jButton41 = new javax.swing.JButton();
        jButton42 = new javax.swing.JButton();
        jButton43 = new javax.swing.JButton();
        jButton44 = new javax.swing.JButton();
        jButton45 = new javax.swing.JButton();
        jButton46 = new javax.swing.JButton();
        jButton47 = new javax.swing.JButton();
        jButton48 = new javax.swing.JButton();
        jButton49 = new javax.swing.JButton();
        jButton50 = new javax.swing.JButton();
        jButton51 = new javax.swing.JButton();
        jButton52 = new javax.swing.JButton();
        jButton53 = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel1.setText("Exam Name:");

        jTextField1.setEditable(false);
        jTextField1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTextField1.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel2.setText("Time :");

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel9.setText("Exam Name:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel9))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jButton1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButton1.setText("Exam Summary");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButton4.setText("Submit");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButton3.setText("Next");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButton2.setText("Previous");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton4)
                    .addComponent(jButton3)
                    .addComponent(jButton2)
                    .addComponent(jButton1))
                .addGap(0, 10, Short.MAX_VALUE))
        );

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setText("Question No.");

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel4.setText("1 of 30");

        buttonGroup1.add(jRadioButton1);
        jRadioButton1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jRadioButton1.setText("<html>class Thing {<br><br>"
            + "	public static int number_of_things = 0;<br>"
            + "	public String what;<br><br>"
            + "	public Thing (String what) {<br>"
            + "	        this.what = what;<br>"
            + "	        number_of_things++;<br></html>");
        jRadioButton1.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        jRadioButton1.setVerticalTextPosition(javax.swing.SwingConstants.TOP);
        jRadioButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton1ActionPerformed(evt);
            }
        });

        buttonGroup1.add(jRadioButton2);
        jRadioButton2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jRadioButton2.setText("<html>class Thing {<br><br>"
            + "	public static int number_of_things = 0;<br>"
            + "	public String what;<br><br>"
            + "	public Thing (String what) {<br>"
            + "	        this.what = what;<br>"
            + "	        number_of_things++;<br></html>");
        jRadioButton2.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        jRadioButton2.setVerticalTextPosition(javax.swing.SwingConstants.TOP);
        jRadioButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton2ActionPerformed(evt);
            }
        });

        buttonGroup1.add(jRadioButton3);
        jRadioButton3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jRadioButton3.setText("<html>class Thing {<br><br>"
            + "	public static int number_of_things = 0;<br>"
            + "	public String what;<br><br>"
            + "	public Thing (String what) {<br>"
            + "	        this.what = what;<br>"
            + "	        number_of_things++;<br></html>");
        jRadioButton3.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        jRadioButton3.setVerticalTextPosition(javax.swing.SwingConstants.TOP);
        jRadioButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton3ActionPerformed(evt);
            }
        });

        buttonGroup1.add(jRadioButton4);
        jRadioButton4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jRadioButton4.setText("<html>class Thing {<br><br>"
            + "	public static int number_of_things = 0;<br>"
            + "	public String what;<br><br>"
            + "	public Thing (String what) {<br>"
            + "	        this.what = what;<br>"
            + "	        number_of_things++;<br></html>");
        jRadioButton4.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        jRadioButton4.setVerticalTextPosition(javax.swing.SwingConstants.TOP);
        jRadioButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton4ActionPerformed(evt);
            }
        });

        buttonGroup1.add(jRadioButton5);
        jRadioButton5.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jRadioButton5.setText("Temp");

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel5.setText("<html>class Thing {<br><br>"
            + "	public static int number_of_things = 0;<br>"
            + "	public String what;<br><br>"
            + "	public Thing (String what) {<br>"
            + "	        this.what = what;<br>"
            + "	        number_of_things++;<br></html>");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(jRadioButton1)
                            .addComponent(jRadioButton2)
                            .addComponent(jRadioButton3)
                            .addComponent(jRadioButton4)
                            .addComponent(jRadioButton5)))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel4)))
                .addContainerGap(1011, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel5)
                .addGap(66, 66, 66)
                .addComponent(jRadioButton1)
                .addGap(18, 18, 18)
                .addComponent(jRadioButton2)
                .addGap(18, 18, 18)
                .addComponent(jRadioButton3)
                .addGap(18, 18, 18)
                .addComponent(jRadioButton4)
                .addGap(18, 18, 18)
                .addComponent(jRadioButton5)
                .addContainerGap(180, Short.MAX_VALUE))
        );

        jScrollPane1.setViewportView(jPanel4);

        jPanel2.setBackground(new java.awt.Color(153, 153, 153));

        jPanel5.setBackground(new java.awt.Color(204, 204, 204));
        jPanel5.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel5.setLayout(new java.awt.FlowLayout(3, 18, 10));

        jButton9.setBackground(new java.awt.Color(126, 126, 125));
        jButton9.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jButton9.setText("1");
        jButton9.setPreferredSize(new java.awt.Dimension(60, 60));
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });
        jPanel5.add(jButton9);

        jButton10.setBackground(new java.awt.Color(126, 126, 125));
        jButton10.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jButton10.setText("2");
        jButton10.setPreferredSize(new java.awt.Dimension(60, 60));
        jButton10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton10ActionPerformed(evt);
            }
        });
        jPanel5.add(jButton10);

        jButton11.setBackground(new java.awt.Color(126, 126, 125));
        jButton11.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jButton11.setText("3");
        jButton11.setPreferredSize(new java.awt.Dimension(60, 60));
        jButton11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton11ActionPerformed(evt);
            }
        });
        jPanel5.add(jButton11);

        jButton12.setBackground(new java.awt.Color(126, 126, 125));
        jButton12.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jButton12.setText("4");
        jButton12.setPreferredSize(new java.awt.Dimension(60, 60));
        jButton12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton12ActionPerformed(evt);
            }
        });
        jPanel5.add(jButton12);

        jButton13.setBackground(new java.awt.Color(126, 126, 125));
        jButton13.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jButton13.setText("5");
        jButton13.setPreferredSize(new java.awt.Dimension(60, 60));
        jButton13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton13ActionPerformed(evt);
            }
        });
        jPanel5.add(jButton13);

        jButton14.setBackground(new java.awt.Color(126, 126, 125));
        jButton14.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jButton14.setText("6");
        jButton14.setPreferredSize(new java.awt.Dimension(60, 60));
        jButton14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton14ActionPerformed(evt);
            }
        });
        jPanel5.add(jButton14);

        jButton15.setBackground(new java.awt.Color(126, 126, 125));
        jButton15.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jButton15.setText("7");
        jButton15.setPreferredSize(new java.awt.Dimension(60, 60));
        jButton15.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton15ActionPerformed(evt);
            }
        });
        jPanel5.add(jButton15);

        jButton16.setBackground(new java.awt.Color(126, 126, 125));
        jButton16.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jButton16.setText("8");
        jButton16.setPreferredSize(new java.awt.Dimension(60, 60));
        jButton16.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton16ActionPerformed(evt);
            }
        });
        jPanel5.add(jButton16);

        jButton17.setBackground(new java.awt.Color(126, 126, 125));
        jButton17.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jButton17.setText("9");
        jButton17.setPreferredSize(new java.awt.Dimension(60, 60));
        jButton17.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton17ActionPerformed(evt);
            }
        });
        jPanel5.add(jButton17);

        jButton18.setBackground(new java.awt.Color(126, 126, 125));
        jButton18.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jButton18.setText("10");
        jButton18.setPreferredSize(new java.awt.Dimension(60, 60));
        jButton18.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton18ActionPerformed(evt);
            }
        });
        jPanel5.add(jButton18);

        jButton19.setBackground(new java.awt.Color(126, 126, 125));
        jButton19.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jButton19.setText("11");
        jButton19.setPreferredSize(new java.awt.Dimension(60, 60));
        jButton19.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton19ActionPerformed(evt);
            }
        });
        jPanel5.add(jButton19);

        jButton20.setBackground(new java.awt.Color(126, 126, 125));
        jButton20.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jButton20.setText("12");
        jButton20.setPreferredSize(new java.awt.Dimension(60, 60));
        jButton20.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton20ActionPerformed(evt);
            }
        });
        jPanel5.add(jButton20);

        jButton21.setBackground(new java.awt.Color(126, 126, 125));
        jButton21.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jButton21.setText("13");
        jButton21.setPreferredSize(new java.awt.Dimension(60, 60));
        jButton21.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton21ActionPerformed(evt);
            }
        });
        jPanel5.add(jButton21);

        jButton22.setBackground(new java.awt.Color(126, 126, 125));
        jButton22.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jButton22.setText("14");
        jButton22.setPreferredSize(new java.awt.Dimension(60, 60));
        jButton22.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton22ActionPerformed(evt);
            }
        });
        jPanel5.add(jButton22);

        jButton23.setBackground(new java.awt.Color(126, 126, 125));
        jButton23.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jButton23.setText("15");
        jButton23.setPreferredSize(new java.awt.Dimension(60, 60));
        jButton23.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton23ActionPerformed(evt);
            }
        });
        jPanel5.add(jButton23);

        jPanel8.setBackground(new java.awt.Color(204, 204, 204));
        jPanel8.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel8.setLayout(new java.awt.FlowLayout(3, 18, 10));

        jButton39.setBackground(new java.awt.Color(126, 126, 125));
        jButton39.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jButton39.setText("1");
        jButton39.setPreferredSize(new java.awt.Dimension(60, 60));
        jButton39.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton39ActionPerformed(evt);
            }
        });
        jPanel8.add(jButton39);

        jButton40.setBackground(new java.awt.Color(126, 126, 125));
        jButton40.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jButton40.setText("2");
        jButton40.setPreferredSize(new java.awt.Dimension(60, 60));
        jButton40.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton40ActionPerformed(evt);
            }
        });
        jPanel8.add(jButton40);

        jButton41.setBackground(new java.awt.Color(126, 126, 125));
        jButton41.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jButton41.setText("3");
        jButton41.setPreferredSize(new java.awt.Dimension(60, 60));
        jButton41.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton41ActionPerformed(evt);
            }
        });
        jPanel8.add(jButton41);

        jButton42.setBackground(new java.awt.Color(126, 126, 125));
        jButton42.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jButton42.setText("4");
        jButton42.setPreferredSize(new java.awt.Dimension(60, 60));
        jButton42.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton42ActionPerformed(evt);
            }
        });
        jPanel8.add(jButton42);

        jButton43.setBackground(new java.awt.Color(126, 126, 125));
        jButton43.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jButton43.setText("5");
        jButton43.setPreferredSize(new java.awt.Dimension(60, 60));
        jButton43.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton43ActionPerformed(evt);
            }
        });
        jPanel8.add(jButton43);

        jButton44.setBackground(new java.awt.Color(126, 126, 125));
        jButton44.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jButton44.setText("6");
        jButton44.setPreferredSize(new java.awt.Dimension(60, 60));
        jButton44.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton44ActionPerformed(evt);
            }
        });
        jPanel8.add(jButton44);

        jButton45.setBackground(new java.awt.Color(126, 126, 125));
        jButton45.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jButton45.setText("7");
        jButton45.setPreferredSize(new java.awt.Dimension(60, 60));
        jButton45.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton45ActionPerformed(evt);
            }
        });
        jPanel8.add(jButton45);

        jButton46.setBackground(new java.awt.Color(126, 126, 125));
        jButton46.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jButton46.setText("8");
        jButton46.setPreferredSize(new java.awt.Dimension(60, 60));
        jButton46.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton46ActionPerformed(evt);
            }
        });
        jPanel8.add(jButton46);

        jButton47.setBackground(new java.awt.Color(126, 126, 125));
        jButton47.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jButton47.setText("9");
        jButton47.setPreferredSize(new java.awt.Dimension(60, 60));
        jButton47.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton47ActionPerformed(evt);
            }
        });
        jPanel8.add(jButton47);

        jButton48.setBackground(new java.awt.Color(126, 126, 125));
        jButton48.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jButton48.setText("10");
        jButton48.setPreferredSize(new java.awt.Dimension(60, 60));
        jButton48.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton48ActionPerformed(evt);
            }
        });
        jPanel8.add(jButton48);

        jButton49.setBackground(new java.awt.Color(126, 126, 125));
        jButton49.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jButton49.setText("11");
        jButton49.setPreferredSize(new java.awt.Dimension(60, 60));
        jButton49.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton49ActionPerformed(evt);
            }
        });
        jPanel8.add(jButton49);

        jButton50.setBackground(new java.awt.Color(126, 126, 125));
        jButton50.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jButton50.setText("12");
        jButton50.setPreferredSize(new java.awt.Dimension(60, 60));
        jButton50.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton50ActionPerformed(evt);
            }
        });
        jPanel8.add(jButton50);

        jButton51.setBackground(new java.awt.Color(126, 126, 125));
        jButton51.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jButton51.setText("13");
        jButton51.setPreferredSize(new java.awt.Dimension(60, 60));
        jButton51.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton51ActionPerformed(evt);
            }
        });
        jPanel8.add(jButton51);

        jButton52.setBackground(new java.awt.Color(126, 126, 125));
        jButton52.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jButton52.setText("14");
        jButton52.setPreferredSize(new java.awt.Dimension(60, 60));
        jButton52.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton52ActionPerformed(evt);
            }
        });
        jPanel8.add(jButton52);

        jButton53.setBackground(new java.awt.Color(126, 126, 125));
        jButton53.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jButton53.setText("15");
        jButton53.setPreferredSize(new java.awt.Dimension(60, 60));
        jButton53.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton53ActionPerformed(evt);
            }
        });
        jPanel8.add(jButton53);

        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel10.setText("Click on a number to navigate");

        jLabel11.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel11.setText("C");

        jLabel12.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel12.setText("Other");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(214, 214, 214)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, 997, Short.MAX_VALUE)
                            .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel10)
                                    .addGroup(jPanel6Layout.createSequentialGroup()
                                        .addGap(21, 21, 21)
                                        .addComponent(jLabel11)))
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(236, 236, 236)
                        .addComponent(jLabel12)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel10)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel11)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel12)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, 164, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        float num = 0;
        boolean flag = false;
        for (int i = 0; i < 30; i++) {
            flag = false;
            if (i < 15) {
                try {
                    Student_Interface midPage = (Student_Interface) Naming.lookup("rmi://" + ip + "/virtual");
                    flag = midPage.Submit(ans[i], qus[i][0]);
                } catch (Exception ex) {
                    System.out.println(ex + " result 1");
                }
            } else {
                try {
                    Student_Interface midPage = (Student_Interface) Naming.lookup("rmi://" + ip + "/virtual");
                    flag = midPage.SubmitOth(ans[i], qus[i][0], ExamTitle);
                } catch (Exception ex) {
                    System.out.println(ex + " result 2");
                }
            }
            if (flag) {
                num++;
            }
        }
        float result = (num / 30) * 100;
        if (result < 50) {
            JOptionPane.showMessageDialog(this, "You are Fail Result is :" + result);
        } else {
            JOptionPane.showMessageDialog(this, "Your Exam Result is :" + result, "Result", JOptionPane.INFORMATION_MESSAGE);
        }
        try {
            Student_Interface midPage = (Student_Interface) Naming.lookup("rmi://" + ip + "/virtual");
            midPage.ResultSave(stu_id, "" + result);
        } catch (Exception ex) {
            System.out.println(ex);
        }
        this.dispose();
    }//GEN-LAST:event_jButton4ActionPerformed
    boolean flag = true;
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        if (flag) {
            jScrollPane1.setVisible(false);
            jPanel2.setVisible(flag);
            flag = false;
            jButton1.setText("Go To Exam");
            jButton3.setEnabled(flag);
            jButton2.setEnabled(flag);
        } else {
            jScrollPane1.setVisible(true);
            jPanel2.setVisible(flag);
            flag = true;
            jButton3.setEnabled(flag);
            jButton2.setEnabled(flag);
            jButton1.setText("Exam Summary");
        }
    }//GEN-LAST:event_jButton1ActionPerformed
    boolean flag1 = true;
    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        index++;
        if (index == 29) {
            jButton3.setEnabled(false);
        } else {
            jButton2.setEnabled(true);
        }
        if (index < 15) {
            jLabel4.setText(index + 1 + " of 15 ( C )");
        } else {
            jLabel4.setText(index + 1 - 15 + " of 15 ( " + ExamTitle + " )");
        }
        setQus(index);
        setButton(index);
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        index--;
        if (index == 0) {
            jButton2.setEnabled(false);
        } else {
            jButton3.setEnabled(true);
        }
        if (index < 15) {
            jLabel4.setText(index + 1 + " of 15 ( C )");
        } else {
            jLabel4.setText(index + 1 - 15 + " of 15 ( " + ExamTitle + " )");
        }
        setQus(index);
        setButton(index);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
        jButton1ActionPerformed(null);
        index = 0;
        jLabel4.setText(index + 1 + " of 15 ( C )");
        setQus(index);
        setButton(index);
    }//GEN-LAST:event_jButton9ActionPerformed

    private void jButton10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton10ActionPerformed
        jButton1ActionPerformed(null);
        index = 1;
        jLabel4.setText(index + 1 + " of 15 ( C )");
        setQus(index);
        setButton(index);
    }//GEN-LAST:event_jButton10ActionPerformed

    private void jButton11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton11ActionPerformed
        jButton1ActionPerformed(null);
        index = 2;
        jLabel4.setText(index + 1 + " of 15 ( C )");
        setQus(index);
        setButton(index);
    }//GEN-LAST:event_jButton11ActionPerformed

    private void jButton12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton12ActionPerformed
        jButton1ActionPerformed(null);
        index = 3;
        jLabel4.setText(index + 1 + " of 15 ( C )");
        setQus(index);
        setButton(index);
    }//GEN-LAST:event_jButton12ActionPerformed

    private void jButton13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton13ActionPerformed
        jButton1ActionPerformed(null);
        index = 4;
        jLabel4.setText(index + 1 + " of 15 ( C )");
        setQus(index);
        setButton(index);
    }//GEN-LAST:event_jButton13ActionPerformed

    private void jButton14ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton14ActionPerformed
        jButton1ActionPerformed(null);
        index = 5;
        jLabel4.setText(index + 1 + " of 15 ( C )");
        setQus(index);
        setButton(index);
    }//GEN-LAST:event_jButton14ActionPerformed

    private void jButton15ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton15ActionPerformed
        jButton1ActionPerformed(null);
        index = 6;
        jLabel4.setText(index + 1 + " of 15 ( C )");
        setQus(index);
        setButton(index);
    }//GEN-LAST:event_jButton15ActionPerformed

    private void jButton16ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton16ActionPerformed
        jButton1ActionPerformed(null);
        index = 7;
        jLabel4.setText(index + 1 + " of 15 ( C )");
        setQus(index);
        setButton(index);
    }//GEN-LAST:event_jButton16ActionPerformed

    private void jButton17ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton17ActionPerformed
        jButton1ActionPerformed(null);
        index = 8;
        jLabel4.setText(index + 1 + " of 15 ( C )");
        setQus(index);
        setButton(index);
    }//GEN-LAST:event_jButton17ActionPerformed

    private void jButton18ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton18ActionPerformed
        jButton1ActionPerformed(null);
        index = 9;
        jLabel4.setText(index + 1 + " of 15 ( C )");
        setQus(index);
        setButton(index);
    }//GEN-LAST:event_jButton18ActionPerformed

    private void jButton19ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton19ActionPerformed
        jButton1ActionPerformed(null);
        index = 10;
        jLabel4.setText(index + 1 + " of 15 ( C )");
        setQus(index);
        setButton(index);
    }//GEN-LAST:event_jButton19ActionPerformed

    private void jButton20ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton20ActionPerformed
        jButton1ActionPerformed(null);
        index = 11;
        jLabel4.setText(index + 1 + " of 15 ( C )");
        setQus(index);
        setButton(index);
    }//GEN-LAST:event_jButton20ActionPerformed

    private void jButton21ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton21ActionPerformed
        jButton1ActionPerformed(null);
        index = 12;
        jLabel4.setText(index + 1 + " of 15 ( C )");
        setQus(index);
        setButton(index);
    }//GEN-LAST:event_jButton21ActionPerformed

    private void jButton22ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton22ActionPerformed
        jButton1ActionPerformed(null);
        index = 13;
        jLabel4.setText(index + 1 + " of 15 ( C )");
        setQus(index);
        setButton(index);
    }//GEN-LAST:event_jButton22ActionPerformed

    private void jButton23ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton23ActionPerformed
        jButton1ActionPerformed(null);
        index = 14;
        jLabel4.setText(index + 1 + " of 15 ( C )");
        setQus(index);
        setButton(index);
    }//GEN-LAST:event_jButton23ActionPerformed

    private void jButton39ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton39ActionPerformed
        jButton1ActionPerformed(null);
        index = 15;
        jLabel4.setText(index + 1 - 15 + " of 15 ( " + ExamTitle + " )");
        setQus(index);
        setButton(index);
    }//GEN-LAST:event_jButton39ActionPerformed

    private void jButton40ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton40ActionPerformed
        jButton1ActionPerformed(null);
        index = 16;
        jLabel4.setText(index + 1 - 15 + " of 15 ( " + ExamTitle + " )");
        setQus(index);
        setButton(index);
    }//GEN-LAST:event_jButton40ActionPerformed

    private void jButton41ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton41ActionPerformed
        jButton1ActionPerformed(null);
        index = 17;
        jLabel4.setText(index + 1 - 15 + " of 15 ( " + ExamTitle + " )");
        setQus(index);
        setButton(index);
    }//GEN-LAST:event_jButton41ActionPerformed

    private void jButton42ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton42ActionPerformed
        jButton1ActionPerformed(null);
        index = 18;
        jLabel4.setText(index + 1 - 15 + " of 15 ( " + ExamTitle + " )");
        setQus(index);
        setButton(index);
    }//GEN-LAST:event_jButton42ActionPerformed

    private void jButton43ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton43ActionPerformed
        jButton1ActionPerformed(null);
        index = 19;
        jLabel4.setText(index + 1 - 15 + " of 15 ( " + ExamTitle + " )");
        setQus(index);
        setButton(index);
    }//GEN-LAST:event_jButton43ActionPerformed

    private void jButton44ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton44ActionPerformed
        jButton1ActionPerformed(null);
        index = 20;
        jLabel4.setText(index + 1 - 15 + " of 15 ( " + ExamTitle + " )");
        setQus(index);
        setButton(index);
    }//GEN-LAST:event_jButton44ActionPerformed

    private void jButton45ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton45ActionPerformed
        jButton1ActionPerformed(null);
        index = 21;
        jLabel4.setText(index + 1 - 15 + " of 15 ( " + ExamTitle + " )");
        setQus(index);
        setButton(index);
    }//GEN-LAST:event_jButton45ActionPerformed

    private void jButton46ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton46ActionPerformed
        jButton1ActionPerformed(null);
        index = 22;
        jLabel4.setText(index + 1 - 15 + " of 15 ( " + ExamTitle + " )");
        setQus(index);
        setButton(index);
    }//GEN-LAST:event_jButton46ActionPerformed

    private void jButton47ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton47ActionPerformed
        jButton1ActionPerformed(null);
        index = 23;
        jLabel4.setText(index + 1 - 15 + " of 15 ( " + ExamTitle + " )");
        setQus(index);
        setButton(index);
    }//GEN-LAST:event_jButton47ActionPerformed

    private void jButton48ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton48ActionPerformed
        jButton1ActionPerformed(null);
        index = 24;
        jLabel4.setText(index + 1 - 15 + " of 15 ( " + ExamTitle + " )");
        setQus(index);
        setButton(index);
    }//GEN-LAST:event_jButton48ActionPerformed

    private void jButton49ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton49ActionPerformed
        jButton1ActionPerformed(null);
        index = 25;
        jLabel4.setText(index + 1 - 15 + " of 15 ( " + ExamTitle + " )");
        setQus(index);
        setButton(index);
    }//GEN-LAST:event_jButton49ActionPerformed

    private void jButton50ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton50ActionPerformed
        jButton1ActionPerformed(null);
        index = 26;
        jLabel4.setText(index + 1 - 15 + " of 15 ( " + ExamTitle + " )");
        setQus(index);
        setButton(index);
    }//GEN-LAST:event_jButton50ActionPerformed

    private void jButton51ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton51ActionPerformed
        jButton1ActionPerformed(null);
        index = 27;
        jLabel4.setText(index + 1 - 15 + " of 15 ( " + ExamTitle + " )");
        setQus(index);
        setButton(index);
    }//GEN-LAST:event_jButton51ActionPerformed

    private void jButton52ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton52ActionPerformed
        jButton1ActionPerformed(null);
        index = 28;
        jLabel4.setText(index + 1 - 15 + " of 15 ( " + ExamTitle + " )");
        setQus(index);
        setButton(index);
    }//GEN-LAST:event_jButton52ActionPerformed

    private void jButton53ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton53ActionPerformed
        jButton1ActionPerformed(null);
        index = 29;
        jLabel4.setText(index + 1 - 15 + " of 15 ( " + ExamTitle + " )");
        setQus(index);
        setButton(index);
    }//GEN-LAST:event_jButton53ActionPerformed

    private void jRadioButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton1ActionPerformed
        ans[index] = 1;
    }//GEN-LAST:event_jRadioButton1ActionPerformed

    private void jRadioButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton2ActionPerformed
        ans[index] = 2;
    }//GEN-LAST:event_jRadioButton2ActionPerformed

    private void jRadioButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton3ActionPerformed
        ans[index] = 3;
    }//GEN-LAST:event_jRadioButton3ActionPerformed

    private void jRadioButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton4ActionPerformed
        ans[index] = 4;
    }//GEN-LAST:event_jRadioButton4ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /*
         * Set the Nimbus look and feel
         */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /*
         * If Nimbus (introduced in Java SE 6) is not available, stay with the
         * default look and feel. For details see
         * http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MainPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /*
         * Create and display the form
         */
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
//                new Main().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton11;
    private javax.swing.JButton jButton12;
    private javax.swing.JButton jButton13;
    private javax.swing.JButton jButton14;
    private javax.swing.JButton jButton15;
    private javax.swing.JButton jButton16;
    private javax.swing.JButton jButton17;
    private javax.swing.JButton jButton18;
    private javax.swing.JButton jButton19;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton20;
    private javax.swing.JButton jButton21;
    private javax.swing.JButton jButton22;
    private javax.swing.JButton jButton23;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton39;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton40;
    private javax.swing.JButton jButton41;
    private javax.swing.JButton jButton42;
    private javax.swing.JButton jButton43;
    private javax.swing.JButton jButton44;
    private javax.swing.JButton jButton45;
    private javax.swing.JButton jButton46;
    private javax.swing.JButton jButton47;
    private javax.swing.JButton jButton48;
    private javax.swing.JButton jButton49;
    private javax.swing.JButton jButton50;
    private javax.swing.JButton jButton51;
    private javax.swing.JButton jButton52;
    private javax.swing.JButton jButton53;
    private javax.swing.JButton jButton9;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JRadioButton jRadioButton2;
    private javax.swing.JRadioButton jRadioButton3;
    private javax.swing.JRadioButton jRadioButton4;
    private javax.swing.JRadioButton jRadioButton5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables
}
