package server;

import com.opencsv.exceptions.CsvValidationException;
import fileworker.WorkWithFile;
import listening.Request;
import listening.Response;

import java.io.IOException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class Main {
	private static final Receiver receiver = new Receiver();
	private static final Invoker invoker = new Invoker(receiver);
	public static void main(String[] args) throws IOException {
		Server server = new Server();
		try {
			WorkWithFile.fillTheCollection(receiver.getCollection());
		} catch (CsvValidationException e) {
			System.out.println("Ошибка валидации csv файла со входной коллекцией.");
		}

		try {
			while (true) {

				if (System.in.available() > 0) {
					String servcomment;
					try {
						servcomment = (new Scanner(System.in)).nextLine();
					} catch (NullPointerException e) {
						return;
					}
					if (servcomment.equals("save")) {
						Request request = new Request("save", null);
						invoker.getCommandMap().get("save").execute(request);
						System.out.println("Коллекция записана в файл.");
					} else if (servcomment.equals("exit")) {
						System.out.println("Сервер завершает свою работу.");
						System.exit(0);
					} else {
						System.out.println("Сервер поддерживает только две команды: save и exit.");
					}
				}

				Request request = server.recieve();
				if (request == null) {
					continue;
				}
				Response response = invoker.execute(request);
				server.send(response, request.getClientAdress());
			}
		} catch (NoSuchElementException ex){
			System.exit(0);
		}
	}
}
