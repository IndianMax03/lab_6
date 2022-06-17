package client;

import base.City;
import base.Government;
import input.Creator;
import listening.Request;

//  Реализация проверок
public class Valiciever {

	public Request add(){
		City city = Creator.createCity();
		return new Request("add", null, city);
	}

	public Request addIfMin(){
		City city = Creator.createCity();
		return new Request("add_if_min", null, city);
	}

	public Request removeGreater(){
		City city = Creator.createCity();
		return new Request("remove_greater", null, city);
	}

	public Request removeLower(){
		City city = Creator.createCity();
		return new Request("remove_lower", null, city);
	}

	public Request removeById(String argument){
		try{
			long id = Long.parseLong(argument);
		} catch (NumberFormatException e) {
			System.out.println("Аргумент id должен быть типа long.");
			return null;
		}
		return new Request("remove_by_id", argument);
	}

	public Request removeAllByGovernment(String argument){
		for (Government government : Government.values()){
			if (government.toString().equals(argument)){
				return new Request("remove_all_by_government", argument);
			}
		}
		System.out.println("Передан неверный аргумент government.");
		return null;
	}

	public Request updateId(String argument){
		try{
			long id = Long.parseLong(argument);
		} catch (NumberFormatException e) {
			System.out.println("Аргумент id должен быть типа long");
			return null;
		}
		System.out.println("Создайте город, который заменит город с выбранным вами значением поля id:");
		City city = Creator.createCity();
		return new Request("update_id", argument, city);
	}
}
