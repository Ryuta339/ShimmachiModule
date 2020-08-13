package titrail.mokei.shimmachi.railroad;

import java.io.PrintStream;
import java.util.Observable;

abstract public class Track extends Observable {
	protected static final String MSG_CHANGE_SPEED = "Speed is changed";

	// 速さを変更する
	abstract public void changeSpeed (int newSpeed);

	// 表示する
	abstract public void printStatus ();
	// abstract public void printStatus (PrintStream printStream);
}
