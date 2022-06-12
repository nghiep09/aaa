package io;

import client.Client;

import java.io.*;
import java.util.ArrayList;

public class ReadAndWriteClient {
    File file = new File("client.csv");

    public void Write(ArrayList<Client> clients) {
        try {
            FileWriter fileWriter = new FileWriter(file);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            bufferedWriter.write("id,nameClient,ageClient , gender ,user ,pass , sellAmount , total");
            bufferedWriter.newLine();
            for (Client ct : clients) {
                bufferedWriter.write(ct.write());
                bufferedWriter.newLine();
            }
            bufferedWriter.close();
            fileWriter.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public ArrayList<Client> reader() {
        ArrayList<Client> clients = new ArrayList<>();
        try {
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String str = bufferedReader.readLine();
            while ((str = bufferedReader.readLine()) != null) {
                String[] arr = str.split(",");
                int id = Integer.parseInt(arr[0]);
                String nameClient = arr[1];
                int ageClient = Integer.parseInt(arr[2]);
                String gender = arr[3];
                String user = arr[4];
                String pass = arr[5];
                int sellAmount = Integer.parseInt(arr[6]);
                double total =Double.parseDouble(arr[7]);

                clients.add(new Client(id,nameClient,ageClient , gender ,user ,pass , sellAmount , total ));
            }
            bufferedReader.close();
            fileReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return clients;
    }


}
