import java.util.ArrayList;
public class PCBuild {
    private item Cpu;
    private item Gpu;
    private item Case;
    private item PowerSupply;
    private item Motherboard;
    private item Cooler;
    private item Ram;
    private item Storage;
    private String Name;
    public PCBuild(String name,item powerSupply,item cpu, item gpu, item ram, item motherboard, item Case, item storage, item cooler) {
        this.Name = name;
        this.PowerSupply = powerSupply;
        this.Cpu = cpu;
        this.Gpu = gpu;
        this.Ram = ram;
        this.Storage = storage;
        this.Cooler = cooler;
        this.Case = Case;
        this.Motherboard = motherboard;
    }

    public void setName(String name) {
        Name = name;
    }
    public String getName() {
        return Name;
    }
    public double getPriceOfBuild() {
        double price = 0;
        try {
            price += this.PowerSupply.getPrice();
        }
        catch (Exception e) {
            System.out.println("No Power Supply Price");
        }
        try {
            price += this.Cpu.getPrice();
        }
        catch (Exception e) {
            System.out.println("No CPU Price");
        }
        try {
            price += this.Gpu.getPrice();
        }
        catch (Exception e) {
            System.out.println("No GPU Price");
        }
        try {
            price += this.Motherboard.getPrice();
        }
        catch (Exception e) {
            System.out.println("No Motherboard Price");
        }
        try {
            price += this.Case.getPrice();
        }
        catch (Exception e) {
            System.out.println("No Case Price");
        }
        try {
            price += this.Ram.getPrice();
        }
        catch (Exception e) {
            System.out.println("No Ram Price");
        }
        try {
            price += this.Storage.getPrice();
        }
        catch (Exception e) {
            System.out.println("No Storage Price");
        }
        try {
            price += this.Cooler.getPrice();
        }
        catch (Exception e) {
            System.out.println("No Cooler Price");
        }
        return price;
    }
    public void setMotherboard(item motherboard) {
        Motherboard = motherboard;
    }
    public item getPowerSupply() {
        return PowerSupply;
    }
    public item getMotherboard() {
        return Motherboard;
    }
    public void setGpu(item gpu) {
        Gpu = gpu;
    }
    public void setCpu(item cpu) {
        Cpu = cpu;
    }
    public item getGpu() {
        return Gpu;
    }
    public item getCpu() {
        return Cpu;
    }
    public void setCase(item aCase) {
        Case = aCase;
    }
    public item getCase() {
        return Case;
    }
    public void setPowerSupply(item powerSupply) {
        PowerSupply = powerSupply;
    }
    public void setStorage(item storage) {
        Storage = storage;
    }
    public item getCooler() {
        return Cooler;
    }
    public void setCooler(item cooler) {
        Cooler = cooler;
    }
    public item getStorage() {
        return Storage;
    }
    public item getRam() {
        return Ram;
    }
    public void setRam(item ram) {
        this.Ram = ram;
    }
    @Override
    public String toString() {
        return  "Name: " + Name + "\n" +
                "Power Supply: " + PowerSupply.getName() + "\n" +
                "CPU: " + Cpu.getName() + "\n" +
                "GPU: " + Gpu.getName() + "\n" +
                "Ram: " + Ram.getName() + "\n" +
                "Motherboard: " + Motherboard.getName() + "\n" +
                "Case: " + Case.getName() + "\n" +
                "Storage" + Storage.getName() + "\n" +
                "Cooler: " + Cooler.getName() + "\n";
    }
}
