package titrail.mokei.shimmachi.main.logger;

import titrail.mokei.shimmachi.main.Main;
import titrail.mokei.shimmachi.railroad.*;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.FileHandler;
import java.util.logging.Logger;


public class LoggerCreater {
	private static final String LOG_FILEDIR = "./log/";

	public static RailroadWiring createRailroadWiringLogger (int ntracks) {
		try {
			Date date = new Date ();
			DateFormat dFormat = new SimpleDateFormat ("yyyyMMdd-HHmmss");
			String logFilename = LOG_FILEDIR + dFormat.format (date);

			Logger logger = Logger.getLogger (Main.class.getName());
			logger.addHandler (new FileHandler (logFilename));

			RailroadWiring wiring = new RailroadWiringLogger (logger);
			for (int i=0; i<ntracks; i++) {
				Track t = new TrackLogger (logger);
				wiring.addTrack (t);
			}

			return wiring;

		} catch (IOException|SecurityException|IllegalArgumentException e) {
			e.printStackTrace ();
		}
		return null;
	}
}
