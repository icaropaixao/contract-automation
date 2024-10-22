package Application;

import Services.ContractService;
import Services.PaypalService;
import entities.Contract;
import entities.Installment;

import java.text.DateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Scanner;

import java.util.Scanner;

public class Program {
    public static void main(String[] args) {

        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        System.out.println("Entre com os dados do contrato: ");

        System.out.print("Numero: ");
        int number = sc.nextInt();

        System.out.print("Data (dd/MM/yyyy): ");
        LocalDate date = LocalDate.parse(sc.next(), fmt);

        System.out.print("Valor do contrato: ");
        double totalValue = sc.nextDouble();

        // criando o contrato
        Contract objContract = new Contract(number,date,totalValue);

        System.out.print("Numero de parcelas: ");
        int n = sc.nextInt();


        
        ContractService contractService = new ContractService(new PaypalService());

        contractService.processContract(objContract,n);

        System.out.println("Parcelas: ");

        for (Installment installment : objContract.getInstallments()){
            System.out.println(installment);
        }

        sc.close();
    }
}
