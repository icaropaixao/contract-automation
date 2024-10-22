package Services;

import entities.Contract;
import entities.Installment;

import java.time.LocalDate;

public class ContractService {

    private OnlinePaymentsService onlinePaymentsService;

    public ContractService(OnlinePaymentsService onlinePaymentsService){
        this.onlinePaymentsService = onlinePaymentsService;
    }

    public void processContract(Contract contract, int months){

        double basicQuota  = contract.getTotalValue() / months;

        for (int i = 1; i <= months; i++){
            LocalDate vencimento = contract.getDate().plusMonths(i);

            double interest = onlinePaymentsService.interest(basicQuota, i); // juros
            double fee = onlinePaymentsService.paymentFee(basicQuota + interest); // taxa
            double quota = basicQuota + interest + fee;

            contract.getInstallments().add(new Installment(vencimento,quota));

        }

    }
}
