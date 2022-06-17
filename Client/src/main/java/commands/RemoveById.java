package commands;

import client.Valiciever;
import listening.Request;

public class RemoveById implements Command {

	private final Valiciever valiciever;

	public RemoveById(Valiciever valiciever){
		this.valiciever = valiciever;
	}


	@Override
	public Request check(String argument) {
		if (argument == null){
			System.out.println("Команда remove_by_id требует аргумент id.");
			return null;
		}
		return valiciever.removeById(argument);
	}
}
