public class item {
    private final String name;
    private final double price;
    private final String website;
    public item(String name, double price, String website) {
        this.name = name;
        this.price = price;
        this.website = website;
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