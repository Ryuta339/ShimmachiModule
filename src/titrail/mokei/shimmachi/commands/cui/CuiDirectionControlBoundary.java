package titrail.mokei.shimmachi.commands.cui;

import titrail.mokei.shimmachi.commands.*;
import titrail.mokei.shimmachi.railroad.*;

import java.util.Scanner;
import java.util.InputMismatchException;
import java.util.NoSuchElementException;


public class CuiDirectionControlBoundary implements DirectionControlBoundary {
	private CuiCommandsBoundary _parent;

	private static final String MSG_REQUIRE_TRACK = "Input the track number.";
	private static final String MSG_REQUIRE_NEW_DIRECTION = "Input the new direction.";

	public CuiDirectionControlBoundary (CuiCommandsBoundary parent) {
		this._parent = parent;
	}
	
	/**
	 * 方向を変更する線路を要求する
	 **/
	@Override
	public void requireTrack () {
		_parent.printMessage (MSG_REQUIRE_TRACK);
	}

	/**
	 * 方向を変更する線路を入力する
	 **/
	@Override
	public int inputTrack () {
		Scanner sc = new Scanner (_parent.getInputStream ());
		int trackNumber = -1;
		try {
			trackNumber = sc.nextInt ();
		} catch (InputMismatchException e) {
			// 再入力
			trackNumber = inputTrack ();
		} catch (NoSuchElementException|IllegalStateException e) {
			e.printStackTrace ();
			trackNumber = inputTrack ();
		}
		return trackNumber;
	}

	/**
	 * 新しい方向を要求する
	 **/
	@Override
	public void requireNewDirection () {
		_parent.printMessage (MSG_REQUIRE_NEW_DIRECTION);
	}

	/**
	 * 新しい方向を入力する
	 **/
	@Override
	public DirectionState inputNewDirection () {
		Scanner sc = new Scanner (_parent.getInputStream ());
		String str = sc.next().toLowerCase ();
		DirectionState state = StopDirection.getInstance ();
		// バグの温床な気がする。
		// null が怖い。
		switch (str) {
			case "left":
				state = LeftDirection.getInstance ();
				break;
			case "right":
				state = RightDirection.getInstance ();
				break;
			case "stop":
				state = StopDirection.getInstance ();
				break;
			default:
				state = StopDirection.getInstance ();
				break;
		}
		return state;
	}

	/**
	 * 状態を表示する
	 **/
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
