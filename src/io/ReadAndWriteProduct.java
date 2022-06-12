package io;

import product.Product;

import java.io.*;
import java.util.ArrayList;

public class ReadAndWriteProduct {
    File file = new File("product.csv");

    public void Write(ArrayList<Product> products) {
        try {
            FileWriter fileWriter = new FileWriter(file);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            bufferedWriter.write("id,name,price,inputAmount,stockAmount,describe");
            bufferedWriter.newLine();
            for (Product pt : products) {
                bufferedWriter.write(pt.write());
                bufferedWriter.newLine();
            }
            bufferedWriter.close();
            fileWriter.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public ArrayList<Product> reader() {
        ArrayList<Product> products = new ArrayList<>();
        try {
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String str = bufferedReader.readLine();
            while ((str = bufferedReader.readLine()) != null) {
                String[] arr = str.split(",");
                int id = Integer.parseInt(arr[0]);
                String name = arr[1];
                double price = Double.parseDouble(arr[2]);
                int inputAmount = Integer.parseInt(arr[3]);
                int stockAmount = Integer.parseInt(arr[4]);
                String describe = arr[6];

                products.add(new Product(id, name, price, inputAmount,stockAmount, describe));
            }
            bufferedReader.close();
            fileReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return products;
    }

}

