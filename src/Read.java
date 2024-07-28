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
    public ArrayList<PCBuild> readPcBuilds(AllItems allItems) throws FileNotFoundException {
        ArrayList<PCBuild> builds = new ArrayList<>();
        ArrayList<String> data = readData();
        for(int i = 0; i < data.size(); i += 9) {
			if(data.get(i+3).equals("N/A") && data.get(i+8).equals("N/A")) {
				builds.add(new PCBuild(
						data.get(i),
						allItems.getAllItems()[0].get(allItems.searchForName(data.get(i+1),0)),
						allItems.getAllItems()[1].get(allItems.searchForName(data.get(i+2),1)),
						new item("N/A",0,"N/A"),
						allItems.getAllItems()[3].get(allItems.searchForName(data.get(i+4),3)),
						allItems.getAllItems()[4].get(allItems.searchForName(data.get(i+5),4)),
						allItems.getAllItems()[5].get(allItems.searchForName(data.get(i+6),5)),
						allItems.getAllItems()[6].get(allItems.searchForName(data.get(i+7),6)),
						new item("N/A",0,"N/A")
						)
				);
			}
	        else if(data.get(i+8).equals("N/A")) {
		        builds.add(new PCBuild(
						data.get(i),
				        allItems.getAllItems()[0].get(allItems.searchForName(data.get(i+1),0)),
				        allItems.getAllItems()[1].get(allItems.searchForName(data.get(i+2),1)),
				        allItems.getAllItems()[2].get(allItems.searchForName(data.get(i + 3), 2)),
				        allItems.getAllItems()[3].get(allItems.searchForName(data.get(i+4),3)),
				        allItems.getAllItems()[4].get(allItems.searchForName(data.get(i+5),4)),
				        allItems.getAllItems()[5].get(allItems.searchForName(data.get(i+6),5)),
				        allItems.getAllItems()[6].get(allItems.searchForName(data.get(i+7),6)),
				        new item("N/A",0,"N/A")
				        )
		        );
	        }
	        else if(data.get(i+3).equals("N/A")) {
		        builds.add(new PCBuild(
				        data.get(i),
				        allItems.getAllItems()[0].get(allItems.searchForName(data.get(i+1),0)),
				        allItems.getAllItems()[1].get(allItems.searchForName(data.get(i+2),1)),
				        new item("N/A",0,"N/A"),
				        allItems.getAllItems()[3].get(allItems.searchForName(data.get(i+4),3)),
				        allItems.getAllItems()[4].get(allItems.searchForName(data.get(i+5),4)),
				        allItems.getAllItems()[5].get(allItems.searchForName(data.get(i+6),5)),
				        allItems.getAllItems()[6].get(allItems.searchForName(data.get(i+7),6)),
				        allItems.getAllItems()[7].get(allItems.searchForName(data.get(i+8),7)))
		        );
	        }
			else {
		        builds.add(new PCBuild(
				        data.get(i),
				        allItems.getAllItems()[0].get(allItems.searchForName(data.get(i + 1), 0)),
				        allItems.getAllItems()[1].get(allItems.searchForName(data.get(i + 2), 1)),
				        allItems.getAllItems()[2].get(allItems.searchForName(data.get(i + 3), 2)),
				        allItems.getAllItems()[3].get(allItems.searchForName(data.get(i + 4), 3)),
				        allItems.getAllItems()[4].get(allItems.searchForName(data.get(i + 5), 4)),
				        allItems.getAllItems()[5].get(allItems.searchForName(data.get(i + 6), 5)),
				        allItems.getAllItems()[6].get(allItems.searchForName(data.get(i + 7), 6)),
				        allItems.getAllItems()[7].get(allItems.searchForName(data.get(i + 8), 7)))
		        );
	        }
        }
        return builds;
    }
}