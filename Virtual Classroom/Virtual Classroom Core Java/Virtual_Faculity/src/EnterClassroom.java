
import java.awt.*;
import java.net.InetAddress;
import java.util.Vector;
import javax.media.*;
import javax.media.control.BufferControl;
import javax.media.protocol.DataSource;
import javax.media.rtp.*;
import javax.media.rtp.event.*;
import javax.swing.*;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.image.BufferedImage;
import java.rmi.Naming;
import java.util.Vector;
import javax.imageio.ImageIO;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.*;

/*
 * To change this template, choose Tools | Templates and open the template in
 * the editor.
 */
/**
 *
 * @author Neha
 */
public class EnterClassroom extends javax.swing.JFrame implements Runnable {

    /**
     * Creates new form EnterClassroom
     */
    //DefaultTableModel table;
    String fac_id = "";
    String ips[] = new String[1];

    public EnterClassroom(String facId, String ip) {
        initComponents();
        ips[0] = ip;
        this.setTitle("My Classroom");
        fac_id = facId;
        this.getOnline();
        this.getImage();
        try {
            BufferedImage img = ImageIO.read(getClass().getResourceAsStream("TitleIcon.png"));
            setIconImage(img);
        } catch (Exception ex) {
            System.out.println(ex);
        }
        Thread th = new Thread(this);
        th.start();
    }

    public void run() {
        AVReceive2 avReceive = new AVReceive2(ips);
        if (!avReceive.initialize()) {
            System.err.println("Failed to initialize the sessions.");
            System.exit(-1);
        }
    }

    public void getOnline() {
        int x1 = 0, y1 = 0, x2 = 0, y2 = 0;
        try {
            Faculity_Interface mid = (Faculity_Interface) Naming.lookup("rmi://localhost/virtual");
            Vector v[] = mid.getStudentDetail();
            for (int i = 0; i < v.length; i++) {

                if (x1 > 1) {
                    x1 = 0;
                    y1 = y1 + 1;
                }

                if (v[i].get(12).toString().equals("true")) {
                    GridBagLayout gb = new GridBagLayout();
                    jPanel2.setLayout(gb);
                    GridBagConstraints gbc = new GridBagConstraints();
                    if (v[i].get(5).toString().equals("Male")) {
                        JLabel l = new JLabel(v[i].get(3).toString() + " ");
                        Font font = new Font("Tahoma", Font.BOLD, 14);
                        l.setFont(font);
                        Color c = new Color(0, 0, 102);
                        l.setForeground(c);
                        gbc.gridx = x1;
                        gbc.gridy = y1;
                        gb.setConstraints(l, gbc);
                        Icon icon = new ImageIcon("images/boy1.png");
                        l.setIcon(icon);
                        jPanel2.add(l);
                        x1++;
                    } else {
                        JLabel l = new JLabel(v[i].get(3).toString() + " ");
                        Font font = new Font("Tahoma", Font.BOLD, 14);
                        l.setFont(font);
                        Color c = new Color(0, 0, 102);
                        l.setForeground(c);
                        gbc.gridx = x1;
                        gbc.gridy = y1;
                        gb.setConstraints(l, gbc);
                        Icon icon = new ImageIcon("images/girl1.png");
                        l.setIcon(icon);
                        jPanel2.add(l);
                        x1++;
                    }
                } else {
                    if (x2 > 1) {
                        x2 = 0;
                        y2 = y2 + 1;
                    }

                    GridBagLayout gb = new GridBagLayout();
                    jPanel3.setLayout(gb);
                    GridBagConstraints gbc = new GridBagConstraints();
                    if (v[i].get(5).toString().equals("Male")) {
                        JLabel l = new JLabel(v[i].get(3).toString() + " ");
                        Font font = new Font("Tahoma", Font.BOLD, 14);
                        l.setFont(font);
                        Color c = new Color(0, 0, 102);
                        l.setForeground(c);
                        gbc.gridx = x2;
                        gbc.gridy = y2;
                        gb.setConstraints(l, gbc);
                        Icon icon = new ImageIcon("images/boy2.png");
                        l.setIcon(icon);
                        jPanel3.add(l);
                        x2++;
                    } else {
                        JLabel l = new JLabel(v[i].get(3).toString() + " ");
                        Font font = new Font("Tahoma", Font.BOLD, 14);
                        l.setFont(font);
                        Color c = new Color(0, 0, 102);
                        l.setForeground(c);
                        gbc.gridx = x2;
                        gbc.gridy = y2;
                        gb.setConstraints(l, gbc);
                        Icon icon = new ImageIcon("images/girl2.png");
                        l.setIcon(icon);
                        jPanel3.add(l);
                        x2++;
                    }
                }
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e);
        }
    }

    public void getImage() {
        try {
            Faculity_Interface mid = (Faculity_Interface) Naming.lookup("rmi://localhost/virtual");
            String facGender = mid.getGender(fac_id);
            GridBagLayout gb = new GridBagLayout();
            jPanel1.setLayout(gb);
            GridBagConstraints gbc = new GridBagConstraints();
            Faculity_Interface mid1 = (Faculity_Interface) Naming.lookup("rmi://localhost/virtual");
            String facName = mid1.getName(fac_id);
            if (facGender.equals("Male")) {
                JLabel l = new JLabel(facName + " ");
                Font font = new Font("Tahoma", Font.BOLD, 24);
                l.setFont(font);
                Color c = new Color(0, 0, 102);
                l.setForeground(c);
                gbc.gridx = 1;
                gbc.gridy = 1;
                gb.setConstraints(l, gbc);
                Icon icon = new ImageIcon("images/Male.png");
                l.setIcon(icon);
                jPanel1.add(l);
            } else {
                JLabel l = new JLabel(facName + " ");
                Font font = new Font("Tahoma", Font.BOLD, 24);
                l.setFont(font);
                Color c = new Color(0, 0, 102);
                l.setForeground(c);
                gbc.gridx = 1;
                gbc.gridy = 1;
                gb.setConstraints(l, gbc);
                Icon icon = new ImageIcon("images/Female.png");
                l.setIcon(icon);
                jPanel1.add(l);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e);
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

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 134, 0));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Online Student");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(160, 0, 0));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Offline Student");

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(153, 153, 153), 2, true));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(153, 153, 153), 2, true));
        jPanel4.setPreferredSize(new java.awt.Dimension(200, 200));

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 292, Short.MAX_VALUE)
        );

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 102));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Video");

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 0, 102));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Faculty");

        jButton1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/diagram-06.png"))); // NOI18N
        jButton1.setText("  Back to Home");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(153, 153, 153), 2, true));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(153, 153, 153), 2, true));
        jPanel2.setForeground(new java.awt.Color(0, 0, 51));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 234, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, 448, Short.MAX_VALUE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 448, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 670, Short.MAX_VALUE)
                            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, 451, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(2, 2, 2)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, 296, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 13, Short.MAX_VALUE)
                .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        new Welcome(fac_id).setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

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
            java.util.logging.Logger.getLogger(EnterClassroom.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(EnterClassroom.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(EnterClassroom.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(EnterClassroom.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /*
         * Create and display the form
         */
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                //new EnterClassroom().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    // End of variables declaration//GEN-END:variables

    public class AVReceive2 implements ReceiveStreamListener, SessionListener, ControllerListener {

        String sessions[] = null;
        RTPManager mgrs[] = null;
        Vector playerWindows = null;
        boolean dataReceived = false;
        Object dataSync = new Object();

        public AVReceive2(String sessions[]) {
            this.sessions = sessions;
        }

        protected boolean initialize() {
            try {
                InetAddress ipAddr;
                SessionAddress localAddr = new SessionAddress();
                SessionAddress destAddr;
                mgrs = new RTPManager[sessions.length];
                playerWindows = new Vector();
                SessionLabel session;
                for (int i = 0; i < sessions.length; i++) {
                    try {
                        session = new SessionLabel(sessions[i]);
                    } catch (IllegalArgumentException e) {
                        System.err.println("Failed to parse the session address given: " + sessions[i]);
                        return false;
                    }

                    System.err.println("  - Open RTP session for Video : addr: " + session.addr + " port: " + session.port + " ttl: " + session.ttl);

                    mgrs[i] = (RTPManager) RTPManager.newInstance();
                    mgrs[i].addSessionListener(this);
                    mgrs[i].addReceiveStreamListener(this);

                    ipAddr = InetAddress.getByName(session.addr);

                    if (ipAddr.isMulticastAddress()) {
                        localAddr = new SessionAddress(ipAddr,
                                session.port,
                                session.ttl);
                        destAddr = new SessionAddress(ipAddr,
                                session.port,
                                session.ttl);
                    } else {
                        localAddr = new SessionAddress(InetAddress.getLocalHost(),
                                session.port);
                        destAddr = new SessionAddress(ipAddr, session.port);
                    }

                    mgrs[i].initialize(localAddr);
                    BufferControl bc = (BufferControl) mgrs[i].getControl("javax.media.control.BufferControl");
                    if (bc != null) {
                        bc.setBufferLength(350);
                    }

                    mgrs[i].addTarget(destAddr);
                }

            } catch (Exception e) {
                System.err.println("Cannot create the RTP Session for Video: " + e.getMessage());
                return false;
            }
            long then = System.currentTimeMillis();
            long waitingPeriod = 300000;

            try {
                synchronized (dataSync) {
                    while (!dataReceived/*
                             * && System.currentTimeMillis() - then < waitingPeriod
                             */) {
                        if (!dataReceived) {
                            System.err.println("  - Waiting for RTP Video data to arrive...");
                        }
                        dataSync.wait(1000);
                    }
                }
            } catch (Exception e) {
            }

            if (!dataReceived) {
                System.err.println("No RTP data was received.");
                close();
                return false;
            }

            return true;
        }

        public boolean isDone() {
            return playerWindows.size() == 0;
        }

        /**
         * Close the players and the session managers.
         */
        protected void close() {

            for (int i = 0; i < playerWindows.size(); i++) {
                try {
                    ((PlayerWindow) playerWindows.elementAt(i)).close();
                } catch (Exception e) {
                }
            }

            playerWindows.removeAllElements();

            // close the RTP session.
            for (int i = 0; i < mgrs.length; i++) {
                if (mgrs[i] != null) {
                    mgrs[i].removeTargets("Closing session from AVReceive2");
                    mgrs[i].dispose();
                    mgrs[i] = null;
                }
            }
        }

        PlayerWindow find(Player p) {
            for (int i = 0; i < playerWindows.size(); i++) {
                PlayerWindow pw = (PlayerWindow) playerWindows.elementAt(i);
                if (pw.player == p) {
                    return pw;
                }
            }
            return null;
        }

        PlayerWindow find(ReceiveStream strm) {
            for (int i = 0; i < playerWindows.size(); i++) {
                PlayerWindow pw = (PlayerWindow) playerWindows.elementAt(i);
                if (pw.stream == strm) {
                    return pw;
                }
            }
            return null;
        }

        public synchronized void update(SessionEvent evt) {
            if (evt instanceof NewParticipantEvent) {
                Participant p = ((NewParticipantEvent) evt).getParticipant();
                System.err.println("  - A new participant had just joined: " + p.getCNAME());
            }
        }

        public synchronized void update(ReceiveStreamEvent evt) {

            RTPManager mgr = (RTPManager) evt.getSource();
            Participant participant = evt.getParticipant();	// could be null.
            ReceiveStream stream = evt.getReceiveStream();  // could be null.

            if (evt instanceof RemotePayloadChangeEvent) {

                System.err.println("  - Received an RTP PayloadChangeEvent.");
                System.err.println("Sorry, cannot handle payload change.");
                System.exit(0);

            } else if (evt instanceof NewReceiveStreamEvent) {

                try {
                    stream = ((NewReceiveStreamEvent) evt).getReceiveStream();
                    DataSource ds = stream.getDataSource();

                    // Find out the formats.
                    RTPControl ctl = (RTPControl) ds.getControl("javax.media.rtp.RTPControl");
                    if (ctl != null) {
                        System.err.println("  - Recevied new RTP stream: " + ctl.getFormat());
                    } else {
                        System.err.println("  - Recevied new RTP stream");
                    }

                    if (participant == null) {
                        System.err.println("      The sender of this stream had yet to be identified.");
                    } else {
                        System.err.println("      The stream comes from: " + participant.getCNAME());
                    }
                    Player p = javax.media.Manager.createPlayer(ds);
                    if (p == null) {
                        return;
                    }

                    p.addControllerListener(this);
                    p.realize();
                    PlayerWindow pw = new PlayerWindow(p, stream);
                    playerWindows.addElement(pw);

                    // Notify intialize() that a new stream had arrived.
                    synchronized (dataSync) {
                        dataReceived = true;
                        dataSync.notifyAll();
                    }

                } catch (Exception e) {
                    System.err.println("NewReceiveStreamEvent exception " + e.getMessage());
                    return;
                }

            } else if (evt instanceof StreamMappedEvent) {

                if (stream != null && stream.getDataSource() != null) {
                    DataSource ds = stream.getDataSource();
                    // Find out the formats.
                    RTPControl ctl = (RTPControl) ds.getControl("javax.media.rtp.RTPControl");
                    System.err.println("  - The previously unidentified stream ");
                    if (ctl != null) {
                        System.err.println("      " + ctl.getFormat());
                    }
                    System.err.println("      had now been identified as sent by: " + participant.getCNAME());

                }
            } else if (evt instanceof ByeEvent) {

                System.err.println("  - Got \"bye\" from: " + participant.getCNAME());
                PlayerWindow pw = find(stream);
                if (pw != null) {
                    pw.close();
                    playerWindows.removeElement(pw);
                }
            }

        }

        public synchronized void controllerUpdate(ControllerEvent ce) {

            Player p = (Player) ce.getSourceController();

            if (p == null) {
                return;
            }
            if (ce instanceof RealizeCompleteEvent) {
                PlayerWindow pw = find(p);
                if (pw == null) {
                    System.err.println("Internal error!");
                    System.exit(-1);
                }
                pw.initialize();
                pw.setSize(500, 250);
                pw.setVisible(true);
                jPanel4.add(pw);
                p.start();
            }

            if (ce instanceof ControllerErrorEvent) {
                p.removeControllerListener(this);
                PlayerWindow pw = find(p);
                if (pw != null) {
                    pw.close();
                    playerWindows.removeElement(pw);
                }
                System.err.println("AVReceive2 internal error: " + ce);
            }

        }

        class SessionLabel {

            public String addr = null;
            public int port;
            public int ttl = 1;

            SessionLabel(String session) throws IllegalArgumentException {

                int off;
                String portStr = null, ttlStr = null;

                if (session != null && session.length() > 0) {
                    while (session.length() > 1 && session.charAt(0) == '/') {
                        session = session.substring(1);
                    }
                    off = session.indexOf('/');
                    if (off == -1) {
                        if (!session.equals("")) {
                            addr = session;
                        }
                    } else {
                        addr = session.substring(0, off);
                        session = session.substring(off + 1);
                        off = session.indexOf('/');
                        if (off == -1) {
                            if (!session.equals("")) {
                                portStr = session;
                            }
                        } else {
                            portStr = session.substring(0, off);
                            session = session.substring(off + 1);
                            // Now see if there's a ttl specified
                            off = session.indexOf('/');
                            if (off == -1) {
                                if (!session.equals("")) {
                                    ttlStr = session;
                                }
                            } else {
                                ttlStr = session.substring(0, off);
                            }
                        }
                    }
                }

                if (addr == null) {
                    throw new IllegalArgumentException();
                }

                if (portStr != null) {
                    try {
                        Integer integer = Integer.valueOf(portStr);
                        if (integer != null) {
                            port = integer.intValue();
                        }
                    } catch (Throwable t) {
                        throw new IllegalArgumentException();
                    }
                } else {
                    throw new IllegalArgumentException();
                }

                if (ttlStr != null) {
                    try {
                        Integer integer = Integer.valueOf(ttlStr);
                        if (integer != null) {
                            ttl = integer.intValue();
                        }
                    } catch (Throwable t) {
                        throw new IllegalArgumentException();
                    }
                }
            }
        }

        class PlayerWindow extends JInternalFrame {

            Player player;
            ReceiveStream stream;

            PlayerWindow(Player p, ReceiveStream strm) {
                player = p;
                stream = strm;
                setLayout(new BorderLayout());

            }

            public void initialize() {
                PlayerPanel pp = new PlayerPanel(player);
                add("Center", pp);
            }

            public void close() {
                player.close();
                setVisible(false);
                dispose();
            }

            public void addNotify() {
                super.addNotify();
                pack();
            }
        }

        class PlayerPanel extends Panel {

            Component vc, cc;

            PlayerPanel(Player p) {
                setLayout(new BorderLayout());
                if ((vc = p.getVisualComponent()) != null) {
                    add("Center", vc);
                }
                if ((cc = p.getControlPanelComponent()) != null) {
                    add("South", cc);
                }
            }
        }
    }
}
