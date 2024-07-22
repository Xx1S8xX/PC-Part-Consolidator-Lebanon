import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
public class Save {
    private final File file;
    public Save(File file) throws FileNotFoundException {
        this.file = file;
    }
    public File getFile() {
        return file;
    }
    public void saveAllAyoubItems(AyoubComputers ayoubComputers) throws FileNotFoundException {
        PrintWriter pw = new PrintWriter(file);
        try {
            for (int i = 0; i < ayoubComputers.getItems().length; i++) {
                for (int x = 0; x < ayoubComputers.getItems()[i].size(); x++) {
                    switch (i) {
                        case 0:
                            pw.println("POWER SUPPLY");
                            break;
                        case 1:
                            pw.println("CPU");
                            break;
                        case 2:
                            pw.println("GPU");
                            break;
                        case 3:
                            pw.println("RAM");
                            break;
                        case 4:
                            pw.println("MOTHERBOARD");
                            break;
                        case 5:
                            pw.println("CASE");
                            break;
                        case 6:
                            pw.println("STORAGE");
                            break;
                        case 7:
                            pw.println("COOLING");
                            break;
                    }
                    pw.println(ayoubComputers.getItems()[i].get(x).getName());
                    pw.println(ayoubComputers.getItems()[i].get(x).getPrice());
                    pw.println(ayoubComputers.getItems()[i].get(x).getWebsite());
                }
            }
        }
        catch (Exception e) {
            System.out.println("No Items In List");
        }
        pw.close();
    }
    public void saveAllMojitechItems(Mojitech mojitech) throws FileNotFoundException {
        PrintWriter pw = new PrintWriter(file);
        try {
            for (int i = 0; i < mojitech.getItems().length; i++) {
                for (int x = 0; x < mojitech.getItems()[i].size(); x++) {
                    switch (i) {
                        case 0:
                            pw.println("POWER SUPPLY");
                            break;
                        case 1:
                            pw.println("CPU");
                            break;
                        case 2:
                            pw.println("GPU");
                            break;
                        case 3:
                            pw.println("RAM");
                            break;
                        case 4:
                            pw.println("MOTHERBOARD");
                            break;
                        case 5:
                            pw.println("CASE");
                            break;
                        case 6:
                            pw.println("STORAGE");
                            break;
                        case 7:
                            pw.println("COOLING");
                            break;
                    }
                    pw.println(mojitech.getItems()[i].get(x).getName());
                    pw.println(mojitech.getItems()[i].get(x).getPrice());
                    pw.println(mojitech.getItems()[i].get(x).getWebsite());
                }
            }
        }
        catch (Exception e) {
            System.out.println("No Items In List");
        }
        pw.close();
    }
}