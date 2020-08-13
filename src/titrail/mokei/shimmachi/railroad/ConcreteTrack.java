/***
 * ConcreteTrack クラスは Track クラスの単純な実装クラス。
 * 名前は早く変えるべき。
 ***/

package titrail.mokei.shimmachi.railroad;

import java.io.IOException;
import java.io.PrintStream;

public class ConcreteTrack extends Track {
	private int _index;
	private int _speed;

	// Constructor
	public ConcreteTrack (int index) {
		this._index = index;
		this._speed = 0;
	}

	/**
	 * @param newSpeed 新しい速さ。
	 *
	 * 速さを変更する。
	 **/
	@Override
	public void changeSpeed (int newSpeed) {
		_speed = newSpeed;
		super.setChanged ();
	}

	/**
	 * 表示する
	 **/
	@Override
	public void printStatus () {
		super.setChanged ();
		super.notifyObservers (this);
	}

	/**
	 * 文字列化。
	 * Observer のUpdateで呼び出される。
	 **/
	@Override
	public String toString () {
		StringBuilder builder = new StringBuilder ("Track no. ")
			.append (Integer.toString(_index))
			.append ("\n\tSpeed: ")
			.append (_speed);
		return builder.toString ();
	}
}

