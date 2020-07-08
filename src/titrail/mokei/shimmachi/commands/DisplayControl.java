package titrail.mokei.shimmachi.commands;

import titrail.mokei.shimmachi.railroad.*;

public class DisplayControl implements Commands {
	private RailroadWiring _wiring;
	private DisplayControlBoundary _boundary;

	// Constructor
	public DisplayControl (RailroadWiring wiring, DisplayControlBoundary boundary) {
		this._wiring = wiring;
		this._boundary = boundary;
	}

	// main method
	// 表示する
	protected void display () {
		_boundary.printStatus (_wiring);
	}

	// 操作する
	@Override
	public void operate () {
		display ();
	}
}
