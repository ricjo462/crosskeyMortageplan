public class Main {
    private static String filename = "prospects.txt";

    public static void main(String[] args) {
        CustomerList customerList = new CustomerList();
        Reader reader = new Reader();
        MortageCalculator mortageCalculator = new MortageCalculator();

        reader.read(filename);
        mortageCalculator.calculate();
        customerList.printMonthlyPayment();
    }
}