package Services;

public interface OnlinePaymentsService {

    double paymentFee(double amount);
    double interest(double amount, int months);

}
