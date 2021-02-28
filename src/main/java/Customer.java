public class Customer {
    String name;
    double totalLoan;
    double interest;
    double years;
    double monthlyPayment;

    public Customer(String name, double totalLoan, double interest, double years) {
        this.name = name;
        this.totalLoan = totalLoan;
        this.interest = interest;
        this.years = years;
    }

    public void setMonthlyPayment(double monthlyPayment) {
        this.monthlyPayment = monthlyPayment;
    }

    public double getTotalLoan() {
        return this.totalLoan;
    }

    public double getInterest() {
        return this.interest;
    }

    public double getYears() {
        return this.years;
    }
}