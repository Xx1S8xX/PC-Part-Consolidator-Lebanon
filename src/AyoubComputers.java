import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import java.io.IOException;
import java.util.ArrayList;
public class AyoubComputers {
    private final ArrayList<item>[] items;
    private final String [] urls =      {"https://ayoubcomputers.com/computer-components/power-supply/?mode=6&sort=priceasc&limit=100",         "https://ayoubcomputers.com/computer-components/power-supply/?&page=2&sort=priceasc&limit=100&mode=6",
                                        "https://ayoubcomputers.com/cpu/?sort=priceasc&limit=100&mode=6",
                                        "https://ayoubcomputers.com/computer-components/video-graphic-card/?mode=6&sort=priceasc&limit=100",    "https://ayoubcomputers.com/computer-components/video-graphic-card/?&page=2&sort=priceasc&limit=100&mode=6",
                                        "https://ayoubcomputers.com/computer-components/ram/?mode=6&sort=priceasc&limit=100",                   "https://ayoubcomputers.com/computer-components/ram/?&page=2&sort=priceasc&limit=100&mode=6",                   "https://ayoubcomputers.com/computer-components/ram/?&page=3&sort=priceasc&limit=100&mode=6",               "https://ayoubcomputers.com/computer-components/ram/?&page=4&sort=priceasc&limit=100&mode=6",
                                        "https://ayoubcomputers.com/computer-components/motherboard/?sort=priceasc&limit=100&mode=6",           "https://ayoubcomputers.com/computer-components/motherboard/?&page=2&sort=priceasc&limit=100&mode=6",           "https://ayoubcomputers.com/computer-components/motherboard/?&page=3&sort=priceasc&limit=100&mode=6",
                                        "https://ayoubcomputers.com/computer-components/computer-case/?mode=6&sort=priceasc&limit=100",         "https://ayoubcomputers.com/computer-components/computer-case/?&page=2&sort=priceasc&limit=100&mode=6",
                                        "https://ayoubcomputers.com/computer-components/storage-drives/?mode=6&sort=priceasc&limit=100",        "https://ayoubcomputers.com/computer-components/storage-drives/?&page=2&sort=priceasc&limit=100&mode=6",        "https://ayoubcomputers.com/computer-components/storage-drives/?&page=3&sort=priceasc&limit=100&mode=6",    "https://ayoubcomputers.com/computer-components/storage-drives/?&page=4&sort=priceasc&limit=100&mode=6",    "https://ayoubcomputers.com/computer-components/storage-drives/?&page=5&sort=priceasc&limit=100&mode=6",
                                        "https://ayoubcomputers.com/computer-components/fans-cooling/?sort=priceasc&limit=100&mode=6",          "https://ayoubcomputers.com/computer-components/fans-cooling/?&page=2&sort=priceasc&limit=100&mode=6",          "https://ayoubcomputers.com/computer-components/fans-cooling/?&page=3&sort=priceasc&limit=100&mode=6",      "https://ayoubcomputers.com/computer-components/fans-cooling/?&page=4&sort=priceasc&limit=100&mode=6"};
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
    public ArrayList<item>[] getItems() {
        return items;
    }
    private ArrayList<item> getItemAyoub(String url) throws IOException {
        ArrayList<item> items = new ArrayList<>();
        final String userAgent = "Mozilla/5.0 (X11; U; Linux i586; en-US; rv:1.7.3) Gecko/20040924 Epiphany/1.4.4 (Ubuntu)";
        Document doc = Jsoup.connect(url).userAgent(userAgent).get();
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
                item temp_item = new item(name.replace("-"," "), Double.parseDouble(price.replace("$", "").replace(",", "")), "Ayoub Computers");
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
        System.out.println("Power Supplies Ayoub Computers");
        // CPUs
        this.items[1] = getItemAyoub(this.urls[2]);
        System.out.println("CPUs Ayoub Computers");
        // GPUs
        this.items[2] = getItemAyoub(this.urls[3]);
        temp = getItemAyoub(urls[4]);
        for(item item:temp)
            items[2].add(item);
        System.out.println("GPUs Ayoub Computers");
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
        System.out.println("RAMs Ayoub Computers");
        // Motherboards
        this.items[4] = getItemAyoub(this.urls[9]);
        temp = getItemAyoub(urls[10]);
        for(item item:temp)
            items[4].add(item);
        temp = getItemAyoub(urls[11]);
        for(item item:temp)
            items[4].add(item);
        System.out.println("Motherboards Ayoub Computers");
        // Cases
        this.items[5] = getItemAyoub(this.urls[12]);
        temp = getItemAyoub(urls[13]);
        for(item item:temp)
            items[5].add(item);
        System.out.println("Cases Ayoub Computers");
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
        System.out.println("Storage Ayoub Computers");
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
        System.out.println("Cooling Ayoub Computers");
    }
}