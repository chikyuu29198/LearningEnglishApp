/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controler;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.WorkbookSettings;
import jxl.read.biff.BiffException;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;
import model.word;


public class Excel 
{

    /**
     *
     * @param FilePath
     * @return 
     * @throws java.io.FileNotFoundException
     * @throws jxl.read.biff.BiffException
     */
    public ArrayList<String> readList (String FilePath) throws FileNotFoundException, IOException, BiffException
    {
        ArrayList<String> list = new ArrayList();
        HashMapHandling map = new HashMapHandling();
        FileInputStream fs = new FileInputStream(FilePath);
        WorkbookSettings ws = new WorkbookSettings();
        ws.setEncoding("Cp1252");
        Workbook wb = Workbook.getWorkbook(fs, ws);
        Sheet sh = wb.getSheet(0); 
        int totalNoOfRows = sh.getRows();
        for (int row = 0; row < totalNoOfRows; row++) {
            String CellGetContent = sh.getCell(0,row).getContents();
            list.add(CellGetContent);
        }
        return list;
    }
    
    public void writeList (ArrayList<String> list, String FilePath) throws FileNotFoundException, IOException, BiffException, WriteException
    {
        FileOutputStream fs = new FileOutputStream(FilePath);
        WritableWorkbook wb = Workbook.createWorkbook(fs);
        WritableSheet sheet = wb.createSheet("Word", 0);
        
        for(int i=0;i<list.size();i++)
        {
            sheet.addCell(new Label(0,i,list.get(i)));
        }
        wb.write();
        wb.close();
        System.out.println("List writed to: "+FilePath);
    }
    public HashMapHandling readMapEn (String FilePath) throws FileNotFoundException, IOException, BiffException
    {
        HashMapHandling map = new HashMapHandling();
        FileInputStream fs = new FileInputStream(FilePath);
        WorkbookSettings ws = new WorkbookSettings();
        ws.setEncoding("Cp1252");
        Workbook wb = Workbook.getWorkbook(fs, ws);
        Sheet sh = wb.getSheet(0); 
        int totalNoOfRows = sh.getRows();
        for (int row = 0; row < totalNoOfRows; row++) {
            word temp = new word();
            String CellGetContent_1 = sh.getCell(0,row).getContents(), 
                   CellGetContent_2 = sh.getCell(1,row).getContents(),
                   CellGetContent_3 = sh.getCell(2,row).getContents();
            try{
                String thattime =  sh.getCell(3,row).getContents();
                Date date1 =new SimpleDateFormat("dd/MM/yyyy").parse(thattime);
                temp.setDate(date1);
            }
            catch(Exception e)
            {
                temp.setDate(null);
            }
            temp.setEn(CellGetContent_1);
            temp.setVn(CellGetContent_2);
            temp.setPrn(CellGetContent_3);
            map.putmapEn(temp);
        }
        return map;
    }
    public HashMapHandling readMapVn (String FilePath) throws FileNotFoundException, IOException, BiffException
    {
        HashMapHandling map = new HashMapHandling();
        FileInputStream fs = new FileInputStream(FilePath);
        WorkbookSettings ws = new WorkbookSettings();
        ws.setEncoding("Cp1252");
        Workbook wb = Workbook.getWorkbook(fs, ws);
        Sheet sh = wb.getSheet(0); 
        int totalNoOfRows = sh.getRows();
        for (int row = 0; row < totalNoOfRows; row++) {
            word temp = new word();
            String CellGetContent_1 = sh.getCell(0,row).getContents(), 
                   CellGetContent_2 = sh.getCell(1,row).getContents(),
                   CellGetContent_3 = sh.getCell(2,row).getContents();
            try{
                String thattime =  sh.getCell(3,row).getContents();
                Date date1 =new SimpleDateFormat("dd/MM/yyyy").parse(thattime);
                temp.setDate(date1);
            }
            catch(Exception e)
            {
                temp.setDate(null);
            }
            temp.setEn(CellGetContent_1);
            temp.setVn(CellGetContent_2);
            temp.setPrn(CellGetContent_3);
            map.putmapVn(temp);
        }
        return map;
    }
    public void writeMap (HashMapHandling map, String FilePath) throws FileNotFoundException, IOException, BiffException, WriteException
    {
        FileOutputStream fs = new FileOutputStream(FilePath);
        WritableWorkbook wb = Workbook.createWorkbook(fs);
        WritableSheet sheet = wb.createSheet("Word", 0);
        
        Collection c = map.values();
        Iterator itr = c.iterator();
        int row = 0;
        while(itr.hasNext())
        {
            word w = (word) itr.next();
            sheet.addCell(new Label(0,row,w.getEn()));
            sheet.addCell(new Label(1,row,w.getVn()));
            sheet.addCell(new Label(2,row,w.getPrn()));
            if(w.getDate()!=null){
                DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
                sheet.addCell(new Label(3,row,dateFormat.format(w.getDate())));
            }
            row++;
        }
        wb.write();
        wb.close();
        System.out.println("Writed to: "+FilePath);
    }
}
