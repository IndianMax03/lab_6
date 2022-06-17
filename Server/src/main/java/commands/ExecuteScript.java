package commands;

import listening.Request;
import listening.Response;
import server.Receiver;

import java.io.*;
import java.util.ArrayList;

public class ExecuteScript implements Command {

	private final ArrayList<String> paths = new ArrayList<>();

	private final Receiver receiver;

	public ExecuteScript(Receiver receiver) {
		this.receiver = receiver;

	}

	@Override
	public Response execute(Request request) {
		Response response = new Response();
		response.setMessage("Данное приложение не поддерживает вызов команды execute_script из самой себя.");
		return response;
	}

	@Override
	public String getHelp() {
		return "Введите execute_script file_name, чтобы считать и исполнить скрипт из указанного файла.";
	}
}
