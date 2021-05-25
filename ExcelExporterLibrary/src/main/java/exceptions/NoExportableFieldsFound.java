package exceptions;

public class NoExportableFieldsFound extends Exception {
    public NoExportableFieldsFound(String errorMessage) {
        super(errorMessage);
    }
}
