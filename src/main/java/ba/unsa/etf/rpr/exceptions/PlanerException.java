package ba.unsa.etf.rpr.exceptions;

public class PlanerException extends Exception {

    public PlanerException(String msg, Exception reason){
        super(msg, reason);
    }

    public PlanerException(String msg){
        super(msg);
    }
}
