/**
 * 停止状態を表すクラス。
 * Singleton パターンを利用。
 **/

package titrail.mokei.shimmachi.railroad;

public class StopDirection implements DirectionState {
	private StopDirection () {}

	@Override
	public String toString () {
		return "Stop";
	}

	/**
	 * 停止状態のインスタンスを返す。
	 **/
	public static StopDirection getInstance () {
		return SingletonHolder.INSTANCE;
	}

	/**
	 * Singleton Holder
	 **/
	private static class SingletonHolder {
		private static final StopDirection INSTANCE = new StopDirection ();
	}
}
