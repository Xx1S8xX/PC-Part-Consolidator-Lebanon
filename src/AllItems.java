import java.lang.reflect.Array;
import java.util.ArrayList;

public class AllItems {
    private ArrayList<item>[] allItems = (ArrayList<item>[]) new ArrayList[8];
    public AllItems(AyoubComputers ayoubComputers, Mojitech mojitech, PCandParts pcAndParts) {
        allItems[0] = new ArrayList<item>();
        allItems[1] = new ArrayList<item>();
        allItems[2] = new ArrayList<item>();
        allItems[3] = new ArrayList<item>();
        allItems[4] = new ArrayList<item>();
        allItems[5] = new ArrayList<item>();
        allItems[6] = new ArrayList<item>();
        allItems[7] = new ArrayList<item>();
        int count = 0;
        for(ArrayList<item> items: ayoubComputers.getItems()) {
            for(item item: items)
                allItems[count].add(item);
            count ++;
        }
        count = 0;
        for(ArrayList<item> items: mojitech.getItems()) {
            for(item item: items)
                allItems[count].add(item);
            count ++;
        }
        count = 0;
        for(ArrayList<item> items: pcAndParts.getItems()) {
            for(item item: items)
                allItems[count].add(item);
            count ++;
        }
    }

    public ArrayList<item>[] getAllItems() {
        return allItems;
    }

}
