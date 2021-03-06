/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controler.Excel;
import controler.HashMapHandling;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import static javax.swing.SwingConstants.BOTTOM;
import static javax.swing.SwingConstants.CENTER;
import jxl.read.biff.BiffException;
import jxl.write.WriteException;
import controler.Main;
import static controler.Main.LoadAV1;
import static controler.Main.MakeFilePath;
import static controler.Main.listChuDe;
import static controler.Main.mapAV1;
import static controler.Main.selection;
import javax.swing.JRadioButton;
import model.word;

/**
 *
 * @author Vu Ngoc Chi
 */
public class GDHocTu extends javax.swing.JFrame {

    /**
     * Creates new form GDHocTu
     */
    public static String ChucNang =new String();
    public  ArrayList<String> listAnh = new ArrayList<>();
    int index = 0;
    ArrayList<word> arr = new ArrayList<>();
    public GDHocTu() {
        
        initComponents();
        if(ChucNang.equals("HocTu")){
            radianBtnThuoc.setVisible(true);
            jLabel1.setText("Chọn từ");
             Main.LoadAV1();
            listAnh = Main.mapAV1.toArrayList();}
        else if(ChucNang.equals("TVHN")){
            
            jLabel1.setText("Từ vựng hôm nay");
            Main.mapAV1.clear();
            try{
            arr = Main.fiveNew();}
            catch(Exception ee){}
            for(int i = 0; i < arr.size(); i++ ){
                listAnh.add(arr.get(i).getEn());
                Main.mapAV1.map.put(arr.get(i).getEn(), arr.get(i));
            }
            radianBtnThuoc.setVisible(false);
            buttonQL.setVisible(false);
        }
        else if(ChucNang.equals("TVNN")){
            jLabel1.setText("Từ vựng ôn tập");
            Main.mapAV1.clear();
            try{
            arr = Main.fiveReview();}
            catch(Exception ee){}
            for(int i = 0; i < arr.size(); i++ ){
                listAnh.add(arr.get(i).getEn());
                Main.mapAV1.map.put(arr.get(i).getEn(), arr.get(i));
            }
            radianBtnThuoc.setVisible(false);
            buttonQL.setVisible(false);
        }
        for(int i = 0;i < listAnh.size(); i++){
        cbbTu.addItem(listAnh.get(i));}   
        LbTu.setText(listAnh.get(index));
        String concat = new String();
        ImageIcon icon;
        concat = Main.mapAV1.getmapPrn(listAnh.get(index)) + " : " + Main.mapAV1.getmapVn(listAnh.get(index));
        try
            {
            icon = new ImageIcon(getClass().getResource("/data/"+listAnh.get(index)+".jpeg"));
            }
        catch(Exception eee)
            {
                icon = new ImageIcon(getClass().getResource("/data/noimg.jpeg"));
            }
        LbNghia.setIcon(icon);
        LbNghia.setText(concat);
        LbNghia.setHorizontalTextPosition(CENTER);
        LbNghia.setVerticalTextPosition(BOTTOM);
        if(Main.mapAV1.getDate(listAnh.get(index)) == null)
        radianBtnThuoc.setSelected(false);
        else radianBtnThuoc.setSelected(true);
        
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
        LbTu = new javax.swing.JLabel();
        LbNghia = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        cbbTu = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        buttonHoc = new javax.swing.JButton();
        radianBtnThuoc = new javax.swing.JRadioButton();
        buttonNext = new javax.swing.JButton();
        buttonBack = new javax.swing.JButton();
        buttonQL = new javax.swing.JButton();
        buttonThoat = new javax.swing.JButton();
        buttonTC2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setLocation(new java.awt.Point(130, 0));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jPanel1KeyPressed(evt);
            }
        });

        LbTu.setBackground(new java.awt.Color(255, 255, 255));
        LbTu.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        LbTu.setForeground(new java.awt.Color(255, 51, 51));
        LbTu.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        LbNghia.setBackground(new java.awt.Color(255, 255, 255));
        LbNghia.setFont(new java.awt.Font("Tahoma", 3, 18)); // NOI18N
        LbNghia.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        LbNghia.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        LbNghia.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setText("Từ vựng hôm nay");
        jLabel1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        cbbTu.setBackground(new java.awt.Color(255, 204, 204));
        cbbTu.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        cbbTu.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                cbbTuKeyPressed(evt);
            }
        });

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/tumblr_lw2kxwlqPf1r88whxo1_500.gif"))); // NOI18N

        buttonHoc.setBackground(new java.awt.Color(255, 102, 204));
        buttonHoc.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        buttonHoc.setForeground(new java.awt.Color(102, 0, 255));
        buttonHoc.setText("Học");
        buttonHoc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonHocActionPerformed(evt);
            }
        });

        radianBtnThuoc.setBackground(new java.awt.Color(0, 255, 0));
        radianBtnThuoc.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        radianBtnThuoc.setForeground(new java.awt.Color(255, 51, 51));
        radianBtnThuoc.setText("Đã thuộc");
        radianBtnThuoc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radianBtnThuocActionPerformed(evt);
            }
        });

        buttonNext.setBackground(new java.awt.Color(0, 102, 255));
        buttonNext.setFont(new java.awt.Font("Tahoma", 3, 12)); // NOI18N
        buttonNext.setForeground(new java.awt.Color(255, 153, 153));
        buttonNext.setText("Next");
        buttonNext.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonNextActionPerformed(evt);
            }
        });
        buttonNext.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                buttonNextKeyPressed(evt);
            }
        });

        buttonBack.setBackground(new java.awt.Color(0, 102, 255));
        buttonBack.setFont(new java.awt.Font("Tahoma", 3, 12)); // NOI18N
        buttonBack.setForeground(new java.awt.Color(255, 153, 153));
        buttonBack.setText("Back");
        buttonBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonBackActionPerformed(evt);
            }
        });
        buttonBack.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                buttonBackKeyPressed(evt);
            }
        });

        buttonQL.setBackground(new java.awt.Color(255, 102, 153));
        buttonQL.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        buttonQL.setForeground(new java.awt.Color(51, 0, 255));
        buttonQL.setText("Quay Lại");
        buttonQL.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonQLActionPerformed(evt);
            }
        });

        buttonThoat.setBackground(new java.awt.Color(255, 102, 153));
        buttonThoat.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        buttonThoat.setForeground(new java.awt.Color(51, 0, 255));
        buttonThoat.setText("Thoát");
        buttonThoat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonThoatActionPerformed(evt);
            }
        });

        buttonTC2.setBackground(new java.awt.Color(255, 102, 153));
        buttonTC2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        buttonTC2.setForeground(new java.awt.Color(51, 0, 255));
        buttonTC2.setText("Trang Chủ");
        buttonTC2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonTC2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 381, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 318, Short.MAX_VALUE)
                .addComponent(radianBtnThuoc)
                .addGap(270, 270, 270))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(buttonQL, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buttonThoat, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buttonTC2))
                .addGap(28, 28, 28))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cbbTu, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(LbTu, javax.swing.GroupLayout.PREFERRED_SIZE, 271, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(50, 50, 50))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(buttonBack)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(LbNghia, javax.swing.GroupLayout.PREFERRED_SIZE, 361, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(4, 4, 4)))
                        .addComponent(buttonNext)
                        .addGap(66, 66, 66))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(buttonHoc)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(241, 241, 241)
                        .addComponent(buttonBack)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(LbNghia, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(35, 35, 35)))
                .addComponent(radianBtnThuoc)
                .addGap(235, 235, 235))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(LbTu, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(buttonHoc)
                        .addComponent(cbbTu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(153, 153, 153)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 265, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(143, 143, 143)
                        .addComponent(buttonNext)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
                .addComponent(buttonTC2)
                .addGap(18, 18, 18)
                .addComponent(buttonQL)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(buttonThoat)
                .addGap(22, 22, 22))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void buttonHocActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonHocActionPerformed
        String en = cbbTu.getItemAt(cbbTu.getSelectedIndex());
        String vn = new String();
        String concat = new String();
        ImageIcon icon;
        if(Main.mapAV1.containsKey(en)==false) {
            concat = "Word can not found";
            icon = new ImageIcon(getClass().getResource("/data/noimg.jpeg"));
        }
        else
        {
        vn = Main.mapAV1.getmapVn(en);
        concat = Main.mapAV1.getmapPrn(en) + " : " + vn;
        try
            {
            icon = new ImageIcon(getClass().getResource("/data/"+en+".jpeg"));
            }
        catch(Exception eee)
            {
                icon = new ImageIcon(getClass().getResource("/data/noimg.jpeg"));
            }
        }
        LbTu.setText(en);
        LbNghia.setIcon(icon);
        LbNghia.setText(concat);
        LbNghia.setHorizontalTextPosition(CENTER);
        LbNghia.setVerticalTextPosition(BOTTOM);
        if(Main.mapAV1.getDate(en)== null)
            radianBtnThuoc.setSelected(false);
        else radianBtnThuoc.setSelected(true);
        for(int i =0;i<listAnh.size(); i++){
            if(listAnh.get(i).equals(en)){
                index = i;
            break;
        }
        
    }//GEN-LAST:event_buttonHocActionPerformed
    }
    private void radianBtnThuocActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radianBtnThuocActionPerformed
            if(radianBtnThuoc.isSelected()){
            Date thattime = new Date();
            Main.mapAV1.setDate(thattime, LbTu.getText());
        }
        else {
            Main.mapAV1.setDate(null, LbTu.getText());
        }
        Excel e = new Excel();
        try {
            e.writeMap(Main.mapAV1, Main.MakeFilePath(Main.selection));
        } catch (IOException ex) {
            Logger.getLogger(GDHocTu.class.getName()).log(Level.SEVERE, null, ex);
        } catch (BiffException ex) {
            Logger.getLogger(GDHocTu.class.getName()).log(Level.SEVERE, null, ex);
        } catch (WriteException ex) {
            Logger.getLogger(GDHocTu.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_radianBtnThuocActionPerformed

    private void buttonQLActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonQLActionPerformed
        listAnh.clear();
        Main.mapAV1.clear();
        new GDChuDe().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_buttonQLActionPerformed

    private void buttonTC2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonTC2ActionPerformed
        listAnh.clear();
        Main.mapAV1.clear();
        new GDTrangChu().setVisible(true);
        this.dispose();           
    }//GEN-LAST:event_buttonTC2ActionPerformed

    private void buttonThoatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonThoatActionPerformed
        System.exit(0);
    }//GEN-LAST:event_buttonThoatActionPerformed

    private void buttonBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonBackActionPerformed
            index--;
            if(index<0) index = listAnh.size()-1;
            LbTu.setText(listAnh.get(index));
            String concat = new String();
            ImageIcon icon;
            concat = Main.mapAV1.getmapPrn(listAnh.get(index)) + " : " + Main.mapAV1.getmapVn(listAnh.get(index));
            try{
                icon = new ImageIcon(getClass().getResource("/data/"+listAnh.get(index)+".jpeg"));
            }
            catch(Exception e)
            {
                icon = new ImageIcon(getClass().getResource("/data/noimg.jpeg"));
            }
            LbNghia.setIcon(icon);
            LbNghia.setText(concat);
            LbNghia.setHorizontalTextPosition(CENTER);
            LbNghia.setVerticalTextPosition(BOTTOM);
        if(Main.mapAV1.getDate(listAnh.get(index))==null)
        radianBtnThuoc.setSelected(false);
        else radianBtnThuoc.setSelected(true);

        
    }//GEN-LAST:event_buttonBackActionPerformed

    private void buttonNextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonNextActionPerformed
            index++;
            if(index==listAnh.size()) index = 0;
            LbTu.setText(listAnh.get(index));
            String concat = new String();
            ImageIcon icon;
            concat = Main.mapAV1.getmapPrn(listAnh.get(index)) + " : " + Main.mapAV1.getmapVn(listAnh.get(index));
            try{
                icon = new ImageIcon(getClass().getResource("/data/"+listAnh.get(index)+".jpeg"));
            }
            catch(Exception e)
            {
                icon = new ImageIcon(getClass().getResource("/data/noimg.jpeg"));
            }
            LbNghia.setIcon(icon);
            LbNghia.setText(concat);
            LbNghia.setHorizontalTextPosition(CENTER);
            LbNghia.setVerticalTextPosition(BOTTOM);
        if(Main.mapAV1.getDate(listAnh.get(index))==null)
        radianBtnThuoc.setSelected(false);
        else radianBtnThuoc.setSelected(true);
        

    }//GEN-LAST:event_buttonNextActionPerformed

    private void cbbTuKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cbbTuKeyPressed
        if(evt.getKeyCode() == KeyEvent.VK_ENTER){
            buttonHoc.doClick();
        }
    }//GEN-LAST:event_cbbTuKeyPressed

    private void buttonNextKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_buttonNextKeyPressed
        if(evt.getKeyCode() == KeyEvent.VK_ENTER){
            buttonNext.doClick();
        }

    }//GEN-LAST:event_buttonNextKeyPressed

    private void buttonBackKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_buttonBackKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_buttonBackKeyPressed

    private void jPanel1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jPanel1KeyPressed
        if(evt.getKeyCode() == KeyEvent.VK_KP_RIGHT){
            buttonNext.doClick();
        }
        if(evt.getKeyCode() == KeyEvent.VK_KP_LEFT){
            buttonBack.doClick();
        }
    }//GEN-LAST:event_jPanel1KeyPressed
   
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
            java.util.logging.Logger.getLogger(GDHocTu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GDHocTu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GDHocTu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GDHocTu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GDHocTu().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel LbNghia;
    private javax.swing.JLabel LbTu;
    private javax.swing.JButton buttonBack;
    private javax.swing.JButton buttonHoc;
    private javax.swing.JButton buttonNext;
    private javax.swing.JButton buttonQL;
    private javax.swing.JButton buttonTC2;
    private javax.swing.JButton buttonThoat;
    private javax.swing.JComboBox<String> cbbTu;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JRadioButton radianBtnThuoc;
    // End of variables declaration//GEN-END:variables
}

