package fileworker;

import base.City;
import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;
import input.Creator;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.TreeSet;

import static java.lang.System.getenv;

public class WorkWithFile {

	public static void fillTheCollection(TreeSet<City> collection) throws IOException, CsvValidationException {

		try (CSVReader reader = new CSVReader(new FileReader( getenv("path")))) {
			String[] components;
			long i = 1;
			while ((components = reader.readNext()) != null) {
				City city = Creator.createByArray(components, i++);
				if (city == null || !collection.add(city)){
					System.out.println("Ошибка добавления города из строки " + i + ": Город уже существует или неверно " +
							"заданы поля.");
				}
				collection.add(city);
			}
		} catch (NullPointerException ex){
			System.out.println("Для запуска серверного приложения необходимо инициализировать переменную окружения path со входной коллекцией");
			System.exit(-1);
		}

	}

	public String writeInFile(TreeSet<City> collection){

		try (BufferedOutputStream out = new BufferedOutputStream(new FileOutputStream(System.getenv("path")))) {
			for (City city : collection){
				byte[] s = city.cityToString().getBytes(StandardCharsets.UTF_8);
				out.write(s);
				out.write("\n".getBytes(StandardCharsets.UTF_8));
			}
			return "текущая коллекция записана в файл.";
		} catch (IOException e){
			return "попытка записать коллекцию в файл не увенчалась успехом. Недостаточно прав.";
		}

	}

}
