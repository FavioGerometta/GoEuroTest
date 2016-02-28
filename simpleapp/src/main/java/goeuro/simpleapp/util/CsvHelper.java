package goeuro.simpleapp.util;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.supercsv.cellprocessor.ift.CellProcessor;
import org.supercsv.io.CsvBeanReader;
import org.supercsv.io.CsvBeanWriter;
import org.supercsv.io.ICsvBeanReader;
import org.supercsv.io.ICsvBeanWriter;
import org.supercsv.prefs.CsvPreference;

import goeuro.simpleapp.common.CsvWriterException;

public final class CsvHelper {

	/**
	 * Writes the specified content of the results in a Csv file
	 *
	 * @param csvFileName
	 *            the name of the csv
	 * @param list
	 *            the list to write in the csv
	 * @param csvFileName
	 *            name of the city
	 * @param header
	 *            the header for each column of the csv
	 * @param processors
	 *            the processor for each column of the csv
	 * 
	 */
	public static <T> void writeListToCSVFile(String csvFileName, List<T> list, String[] header,
			CellProcessor[] processors) throws CsvWriterException {
		ICsvBeanWriter beanWriter = null;

		try {
			beanWriter = new CsvBeanWriter(new FileWriter(csvFileName), CsvPreference.STANDARD_PREFERENCE);

			beanWriter.writeHeader(header);

			for (T item : list) {
				beanWriter.write(item, header, processors);
			}

		} catch (IOException ex) {
			throw new CsvWriterException("An error ocurred while writing the CSV file: ", ex);
		} finally {
			if (beanWriter != null) {
				try {
					beanWriter.close();
				} catch (IOException ex) {
					System.err.println("An error ocurred while closing the CSV writer: " + ex);
				}
			}
		}
	}

	/**
	 * Writes the specified content of the results in a Csv file
	 *
	 * @param csvFileName
	 *            the name of the csv
	 * @param type
	 *            the type that defines the list
	 * @param csvFileName
	 *            name of the city
	 * @param processors
	 *            the processor for each column of the csv
	 * 
	 * @return the list of the results being read
	 */
	public static <T> List<T> readWithCsvBeanReader(String csvFileName, Class<T> type, CellProcessor[] processors)
			throws FileNotFoundException, IOException {

		ICsvBeanReader beanReader = null;
		List<T> list = new ArrayList<>();
		try {
			beanReader = new CsvBeanReader(new FileReader(csvFileName), CsvPreference.STANDARD_PREFERENCE);
			final String[] header = beanReader.getHeader(true);
			T outputContainer;
			while ((outputContainer = (T) beanReader.read(type, header, processors)) != null) {
				list.add(outputContainer);
			}
		} finally {
			if (beanReader != null) {
				beanReader.close();
			}
		}
		return list;
	}
}
