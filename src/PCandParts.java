import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
public class PCandParts {
    private final ArrayList<item>[] items;
    private final String [] urls =      {"https://pcandparts.com/power-supplies/",
                                        "https://pcandparts.com/cpu/",
                                        "https://pcandparts.com/video-card/",
                                        "https://pcandparts.com/memory/",
                                        "https://pcandparts.com/motherboard/",
                                        "https://pcandparts.com/computer-cases/",
                                        "https://pcandparts.com/storage-hdd-hard-drives-nvme-ssd-m2/",      "https://pcandparts.com/storage-hdd-hard-drives-nvme-ssd-m2/page/2/",
                                        "https://pcandparts.com/cooling/",                                  "https://pcandparts.com/cooling/page/2/"};
    public PCandParts(ArrayList<item>[] items) {
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
    private ArrayList<item> getItemPCandParts(String url) throws IOException {
        ArrayList<item> items = new ArrayList<>();
        final String userAgent = "Mozilla/5.0 (X11; U; Linux i586; en-US; rv:1.7.3) Gecko/20040924 Epiphany/1.4.4 (Ubuntu)";
        Document doc = Jsoup.connect(url).userAgent(userAgent).get();
        Elements elements = doc.select("div.product-small.box ");
        String name;
        String price;
        String website;
        for(int i = 0; i < elements.size(); i ++)
        {
            Element element = elements.get(i);
            Element element2 = element;
            Element element3 = element;
            name = element.select("a.woocommerce-LoopProduct-link.woocommerce-loop-product__link").text();
            website = element3.select("a.woocommerce-LoopProduct-link.woocommerce-loop-product__link").attr("href");
            if(!element2.select("span.price").text().equals("Out Of Stock") && !element2.select("span.price").text().equals("Request Price"))
            {
                price = element2.select("bdi").text();
                if(price.contains(" "))
                    price = price.substring(price.indexOf(" ")+1);
                item temp_item = new item(name.replace("-"," "),Double.parseDouble(price.replace("$","").replace(",","")),website);
                items.add(temp_item);
            }
        }
        return items;
    }
    public void getAllItemPCandParts() throws IOException {
        ArrayList<item> temp;

        // Power Supplies
        this.items[0] = getItemPCandParts(this.urls[0]);
        System.out.println("Power Supplies PC and Parts");

        // CPUs
        this.items[1] = getItemPCandParts(this.urls[1]);
        System.out.println("CPUs PC and Parts");

        // GPUs
        this.items[2] = getItemPCandParts(this.urls[2]);
        System.out.println("GPUs PC and Parts");

        // RAMs
        this.items[3] = getItemPCandParts(this.urls[3]);
        System.out.println("RAMs PC and Parts");

        // Motherboards
        this.items[4] = getItemPCandParts(this.urls[4]);
        System.out.println("Motherboards PC and Parts");

        // Cases
        this.items[5] = getItemPCandParts(this.urls[5]);
        System.out.println("Cases PC and Parts");

        // Storage
        this.items[6] = getItemPCandParts(this.urls[6]);
        temp = getItemPCandParts(urls[7]);
        for(item item:temp)
            items[6].add(item);
        System.out.println("Storage PC and Parts");

        //Cooling
        this.items[7] = getItemPCandParts(this.urls[8]);
        temp = getItemPCandParts(urls[9]);
        for(item item:temp)
            items[7].add(item);
        System.out.println("Cooling PC and Parts");
    }
}