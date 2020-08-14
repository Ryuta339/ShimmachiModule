package titrail.mokei.shimmachi.railroad;

import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Iterator;

public class RailroadWiringWithList extends RailroadWiring {
	private ArrayList <Track> _tracks;

	// Constructor
	public RailroadWiringWithList () {
		this._tracks = new ArrayList <Track> ();
	}

	public boolean addTrack (Track track) {
		super.setChanged ();
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
			// throw すべき？
			return;
		}
		_tracks.get (trackNumber). changeSpeed (newSpeed);
		super.setChanged ();
	}
	@Override
	public void changeSpeed (Track track, int newSpeed) {
		if (!isIn(track) || !isInRange(newSpeed)) {
			// エラー処理
			// throw すべき？
			return;
		}
		track.changeSpeed (newSpeed);
		super.setChanged ();
	}

	// 方向を変更する
	@Override
	public void changeDirection (int trackNumber, DirectionState newState) {
		if (!isIn (trackNumber)) {
			// エラー処理
			// throw すべき？
			return;
		}
		_tracks.get (trackNumber). changeDirection (newState);
		super.setChanged ();
	}
	@Override
	public void changeDirection (Track track, DirectionState newState) {
		if (!isIn (track)) {
			// エラー処理
			// throw すべき？
			return;
		}
		track.changeDirection (newState);
		super.setChanged ();
	}


	// 表示する
	@Override
	public void printStatus () {
		super.setChanged ();
		super.notifyObservers (this);
	}

	@Override
	public String toString () {
		StringBuilder builder = new StringBuilder ("============ Status ============\n");
		Iterator <Track> iterator = _tracks.iterator ();
		while (iterator.hasNext ()) {
			Track t = iterator.next ();
			builder.append (t.toString() + "\n");
		}
		builder.append ("================================\n");
		return builder.toString ();
	}
}
