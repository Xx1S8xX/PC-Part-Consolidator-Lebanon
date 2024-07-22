import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class MainMenu   extends JFrame{
    private JTextField searchName;
    private JComboBox categoryChoice;
    private JScrollPane itemsList;
    private JButton searchButton;
    private JComboBox sortBy;
    private JTextArea shownItems;
    private JPanel MainMenu;
    private int category;
    private String searchFor;

    public MainMenu(AyoubComputers ayoubComputers, Mojitech mojitech, PCandParts pcAndParts) {
        searchFor = " ";
        shownItems.setEditable(false);
        setContentPane(MainMenu);
        AllItems allItems = new AllItems(ayoubComputers, mojitech, pcAndParts);
        setVisible(true);
        setSize(1000,800);
        setResizable(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        showAllItems(allItems);
        shownItems.setFont(Font.getFont(Font.MONOSPACED));
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
                shownItems.setText("");
                if(category < 0 || category > 7) {
                    showAllItems(allItems);
                }
                else {
                    for (item item: allItems.getAllItems()[category]) {
                        if(item.getName().toLowerCase().contains(searchFor.toLowerCase()))
                            shownItems.append(item.getName() + "        $" + item.getPrice() +"         "+ item.getWebsite() +"\n");
                    }
                }
            }
        });
        searchName.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                searchFor = searchName.getText();
                System.out.println(searchFor);
            }
        });
        sortBy.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                shownItems.setText("");
                ArrayList<item> temp = new ArrayList<>();
                if(category < 0 || category > 7) {
                    for(ArrayList<item> items: allItems.getAllItems())
                        temp.addAll(items);
                }
                else {
                    temp.addAll(allItems.getAllItems()[category]);
                    switch (sortBy.getSelectedIndex()) {
                        case 0:
                            temp = sortByPriceLowToHigh(temp);
                            for(item item:temp)
                                if(item.getName().toLowerCase().contains(searchFor.toLowerCase()))
                                    shownItems.append(item.getName()+"              $"+item.getPrice()+"                "+item.getWebsite()+'\n');
                            break;
                        case 1:
                            temp = sortByPriceHighToLow(temp);
                            for(item item:temp)
                                if(item.getName().toLowerCase().contains(searchFor.toLowerCase()))
                                    shownItems.append(item.getName()+"              $"+item.getPrice()+"                "+item.getWebsite()+'\n');
                            break;
                    }
                }
            }
        });
    }
    public ArrayList<item> sortByPriceLowToHigh(ArrayList<item> items) {
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
    public ArrayList<item> sortByPriceHighToLow(ArrayList<item> items) {
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
    public void showAllItems(AllItems allItems) {
        shownItems.setText("");
        int count = 0;
        shownItems.append(allItems.getAllItems()[0].get(0).getName() + "    $" + allItems.getAllItems()[0].get(0).getPrice() + "      " + allItems.getAllItems()[0].get(0).getWebsite());
        for (int i = 0; i < allItems.getAllItems().length; i++) {
            for (item item: allItems.getAllItems()[i]) {
                if (count != 0)
                    shownItems.append("\n" + item.getName() + "    $" + item.getPrice()+ "      " + item.getWebsite());
                count++;
            }
        }
    }
    public void showCategory(int choice, AllItems allItems) {
        shownItems.setText("");
        int count = 0;
        shownItems.append(allItems.getAllItems()[choice].get(0).getName() + "    $" + allItems.getAllItems()[choice].get(0).getPrice() + "      " + allItems.getAllItems()[choice].get(0).getWebsite());
        for (item item: allItems.getAllItems()[choice]) {
            if (count != 0)
                shownItems.append("\n" + item.getName() + "    $" + item.getPrice() + "     " + item.getWebsite());
            count++;
        }
    }
}
