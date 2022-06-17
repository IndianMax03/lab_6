package commands;

import client.Valiciever;
import listening.Request;

public class UpdateId implements Command {

	private final Valiciever valiciever;

	public UpdateId(Valiciever valiciever){
		this.valiciever = valiciever;
	}

	@Override
	public Request check(String argument) {
		if (argument == null){
			System.out.println("Команда update_id требует аргумент id.");
			return null;
		}
		return valiciever.updateId(argument);
	}
}
