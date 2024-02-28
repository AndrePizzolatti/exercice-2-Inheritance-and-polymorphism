package entities;

public class Individual extends TaxPayer {
    private Double healthExpenditures;

    public Individual(String name, Double annualIncome, Double healthExpenditures) {
        super(name, annualIncome);
        this.healthExpenditures = healthExpenditures;
    }

    public Double getHealthSpending() {
        return healthExpenditures;
    }

    public void setHealthSpending(Double healthExpenditures) {
        this.healthExpenditures = healthExpenditures;
    }

    @Override
    public Double taxPaid() {
        double tax;

        if (annualIncome < 20000) {
            tax = 0.15 * annualIncome - 0.5 * healthExpenditures;
        } else {
            tax = 0.25 * annualIncome - 0.5 * healthExpenditures;
        }

        return tax;
    }
}
