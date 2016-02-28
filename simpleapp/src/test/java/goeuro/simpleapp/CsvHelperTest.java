package goeuro.simpleapp;

import static org.assertj.core.api.Assertions.assertThat;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import org.junit.Test;
import org.supercsv.cellprocessor.constraint.NotNull;
import org.supercsv.cellprocessor.ift.CellProcessor;
import org.supercsv.exception.SuperCsvException;

import goeuro.simpleapp.client.Controller;
import goeuro.simpleapp.common.ThrowableCaptor;
import goeuro.simpleapp.model.dto.LocationDto;
import goeuro.simpleapp.util.CsvHelper;

public final class CsvHelperTest {

	private static final String TEST_RESOURCES_PATH = "src/test/resources/";
	private static final String READ_SAMPLE_FILENAME = TEST_RESOURCES_PATH + "sample_read.csv";
	private static final String WRITE_SAMPLE_FILENAME = TEST_RESOURCES_PATH + "sample_write.csv";

	@Test
	public void testReadLocationsWithInvalidFile() throws Exception {
		final Throwable throwable = ThrowableCaptor.captureThrowable(
				() -> CsvHelper.readWithCsvBeanReader("nonExistantFile.csv", LocationDto.class, Controller.PROCESSORS));
		assertThat(throwable).isNotNull().isInstanceOf(FileNotFoundException.class);
	}

	@Test
	public void testReadCsvHappyPath() throws Exception {
		final List<LocationDto> locationsDto = CsvHelper.readWithCsvBeanReader(READ_SAMPLE_FILENAME, LocationDto.class,
				Controller.PROCESSORS);

		assertThat(locationsDto).isNotNull().hasSize(2);

		assertThat(locationsDto).extracting("id").contains("1", "2");

		assertThat(locationsDto).extracting("name").contains("Anywhere", "Rosario");

		assertThat(locationsDto).extracting("type").contains("SomeType", "location");

		assertThat(locationsDto).extracting("latitude").contains("40.2312", "32.2312");

		assertThat(locationsDto).extracting("longitude").contains("-15.456", "33.456");
	}

	@Test
	public void testWriteCsvWithInvalidHeaders() throws Exception {
		final Throwable throwable = ThrowableCaptor
				.captureThrowable(() -> CsvHelper.writeListToCSVFile(WRITE_SAMPLE_FILENAME, getLocationsDtoMockedList(),
						new String[]{}, Controller.PROCESSORS));
		assertThat(throwable).isNotNull().isInstanceOf(IllegalArgumentException.class);
	}
	
	@Test
	public void testWriteCsvWithInvalidProcessors() throws Exception {
		final Throwable throwable = ThrowableCaptor
				.captureThrowable(() -> CsvHelper.writeListToCSVFile(WRITE_SAMPLE_FILENAME, getLocationsDtoMockedList(),
						Controller.HEADERS,  new CellProcessor[] { new NotNull()}));
		assertThat(throwable).isNotNull().isInstanceOf(SuperCsvException.class);
	}

	@Test
	public void testWriteCsvHappyPath() throws Exception {
		CsvHelper.writeListToCSVFile(WRITE_SAMPLE_FILENAME, getLocationsDtoMockedList(), Controller.HEADERS,
				Controller.PROCESSORS);
	}

	private List<LocationDto> getLocationsDtoMockedList() throws FileNotFoundException, IOException {
		return CsvHelper.readWithCsvBeanReader(READ_SAMPLE_FILENAME, LocationDto.class, Controller.PROCESSORS);
	}

}
