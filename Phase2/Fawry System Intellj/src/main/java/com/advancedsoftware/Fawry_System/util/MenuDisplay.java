//package com.advancedsoftware.Fawry_System.util;
//import java.util.Scanner;
//
//public class MenuDisplay {
//    Scanner sc = new Scanner(System.in);
//    public int MainMenu(){
//        System.out.println("1- Login");
//        System.out.println("2- Signup");
//        System.out.println("3- Exit");
//        int choice;
//        choice = sc.nextInt();
//        while (choice > 3 || choice < 1){
//            System.out.println("Please enter a valid number between 1 to 3");
//            choice = sc.nextInt();
//        }
//        return choice;
//    }
//    public int ClientMenu(){
//        System.out.println("1- Search");
//        System.out.println("2- Pay");
//        System.out.println("3- Add Credit Card");
//        System.out.println("4- Add Funds");
//        System.out.println("5- Send Refund Request");
//        System.out.println("6- Check Discounts");
//        System.out.println("7- Profile");
//        System.out.println("8- Sign Out");
//        int choice;
//        choice = sc.nextInt();
//        while (choice > 8 || choice < 1){
//            System.out.println("Please enter a valid number between 1 to 8");
//            choice = sc.nextInt();
//        }
//        return choice;
//    }
//    public int searchMenu(){
//        System.out.println("1- Mobile Service");
//        System.out.println("2- Internet Service");
//        System.out.println("3- Landline Service");
//        System.out.println("4- Donation Service");
//        System.out.println("5- Back");
//        int choice;
//        choice = sc.nextInt();
//        while (choice > 5 || choice < 1){
//            System.out.println("Please enter a valid number between 1 to 5");
//            choice = sc.nextInt();
//        }
//        return choice;
//    }
//    public int ServiceMenu(){
//        System.out.println("1- Vodafone");
//        System.out.println("2- Etisalat");
//        System.out.println("3- We");
//        System.out.println("4- Orange");
//        System.out.println("5- Monthly Receipt");
//        System.out.println("6- Quarter Receipt");
//        System.out.println("7- NGOs");
//        System.out.println("8- Cancer Hospitals");
//        System.out.println("9- Schools");
//        System.out.println("10- Back");
//        int choice;
//        choice = sc.nextInt();
//        while (choice > 10 || choice < 1){
//            System.out.println("Please enter a valid number between 1 to 10");
//            choice = sc.nextInt();
//        }
//        return choice;
//    }
//    public int payServiceMenu(){
//        System.out.println("1- Pay for Mobile Service");
//        System.out.println("2- Pay for Internet Service");
//        System.out.println("3- Back");
//
//        int choice;
//        choice = sc.nextInt();
//        while (choice > 3 || choice < 1){
//            System.out.println("Please enter a valid number between 1 to 3");
//            choice = sc.nextInt();
//        }
//        return choice;
//    }
//    public int refundServiceMenu(){
//        System.out.println("1- Send Refund Request for Mobile Service");
//        System.out.println("2- Send Refund Request for Internet Service");
//        System.out.println("3- Back");
//        int choice;
//        choice = sc.nextInt();
//        while (choice > 3 || choice < 1){
//            System.out.println("Please enter a valid number between 1 to 3");
//            choice = sc.nextInt();
//        }
//        return choice;
//    }
//    public int displayWayPayment(FawryScreen fawryScreen, Service service){
//        fawryScreen.display(service);
//        int choice;
//        choice = sc.nextInt();
//        while (choice > service.getWaysOfPayment().size() + 1 || choice < 1){
//            System.out.println("Please enter a valid number between 1 to " + (service.getWaysOfPayment().size() + 1));
//            choice = sc.nextInt();
//        }
//        return choice;
//    }
//    public double checkAmount(){
//        double amount = sc.nextDouble();
//        while (amount <= 0){
//            System.out.println("Please enter a valid amount greater than zero");
//            amount = sc.nextDouble();
//        }
//        return amount;
//    }
//    public boolean checkCardValid(String card){
//        boolean ok = true;
//        for(int i = 0; i < card.length();i++){
//            if(card.charAt(i) < '0' || card.charAt(i) > '9')ok = false;
//        }
//        return ok;
//    }
//    public String checkCard(){
//        String card = sc.next();
//        while (!checkCardValid(card)){
//            System.out.println("Please enter a valid credit card all character are digits from 0 to 9");
//            card = sc.next();
//        }
//        return card;
//    }
//    public int sendRequest(Client client){
//        int choice;
//        choice = sc.nextInt();
//        while (choice > client.getTransactions().size() + 1 || choice < 1){
//            System.out.println("Please enter a valid number between 1 to " + (client.getTransactions()));
//            choice = sc.nextInt();
//        }
//        return choice;
//    }
//    public int checkDiscount(){
//        System.out.println("1-Check Discounts for Mobile Service");
//        System.out.println("2-Check Discounts for Internet Service");
//        System.out.println("3- Back");
//
//        int choice;
//        choice = sc.nextInt();
//        while (choice > 3 || choice < 1){
//            System.out.println("Please enter a valid number between 1 to 3");
//            choice = sc.nextInt();
//        }
//        return choice;
//    }
//    public int adminMenu(){
//        System.out.println("1- Add discount");
//        System.out.println("2- List all refund requests");
//        System.out.println("3- Sign out");
//        int choice;
//        choice = sc.nextInt();
//        while (choice > 3 || choice < 1){
//            System.out.println("Please enter a valid number between 1 to 3");
//            choice = sc.nextInt();
//        }
//        return choice;
//    }
//    public int discountMenu(){
//        System.out.println("1- Overall Discount");
//        System.out.println("2- Specific Discount");
//        System.out.println("3- Back");
//
//        int choice;
//        choice = sc.nextInt();
//        while (choice > 3 || choice < 1){
//            System.out.println("Please enter a valid number between 1 to 3");
//            choice = sc.nextInt();
//        }
//        return choice;
//    }
//    public int ServiceCategoyMenu(){
//        System.out.println("1- Mobile Service");
//        System.out.println("2- Internet Service");
//        System.out.println("3- Landline Service");
//        System.out.println("4- Donation Service");
//        System.out.println("5- Back");
//        int choice;
//        choice = sc.nextInt();
//        while (choice > 5 || choice < 1){
//            System.out.println("Please enter a valid number between 1 to 5");
//            choice = sc.nextInt();
//        }
//        return choice;
//    }
//    public int MobileMenuService(){
//        System.out.println("1- Vodafone");
//        System.out.println("2- Etisalat");
//        System.out.println("3- We");
//        System.out.println("4- Orange");
//        System.out.println("5- Back");
//        int choice;
//        choice = sc.nextInt();
//        while (choice > 5 || choice < 1){
//            System.out.println("Please enter a valid number between 1 to 5");
//            choice = sc.nextInt();
//        }
//        return choice;
//    }
//    public int InternetMenuService(){
//        System.out.println("1- Vodafone");
//        System.out.println("2- Etisalat");
//        System.out.println("3- We");
//        System.out.println("4- Orange");
//        System.out.println("5- Back");
//        int choice;
//        choice = sc.nextInt();
//        while (choice > 5 || choice < 1){
//            System.out.println("Please enter a valid number between 1 to 5");
//            choice = sc.nextInt();
//        }
//        return choice;
//    }
//    public int landlineenuService(){
//        System.out.println("1- Monthly Receipt");
//        System.out.println("2- Quarter Receipt");
//        System.out.println("3- Back");
//        int choice;
//        choice = sc.nextInt();
//        while (choice > 3 || choice < 1){
//            System.out.println("Please enter a valid number between 1 to 3");
//            choice = sc.nextInt();
//        }
//        return choice;
//    }
//    public int DonationMenuService(){
//        System.out.println("1- NGOs");
//        System.out.println("2- Cancer Hospitals");
//        System.out.println("3- Schools");
//        System.out.println("4- Back");
//        int choice;
//        choice = sc.nextInt();
//        while (choice > 4 || choice < 1){
//            System.out.println("Please enter a valid number between 1 to 4");
//            choice = sc.nextInt();
//        }
//        return choice;
//    }
//
//
//
//}
