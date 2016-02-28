package goeuro.simpleapp;

import static org.assertj.core.api.Assertions.*;
import org.junit.Test;

import goeuro.simpleapp.common.InvalidCityNameException;
import goeuro.simpleapp.common.ThrowableCaptor;
import goeuro.simpleapp.util.ValidationUtils;
import junit.framework.TestCase;
import junit.framework.TestSuite;

public final class ValidationUtilsTest  extends TestCase {
	
	public ValidationUtilsTest(String testName) {
		super(testName);
	}

	public static TestSuite suite() {
		return new TestSuite(ValidationUtilsTest.class);
	}
	
	@Test
	public void testValidateInvalidCityName() {
		final Throwable throwable = ThrowableCaptor.captureThrowable(() ->ValidationUtils.validateCityName(""));
		assertThat(throwable).isNotNull().isInstanceOf(InvalidCityNameException.class)
				.hasMessage(InvalidCityNameException.ERR_MSG);
	}
	
	@Test
	public void testValidateNullCityName() {
		final Throwable throwable = ThrowableCaptor.captureThrowable(() ->ValidationUtils.validateCityName(null));
		assertThat(throwable).isNotNull().isInstanceOf(InvalidCityNameException.class)
				.hasMessage(InvalidCityNameException.ERR_MSG);
	}

	
	

}
