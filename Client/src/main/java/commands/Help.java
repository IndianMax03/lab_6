package commands;

import listening.Request;

public class Help implements Command {


	@Override
	public Request check(String argument) {
		if (argument != null){
			System.out.println("Команда help не принимает аргументы.");
			return null;
		}
		return new Request("help", null);
	}
}
