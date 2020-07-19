package titrail.mokei.shimmachi.main.logger;

import titrail.mokei.shimmachi.main.Main;
import titrail.mokei.shimmachi.railroad.*;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.ConsoleHandler;
import java.util.logging.FileHandler;
import java.util.logging.Handler;
import java.util.logging.Logger;


public class LoggerCreater {
	private static final String LOG_FILEDIR = "./log/";

	public static final boolean SUPPRESS_STDOUT_LOGGER = true;
	public static final boolean NOT_SUPPRESS_STDOUT_LOGGER = false;

	/**
	 * @param ntracks  線路の本数
	 * @param suppressFlag コンソール出力を抑制するかどうか。
	 *
	 * @return 作られたRailroadWiringLogger
	 *
	 * suppressFlag にSUPPRESS_STDOUT_LOGGER を与えると、標準出力にログが出力されずにファイルだけに出力されるようになる。
	 **/
	public static RailroadWiring createRailroadWiringLogger (int ntracks, boolean suppressFlag) {
		try {
			Date date = new Date ();
			DateFormat dFormat = new SimpleDateFormat ("yyyyMMdd-HHmmss");
			String logFilename = LOG_FILEDIR + dFormat.format (date);

			Logger logger = Logger.getLogger (Main.class.getName());
			logger.addHandler (new FileHandler (logFilename));
			if (suppressFlag) {
				// コンソール出力を抑制
				removeConsoleHandler (logger);
			}

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


	/**
	 *
	 * 標準出力へのログ出力を抑制する
	 * refered by https://blue-red.ddo.jp/~ao/wiki/wiki.cgi?page=Java%A4%C7%A5%ED%A5%AE%A5%F3%A5%B0#p4
	 **/
	private static void removeConsoleHandler (Logger logger) {
		for (Handler handler: logger.getHandlers ()) {
			if (handler instanceof ConsoleHandler) {
				logger.removeHandler (handler);
			}
		}
		// 再帰的に呼び出す
		Logger parentLogger = logger.getParent ();
		if (parentLogger != null) {
			// 親が存在する時、再帰する
			removeConsoleHandler (parentLogger);
		}
	}
}
