import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Reader {
    private static ArrayList<Customer> customerList;

    public Reader(String filename){
        customerList = new ArrayList<>();
        reader(filename);
    }

    public ArrayList<Customer> getCustomerList() {
        return customerList;
    }

    /**
     * Reads a file and saves the data into Customer class
     * @param prospectsFileName name of the file to be read
     */
    private void reader(String prospectsFileName){
        String name = "";
        double totalLoan;
        double interest;
        int years;
        try {
            ClassLoader classLoader = getClass().getClassLoader();
            //TODO fix probable nullpointerexception from getfile()
            File prospects = new File(classLoader.getResource(prospectsFileName).getFile());
            Scanner scanner = new Scanner(prospects);
            scanner.useDelimiter(",");
            String line;

            while(!(line = scanner.nextLine()).equals("")) {
                int prospectIndex = 0;
                String[] prospect;
                // If the name is sorrounded by ""
                if (line.contains("\"")){
                    Pattern p = Pattern.compile(".*\"(.*)\"(.*)");
                    Matcher m = p.matcher(line);
                    // TODO fix the splitting
                    if (m.matches()) {
                        name = m.group(1);
                        prospect = name.split(",");
                        name = "";
                        for(String names : prospect)
                            name += names + " ";
                        //System.out.println("Name: " + name);
                        line = m.group(2);
                        //System.out.println("line: " + line);
                        prospectIndex++;
                    }
                }
                prospect = line.split(",");


                //TODO loop
                try {
                    if (prospectIndex == 0)
                        name = prospect[prospectIndex++];
                    totalLoan = Double.parseDouble(prospect[prospectIndex++]);
                    interest = 0.01 * Double.parseDouble(prospect[prospectIndex++]);
                    years = Integer.parseInt(prospect[prospectIndex]);

                    // Save to customer
                    Customer customer = new Customer(name, totalLoan, interest, years);
                    customerList.add(customer);

                } catch (NumberFormatException e) {
                    //TODO fix empty catch
                    //e.printStackTrace();
                }

            }
        } catch(FileNotFoundException e) {
            System.out.println("No prospects file found in: " + prospectsFileName);
            e.printStackTrace();
        }
    }
}
