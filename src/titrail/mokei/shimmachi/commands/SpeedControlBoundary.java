package titrail.mokei.shimmachi.commands;

public interface SpeedControlBoundary extends CommandsBoundary {

	// 加速・減速する線路を要求する
	abstract public void requireTrack ();

	// 加速・減速する線路を入力する
	abstract public int inputTrack ();

	// 新しい速さを要求する
	abstract public void requireNewSpeed ();

	// 新しい速さを入力する
	abstract public int inputNewSpeed ();
}
