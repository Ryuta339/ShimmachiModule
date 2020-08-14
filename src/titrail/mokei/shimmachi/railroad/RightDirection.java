/**
 * 右向きに進む状態を表すクラス。
 * Singleton パターンを利用。
 **/

package titrail.mokei.shimmachi.railroad;

public class RightDirection implements DirectionState {
	private RightDirection () {}

	@Override
	public String toString () {
		return "Right";
	}

	/**
	 * 右向きに進む状態のインスタンスを返す。
	 **/
	public static DirectionState getInstance () {
		return SingletonHolder.INSTANCE;
	}

	/**
	 * Singleton Holder
	 **/
	private static class SingletonHolder {
		private static final RightDirection INSTANCE = new RightDirection ();
	}
}
