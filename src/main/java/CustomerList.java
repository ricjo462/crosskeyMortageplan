import java.util.ArrayList;

public class CustomerList {
    private static ArrayList<Customer> customerList;

    /**
     * Used to save all customers to be printed
     */
    public CustomerList() {
        customerList = new ArrayList<>();
    }

    /**
     * Prints the name, total loan, loan period and monthly payment of all customers
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

    public static void add(Customer customer) {
        customerList.add(customer);
    }

    public static ArrayList<Customer> getCustomerList() {
        return customerList;
    }
}
