package picnicplanner;
import java.io.IOException;
import java.util.List;
import java.util.Random;

public class DrinkStore extends PicnicItemStore {
    
    public DrinkStore(String input) throws IOException {
        super(input);
    }
    
    public DrinkStore() {
        super();
    }
    
    public DrinkStore(String filename, int prefix) throws IOException {
        super(filename, prefix);
    }

    @Override 
    public String getRandomItem(String key) {
        //takes in key and generates a random value for that key
        key = key.toLowerCase();
         if (!map.containsKey(key)) {
             return null;
         } else { 
         Random random = new Random();
        List<String> ranList = map.get(key);
        
        String randomString = ranList.get(random.nextInt(ranList.size()));
        String s1 = "";
        s1 = randomString.substring(0, 1).toUpperCase() + randomString.substring(1);
        String[] array; 
        array = s1.split(" ");
        String StringNum = array[array.length-1];
        int num;
        num = Integer.parseInt(StringNum);
        if (num >= 12) {
            s1 = s1.concat("(strong wine)");
        } else if (num > 0) {
            s1 = s1.concat("(wine)");
        } else {
            s1 = s1.concat("(soft drink)");
        }
        
        
         return s1;
     }
     }
    

}
