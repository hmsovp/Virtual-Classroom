import java.awt.Dimension;
import java.io.IOException;
import javax.media.Codec;
import javax.media.Controller;
import javax.media.ControllerClosedEvent;
import javax.media.ControllerEvent;
import javax.media.ControllerListener;
import javax.media.DataSink;
import javax.media.Format;
import javax.media.Manager;
import javax.media.MediaLocator;
import javax.media.NoProcessorException;
import javax.media.Owned;
import javax.media.Player;
import javax.media.Processor;
import javax.media.control.QualityControl;
import javax.media.control.TrackControl;
import javax.media.format.AudioFormat;
import javax.media.format.VideoFormat;
import javax.media.protocol.ContentDescriptor;
import javax.media.protocol.DataSource;
import java.awt.*;
import java.net.InetAddress;
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
    
    String fac_id="";
    DefaultTableModel table;
    public My_Classes(String facId) {
        initComponents();
        
        fac_id=facId;
        
        jButton1.setEnabled(false);
        
        table=(DefaultTableModel)jTable1.getModel();
        int count=table.getRowCount();
        for(int i=count-1;i>=0;i--)
            table.removeRow(i);
        try{
            Faculity_Interface mid=(Faculity_Interface)Naming.lookup("rmi://localhost/virtual");
            Vector v[]=mid.mySearch(fac_id);
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

        setBackground(new java.awt.Color(255, 255, 255));
        setBorder(new javax.swing.border.LineBorder(new java.awt.Color(102, 102, 102), 2, true));
        setPreferredSize(new java.awt.Dimension(960, 520));

        jTable1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
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
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jTable1MousePressed(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        jButton1.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        jButton1.setText("Goto class");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/diagram-36 - Copy.png"))); // NOI18N
        jLabel1.setText("  My Classes");
        jLabel1.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 911, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 393, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton1)
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
        try{
        InetAddress inetaddress=InetAddress.getLocalHost();
        String ip=inetaddress.getHostAddress();
        String port=getPortNumber();
        String port1=getPortNumber();
        Faculity_Interface mid=(Faculity_Interface)Naming.lookup("rmi://localhost/virtual");
        mid.registerFaculty(ip+"/"+port, fac_id,ip+"/"+port1);
        VideoTransmit vt=new VideoTransmit(port);
        vt.start();
        AudioTransmit at=new AudioTransmit(port1);
        at.start();
        new EnterClassroom(fac_id,ip+"/"+port).setVisible(true);
        Welcome w=new Welcome(fac_id);
        w.dispose();
        }catch(Exception e)
        {}
    }//GEN-LAST:event_jButton1ActionPerformed
    public String getPortNumber()
    {
        String port="";
        String req="23456789";
        int len=req.length();
        int index=0;
        for(int i=1;i<=4;i++)
        {
                index=(int)(len*Math.random());
                port+=req.charAt(index);
        }
        int p=Integer.parseInt(port);
        if(p%2!=0)
            p=p+1;
        return p+"";
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
    public class VideoTransmit 
    {
        private Processor processor = null;
        private DataSink  rtptransmitter = null;
        private DataSource dataOutput = null;
        private MediaLocator locator;
        private String ipAddress;
        private String port;
        String ips[]=null;
        int index;
        DataSource ds;
        public VideoTransmit(String port) 
        {
            this.port=port;
            try{
            ds=Manager.createDataSource(new MediaLocator("vfw://0"));
            }catch(Exception e)
            {
                System.out.println(e);
            }
        }
        public synchronized String start() 
        {
            String result;
            result = createProcessor();
            System.out.println(result);
            if (result != null)
                return result;
            result = createTransmitter();
            if (result != null) {
                processor.close();
                processor = null;
                return result;
            }
            processor.start();
            return null;
        }
        public void stop() {
            synchronized (this) {
                if (processor != null) {
                    processor.stop();
                    processor.close();
                    processor = null;
                    rtptransmitter.close();
                    rtptransmitter = null;
                }
            }
        }

        private String createProcessor() 
        {
            try {

                processor = Manager.createProcessor(ds);
            } catch (NoProcessorException npe) {
                return "Couldn't create processor";
            } catch (IOException ioe) {
                return "IOException creating processor";
            }catch(Exception e)
                {
                    System.out.println(e);
                }
            /*Frame Configuration*/

            boolean result = waitForState(processor, Processor.Configured);
            if (result == false)
                return "Couldn't configure processor";
            TrackControl [] tracks = processor.getTrackControls();
            if (tracks == null || tracks.length < 1)
                return "Couldn't find tracks in processor";

            boolean programmed = false;

            for (int i = 0; i < tracks.length; i++) {
                Format format = tracks[i].getFormat();
                if (  tracks[i].isEnabled() &&
                      format instanceof VideoFormat &&
                      !programmed) {

                    Dimension size = ((VideoFormat)format).getSize();
                    float frameRate = ((VideoFormat)format).getFrameRate();
                    VideoFormat jpegFormat = new VideoFormat(VideoFormat.JPEG_RTP,
                                                             new Dimension(300, 300),
                                                             Format.NOT_SPECIFIED,
                                                             Format.byteArray,
                                                             frameRate);
                    tracks[i].setFormat(jpegFormat);
                    System.err.println("Video transmitted as:");
                    System.err.println("  " + jpegFormat);
                    programmed = true;
                }
                else if(format instanceof AudioFormat)
                {
                  System.out.println("Awaj");
                  AudioFormat audioformat=new AudioFormat(AudioFormat.LINEAR);  
                  tracks[i].setFormat(audioformat);
                }
                else
                    tracks[i].setEnabled(false);
            }

            if (!programmed)
                return "Couldn't find video track";

            ContentDescriptor cd = new ContentDescriptor(ContentDescriptor.RAW_RTP);
            processor.setContentDescriptor(cd);
            result = waitForState(processor, Controller.Realized);
            if (result == false)
                return "Couldn't realize processor";

            // Set the JPEG quality to .5.
            setJPEGQuality(processor, 0.5f);

            /*Frame Configuration End*/

            dataOutput = processor.getDataOutput();
            return null;
        }
        private String createTransmitter() {
            String rtpURL = "rtp://192.168.1.255:"+port+"/video";
            MediaLocator outputLocator = new MediaLocator(rtpURL);
            try {
                rtptransmitter = Manager.createDataSink(dataOutput, outputLocator);
                rtptransmitter.open();
                rtptransmitter.start();
                dataOutput.start();
            } catch (IOException ioe) {
                return "Couldn't create RTP data sink";
            }catch(Exception e){
                return "No such Data Sink";
            }
            return null;
        }
        void setJPEGQuality(Player p, float val) {

            javax.media.Control cs[] = p.getControls();
            QualityControl qc = null;
            VideoFormat jpegFmt = new VideoFormat(VideoFormat.JPEG);
            for (int i = 0; i < cs.length; i++) {

                if (cs[i] instanceof QualityControl &&
                    cs[i] instanceof Owned) {
                    Object owner = ((Owned)cs[i]).getOwner();
                    if (owner instanceof Codec) {
                        Format fmts[] = ((Codec)owner).getSupportedOutputFormats(null);
                        for (int j = 0; j < fmts.length; j++) {
                            if (fmts[j].matches(jpegFmt)) {
                                qc = (QualityControl)cs[i];
                                qc.setQuality(val);
                                System.err.println("- Setting quality to " + 
                                            val + " on " + qc);
                                break;
                            }
                        }
                    }
                    if (qc != null)
                        break;
                }
            }
        }
        private Integer stateLock = new Integer(0);
        private boolean failed = false;

        Integer getStateLock() {
            return stateLock;
        }

        void setFailed() {
            failed = true;
        }

        private synchronized boolean waitForState(Processor p, int state) {
            p.addControllerListener(new VideoTransmit.StateListener());
            failed = false;
            if (state == Processor.Configured) {
                p.configure();
            } else if (state == Processor.Realized) {
                p.realize();
            }
            while (p.getState() < state && !failed) {
                synchronized (getStateLock()) {
                    try {
                        getStateLock().wait();
                    } catch (InterruptedException ie) {
                        return false;
                    }
                }
            }

            if (failed)
                return false;
            else
                return true;
        }
        class StateListener implements ControllerListener {

            public void controllerUpdate(ControllerEvent ce) {
                if (ce instanceof ControllerClosedEvent)
                    setFailed();
                if (ce instanceof ControllerEvent) {
                    synchronized (getStateLock()) {
                        getStateLock().notifyAll();
                    }
                }
            }
        }
    }
    public class AudioTransmit 
    {
        private String ipAddress;
        private String port;
        private Processor processor = null;
        private DataSink  rtptransmitter = null;
        private DataSource dataOutput = null;
        private DataSource ds1;
        public AudioTransmit(String port) 
        {
            this.port = port;
            try{
            ds1=Manager.createDataSource(new MediaLocator("javasound://44100"));
            }catch(Exception e)
            {
                System.out.println(e);
            }
        }
        public synchronized String start() 
        {
            String result;
            result = createProcessor();
            if (result != null)
                return result;
            result = createTransmitter();
            if (result != null) {
                processor.close();
                processor = null;
                return result;
            }
            processor.start();
            return null;
        }
        public void stop() {
            synchronized (this) {
                if (processor != null) {
                    processor.stop();
                    processor.close();
                    processor = null;
                    rtptransmitter.close();
                    rtptransmitter = null;
                }
            }
        }

        private String createProcessor() 
        {
            try {
                processor = Manager.createProcessor(ds1);
            } catch (NoProcessorException npe) {
                return "Couldn't create processor";
            } catch (IOException ioe) {
                return "IOException creating processor";
            } 
            boolean result = waitForState(processor, Processor.Configured);
            if (result == false)
                return "Couldn't configure processor";
            TrackControl [] tracks = processor.getTrackControls();
            if (tracks == null || tracks.length < 1)
                return "Couldn't find tracks in processor";
            boolean programmed = false;
            AudioFormat afmt;
            for (int i = 0; i < tracks.length; i++) {
                Format format = tracks[i].getFormat();
                if(tracks[i].isEnabled() &&format instanceof AudioFormat &&!programmed) {
                    afmt = (AudioFormat)tracks[i].getFormat();
                           AudioFormat ulawFormat =   new AudioFormat(AudioFormat.DVI_RTP);
                    tracks[i].setFormat (ulawFormat);
                    System.err.println("Audio transmitted as:");
                    System.err.println("  " + ulawFormat);
                    programmed = true;
                } else
                    tracks[i].setEnabled(false);
            }

            if (!programmed)
                return "Couldn't find Audio track";
           ContentDescriptor cd = new ContentDescriptor(ContentDescriptor.RAW_RTP);
           processor.setContentDescriptor(cd);
            result = waitForState(processor, Controller.Realized);
            if (result == false)
                return "Couldn't realize processor";
            dataOutput = processor.getDataOutput();
            return null;
        }
        private String createTransmitter() {
            String rtpURL = "rtp://192.168.1.255" + ":" + port + "/audio";
            MediaLocator outputLocator = new MediaLocator(rtpURL);
            try {
                rtptransmitter = Manager.createDataSink(dataOutput, outputLocator);
                rtptransmitter.open();
                rtptransmitter.start();
                dataOutput.start();
            } catch (Exception me) {
                return "Couldn't create RTP data sink";
            }
            return null;
        }
        private Integer stateLock = new Integer(0);
        private boolean failed = false;

        Integer getStateLock() {
            return stateLock;
        }

        void setFailed() {
            failed = true;
        }

        private synchronized boolean waitForState(Processor p, int state) {
            p.addControllerListener(new StateListener());
            failed = false;
            if (state == Processor.Configured) {
                p.configure();
            } else if (state == Processor.Realized) {
                p.realize();
            }
            while (p.getState() < state && !failed) {
                synchronized (getStateLock()) {
                    try {
                        getStateLock().wait();
                    } catch (InterruptedException ie) {
                        return false;
                    }
                }
            }

            if (failed)
                return false;
            else
                return true;
        }
        class StateListener implements ControllerListener {

            public void controllerUpdate(ControllerEvent ce) 
            {
                if (ce instanceof ControllerClosedEvent)
                    setFailed();
                if (ce instanceof ControllerEvent) {
                    synchronized (getStateLock()) {
                        getStateLock().notifyAll();
                    }
                }
            }
        }
    }
}