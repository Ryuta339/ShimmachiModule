package titrail.mokei.shimmachi.commands.cui;

import titrail.mokei.shimmachi.commands.*;
import titrail.mokei.shimmachi.railroad.RailroadWiring;

import java.io.PrintStream;
import java.util.Observable;

public class CuiDisplayControlBoundary implements DisplayControlBoundary {
	private PrintStream _printStream;

	// Constructor
	public CuiDisplayControlBoundary (PrintStream printStream) {
		this._printStream = printStream;
	}

	// Constructor
	public CuiDisplayControlBoundary () {
		this (System.out);
	}

	// 状態を表示する
	@Override
	public void printStatus (RailroadWiring railroadWiring) {
		railroadWiring.printStatus ();
	}

	// メッセージを表示する
	@Override
	public void printMessage (String message) {
		_printStream.println (message);
	}

	// update
	@Override
	public void update (Observable o, Object arg) {
		try {
			RailroadWiring wiring = (RailroadWiring) o;
			_printStream.println (wiring.toString ());
		} catch (ClassCastException e) {
			e.printStackTrace (_printStream);
		}
	}
}
