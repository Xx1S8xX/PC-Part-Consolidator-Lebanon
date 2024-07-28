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
    public void saveAllPcAndPartsItems(PCandParts pcAndParts) throws FileNotFoundException {
        PrintWriter pw = new PrintWriter(file);
        try {
            for (int i = 0; i < pcAndParts.getItems().length; i++) {
                for (int x = 0; x < pcAndParts.getItems()[i].size(); x++) {
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
                    pw.println(pcAndParts.getItems()[i].get(x).getName());
                    pw.println(pcAndParts.getItems()[i].get(x).getPrice());
                    pw.println(pcAndParts.getItems()[i].get(x).getWebsite());
                }
            }
        }
        catch (Exception e) {
            System.out.println("No Items In List");
        }
        pw.close();
    }
    public void saveAllPcBuilds(ArrayList<PCBuild> builds) throws FileNotFoundException {
        try {
            PrintWriter pw = new PrintWriter(file);
            for (PCBuild build : builds) {
                if(build.getBuildName() == null)
                    pw.println("");
                else
                    pw.println(build.getBuildName());

                if(build.getPowerSupply().getName() == null)
                    pw.println("");
                else
                    pw.println(build.getPowerSupply().getName());

                if(build.getCpu().getName() == null)
                    pw.println("");
                else
                    pw.println(build.getCpu().getName());

                if(build.getGpu().getName() == null)
                    pw.println("");
                else
                    pw.println(build.getGpu().getName());

                if(build.getRam().getName() == null)
                    pw.println("");
                else
                    pw.println(build.getRam().getName());

                if(build.getMotherboard().getName() == null)
                    pw.println("");
                else
                    pw.println(build.getMotherboard().getName());

                if(build.getCase().getName() == null)
                    pw.println("");
                else
                    pw.println(build.getCase().getName());

                if(build.getStorage().getName() == null)
                    pw.println("");
                else
                    pw.println(build.getStorage().getName());

                if(build.getCooler().getName() == null)
                    pw.println("");
                else
                    pw.println(build.getCooler().getName());
            }
            pw.close();
        }
        catch (Exception e) {
            System.out.println("Error Saving PC Builds");
        }
    }
}