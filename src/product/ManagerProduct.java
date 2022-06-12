package product;

import client.Client;
import io.ReadAndWriteClient;
import io.ReadAndWriteProduct;
import io.ReadAndWriteSell;
import log_in.ManagerLogin;
import sellAmount.SellAmount;
import sort.SortByPriceGiam;
import sort.SortByPriceTang;
import valiDate.ValiDate;

import java.util.ArrayList;
import java.util.Scanner;

public class ManagerProduct {
    ArrayList<Product> products = new ArrayList<>();
    ReadAndWriteClient readAndWriteClient = new ReadAndWriteClient();
    ArrayList<SellAmount> sellAmounts = new ArrayList<>();
    ArrayList<Client> clients = new ArrayList<>();
    ReadAndWriteProduct readAndWriteProduct = new ReadAndWriteProduct();
    ReadAndWriteSell readAndWriteSell = new ReadAndWriteSell();
    ValiDate valiDate = new ValiDate();
    Scanner scanner = new Scanner(System.in);
    public void manager() {
        System.out.println("Xin chào Addmin");
        System.out.println("MENU");
        System.out.println("1. Thêm sản phẩm");
        System.out.println("2. Cập Nhật");
        System.out.println("3. Xóa sản phẩm");
        System.out.println("4. Tìm kiếm");
        System.out.println("5. Hiển thị");
        System.out.println("6. Sắp xếp");
        System.out.println("7. Logout");
        System.out.println("xin hãy chọn chức năng");

        int choice = Integer.parseInt(scanner.nextLine());
        switch (choice) {
            case 1:
                create();
                break;
            case 2:
                edit();
                break;
            case 3:
                delete();
                break;
            case 4:
                search();
                break;
            case 5:
                show();
                readAndWriteProduct.Write(products);
                break;
            case 6:
                sort();
                break;
            case 7:
                ManagerLogin.login = null;
                break;
        }
    }

    public void show() {
        for (Product pt : products) {
            System.out.println(pt);
        }
    }

    public Product createProduct() {
        int id = valiDate.validateID(products);
        String name = valiDate.validateName("name: ");
        double price = valiDate.validatePrice("price: ");
        int inputAmount = valiDate.validateAmount("amount: ");
        String describe = valiDate.validateDescribe("describe: ");

        return new Product(id, name, price, inputAmount, describe);
    }

    public void create() {
        products.add(createProduct());
    }

    public void edit() {
        System.out.println("Nhập id cần sửa: ");
        int id=Integer.parseInt(scanner.nextLine());
        int index = valiDate.getIndexID(id, products);
        if (index != -1) {
            products.set(index, createProduct());
        } else {
            System.out.println("Không có sản phẩm trùng id");
        }
    }

    public void delete() {
        System.out.println("Nhập id cần xóa: ");
        int id = Integer.parseInt(scanner.nextLine());
        int index = valiDate.getIndexID(id, products);
        if (index != -1) {
            products.remove(index);
        } else {
            System.out.println("Không có sản phẩm trùng id");
        }
    }

    public void search() {
        boolean check = false;
        System.out.println("Nhập tên cần tìm kiếm: ");
        String ten = scanner.nextLine();
        for (int i = 0; i < products.size(); i++) {
            if (products.get(i).getName().contains(ten)) {
                System.out.println(products.get(i));
                check = true;
            }
        }
        if (!check) {
            System.out.println("không tìm thấy tên sản phẩm");
        }
    }

    public void sort() {
        System.out.println(" chọn cách sắp xếp");
        System.out.println("1. giá tăng dần");
        System.out.println("2. giá giảm dần");
        int choice1 = Integer.parseInt(scanner.nextLine());

        switch (choice1) {
            case 1:
                products.sort(new SortByPriceTang());
                for (Product pt : products) {
                    System.out.println(pt);
                }
                break;

            case 2:
                products.sort(new SortByPriceGiam());
                for (Product pt : products) {
                    System.out.println(pt);
                }
                break;
        }
    }

    public void managerClient() {
        System.out.println("Xin chào " + ManagerLogin.login.getUserName() + " đến với cửa hàng");
        System.out.println("MANU");
        System.out.println("1. Thêm sản phẩm vào giỏ hàng");
        System.out.println("2. Xóa sản phẩm khỏi giỏ hàng");
        System.out.println("3. Hiển thị sản phẩm có trong giỏ");
        System.out.println("4. Tổng tiền");
        System.out.println("5. Tìm kiếm sản phẩm");
        System.out.println("6. Hiển thị sản trong cửa hàng");
        System.out.println("7. Sắp xếp");
        System.out.println("8. Logout");
        System.out.println("xin hãy chọn chức năng");

        int choice2 = Integer.parseInt(scanner.nextLine());
        switch (choice2) {
            case 1:
                createPro();
                break;
//            case 2:
//                deleteClient();
//            break;
//            case 3:
//                showClient();
//                break;
//            case 4:
//                total();
//                break;
            case 5:
                search();
                break;
            case 6:
                show();
                break;
            case 7:
                sort();
                break;
            case 8:
                ManagerLogin.login = null;
                break;
        }

    }

    public void createPro(){
        System.out.println("Nhập tên sản phẩm muốn mua");
        String name = scanner.nextLine();
        for (int i=0;i<products.size();i++){
            if (products.get(i).getName().equals(name)){
                String user = ManagerLogin.login.getUserName();
                String name1= products.get(i).getName();
                double price=products.get(i).getPrice();
                System.out.println("nhập số lượng muốn mua");
                int sellAmount=Integer.parseInt(scanner.nextLine());
                double total=(products.get(i).getPrice()*sellAmount);
                int inputAmount =products.get(i).getInputAmount();
                int id =products.get(i).getId();
                String describe = products.get(i).getDescribe();
                int stockAmount=inputAmount-sellAmount;
                products.get(i).setInputAmount(stockAmount);
                readAndWriteClient.Write(clients);
                readAndWriteProduct.Write(products);

                products.add(new Product(id, name, price, inputAmount,stockAmount, describe));
                clients.add(new Client( user,sellAmount, total));
            }
        }
        System.out.println("mua thành công");
    }
}
