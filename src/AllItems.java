import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Objects;

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
    public int searchForName(String name, int cat) {
        int index = 0;
        for(item item: getAllItems()[cat]) {
            if(Objects.equals(name, item.getName()))
                return index;
            index ++;
        }
        return -1;
    }
    public ArrayList<item>[] getAllItems() {
        return allItems;
    }

}
