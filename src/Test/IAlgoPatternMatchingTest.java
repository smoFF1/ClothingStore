package Test;
import Algorithms.KMPAlgorithm;
import Algorithms.RabinKarpAlgorithm;
import  StrategyPattern.PatternMatchingContext;
import static org.junit.jupiter.api.Assertions.assertEquals;
public class IAlgoPatternMatchingTest
{
    public static void main(String[] args)
    {
        String text = "ABABABABACDABABCABAB";
        String pattern = "ABAB";

        PatternMatchingContext context = new PatternMatchingContext();
        context.setStrategy(new KMPAlgorithm());

        // Act
        int result = context.search(text, pattern);

        // Assert
        assertEquals(0, result, "KMP should find pattern at index 0");
        context.setStrategy(new RabinKarpAlgorithm());
         result = context.search(text, pattern);

        // Assert
        assertEquals(0, result, "Rabin-Karp should find pattern at index 0");



        pattern = "XYZ";
        context.setStrategy(new KMPAlgorithm());
        result = context.search(text, pattern);
        assertEquals(-1, result, "KMP should return -1 if pattern is not found");
        context.setStrategy(new RabinKarpAlgorithm());

        // Act
         result = context.search(text, pattern);

        // Assert
        assertEquals(-1, result, "Rabin-Karp should return -1 if pattern is not found");

    }
}
