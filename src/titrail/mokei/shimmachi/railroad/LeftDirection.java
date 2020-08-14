/**
 * 左向きに進む状態を表すクラス。
 * Singleton パターンを利用。
 **/

package titrail.mokei.shimmachi.railroad;

public class LeftDirection implements DirectionState {
	private LeftDirection () {}

	@Override
	public String toString () {
		return "Left";
	}

	/**
	 * 左向きに進む状態のインスタンスを返す。
	 **/
	public static DirectionState getInstance () {
		return SingltonHolder.INSTANCE;
	}

	/**
	 * Singleton Holder
	 **/
	private static class SingltonHolder {
		private static final LeftDirection INSTANCE = new LeftDirection ();
	}
}
