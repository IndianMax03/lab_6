package commands;

import client.Valiciever;
import listening.Request;

public class AddIfMin implements Command{

	private final Valiciever valiciever;

	public AddIfMin(Valiciever valiciever){
		this.valiciever = valiciever;
	}

	@Override
	public Request check(String argument) {
		if (argument != null){
			System.out.println("Команда add_if_min не принимает аргументы.");
			return null;
		}
		return valiciever.addIfMin();
	}
}
