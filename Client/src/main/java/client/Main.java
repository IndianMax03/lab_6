package client;

import java.util.NoSuchElementException;

public class Main {
	public static void main(String[] args){
		try {
			Client client = new Client();
			Valiciever valiciever = new Valiciever();
			Invoker invoker = new Invoker(valiciever);
			Terminal terminal = new Terminal(invoker, client);
			terminal.startKeyboard();
		} catch (NoSuchElementException ex){
			System.exit(0);
		}
	}

}
