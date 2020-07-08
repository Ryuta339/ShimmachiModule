package titrail.mokei.shimmachi.main;

import titrail.mokei.shimmachi.commands.*;
import titrail.mokei.shimmachi.commands.cui.*;
import titrail.mokei.shimmachi.railroad.*;

import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

public class Main {
	static final String LOG_FILENAME = "./log/";
	public static void main (String[] args) {
		try {
			Date date = new Date ();
			DateFormat dFormat = new SimpleDateFormat ("yyyyMMdd-HHmmss");
			String logFilename = LOG_FILENAME + dFormat.format (date);

			Track t1 = new TrackLogger (logFilename);
			Track t2 = new TrackLogger (logFilename);
			RailroadWiring wiring = new RailroadWiringLogger (logFilename);
			wiring.addTrack (t1);
			wiring.addTrack (t2);
		} catch (Exception e) {
			e.printStackTrace ();
		}
	}
}

