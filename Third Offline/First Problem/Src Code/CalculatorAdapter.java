import java.io.*;

public class CalculatorAdapter extends DecimalSumCalculator implements AsciiSumCalculator{
    private File asciiFile;
    private double sum ;

    CalculatorAdapter() throws IOException {
        asciiFile =  new File("/home/sadia/Desktop/CSE308/Third/FirstProblem/src/ascii.txt");
        asciiFile.createNewFile();
        sum=0;
    }

    public  File takeInputFile(File file){
        try{
            BufferedReader reader = new BufferedReader(new FileReader(file));
            FileWriter writer = new FileWriter(asciiFile);
            int x;
            while ((x=reader.read())!=-1){
                if(x==32) continue;
                writer.write(x+" ");
            }
            writer.close();
            reader.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found.");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return asciiFile;
    }

    @Override
    public void calculateSum(File file) throws FileNotFoundException {
        super.calculateSum(asciiFile);
    }
}
