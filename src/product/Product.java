package product;

public class Product {
    private int id;
    private String name;
    private double price;
    private int inputAmount;
    private int stockAmount;
    private String describe;

    public Product() {

    }

    public Product(int id, String name, double price, int inputAmount, int stockAmount, String describe) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.inputAmount = inputAmount;
        this.stockAmount = stockAmount;
        this.describe = describe;
    }

    public Product(int id, String name, double price, int inputAmount, int sellAmount, int stockAmount, String describe) {

    }

    public Product(int id, String name, double price, int inputAmount, String describe) {

    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getInputAmount() {
        return inputAmount;
    }

    public void setInputAmount(int inputAmount) {
        this.inputAmount = inputAmount;
    }

    public int getStockAmount() {
        return stockAmount;
    }

    public void setStockAmount(int stockAmount) {
        this.stockAmount = stockAmount;
    }

    public String getDescribe() {
        return describe;
    }

    public void setDescribe(String describe) {
        this.describe = describe;
    }

    public String write() {
        return id + " , " + name + " , " +
                " , " + price +
                " , " + inputAmount +
                " , " + stockAmount +
                " , " + describe;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", inputAmount=" + inputAmount +
                ", stockAmount=" + stockAmount +
                ", describe='" + describe + '\'' +
                '}';
    }
}