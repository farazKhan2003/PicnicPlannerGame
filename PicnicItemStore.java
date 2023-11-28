package picnicplanner;
import java.util.List;
import java.util.Map;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Random;

public class PicnicItemStore {
    protected Map<String, List<String>> map;
    
     
     public PicnicItemStore() {
          this.map = new HashMap<>();
          
     }
     public void put(String key, String value) { 
         if (this.map.get(key) == null) {
             this.map.put(key,  new ArrayList<String>());
         }
         this.map.get(key).add(value);
     }
     
     public PicnicItemStore(String filename) throws IOException {
         
         map = new HashMap<>();
         BufferedReader reader = new BufferedReader(new FileReader(filename));
         
         try {
             String CurRead;
             String Value = "";
            
             while ((CurRead = reader.readLine()) != null) {
         //map shit
                  CurRead = CurRead.toLowerCase();
                  //System.out.println(CurRead);
                  Value = CurRead;
                  if (map.get(CurRead.substring(0, 1)) == null) {
                         map.put(CurRead.substring(0, 1).toLowerCase(),  new ArrayList<String>());
                     }
                     map.get(CurRead.substring(0, 1)).add(Value);                
             }
     } finally {
         //map.remove(map.size()-1);
         //System.out.println(map.containsKey(map.size() - 1));
         reader.close();
     }
     }
     public PicnicItemStore(String filename, int prefix) throws IOException {
         this.map = new HashMap<>();
         BufferedReader reader = new BufferedReader(new FileReader(filename));
         try {
             String CurRead;
             String Value = "";
             int curreadsize;
            
             while ((CurRead = reader.readLine()) != null) {
         //map shit
                 for (int i = 1; i < prefix+1; i++) {
                  CurRead = CurRead.toLowerCase();
                  curreadsize = CurRead.length();
                  if (i > curreadsize) {
                      break;
                  }
                  //if CurRead.substring(0,i) doesnt exist in CurRead then moveon
                String key = CurRead.substring(0,i);
                  Value = CurRead;
                  if (this.map.get(key) == null) {
                        this. map.put(key, new ArrayList<String>());
                     }
                     this.map.get(key).add(Value);  
                    // System.out.println(key);
                     //System.out.println(Value);
                    
                 }
                 
                 
             }
     } finally {
         reader.close();
     }
     }
     
    
     
     public boolean containsKey(String key) {
        if (!this.map.containsKey(key)) {
         return false;
         } else {
             return true;
         }
    
     }
     
     
     
     public String getRandomItem(String key) {
         key = key.toLowerCase();
        //takes in key and generates a random value for that key
         if (!map.containsKey(key)) {
             return null;
         } else { 
         Random random = new Random();
        List<String> ranList = map.get(key);
        String randomString = ranList.get(random.nextInt(ranList.size()));
        String s1 = "";
        s1 = randomString.substring(0, 1).toUpperCase() + randomString.substring(1);
         
         
         
         return s1;
     }
     }
}
