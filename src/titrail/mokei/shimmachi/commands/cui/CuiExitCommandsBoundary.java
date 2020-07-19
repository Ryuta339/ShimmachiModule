package titrail.mokei.shimmachi.commands.cui;

import titrail.mokei.shimmachi.commands.*;
import titrail.mokei.shimmachi.railroad.RailroadWiring;

public class CuiExitCommandsBoundary implements ExitCommandsBoundary {
	private CuiCommandsBoundary _parent;

	// Constructor
	public CuiExitCommandsBoundary (CuiCommandsBoundary parent) {
		this._parent = parent;
	}

	// 状態を表示する
	@Override
	public void printStatus (RailroadWiring railroadWiring) {
		// 呼ばれない気がする
		_parent.printStatus (railroadWiring);
	}

	// メッセージを表示する
	@Override
	public void printMessage (String message) {
		_parent.printMessage (message);
	}
}
