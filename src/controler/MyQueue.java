/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controler;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
import java.util.Queue;
import model.word;

/**
 *
 * @author Nephilim
 */
public class MyQueue {
    ArrayList<word> arr = new ArrayList();

    public void write () 
    {
        try(FileOutputStream fos = new FileOutputStream(new File("MyQueue"))){
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(arr);
        } catch (Exception e) {
            System.out.println("Got an exception");
        }
    }
    
    public void read ()
    {
        try(FileInputStream fis = new FileInputStream(new File("MyQueue"))){
            ObjectInputStream ois = new ObjectInputStream(fis);
            arr =  (ArrayList<word>) ois.readObject();
        } catch(Exception e)
        {
            System.out.println("Got an exception");
        }
    }
    
    public void add5words(ArrayList<word> list) // nhap vao 1 arraylist gom 5 phan tu vao file .dat
    {
        //khi them 5 phan tu moi se gan date bang thoi diem hien tai
        this.read();
        for(int i=0;i<5;i++)
        {
            arr.add(list.get(i));
        }
        this.write();
    }
    
    public ArrayList<word> peek5words()//Se tu dong dua 5 tu do ve cuoi ArrayList va gan lai date thanh ngay hom nay vao file .dat
    {
        //lay ra 5 phan tu o dau queue
        //chuyen date sang thoi diem hien tai
        //roi dua ve cuoi queue
        this.read();
        ArrayList<word> result = new ArrayList();
        Date thistime = new Date();
        for(int i=0;i<5;i++) 
        {
            result.add(arr.get(0));
            arr.remove(0);
        }
        for(int i=0;i<5;i++) 
        {
            word w = result.get(i);
            w.setDate(thistime);
            arr.add(w);
        }
        this.write();
        return result;
    }
    
    public void Clear()
    {
        arr.clear();
    }
    
    public boolean isEmpty()
    {
        return arr.isEmpty();
    }
}
