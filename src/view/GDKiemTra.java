/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.awt.Color;
import java.io.File;
import java.util.ArrayList;
import java.util.Random;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import static javax.swing.SwingConstants.BOTTOM;
import static javax.swing.SwingConstants.CENTER;
import controler.Main;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Vu Ngoc Chi
 */
public class GDKiemTra extends javax.swing.JFrame {
    public ArrayList<String> listThuoc = new ArrayList<>();
    public ArrayList<String> listTatCa = new ArrayList<>();
    public ArrayList<String> listRandom = new ArrayList<>();
    public int dung = 0, sai= 0;
    public int index = 0;
    /**
     * Creates new form GDKiemTra
     */
    public GDKiemTra() throws IOException {
        initComponents();
        Main.LoadAV();
        listTatCa = Main.mapAV.toArrayList();
        for(String check : listTatCa){
            if(Main.mapAV.getDate(check)!=null){
                listThuoc.add(check);
            }
        }
        int i;
        for(i =0; i<listTatCa.size(); i++){
            if(listTatCa.get(i).equals(listThuoc.get(index))) break;
        }
        listTatCa.remove(i);
        
        Set set = new HashSet();
        set.add(listThuoc.get(index));
        for(int k = 1; k<=3; k++){
            int current;
            do{
                Random rn =  new Random();
                current = rn.nextInt(listTatCa.size());
            }while(set.contains(listTatCa.get(current))==true);
            set.add(listTatCa.get(current));
            listRandom.add(listTatCa.get(current));
        }
        
        listTatCa.add(listThuoc.get(index));
        LbKey.setText(listThuoc.get(index));
        buttonDA1.setText(Main.mapAV.getmapVn(listRandom.get(0)));
        buttonDA2.setText(Main.mapAV.getmapVn(listRandom.get(1)));
        buttonDA3.setText(Main.mapAV.getmapVn(listRandom.get(2)));
        buttonDA4.setText(Main.mapAV.getmapVn(listThuoc.get(index)));
        
        buttonDA1.setForeground(Color.black);
        buttonDA2.setForeground(Color.black);
        buttonDA3.setForeground(Color.black);
        buttonDA4.setForeground(Color.black);
        LbFalse.setText("Số câu sai: " + sai);
        LbTrue.setText("Số câu đúng: " + dung);
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
        jPanel2 = new javax.swing.JPanel();
        LbKey = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        buttonDA2 = new javax.swing.JRadioButton();
        buttonDA1 = new javax.swing.JRadioButton();
        buttonDA3 = new javax.swing.JRadioButton();
        buttonDA4 = new javax.swing.JRadioButton();
        buttonKT = new javax.swing.JButton();
        Lbicon = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        buttonNext = new javax.swing.JButton();
        LbDA = new javax.swing.JLabel();
        buttonTC = new javax.swing.JButton();
        buttonThoat = new javax.swing.JButton();
        LbTrue = new javax.swing.JLabel();
        LbFalse = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setLocation(new java.awt.Point(140, 0));

        jPanel1.setBackground(new java.awt.Color(255, 255, 153));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        LbKey.setBackground(new java.awt.Color(255, 255, 255));
        LbKey.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        LbKey.setForeground(new java.awt.Color(255, 0, 0));
        LbKey.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        LbKey.setText("Apple");

        jLabel2.setBackground(new java.awt.Color(255, 255, 255));
        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel2.setText("có nghĩa là :");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(128, Short.MAX_VALUE)
                .addComponent(LbKey, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(121, 121, 121))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(20, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(LbKey, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        buttonDA2.setBackground(new java.awt.Color(255, 255, 153));
        buttonGroup1.add(buttonDA2);
        buttonDA2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        buttonDA2.setForeground(new java.awt.Color(0, 0, 204));
        buttonDA2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonDA2ActionPerformed(evt);
            }
        });

        buttonDA1.setBackground(new java.awt.Color(255, 255, 153));
        buttonGroup1.add(buttonDA1);
        buttonDA1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        buttonDA1.setForeground(new java.awt.Color(0, 0, 204));

        buttonDA3.setBackground(new java.awt.Color(255, 255, 153));
        buttonGroup1.add(buttonDA3);
        buttonDA3.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        buttonDA3.setForeground(new java.awt.Color(0, 0, 204));

        buttonDA4.setBackground(new java.awt.Color(255, 255, 153));
        buttonGroup1.add(buttonDA4);
        buttonDA4.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        buttonDA4.setForeground(new java.awt.Color(0, 0, 204));

        buttonKT.setBackground(new java.awt.Color(153, 255, 153));
        buttonKT.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        buttonKT.setForeground(new java.awt.Color(255, 0, 51));
        buttonKT.setText("Kiểm Tra");
        buttonKT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonKTActionPerformed(evt);
            }
        });

        Lbicon.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        Lbicon.setForeground(new java.awt.Color(153, 0, 153));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/questionmark_full.png"))); // NOI18N

        buttonNext.setBackground(new java.awt.Color(153, 255, 153));
        buttonNext.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        buttonNext.setForeground(new java.awt.Color(255, 0, 51));
        buttonNext.setText("Next");
        buttonNext.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonNextActionPerformed(evt);
            }
        });

        LbDA.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        LbDA.setForeground(new java.awt.Color(255, 0, 51));
        LbDA.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        LbDA.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        LbDA.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        LbDA.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);

        buttonTC.setBackground(new java.awt.Color(255, 102, 153));
        buttonTC.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        buttonTC.setForeground(new java.awt.Color(51, 0, 255));
        buttonTC.setText("Trang Chủ");
        buttonTC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonTCActionPerformed(evt);
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

        LbTrue.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        LbTrue.setForeground(new java.awt.Color(51, 0, 255));

        LbFalse.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        LbFalse.setForeground(new java.awt.Color(51, 0, 255));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 301, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(buttonDA1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 255, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(buttonDA2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 255, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(buttonDA3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 255, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(buttonDA4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 255, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(106, 106, 106)
                                .addComponent(buttonKT)
                                .addGap(39, 39, 39)
                                .addComponent(buttonNext, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(167, 167, 167)
                                .addComponent(LbDA)))
                        .addGap(0, 31, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Lbicon, javax.swing.GroupLayout.PREFERRED_SIZE, 343, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(buttonTC)
                    .addComponent(buttonThoat, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(55, 55, 55))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(224, 224, 224)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(246, 246, 246)
                        .addComponent(LbTrue, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(131, 131, 131)
                        .addComponent(LbFalse, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(LbTrue, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(LbFalse, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(36, 36, 36)
                        .addComponent(buttonDA1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(buttonDA2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(buttonDA3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(buttonDA4)
                        .addGap(35, 35, 35)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(buttonKT)
                            .addComponent(buttonNext))
                        .addGap(59, 59, 59)
                        .addComponent(LbDA))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(11, 11, 11)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(Lbicon, javax.swing.GroupLayout.PREFERRED_SIZE, 283, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 119, Short.MAX_VALUE)
                .addComponent(buttonTC)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(buttonThoat, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void buttonDA2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonDA2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_buttonDA2ActionPerformed
    public void playSound(String soundName)
 {
   try 
   {
    AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File(soundName).getAbsoluteFile( ));
    Clip clip = AudioSystem.getClip( );
    clip.open(audioInputStream);
    clip.start( );
   }
   catch(Exception ex)
   {
     System.out.println("Error with playing sound.");
     ex.printStackTrace( );
   }
 }
    private void buttonKTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonKTActionPerformed
       if(buttonDA1.getForeground().equals(Color.red) ||buttonDA4.getForeground().equals(Color.red) ||buttonDA2.getForeground().equals(Color.red) ||buttonDA3.getForeground().equals(Color.red)){          
       }
       else{
        if(buttonDA1.isSelected()||buttonDA2.isSelected()||buttonDA3.isSelected()||buttonDA4.isSelected()){
        
        String En = new String();
        String DA = new String();
        En = listThuoc.get(index);
        DA = Main.mapAV.getmapVn(En);
        if(buttonDA1.getText().equals(DA)){
            buttonDA1.setForeground(Color.red);
            if(buttonDA1.isSelected()){
                ImageIcon icon;
                icon = new ImageIcon(getClass().getResource("/images/giphy (1).gif"));
                Lbicon.setIcon(icon);
                Lbicon.setText("Bạn đã đúng");
                Lbicon.setHorizontalTextPosition(CENTER);
                Lbicon.setVerticalTextPosition(BOTTOM);
                dung++;
            }
            else{
                ImageIcon icon;
                icon = new ImageIcon(getClass().getResource("/images/icon-bieutuong_29.gif"));
                Lbicon.setIcon(icon);
                Lbicon.setText("Chưa chính xác");
                Lbicon.setHorizontalTextPosition(CENTER);
                Lbicon.setVerticalTextPosition(BOTTOM);
                sai++;
            }
        }
        else if(buttonDA2.getText().equals(DA)){
            buttonDA2.setForeground(Color.red);
            if(buttonDA2.isSelected()){
                ImageIcon icon;
                icon = new ImageIcon(getClass().getResource("/images/giphy (1).gif"));
                Lbicon.setIcon(icon);
                Lbicon.setText("Bạn đã đúng");
                Lbicon.setHorizontalTextPosition(CENTER);
                Lbicon.setVerticalTextPosition(BOTTOM);
                dung++;
            }
            else{
                ImageIcon icon;
                icon = new ImageIcon(getClass().getResource("/images/icon-bieutuong_29.gif"));
                Lbicon.setIcon(icon);
                Lbicon.setText("Chưa chính xác");
                Lbicon.setHorizontalTextPosition(CENTER);
                Lbicon.setVerticalTextPosition(BOTTOM);
                sai++;
            }
        }
        else if(buttonDA3.getText().equals(DA)){
            buttonDA3.setForeground(Color.red);
            if(buttonDA3.isSelected()){
                ImageIcon icon;
                icon = new ImageIcon(getClass().getResource("/images/giphy (1).gif"));
                Lbicon.setIcon(icon);
                Lbicon.setText("Bạn đã đúng");
                Lbicon.setHorizontalTextPosition(CENTER);
                Lbicon.setVerticalTextPosition(BOTTOM);
                dung++;
            }
            else{
                ImageIcon icon;
                icon = new ImageIcon(getClass().getResource("/images/icon-bieutuong_29.gif"));
                Lbicon.setIcon(icon);
                Lbicon.setText("Chưa chính xác");
                Lbicon.setHorizontalTextPosition(CENTER);
                Lbicon.setVerticalTextPosition(BOTTOM);
                sai++;
            }
        
        }
        else if(buttonDA4.getText().equals(DA)){
            buttonDA4.setForeground(Color.red);
            if(buttonDA4.isSelected()){
                ImageIcon icon;
                icon = new ImageIcon(getClass().getResource("/images/giphy (1).gif"));
                Lbicon.setIcon(icon);
                Lbicon.setText("Bạn đã đúng");
                Lbicon.setHorizontalTextPosition(CENTER);
                Lbicon.setVerticalTextPosition(BOTTOM);
                dung++;
            }
            else{
                ImageIcon icon;
                icon = new ImageIcon(getClass().getResource("/images/icon-bieutuong_29.gif"));
                Lbicon.setIcon(icon);
                Lbicon.setText("Chưa chính xác");
                Lbicon.setHorizontalTextPosition(CENTER);
                Lbicon.setVerticalTextPosition(BOTTOM);
                sai++;
            }}
        LbDA.setText(DA);
        ImageIcon icon1;
        icon1 = new ImageIcon(getClass().getResource("/data/"+En+".jpeg"));
        LbDA.setIcon(icon1);
        LbFalse.setText("Số câu sai: " + sai);
        LbTrue.setText("Số câu đúng: " + dung);
        }
        else{
            JOptionPane.showMessageDialog(rootPane, "Bạn cần lựa chọn 1 đáp án đúng");
        }
       }
    }//GEN-LAST:event_buttonKTActionPerformed

    private void buttonNextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonNextActionPerformed
        listRandom.clear();
        if(buttonDA1.getForeground().equals(Color.red) ||buttonDA4.getForeground().equals(Color.red) ||buttonDA2.getForeground().equals(Color.red) ||buttonDA3.getForeground().equals(Color.red)){
        
        if(index<listThuoc.size() - 1){
           index++;       
        double current;
        int i;
        for(i =0; i<listTatCa.size(); i++){
            if(listTatCa.get(i).equals(listThuoc.get(index))) break;
        }
        listTatCa.remove(i);
        
        Set<String> set = new HashSet();
        for(int k = 1; k<=3; k++){
            int currentt;
            do{
                Random rn =  new Random();
                currentt = rn.nextInt(listTatCa.size());
            }while(set.contains(listTatCa.get(currentt))==true);
            set.add(listTatCa.get(currentt));
            listRandom.add(listTatCa.get(currentt));
        }
        
        for(int k = 1; k<=3; k++){
            current = Math.random();
            current = (int)Math.round(current*(listTatCa.size()));
            listRandom.add(listTatCa.get((int)current));
        }
        
        listTatCa.add(listThuoc.get(index));
        LbKey.setText(listThuoc.get(index));
        buttonDA1.setText(Main.mapAV.getmapVn(listRandom.get(0)));
        buttonDA2.setText(Main.mapAV.getmapVn(listRandom.get(1)));
        buttonDA3.setText(Main.mapAV.getmapVn(listRandom.get(2)));
        buttonDA4.setText(Main.mapAV.getmapVn(listThuoc.get(index)));
        double change;
        change = Math.random();
        change = change*4;
        if((int)change == 0.0){
            buttonDA4.setText(buttonDA1.getText());
            buttonDA1.setText(Main.mapAV.getmapVn(listThuoc.get(index)));
        }
        else if((int)change == 1.0){
            buttonDA4.setText(buttonDA2.getText());
            buttonDA2.setText(Main.mapAV.getmapVn(listThuoc.get(index)));
        }
        else if((int)change == 2.0){
            buttonDA4.setText(buttonDA3.getText());
            buttonDA3.setText(Main.mapAV.getmapVn(listThuoc.get(index)));
        }
        buttonGroup1.clearSelection();
        LbDA.setText(null);
        LbDA.setIcon(null);
        Lbicon.setIcon(null);
        Lbicon.setText(null);
        buttonDA1.setForeground(Color.black);
        buttonDA2.setForeground(Color.black);
        buttonDA3.setForeground(Color.black);
        buttonDA4.setForeground(Color.black);       
       }
       else{
           JOptionPane.showMessageDialog(rootPane, "Bạn đã hoàn thành các câu hỏi với kết quả là: "+ dung+"/"+(dung+sai)+ " câu trả lời đúng. "
                    +"Vui lòng quay lại trang chủ để thực hiện chức năng khác");
       }}
        else JOptionPane.showMessageDialog(rootPane, "Bạn cần hoàn thành câu hỏi này trước khi đến với câu hỏi tiếp theo!");
    }//GEN-LAST:event_buttonNextActionPerformed

    private void buttonTCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonTCActionPerformed
        int n =  JOptionPane.showConfirmDialog(rootPane, "Bạn có chắc chắn muốn dừng bài kiểm tra?");
            if(n == JOptionPane.YES_OPTION){
        new GDTrangChu().setVisible(true);
        this.dispose();}
    }//GEN-LAST:event_buttonTCActionPerformed

    private void buttonThoatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonThoatActionPerformed
        int n =  JOptionPane.showConfirmDialog(rootPane, "Bạn có chắc chắn muốn dừng bài kiểm tra?");
            if(n == JOptionPane.YES_OPTION){
        System.exit(0);}
    }//GEN-LAST:event_buttonThoatActionPerformed

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
            java.util.logging.Logger.getLogger(GDKiemTra.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GDKiemTra.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GDKiemTra.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GDKiemTra.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new GDKiemTra().setVisible(true);
                } catch (IOException ex) {
                    Logger.getLogger(GDKiemTra.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel LbDA;
    private javax.swing.JLabel LbFalse;
    private javax.swing.JLabel LbKey;
    private javax.swing.JLabel LbTrue;
    private javax.swing.JLabel Lbicon;
    private javax.swing.JRadioButton buttonDA1;
    private javax.swing.JRadioButton buttonDA2;
    private javax.swing.JRadioButton buttonDA3;
    private javax.swing.JRadioButton buttonDA4;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton buttonKT;
    private javax.swing.JButton buttonNext;
    private javax.swing.JButton buttonTC;
    private javax.swing.JButton buttonThoat;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    // End of variables declaration//GEN-END:variables
}