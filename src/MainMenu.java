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
    private JButton savePCButton;
    private JScrollPane PriceList;
    private JScrollPane WebsiteList;
    private JLabel powerSupplyLabel;
    private JLabel cpuLabel;
    private JLabel gpuLabel;
    private JLabel ramLabel;
    private JLabel motherboardLabel;
    private JLabel caseLabel;
    private JLabel storageLabel;
    private JLabel coolerLabel;
    private JLabel totalPriceLabel;
    private JLabel powerSupplyPriceLabel;
    private JLabel cpuPriceLabel;
    private JLabel gpuPriceLabel;
    private JLabel ramPriceLabel;
    private JLabel motherboardPriceLabel;
    private JLabel casePriceLabel;
    private JLabel storagePriceLabel;
    private JLabel coolingPriceLabel;
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
        PCBuild pcBuild = new PCBuild(null, null, null, null, null, null, null, null);
        powerSupplyLabel.setText("Power Supply:");
        powerSupplyPriceLabel.setText("Price: 0");
        cpuLabel.setText("CPU:");
        cpuPriceLabel.setText("Price: 0");
        gpuLabel.setText("GPU:");
        gpuPriceLabel.setText("Price: 0");
        ramLabel.setText("RAM:");
        ramPriceLabel.setText("Price: 0");
        motherboardLabel.setText("Motherboard:");
        motherboardPriceLabel.setText("Price: 0");
        caseLabel.setText("Case:");
        casePriceLabel.setText("Price: 0");
        storageLabel.setText("Storage");
        storagePriceLabel.setText("Price: 0");
        coolerLabel.setText("Cooler");
        coolingPriceLabel.setText("Price: 0");
        totalPriceLabel.setText("Total Price: 0");
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
                        for (int a = 0; a < mojitech.getItems()[i].size(); a++) {
                            if (mojitech.getItems()[i].get(a).getName().contains("Tax Free")) {
                                mojitech.getItems()[i].get(a).setName(mojitech.getItems()[i].get(a).getName().replace("Tax Free",""));
                            }
                            else if(mojitech.getItems()[i].get(a).getName().contains("free tax")) {
                                mojitech.getItems()[i].get(a).setName(mojitech.getItems()[i].get(a).getName().replace("free tax",""));
                            }
                            else if(mojitech.getItems()[i].get(a).getName().contains("Tax Included")) {
                                mojitech.getItems()[i].get(a).setName(mojitech.getItems()[i].get(a).getName().replace("Tax Included",""));
                            }
                            else if(mojitech.getItems()[i].get(a).getName().contains("Tax included")) {
                                mojitech.getItems()[i].get(a).setName(mojitech.getItems()[i].get(a).getName().replace("Tax included",""));
                            }
                            else {
                                mojitech.getItems()[i].get(a).setPrice(mojitech.getItems()[i].get(a).getPrice() * 1.11);
                                mojitech.getItems()[i].get(a).setPrice(Math.round(mojitech.getItems()[i].get(a).getPrice()*100.0) / 100.0);
                            }
                        }
                    }
                    for (int i = 0; i < ayoubComputers.getItems().length; i++) {
                        for (int a = 0; a < ayoubComputers.getItems()[i].size(); a++) {
                            if (ayoubComputers.getItems()[i].get(a).getName().contains("Tax Free")) {
                                ayoubComputers.getItems()[i].get(a).setName(ayoubComputers.getItems()[i].get(a).getName().replace("Tax Free",""));
                            }
                            else if(ayoubComputers.getItems()[i].get(a).getName().contains("free tax")) {
                                ayoubComputers.getItems()[i].get(a).setName(ayoubComputers.getItems()[i].get(a).getName().replace("free tax",""));
                            }
                            else if(ayoubComputers.getItems()[i].get(a).getName().contains("Tax Included")) {
                                ayoubComputers.getItems()[i].get(a).setName(ayoubComputers.getItems()[i].get(a).getName().replace("Tax Included",""));
                            }
                            else if(ayoubComputers.getItems()[i].get(a).getName().contains("Tax included")) {
                                ayoubComputers.getItems()[i].get(a).setName(ayoubComputers.getItems()[i].get(a).getName().replace("Tax included",""));
                            }
                            else {
                                ayoubComputers.getItems()[i].get(a).setPrice(ayoubComputers.getItems()[i].get(a).getPrice() * 1.11);
                                ayoubComputers.getItems()[i].get(a).setPrice(Math.round(ayoubComputers.getItems()[i].get(a).getPrice() * 100.0) / 100.0);
                            }
                        }
                    }
                    for (int i = 0; i < pcAndParts.getItems().length; i++) {
                        for (int a = 0; a < pcAndParts.getItems()[i].size(); a++) {
                            if (pcAndParts.getItems()[i].get(a).getName().contains("Tax Free")) {
                                pcAndParts.getItems()[i].get(a).setName(pcAndParts.getItems()[i].get(a).getName().replace("Tax Free",""));
                            }
                            else if(pcAndParts.getItems()[i].get(a).getName().contains("free tax")) {
                                pcAndParts.getItems()[i].get(a).setName(pcAndParts.getItems()[i].get(a).getName().replace("free tax",""));
                            }
                            else if(pcAndParts.getItems()[i].get(a).getName().contains("Tax Included")) {
                                pcAndParts.getItems()[i].get(a).setName(pcAndParts.getItems()[i].get(a).getName().replace("Tax Included",""));
                            }
                            else if(pcAndParts.getItems()[i].get(a).getName().contains("Tax included")) {
                                pcAndParts.getItems()[i].get(a).setName(pcAndParts.getItems()[i].get(a).getName().replace("Tax included",""));
                            }
                            else {
                                pcAndParts.getItems()[i].get(a).setPrice(pcAndParts.getItems()[i].get(a).getPrice() * 1.11);
                                pcAndParts.getItems()[i].get(a).setPrice(Math.round(pcAndParts.getItems()[i].get(a).getPrice() * 100.0) / 100.0);
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
                else if(e.getKeyCode() == KeyEvent.VK_ENTER) {
                    switch (category) {
                        case 0:
                            pcBuild.setPowerSupply(allItems.getAllItems()[category].get(allItems.searchForName(String.valueOf(ItemsNameList.getSelectedValue()),category)));
                            powerSupplyLabel.setText("Power Supply: " + pcBuild.getPowerSupply().getName());
                            powerSupplyPriceLabel.setText("Price: " + pcBuild.getPowerSupply().getPrice());
                            totalPriceLabel.setText("Total Price: " + pcBuild.getPriceOfBuild());
                            break;
                        case 1:
                            pcBuild.setCpu(allItems.getAllItems()[category].get(allItems.searchForName(String.valueOf(ItemsNameList.getSelectedValue()),category)));
                            cpuLabel.setText("CPU: " + pcBuild.getCpu().getName());
                            cpuPriceLabel.setText("Price: " + pcBuild.getCpu().getPrice());
                            totalPriceLabel.setText("Total Price: " + pcBuild.getPriceOfBuild());
                            break;
                        case 2:
                            pcBuild.setGpu(allItems.getAllItems()[category].get(allItems.searchForName(String.valueOf(ItemsNameList.getSelectedValue()),category)));
                            gpuLabel.setText("GPU: " + pcBuild.getGpu().getName());
                            gpuPriceLabel.setText("Price: " + pcBuild.getGpu().getPrice());
                            totalPriceLabel.setText("Total Price: " + pcBuild.getPriceOfBuild());
                            break;
                        case 3:
                            pcBuild.setRam(allItems.getAllItems()[category].get(allItems.searchForName(String.valueOf(ItemsNameList.getSelectedValue()),category)));
                            ramLabel.setText("RAM: " + pcBuild.getRam().getName());
                            ramPriceLabel.setText("Price: " + pcBuild.getRam().getPrice());
                            totalPriceLabel.setText("Total Price: " + pcBuild.getPriceOfBuild());
                            break;
                        case 4:
                            pcBuild.setMotherboard(allItems.getAllItems()[category].get(allItems.searchForName(String.valueOf(ItemsNameList.getSelectedValue()),category)));
                            motherboardLabel.setText("Motherboard: " + pcBuild.getMotherboard().getName());
                            motherboardPriceLabel.setText("Price: " + pcBuild.getMotherboard().getPrice());
                            totalPriceLabel.setText("Total Price: " + pcBuild.getPriceOfBuild());
                            break;
                        case 5:
                            pcBuild.setCase(allItems.getAllItems()[category].get(allItems.searchForName(String.valueOf(ItemsNameList.getSelectedValue()),category)));
                            caseLabel.setText("Case: " + pcBuild.getCase().getName());
                            casePriceLabel.setText("Price: " + pcBuild.getCase().getPrice());
                            totalPriceLabel.setText("Total Price: " + pcBuild.getPriceOfBuild());
                            break;
                        case 6:
                            pcBuild.setStorage(allItems.getAllItems()[category].get(allItems.searchForName(String.valueOf(ItemsNameList.getSelectedValue()),category)));
                            storageLabel.setText("Storage: " + pcBuild.getStorage().getName());
                            storagePriceLabel.setText("Price: " + pcBuild.getStorage().getPrice());
                            totalPriceLabel.setText("Total Price: " + pcBuild.getPriceOfBuild());
                            break;
                        case 7:
                            pcBuild.setCooler(allItems.getAllItems()[category].get(allItems.searchForName(String.valueOf(ItemsNameList.getSelectedValue()),category)));
                            coolerLabel.setText("Cooler: " + pcBuild.getCooler().getName());
                            coolingPriceLabel.setText("Price: " + pcBuild.getCooler().getPrice());
                            totalPriceLabel.setText("Total Price: " + pcBuild.getPriceOfBuild());
                            break;
                    }
                    System.out.println("Enter");
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
