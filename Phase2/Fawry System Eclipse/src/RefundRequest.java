import java.util.ArrayList;

public class RefundRequest implements Subject{
    Transaction transaction;
    RefundRequest(Transaction transaction){
        this.transaction = transaction;
    }
    @Override
    public void notify(boolean acceptance) {
        transaction.getClient().update(acceptance, transaction);
    }
}
