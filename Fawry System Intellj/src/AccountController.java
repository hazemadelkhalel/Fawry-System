public class AccountController extends FawryController{
    String addAccount(Admin admin){
        database.accounts.put(admin, "Admin");
        return "Account added successfully";
    }
    String addAccount(Client client) {
        database.accounts.put(client, "Client");
        return "Account added successfully";
    }
}
