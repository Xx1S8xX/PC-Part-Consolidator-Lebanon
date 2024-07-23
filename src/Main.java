import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
public class Main {
    public static void main(String[] args) throws IOException {
        // 0: Power Supply
        // 1: CPUS
        // 2: GPUS
        // 3: Ram
        // 4: Motherboards
        // 5: Cases
        // 6: Storage
        // 7: Cooling
        // Ayoub Stuff
        File ayoubFile = new File("ayoubFile.txt");
        Save ayoubSave = new Save(ayoubFile);
        Read ayoubRead = new Read(ayoubFile);
        ArrayList<item>[] ayoubItems = (ArrayList<item>[]) new ArrayList[8];
        AyoubComputers ayoubComputers;
        try {
            ayoubComputers = ayoubRead.readAyoubComputersData();
        }
        catch (Exception e) {
            System.out.println("No File Found");
            ayoubComputers = new AyoubComputers(ayoubItems);
        }
        //ayoubComputers.getAllItemAyoub();




        // PC and Parts Stuff
        File pcAndPartsFile = new File("pcAndPartsFile.txt");
        Save pcAndPartsSave = new Save(pcAndPartsFile);
        Read pcAndPartsRead = new Read(pcAndPartsFile);
        ArrayList<item>[] pcAndPartsItems = (ArrayList<item>[]) new ArrayList[8];
        PCandParts pcAndParts;
        try {
            pcAndParts = pcAndPartsRead.readPcAndPartsData();
        }
        catch (Exception e) {
            System.out.println("No File Found");
            pcAndParts = new PCandParts(pcAndPartsItems);
        }
        //pcAndParts.getAllItemPCandParts();



        // Mojitech Stuff
        File mojitechFile = new File("mojitechFile.txt");
        Save mojitechSave = new Save(mojitechFile);
        Read mojitechRead = new Read(mojitechFile);
        ArrayList<item>[] mojitechItems = (ArrayList<item>[]) new ArrayList[8];
        Mojitech mojitech;
        try {
            mojitech = mojitechRead.readMojitechData();
        }
        catch (Exception e) {
            System.out.println("No File Found");
            mojitech = new Mojitech(mojitechItems);
        }
        //mojitech.getAllItemMojitech();

        pcAndPartsSave.saveAllPcAndPartsItems(pcAndParts);
        mojitechSave.saveAllMojitechItems(mojitech);
        ayoubSave.saveAllAyoubItems(ayoubComputers);
        MainMenu mainMenu = new MainMenu(ayoubComputers,mojitech,pcAndParts);
    }
}