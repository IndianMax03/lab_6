package server;

import commands.*;
import listening.Request;
import listening.Response;

import java.util.HashMap;

public class Invoker {

	private static Invoker invoker;

	private final HashMap<String, Command> commandMap = new HashMap<>();

	public void register(String commandName, Command command){
		commandMap.put(commandName, command);
	}

	public Invoker(Receiver receiver){

		commandMap.put("save", new Save(receiver));
		commandMap.put("add", new Add(receiver));
		commandMap.put("addIfMin", new AddIfMin(receiver));
		commandMap.put("clear", new Clear(receiver));
		commandMap.put("execute_script", new ExecuteScript(receiver));
		commandMap.put("filter_starts_with_name", new FilterStartsWithName(receiver));
		commandMap.put("help", new Help(receiver, commandMap));
		commandMap.put("info", new Info(receiver));
		commandMap.put("print_descending", new PrintDescending(receiver));
		commandMap.put("remove_all_by_government", new RemoveAllByGovernment(receiver));
		commandMap.put("remove_by_id", new RemoveById(receiver));
		commandMap.put("remove_greater", new RemoveGreater(receiver));
		commandMap.put("remove_lower", new RemoveLower(receiver));
		commandMap.put("show", new Show(receiver));
		commandMap.put("update_id", new UpdateId(receiver));
		commandMap.put("exit", new Exit());

	}

	public Response execute(Request request){
		String commandName = request.getCommandName();
		return this.commandMap.get(commandName).execute(request);
	}

	public HashMap<String, Command> getCommandMap(){
		return this.commandMap;
	}

	public static Invoker getInstance(Receiver receiver){
		if (invoker == null){
			invoker = new Invoker(receiver);
		}
		return invoker;
	}

}
