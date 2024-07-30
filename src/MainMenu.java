import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Arrays;
public class MainMenu   extends JFrame {
    private JTextField searchName;
    private JComboBox categoryChoice;
    private JScrollPane itemsList;
    private JButton searchButton;
    private JComboBox sortBy;
    private JPanel MainMenu;
    private JButton UpdateSources;
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
    private JList pcBuilds;
    private JButton deletePCButton;
    private JTextField pcNameTextField;
    private JLabel currentPcName;
    private int category;
    private String searchFor;
    private int index;
    private int index2;
    private PCBuild pcBuild;
    private ArrayList<PCBuild> builds;
    public MainMenu(AyoubComputers ayoubComputers, Mojitech mojitech, PCandParts pcAndParts, ArrayList<PCBuild> Builds) {
        index = -1;
        index2 = -1;
        searchFor = " ";
        builds = Builds;
        pcBuilds.setListData(getPCNames(builds));
        setContentPane(MainMenu);
        AllItems allItems = new AllItems(ayoubComputers, mojitech, pcAndParts);
        setVisible(true);
        setSize(1920,1080);
        setResizable(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        showCategory(0,allItems);
        pcBuild = new PCBuild(null, null, null, null, null, null, null, null, null);
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
        storageLabel.setText("Storage:");
        storagePriceLabel.setText("Price: 0");
        coolerLabel.setText("Cooler:");
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
                index = -1;
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
                            if(item.getWebsite().contains("mojitech.net"))
                                websiteList.add("mojitech.net");
                            else if(item.getWebsite().contains("pcandparts.com"))
                                websiteList.add("pcandparts.com");
                            else if(item.getWebsite().contains("ayoubcomputers.com"))
                                websiteList.add("ayoubcomputers.com");
                            else
                                websiteList.add("N/A");
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
                                if(item.getWebsite().contains("mojitech.net"))
                                    websiteList.add("mojitech.net");
                                else if(item.getWebsite().contains("pcandparts.com"))
                                    websiteList.add("pcandparts.com");
                                else if(item.getWebsite().contains("ayoubcomputers.com"))
                                    websiteList.add("ayoubcomputers.com");
                                else
                                    websiteList.add("N/A");
                            }
                        }
                        break;
                    case 1:
                        temp = sortByPriceHighToLow(temp);
                        for (item item : temp) {
                            if (item.getName().toLowerCase().contains(searchFor.toLowerCase())) {
                                namesList.add(item.getName());
                                priceList.add(String.valueOf(item.getPrice()));
                                if(item.getWebsite().contains("mojitech.net"))
                                    websiteList.add("mojitech.net");
                                else if(item.getWebsite().contains("pcandparts.com"))
                                    websiteList.add("pcandparts.com");
                                else if(item.getWebsite().contains("ayoubcomputers.com"))
                                    websiteList.add("ayoubcomputers.com");
                                else
                                    websiteList.add("N/A");
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
                    try {
                        ItemsNameList.setSelectedIndex(ItemsNameList.getSelectedIndex() + ((e.getScrollAmount() * e.getWheelRotation()) / 2));
                        ItemsNameList.ensureIndexIsVisible(ItemsNameList.getSelectedIndex());
                        ItemsPriceList.setSelectedIndex(ItemsNameList.getSelectedIndex());
                        ItemsPriceList.ensureIndexIsVisible(ItemsNameList.getSelectedIndex());
                        ItemsWebsiteList.setSelectedIndex(ItemsNameList.getSelectedIndex());
                        ItemsWebsiteList.ensureIndexIsVisible(ItemsNameList.getSelectedIndex());
                    }
                    catch (Exception exception) {
                        System.out.println("Error in scrolling");
                    }
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
                    File ayoubFile = new File(System.getProperty("user.home") + System.getProperty("file.separator") + "ayoubComputers.txt");
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
                    File pcAndPartsFile = new File(System.getProperty("user.home") + System.getProperty("file.separator") + "pcAndParts.txt");
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
                    File mojitechFile = new File(System.getProperty("user.home") + System.getProperty("file.separator") + "mojitech.txt");
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
                            else if(pcAndParts.getItems()[i].get(a).getName().contains("(TAX included)")) {
                                pcAndParts.getItems()[i].get(a).setName(pcAndParts.getItems()[i].get(a).getName().replace("(TAX included)",""));
                            }
                            else {
                                pcAndParts.getItems()[i].get(a).setPrice(pcAndParts.getItems()[i].get(a).getPrice() * 1.11);
                                pcAndParts.getItems()[i].get(a).setPrice(Math.round(pcAndParts.getItems()[i].get(a).getPrice() * 100.0) / 100.0);
                            }
                        }
                    }
                    AllItems allItems = new AllItems(ayoubComputers,mojitech,pcAndParts);
                    File savedPCsFile = new File(System.getProperty("user.home") + System.getProperty("file.separator") + "savedPCs.txt");
                    Save savedPCsSave = new Save(savedPCsFile);
                    Read savedPCsRead = new Read(savedPCsFile);
                    ArrayList<PCBuild> builds = new ArrayList<>();
                    try {
                        builds = savedPCsRead.readPcBuilds(allItems);
                    }
                    catch (Exception exception) {
                        savedPCsSave.savePcBuilds(builds);
                    }

                    pcAndPartsSave.saveAllPcAndPartsItems(pcAndParts);
                    mojitechSave.saveAllMojitechItems(mojitech);
                    ayoubSave.saveAllAyoubItems(ayoubComputers);
                    dispose();
                    new MainMenu(ayoubComputers,mojitech,pcAndParts,builds);
                }
                catch (Exception ex) {
                    System.out.println("Error in updating sources");
                }
            }
        });
        pcNameTextField.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                pcBuild.setName(pcNameTextField.getText());
                currentPcName.setText("PC Name: "+pcBuild.getName());
            }
        });
        savePCButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ArrayList<String> names = new ArrayList<>(Arrays.asList(getPCNames(builds)));
                try {
                    if (!pcBuild.getName().isEmpty() && names.contains(pcBuilds.getName()) && names.get(names.indexOf(pcBuild.getName())).length() != pcBuild.getName().length()) {
                        try {
                            System.out.println("option 1");
                            builds.add(pcBuild);
                            Save save = new Save(new File(System.getProperty("user.home") + System.getProperty("file.separator") + "savedPCs.txt"));
                            save.savePcBuilds(builds);
                        } catch (FileNotFoundException ex) {
                            throw new RuntimeException(ex);
                        }
                    } else if (!pcBuild.getName().isEmpty() && !names.contains(pcBuild.getName())) {
                        try {
                            builds.add(pcBuild);
                            Save save = new Save(new File(System.getProperty("user.home") + System.getProperty("file.separator") + "savedPCs.txt"));
                            save.savePcBuilds(builds);
                        } catch (FileNotFoundException ex) {
                            throw new RuntimeException(ex);
                        }
                    } else if (!pcBuild.getName().isEmpty() && names.contains(pcBuild.getName())) {
                        try {
                            builds.set(arrayListIndexOfString(builds, pcBuild.getName()), pcBuild);
                            Save save = new Save(new File(System.getProperty("user.home") + System.getProperty("file.separator") + "savedPCs.txt"));
                            save.savePcBuilds(builds);
                        } catch (FileNotFoundException ex) {
                            throw new RuntimeException(ex);
                        }
                    }
                    pcBuilds.setListData(getPCNames(builds));
                }
                catch (Exception exception) {
                    System.out.println("Error when saving pcs");
                }
            }
        });
        deletePCButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    builds.remove(pcBuilds.getSelectedIndex());
                    Save save = new Save(new File(System.getProperty("user.home") + System.getProperty("file.separator") + "savedPCs.txt"));
                    save.savePcBuilds(builds);
                    pcBuilds.setListData(getPCNames(builds));
                } catch (FileNotFoundException ex) {
                    throw new RuntimeException(ex);
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
                    index = ItemsNameList.getSelectedIndex();
                }
                else if(e.getKeyCode() == 38) {
                    ItemsPriceList.setSelectedIndex(ItemsNameList.getSelectedIndex() - 1);
                    ItemsPriceList.ensureIndexIsVisible(ItemsNameList.getSelectedIndex() - 1);
                    ItemsWebsiteList.setSelectedIndex(ItemsNameList.getSelectedIndex() - 1);
                    ItemsWebsiteList.ensureIndexIsVisible(ItemsNameList.getSelectedIndex() - 1);
                    index = ItemsNameList.getSelectedIndex();
                }
                else if(e.getKeyCode() == KeyEvent.VK_ENTER) {
                    switch (category) {
                        case 0:
                            pcBuild.setPowerSupply(allItems.getAllItems()[category].get(allItems.searchForName(String.valueOf(ItemsNameList.getSelectedValue()),category)));
                            powerSupplyLabel.setText("<html>" + "Power Supply: " + pcBuild.getPowerSupply().getName() + "</html>");
                            powerSupplyPriceLabel.setText("Price: " + pcBuild.getPowerSupply().getPrice());
                            totalPriceLabel.setText("Total Price: " + pcBuild.getPriceOfBuild());
                            break;
                        case 1:
                            pcBuild.setCpu(allItems.getAllItems()[category].get(allItems.searchForName(String.valueOf(ItemsNameList.getSelectedValue()),category)));
                            cpuLabel.setText("<html>" + "CPU: " + pcBuild.getCpu().getName() + "</html>");
                            cpuPriceLabel.setText("Price: " + pcBuild.getCpu().getPrice());
                            totalPriceLabel.setText("Total Price: " + pcBuild.getPriceOfBuild());
                            break;
                        case 2:
                            pcBuild.setGpu(allItems.getAllItems()[category].get(allItems.searchForName(String.valueOf(ItemsNameList.getSelectedValue()),category)));
                            gpuLabel.setText("<html>" + "GPU: " + pcBuild.getGpu().getName() + "</html>");
                            gpuPriceLabel.setText("Price: " + pcBuild.getGpu().getPrice());
                            totalPriceLabel.setText("Total Price: " + pcBuild.getPriceOfBuild());
                            break;
                        case 3:
                            pcBuild.setRam(allItems.getAllItems()[category].get(allItems.searchForName(String.valueOf(ItemsNameList.getSelectedValue()),category)));
                            ramLabel.setText("<html>" + "RAM: " + pcBuild.getRam().getName() + "</html>");
                            ramPriceLabel.setText("Price: " + pcBuild.getRam().getPrice());
                            totalPriceLabel.setText("Total Price: " + pcBuild.getPriceOfBuild());
                            break;
                        case 4:
                            pcBuild.setMotherboard(allItems.getAllItems()[category].get(allItems.searchForName(String.valueOf(ItemsNameList.getSelectedValue()),category)));
                            motherboardLabel.setText("<html>" + "Motherboard: " + pcBuild.getMotherboard().getName() + "</html>");
                            motherboardPriceLabel.setText("Price: " + pcBuild.getMotherboard().getPrice());
                            totalPriceLabel.setText("Total Price: " + pcBuild.getPriceOfBuild());
                            break;
                        case 5:
                            pcBuild.setCase(allItems.getAllItems()[category].get(allItems.searchForName(String.valueOf(ItemsNameList.getSelectedValue()),category)));
                            caseLabel.setText("<html>" + "Case: " + pcBuild.getCase().getName() + "</html>");
                            casePriceLabel.setText("Price: " + pcBuild.getCase().getPrice());
                            totalPriceLabel.setText("Total Price: " + pcBuild.getPriceOfBuild());
                            break;
                        case 6:
                            pcBuild.setStorage(allItems.getAllItems()[category].get(allItems.searchForName(String.valueOf(ItemsNameList.getSelectedValue()),category)));
                            storageLabel.setText("<html>" + "Storage: " + pcBuild.getStorage().getName() + "</html>");
                            storagePriceLabel.setText("Price: " + pcBuild.getStorage().getPrice());
                            totalPriceLabel.setText("Total Price: " + pcBuild.getPriceOfBuild());
                            break;
                        case 7:
                            pcBuild.setCooler(allItems.getAllItems()[category].get(allItems.searchForName(String.valueOf(ItemsNameList.getSelectedValue()),category)));
                            coolerLabel.setText("<html>" + "Cooler: " + pcBuild.getCooler().getName() + "</html>");
                            coolingPriceLabel.setText("Price: " + pcBuild.getCooler().getPrice());
                            totalPriceLabel.setText("Total Price: " + pcBuild.getPriceOfBuild());
                            break;
                    }
                }
            }
        });
        ItemsPriceList.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                super.keyPressed(e);
                if(e.getKeyCode() == 40) {
                    ItemsNameList.setSelectedIndex(ItemsPriceList.getSelectedIndex() + 1);
                    ItemsNameList.ensureIndexIsVisible(ItemsPriceList.getSelectedIndex() + 1);
                    ItemsWebsiteList.setSelectedIndex(ItemsPriceList.getSelectedIndex() + 1);
                    ItemsWebsiteList.ensureIndexIsVisible(ItemsPriceList.getSelectedIndex() + 1);
                    index = ItemsPriceList.getSelectedIndex();
                }
                else if(e.getKeyCode() == 38) {
                    ItemsNameList.setSelectedIndex(ItemsPriceList.getSelectedIndex() - 1);
                    ItemsNameList.ensureIndexIsVisible(ItemsPriceList.getSelectedIndex() - 1);
                    ItemsWebsiteList.setSelectedIndex(ItemsPriceList.getSelectedIndex() - 1);
                    ItemsWebsiteList.ensureIndexIsVisible(ItemsPriceList.getSelectedIndex() - 1);
                    index = ItemsPriceList.getSelectedIndex();
                }
                else if(e.getKeyCode() == KeyEvent.VK_ENTER) {
                    switch (category) {
                        case 0:
                            pcBuild.setPowerSupply(allItems.getAllItems()[category].get(allItems.searchForName(String.valueOf(ItemsNameList.getSelectedValue()),category)));
                            powerSupplyLabel.setText("<html>" + "Power Supply: " + pcBuild.getPowerSupply().getName() + "</html>");
                            powerSupplyPriceLabel.setText("Price: " + pcBuild.getPowerSupply().getPrice());
                            totalPriceLabel.setText("Total Price: " + pcBuild.getPriceOfBuild());
                            break;
                        case 1:
                            pcBuild.setCpu(allItems.getAllItems()[category].get(allItems.searchForName(String.valueOf(ItemsNameList.getSelectedValue()),category)));
                            cpuLabel.setText("<html>" + "CPU: " + pcBuild.getCpu().getName() + "</html>");
                            cpuPriceLabel.setText("Price: " + pcBuild.getCpu().getPrice());
                            totalPriceLabel.setText("Total Price: " + pcBuild.getPriceOfBuild());
                            break;
                        case 2:
                            pcBuild.setGpu(allItems.getAllItems()[category].get(allItems.searchForName(String.valueOf(ItemsNameList.getSelectedValue()),category)));
                            gpuLabel.setText("<html>" + "GPU: " + pcBuild.getGpu().getName() + "</html>");
                            gpuPriceLabel.setText("Price: " + pcBuild.getGpu().getPrice());
                            totalPriceLabel.setText("Total Price: " + pcBuild.getPriceOfBuild());
                            break;
                        case 3:
                            pcBuild.setRam(allItems.getAllItems()[category].get(allItems.searchForName(String.valueOf(ItemsNameList.getSelectedValue()),category)));
                            ramLabel.setText("<html>" + "RAM: " + pcBuild.getRam().getName() + "</html>");
                            ramPriceLabel.setText("Price: " + pcBuild.getRam().getPrice());
                            totalPriceLabel.setText("Total Price: " + pcBuild.getPriceOfBuild());
                            break;
                        case 4:
                            pcBuild.setMotherboard(allItems.getAllItems()[category].get(allItems.searchForName(String.valueOf(ItemsNameList.getSelectedValue()),category)));
                            motherboardLabel.setText("<html>" + "Motherboard: " + pcBuild.getMotherboard().getName() + "</html>");
                            motherboardPriceLabel.setText("Price: " + pcBuild.getMotherboard().getPrice());
                            totalPriceLabel.setText("Total Price: " + pcBuild.getPriceOfBuild());
                            break;
                        case 5:
                            pcBuild.setCase(allItems.getAllItems()[category].get(allItems.searchForName(String.valueOf(ItemsNameList.getSelectedValue()),category)));
                            caseLabel.setText("<html>" + "Case: " + pcBuild.getCase().getName() + "</html>");
                            casePriceLabel.setText("Price: " + pcBuild.getCase().getPrice());
                            totalPriceLabel.setText("Total Price: " + pcBuild.getPriceOfBuild());
                            break;
                        case 6:
                            pcBuild.setStorage(allItems.getAllItems()[category].get(allItems.searchForName(String.valueOf(ItemsNameList.getSelectedValue()),category)));
                            storageLabel.setText("<html>" + "Storage: " + pcBuild.getStorage().getName() + "</html>");
                            storagePriceLabel.setText("Price: " + pcBuild.getStorage().getPrice());
                            totalPriceLabel.setText("Total Price: " + pcBuild.getPriceOfBuild());
                            break;
                        case 7:
                            pcBuild.setCooler(allItems.getAllItems()[category].get(allItems.searchForName(String.valueOf(ItemsNameList.getSelectedValue()),category)));
                            coolerLabel.setText("<html>" + "Cooler: " + pcBuild.getCooler().getName() + "</html>");
                            coolingPriceLabel.setText("Price: " + pcBuild.getCooler().getPrice());
                            totalPriceLabel.setText("Total Price: " + pcBuild.getPriceOfBuild());
                            break;
                    }
                }
            }
        });
        ItemsWebsiteList.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                super.keyPressed(e);
                if(e.getKeyCode() == 40) {
                    ItemsPriceList.setSelectedIndex(ItemsWebsiteList.getSelectedIndex() + 1);
                    ItemsPriceList.ensureIndexIsVisible(ItemsWebsiteList.getSelectedIndex() + 1);
                    ItemsNameList.setSelectedIndex(ItemsWebsiteList.getSelectedIndex() + 1);
                    ItemsNameList.ensureIndexIsVisible(ItemsWebsiteList.getSelectedIndex() + 1);
                    index = ItemsWebsiteList.getSelectedIndex();
                }
                else if(e.getKeyCode() == 38) {
                    ItemsPriceList.setSelectedIndex(ItemsWebsiteList.getSelectedIndex() - 1);
                    ItemsPriceList.ensureIndexIsVisible(ItemsWebsiteList.getSelectedIndex() - 1);
                    ItemsNameList.setSelectedIndex(ItemsWebsiteList.getSelectedIndex() - 1);
                    ItemsNameList.ensureIndexIsVisible(ItemsWebsiteList.getSelectedIndex() - 1);
                    index = ItemsWebsiteList.getSelectedIndex();
                }
                else if(e.getKeyCode() == KeyEvent.VK_ENTER) {
                    switch (category) {
                        case 0:
                            pcBuild.setPowerSupply(allItems.getAllItems()[category].get(allItems.searchForName(String.valueOf(ItemsNameList.getSelectedValue()),category)));
                            powerSupplyLabel.setText("<html>" + "Power Supply: " + pcBuild.getPowerSupply().getName() + "</html>");
                            powerSupplyPriceLabel.setText("Price: " + pcBuild.getPowerSupply().getPrice());
                            totalPriceLabel.setText("Total Price: " + pcBuild.getPriceOfBuild());
                            break;
                        case 1:
                            pcBuild.setCpu(allItems.getAllItems()[category].get(allItems.searchForName(String.valueOf(ItemsNameList.getSelectedValue()),category)));
                            cpuLabel.setText("<html>" + "CPU: " + pcBuild.getCpu().getName() + "</html>");
                            cpuPriceLabel.setText("Price: " + pcBuild.getCpu().getPrice());
                            totalPriceLabel.setText("Total Price: " + pcBuild.getPriceOfBuild());
                            break;
                        case 2:
                            pcBuild.setGpu(allItems.getAllItems()[category].get(allItems.searchForName(String.valueOf(ItemsNameList.getSelectedValue()),category)));
                            gpuLabel.setText("<html>" + "GPU: " + pcBuild.getGpu().getName() + "</html>");
                            gpuPriceLabel.setText("Price: " + pcBuild.getGpu().getPrice());
                            totalPriceLabel.setText("Total Price: " + pcBuild.getPriceOfBuild());
                            break;
                        case 3:
                            pcBuild.setRam(allItems.getAllItems()[category].get(allItems.searchForName(String.valueOf(ItemsNameList.getSelectedValue()),category)));
                            ramLabel.setText("<html>" + "RAM: " + pcBuild.getRam().getName() + "</html>");
                            ramPriceLabel.setText("Price: " + pcBuild.getRam().getPrice());
                            totalPriceLabel.setText("Total Price: " + pcBuild.getPriceOfBuild());
                            break;
                        case 4:
                            pcBuild.setMotherboard(allItems.getAllItems()[category].get(allItems.searchForName(String.valueOf(ItemsNameList.getSelectedValue()),category)));
                            motherboardLabel.setText("<html>" + "Motherboard: " + pcBuild.getMotherboard().getName() + "</html>");
                            motherboardPriceLabel.setText("Price: " + pcBuild.getMotherboard().getPrice());
                            totalPriceLabel.setText("Total Price: " + pcBuild.getPriceOfBuild());
                            break;
                        case 5:
                            pcBuild.setCase(allItems.getAllItems()[category].get(allItems.searchForName(String.valueOf(ItemsNameList.getSelectedValue()),category)));
                            caseLabel.setText("<html>" + "Case: " + pcBuild.getCase().getName() + "</html>");
                            casePriceLabel.setText("Price: " + pcBuild.getCase().getPrice());
                            totalPriceLabel.setText("Total Price: " + pcBuild.getPriceOfBuild());
                            break;
                        case 6:
                            pcBuild.setStorage(allItems.getAllItems()[category].get(allItems.searchForName(String.valueOf(ItemsNameList.getSelectedValue()),category)));
                            storageLabel.setText("<html>" + "Storage: " + pcBuild.getStorage().getName() + "</html>");
                            storagePriceLabel.setText("Price: " + pcBuild.getStorage().getPrice());
                            totalPriceLabel.setText("Total Price: " + pcBuild.getPriceOfBuild());
                            break;
                        case 7:
                            pcBuild.setCooler(allItems.getAllItems()[category].get(allItems.searchForName(String.valueOf(ItemsNameList.getSelectedValue()),category)));
                            coolerLabel.setText("<html>" + "Cooler: " + pcBuild.getCooler().getName() + "</html>");
                            coolingPriceLabel.setText("Price: " + pcBuild.getCooler().getPrice());
                            totalPriceLabel.setText("Total Price: " + pcBuild.getPriceOfBuild());
                            break;
                    }
                }
            }
        });
        ItemsNameList.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                ItemsNameList.setSelectedIndex(ItemsNameList.getSelectedIndex());
                ItemsNameList.ensureIndexIsVisible(ItemsNameList.getSelectedIndex());
                ItemsPriceList.setSelectedIndex(ItemsNameList.getSelectedIndex());
                ItemsPriceList.ensureIndexIsVisible(ItemsNameList.getSelectedIndex());
                ItemsWebsiteList.setSelectedIndex(ItemsNameList.getSelectedIndex());
                ItemsWebsiteList.ensureIndexIsVisible(ItemsNameList.getSelectedIndex());
                super.mouseClicked(e);
                if(index == ItemsNameList.getSelectedIndex()) {
                    try {
                        Desktop desktop = Desktop.isDesktopSupported() ? Desktop.getDesktop() : null;
                        URI uri = new URI(allItems.getAllItems()[category].get(allItems.searchForName(String.valueOf(ItemsNameList.getSelectedValue()),category)).getWebsite());
                        desktop.browse(uri);
                    } catch (URISyntaxException | IOException ex) {
                        System.out.println("Could not open website");
                    }

                }
                else {
                    index = ItemsNameList.getSelectedIndex();
                }
            }
        });
        ItemsPriceList.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                ItemsNameList.setSelectedIndex(ItemsPriceList.getSelectedIndex());
                ItemsNameList.ensureIndexIsVisible(ItemsPriceList.getSelectedIndex());
                ItemsWebsiteList.setSelectedIndex(ItemsPriceList.getSelectedIndex());
                ItemsWebsiteList.ensureIndexIsVisible(ItemsPriceList.getSelectedIndex());
                super.mouseClicked(e);
                if(index == ItemsPriceList.getSelectedIndex()) {
                    try {
                        Desktop desktop = Desktop.isDesktopSupported() ? Desktop.getDesktop() : null;
                        URI uri = new URI(allItems.getAllItems()[category].get(allItems.searchForName(String.valueOf(ItemsNameList.getSelectedValue()),category)).getWebsite());
                        desktop.browse(uri);
                    } catch (URISyntaxException | IOException ex) {
                        System.out.println("Could not open website");
                    }
                }
                else {
                    index = ItemsNameList.getSelectedIndex();
                }
            }
        });
        ItemsWebsiteList.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                ItemsNameList.setSelectedIndex(ItemsWebsiteList.getSelectedIndex());
                ItemsNameList.ensureIndexIsVisible(ItemsWebsiteList.getSelectedIndex());
                ItemsPriceList.setSelectedIndex(ItemsWebsiteList.getSelectedIndex());
                ItemsPriceList.ensureIndexIsVisible(ItemsWebsiteList.getSelectedIndex());
                super.mouseClicked(e);
                if(index == ItemsWebsiteList.getSelectedIndex()) {
                    try {
                        Desktop desktop = Desktop.isDesktopSupported() ? Desktop.getDesktop() : null;
                        URI uri = new URI(allItems.getAllItems()[category].get(allItems.searchForName(String.valueOf(ItemsNameList.getSelectedValue()),category)).getWebsite());
                        desktop.browse(uri);
                    } catch (URISyntaxException | IOException ex) {
                        System.out.println("Could not open website");
                    }
                }
                else {
                    index = ItemsNameList.getSelectedIndex();
                }
            }
        });
        powerSupplyLabel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                try {
                    Desktop desktop = Desktop.isDesktopSupported() ? Desktop.getDesktop() : null;
                    URI uri = new URI(pcBuild.getPowerSupply().getWebsite());
                    desktop.browse(uri);
                } catch (URISyntaxException | IOException ex) {
                    System.out.println("Could not open website");
                }
            }
        });
        cpuLabel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                try {
                    Desktop desktop = Desktop.isDesktopSupported() ? Desktop.getDesktop() : null;
                    URI uri = new URI(pcBuild.getCpu().getWebsite());
                    desktop.browse(uri);
                } catch (URISyntaxException | IOException ex) {
                    System.out.println("Could not open website");
                }
            }
        });
        gpuLabel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                try {
                    Desktop desktop = Desktop.isDesktopSupported() ? Desktop.getDesktop() : null;
                    URI uri = new URI(pcBuild.getGpu().getWebsite());
                    desktop.browse(uri);
                } catch (URISyntaxException | IOException ex) {
                    System.out.println("Could not open website");
                }
            }
        });
        ramLabel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                try {
                    Desktop desktop = Desktop.isDesktopSupported() ? Desktop.getDesktop() : null;
                    URI uri = new URI(pcBuild.getRam().getWebsite());
                    desktop.browse(uri);
                } catch (URISyntaxException | IOException ex) {
                    System.out.println("Could not open website");
                }
            }
        });
        motherboardLabel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                try {
                    Desktop desktop = Desktop.isDesktopSupported() ? Desktop.getDesktop() : null;
                    URI uri = new URI(pcBuild.getMotherboard().getWebsite());
                    desktop.browse(uri);
                } catch (URISyntaxException | IOException ex) {
                    System.out.println("Could not open website");
                }
            }
        });
        caseLabel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                try {
                    Desktop desktop = Desktop.isDesktopSupported() ? Desktop.getDesktop() : null;
                    URI uri = new URI(pcBuild.getCase().getWebsite());
                    desktop.browse(uri);
                } catch (URISyntaxException | IOException ex) {
                    System.out.println("Could not open website");
                }
            }
        });
        storageLabel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                try {
                    Desktop desktop = Desktop.isDesktopSupported() ? Desktop.getDesktop() : null;
                    URI uri = new URI(pcBuild.getStorage().getWebsite());
                    desktop.browse(uri);
                } catch (URISyntaxException | IOException ex) {
                    System.out.println("Could not open website");
                }
            }
        });
        coolerLabel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                try {
                    Desktop desktop = Desktop.isDesktopSupported() ? Desktop.getDesktop() : null;
                    URI uri = new URI(pcBuild.getCooler().getWebsite());
                    desktop.browse(uri);
                } catch (URISyntaxException | IOException ex) {
                    System.out.println("Could not open website");
                }
            }
        });
        pcBuilds.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                if(index2 == pcBuilds.getSelectedIndex() && index2 != -1) {
	                try {
		                Read read = new Read(new File(System.getProperty("user.home") + System.getProperty("file.separator") + "savedPCs.txt"));
                        pcBuild = builds.get(index2);
                        Save save = new Save(new File(System.getProperty("user.home") + System.getProperty("file.separator") + "savedPCs.txt"));
                        save.savePcBuilds(builds);
                        builds = read.readPcBuilds(allItems);
                        currentPcName.setText("PC Name: " + builds.get(index2).getName());
                        pcNameTextField.setText(builds.get(index2).getName());
                        powerSupplyLabel.setText("<html>" + "Power Supply: " + builds.get(index2).getPowerSupply().getName() + "</html>");
                        powerSupplyPriceLabel.setText("<html>" + "Price: " + builds.get(index2).getPowerSupply().getPrice() + "</html>");
                        cpuLabel.setText("<html>" + "CPU: " + builds.get(index2).getCpu().getName() + "</html>");
                        cpuPriceLabel.setText("<html>" + "Price: " + builds.get(index2).getCpu().getPrice() + "</html>");
                        gpuLabel.setText("<html>" + "GPU: " + builds.get(index2).getGpu().getName() + "</html>");
                        gpuPriceLabel.setText("<html>" + "Price: " + builds.get(index2).getGpu().getPrice() + "</html>");
                        ramLabel.setText("<html>" + "RAM: " + builds.get(index2).getRam().getName() + "</html>");
                        ramPriceLabel.setText("<html>" + "Price: " + builds.get(index2).getRam().getPrice() + "</html>");
                        motherboardLabel.setText("<html>" + "Motherboard: " + builds.get(index2).getMotherboard().getName() + "</html>");
                        motherboardPriceLabel.setText("<html>" + "Price: " + builds.get(index2).getMotherboard().getPrice() + "</html>");
                        caseLabel.setText("<html>" + "Case: " + builds.get(index2).getCase().getName() + "</html>");
                        casePriceLabel.setText("<html>" + "Price: " + builds.get(index2).getCase().getPrice() + "</html>");
                        storageLabel.setText("<html>" + "Storage: " + builds.get(index2).getStorage().getName() + "</html>");
                        storagePriceLabel.setText("<html>" + "Price: " + builds.get(index2).getStorage().getPrice() + "</html>");
                        coolerLabel.setText("<html>" + "Cooler: " + builds.get(index2).getCooler().getName() + "</html>");
                        coolingPriceLabel.setText("<html>" + "Price: " + builds.get(index2).getCooler().getPrice() + "</html>");
                        totalPriceLabel.setText("<html>" + "Total Price: " + Math.round(builds.get(index2).getPriceOfBuild()*10)/10 + "</html>");
	                } catch (FileNotFoundException ex) {
		                throw new RuntimeException(ex);
	                }
                    index2 = -1;
                }
                else
                    index2 = pcBuilds.getSelectedIndex();
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
                if(item.getWebsite().contains("mojitech.net"))
                    websiteList.add("mojitech.net");
                else if(item.getWebsite().contains("pcandparts.com"))
                    websiteList.add("pcandparts.com");
                else if(item.getWebsite().contains("ayoubcomputers.com"))
                    websiteList.add("ayoubcomputers.com");
                else
                    websiteList.add("N/A");
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
            if(item.getWebsite().contains("mojitech.net"))
                websiteList.add("mojitech.net");
            else if(item.getWebsite().contains("pcandparts.com"))
                websiteList.add("pcandparts.com");
            else if(item.getWebsite().contains("ayoubcomputers.com"))
                websiteList.add("ayoubcomputers.com");
            else
                websiteList.add("N/A");
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
    public int arrayListIndexOfString(ArrayList<PCBuild> builds, String name) {
        int index = 0;
        for(PCBuild build: builds) {
            if(name.equals(build.getName()))
                return index;
            index++;
        }
        return -1;
    }
    public String[] getPCNames(ArrayList<PCBuild> builds) {
        String[] names = new String[builds.size()];
        int index = 0;
        for(PCBuild build: builds) {
            names[index] = build.getName();
            index ++;
        }
        return names;
    }
}
