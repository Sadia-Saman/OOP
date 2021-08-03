import java.io.*;

public class DecimalSumCalculator {
    void calculateSum(File file) throws FileNotFoundException {
        BufferedReader reader = new BufferedReader(new FileReader(file));
        String line;
        String []words;
        double sum=0;
        while (true) {
            try {
                if ((line = reader.readLine()) == null) break;
                words = line.split(" ");
                for(String str :words)
                    sum+=Integer.parseInt(str);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Sum of all integers in the file is "+sum +".");
    }
}
