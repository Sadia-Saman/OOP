import java.io.File;
import java.io.FileNotFoundException;

public interface AsciiSumCalculator {
    void calculateSum(File file) throws FileNotFoundException;
    File takeInputFile(File file);
}
