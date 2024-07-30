import java.io.*;
import java.util.ArrayList;
import java.util.Objects;

public class Read {
    private final File file;
    public Read(File file) throws FileNotFoundException {
        this.file = file;
    }
    public File getFile() {
        return file;
    }
    public ArrayList<String> readData() {
        ArrayList<String> data = new ArrayList<>();
        try {
            FileReader fr = new FileReader(file);
            BufferedReader br = new BufferedReader(fr);
            while(br.ready()) {
                data.add(br.readLine());
            }
            br.close();
            fr.close();
        }
        catch (Exception e) {
            System.out.println("Could not create buffered Reader or FileReader");
        }
        return data;
    }
    public AyoubComputers readAyoubComputersData() throws IOException {
        ArrayList<item>[] items = (ArrayList<item>[]) new ArrayList[8];
        items[0] = new ArrayList<item>();
        items[1] = new ArrayList<item>();
        items[2] = new ArrayList<item>();
        items[3] = new ArrayList<item>();
        items[4] = new ArrayList<item>();
        items[5] = new ArrayList<item>();
        items[6] = new ArrayList<item>();
        items[7] = new ArrayList<item>();
        ArrayList<String> data = readData();
        int counter = 0;
        while (counter < data.size()) {
            switch (data.get(counter)) {
                case "POWER SUPPLY":
                    items[0].add(new item(data.get(counter+1).replace("-"," "),Double.parseDouble(data.get(counter+2)),data.get(counter+3)));
                    break;
                case "CPU":
                    items[1].add(new item(data.get(counter+1).replace("-"," "),Double.parseDouble(data.get(counter+2)),data.get(counter+3)));
                    break;
                case "GPU":
                    items[2].add(new item(data.get(counter+1).replace("-"," "),Double.parseDouble(data.get(counter+2)),data.get(counter+3)));
                    break;
                case "RAM":
                    items[3].add(new item(data.get(counter+1).replace("-"," "),Double.parseDouble(data.get(counter+2)),data.get(counter+3)));
                    break;
                case "MOTHERBOARD":
                    items[4].add(new item(data.get(counter+1).replace("-"," "),Double.parseDouble(data.get(counter+2)),data.get(counter+3)));
                    break;
                case "CASE":
                    items[5].add(new item(data.get(counter+1).replace("-"," "),Double.parseDouble(data.get(counter+2)),data.get(counter+3)));
                    break;
                case "STORAGE":
                    items[6].add(new item(data.get(counter+1).replace("-"," "),Double.parseDouble(data.get(counter+2)),data.get(counter+3)));
                    break;
                case "COOLING":
                    items[7].add(new item(data.get(counter+1).replace("-"," "),Double.parseDouble(data.get(counter+2)),data.get(counter+3)));
                    break;
            }
            counter += 4;
        }
        return new AyoubComputers(items);
    }
    public Mojitech readMojitechData() throws IOException {
        ArrayList<item>[] items = (ArrayList<item>[]) new ArrayList[8];
        items[0] = new ArrayList<item>();
        items[1] = new ArrayList<item>();
        items[2] = new ArrayList<item>();
        items[3] = new ArrayList<item>();
        items[4] = new ArrayList<item>();
        items[5] = new ArrayList<item>();
        items[6] = new ArrayList<item>();
        items[7] = new ArrayList<item>();
        ArrayList<String> data = readData();
        int counter = 0;
        while (counter < data.size()) {
            switch (data.get(counter)) {
                case "POWER SUPPLY":
                    items[0].add(new item(data.get(counter+1).replace("-"," "),Double.parseDouble(data.get(counter+2)),data.get(counter+3)));
                    break;
                case "CPU":
                    items[1].add(new item(data.get(counter+1).replace("-"," "),Double.parseDouble(data.get(counter+2)),data.get(counter+3)));
                    break;
                case "GPU":
                    items[2].add(new item(data.get(counter+1).replace("-"," "),Double.parseDouble(data.get(counter+2)),data.get(counter+3)));
                    break;
                case "RAM":
                    items[3].add(new item(data.get(counter+1).replace("-"," "),Double.parseDouble(data.get(counter+2)),data.get(counter+3)));
                    break;
                case "MOTHERBOARD":
                    items[4].add(new item(data.get(counter+1).replace("-"," "),Double.parseDouble(data.get(counter+2)),data.get(counter+3)));
                    break;
                case "CASE":
                    items[5].add(new item(data.get(counter+1).replace("-"," "),Double.parseDouble(data.get(counter+2)),data.get(counter+3)));
                    break;
                case "STORAGE":
                    items[6].add(new item(data.get(counter+1).replace("-"," "),Double.parseDouble(data.get(counter+2)),data.get(counter+3)));
                    break;
                case "COOLING":
                    items[7].add(new item(data.get(counter+1).replace("-"," "),Double.parseDouble(data.get(counter+2)),data.get(counter+3)));
                    break;
            }
            counter += 4;
        }
        return new Mojitech(items);
    }
    public PCandParts readPcAndPartsData() throws IOException {
        ArrayList<item>[] items = (ArrayList<item>[]) new ArrayList[8];
        items[0] = new ArrayList<item>();
        items[1] = new ArrayList<item>();
        items[2] = new ArrayList<item>();
        items[3] = new ArrayList<item>();
        items[4] = new ArrayList<item>();
        items[5] = new ArrayList<item>();
        items[6] = new ArrayList<item>();
        items[7] = new ArrayList<item>();
        ArrayList<String> data = readData();
        int counter = 0;
        while (counter < data.size()) {
            switch (data.get(counter)) {
                case "POWER SUPPLY":
                    items[0].add(new item(data.get(counter+1).replace("-"," "),Double.parseDouble(data.get(counter+2)),data.get(counter+3)));
                    break;
                case "CPU":
                    items[1].add(new item(data.get(counter+1).replace("-"," "),Double.parseDouble(data.get(counter+2)),data.get(counter+3)));
                    break;
                case "GPU":
                    items[2].add(new item(data.get(counter+1).replace("-"," "),Double.parseDouble(data.get(counter+2)),data.get(counter+3)));
                    break;
                case "RAM":
                    items[3].add(new item(data.get(counter+1).replace("-"," "),Double.parseDouble(data.get(counter+2)),data.get(counter+3)));
                    break;
                case "MOTHERBOARD":
                    items[4].add(new item(data.get(counter+1).replace("-"," "),Double.parseDouble(data.get(counter+2)),data.get(counter+3)));
                    break;
                case "CASE":
                    items[5].add(new item(data.get(counter+1).replace("-"," "),Double.parseDouble(data.get(counter+2)),data.get(counter+3)));
                    break;
                case "STORAGE":
                    items[6].add(new item(data.get(counter+1).replace("-"," "),Double.parseDouble(data.get(counter+2)),data.get(counter+3)));
                    break;
                case "COOLING":
                    items[7].add(new item(data.get(counter+1).replace("-"," "),Double.parseDouble(data.get(counter+2)),data.get(counter+3)));
                    break;
            }
            counter += 4;
        }
        return new PCandParts(items);
    }
    public ArrayList<PCBuild> readPcBuilds(AllItems allItems) throws FileNotFoundException {
        FileReader fr = new FileReader(file);
        BufferedReader br = new BufferedReader(fr);
        ArrayList<PCBuild> builds = new ArrayList<>();
        ArrayList<String> data = readData();
        for(int i = 0; i < data.size(); i += 9) {
            item PowerSupply;
            item Cpu;
            item Gpu;
            item Ram;
            item Motherboard;
            item Case;
            item Storage;
            item Cooler;
            if(Objects.equals(data.get(i + 1), "N/A")) PowerSupply = new item("N/A",0,"N/A");
            else PowerSupply = allItems.getAllItems()[0].get(allItems.searchForName(data.get(i+1),0));
            if(Objects.equals(data.get(i + 2), "N/A")) Cpu = new item("N/A",0,"N/A");
            else Cpu = allItems.getAllItems()[1].get(allItems.searchForName(data.get(i+2),1));
            if(Objects.equals(data.get(i + 3), "N/A")) Gpu = new item("N/A",0,"N/A");
            else Gpu = allItems.getAllItems()[2].get(allItems.searchForName(data.get(i+3),2));
            if(Objects.equals(data.get(i + 4), "N/A")) Ram = new item("N/A",0,"N/A");
            else Ram = allItems.getAllItems()[3].get(allItems.searchForName(data.get(i+4),3));
            if(Objects.equals(data.get(i + 5), "N/A")) Motherboard = new item("N/A",0,"N/A");
            else Motherboard = allItems.getAllItems()[4].get(allItems.searchForName(data.get(i+5),4));
            if(Objects.equals(data.get(i + 6), "N/A")) Case = new item("N/A",0,"N/A");
            else Case = allItems.getAllItems()[5].get(allItems.searchForName(data.get(i+6),5));
            if(Objects.equals(data.get(i + 7), "N/A")) Storage = new item("N/A",0,"N/A");
            else Storage = allItems.getAllItems()[6].get(allItems.searchForName(data.get(i+7),6));
            if(Objects.equals(data.get(i + 8), "N/A")) Cooler = new item("N/A",0,"N/A");
            else Cooler = allItems.getAllItems()[7].get(allItems.searchForName(data.get(i+8),7));
            builds.add(new PCBuild(
                    data.get(i),
                    PowerSupply,
                    Cpu,
                    Gpu,
                    Ram,
                    Motherboard,
                    Case,
                    Storage,
                    Cooler
            ));
        }
        return builds;
    }
}