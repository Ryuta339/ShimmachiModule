package titrail.mokei.shimmachi.railroad;

import java.io.IOException;
import java.io.PrintStream;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;

public class TrackLogger implements Track {
	private Logger _logger;
	private int _speed;

	private static final String MSG_CHANGE_SPEED = "Speed is changed";

	// Constructor
	public TrackLogger (Logger logger) {
		this._logger = logger;
		this._speed = 0;
		this._logger.log (Level.INFO, "Created Track.");
	}

	// Constructor
	public TrackLogger (String logFilename) 
		throws IOException, SecurityException, IllegalArgumentException
	{
		this (Logger.getLogger (TrackLogger.class.getName ()));
		this._logger.addHandler (new FileHandler (logFilename));
	}

	// 速さを変更する
	@Override
	public void changeSpeed (int newSpeed) {
		_logger.log (Level.INFO, "Called changeSpeed.");
		_speed = newSpeed;
		_logger.log (Level.INFO, MSG_CHANGE_SPEED);
	}

	// 表示する
	@Override
	public void printStatus (PrintStream printStream) {
		printStream.printf ("Speed: %d\n", _speed);
		_logger.log (Level.INFO, "Speed: %d\n", _speed);
	}
}

