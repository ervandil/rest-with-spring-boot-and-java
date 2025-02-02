package br.com.ervandil.controllers;

import java.util.concurrent.atomic.AtomicLong;

import br.com.ervandil.exceptions.UnsupportedMathOperationException;
import br.com.ervandil.math.SimpleMath;
import br.com.ervandil.utils.MathUtil;
import org.springframework.web.bind.annotation.*;

@RestController
public class MathController {

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();
    private final SimpleMath simpleMath = new SimpleMath();

    @RequestMapping(value = "/sum/{numberOne}/{numberTwo}", method = RequestMethod.GET)
    public Double sum(@PathVariable(value = "numberOne") String numberOne, @PathVariable(value = "numberTwo") String numberTwo) throws Exception {
        return simpleMath.performOperation(numberOne, numberTwo, (Double::sum));
    }

    @RequestMapping(value = "/subtraction/{numberOne}/{numberTwo}", method = RequestMethod.GET)
    public Double subtraction(@PathVariable(value = "numberOne") String numberOne, @PathVariable(value = "numberTwo") String numberTwo) throws Exception {
        return simpleMath.performOperation(numberOne, numberTwo, ((a, b) -> a - b));
    }

    @RequestMapping(value = "/multiplication/{numberOne}/{numberTwo}", method = RequestMethod.GET)
    public Double multiplication(@PathVariable(value = "numberOne") String numberOne, @PathVariable(value = "numberTwo") String numberTwo) throws Exception {
        return simpleMath.performOperation(numberOne, numberTwo, ((a, b) -> a * b));
    }

    @RequestMapping(value = "/division/{numberOne}/{numberTwo}", method = RequestMethod.GET)
    public Double division(@PathVariable(value = "numberOne") String numberOne, @PathVariable(value = "numberTwo") String numberTwo) throws Exception {
        return simpleMath.performOperation(numberOne, numberTwo, ((a, b) -> a / b));
    }

    @RequestMapping(value = "/average/{numberOne}/{numberTwo}", method = RequestMethod.GET)
    public Double average(@PathVariable(value = "numberOne") String numberOne, @PathVariable(value = "numberTwo") String numberTwo) throws Exception {
        return simpleMath.performOperation(numberOne, numberTwo, ((a, b) -> (a + b) / 2));
    }

    @RequestMapping(value = "/squareRoot/{numberOne}", method = RequestMethod.GET)
    public Double squareRoot(@PathVariable(value = "numberOne") String numberOne) throws Exception {
        if (!MathUtil.isNumeric(numberOne)) {
            throw new UnsupportedMathOperationException("Please set a numeric value");
        }
        return Math.sqrt(MathUtil.convertToDouble(numberOne));
    }

}
