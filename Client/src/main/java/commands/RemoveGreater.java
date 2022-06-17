package commands;

import client.Valiciever;
import listening.Request;

public class RemoveGreater implements Command {

	private final Valiciever valiciever;

	public RemoveGreater(Valiciever valiciever){
		this.valiciever = valiciever;
	}


	@Override
	public Request check(String argument) {

		if (argument != null){
			System.out.println("Команда remove_greater не принимает аргумент.");
			return null;
		}
		return valiciever.removeGreater();
	}
}
