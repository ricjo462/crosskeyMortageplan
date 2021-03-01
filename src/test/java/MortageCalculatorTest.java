import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public final class MortageCalculatorTest {
    CustomerList cl;
    Customer c;
    MortageCalculator mc;

    @Test
    public void testMortageCalculator() {
        cl = new CustomerList();
        c = new Customer("MrTest", 1000, 0.05, 2);
        cl.add(c);
        mc = new MortageCalculator();
        mc.mortageCalculator();
        assertEquals(43.87, c.monthlyPayment);
    }

    @Test
    public void testPowerOf() {
        assertEquals(25, mc.powerOf(5,2));
        assertEquals(1, mc.powerOf(5,0));
        assertEquals(5, mc.powerOf(5,1));
    }

    @Test
    public void round() {
        assertEquals(10.0, mc.round(9.999));
        assertEquals(1.34, mc.round(1.337));
    }
}