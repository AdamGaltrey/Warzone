package couk.Adamki11s.Database;

import java.net.MalformedURLException;
import java.util.logging.Logger;

public class MySqlHandler {
	
	String host, user, database, password, prefix = "[Warzone]";
	Logger log = Logger.getLogger("Minecraft");
	
	public void initialise(){
		Initialise.sqlCore.initialize();
		
		try {
			if (Initialise.sqlCore.checkConnection()) {
				System.out.println(prefix + " MySQL connection successful");
				if (!Initialise.sqlCore.checkTable("statistics")) {
					System.out.println(prefix + " Creating MySql Tables for Warzone...");
					String query = "CREATE TABLE statistics ('id' INT NOT NULL AUTO_INCREMENT, 'player' VARCHAR(100), 'wins' INT, 'draws' INT" +
					", 'losses' INT, 'shotsfired' INT, 'shotshit' INT, 'shotsmissed' INT, 'playtime' INT, 'kills' INT, 'deaths' INT, 'gp' INT," +
					"PRIMARY KEY (id));";
					Initialise.sqlCore.createTable(query);
					System.out.println(prefix + " MySQL tables created successfully!");
					Initialise.mysqlEnabled = true;
				}
			} else {
				System.out.println(prefix + " MySQL connection failed. Defaulting to SQLite");
				Initialise.mysqlEnabled = false;
				new Initialise().SQLite_Startup();
			}
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
	}

}
