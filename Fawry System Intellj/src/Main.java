import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
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



        Database database = new Database();
        FawryScreen fawryScreen = new FawryScreen(database);
        Vodafone vodafone = new Vodafone("Vodafone");
        CreditCardMethod creditCardMethod = new CreditCardMethod(database);
        WalletMethod walletMethod = new WalletMethod(database);
        CashMethod cashMethod = new CashMethod(database);
        vodafone.addPaymentMethod(creditCardMethod);
        vodafone.addPaymentMethod(walletMethod);
        vodafone.addPaymentMethod(cashMethod);
        database.InternetServices.add(vodafone);
        database.mobileServices.add(vodafone);
        Admin admin = new Admin("admin", "admin@gmail.com", "admin");
        AccountController accountController = new AccountController(database);
        accountController.addAccount(admin);
        Client client = new Client("Medhat", "Medhat@gmail.com", "LoveMedhat", 100);
        CreditCard creditCard = new CreditCard("123456", 100);
        fawryScreen.addCreditCard(client, creditCard);
        fawryScreen.addClientAccountButton(client);
        fawryScreen.displayUserMenu();
        fawryScreen.displayAdminMenu();
        fawryScreen.searchInternetServiceButton("Vod");
        fawryScreen.searchMobileServiceButton("a");
        fawryScreen.searchDonationServiceButton("Vod");
//        System.out.println(fawryScreen.payButtonMobileService(client, vodafone, 20, 0));
//        System.out.println(fawryScreen.payButtonMobileService(client, vodafone, 20, 1));
//        System.out.println(fawryScreen.payButtonMobileService(client, vodafone, 20, 1));
//        System.out.println(fawryScreen.payButtonMobileService(client, vodafone, 20, 1));
//        System.out.println(fawryScreen.payButtonMobileService(client, vodafone, 20, 0));

//        fawryScreen.displayUserMenu();
//        fawryScreen.display(vodafone);
//        fawryScreen.display(client);
//        SpecificDiscount discount = new SpecificDiscount(vodafone, 20);
//        OverallDiscount discount1 = new OverallDiscount(vodafone, 10);
//        database.mobileServiceDiscount = discount;
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