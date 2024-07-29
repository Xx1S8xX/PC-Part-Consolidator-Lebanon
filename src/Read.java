import java.io.*;
import java.util.ArrayList;
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
}