import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Reader {

    /**
     * Reads a file and saves the data into the Customer list
     * @param prospectsFileName name of the file to be read
     */
    public void read(String prospectsFileName){
        String path;
        String line;
        String longName = "";
        String[] prospect;
        File prospects = null;

        try {
            path = getClass().getClassLoader().getResource(prospectsFileName).getFile();
            prospects = new File(path);

        } catch(NullPointerException e) {
            System.out.println("No prospects file found named: " + prospectsFileName);
        }

        try {
            Scanner scanner = new Scanner(prospects);
            scanner.useDelimiter(",");

            // Don't want to save the header, so just skip the first row
            scanner.nextLine();

            while(!(line = scanner.nextLine()).equals("")) {
                // If the name is sorrounded by ""
                if (line.contains("\"")) {
                    Pattern p = Pattern.compile(".*\"(.*)\"(.*)");
                    Matcher m = p.matcher(line);
                    if (m.matches()) {
                        longName = m.group(1).replace(",", " ");
                        line = m.group(2);
                    }
                }
                prospect = line.split(",");
                saver(prospect, longName);
                if (!(longName.equals(""))){
                    longName = "";
                }
            }

        } catch(FileNotFoundException e) {
            System.out.println("No prospects file found named: " + prospectsFileName);
        }
    }

    /**
     * Saves a prospect into the Customer list
     * @param prospect array of Customer,Total loan,Interest and Years, to be saved into Customer list
     * @param longName used if the prospect has a name like "Firstname,Lastname"
     */
    private void saver(String[] prospect, String longName) {
        String name;
        int index = 0;

        try {
            if (longName.isEmpty()) {
                name = prospect[index++];
            } else {
                name = longName;
                index++;
            }
            double totalLoan = Double.parseDouble(prospect[index++]);
            double interest = 0.01 * Double.parseDouble(prospect[index++]);
            int years = Integer.parseInt(prospect[index]);

            // Save to customer
            Customer customer = new Customer(name, totalLoan, interest, years);
            CustomerList.add(customer);

        } catch (NumberFormatException e) {
            System.out.println("Wrong format on prospects.txt. Needs to be like 'Customer,Total loan,Interest,Years' on each row.");
            e.printStackTrace();
        }

    }
}
