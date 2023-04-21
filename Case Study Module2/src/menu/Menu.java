package menu;

import java.util.Scanner;

public class Menu {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Nhập Tài Khoản: ");
        String admin = input.nextLine();
        if (admin == admin) {
            int choise = -1;
            while (choise != 0) {
                System.out.println("1. Quản lí vé xe");
                System.out.println("2. Quản lí xe ra");
                System.out.println("3. Quản lí xe vào");
                System.out.println("4. Báo cáo doanh thu tháng");
                System.out.println("0. Exit");
                choise = input.nextInt();
                switch (choise) {
                    case 1:
                        System.out.println("1. Số vé còn lại: ");
                        System.out.println("2. Exit");
                        choise = input.nextInt();
                        break;
                    case 2:
                        System.out.println("1. Số lượng xe ra: ");
                        System.out.println("2. Exit");
                        choise = input.nextInt();
                        break;
                    case 3:
                        System.out.println("1. Số lượng xe vào: ");
                        System.out.println("2. Exit");
                        choise = input.nextInt();
                        break;
                    case 4:
                        System.out.println("1. Doanh thu tháng này: ");
                        System.out.println("2. Exit");
                        choise = input.nextInt();
                        break;

                    default:
                        System.out.println("Xin chào hẹn gặp lại");
                }

            }
        }
    }
}
