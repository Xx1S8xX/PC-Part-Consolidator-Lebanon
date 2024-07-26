import javax.swing.*;
import java.awt.event.*;
import java.io.File;
import java.util.ArrayList;

public class MainMenu   extends JFrame {
    private JTextField searchName;
    private JComboBox categoryChoice;
    private JScrollPane itemsList;
    private JButton searchButton;
    private JComboBox sortBy;
    private JPanel MainMenu;
    private JButton UpdateSources;
    private JTextArea textArea1;
    private JList ItemsNameList;
    private JList ItemsPriceList;
    private JList ItemsWebsiteList;
    private JButton button2;
    private JScrollPane PriceList;
    private JScrollPane WebsiteList;
    private int category;
    private String searchFor;

    public MainMenu(AyoubComputers ayoubComputers, Mojitech mojitech, PCandParts pcAndParts) {
        searchFor = " ";
        setContentPane(MainMenu);
        AllItems allItems = new AllItems(ayoubComputers, mojitech, pcAndParts);
        setVisible(true);
        setSize(1000,800);
        setResizable(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        showAllItems(allItems);
        categoryChoice.addItem("Power Supply");
        categoryChoice.addItem("CPU");
        categoryChoice.addItem("GPU");
        categoryChoice.addItem("Ram");
        categoryChoice.addItem("Motherboard");
        categoryChoice.addItem("Case");
        categoryChoice.addItem("Storage");
        categoryChoice.addItem("Cooling");
        sortBy.addItem("Price High To Low");
        sortBy.addItem("Price Low to High");
        PriceList.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
        WebsiteList.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
        itemsList.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);

        categoryChoice.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                category = categoryChoice.getSelectedIndex();
                showCategory(category,allItems);
            }
        });
        searchName.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                searchFor = searchName.getText();
                if(category < 0 || category > 7) {
                    showAllItems(allItems);
                }
                else {
                    ArrayList<String> namesList = new ArrayList<>();
                    ArrayList<String> priceList = new ArrayList<>();
                    ArrayList<String> websiteList = new ArrayList<>();
                    for (item item: allItems.getAllItems()[category]) {
                        if(item.getName().toLowerCase().contains(searchFor.toLowerCase())) {
                            namesList.add(item.getName());
                            priceList.add(String.valueOf(item.getPrice()));
                            websiteList.add(item.getWebsite());
                        }
                    }
                    ItemsWebsiteList.setSelectedIndex(0);
                    ItemsWebsiteList.ensureIndexIsVisible(ItemsWebsiteList.getSelectedIndex());
                    ItemsPriceList.setSelectedIndex(0);
                    ItemsPriceList.ensureIndexIsVisible(ItemsWebsiteList.getSelectedIndex());
                    ItemsNameList.setSelectedIndex(0);
                    ItemsNameList.ensureIndexIsVisible(ItemsWebsiteList.getSelectedIndex());
                    ItemsNameList.setListData(namesList.toArray());
                    ItemsPriceList.setListData(priceList.toArray());
                    ItemsWebsiteList.setListData(websiteList.toArray());
                }
            }
        });
        sortBy.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ArrayList<String> namesList = new ArrayList<>();
                ArrayList<String> priceList = new ArrayList<>();
                ArrayList<String> websiteList = new ArrayList<>();
                ArrayList<item> temp = new ArrayList<>(allItems.getAllItems()[category]);

                switch (sortBy.getSelectedIndex()) {
                    case 0:
                        temp = sortByPriceLowToHigh(temp);
                        for (item item : temp) {
                            if (item.getName().toLowerCase().contains(searchFor.toLowerCase())) {
                                namesList.add(item.getName());
                                priceList.add(String.valueOf(item.getPrice()));
                                websiteList.add(item.getWebsite());
                            }
                        }
                        break;
                    case 1:
                        temp = sortByPriceHighToLow(temp);
                        for (item item : temp) {
                            if (item.getName().toLowerCase().contains(searchFor.toLowerCase())) {
                                namesList.add(item.getName());
                                priceList.add(String.valueOf(item.getPrice()));
                                websiteList.add(item.getWebsite());
                            }
                        }
                        break;
                }
                ItemsWebsiteList.setSelectedIndex(0);
                ItemsWebsiteList.ensureIndexIsVisible(ItemsWebsiteList.getSelectedIndex());
                ItemsPriceList.setSelectedIndex(0);
                ItemsPriceList.ensureIndexIsVisible(ItemsWebsiteList.getSelectedIndex());
                ItemsNameList.setSelectedIndex(0);
                ItemsNameList.ensureIndexIsVisible(ItemsWebsiteList.getSelectedIndex());
                ItemsNameList.setListData(namesList.toArray());
                ItemsPriceList.setListData(priceList.toArray());
                ItemsWebsiteList.setListData(websiteList.toArray());
            }
        });
        ItemsNameList.addMouseWheelListener(new MouseWheelListener() {
            @Override
            public void mouseWheelMoved(MouseWheelEvent e) {
                if(ItemsNameList.getSelectedIndex() > 0 || e.getWheelRotation() > 0) {
                    ItemsNameList.setSelectedIndex(ItemsNameList.getSelectedIndex() + ((e.getScrollAmount() * e.getWheelRotation()) / 2));
                    ItemsNameList.ensureIndexIsVisible(ItemsNameList.getSelectedIndex());
                    ItemsPriceList.setSelectedIndex(ItemsNameList.getSelectedIndex());
                    ItemsPriceList.ensureIndexIsVisible(ItemsNameList.getSelectedIndex());
                    ItemsWebsiteList.setSelectedIndex(ItemsNameList.getSelectedIndex());
                    ItemsWebsiteList.ensureIndexIsVisible(ItemsNameList.getSelectedIndex());
                }
            }
        });
        ItemsPriceList.addMouseWheelListener(new MouseWheelListener() {
            @Override
            public void mouseWheelMoved(MouseWheelEvent e) {
                if(ItemsNameList.getSelectedIndex() > 0 || e.getWheelRotation() > 0) {
                    ItemsPriceList.setSelectedIndex(ItemsPriceList.getSelectedIndex() + ((e.getScrollAmount() * e.getWheelRotation()) / 2));
                    ItemsPriceList.ensureIndexIsVisible(ItemsPriceList.getSelectedIndex());
                    ItemsNameList.setSelectedIndex(ItemsPriceList.getSelectedIndex());
                    ItemsNameList.ensureIndexIsVisible(ItemsPriceList.getSelectedIndex());
                    ItemsWebsiteList.setSelectedIndex(ItemsPriceList.getSelectedIndex());
                    ItemsWebsiteList.ensureIndexIsVisible(ItemsPriceList.getSelectedIndex());
                }
            }
        });
        ItemsWebsiteList.addMouseWheelListener(new MouseWheelListener() {
            @Override
            public void mouseWheelMoved(MouseWheelEvent e) {
                if(ItemsNameList.getSelectedIndex() > 0 || e.getWheelRotation() > 0) {
                    ItemsWebsiteList.setSelectedIndex(ItemsWebsiteList.getSelectedIndex() + ((e.getScrollAmount() * e.getWheelRotation()) / 2));
                    ItemsWebsiteList.ensureIndexIsVisible(ItemsWebsiteList.getSelectedIndex());
                    ItemsPriceList.setSelectedIndex(ItemsWebsiteList.getSelectedIndex());
                    ItemsPriceList.ensureIndexIsVisible(ItemsWebsiteList.getSelectedIndex());
                    ItemsNameList.setSelectedIndex(ItemsWebsiteList.getSelectedIndex());
                    ItemsNameList.ensureIndexIsVisible(ItemsWebsiteList.getSelectedIndex());
                }
            }
        });
        UpdateSources.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    File ayoubFile = new File("ayoubFile.txt");
                    Save ayoubSave = new Save(ayoubFile);
                    Read ayoubRead = new Read(ayoubFile);
                    ArrayList<item>[] ayoubItems = (ArrayList<item>[]) new ArrayList[8];
                    AyoubComputers ayoubComputers;
                    try {
                        ayoubComputers = ayoubRead.readAyoubComputersData();
                    } catch (Exception ex) {
                        System.out.println("No File Found");
                        ayoubComputers = new AyoubComputers(ayoubItems);
                    }
                    ayoubComputers.getAllItemAyoub();


                    // PC and Parts Stuff
                    File pcAndPartsFile = new File("pcAndPartsFile.txt");
                    Save pcAndPartsSave = new Save(pcAndPartsFile);
                    Read pcAndPartsRead = new Read(pcAndPartsFile);
                    ArrayList<item>[] pcAndPartsItems = (ArrayList<item>[]) new ArrayList[8];
                    PCandParts pcAndParts;
                    try {
                        pcAndParts = pcAndPartsRead.readPcAndPartsData();
                    } catch (Exception ex) {
                        System.out.println("No File Found");
                        pcAndParts = new PCandParts(pcAndPartsItems);
                    }
                    pcAndParts.getAllItemPCandParts();


                    // Mojitech Stuff
                    File mojitechFile = new File("mojitechFile.txt");
                    Save mojitechSave = new Save(mojitechFile);
                    Read mojitechRead = new Read(mojitechFile);
                    ArrayList<item>[] mojitechItems = (ArrayList<item>[]) new ArrayList[8];
                    Mojitech mojitech;
                    try {
                        mojitech = mojitechRead.readMojitechData();
                    } catch (Exception ex) {
                        System.out.println("No File Found");
                        mojitech = new Mojitech(mojitechItems);
                    }
                    mojitech.getAllItemMojitech();

                    for (int i = 0; i < mojitech.getItems().length; i++) {
                        for (item item: mojitech.getItems()[i]) {
                            if (item.getName().contains("Tax Free")) {
                                item.setName(item.getName().replace("Tax Free",""));
                            }
                            else if(item.getName().contains("free tax")) {
                                item.setName(item.getName().replace("free tax",""));
                            }
                            else if(!item.getName().contains("Tax Included")) {
                                item.setName(item.getName().replace("Tax Included",""));
                            }
                            else if(!item.getName().contains("Tax included")) {
                                item.setName(item.getName().replace("Tax included",""));
                            }
                            else {
                                item.setPrice(item.getPrice() * 1.11);
                                item.setPrice(Math.round(item.getPrice()));
                            }
                        }
                    }
                    for (int i = 0; i < ayoubComputers.getItems().length; i++) {
                        for (item item: ayoubComputers.getItems()[i]) {
                            if (item.getName().contains("Tax Free")) {
                                item.setName(item.getName().replace("Tax Free",""));
                            }
                            else if(item.getName().contains("free tax")) {
                                item.setName(item.getName().replace("free tax",""));
                            }
                            else if(!item.getName().contains("Tax Included")) {
                                item.setName(item.getName().replace("Tax Included",""));
                            }
                            else if(!item.getName().contains("Tax included")) {
                                item.setName(item.getName().replace("Tax included",""));
                            }
                            else {
                                item.setPrice(item.getPrice() * 1.11);
                                item.setPrice(Math.round(item.getPrice()));
                            }
                        }
                    }
                    for (int i = 0; i < pcAndParts.getItems().length; i++) {
                        for (item item: pcAndParts.getItems()[i]) {
                            if (item.getName().contains("Tax Free")) {
                                item.setName(item.getName().replace("Tax Free",""));
                            }
                            else if(item.getName().contains("free tax")) {
                                item.setName(item.getName().replace("free tax",""));
                            }
                            else if(!item.getName().contains("Tax Included")) {
                                item.setName(item.getName().replace("Tax Included",""));
                            }
                            else if(!item.getName().contains("Tax included")) {
                                item.setName(item.getName().replace("Tax included",""));
                            }
                            else {
                                item.setPrice(item.getPrice() * 1.11);
                                item.setPrice(Math.round(item.getPrice()));
                            }
                        }
                    }
                    pcAndPartsSave.saveAllPcAndPartsItems(pcAndParts);
                    mojitechSave.saveAllMojitechItems(mojitech);
                    ayoubSave.saveAllAyoubItems(ayoubComputers);
                    dispose();
                    new MainMenu(ayoubComputers,mojitech,pcAndParts);
                }
                catch (Exception ex) {
                    System.out.println("Error in updating sources");
                }
            }
        });
        ItemsNameList.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                super.keyPressed(e);
                if(e.getKeyCode() == 40) {
                    ItemsPriceList.setSelectedIndex(ItemsNameList.getSelectedIndex() + 1);
                    ItemsPriceList.ensureIndexIsVisible(ItemsNameList.getSelectedIndex() + 1);
                    ItemsWebsiteList.setSelectedIndex(ItemsNameList.getSelectedIndex() + 1);
                    ItemsWebsiteList.ensureIndexIsVisible(ItemsNameList.getSelectedIndex() + 1);
                    System.out.println("Down");
                }
                else if(e.getKeyCode() == 38) {
                    ItemsPriceList.setSelectedIndex(ItemsNameList.getSelectedIndex() - 1);
                    ItemsPriceList.ensureIndexIsVisible(ItemsNameList.getSelectedIndex() - 1);
                    ItemsWebsiteList.setSelectedIndex(ItemsNameList.getSelectedIndex() - 1);
                    ItemsWebsiteList.ensureIndexIsVisible(ItemsNameList.getSelectedIndex() - 1);
                    System.out.println("Up");
                }
            }
        });
    }
    public ArrayList<item> sortByPriceLowToHigh(ArrayList<item> items) {
        if(items.size() <= 1)
            return items;
        for(int x = 0; x < items.size(); x++) {
            for(int i = 0; i < items.size()-1; i++) {
                if (items.get(i).getPrice() < items.get(i+1).getPrice()) {
                    item item = items.get(i);
                    items.set(i,items.get(i+1));
                    items.set(i+1,item);
                }
            }
        }
        return items;
    }
    public ArrayList<item> sortByPriceHighToLow(ArrayList<item> items) {
        if(items.size() <= 1)
            return items;
        for(int x = 0; x < items.size(); x++) {
            for(int i = 0; i < items.size()-1; i++) {
                if (items.get(i).getPrice() > items.get(i+1).getPrice()) {
                    item item = items.get(i);
                    items.set(i,items.get(i+1));
                    items.set(i+1,item);
                }
            }
        }
        return items;
    }
    public void showAllItems(AllItems allItems) {
        ArrayList<String> namesList = new ArrayList<>();
        ArrayList<String> priceList = new ArrayList<>();
        ArrayList<String> websiteList = new ArrayList<>();

        for (int i = 0; i < allItems.getAllItems().length; i++) {
            for (item item: allItems.getAllItems()[i]) {
                namesList.add(item.getName());
                priceList.add(String.valueOf(item.getPrice()));
                websiteList.add(item.getWebsite());
            }
        }
        ItemsWebsiteList.setSelectedIndex(0);
        ItemsWebsiteList.ensureIndexIsVisible(ItemsWebsiteList.getSelectedIndex());
        ItemsPriceList.setSelectedIndex(0);
        ItemsPriceList.ensureIndexIsVisible(ItemsWebsiteList.getSelectedIndex());
        ItemsNameList.setSelectedIndex(0);
        ItemsNameList.ensureIndexIsVisible(ItemsWebsiteList.getSelectedIndex());
        ItemsNameList.setListData(namesList.toArray());
        ItemsPriceList.setListData(priceList.toArray());
        ItemsWebsiteList.setListData(websiteList.toArray());
    }
    public void showCategory(int choice, AllItems allItems) {

        ArrayList<String> namesList = new ArrayList<>();
        ArrayList<String> priceList = new ArrayList<>();
        ArrayList<String> websiteList = new ArrayList<>();

        for (item item: allItems.getAllItems()[choice]) {
            namesList.add(item.getName());
            priceList.add(String.valueOf(item.getPrice()));
            websiteList.add(item.getWebsite());
        }
        ItemsWebsiteList.setSelectedIndex(0);
        ItemsWebsiteList.ensureIndexIsVisible(ItemsWebsiteList.getSelectedIndex());
        ItemsPriceList.setSelectedIndex(0);
        ItemsPriceList.ensureIndexIsVisible(ItemsWebsiteList.getSelectedIndex());
        ItemsNameList.setSelectedIndex(0);
        ItemsNameList.ensureIndexIsVisible(ItemsWebsiteList.getSelectedIndex());
        ItemsNameList.setListData(namesList.toArray());
        ItemsPriceList.setListData(priceList.toArray());
        ItemsWebsiteList.setListData(websiteList.toArray());

    }
}
