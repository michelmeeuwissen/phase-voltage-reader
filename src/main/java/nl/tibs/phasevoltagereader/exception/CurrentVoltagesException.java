package nl.tibs.phasevoltagereader.exception;

public class CurrentVoltagesException extends RuntimeException {

    public CurrentVoltagesException(String message, Exception e) {
        super(message, e);
    }

    public CurrentVoltagesException(Exception e) {
        super(e);
    }
}
