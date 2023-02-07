package DCB.mantenimineto;

/**
 * Class providing a method to compute the factorial of an integer number
 */
public class Factorial {
    public int compute(int value) {
        int result = 0;

        if(value < 0){
            throw new NegativeValueException("The value" + value + "is negative");
        }else if((value == 0)){
            result = 1;
        }else{
            return value * compute(value-1);
        }
        return result;
    }
    void f(){

    }
}

