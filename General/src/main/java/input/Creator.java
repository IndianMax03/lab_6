package input;

import base.*;

import java.time.ZonedDateTime;

public class Creator {

	public static City createCity(){
		Typer typer = new Typer();

		String name = typer.nameInput();

		Coordinates coordinates = typer.coordinatesInput();

		float area = typer.areaInput();

		int population = typer.populationInput();

		float masl = typer.metersAboveSeaLevelInput();

		Climate climate = typer.climateInput();

		Government government = typer.governmentInput();

		StandardOfLiving standardOfLiving = typer.standardOfLivingInput();

		Human governor = typer.leaderInput();

		return new City(null, name, coordinates, null, area, population, masl, climate, government, standardOfLiving,
				governor);
	}

	public static City createByArray(String [] line, long i){

		if (line.length != 11){
			return null;
		}

		Validator validator = new Validator();
		Long id = validator.checkIdValid(line[0]);
		String name = validator.checkNameValid(line[1]);
		Coordinates coordinates = validator.checkCoordinatesValid(line[2]);
		ZonedDateTime creationDate = validator.checkDataValid(line[3]);
		Float area = validator.checkAreaValid(line[4]);
		Integer population = validator.checkPopulationValid(line[5]);
		Float metersAboveSeaLevel = validator.checkMetersAboveSeaLevelValid(line[6]);
		Climate climate = validator.checkClimateByNameValid(line[7]);
		Government government = validator.checkGovernmentByNameValid(line[8]);
		StandardOfLiving standardOfLiving = validator.checkStandartOfLivingByNameValid(line[9]);
		Human governor = validator.checkLeadersByNameValid(line[10]);

		if (id == null || name == null || coordinates == null || creationDate == null || area == null || population == null
			|| metersAboveSeaLevel == null || climate == null || government == null || standardOfLiving == null || governor == null)
			return null;

		return new City(id, name, coordinates, creationDate, area, population, metersAboveSeaLevel, climate, government, standardOfLiving,
				governor);

	}

}
