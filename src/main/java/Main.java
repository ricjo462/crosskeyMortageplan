public class Main {
    private static String filename = "prospects.txt";

    public static void main(String[] args) {
        Reader reader = new Reader(filename);
        MortageCalculator calculator = new MortageCalculator(reader);
        calculator.printMonthlyPayment();
    }
}