package picnicplanner;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class PicnicPlanner extends PicnicItemStore {

private List<String> plan = new ArrayList<String>();
private PicnicItemStore picnicitemstore;
private CheeseStore cheesestore;
private DrinkStore drinkstore;
private int prefix;
    public PicnicPlanner() throws IOException {
        this.picnicitemstore= new PicnicItemStore("fruits.txt");
        drinkstore = new DrinkStore("drinks.txt");
        cheesestore = new CheeseStore("cheeses.txt");
        
        
        this.plan = plan;
        this.prefix = 0;
    }
    
    public PicnicPlanner(int prefix) throws IOException {
        
        this.prefix = prefix;
          this.picnicitemstore = picnicitemstore = new PicnicItemStore("fruits.txt", prefix);
         this.drinkstore = drinkstore = new DrinkStore("drinks.txt", prefix);
        this.cheesestore = cheesestore = new CheeseStore("cheeses.txt", prefix);
        
        this.plan = plan;
    }
    
    public List<String> generate(String input) throws IOException {

        int itemcount = input.length();
        int curamount = 0;
    
    
        String item;    
            for (curamount = 0; curamount < itemcount ; curamount++) {
                int j = curamount % 3;
                
                 char ch;
                 String key = "";
                
                if (j == 0) {
                    int pref = this.prefix;
                    if (pref == 0 || curamount == input.length()-1) {
                         ch = input.charAt(curamount);
                         key = String.valueOf(ch);
                         
                         } else {
                             
                            while (pref > 0) {
                                if (input.substring(curamount,input.length()).length() <= pref) {
                                    pref--;
                                    continue;
                                }
                                key = input.substring(curamount, input.length()).substring(0, pref);
                             if (this.picnicitemstore.containsKey(key) == true) {
                                 curamount += key.length() - 1;
                                 break;
                             } else {
                                 
                                 pref--;
                                 continue; 
                             }   
                         }
                         }
                    
                    item = this.picnicitemstore.getRandomItem(key);
                    item = item.substring(0, key.length()).toUpperCase() + item.substring(key.length());
                    this.plan.add(item + "\n");
                    System.out.println(item);
                    
                     if (curamount == itemcount) {
                         break;
                     }
                } 
                else if (j == 1) {
                    
                    int pref = this.prefix;
                    if (pref == 0 || curamount == input.length()-1) {
                         ch = input.charAt(curamount);
                         key = String.valueOf(ch);
                         
                         } else {
                             
                            while (pref > 0) {
                                if (input.substring(curamount,input.length()).length() <= pref) {
                                    pref--;
                                    continue;
                                }
                                key = input.substring(curamount, input.length()).substring(0, pref);
                             if (this.cheesestore.containsKey(key) == true) {
                                 curamount += key.length() - 1;
                                 break;
                             } else {
                                 
                                 pref--;
                                 continue;
                             }   
                         }
                         }
                    
                    item = this.cheesestore.getRandomItem(key);
                    item = item.substring(0, key.length()).toUpperCase() + item.substring(key.length());
                    this.plan.add(item + "\n");
                    System.out.println(item);
                    
                     if (curamount == itemcount) {
                         break;
                     }

                }
                 else if (j == 2) {
                     
                     int pref = this.prefix;
                        if (pref == 0 || curamount == input.length()-1) {
                             ch = input.charAt(curamount);
                             key = String.valueOf(ch);
                             
                             } else {
                                 
                                while (pref > 0) {
                                    
                                    if (input.substring(curamount,input.length()).length() <= pref) {
                                        pref--;
                                        continue;
                                    }
                                
                                    key = input.substring(curamount, input.length()).substring(0, pref);
                                 if (this.drinkstore.containsKey(key) == true) {
                                     curamount += key.length() - 1;
                                     break;
                                 } else {
                                     
                                     pref--;
                                     continue;
                                 }   
                             }
                             }
                        
                        item = this.drinkstore.getRandomItem(key);
                        item = item.substring(0, key.length()).toUpperCase() + item.substring(key.length());
                        this.plan.add(item + "\n");
                        System.out.println(item);
                        
                         if (curamount == itemcount) {
                             break;
                         }
                }
                

            }       
    
             return this.plan;
}
        

        public static void main(String[] args) throws IOException  {
              if (args.length != 0) {
                String arg = args[0];
                arg = arg.toLowerCase();
                for (int i = 0; i < arg.length(); i++) { 
                    
                    boolean isLetter = Character.isLetter(arg.toCharArray()[i]);
                    if (isLetter) {
                        break;
                    } else {
                        System.err.println("Please only enter valid characters [no numbers or special characters]");
                        System.exit(0);
                }
                
                
                }
                if (args.length == 1) {
                    PicnicPlanner picnic = new PicnicPlanner();
                    picnic.generate(arg);
                } else {
                String prefixarg = args[1];
                int prefix;
                prefix = Integer.parseInt(prefixarg);
                if (prefix >0) {
                    PicnicPlanner picnic = new PicnicPlanner(prefix);
                    picnic.generate(arg);
            } else {
                System.err.println("prefix has to be at least 1");
                System.exit(0);
            }
          }
          
    } else {
        System.out.println("please enter a valid word");
    }
        }
}

        
