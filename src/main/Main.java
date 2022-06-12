package main;

import log_in.ManagerLogin;
import product.ManagerProduct;

public class Main {
    public static void main(String[] args) {
        ManagerProduct managerProduct=new ManagerProduct();
        ManagerLogin managerLogin = new ManagerLogin();
        while (true){
            if (ManagerLogin.login == null) {
                managerLogin.manuLogin();
            } else {
                if (ManagerLogin.login.getRole().equals("admin")) {
                    managerProduct.manager();
                } else {
                    managerProduct.managerClient();
                }
            }
        }
    }
}
