package goeuro.simpleapp.common;

@FunctionalInterface
public interface ExceptionThrower {
	 void throwException() throws Throwable;
}
