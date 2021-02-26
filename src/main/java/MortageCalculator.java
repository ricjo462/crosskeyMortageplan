import java.util.ArrayList;

public class MortageCalculator {
    Reader reader;
    ArrayList<Customer> customerList;

    public MortageCalculator(Reader reader){
        this.reader = reader;
        customerList = reader.getCustomerList();
        mortageCalculator();
    }


    /**
     * Calculates the monthly payments and saves the data into Customer class
     */
    private void mortageCalculator(){
        double E; // fixed monthly payment
        double b; // interest on a monthly basis
        double U; // total loan
        double p; // number of payments

        for (Customer customer : customerList){
            b = customer.getInterest()/12.0;
            U = customer.getTotalLoan();
            p = customer.getYears()*12.0;
            E = U * b * powerOf((1.0 + b), p) / (powerOf((1.0 + b), p) - 1.0);

            customer.setMonthlyPayment(round(E));
        }
    }

    /**
     * To be used if the exponent is a double
     * @return the value of powerOf(double,int)
     */
    private static double powerOf(double base, double exponent){
        int exp = (int) exponent;
        return powerOf(base, exp);
    }

    /**
     * My implementation of an exponential multiplication
     * @param base the double to be raised
     * @param exponent the integer to raise the base to
     * @return the base to the power of the exponent
     */
    private static double powerOf(double base, int exponent) {
        double answer = 1;
        if (base == 0){
            return answer;
        }
        for (int i=0; i<exponent; i++) {
            answer *= base;
        }
        return answer;
    }

    /**
     * My implementation of a method to round to two decimal places
     * @param x the decimal number to be rounded
     * @return a double rounded to two decimal places
     */
    private static double round(double x) {
        return ((double)(int)(x * 100 + 0.5)) / 100;
    }

    /**
     * Prints the name, total loan, loan period and monthly payment of all customers in Customer
     */
    public void printMonthlyPayment(){
        int prospectNr = 0;

        System.out.println("***************************************************************" +
                "*************************************");
        for(Customer customer : customerList){
            prospectNr++;
            System.out.println("Prospect " + prospectNr + ": " + customer.name +
                    " wants to borrow " + customer.totalLoan + "€ for a period of " + (int)customer.years +
                    " years and pay " + customer.monthlyPayment + "€ each month");
            System.out.println("***************************************************************" +
                    "*************************************");
        }
    }
}
