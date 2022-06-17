package client;

import commands.*;
import commands.Command;
import listening.Request;

import java.util.HashMap;

public class Invoker {

	private final HashMap<String, Command> commandMap = new HashMap<>();

	public Invoker(Valiciever valiciever){

		commandMap.put("add", new Add(valiciever));
		commandMap.put("addIfMin", new AddIfMin(valiciever));
		commandMap.put("clear", new Clear());
		commandMap.put("execute_script", new ExecuteScript());
		commandMap.put("exit", new Exit());
		commandMap.put("filter_starts_with_name", new FilterStartsWithName());
		commandMap.put("help", new Help());
		commandMap.put("info", new Info());
		commandMap.put("print_descending", new PrintDescending());
		commandMap.put("remove_all_by_government", new RemoveAllByGovernment(valiciever));
		commandMap.put("remove_by_id", new RemoveById(valiciever));
		commandMap.put("remove_greater", new RemoveGreater(valiciever));
		commandMap.put("remove_lower", new RemoveLower(valiciever));
		commandMap.put("show", new Show());
		commandMap.put("update_id", new UpdateId(valiciever));
	}

	public Request check(String commandName, String argument){
		if (this.commandMap.containsKey(commandName))
			return this.commandMap.get(commandName).check(argument);
		System.out.println("Введённой команды не существует. Повторите ввод.");
		return null;
	}
}
