public class Main {
    private static String filename = "prospects.txt";

    public static void main(String[] args) {
        CustomerList customerList = new CustomerList();
        Reader reader = new Reader();
        reader.read(filename);
        new MortageCalculator(reader);
        customerList.printMonthlyPayment();
    }
}