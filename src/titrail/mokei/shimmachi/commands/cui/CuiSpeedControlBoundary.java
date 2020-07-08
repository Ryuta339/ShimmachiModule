package titrail.mokei.shimmachi.commands.cui;

import titrail.mokei.shimmachi.commands.*;
import titrail.mokei.shimmachi.railroad.RailroadWiring;

import java.util.Scanner;

public class CuiSpeedControlBoundary implements SpeedControlBoundary {
	private CuiCommandsBoundary _parent;

	private static final String MSG_REQUIRE_TRACK = "Input the track number.";
	private static final String MSG_REQUIRE_NEW_SPEED = "Input the new speed.";


	public CuiSpeedControlBoundary (CuiCommandsBoundary parent) {
		this._parent = parent;
	}

	// 加速・減速する線路を要求する
	@Override
	public void requireTrack () {
		_parent.printMessage (MSG_REQUIRE_TRACK);
	}
	
	// 加速・減速する線路を入力する
	@Override
	public int inputTrack () {
		Scanner sc = new Scanner (_parent.getInputStream());
		int trackNumber = -1;
		try {
			trackNumber = sc.nextInt ();
		} catch (Exception e) {
			e.printStackTrace ();
			trackNumber = inputTrack ();
		}
		return trackNumber;
	}

	// 新しい速さを要求する
	@Override
	public void requireNewSpeed () {
		_parent.printMessage (MSG_REQUIRE_NEW_SPEED);
	}

	// 新しい速さを入力する
	@Override
	public int inputNewSpeed () {
		Scanner sc = new Scanner (_parent.getInputStream());
		int newSpeed = -1;
		try {
			newSpeed = sc.nextInt ();
		} catch (Exception e) {
			e.printStackTrace ();
			newSpeed = inputNewSpeed ();
		}
		return newSpeed;
	}

	// 状態を表示する
	@Override
	public void printStatus (RailroadWiring railroadWiring) {
		_parent.printStatus (railroadWiring);
	}

	// メッセージを表示する
	@Override
	public void printMessage (String message) {
		_parent.printMessage (message);
	}
}
