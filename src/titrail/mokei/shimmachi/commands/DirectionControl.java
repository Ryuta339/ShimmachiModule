package titrail.mokei.shimmachi.commands;

import titrail.mokei.shimmachi.railroad.*;

public class DirectionControl implements Commands {
	private RailroadWiring _wiring;
	private DirectionControlBoundary _boundary;

	private static final String ILLEGAL_TRACK_NUMBER = "Illegal track number is input.";
	private static final String REQUIRE_REINPUT = "Reinput.";

	// Constructor
	public DirectionControl (RailroadWiring wiring, DirectionControlBoundary boundary) {
		this._wiring = wiring;
		this._boundary = boundary;
	}

	// 線路を指定する
	// SpeedControl と共通するメソッドなので後で別クラスを作って移譲する
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

	// 新しい方向を指定する
	protected DirectionState decideNewDirection () {
		_boundary.requireNewDirection ();
		DirectionState newDirection = _boundary.inputNewDirection ();
		return newDirection;
	}

	// main method
	// 方向を変更する
	protected void changeDirection () {
		int trackNumber = specifyTrack ();
		DirectionState newDirection = decideNewDirection ();
		_wiring.changeDirection (trackNumber, newDirection);
		_wiring.notifyObservers (_wiring);
	}

	// 操作する
	@Override
	public void operate () {
		changeDirection ();
	}
}
