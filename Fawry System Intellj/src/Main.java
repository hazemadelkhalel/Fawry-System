import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Database database = new Database();
        FawryScreen fawryScreen = new FawryScreen(database);
        Client client ;
        while(true) {
            System.out.println("1-Admin");
            System.out.println("2-User");



            int choice;
            Scanner sc = new Scanner(System.in);
            choice = sc.nextInt();


            if (choice == 1) {


            }
            // User
            else if (choice == 2) {
                System.out.println("1-Login");
                System.out.println("2-Signup");
                System.out.println("3-Exit");
                choice = sc.nextInt();
                if(choice == 3){
                    break;
                }
                // Sign Up
                else if (choice == 2) {
                    System.out.print("Enter a Username: ");
                    String username = sc.next();
                    System.out.print("Enter an Email: ");
                    String email = sc.next();
                    System.out.print("Enter a Password: ");
                    String password = sc.next();
                    System.out.print("Enter a wallet balance: ");
                    double wallet = sc.nextDouble();
                     client = new Client(username, email, password, wallet);
//                    Database database = new Database();
//                    FawryScreen fawryScreen = new FawryScreen(database);
                    fawryScreen.signUpButton(client);
                    System.out.println(fawryScreen.signUpButton(client));


                }
                // Login
               // else if (choice == 1) {
                    System.out.print("Enter your Username: ");
                    String username = sc.next();
                    System.out.print("Enter your Email: ");
                    String email = sc.next();
                    System.out.print("Enter your Password: ");
                    String password = sc.next();
                    System.out.print("Enter your current wallet balance: ");
                    double wallet = sc.nextDouble();
                    client = new Client(username, email, password, wallet);
//                    Database database = new Database();
//                    FawryScreen fawryScreen = new FawryScreen(database);
                    if (fawryScreen.loginButton(client) == "-1") {
//                        System.out.println("hhhhhh");
                        //New to the system or wrong info

                    }
                    // If logged in as a normal user
                    else {
                        System.out.println(fawryScreen.loginButton(client));
                        while (true) {
                            System.out.println("1-Search");
                            System.out.println("2-Pay");
                            System.out.println("3-Add Credit Card");
                            System.out.println("4-Add Funds");
                            System.out.println("5-Send Refund Request");
                            System.out.println("6-Check Discounts");
                            System.out.println("7-Sign Out");
                            choice = sc.nextInt();
                            if (choice == 7) {
                                break;
                            }
                            // Search
                            if (choice == 1) {
                                System.out.println("1-Mobile Service");
                                System.out.println("2-Internet Service");
                                System.out.println("3-Landline Service");
                                System.out.println("4-Donation Service");
                                choice = sc.nextInt();
                                if (choice == 1) {
                                    System.out.print("Enter your desired category in Mobile Service:");
                                    String word = sc.next();
                                    fawryScreen.searchMobileServiceButton(word);
                                } else if (choice == 2) {
                                    System.out.print("Enter your desired category in Internet Service:");
                                    String word = sc.next();
                                    fawryScreen.searchInternetServiceButton(word);
                                } else if (choice == 3) {
                                    System.out.print("Enter your desired category in Landline Service:");
                                    String word = sc.next();
                                    fawryScreen.searchLandlineServiceButton(word);
                                } else if (choice == 4) {
                                    System.out.print("Enter your desired category in Donation Service:");
                                    String word = sc.next();
                                    fawryScreen.searchDonationServiceButton(word);
                                }

                            }
                            // Pay
                            else if (choice == 2) {
                                System.out.println("1-Vodafone");
                                System.out.println("2-Etisalat");
                                System.out.println("3-We");
                                System.out.println("4-Orange");
                                System.out.println("5-Monthly Receipt");
                                System.out.println("6-Quarter Receipt");
                                System.out.println("7-NGOs");
                                System.out.println("8-Cancer Hospitals");
                                System.out.println("9-Schools");
                                choice = sc.nextInt();
                                if (choice == 1) {
                                    System.out.println("1-Pay for Mobile Service");
                                    System.out.println("2-Pay for Internet Service");
                                    choice = sc.nextInt();
                                    if (choice == 1) {
                                        Service service = new Vodafone("Mobile Service");
                                        System.out.print("Enter the amount you will pay:");
                                        double amount = sc.nextDouble();
                                        System.out.print("Enter the way you will pay by:");
                                        int way = sc.nextInt();
                                        fawryScreen.payButtonMobileService(client, service, amount, way);
                                    } else if (choice == 2) {
                                        Service service = new Vodafone("Internet Service");
                                        System.out.print("Enter the amount you will pay:");
                                        double amount = sc.nextDouble();
                                        System.out.print("Enter the way you will pay by:");
                                        int way = sc.nextInt();
                                        fawryScreen.payButtonInternetService(client, service, amount, way);
                                    }
                                } else if (choice == 2) {
                                    System.out.println("1-Pay for Mobile Service");
                                    System.out.println("2-Pay for Internet Service");
                                    choice = sc.nextInt();
                                    if (choice == 1) {
                                        Service service = new Etisalat("Mobile Service");
                                        System.out.print("Enter the amount you will pay:");
                                        double amount = sc.nextDouble();
                                        System.out.print("Enter the way you will pay by:");
                                        int way = sc.nextInt();
                                        fawryScreen.payButtonMobileService(client, service, amount, way);
                                    } else if (choice == 2) {
                                        Service service = new Etisalat("Internet Service");
                                        System.out.print("Enter the amount you will pay:");
                                        double amount = sc.nextDouble();
                                        System.out.print("Enter the way you will pay by:");
                                        int way = sc.nextInt();
                                        fawryScreen.payButtonInternetService(client, service, amount, way);
                                    }
                                } else if (choice == 3) {
                                    System.out.println("1-Pay for Mobile Service");
                                    System.out.println("2-Pay for Internet Service");
                                    choice = sc.nextInt();
                                    if (choice == 1) {
                                        Service service = new We("Mobile Service");
                                        System.out.print("Enter the amount you will pay:");
                                        double amount = sc.nextDouble();
                                        System.out.print("Enter the way you will pay by:");
                                        int way = sc.nextInt();
                                        fawryScreen.payButtonMobileService(client, service, amount, way);
                                    } else if (choice == 2) {
                                        Service service = new We("Internet Service");
                                        System.out.print("Enter the amount you will pay:");
                                        double amount = sc.nextDouble();
                                        System.out.print("Enter the way you will pay by:");
                                        int way = sc.nextInt();
                                        fawryScreen.payButtonInternetService(client, service, amount, way);
                                    }
                                } else if (choice == 4) {
                                    System.out.println("1-Pay for Mobile Service");
                                    System.out.println("2-Pay for Internet Service");
                                    choice = sc.nextInt();
                                    if (choice == 1) {
                                        Service service = new Orange("Mobile Service");
                                        System.out.print("Enter the amount you will pay:");
                                        double amount = sc.nextDouble();
                                        System.out.print("Enter the way you will pay by:");
                                        int way = sc.nextInt();
                                        fawryScreen.payButtonMobileService(client, service, amount, way);
                                    } else if (choice == 2) {
                                        Service service = new Orange("Internet Service");
                                        System.out.print("Enter the amount you will pay:");
                                        double amount = sc.nextDouble();
                                        System.out.print("Enter the way you will pay by:");
                                        int way = sc.nextInt();
                                        fawryScreen.payButtonInternetService(client, service, amount, way);
                                    }
                                }
                                // Monthly Receipt
                                else if (choice == 5) {
                                    System.out.println("1-You are currently paying for Landline Service");
                                    Service service = new MonthlyReceipt("Landline Service");
                                    System.out.print("Enter the amount you will pay:");
                                    double amount = sc.nextDouble();
                                    System.out.print("Enter the way you will pay by:");
                                    int way = sc.nextInt();
                                    fawryScreen.payButtonLandlineService(client, service, amount, way);

                                }
                                // Quarter Receipt
                                else if (choice == 6) {
                                    System.out.println("1-You are currently paying for Landline Service");
                                    Service service = new QuarterReceipt("Landline Service");
                                    System.out.print("Enter the amount you will pay:");
                                    double amount = sc.nextDouble();
                                    System.out.print("Enter the way you will pay by:");
                                    int way = sc.nextInt();
                                    fawryScreen.payButtonLandlineService(client, service, amount, way);
                                }
                                // NGOs
                                else if (choice == 7) {
                                    System.out.println("1-You are currently paying for Donation Service");
                                    Service service = new NGO("Donation Service");
                                    System.out.print("Enter the amount you will pay:");
                                    double amount = sc.nextDouble();
                                    System.out.print("Enter the way you will pay by:");
                                    int way = sc.nextInt();
                                    fawryScreen.payButtonDonationService(client, service, amount, way);
                                }
                                // Cancer Hospital
                                else if (choice == 8) {
                                    System.out.println("1-You are currently paying for Donation Service");
                                    Service service = new CancerHospital("Donation Service");
                                    System.out.print("Enter the amount you will pay:");
                                    double amount = sc.nextDouble();
                                    System.out.print("Enter the way you will pay by:");
                                    int way = sc.nextInt();
                                    fawryScreen.payButtonDonationService(client, service, amount, way);
                                }
                                // Schools
                                else if (choice == 9) {
                                    System.out.println("1-You are currently paying for Donation Service");
                                    Service service = new School("Donation Service");
                                    System.out.print("Enter the amount you will pay:");
                                    double amount = sc.nextDouble();
                                    System.out.print("Enter the way you will pay by:");
                                    int way = sc.nextInt();
                                    fawryScreen.payButtonDonationService(client, service, amount, way);
                                }
                            }
                            // Add Credit Card
                            else if(choice == 3){
                                System.out.print("Enter your credit card number: ");
                                String CardNumber= sc.next();
                                System.out.print("Enter the amount: ");
                                double amount= sc.nextDouble();
                                CreditCard creditCard = new CreditCard(CardNumber,amount);
//                                fawryScreen.addCreditCard(client,creditCard);
                                client.setCreditCard(creditCard);
                                System.out.println(fawryScreen.addCreditCard(client,creditCard) );
                                System.out.println( client.creditCard.getAmount() );

                            }

                            //Add Funds
                            else if(choice == 4){
                                System.out.print("Enter the desired amount: ");
                                double amount= sc.nextDouble();
//                                fawryScreen.addFunds(client,amount);
                                System.out.println( fawryScreen.addFunds(client,amount) );
                                System.out.println( "Wallet : " + client.getWallet() );
                                System.out.println("Amount in cc : " + client.creditCard.getAmount());

                            }

                            //Send Refund Request
                            else if(choice == 5){
                                Transaction transaction;
                                Service service = null;
                                System.out.println("1-Vodafone");
                                System.out.println("2-Etisalat");
                                System.out.println("3-We");
                                System.out.println("4-Orange");
                                System.out.println("5-Monthly Receipt");
                                System.out.println("6-Quarter Receipt");
                                System.out.println("7-NGOs");
                                System.out.println("8-Cancer Hospitals");
                                System.out.println("9-Schools");
                                choice = sc.nextInt();
                                if (choice == 1) {
                                    System.out.println("1-Send Refund Request for Mobile Service");
                                    System.out.println("2-Send Refund Request for Internet Service");
                                    choice = sc.nextInt();
                                    if (choice == 1) {
                                        
                                    } else if (choice == 2) {
                                        
                                    }
                                    service = new Vodafone("Vodafone");
                                    
                                    
                                } else if (choice == 2) {
                                    System.out.println("1-Send Refund Request for Mobile Service");
                                    System.out.println("2-Send Refund Request for Internet Service");
                                    choice = sc.nextInt();
                                    if (choice == 1) {

                                    } else if (choice == 2) {

                                    }
                                    service = new Etisalat("Etisalat");
                                } else if (choice == 3) {
                                    System.out.println("1-Send Refund Request for Mobile Service");
                                    System.out.println("2-Send Refund Request for Internet Service");
                                    choice = sc.nextInt();
                                    if (choice == 1) {

                                    } else if (choice == 2) {

                                    }
                                    service = new We("We");
                                } else if (choice == 4) {
                                    System.out.println("1-Send Refund Request for Mobile Service");
                                    System.out.println("2-Send Refund Request for Internet Service");
                                    choice = sc.nextInt();
                                    if (choice == 1) {

                                    } else if (choice == 2) {

                                    }
                                    service = new Orange("Orange");
                                }
                                // Monthly Receipt
                                else if (choice == 5) {
                                    System.out.println("1-You are currently paying for Landline Service");
                                    service = new MonthlyReceipt("Landline Service");

                                }
                                // Quarter Receipt
                                else if (choice == 6) {
                                    System.out.println("1-You are currently paying for Landline Service");
                                    service = new QuarterReceipt("Landline Service");
                                }
                                // NGOs
                                else if (choice == 7) {
                                    System.out.println("1-You are currently paying for Donation Service");
                                    service = new NGO("Donation Service");
                                }
                                // Cancer Hospital
                                else if (choice == 8) {
                                    System.out.println("1-You are currently paying for Donation Service");
                                    service = new CancerHospital("Donation Service");
                                }
                                // Schools
                                else if (choice == 9) {
                                    System.out.println("1-You are currently paying for Donation Service");
                                    service = new School("Donation Service");
                                }
                                System.out.print("Enter the amount you will pay:");
                                double amount = sc.nextDouble();
                                System.out.print("Enter the way you will pay by:");
                                int way = sc.nextInt();
                                transaction = new Transaction(client , service , amount , way );
                                fawryScreen.addRefundRequest(transaction);
                            }

                            //Check Discounts
                            else if(choice == 6)
                            {
                                Service service = null;
                                System.out.println("1-Vodafone");
                                System.out.println("2-Etisalat");
                                System.out.println("3-We");
                                System.out.println("4-Orange");
                                System.out.println("5-Monthly Receipt");
                                System.out.println("6-Quarter Receipt");
                                System.out.println("7-NGOs");
                                System.out.println("8-Cancer Hospitals");
                                System.out.println("9-Schools");
                                choice = sc.nextInt();
                                if (choice == 1) {
                                    System.out.println("1-Check Discounts for Mobile Service");
                                    System.out.println("2-Check Discounts for Internet Service");
                                    choice = sc.nextInt();
                                    if (choice == 1) {

                                    } else if (choice == 2) {

                                    }
                                    service = new Vodafone("Vodafone");


                                } else if (choice == 2) {
                                    System.out.println("1-Check Discounts for Mobile Service");
                                    System.out.println("2-Check Discounts for Internet Service");
                                    choice = sc.nextInt();
                                    if (choice == 1) {

                                    } else if (choice == 2) {

                                    }
                                    service = new Etisalat("Etisalat");
                                } else if (choice == 3) {
                                    System.out.println("1-Check Discounts for Mobile Service");
                                    System.out.println("2-Check Discounts for Internet Service");
                                    choice = sc.nextInt();
                                    if (choice == 1) {

                                    } else if (choice == 2) {

                                    }
                                    service = new We("We");
                                } else if (choice == 4) {
                                    System.out.println("1-Check Discounts for Mobile Service");
                                    System.out.println("2-Check Discounts for Internet Service");
                                    choice = sc.nextInt();
                                    if (choice == 1) {

                                    } else if (choice == 2) {

                                    }
                                    service = new Orange("Orange");
                                }
                                // Monthly Receipt
                                else if (choice == 5) {
                                    System.out.println("1-You are checking discounts for Landline Service");
                                    service = new MonthlyReceipt("Landline Service");

                                }
                                // Quarter Receipt
                                else if (choice == 6) {
                                    System.out.println("1-You are checking discounts for Landline Service");
                                    service = new QuarterReceipt("Landline Service");
                                }
                                // NGOs
                                else if (choice == 7) {
                                    System.out.println("1-You are checking discounts for Donation Service");
                                    service = new NGO("Donation Service");
                                }
                                // Cancer Hospital
                                else if (choice == 8) {
                                    System.out.println("1-You are checking discounts for Donation Service");
                                    service = new CancerHospital("Donation Service");
                                }
                                // Schools
                                else if (choice == 9) {
                                    System.out.println("1-You are checking discounts for Donation Service");
                                    service = new School("Donation Service");
                                }
                                fawryScreen.checkDiscountAvailable(service);
                            }


                        }



                    }
                //}
//                 else if (choice == 2) {
//                    System.out.print("Enter a Username: ");
//                    String username = sc.next();
//                    System.out.print("Enter an Email: ");
//                    String email = sc.next();
//                    System.out.print("Enter a Password: ");
//                    String password = sc.next();
//                    System.out.print("Enter a wallet balance: ");
//                    double wallet = sc.nextDouble();
//                    Client client = new Client(username, email, password, wallet);
//                    Database database = new Database();
//                    FawryScreen fawryScreen = new FawryScreen(database);
//                    fawryScreen.signUpButton(client);
//                    System.out.println(fawryScreen.signUpButton(client));
//
//                    System.out.print("Enter your Username: ");
//                    username = sc.next();
//                    System.out.print("Enter your Email: ");
//                    email = sc.next();
//                    System.out.print("Enter your Password: ");
//                    password = sc.next();
//                    System.out.print("Enter your current wallet balance: ");
//                    wallet = sc.nextDouble();
//                    //client = new Client(username, email, password, wallet);
//                    System.out.println(fawryScreen.loginButton(client));
//                }
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
