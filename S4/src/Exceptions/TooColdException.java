package Exceptions;

public class TooColdException extends exceptions.TemperatureException {
    public TooColdException(int temperature) {
        super(temperature);
    }
}
