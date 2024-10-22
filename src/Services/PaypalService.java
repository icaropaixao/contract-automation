package Services;

public class PaypalService implements OnlinePaymentsService{

    @Override
    public double paymentFee(double amount) {
        return amount * 0.02; // taxa de 2%
    }

    @Override
    public double interest(double amount, int months) {
        return amount * 0.01 * months;
    }
}
