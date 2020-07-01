package titrail.mokei.shimmachi.railroad;

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
	}

	// 速さを変更する
	@Override
	public void changeSpeed (int newSpeed) {
		_speed = newSpeed;
		_logger.log (Level.INFO, MSG_CHANGE_SPEED);
	}
}

