package titrail.mokei.shimmachi.commands;

import titrail.mokei.shimmachi.railroad.DirectionState;

public interface DirectionControlBoundary extends CommandsBoundary {

	// 方向を変更する線路を要求する
	abstract public void requireTrack ();

	// 方向を変更する線路を入力する
	abstract public int inputTrack ();

	// 新しい方向を要求する
	abstract public void requireNewDirection ();

	// 新しい方向を入力する
	abstract public DirectionState inputNewDirection ();
}
