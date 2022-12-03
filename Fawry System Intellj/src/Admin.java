import java.util.ArrayList;

public class Admin extends Account{
    Admin(String username, String email, String password){
        this.username = username;
        this.email = email;
        this.password = password;
    }

    @Override
    public void update(boolean acceptance, Transaction transaction) {

    }
}
