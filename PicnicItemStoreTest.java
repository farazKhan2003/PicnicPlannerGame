package picnicplanner;
import java.io.IOException;

public class PicnicItemStoreTest extends PicnicItemStore {
    public static void main (String[] args) throws IOException {
        PicnicItemStore store = new PicnicItemStore(); 
        store.put("a", "abiu");
        store.put("bl", "blackberry");
        store.put("bl", "blackcurrent");
        store.put("a", "apricot");
        store.getRandomItem("a");
        store.containsKey(null);
        

    }
}