package goeuro.simpleapp.common;

public final class ThrowableCaptor {
	
    public static Throwable captureThrowable(ExceptionThrower exceptionThrower) {
        try {
            exceptionThrower.throwException();
            return null;
        } catch (Throwable caught) {
            return caught;
        }
    }
}