package commands;

import listening.Request;

public interface Command {

	Request check(String argument);


}
