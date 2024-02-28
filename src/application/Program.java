package application;

import entities.Company;
import entities.Individual;
import entities.TaxPayer;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        List<TaxPayer> payers = new ArrayList<>();

        System.out.print("Enter the number of tax payers: ");
        int numberOfTaxPayers = sc.nextInt();

        sc.nextLine();

        for (int i=1; i<=numberOfTaxPayers; i++) {
            System.out.println("Tax payer #" + i + " data:");

            System.out.print("Individual or company (i/c)? ");
            char payerType = sc.next().charAt(0);
            sc.nextLine();

            System.out.print("Name: ");
            String name = sc.nextLine();

            System.out.print("Annual income: ");
            double annualIncome = sc.nextDouble();

            switch (payerType) {

                case 'i':
                    System.out.print("Health expenditures: ");
                    double healthExpenditures = sc.nextDouble();
                    payers.add(new Individual(name, annualIncome, healthExpenditures));
                    break;

                case 'c':
                    System.out.print("Number of employees: ");
                    int numberOfEmployees = sc.nextInt();
                    sc.nextLine();
                    payers.add(new Company(name, annualIncome, numberOfEmployees));
                    break;

                default:
                    break;
            }
        }

        sc.close();

        System.out.println();
        System.out.println("TAXES PAID:");

        double totalTaxes = 0;

        for (TaxPayer payer : payers) {
            System.out.printf("%s: $ %.2f%n", payer.getName(), payer.taxPaid());
            totalTaxes += payer.taxPaid();
        }

        System.out.println();
        System.out.printf("TOTAL TAXES: $ %.2f", totalTaxes);
    }
}
