
public class RefundController extends FawryController {
    RefundController(Database database){
        this.database = database;
    }

    // change return type boolean
    void checkApproval(Transaction transaction) {
        // return admin's approval for a transaction
    }

    void listAllTransaction() {
        // print all transaction
    }
}