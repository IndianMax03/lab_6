package commands;

import listening.Request;

public class FilterStartsWithName implements Command{

	@Override
	public Request check(String argument) {
		if (argument == null){
			System.out.println("Команда filter_starts_with_name принимает требует аргумент name.");
			return null;
		}
		return new Request("filter_starts_with_name", argument);
	}
}
