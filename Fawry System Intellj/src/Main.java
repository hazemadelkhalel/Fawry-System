import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("1-Admin");
        System.out.println("2-User");

        int choice;
        Scanner sc = new Scanner(System.in);
        choice = sc.nextInt();


        if(choice == 1){

        }
        else if(choice == 2){
            System.out.println("1-Login");
            System.out.println("2-Signup");
            choice = sc.nextInt();
            if(choice == 1){
                System.out.print("Enter your Username: ");
                String username = sc.next();
                System.out.print("Enter your Email: ");
                String email = sc.next();
                System.out.print("Enter your Password: ");
                String password = sc.next();
                System.out.print("Enter your current wallet balance: ");
                double wallet = sc.nextDouble();
                Client client = new Client(username, email, password, wallet);
                Database database = new Database();
                FawryScreen fawryScreen = new FawryScreen(database);
                if(fawryScreen.loginButton(client) == "-1"){
                    //New to the system or wrong info

                }
                else{
                    System.out.println(fawryScreen.loginButton(client));
                }
            }
            else if(choice == 2){
                System.out.print("Enter a Username: ");
                String username = sc.next();
                System.out.print("Enter an Email: ");
                String email = sc.next();
                System.out.print("Enter a Password: ");
                String password = sc.next();
                System.out.print("Enter a wallet balance: ");
                double wallet = sc.nextDouble();
                Client client = new Client(username, email, password, wallet);
                Database database = new Database();
                FawryScreen fawryScreen = new FawryScreen(database);
                fawryScreen.signUpButton(client);
                System.out.println(fawryScreen.signUpButton(client));

                System.out.print("Enter your Username: ");
                username = sc.next();
                System.out.print("Enter your Email: ");
                email = sc.next();
                System.out.print("Enter your Password: ");
                password = sc.next();
                System.out.print("Enter your current wallet balance: ");
                wallet = sc.nextDouble();
                //client = new Client(username, email, password, wallet);
                System.out.println(fawryScreen.loginButton(client));
            }
        }




//        Database database = new Database();
//        FawryScreen fawryScreen = new FawryScreen(database);
//        fawryScreen.displayAdminMenu();
//        Client client = new Client("Medhat", "Medhat@gmail.com", "LoveMedhat", 13.5);
//        System.out.println(fawryScreen.addClientAccountButton(client));
//        CreditCard creditCard = new CreditCard("123456", 100);
//        System.out.println(fawryScreen.addCreditCard(client, creditCard));
//        System.out.println(fawryScreen.addFunds(client, 70));
//        System.out.println(client.getCreditCard().getAmount());
//        System.out.println(client.getWallet());
//        CreditCard creditCard1 = new CreditCard("123456", 120);
//        System.out.println(fawryScreen.addCreditCard(client, creditCard1));
//        System.out.println(fawryScreen.addFunds(client, 70));
//        System.out.println(client.getCreditCard().getAmount());
//        System.out.println(client.getWallet());



//        Database database = new Database();
//        FawryScreen fawryScreen = new FawryScreen(database);
//        Vodafone vodafone = new Vodafone("Vodafone");
//        CreditCardMethod creditCardMethod = new CreditCardMethod(database);
//        WalletMethod walletMethod = new WalletMethod(database);
//        CashMethod cashMethod = new CashMethod(database);
//        vodafone.addPaymentMethod(creditCardMethod);
//        vodafone.addPaymentMethod(walletMethod);
//        vodafone.addPaymentMethod(cashMethod);
//        database.InternetServices.add(vodafone);
//        database.mobileServices.add(vodafone);
//        Admin admin = new Admin("admin", "admin@gmail.com", "admin");
//        AccountController accountController = new AccountController(database);
//        accountController.addAccount(admin);
//        Client client = new Client("Medhat", "Medhat@gmail.com", "LoveMedhat", 100);
//        CreditCard creditCard = new CreditCard("123456", 100);
//        fawryScreen.addCreditCard(client, creditCard);
//        fawryScreen.addClientAccountButton(client);
//        fawryScreen.displayUserMenu();
//        fawryScreen.displayAdminMenu();
//        fawryScreen.searchInternetServiceButton("Vod");
 //       System.out.println(fawryScreen.payButtonMobileService(client, vodafone, 20, 1));
//        System.out.println(fawryScreen.payButtonMobileService(client, vodafone, 20, 1));
//        System.out.println(fawryScreen.payButtonMobileService(client, vodafone, 20, 1));
//        System.out.println(fawryScreen.payButtonMobileService(client, vodafone, 20, 1));
//        System.out.println(fawryScreen.payButtonMobileService(client, vodafone, 20, 0));

//        fawryScreen.displayUserMenu();
////        fawryScreen.display(client);
//        fawryScreen.addRefundRequest(client.getTransactions().get(0));
//        RefundRequest refundRequest = database.refunds.get(0);
//        fawryScreen.listAllRefundRequest();
//        System.out.println(fawryScreen.acceptRefundRequestButton(true, refundRequest));
//        fawryScreen.display(client);
//        fawryScreen.display(vodafone);
//        fawryScreen.display(client);
//        SpecificDiscount discount = new SpecificDiscount(vodafone, 20);
//        OverallDiscount discount1 = new OverallDiscount(vodafone, 10);
//        fawryScreen.addMobileServiceDiscount(discount);
//        database.overallDiscount = discount1;
//        System.out.println(client.getWallet());
//        double amount = fawryScreen.applyDiscountMobileServiceButton(vodafone, client, 100);
//        System.out.println(amount);
//        fawryScreen.payButtonMobileService(client, vodafone, amount, 1);
//        System.out.println(client.getWallet());

//
//        double ans = discount.applyDiscount(100);
//        OverallDiscount discount1 = new OverallDiscount(vodafone);
//        System.out.println(ans);
//        double ans1 = discount1.applyDiscount(ans, 10);
//        System.out.println(ans1);




    }
}