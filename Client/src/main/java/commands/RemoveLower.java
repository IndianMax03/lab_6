package commands;

import client.Valiciever;
import listening.Request;

public class RemoveLower implements Command {

	private final Valiciever valiciever;

	public RemoveLower(Valiciever valiciever){
		this.valiciever = valiciever;
	}


	@Override
	public Request check(String argument) {
		if (argument != null){
			System.out.println("Команда remove_lower не принимает аргумент.");
			return null;
		}
		return valiciever.removeLower();
	}
}
