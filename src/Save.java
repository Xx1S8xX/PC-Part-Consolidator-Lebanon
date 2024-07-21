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
}
