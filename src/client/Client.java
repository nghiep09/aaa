package client;

public class Client  {
    private int id;
    private String nameClient;
    private int ageClient;
    private String gender;
    private String user;
    private String pass;
    private int sellAmount;
    private double total;


    public Client() {

    }

    public Client(int id, String nameClient, int ageClient, String gender, String user, String pass, int sellAmount, double total) {
        this.id = id;
        this.nameClient = nameClient;
        this.ageClient = ageClient;
        this.gender = gender;
        this.user = user;
        this.pass = pass;
        this.sellAmount = sellAmount;
        this.total = total;
    }

    public Client(String user, int sellAmount, double total) {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNameClient() {
        return nameClient;
    }

    public void setNameClient(String nameClient) {
        this.nameClient = nameClient;
    }

    public int getAgeClient() {
        return ageClient;
    }

    public void setAgeClient(int ageClient) {
        this.ageClient = ageClient;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public int getSellAmount() {
        return sellAmount;
    }

    public void setSellAmount(int sellAmount) {
        this.sellAmount = sellAmount;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public String write(){
        return id +
                " , " + nameClient+
                " , " + ageClient +
                " , " + gender +
                " , " + user +
                " , " + pass +
                " , " + sellAmount +
                ", " + total;
    }

    @Override
    public String toString() {
        return "Client{" +
                "id=" + id +
                ", nameClient='" + nameClient + '\'' +
                ", ageClient=" + ageClient +
                ", gender='" + gender + '\'' +
                ", user='" + user + '\'' +
                ", pass='" + pass + '\'' +
                ", sellAmount=" + sellAmount +
                ", total=" + total +
                '}';
    }
}
