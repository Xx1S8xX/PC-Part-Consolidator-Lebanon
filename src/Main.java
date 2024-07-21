import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

public class Main {
    public static void main(String[] args) throws IOException {

        ArrayList<item>[] items = (ArrayList<item>[]) new ArrayList[8];
        ArrayList<item> temp = new ArrayList<>();
        String fileName = "data.txt";
        Save save = new Save(fileName);
        AyoubComputers ayoubComputers = new AyoubComputers(items);
        ayoubComputers.getAllItemAyoub();
        for(ArrayList<item> data: ayoubComputers.getItems()) {
            save.writeItemToFile(data);
        }
        save.closePW();
    }
}