package titrail.mokei.shimmachi.commands.cui;

import titrail.mokei.shimmachi.commands.*;
import titrail.mokei.shimmachi.railroad.RailroadWiring;

import java.io.InputStream;

public class CuiCommandsBoundary implements CommandsBoundary {
	private DisplayControlBoundary _display; // Delegation 
	private InputStream _inputStream;

	// Constructor
	public CuiCommandsBoundary (DisplayControlBoundary display, InputStream inputStream) {
		this._display = display;
		this._inputStream = inputStream;
	}
	// Constructor
	public CuiCommandsBoundary (DisplayControlBoundary display) {
		this (display, System.in);
	}

	protected InputStream getInputStream () {
		return _inputStream;
	}

	// 状態を表示する
	@Override
	public void printStatus (RailroadWiring railroadWiring) {
		_display.printStatus (railroadWiring);
	}

	// メッセージを表示する
	@Override
	public void printMessage (String message) {
		_display.printMessage (message);
	}
}

