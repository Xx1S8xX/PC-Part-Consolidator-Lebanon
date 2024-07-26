import java.util.ArrayList;

public class PCBuild {
    private item Cpu;
    private item Gpu;
    private item Case;
    private item PowerSupply;
    private item Motherboard;
    private ArrayList<item> Coolers;
    private ArrayList<item> Rams;
    private ArrayList<item> Storages;
    public PCBuild(item powerSupply,item cpu, item gpu, ArrayList<item> rams, item motherboard, item Case, ArrayList<item> storages, ArrayList<item> coolers) {
        this.PowerSupply = powerSupply;
        this.Cpu = cpu;
        this.Gpu = gpu;
        this.Rams = rams;
        this.Storages = storages;
        this.Coolers = coolers;
        this.Case = Case;
        this.Motherboard = motherboard;
    }

    public double getPriceOfBuild() {
        double price = 0;
        price += this.Cpu.getPrice();
        price += this.Gpu.getPrice();
        price += this.Motherboard.getPrice();
        price += this.PowerSupply.getPrice();
        price += this.Case.getPrice();
        for (item item : Storages)
            price += item.getPrice();
        for (item item : Coolers)
            price += item.getPrice();
        for (item item : Rams)
            price += item.getPrice();
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

    public void setRams(ArrayList<item> rams) {
        Rams = rams;
    }

    public void setStorages(ArrayList<item> storages) {
        Storages = storages;
    }

    public ArrayList<item> getCoolers() {
        return Coolers;
    }

    public ArrayList<item> getRams() {
        return Rams;
    }

    public ArrayList<item> getStorages() {
        return Storages;
    }

    public void setCoolers(ArrayList<item> coolers) {
        Coolers = coolers;
    }

    public item getStorage(int index) {
        return Storages.get(index);
    }

    public void setStorage(int index, item storage) {
        Storages.set(index,storage);
    }

    public item getCooler(int index) {
        return Coolers.get(index);
    }

    public item getRam(int index) {
        return Rams.get(index);
    }

    public void setCooler(int index, item cooler) {
        Coolers.set(index,cooler);
    }

    public void setRam(int index, item ram) {
        Rams.set(index,ram);
    }
    public String getPartNames(ArrayList<item> items) {
        StringBuilder names = new StringBuilder();
        for (item item : items)
            names.append(item.getName()).append(" ");
        return names.toString();
    }

    @Override
    public String toString() {
        return "Power Supply: " + PowerSupply.getName() + "\n" +
                "CPU: " + Cpu.getName() + "\n" +
                "GPU: " + Gpu.getName() + "\n" +
                "Ram: " + getPartNames(getRams()) + "\n" +
                "Motherboard: " + Motherboard.getName() + "\n" +
                "Case: " + Case.getName() + "\n" +
                "Storage" + getPartNames(getStorages()) + "\n" +
                "Cooler: " + getPartNames(getCoolers()) + "\n";
    }
}
