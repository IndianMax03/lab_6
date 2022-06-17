package client;

import listening.Request;
import listening.Response;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Terminal {


	Scanner scanner;
	private final Invoker invoker;
	private final Client client;
	private String out;

	public Terminal(Invoker invoker, Client client) {
		this.invoker = invoker;
		this.client = client;
	}

	protected void startFile(String filename){

		String pathToFile = new File(filename).getAbsolutePath();
		File file = new File(pathToFile);
		try {
			this.scanner = new Scanner(file);
		} catch (FileNotFoundException e) {
			System.out.println("Файл не найден.");
			return;
		}

		while (scanner.hasNext()){
			String line = scanner.nextLine();
			Request request = lineHandler(line);
			if (request == null) {
				System.out.println("В файле найдена некорректная команда. Выполнение прекращено.");
				break;
			}
			client.send(request);
			Response response = client.recieve();
			if (response == null){
				System.exit(-1);
			}
			if (response.getMessage() == null) {
				if (response.getAnswer() == null)
					System.out.println("Не удалось получить ответ от сервера.");
				else {
					for (String ans : response.getAnswer())
						System.out.println(ans);
				}
			} else {
				if (response.getAnswer() == null) {
					System.out.println(response.getMessage());
				} else {
					System.out.println(response.getMessage());
					for (String ans : response.getAnswer())
						System.out.println(ans);
				}
			}
		}
		startKeyboard();
	}

	protected void startKeyboard(){

		this.scanner = new Scanner(System.in);

		while (true) {

			System.out.print("Введите команду:\n>");
			String line = scanner.nextLine();

			Request request = lineHandler(line);

			if (request == null)
				continue;

			if (request.getCommandName().equals("execute_script")) {
				startFile(request.getArgument());
			}

			client.send(request);
			Response response = client.recieve();

			if (response == null){
				System.out.println("Потеряна связь с сервером.");
				System.exit(-1);
			}

			if (response.getMessage() == null) {
				if (response.getAnswer() == null)
					System.out.println("Не удалось получить ответ от сервера.");
				else {
					for (String ans : response.getAnswer())
						System.out.println(ans);
				}
			} else {
				if (response.getAnswer() == null) {
					System.out.println(response.getMessage());
				} else {
					System.out.println(response.getMessage());
					for (String ans : response.getAnswer())
						System.out.println(ans);
				}
			}
		}
	}


	protected Request lineHandler(String line) throws NullPointerException {

		while (line.contains("  ")){
			line = line.replace("  ", " ");
		}
		String[] commandLine = line.split(" ");
		String command = commandLine[0].trim();
		Request request = null;
		if (commandLine.length == 1) {
			return invoker.check(command, null);
		}
		if (commandLine.length == 2) {
			return invoker.check(command, commandLine[1]);
		}
		return request;
	}
}
