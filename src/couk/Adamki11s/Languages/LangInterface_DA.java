package couk.Adamki11s.Languages;

public class LangInterface_DA {
	
	public String getString(String s){
		return parseString(s);
	}

	private String parseString(String s){
		if(s.equalsIgnoreCase("Hello")){
			return "Hej";
		}
		if(s.equalsIgnoreCase("[Warzone] By Adamki11s of the MineDev team.")){
			return "[Warzone] Lavet af Adamki11s fra the MineDev team.";
		}
		if(s.equalsIgnoreCase("version")){
			return "version";
		}
		if(s.equalsIgnoreCase("enabled successfully")){
			return "slået til";
		}
		if(s.equalsIgnoreCase("Warzone disabled successfully")){
			return "Succesfuldt deaktiverede krigszone";
		}
		if(s.equalsIgnoreCase("Statistics reset for player : ")){
			return "Statistikkerne er blevet reset for spiller : ";
		}
		if(s.equalsIgnoreCase("This player does not exist in the warzone database!")){
			return "Denne spiller findes ikke i krigzone databasen!";
		}
		if(s.equalsIgnoreCase("You must provide the block id!")){
			return "Du skal give et block id!";
		}
		if(s.equalsIgnoreCase("You do not have permission to disable Warzone!")){
			return "Du har ikke adgang til at deaktivere Krigszonen!";
		}
		if(s.equalsIgnoreCase("Search cancelled successfully.")){
			return "Søgning annulleret.";
		}
		if(s.equalsIgnoreCase("You are not searching for a game!")){
			return "Du leder ikke efter et spil!";
		}
		if(s.equalsIgnoreCase("Returned to previous location.")){
			return "Retunerede til sidste punkt.";
		}
		if(s.equalsIgnoreCase("No return location exists!")){
			return "Intet punkt at retunere til!";
		}
		if(s.equalsIgnoreCase("has no statistics to display.")){
			return "har ingen statistikker at fremvise.";
		}
		if(s.equalsIgnoreCase("You have no statistics to display!")){
			return "Du har ingen statistikker at fremvise!";
		}
		if(s.equalsIgnoreCase("You do not have permissions to do this!")){
			return "Du har ikke adgang til at gøre dette!";
		}
		if(s.equalsIgnoreCase("Invalid Sword Type")){
			return "Forkert sværd type";
		}
		if(s.equalsIgnoreCase("You must be level")){
			return "Du skal være level";
		}
		if(s.equalsIgnoreCase("or above to do this")){
			return "eller højere for at gøre dette";
		}
		if(s.equalsIgnoreCase("Sword preference changed to")){
			return "Sværd preferencer ændret til";
		}
		if(s.equalsIgnoreCase("Invalid Material Type!")){
			return "Forkert Materiale type";
		}
		if(s.equalsIgnoreCase("Armour type changed to")){
			return "Rustning type er blevet ændret til";
		}
		if(s.equalsIgnoreCase("sucessfully!")){
			return "lykkedes!";
		}
		if(s.equalsIgnoreCase("to wield this armour!")){
			return "for at bære rustning!";
		}
		if(s.equalsIgnoreCase("Error : Armour type can only be")){
			return "Fejl : Rustning kan kun være";
		}
		if(s.equalsIgnoreCase("Chill in the lobby while we find a match for you.")){
			return "Slap af i lobbien imens vi finder et map til dig.";
		}
		if(s.equalsIgnoreCase("Searching for players...")){
			return "Leder efter spillere...";
		}
		if(s.equalsIgnoreCase("You are already searching!")){
			return "Du søger allerede!";
		}
		if(s.equalsIgnoreCase("Do &e/warzone stop search &redto cancel")){
			return "Skriv &e/warzone stop search &redfor at annuller";
		}
		if(s.equalsIgnoreCase("No players found, request timed out.")){
			return "Ingen spillere fundet, forspørgelse timed out.";
		}
		if(s.equalsIgnoreCase("Timeout in")){
			return "Timeout om";
		}
		if(s.equalsIgnoreCase("match found with")){
			return "spil funder med";
		}
		if(s.equalsIgnoreCase("Selecting random map...")){
			return "Vælger et tilfældigt map...";
		}
		if(s.equalsIgnoreCase("All maps are occupied! Please wait.")){
			return "Alle maps er optaget! Vent venligst.";
		}
		if(s.equalsIgnoreCase("Map Chosen")){
			return "Map valgt";
		}
		if(s.equalsIgnoreCase("Loading map...")){
			return "Loading map...";
		}
		if(s.equalsIgnoreCase("Map Loaded")){
			return "Map Loaded";
		}
		if(s.equalsIgnoreCase("Let battle commence!")){
			return "Lad kampen begynde!";
		}
		if(s.equalsIgnoreCase("The warzone world is not editable!")){
			return "Krigszone verdenen kan ikke blive redigeret!";
		}
		if(s.equalsIgnoreCase("You quit unexpectedly!")){
			return "Du lavede en uforudsigeligt afslutning!";
		}
		if(s.equalsIgnoreCase("Inventory was restored successfully.")){
			return "Dit inventory er blevet gendannet.";
		}
		if(s.equalsIgnoreCase("You quit during a game! Returned to initial location.")){
			return "Du afsluttede spillet imens kampen var igang! Du er blevet taget tilbage til det oprindelige spawn area.";
		}
		if(s.equalsIgnoreCase("Time Left")){//Shows on sign. make sure message is not too long
			return "Tid tilbage";
		}
		if(s.equalsIgnoreCase("You struckdown")){
			return "Du dræbte";
		}
		if(s.equalsIgnoreCase("You got struckdown by")){
			return "Du blev slået ned af";
		}
		if(s.equalsIgnoreCase("You shot")){
			return "Du skød";
		}
		if(s.equalsIgnoreCase("You got shot by")){
			return "Du blev skudt af";
		}
		if(s.equalsIgnoreCase("Quit the game!")){
			return "Forlod spillet!";
		}
		if(s.equalsIgnoreCase("remaining.")){
			return "tilbage.";
		}
		if(s.equalsIgnoreCase("The match was a draw!")){
			return "Kampen var uafgjort";
		}
		if(s.equalsIgnoreCase("You gained")){
			return "Du fik";
		}
		if(s.equalsIgnoreCase("Game over!")){
			return "Spillet er Slut";
		}
		if(s.equalsIgnoreCase("was victorious!")){
			return "har vundet!";
		}
		if(s.equalsIgnoreCase("won with")){
			return "vundet med";
		}
		if(s.equalsIgnoreCase("kills.")){
			return "dræbte.";
		}
		return "";
	}

}
