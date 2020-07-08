package titrail.mokei.shimmachi.commands;

import titrail.mokei.shimmachi.railroad.*;

public class SpeedControl implements Commands {
	private RailroadWiring _wiring;
	private SpeedControlBoundary _boundary;

	private static final String ILLEGAL_TRACK_NUMBER = "Illegal track number is input.";
	private static final String ILLEGAL_SPEED = "Illegal speed is input.";
	private static final String REQUIRE_REINPUT = "Reinput.";

	// Constructor
	public SpeedControl (RailroadWiring wiring, SpeedControlBoundary boundary) {
		this._wiring = wiring;
		this._boundary = boundary;
	}

	// 線路を特定する
	protected int specifyTrack () {
		_boundary.requireTrack ();
		int trackNumber = _boundary.inputTrack ();
		if (! _wiring.isIn (trackNumber)) {
			// 線路が存在しない
			// 再入力する
			_boundary.printMessage (ILLEGAL_TRACK_NUMBER);
			_boundary.printMessage (REQUIRE_REINPUT);
			return specifyTrack ();
		}
		return trackNumber;
	}

	// 新しい速さを指定する
	protected int decideNewSpeed () {
		_boundary.requireNewSpeed ();
		int newSpeed = _boundary.inputNewSpeed ();
		if (! _wiring.isInRange (newSpeed)) {
			// 新しい速さが負もしくは上限以上
			// 再入力する
			_boundary.printMessage (ILLEGAL_SPEED);
			_boundary.printMessage (REQUIRE_REINPUT);
			return decideNewSpeed ();
		}
		return newSpeed;
	}

	// main method
	// 加速・減速する
	protected void accelerateAndDecelarate () {
		int trackNumber = specifyTrack ();
		int newSpeed = decideNewSpeed ();
		_wiring.changeSpeed (trackNumber, newSpeed);
		_boundary.printStatus (_wiring);
	}

	// 操作する
	@Override
	public void operate () {
		accelerateAndDecelarate ();
	}
}
