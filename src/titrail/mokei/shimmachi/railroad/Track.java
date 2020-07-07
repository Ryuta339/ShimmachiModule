package titrail.mokei.shimmachi.railroad;

import java.io.PrintStream;

public interface Track {
	// 速さを変更する
	abstract public void changeSpeed (int newSpeed);

	// 表示する
	abstract public void printStatus (PrintStream printStream);
}
