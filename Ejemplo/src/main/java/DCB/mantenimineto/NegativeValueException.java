package DCB.mantenimineto;

public class NegativeValueException extends RuntimeException{
    public NegativeValueException(String errormessage) {
        super(errormessage);
    }
}
