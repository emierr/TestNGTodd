import org.testng.*;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(TestListener.class)
public class TestCalculator implements IRetryAnalyzer{

    int retryLimit = 3;
    int counter = 0;

    @Override
    public boolean retry(ITestResult iTestResult) {
        if (counter < retryLimit) {
            counter++;
            return true;
        } else {
            return false;
        }
    }

    @DataProvider
    public Object[][] dataAdd() {
        return new Object[][]
                {
                        {1, 5, 6},
                        {6, 2, 8},
                        {7, 1, 7},
                        {0, 2, 2},
                        {2, 0, 2}
                };

    }

    @DataProvider
    public Object[][] dataSubtract() {
        return new Object[][]
                {
                        {1, 5, -4},
                        {6, 2, 4},
                        {7, 1, 7},
                        {0, 2, -2},
                        {2, 0, 2}
                };

    }

    @Test(retryAnalyzer = TestCalculator.class, dataProvider = "dataAdd")
    public void testAdd(int a, int b, int expected) {
        int response = Calculator.add(a, b);
        Reporter.log("Adding numbers " + a + " and " + b, 1, true);
        Assert.assertEquals(expected, response);
    }

    @Test(retryAnalyzer = TestCalculator.class, dataProvider = "dataSubtract")
    public void testSubtract(int a, int b, int expected) {
        int response = Calculator.subtract(a, b);
        Reporter.log("Subtracting numbers " + a + " and " + b, 1, true);
        Assert.assertEquals(expected, response);
    }
}
