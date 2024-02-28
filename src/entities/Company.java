package entities;

public class Company extends TaxPayer {
    private Integer numberOfEmployees;

    public Company(String name, Double annualIncome, Integer numberOfEmployees) {
        super(name, annualIncome);
        this.numberOfEmployees = numberOfEmployees;
    }

    public Integer getNumberOfEmployees() {
        return numberOfEmployees;
    }

    public void setNumberOfEmployees(Integer numberOfEmployees) {
        this.numberOfEmployees = numberOfEmployees;
    }

    @Override
    public Double taxPaid() {
        double tax;

        if (numberOfEmployees <= 10) {
            tax = 0.16 * annualIncome;
        } else {
            tax = 0.14 * annualIncome;
        }

        return tax;
    }
}
