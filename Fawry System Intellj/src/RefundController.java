import java.util.ArrayList;

public class RefundController extends FawryController {
    RefundController(Database database){
        this.database = database;
    }

    String addRefundRequest(Transaction transaction){
        RefundRequest refundRequest = new RefundRequest(transaction);
        database.refunds.add(refundRequest);
        return "Added Successfully";
    }

    boolean applyApproval(boolean acceptance, RefundRequest refundRequest) {
        database.refunds.remove(refundRequest);
        refundRequest.notify(acceptance);
        return acceptance;
    }

    ArrayList<Transaction> listAllTransaction(Client client, Service service) {
        ArrayList<Transaction> transactions = new ArrayList<>();
        for(int i = 0; i < client.getTransactions().size(); i++){
            if(client.getTransactions().get(i).getService().getServiceName().equals(service.getServiceName())){
                transactions.add(client.getTransactions().get(i));
            }
        }
        return transactions;
    }
}