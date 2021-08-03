import java.io.File;
import java.io.IOException;

public class SumCalculatorMain {
    public static void main(String []args) throws IOException {
        AsciiSumCalculator asciiSum = new CalculatorAdapter();
        File file1 = new File("/home/sadia/Desktop/CSE308/Third/FirstProblem/src/input.txt");
        File file = asciiSum.takeInputFile(file1);
        if(file!=null)
            asciiSum.calculateSum(file);
    }
}
