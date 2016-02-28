package goeuro.simpleapp;

import static org.assertj.core.api.Assertions.*;
import org.junit.Test;

import goeuro.simpleapp.common.CsvWriterException;
import goeuro.simpleapp.common.InvalidCityNameException;
import goeuro.simpleapp.common.ThrowableCaptor;


/**
 * Unit test for simple App.
 */
public final class AppTest{

	@Test
	public void testAppHappyPath() throws InvalidCityNameException, CsvWriterException {
		App.main(new String[] { "Berlin" });
	}

	@Test
	public void testAppWithInvalidArguments() throws InvalidCityNameException, CsvWriterException {
		Throwable throwable = ThrowableCaptor.captureThrowable(() -> App.main(new String[] {}));
		assertThat(throwable).isNotNull().isInstanceOf(IllegalArgumentException.class);
		
		throwable = ThrowableCaptor.captureThrowable(() -> App.main(new String[] {"",""}));
		assertThat(throwable).isNotNull().isInstanceOf(IllegalArgumentException.class);
	}

}
