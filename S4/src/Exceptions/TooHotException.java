package Exceptions;

public class TooHotException extends exceptions.TemperatureException {
    public TooHotException(int temperature) {
        super(temperature);
    }
}
