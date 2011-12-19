package couk.Adamki11s.Languages;

public class LangInterface_FR {
	
	public String getString(String s){
		return parseString(s);
	}
	
	private String parseString(String s){
		if(s.equalsIgnoreCase("Hello")){//Leave the english.
			return "Bonjour"; //Change all return strings into french.
		}
		if(s.equalsIgnoreCase("[Warzone] By Adamki11s of the MineDev team.")){
			return "[Warzone] Par Adamki11s fr de l equipe MineDev.";
		}
		if(s.equalsIgnoreCase("version")){
			return "version";
		}
		if(s.equalsIgnoreCase("enabled successfully")){
			return "Champ de bataille active";
		}
		if(s.equalsIgnoreCase("Warzone disabled succesfully")){
			return "Champ de bataille desactive";
		}
		if(s.equalsIgnoreCase("Statistics reset for player : ")){
			return "Reinitialisation des statistiques du joueur : ";
		}
		if(s.equalsIgnoreCase("This player does not exist in the warzone database!")){
			return "Ce joueur n est pas dans la base de donnee du champ de bataille!";
		}
		if(s.equalsIgnoreCase("You must provide the block id!")){
			return "Vous devez specifier l id du bloc!";
		}
		if(s.equalsIgnoreCase("You do not have permission to disable Warzone!")){
			return "Vous n avez pas le droit de desactiver le champ de bataille!";
		}
		if(s.equalsIgnoreCase("Search cancelled successfully.")){
			return "La recherche a ete interrompue.";
		}
		if(s.equalsIgnoreCase("You are not searching for a game!")){
			return "Vous n etes pas en train de chercher une partie!";
		}
		if(s.equalsIgnoreCase("Returned to previous location.")){
			return "Retour a l ancienne localisation.";
		}
		if(s.equalsIgnoreCase("No return location exists!")){
			return "Aucune localisation de retour n existe!";
		}
		if(s.equalsIgnoreCase("has no statistics to display.")){
			return "n a pas de statistique a afficher.";
		}
		if(s.equalsIgnoreCase("You have no statistics to display!")){
			return "Vous n avez aucune statistique a afficher!";
		}
		if(s.equalsIgnoreCase("You do not have permissions to do this!")){
			return "Vous n avez pas le droit de faire ca!";
		}
		if(s.equalsIgnoreCase("Invalid Sword Type")){
			return "Type d epee incorrect";
		}
		if(s.equalsIgnoreCase("You must be level")){
			return "Vous devvez etre au niveau";
		}
		if(s.equalsIgnoreCase("or above to do this")){
			return "ou plus pour faire ca";
		}
		if(s.equalsIgnoreCase("Sword preference changed to")){
			return "La preference d epee a ete changee en";
		}
		if(s.equalsIgnoreCase("Invalid Material Type!")){
			return "Type de materiel incorrect!";
		}
		if(s.equalsIgnoreCase("Armour type changed to")){
			return "Type d armure change en";
		}
		if(s.equalsIgnoreCase("sucessfully!")){
			return "avec succes!";
		}
		if(s.equalsIgnoreCase("to wield this armour!")){
			return "pour porter cette amure!";
		}
		if(s.equalsIgnoreCase("Error : Armour type can only be")){
			return "Erreur : le type d armure peut seulement etre";
		}
		if(s.equalsIgnoreCase("Chill in the lobby while we find a match for you.")){
			return "Patientez dans la salle de preparation pendant que l on cherche un adversaire pour vous.";
		}
		if(s.equalsIgnoreCase("Searching for players...")){
			return "Recherche de joueurs...";
		}
		if(s.equalsIgnoreCase("You are already searching!")){
			return "Vous etes deja en train de chercher!";
		}
		if(s.equalsIgnoreCase("Do &e/warzone stop search &redto cancel")){
			return "Repprendre la recherche de &e/warzone &redto";
		}
		if(s.equalsIgnoreCase("No players found, request timed out.")){
			return "Aucun joueur trouve, la requete s est arretee.";
		}
		if(s.equalsIgnoreCase("Timeout in")){
			return "Pause en cours";
		}
		if(s.equalsIgnoreCase("match found with")){
			return "adversaire trouve :";
		}
		if(s.equalsIgnoreCase("Selecting random map...")){
			return "Selection de carte aleatoire...";
		}
		if(s.equalsIgnoreCase("All maps are occupied! Please wait.")){
			return "Toutes les cartes sont occupees! Veuillez patienter.";
		}
		if(s.equalsIgnoreCase("Map Chosen")){
			return "Carte choisie";
		}
		if(s.equalsIgnoreCase("Loading map...")){
			return "Chargement de la carte...";
		}
		if(s.equalsIgnoreCase("Map Loaded")){
			return "Carte chargee";
		}
		if(s.equalsIgnoreCase("Let battle commence!")){
			return "Que le combat commence!";
		}
		if(s.equalsIgnoreCase("The warzone world is not editable!")){
			return "Ce champ de bataille n est pas modifiable!";
		}
		if(s.equalsIgnoreCase("You quit unexpectedly!")){
			return "Vous avez quitte de maniere innatendue!";
		}
		if(s.equalsIgnoreCase("Returned to previous location.")){
			return "Vous etes revenu a l ancienne localisation.";
		}
		if(s.equalsIgnoreCase("Inventory was restored successfully.")){
			return "L inventaire a ete restore correctement.";
		}
		if(s.equalsIgnoreCase("You quit during a game! Returned to initial location.")){
			return "Vous avez quitte durant un combat! Vous etes revenu a la localisation initiale.";
		}
		if(s.equalsIgnoreCase("Time Left")){//Shows on sign. make sure message is not too long
			return "Temps restant";
		}
		if(s.equalsIgnoreCase("You struckdown")){
			return "Vous avez detruit";
		}
		if(s.equalsIgnoreCase("You got struckdown by")){
			return "Vous avez ete detruit par";
		}
		if(s.equalsIgnoreCase("You shot")){
			return "Vous avez touche";
		}
		if(s.equalsIgnoreCase("You got shot by")){
			return "Vous avez ete touche par";
		}
		if(s.equalsIgnoreCase("Quit the game!")){
			return "Quittez le jeu!";
		}
		if(s.equalsIgnoreCase("remaining.")){
			return "restant.";
		}
		if(s.equalsIgnoreCase("The match was a draw!")){
			return "Egalite!";
		}
		if(s.equalsIgnoreCase("You gained")){
			return "Vous avez gagne";
		}
		if(s.equalsIgnoreCase("Game over!")){
			return "Partie terminee!";
		}
		if(s.equalsIgnoreCase("was victorious!")){
			return "a remporte la victoire!";
		}
		if(s.equalsIgnoreCase("won with")){
			return "a gagne avec";
		}
		if(s.equalsIgnoreCase("kills.")){
			return "morts.";
		}
		return "";
	}

}
