import org.example.model.Equation;
import org.example.service.CounterService;
import org.junit.Assert;
import org.junit.Test;

public class CounterServiceTest {

    private static final String TEST_CASE = "3+3+3+(3+x)+10+100=6";
    private static final CounterService COUNTER_SERVICE = CounterService.getInstance();

    @Test
    public void shouldCount(){

        Equation equation = new Equation();

        equation.setEquation(TEST_CASE);

        int actualNumberOfNumbers = COUNTER_SERVICE.getNumbers(equation);

        int expectedNumberOfNumbers = 10;

        Assert.assertEquals(actualNumberOfNumbers, expectedNumberOfNumbers);

    }
}
