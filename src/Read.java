import java.io.*;
import java.util.ArrayList;

public class Read {
    private File file;
    private FileReader fileReader;
    private BufferedReader bufferedReader;
    public Read(String fileName) throws FileNotFoundException {
        this.file = new File(fileName);
        this.fileReader = new FileReader(file);
        this.bufferedReader = new BufferedReader(fileReader);
    }

    public void setFile(File file) {
        this.file = file;
    }

    public File getFile() {
        return file;
    }

    public ArrayList<String> readData() throws IOException {
        ArrayList<String> data = new ArrayList<>();
        while(bufferedReader.ready())
            data.add(bufferedReader.readLine());
        return data;
    }
}
