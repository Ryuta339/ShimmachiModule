package titrail.mokei.shimmachi.railroad;

import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;

public class RailroadWiringLogger implements RailroadWiring {
	private Logger _logger;
	private ArrayList <Track> _tracks;

	private static final int MAX_SPEED = 100;
	private static final String ERR_IN_CHANGESPEED = "Illegal parameter was passed in RailroadWiringLogger$changeSpeed.";

	// Constructor
	public RailroadWiringLogger (Logger logger) {
		this._logger = logger;
		this._tracks = new ArrayList <Track> ();
	}

	// Constructor
	public RailroadWiringLogger (String logFilename)
		throws IOException, SecurityException, IllegalArgumentException
   	{
		this (Logger.getLogger (RailroadWiringLogger.class.getName()));
		this._logger.addHandler (new FileHandler (logFilename));
	}

	public boolean addTrack (Track track) {
		return _tracks.add (track);
	}

	// 線路が配線略図にあるかを判定する
	@Override
	public boolean isIn (int trackNumber) {
		return 0<=trackNumber && trackNumber<_tracks.size();
	}
	@Override
	public boolean isIn (Track track) {
		return _tracks.indexOf (track) >= 0;
	}

	// 速さが非負かつ上限以下か判定する
	@Override
	public boolean isInRange (int speed) {
		return 0<=speed && speed<=MAX_SPEED;
	}

	// 速さを変更する
	@Override
	public void changeSpeed (int trackNumber, int newSpeed) {
		if (!isIn(trackNumber) || !isInRange(newSpeed)) {
			// エラー処理
			_logger.log (Level.WARNING, ERR_IN_CHANGESPEED);
			return;
		}
		_tracks.get (trackNumber). changeSpeed (newSpeed);
	}
	@Override
	public void changeSpeed (Track track, int newSpeed) {
		if (!isIn(track) || !isInRange(newSpeed)) {
			// エラー処理
			_logger.log (Level.WARNING, ERR_IN_CHANGESPEED);
			return;
		}
		track.changeSpeed (newSpeed);
	}


	// 表示する
	@Override
	public void printStatus (PrintStream printStream) {
		printStream.println ("============ Status ============");
		_logger.log (Level.INFO, "============ Status ============");
		Iterator <Track> iterator = _tracks.iterator();
		while (iterator.hasNext ()) {
			Track t = iterator.next ();
			t.printStatus (printStream);
		}
		printStream.println ("================================");
		_logger.log (Level.INFO, "================================");
	}

}
