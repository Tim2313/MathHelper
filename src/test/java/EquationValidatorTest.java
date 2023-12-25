import org.example.model.Equation;
import org.example.service.EquationValidatorService;
import org.junit.Assert;
import org.junit.Test;

public class EquationValidatorTest {
    private static final String TEST_CASE_BRACKETS = "(10+2)+(11+2)+(12+x)+10(=10";
    private static final String TEST_CASE_DUPLICATIVE = "(10+2)+(11+2)+(12++x)+10(=10";
    private static final String TEST_CASE_INVALID_EXPRESSION = "(10+2)+(10+2)+(10+4)+(10+2)+(10+*10)(=100";
    private static final EquationValidatorService EQUATION_VALIDATOR_SERVICE = EquationValidatorService.getInstance();

    @Test
    public void shouldValidateBrackets() {

        Equation equation = new Equation();
        equation.setEquation(TEST_CASE_BRACKETS);

        boolean actual = EQUATION_VALIDATOR_SERVICE.getValidateByBrackets(equation);

        boolean expected = false;

        Assert.assertEquals(actual, expected);

    }

    @Test
    public void shouldValidateDuplication() {

        Equation equation = new Equation();
        equation.setEquation(TEST_CASE_DUPLICATIVE);

        boolean actual = EQUATION_VALIDATOR_SERVICE.getValidateByDublicates(equation);

        boolean expected = true;

        Assert.assertEquals(actual, expected);


    }

    @Test
    public void shouldValidateInvalidExpression() {

        Equation equation = new Equation();
        equation.setEquation(TEST_CASE_INVALID_EXPRESSION);

        boolean actual = EQUATION_VALIDATOR_SERVICE.getValidateExpression(equation);

        boolean expected = false;

        Assert.assertEquals(actual, expected);

    }

}
