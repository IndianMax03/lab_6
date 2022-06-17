package client;
public class Main {
	public static void main(String[] args){
		Client client = new Client();
		Valiciever valiciever = new Valiciever();
		Invoker invoker = new Invoker(valiciever);
		Terminal terminal = new Terminal(invoker, client);
		terminal.startKeyboard();
	}

}
