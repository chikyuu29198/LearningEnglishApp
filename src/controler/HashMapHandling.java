/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controler;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collector;
import jxl.read.biff.BiffException;
import jxl.write.WriteException;
import model.word;



public class HashMapHandling {
    public Map<String, word> map = new HashMap<>();
    
    public HashMapHandling(){
    }
    //Them tu moi duyet duoc theo ca 2 cach
    
    //Tao map voi tu khoa la tieng anh
    public void putmapEn(word w)
    {
        map.put(w.getEn(), w);
    }
    
    public String getmapEn(String vn)
    {
        return map.get(vn).getEn();
    }
    //Tao map voi tu khoa la tieng viet
    public void putmapVn(word w)
    {
        map.put(w.getVn(), w);
    }
    
    public String getmapVn(String en)
    {
        return map.get(en).getVn();
    }
    public void setDate(Date now, String key)
    {
        map.get(key).setDate(now);
    }
    public Date getDate(String key)
    {
        return map.get(key).getDate();
    }
    public String getmapPrn(String key) {
        return map.get(key).getPrn();
    }
    //Kiem tra xem map co key do khong
    public boolean containsKey(String key)
    {
        return map.containsKey(key);
    }
    //Ket hop 2 HashMapHandling
    public void connect(HashMapHandling map2)
    {
        map.putAll(map2.map);
    }
    
    public Set keySet() {
        return map.keySet();
    }
    
    Collection values() {
        return map.values();
    }
    // phuong thuc chuyen tat ca cac key sang ArrayList
    public ArrayList toArrayList ()
    {
        ArrayList<String> list = new ArrayList<>();
        Set s = map.keySet();
        Iterator itr = s.iterator();
        while (itr.hasNext()) {
        list.add((String) itr.next());
        }
        return list;
    }
    public void addNewWord(word w, String topic) throws IOException, FileNotFoundException, BiffException, WriteException
    {
        //nhap topic va them vao mot word cho topic do
        map.put(w.getEn(), w);
        map.put(w.getVn(), w);// them vao de co the search ngay word do
        Excel e =new Excel();
        HashMapHandling mapp = e.readMapEn(MakeFilePath(topic));
        mapp.putmapEn(w);
        e.writeMap(mapp, MakeFilePath(topic));
    }
    public void removeWord(String en, String topic) throws IOException, FileNotFoundException, BiffException, WriteException
    {
        //nhap topic va tu tieng anh thuoc topic do de xoa
        Excel e =new Excel();
        HashMapHandling mapp = e.readMapEn(MakeFilePath(topic));
        if(mapp.map.containsKey(en)) 
        {
            mapp.map.remove(en);
            e.writeMap(mapp, MakeFilePath(topic));
        }
    }
    public void clear ()
    {
        map.clear();
    }
    public String MakeFilePath(String filename)
    {
        //Chuyen FilePath sang link trong folder cua project
        String filepath = System.getProperty("user.dir");
        filepath = filepath.concat("/data/"+filename+".xls");
        return filepath;
    }
    public ArrayList<word> get5WordsUnknown() 
    {
        //Nên dùng với một mapAnh - Việt 
        //sau đó nhớ phải WriteMap() của map đó ra file Excel để lưu lại Date được thay đổi
        //Trong mapAV của hàm main có VD dùng thử
        ArrayList<word> arr = new ArrayList();
        Set c = map.keySet();
        Iterator i = c.iterator();
        while(i.hasNext()&&arr.size()<5)
        {
            String key = (String) i.next();
            word w = (word) map.get(key);
            if(w.getDate()==null)
            {
                //doan code ben duoi giup SetDate cho phan tu cua map vua duoc lay ra
                Date thistime = new Date();
                w.setDate(thistime);
                map.get(key).setDate(thistime);
                arr.add(w);
            }
        }
        return arr;
        //Phần trả về này sẽ dùng để in ra màn hình hiển thị và nhớ ném vào myQueue
        //Sau đó myQueue sẽ tự xử lý không cần quan tâm
        //Hàm của myQueue chưa được test có thể có lỗi
    }
    public ArrayList<word> geAllWordRemember() 
    {
        //Nên dùng với một mapAnh - Việt 
        //sau đó nhớ phải WriteMap() của map đó ra file Excel để lưu lại Date được thay đổi
        //Trong mapAV của hàm main có VD dùng thử
        ArrayList<word> arr = new ArrayList();
        Set c = map.keySet();
        Iterator i = c.iterator();
        while(i.hasNext())
        {
            String key = (String) i.next();
            word w = (word) map.get(key);
            if(w.getDate()!=null)
            {
                //doan code ben duoi giup SetDate cho phan tu cua map vua duoc lay ra
//                Date thistime = new Date();
//                w.setDate(thistime);
//                map.put(key, w);
                arr.add(w);
            }
        }
        return arr;
    }
    public class DateStagistic implements Comparator<DateStagistic>{
        Date date;
        int count;
        public DateStagistic()
        {
        }
        public DateStagistic(Date d, int c)
        {
            date = d;
            count = c;
        }
        public String getDate()
        {
            DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
            return dateFormat.format(date);
        }
        public int getCount()
        {
            return count;
        }
        @Override
        public int compare(DateStagistic a, DateStagistic b)
        {
            return a.getDate().compareTo(b.getDate());
        }
    }
    public ArrayList<DateStagistic> getDateStagistic()
    {
        //Chỗ ngay đầu phần GDAnhViet sẽ có hướng dẫn sử dụng nhé
        //Dùng y như thế với MapAV là đủ
        HashMap<Date, Integer> mapDate = new HashMap(); 
        Collection c = map.values();
        Iterator i = c.iterator();
        while(i.hasNext())
        {
            word w = (word) i.next();
            if(w.getDate()!=null)
            {
                int count = 1;
                if(mapDate.containsKey(w.getDate())==true)
                {
                    count += mapDate.get(w.getDate());
                }
                mapDate.put(w.getDate(), count);
            }
        }
        //Như vậy là lọc xong số từ học trong ngày nào vào HashMap
        //Phần bên dưới chuyển dữ liệu vào một ArrayList<DateStagistic> để sắp xếp tăng dần
        ArrayList<DateStagistic> arr = new ArrayList();
        Set s = mapDate.keySet();
        Iterator j = s.iterator();
        while(j.hasNext())
        {
            Date d = (Date)j.next();
            DateStagistic DS = new DateStagistic(d, mapDate.get(d));
            arr.add(DS);
        }
        Collections.sort(arr, new DateStagistic());
        return arr;
    }
}