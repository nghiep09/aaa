package io;

import client.Client;
import product.Product;
import sellAmount.SellAmount;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ReadAndWriteSell {

    List<Product>products =new ArrayList<>();
    List<Client>clients = new ArrayList<>();
    File file = new File("sellAmount.csv");

    public void Write(ArrayList<SellAmount> sellAmounts) {
        try {
            FileWriter fileWriter = new FileWriter(file);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            bufferedWriter.write("id,name,age,gender,user,pass");
            bufferedWriter.newLine();
            for (SellAmount st : sellAmounts) {
                bufferedWriter.write(st.write());
                bufferedWriter.newLine();
            }
            bufferedWriter.close();
            fileWriter.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public ArrayList<SellAmount> reader() {
        ArrayList<SellAmount> sellAmounts = new ArrayList<>();
        try {
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String str = bufferedReader.readLine();
            while ((str = bufferedReader.readLine()) != null) {
                String[] arr = str.split(",");
                String product = arr[0];
                int sellAmount = Integer.parseInt(arr[1]);
                String client = arr[2];

                sellAmounts.add(new SellAmount(product, sellAmount ,client ));
            }
            bufferedReader.close();
            fileReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return sellAmounts;
    }

}
