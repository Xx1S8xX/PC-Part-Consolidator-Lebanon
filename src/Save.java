import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class Save {
    private File file;
    private PrintWriter pw;
    public Save(String fileName) throws FileNotFoundException {
        this.file = new File(fileName);
        this.pw = new PrintWriter(file);
    }

    public File getFile() {
        return file;
    }

    public void setFile(File file) {
        this.file = file;
    }

    public void closePW() {
        pw.close();
    }

    public void writeItemToFile(ArrayList<item> data) {
        for(item item: data){
            pw.println(item.getName());
            pw.println(item.getPrice());
            pw.println(item.getWebsite());
        }
    }
    
    public void writeOneItemToFile(item item) {
        pw.println(item.getName());
        pw.println(item.getPrice());
        pw.println(item.getWebsite());
    }

    public void writeStringToFile(String string) {
        pw.println(string);
    }

    public void saveAllAyoubItems(AyoubComputers ayoubComputers) {
        for(int i = 0; i < ayoubComputers.getItems().length; i++) {
            for(int x = 0; x < ayoubComputers.getItems()[i].size(); x++){
                switch (i) {
                    case 0:
                        writeStringToFile("POWER SUPPLY");
                        break;
                    case 1:
                        writeStringToFile("CPU");
                        break;
                    case 2:
                        writeStringToFile("GPU");
                        break;
                    case 3:
                        writeStringToFile("RAM");
                        break;
                    case 4:
                        writeStringToFile("MOTHERBOARD");
                        break;
                    case 5:
                        writeStringToFile("CASE");
                        break;
                    case 6:
                        writeStringToFile("STORAGE");
                        break;
                    case 7:
                        writeStringToFile("COOLING");
                        break;
                }
                writeOneItemToFile(ayoubComputers.getItems()[i].get(x));
            }
        }
    }
}
