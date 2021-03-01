import org.junit.After;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

public class CustomerListTest {
    CustomerList cl;
    Customer c;
    MortageCalculator mc;
    PrintStream standardOut = System.out;
    ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

    @BeforeEach
    public void setup() {
        System.setOut(new PrintStream(outputStreamCaptor));
        cl = new CustomerList();
        c = new Customer("MrTest", 1000, 0.05, 2);
        c.setMonthlyPayment(43.87);
        cl.add(c);
    }

    @Test
    public void testPrintMonthlyPayment() {
        cl.printMonthlyPayment();
        assertEquals("****************************************************************************************************\n" +
                "Prospect 1: MrTest wants to borrow 1000.0€ for a period of 2 years and pay 43.87€ each month\n" +
                "****************************************************************************************************",
                outputStreamCaptor.toString().trim());
    }

    @After
    public void reset() {
        System.setOut(standardOut);
    }
}