/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controler;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import jxl.read.biff.BiffException;
import jxl.write.WriteException;
import model.word;
import view.GDTrangChu;

/**
 *
 * @author Vu Ngoc Chi
 */
public class Main {
    public static HashMapHandling mapAV = new HashMapHandling(); 
    public static HashMapHandling mapVA = new HashMapHandling();
    public static ArrayList<String> listChuDe = new ArrayList<>();
    public static HashMapHandling mapAV1 = new HashMapHandling();
    public static String selection = new String();
    public static String MakeFilePath(String filename)
    {
        //Chuyen FilePath sang link trong folder cua project
        String filepath = System.getProperty("user.dir");
        filepath = filepath.concat("/data/"+filename+".xls");
        return filepath;
    }
    public static void LoadList(){
        Excel e = new Excel();
        try{
        listChuDe = e.readList(MakeFilePath("list"));
        }
        catch(Exception ee){}
        
    }
    public static void LoadAV() throws IOException{
        Excel e = new Excel();
        try{
        for(int i=0;i<listChuDe.size();i++)
        {
            mapAV.connect(e.readMapEn(MakeFilePath(listChuDe.get(i))));
        }}
        catch(Exception ee)
        {
        }
        
    }
    public static void LoadVA(){
        Excel e = new Excel();
        try{
        for(int i=0;i<listChuDe.size();i++)
        {
            mapVA.connect(e.readMapVn(MakeFilePath(listChuDe.get(i))));
        }}
        catch(Exception ee)
        {
        }
   
    }
    public static void LoadAV1(){
         Excel e = new Excel();
        try{
            mapAV1.connect(e.readMapEn(MakeFilePath(selection)));
        }
        catch(Exception ee){}
    }
    public static ArrayList<word> fiveNew() throws IOException, FileNotFoundException, BiffException, WriteException{
        LoadList();
        LoadAV();
        ArrayList<word> arr=new ArrayList();
        arr = mapAV.get5WordsUnknown();
        MyQueue q = new MyQueue();
        q.add5words(arr);
        for(int i = 0; i<arr.size(); i++){
            for(int j =0; j<listChuDe.size(); j++){
                selection = listChuDe.get(j);
                mapAV1.clear();
                LoadAV1();
                if(!mapAV1.containsKey(arr.get(i).getEn()));
                else{
                    Excel e = new Excel();
                    mapAV1.setDate(arr.get(i).getDate(), arr.get(i).getEn());
                    e.writeMap(mapAV1, MakeFilePath(selection));
                    
                }
            }
        }
        return arr;
        
    }
    
    public static ArrayList<word> fiveReview() throws IOException, FileNotFoundException, BiffException, WriteException{
        LoadList();
        LoadAV();
        ArrayList<word> arr=new ArrayList();
        arr = mapAV.geAllWordRemember();
        MyQueue q = new MyQueue();
        arr = q.peek5words();
        q.add5words(mapAV.get5WordsUnknown());
        return arr;
    }
    
    public static void main(String[] args) throws IOException, FileNotFoundException, BiffException, WriteException {
        LoadList();
        new GDTrangChu().setVisible(true);
    }
}
