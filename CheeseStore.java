package picnicplanner;
import java.util.List;
import java.util.Random;
import java.io.IOException;
public class CheeseStore extends PicnicItemStore {

    public CheeseStore(String input) throws IOException {
        super(input);
    }
    public CheeseStore() {
        super();
    }
    
    public CheeseStore(String filename, int prefix) throws IOException {
        super(filename, prefix);
    }
    
    @Override 
    public String getRandomItem(String key) {
        //takes in key and generates a random value for that key
        key = key.toLowerCase();
         if (!this.map.containsKey(key)) {
             return null;
         } else { 
         Random random = new Random();
        List<String> ranList = this.map.get(key);
        
        String randomString = ranList.get(random.nextInt(ranList.size()));
        String s1 = "";
        s1 = randomString.substring(0, 1).toUpperCase() + randomString.substring(1);
        s1 = s1.concat(" (cheese)");
         
         
         return s1;
     }
 
    

}
}
