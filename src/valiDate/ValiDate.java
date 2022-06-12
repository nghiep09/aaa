package valiDate;

import product.Product;

import java.util.List;
import java.util.Scanner;

public class ValiDate {
    Scanner scanner = new Scanner(System.in);

    public int validateID(List<Product>products) {

        while (true) {
            try {
                System.out.println("1. Nhập id sản phẩm: ");
                int id = Integer.parseInt(scanner.nextLine());
                if (getIndexID(id,products)!=-1){
                    throw new Exception();
                }
                return id;
            } catch (Exception e) {
                System.out.println("nhập lại giá trị của id: ");;
            }

        }
    }
    public int getIndexID(int id, List<Product>products) {
        for (int i=0;i<products.size();i++){
            if (products.get(i).getId()==id){
                return i;
            }
        }

        return -1;
    }

    public String validateName(String name){
        while (true){
            System.out.println("2. Nhập tên sản phẩm: ");
            String str=scanner.nextLine();
            if (str.equals(" ")){
                System.err.println("không để trống tên sản phẩm");
                continue;
            }else {
                return str;
            }
        }
    }
    public double validatePrice(String products){
        while (true){
            try {
                System.out.println("3. Nhập giá sản phẩm:");
                Double price=Double.parseDouble(scanner.nextLine());
                return price;
            } catch (NumberFormatException e) {
                System.out.println("Nhập lại giá sản phẩm bằng số: ");
            }
        }
    }
    public int validateAmount(String products){
        while (true){
            try {
                System.out.println("4. Nhập số lượng sản phẩm: ");
                int inputAmount=Integer.parseInt(scanner.nextLine());
                return inputAmount;
            } catch (NumberFormatException e) {
                System.out.println("Nhập lại số lượng sản phẩm: ");
            }
        }
    }
    public String validateDescribe(String describe){
        while (true){
                System.out.println("5. Nhập mô tả sản phẩm: ");
                String str = scanner.nextLine();
                if (str.equals(" ")){
                    System.out.println(" Hãy mô tả sản phẩm");
                }else {
                    return str;
            }
        }

    }
}
