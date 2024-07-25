import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;
import java.util.ArrayList;

public class MainMenu   extends JFrame{
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
        categoryChoice.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                category = categoryChoice.getSelectedIndex();
                showCategory(category,allItems);
            }
        });

        searchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
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
                    ItemsNameList.setListData(namesList.toArray());
                    ItemsPriceList.setListData(priceList.toArray());
                    ItemsWebsiteList.setListData(websiteList.toArray());
                }
            }
        });
        searchName.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                searchFor = searchName.getText();
            }
        });
        sortBy.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ArrayList<String> namesList = new ArrayList<>();
                ArrayList<String> priceList = new ArrayList<>();
                ArrayList<String> websiteList = new ArrayList<>();
                ArrayList<item> temp = new ArrayList<>();

                temp.addAll(allItems.getAllItems()[category]);
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
                ItemsNameList.setListData(namesList.toArray());
                ItemsPriceList.setListData(priceList.toArray());
                ItemsWebsiteList.setListData(websiteList.toArray());
            }
        });
        ItemsNameList.addMouseWheelListener(new MouseWheelListener() {
            @Override
            public void mouseWheelMoved(MouseWheelEvent e) {
                ItemsPriceList. (e.getWheelRotation()*e.getScrollAmount());
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

        ItemsNameList.setListData(namesList.toArray());
        ItemsPriceList.setListData(priceList.toArray());
        ItemsWebsiteList.setListData(websiteList.toArray());

    }
}
