package commands;

import client.Valiciever;
import listening.Request;

public class Add implements Command{

	private final Valiciever valiciever;

	public Add(Valiciever valiciever){
		this.valiciever = valiciever;
	}


	@Override
	public Request check(String argument) {
		if (argument != null) {
			System.out.println("Команда add не принимает аргументы.");
			return null;
		}
		return valiciever.add();
	}
}
