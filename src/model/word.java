/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

public class word implements Serializable{
    private String en, vn, Prn;
    DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
    Date date = new Date();
    
    public word (){
        dateFormat.format(date);
    }
    public word(word coppy) {
        en=coppy.getEn();
        vn=coppy.getVn();
        Prn=coppy.getPrn();
        date=coppy.date;
        dateFormat.format(date);
    }

    
    public Date getDate() {
        return date;
    }

    public void setDate(Date thattime) {
        date = thattime;
    }

    public String getPrn() {
        return Prn;
    }

    public void setPrn(String Prn) {
        this.Prn = Prn;
    }
    public String getEn() {
        return en;
    }

    public void setEn(String en) {
        this.en = en;
    }

    public String getVn() {
        return vn;
    }

    public void setVn(String vn) {
        this.vn = vn;
    }

}
