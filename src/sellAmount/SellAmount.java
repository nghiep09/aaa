package sellAmount;

import client.Client;
import product.Product;

public class SellAmount {
    private Product product;
    private int sellAmount;
    private Client client;

    public SellAmount() {

    }

    public SellAmount(Product product, int sellAmount, Client client) {
        this.product = product;
        this.sellAmount = sellAmount;
        this.client = client;
    }

    public SellAmount(String product, int sellAmount, String client) {

    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getSellAmount() {
        return sellAmount;
    }

    public void setSellAmount(int sellAmount) {
        this.sellAmount = sellAmount;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public String write(){
        return product + " , " + sellAmount +
                " , " + client;
    }

    @Override
    public String toString() {
        return "SellAmount{" +
                "product=" + product +
                ", sellAmount=" + sellAmount +
                ", client=" + client +
                '}';
    }
}
