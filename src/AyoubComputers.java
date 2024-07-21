import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;

public class AyoubComputers {
    private ArrayList<item>[] items;
    private String [] urls =   {"https://ayoubcomputers.com/computer-components/power-supply/?mode=6&sort=priceasc&limit=100", "https://ayoubcomputers.com/computer-components/power-supply/?&page=2&sort=priceasc&limit=100&mode=6",
                                "https://ayoubcomputers.com/cpu/?sort=priceasc&limit=100&mode=6",
                                "https://ayoubcomputers.com/computer-components/video-graphic-card/?mode=6&sort=priceasc&limit=100", "https://ayoubcomputers.com/computer-components/video-graphic-card/?&page=2&sort=priceasc&limit=100&mode=6",
                                "https://ayoubcomputers.com/computer-components/ram/?mode=6&sort=priceasc&limit=100", "https://ayoubcomputers.com/computer-components/ram/?&page=2&sort=priceasc&limit=100&mode=6", "https://ayoubcomputers.com/computer-components/ram/?&page=3&sort=priceasc&limit=100&mode=6", "https://ayoubcomputers.com/computer-components/ram/?&page=4&sort=priceasc&limit=100&mode=6",
                                "https://ayoubcomputers.com/computer-components/motherboard/?sort=priceasc&limit=100&mode=6", "https://ayoubcomputers.com/computer-components/motherboard/?&page=2&sort=priceasc&limit=100&mode=6", "https://ayoubcomputers.com/computer-components/motherboard/?&page=3&sort=priceasc&limit=100&mode=6",
                                "https://ayoubcomputers.com/computer-components/computer-case/?mode=6&sort=priceasc&limit=100", "https://ayoubcomputers.com/computer-components/computer-case/?&page=2&sort=priceasc&limit=100&mode=6",
                                "https://ayoubcomputers.com/computer-components/storage-drives/?mode=6&sort=priceasc&limit=100", "https://ayoubcomputers.com/computer-components/storage-drives/?&page=2&sort=priceasc&limit=100&mode=6", "https://ayoubcomputers.com/computer-components/storage-drives/?&page=3&sort=priceasc&limit=100&mode=6", "https://ayoubcomputers.com/computer-components/storage-drives/?&page=4&sort=priceasc&limit=100&mode=6", "https://ayoubcomputers.com/computer-components/storage-drives/?&page=5&sort=priceasc&limit=100&mode=6",
                                "https://ayoubcomputers.com/computer-components/fans-cooling/?sort=priceasc&limit=100&mode=6", "https://ayoubcomputers.com/computer-components/fans-cooling/?&page=2&sort=priceasc&limit=100&mode=6", "https://ayoubcomputers.com/computer-components/fans-cooling/?&page=3&sort=priceasc&limit=100&mode=6", "https://ayoubcomputers.com/computer-components/fans-cooling/?&page=4&sort=priceasc&limit=100&mode=6"};
    public AyoubComputers(ArrayList<item>[] items) {
        // 0: Power Supply
        // 1: CPUS
        // 2: GPUS
        // 3: Ram
        // 4: Motherboards
        // 5: Cases
        // 6: Storage
        // 7: Cooling
        this.items = items;
    }

    public void setItems(ArrayList<item>[] items) {
        this.items = items;
    }

    public ArrayList<item>[] getItems() {
        return items;
    }

    public String[] getUrls() {
        return urls;
    }

    public void setUrls(String[] urls) {
        this.urls = urls;
    }
    private ArrayList<item> getItemAyoub(String url) throws IOException {
        ArrayList<item> items = new ArrayList<>();
        Document doc = Jsoup.connect(url).get();
        Elements elements = doc.select("li.product");
        String name;
        String price;
        for(int i = 0; i < elements.size(); i ++)
        {
            Element element = elements.get(i);
            Element element2 = elements.get(i);
            name = element.select("h4.card-title a").text();
            if(!element2.select("span.price.price--withoutTAX.price--main").isEmpty())
            {
                price = element2.select("span.price.price--withoutTAX.price--main").text();
                price = price.substring(0, price.indexOf(" "));
                item temp_item = new item(name, Double.parseDouble(price.replace("$", "").replace(",", "")), "Ayoub Computers");
                items.add(temp_item);
            }
        }
        return items;
    }
    public void getAllItemAyoub() throws IOException {
        ArrayList<item> temp;

        // Power Supplies
        this.items[0] = getItemAyoub(this.urls[0]);
        temp = getItemAyoub(urls[1]);
        for(item item:temp)
            items[0].add(item);
        System.out.println("Power Supplies");

        // CPUs
        this.items[1] = getItemAyoub(this.urls[2]);
        System.out.println("CPUs");

        // GPUs
        this.items[2] = getItemAyoub(this.urls[3]);
        temp = getItemAyoub(urls[4]);
        for(item item:temp)
            items[2].add(item);
        System.out.println("GPUs");

        // RAMs
        this.items[3] = getItemAyoub(this.urls[5]);
        temp = getItemAyoub(urls[6]);
        for(item item:temp)
            items[3].add(item);
        temp = getItemAyoub(urls[7]);
        for(item item:temp)
            items[3].add(item);
        temp = getItemAyoub(urls[8]);
        for(item item:temp)
            items[3].add(item);
        System.out.println("RAMs");

        // Motherboards
        this.items[4] = getItemAyoub(this.urls[9]);
        temp = getItemAyoub(urls[10]);
        for(item item:temp)
            items[4].add(item);
        temp = getItemAyoub(urls[11]);
        for(item item:temp)
            items[4].add(item);
        System.out.println("Motherboards");

        // Cases
        this.items[5] = getItemAyoub(this.urls[12]);
        temp = getItemAyoub(urls[13]);
        for(item item:temp)
            items[5].add(item);
        System.out.println("Cases");

        // Storage
        this.items[6] = getItemAyoub(this.urls[14]);
        temp = getItemAyoub(urls[15]);
        for(item item:temp)
            items[6].add(item);
        temp = getItemAyoub(urls[16]);
        for(item item:temp)
            items[6].add(item);
        temp = getItemAyoub(urls[17]);
        for(item item:temp)
            items[6].add(item);
        temp = getItemAyoub(urls[18]);
        for(item item:temp)
            items[6].add(item);
        System.out.println("Storage");

        //Cooling
        this.items[7] = getItemAyoub(this.urls[19]);
        temp = getItemAyoub(urls[20]);
        for(item item:temp)
            items[7].add(item);
        temp = getItemAyoub(urls[21]);
        for(item item:temp)
            items[7].add(item);
        temp = getItemAyoub(urls[22]);
        for(item item:temp)
            items[7].add(item);
        System.out.println("Cooling");

        for(int i = 0; i < items.length; i++)
            System.out.println(i+": "+items[i].size());
    }
}
