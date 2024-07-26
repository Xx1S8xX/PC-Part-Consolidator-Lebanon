public class item {
    private String name;
    private double price;
    private final String website;
    public item(String name, double price, String website) {
        this.name = name;
        this.price = price;
        this.website = website;
    }
    public void setPrice(double price) {
        this.price = price;
    }
    public void setName(String name) {
        this.name = name;
    }
    public double getPrice() {
        return price;
    }
    public String getName() {
        return name;
    }
    public String getWebsite() {
        return website;
    }
}