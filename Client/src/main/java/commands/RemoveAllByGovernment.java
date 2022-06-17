package commands;

import base.Government;
import client.Valiciever;
import listening.Request;

public class RemoveAllByGovernment implements Command {

	private final Valiciever valiciever;

	public RemoveAllByGovernment(Valiciever valiciever){
		this.valiciever = valiciever;
	}

	@Override
	public Request check(String argument) {
		if (argument == null){
			System.out.println("Команда remove_all_by_government принимает аргумент government.");
			System.out.println("Напишите один из представленнных ниже:");
			int i = 1;
			for (Government government : Government.values()){
				System.out.println(i++ + ") " + government);
			}
			return null;
		}
		return valiciever.removeAllByGovernment(argument);
	}
}
