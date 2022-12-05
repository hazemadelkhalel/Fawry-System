import java.util.ArrayList;
import java.util.Scanner;


public class Main {




    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Database database = new Database();
        FawryScreen fawryScreen = new FawryScreen(database);
        MenuDisplay menuDisplay = new MenuDisplay();
        CreditCardMethod creditCardMethod = new CreditCardMethod(database);
        WalletMethod walletMethod = new WalletMethod(database);
        CashMethod cashMethod = new CashMethod(database);
        Vodafone vodafone = new Vodafone("Vodafone");
        We we = new We("We");
        Orange orange = new Orange("Orange");
        Etisalat etisalat = new Etisalat("Etisalat");
        MonthlyReceipt monthlyReceipt = new MonthlyReceipt("Monthly Receipt");
        QuarterReceipt quarterReceipt = new QuarterReceipt("Quarter Receipt");
        CancerHospital cancerHospital = new CancerHospital("Cancer Hospital");
        School school = new School("School");
        NGO ngo = new NGO("NGO");
        vodafone.addPaymentMethod(creditCardMethod);
        we.addPaymentMethod(creditCardMethod);
        orange.addPaymentMethod(creditCardMethod);
        etisalat.addPaymentMethod(creditCardMethod);
        monthlyReceipt.addPaymentMethod(creditCardMethod);
        quarterReceipt.addPaymentMethod(creditCardMethod);
        cancerHospital.addPaymentMethod(creditCardMethod);
        school.addPaymentMethod(creditCardMethod);
        ngo.addPaymentMethod(creditCardMethod);

        vodafone.addPaymentMethod(walletMethod);
        we.addPaymentMethod(walletMethod);
        orange.addPaymentMethod(walletMethod);
        etisalat.addPaymentMethod(walletMethod);
        monthlyReceipt.addPaymentMethod(walletMethod);
        quarterReceipt.addPaymentMethod(walletMethod);
        cancerHospital.addPaymentMethod(walletMethod);
        school.addPaymentMethod(walletMethod);
        ngo.addPaymentMethod(walletMethod);

        vodafone.addPaymentMethod(cashMethod);
        cancerHospital.addPaymentMethod(cashMethod);
        school.addPaymentMethod(cashMethod);

        database.services.add(vodafone);
        database.mobileServices.add(vodafone);
        database.InternetServices.add(vodafone);

        database.services.add(we);
        database.mobileServices.add(we);
        database.InternetServices.add(we)
        ;
        database.services.add(orange);
        database.mobileServices.add(orange);
        database.InternetServices.add(orange);

        database.services.add(etisalat);
        database.mobileServices.add(etisalat);
        database.InternetServices.add(etisalat);

        database.services.add(monthlyReceipt);
        database.landlineServices.add(monthlyReceipt);

        database.services.add(quarterReceipt);
        database.landlineServices.add(quarterReceipt)
        ;
        database.services.add(cancerHospital);
        database.donationServices.add(cancerHospital);

        database.services.add(school);
        database.donationServices.add(school);

        database.services.add(ngo);
        database.donationServices.add(ngo);

        Admin admin = new Admin("admin", "Admin@gmail.com", "admin");
        Client c = new Client("a", "a@gmail.com", "a", 120);
        database.accounts.add(admin);
        database.accounts.add(c);


        // intitialize all services
//        Client client ;
        while(true) {
            int choice = menuDisplay.MainMenu();
            boolean exit = true;
            while (choice == 1) {
                if(!exit){
                    break;
                }
                System.out.print("Enter your Username/Email: ");
                String usernameOrEmail = sc.next();
                System.out.print("Enter your Password: ");
                String password = sc.next();
                Account account = fawryScreen.loginButton(usernameOrEmail, password);
                if(account != null){
                    while (account.notifications.size() > 0){
                        System.out.println(account.notifications.get(0));
                        account.notifications.remove(0);
                    }
                    while (choice == 1){
                        boolean sign = true;
                        if(account instanceof Client){
                            Client client = (Client) account;
                            int clientChoice = menuDisplay.ClientMenu();
                            // Search
                            if (clientChoice == 1) {
                                int searchChoice = menuDisplay.searchMenu();
                                if (searchChoice == 1) {
                                    System.out.print("Enter your desired category in Mobile Service: ");
                                    String word = sc.next();
                                    fawryScreen.searchMobileServiceButton(word);
                                } else if (searchChoice == 2) {
                                    System.out.print("Enter your desired category in Internet Service: ");
                                    String word = sc.next();
                                    fawryScreen.searchInternetServiceButton(word);
                                } else if (searchChoice == 3) {
                                    System.out.print("Enter your desired category in Landline Service: ");
                                    String word = sc.next();
                                    fawryScreen.searchLandlineServiceButton(word);
                                } else if (searchChoice == 4) {
                                    System.out.print("Enter your desired category in Donation Service: ");
                                    String word = sc.next();
                                    fawryScreen.searchDonationServiceButton(word);
                                }
                            }

                            // Pay
                            while (clientChoice == 2) {
                                int payChoice = menuDisplay.ServiceMenu();
                                if(payChoice == 10){
                                    clientChoice = -1;
                                    break;
                                }
                                while (payChoice == 1) {
                                    int payChoiceService = menuDisplay.payServiceMenu();
                                    if (payChoiceService == 1) {
                                        System.out.print("Enter the amount you will pay:");
                                        double amount = menuDisplay.checkAmount();
                                        System.out.print("Enter the way you will pay by:");
                                        int way = menuDisplay.displayWayPayment(fawryScreen, vodafone);
                                        way--;
                                        if(way == vodafone.getWaysOfPayment().size()){
                                            break;
                                        }
                                        System.out.println(fawryScreen.payButtonMobileService(client, vodafone, amount, way));
                                    } else if (payChoiceService == 2) {
                                        System.out.print("Enter the amount you will pay:");
                                        double amount = menuDisplay.checkAmount();
                                        System.out.print("Enter the way you will pay by:");
                                        int way = menuDisplay.displayWayPayment(fawryScreen, vodafone);
                                        way--;
                                        if(way == vodafone.getWaysOfPayment().size()){
                                            break;
                                        }
                                        System.out.println(fawryScreen.payButtonInternetService(client, vodafone, amount, way));
                                    }
                                    else{
                                        break;
                                    }
                                }
                                while (payChoice == 2) {
                                    int payChoiceService = menuDisplay.payServiceMenu();
                                    if (payChoiceService == 1) {
                                        System.out.print("Enter the amount you will pay:");
                                        double amount = menuDisplay.checkAmount();
                                        System.out.print("Enter the way you will pay by:");
                                        int way = menuDisplay.displayWayPayment(fawryScreen, etisalat);
                                        way--;
                                        if(way == etisalat.getWaysOfPayment().size()){
                                            break;
                                        }
                                        System.out.println(fawryScreen.payButtonMobileService(client, etisalat, amount, way));
                                    } else if (payChoiceService == 2) {
                                        System.out.print("Enter the amount you will pay:");
                                        double amount = menuDisplay.checkAmount();
                                        System.out.print("Enter the way you will pay by:");
                                        int way = menuDisplay.displayWayPayment(fawryScreen, etisalat);
                                        way--;
                                        if(way == etisalat.getWaysOfPayment().size()){
                                            break;
                                        }
                                        System.out.println(fawryScreen.payButtonInternetService(client, etisalat, amount, way));
                                    }
                                    else{
                                        break;
                                    }
                                }
                                while (payChoice == 3) {
                                    int payChoiceService = menuDisplay.payServiceMenu();
                                    if (payChoiceService == 1) {
                                        System.out.print("Enter the amount you will pay:");
                                        double amount = menuDisplay.checkAmount();
                                        System.out.print("Enter the way you will pay by:");
                                        int way = menuDisplay.displayWayPayment(fawryScreen, we);
                                        way--;
                                        if(way == we.getWaysOfPayment().size()){
                                            break;
                                        }
                                        System.out.println(fawryScreen.payButtonMobileService(client, we, amount, way));
                                    } else if (payChoiceService == 2) {
                                        System.out.print("Enter the amount you will pay:");
                                        double amount = menuDisplay.checkAmount();
                                        System.out.print("Enter the way you will pay by:");
                                        int way = menuDisplay.displayWayPayment(fawryScreen, we);
                                        way--;
                                        if(way == we.getWaysOfPayment().size()){
                                            break;
                                        }
                                        System.out.println(fawryScreen.payButtonInternetService(client, we, amount, way));
                                    }
                                    else{
                                        break;
                                    }
                                }
                                while (payChoice == 4) {
                                    int payChoiceService = menuDisplay.payServiceMenu();
                                    if (payChoiceService == 1) {
                                        System.out.print("Enter the amount you will pay:");
                                        double amount = menuDisplay.checkAmount();
                                        System.out.print("Enter the way you will pay by:");
                                        int way = menuDisplay.displayWayPayment(fawryScreen, orange);
                                        way--;
                                        if(way == orange.getWaysOfPayment().size()){
                                            break;
                                        }
                                        System.out.println(fawryScreen.payButtonMobileService(client, orange, amount, way));
                                    } else if (payChoiceService == 2) {
                                        System.out.print("Enter the amount you will pay:");
                                        double amount = menuDisplay.checkAmount();
                                        System.out.print("Enter the way you will pay by:");
                                        int way = menuDisplay.displayWayPayment(fawryScreen, orange);
                                        way--;
                                        if(way == orange.getWaysOfPayment().size()){
                                            break;
                                        }
                                        System.out.println(fawryScreen.payButtonInternetService(client, orange, amount, way));
                                    }
                                    else {
                                        break;
                                    }
                                }
                                // Monthly Receipt
                                if (payChoice == 5) {
                                    System.out.print("Enter the amount you will pay:");
                                    double amount = menuDisplay.checkAmount();
                                    System.out.print("Enter the way you will pay by:");
                                    int way = menuDisplay.displayWayPayment(fawryScreen, monthlyReceipt);
                                    way--;
                                    if(way == monthlyReceipt.getWaysOfPayment().size()){
                                        break;
                                    }
                                    System.out.println(fawryScreen.payButtonLandlineService(client, monthlyReceipt, amount, way));

                                }
                                // Quarter Receipt
                                else if (payChoice == 6) {
                                    System.out.print("Enter the amount you will pay:");
                                    double amount = menuDisplay.checkAmount();
                                    System.out.print("Enter the way you will pay by:");
                                    int way = menuDisplay.displayWayPayment(fawryScreen, quarterReceipt);
                                    way--;
                                    if(way == quarterReceipt.getWaysOfPayment().size()){
                                        break;
                                    }
                                    System.out.println(fawryScreen.payButtonLandlineService(client, quarterReceipt, amount, way));
                                }
                                // NGOs
                                else if (payChoice == 7) {
                                    System.out.print("Enter the amount you will pay:");
                                    double amount = menuDisplay.checkAmount();
                                    System.out.print("Enter the way you will pay by:");
                                    int way = menuDisplay.displayWayPayment(fawryScreen, ngo);
                                    way--;
                                    if(way == ngo.getWaysOfPayment().size()){
                                        break;
                                    }
                                    System.out.println(fawryScreen.payButtonMobileService(client, ngo, amount, way));
                                }
                                // Cancer Hospital
                                else if (payChoice == 8) {
                                    System.out.print("Enter the amount you will pay:");
                                    double amount = menuDisplay.checkAmount();
                                    System.out.print("Enter the way you will pay by:");
                                    int way = menuDisplay.displayWayPayment(fawryScreen, cancerHospital);
                                    way--;
                                    if(way == cancerHospital.getWaysOfPayment().size()){
                                        break;
                                    }
                                    System.out.println(fawryScreen.payButtonMobileService(client, cancerHospital, amount, way));
                                }
                                // Schools
                                else if (payChoice == 9) {
                                    System.out.print("Enter the amount you will pay:");
                                    double amount = menuDisplay.checkAmount();
                                    System.out.print("Enter the way you will pay by:");
                                    int way = menuDisplay.displayWayPayment(fawryScreen, school);
                                    way--;
                                    if(way == school.getWaysOfPayment().size()){
                                        break;
                                    }
                                    System.out.println(fawryScreen.payButtonMobileService(client, school, amount, way));
                                }
                            }

                            // Add Credit Card
                            if (clientChoice == 3){
                                System.out.println("Enter your credit card number: ");
                                String CardNumber= menuDisplay.checkCard();
                                System.out.println("Enter the amount: ");
                                double amount= menuDisplay.checkAmount();
                                CreditCard creditCard = new CreditCard(CardNumber,amount);
                                client.setCreditCard(creditCard);
                                System.out.println(fawryScreen.addCreditCard(client,creditCard) );
                            }

                            //Add Funds
                            else if (clientChoice == 4){
                                System.out.print("Enter the desired amount: ");
                                double amount= menuDisplay.checkAmount();
                                System.out.println( fawryScreen.addFunds(client,amount) );
                                System.out.println( "Wallet : " + client.getWallet() );
                                System.out.println("Amount in Credit Card : " + client.creditCard.getAmount());

                            }

                            //Send Refund Request
                            else if(clientChoice == 5){
                                if(client.getTransactions().size() == 0){
                                    System.out.println("There is no transaction");
                                }
                                else {
                                    System.out.println("Choose one of your transactions");
                                    fawryScreen.displayClientTransactions(client);
                                    int num = menuDisplay.sendRequest(client);
                                    num--;
                                    if (num == client.getTransactions().size()) {
                                        continue;
                                    }
                                    Transaction transaction = client.getTransactions().get(num);
                                    fawryScreen.addRefundRequest(admin, transaction);
                                }
                            }


                            //Check Discounts
                            else if(clientChoice == 6) {
                                Service service = null;
                                int serviceChoice = menuDisplay.ServiceMenu();
                                if (serviceChoice == 1) {
                                    service = vodafone;
                                }
                                else if (serviceChoice == 2) {
                                    service = etisalat;
                                }

                                else if (serviceChoice == 3) {
                                    service = we;
                                }
                                else if (serviceChoice == 4) {
                                    service = orange;
                                }
                                // Monthly Receipt
                                else if (serviceChoice == 5) {
                                    service = monthlyReceipt;
                                }
                                // Quarter Receipt
                                else if (serviceChoice == 6) {
                                    service = quarterReceipt;
                                }
                                // NGOs
                                else if (serviceChoice == 7) {
                                    service = ngo;
                                }
                                // Cancer Hospital
                                else if (serviceChoice == 8) {
                                    service = cancerHospital;
                                }
                                // Schools
                                else if (serviceChoice == 9) {
                                    service = school;
                                }
                                else{
                                    continue;
                                }
                                fawryScreen.showAvailableDiscounts(service);
                            }
                            else if(clientChoice == 7){
                                fawryScreen.display(client);
                            }
                            else if(clientChoice == 8){
                                exit = false;
                                break;
                            }
                        }
                        else{
                            int adminChoice = menuDisplay.adminMenu();
                            while (adminChoice == 1){
                                int addDiscountChoice = menuDisplay.discountMenu();
                                if(addDiscountChoice == 1){
                                    System.out.println("Which service do you want to add discount for: ");
                                    Service service = null;
                                    int serviceChoice = menuDisplay.ServiceMenu();
                                    if (serviceChoice == 1) {
                                        service = vodafone;
                                    }
                                    else if (serviceChoice == 2) {
                                        service = etisalat;
                                    }

                                    else if (serviceChoice == 3) {
                                        service = we;
                                    }
                                    else if (serviceChoice == 4) {
                                        service = orange;
                                    }
                                    // Monthly Receipt
                                    else if (serviceChoice == 5) {
                                        service = monthlyReceipt;
                                    }
                                    // Quarter Receipt
                                    else if (serviceChoice == 6) {
                                        service = quarterReceipt;
                                    }
                                    // NGOs
                                    else if (serviceChoice == 7) {
                                        service = ngo;
                                    }
                                    // Cancer Hospital
                                    else if (serviceChoice == 8) {
                                        service = cancerHospital;
                                    }
                                    // Schools
                                    else if (serviceChoice == 9) {
                                        service = school;
                                    }
                                    else{
                                        break;
                                    }
                                    System.out.println("How much percentage do you want to add: ");
                                    double percentage = menuDisplay.checkAmount();
                                    OverallDiscount overallDiscount = new OverallDiscount(service, percentage);
                                    System.out.println(fawryScreen.addOverallDiscount(overallDiscount));
                                }
                                else if(addDiscountChoice == 2){
                                    System.out.println("Which Category:");
                                    int category = menuDisplay.ServiceCategoyMenu();
                                    Service service = null;
                                    if(category == 1 || category == 2){
                                        System.out.println("Which service do you want to add discount for: ");
                                        int serviceChoice = menuDisplay.MobileMenuService();
                                        if (serviceChoice == 1) {
                                            service = vodafone;
                                        }
                                        else if (serviceChoice == 2) {
                                            service = etisalat;
                                        }

                                        else if (serviceChoice == 3) {
                                            service = we;
                                        }
                                        else if (serviceChoice == 4) {
                                            service = orange;
                                        }
                                        else if(serviceChoice == 5){
                                            break;
                                        }
                                    }
                                    else if(category == 3){
                                        System.out.println("Which service do you want to add discount for: ");
                                        int serviceChoice = menuDisplay.landlineenuService();
                                        // Monthly Receipt
                                        if (serviceChoice == 1) {
                                            service = monthlyReceipt;
                                        }
                                        // Quarter Receipt
                                        else if (serviceChoice == 2) {
                                            service = quarterReceipt;
                                        }
                                        else if(serviceChoice == 3){
                                            break;
                                        }
                                    }
                                    else if(category == 4){
                                        System.out.println("Which service do you want to add discount for: ");
                                        // NGOs
                                        int serviceChoice = menuDisplay.DonationMenuService();
                                        if (serviceChoice == 1) {
                                            service = ngo;
                                        }
                                        // Cancer Hospital
                                        else if (serviceChoice == 2) {
                                            service = cancerHospital;
                                        }
                                        // Schools
                                        else if (serviceChoice == 3) {
                                            service = school;
                                        }
                                        else if(serviceChoice == 4){
                                            break;
                                        }
                                    }
                                    else{
                                        break;
                                    }
                                    System.out.println("How much percentage do you want to add: ");
                                    double percentage = menuDisplay.checkAmount();
                                    SpecificDiscount specificDiscount = new SpecificDiscount(service, percentage);
                                    if(category == 1){
                                        System.out.println(fawryScreen.addMobileServiceDiscount(specificDiscount));
                                    }
                                    else if(category == 2){
                                        System.out.println(fawryScreen.addInternetServiceDiscount(specificDiscount));
                                    }
                                    else if(category == 3){
                                        System.out.println(fawryScreen.addLandLineServiceDiscount(specificDiscount));

                                    }
                                    else{
                                        System.out.println(fawryScreen.addDonationServiceDiscount(specificDiscount));
                                    }
                                }
                                else{
                                    break;
                                }
                            }
                            if (adminChoice == 2){
                                fawryScreen.listAllRefundRequest();
                                if(database.refunds.size() == 0){
                                    continue;
                                }
                                System.out.println("Do you want to approve refund request?");
                                System.out.println("1 for YES, 0 for NO");
                                int no = sc.nextInt();
                                while (no > 1 || no < 0){
                                    System.out.println("Please enter a valid number 0 or 1");
                                    no = sc.nextInt();
                                }
                                if(no == 0){
                                    continue;
                                }
                                System.out.println("Which index of refund request: ");
                                int index = sc.nextInt();
                                while (index > database.refunds.size() || index < 1){
                                    int val = database.refunds.size();
                                    val--;
                                    System.out.println("Please enter a valid number between 0 to " + val);
                                    index = sc.nextInt();
                                }
                                System.out.println("Do you accept this refund request: ");
                                System.out.println("1 for YES, 0 for NO");
                                no = sc.nextInt();
                                while (no > 1 || no < 0){
                                    System.out.println("Please enter a valid number 0 or 1");
                                    no = sc.nextInt();
                                }
                                boolean accept = false;
                                if(no == 1){
                                    accept = true;
                                }
                                index--;
                                fawryScreen.acceptRefundRequestButton(accept, database.refunds.get(index));
                            }
                            else if(adminChoice == 3){
                                exit = false;
                                break;
                            }
                        }
                        System.out.println("\n");
                    }
                }
                else{
                    System.out.println("Do you want to go Main menu ?");
                    System.out.println("1 for YES, 0 for NO");
                    int back = sc.nextInt();
                    while (back > 1 || back < 0){
                        System.out.println("Please enter a valid number 0 or 1");
                        back = sc.nextInt();
                    }
                    if(back == 1){
                        choice = -1;
                        break;
                    }
                }
            }
            while (choice == 2){
                System.out.print("Enter a Username: ");
                String username = sc.next();
                System.out.print("Enter an Email: ");
                String email = sc.next();
                System.out.print("Enter a Password: ");
                String password = sc.next();
                System.out.print("Enter a wallet balance: ");
                double wallet = menuDisplay.checkAmount();
                Client client = new Client(username, email, password, wallet);
                String result = fawryScreen.signUpButton(client);
                if(result.equals("-1")){
                    System.out.println("Can not register with this account");
                }
                else{
                    System.out.println("Added Successfully");
                }
                break;
            }
            if(choice == 3){
                System.out.println("Thank you using our system");
                break;
            }
        }
    }
}
