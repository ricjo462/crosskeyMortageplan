public class MortageCalculator {

    public MortageCalculator(){
        mortageCalculator();
    }


    /**
     * Calculates the monthly payments and saves the data into the Customer list
     */
    public void mortageCalculator(){
        double E; // fixed monthly payment
        double b; // interest on a monthly basis
        double U; // total loan
        double p; // number of payments

        for (Customer customer : CustomerList.getCustomerList()){
            b = customer.getInterest()/12.0;
            U = customer.getTotalLoan();
            p = customer.getYears()*12.0;
            E = U * b * powerOf((1.0 + b), p) / (powerOf((1.0 + b), p) - 1.0);

            customer.setMonthlyPayment(round(E));
        }
    }

    /**
     * Exponential calculator with an exponent that is a double
     * @return the base to the power of exponent
     */
    public static double powerOf(double base, double exponent){
        int exp = (int) exponent;
        return powerOf(base, exp);
    }

    /**
     * My implementation of an exponential multiplication calculator
     * @param base the double to be raised
     * @param exponent the integer to raise the base to
     * @return the base to the power of the exponent
     */
    public static double powerOf(double base, int exponent) {
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
    public static double round(double x) {
        return ((double)(int)(x * 100 + 0.5)) / 100;
    }

}
