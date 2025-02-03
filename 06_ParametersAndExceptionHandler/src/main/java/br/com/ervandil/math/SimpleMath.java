package br.com.ervandil.math;

import br.com.ervandil.exceptions.UnsupportedMathOperationException;
import br.com.ervandil.utils.MathUtil;

public class SimpleMath {
    public Double performOperation(String numberOne, String numberTwo, MathOperation operation) {
        if (!MathUtil.isNumeric(numberOne) || !MathUtil.isNumeric(numberTwo)) {
            throw new UnsupportedMathOperationException("Please set a numeric value");
        }
        return operation.apply(MathUtil.convertToDouble(numberOne), MathUtil.convertToDouble(numberTwo));
    }

    @FunctionalInterface
    public interface MathOperation {
        Double apply(Double a, Double b);
    }
}
