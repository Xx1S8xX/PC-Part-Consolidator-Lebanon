import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
public class Mojitech {
    private final ArrayList<item>[] items;
    private final String [] urls =      {"https://mojitech.net/product-category/pc-parts/power-supplies/",
                                        "https://mojitech.net/product-category/pc-parts/cpus/",             "https://mojitech.net/product-category/pc-parts/cpus/page/2/",
                                        "https://mojitech.net/product-category/pc-parts/video-cards/",
                                        "https://mojitech.net/product-category/pc-parts/memory/",
                                        "https://mojitech.net/product-category/pc-parts/motherboards/",     "https://mojitech.net/product-category/pc-parts/motherboards/page/2/",      "https://mojitech.net/product-category/pc-parts/motherboards/page/3/",
                                        "https://mojitech.net/product-category/pc-parts/computer-cases/",   "https://mojitech.net/product-category/pc-parts/computer-cases/page/2/",
                                        "https://mojitech.net/product-category/pc-parts/storage/",          "https://mojitech.net/product-category/pc-parts/storage/page/2/",           "https://mojitech.net/product-category/pc-parts/storage/page/3/",
                                        "https://mojitech.net/product-category/pc-parts/cooling/",          "https://mojitech.net/product-category/pc-parts/cooling/page/2/"};
    public Mojitech(ArrayList<item>[] items) {
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
    private ArrayList<item> getItemMojitech(String url) throws IOException {
        ArrayList<item> items = new ArrayList<>();
        final String userAgent = "Mozilla/5.0 (X11; U; Linux i586; en-US; rv:1.7.3) Gecko/20040924 Epiphany/1.4.4 (Ubuntu)";
        Document doc = Jsoup.connect(url).userAgent(userAgent).get();
        Elements elements = doc.select("div.col-inner");
        String name;
        String price;
        String website;
        for(int i = 0; i < elements.size(); i ++)
        {
            Element element = elements.get(i);
            Element element2 = element;
            Element element3 = element;
            name = element.select("a.woocommerce-LoopProduct-link.woocommerce-loop-product__link").text();
            website = "https://mojitech.net" + element3.select("a.woocommerce-LoopProduct-link.woocommerce-loop-product__link").attr("href");
            System.out.println(website);
            if(!element2.select("strong").text().equals("Call for price"))
            {
                price = element2.select("bdi").text();
                if(price.contains(" "))
                    price = price.substring(price.indexOf(" ")+1);
                item temp_item = new item(name.replace("-"," "),Double.parseDouble(price.replace("$","").replace(",","")), website);
                items.add(temp_item);
            }
        }
        return items;
    }
    public void getAllItemMojitech() throws IOException {
        ArrayList<item> temp;

        // Power Supplies
        this.items[0] = getItemMojitech(this.urls[0]);
        System.out.println("Power Supplies MOJITECH");

        // CPUs
        this.items[1] = getItemMojitech(this.urls[1]);
        temp = getItemMojitech(urls[2]);
        for(item item:temp)
            items[1].add(item);
        System.out.println("CPUs MOJITECH");

        // GPUs
        this.items[2] = getItemMojitech(this.urls[3]);
        System.out.println("GPUs MOJITECH");

        // RAMs
        this.items[3] = getItemMojitech(this.urls[4]);
        System.out.println("RAMs MOJITECH");

        // Motherboards
        this.items[4] = getItemMojitech(this.urls[5]);
        temp = getItemMojitech(urls[6]);
        for(item item:temp)
            items[4].add(item);
        temp = getItemMojitech(urls[7]);
        for(item item:temp)
            items[4].add(item);
        System.out.println("Motherboards MOJITECH");

        // Cases
        this.items[5] = getItemMojitech(this.urls[8]);
        temp = getItemMojitech(urls[9]);
        for(item item:temp)
            items[5].add(item);
        System.out.println("Cases MOJITECH");

        // Storage
        this.items[6] = getItemMojitech(this.urls[9]);
        temp = getItemMojitech(urls[10]);
        for(item item:temp)
            items[6].add(item);
        temp = getItemMojitech(urls[11]);
        for(item item:temp)
            items[6].add(item);
        System.out.println("Storage MOJITECH");

        //Cooling
        this.items[7] = getItemMojitech(this.urls[12]);
        temp = getItemMojitech(urls[13]);
        for(item item:temp)
            items[7].add(item);
        System.out.println("Cooling MOJITECH");
    }
}