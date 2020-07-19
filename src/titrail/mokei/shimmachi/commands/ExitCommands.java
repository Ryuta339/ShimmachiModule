package titrail.mokei.shimmachi.commands;

import titrail.mokei.shimmachi.railroad.*;

public class ExitCommands implements Commands {
	private ExitCommandsBoundary _boundary;

	private static final String EXIT_MSG = "Exit.";
	private static final int EXIT_SUCCESS = 0;
	private static final int EXIT_FAILURE = 1;

	// Constructor
	public ExitCommands (ExitCommandsBoundary boundary) {
		this._boundary = boundary;
	}

	// main method
	protected void exit () {
		_boundary.printMessage (EXIT_MSG);
		// RailroadWiring に何かexit 操作が必要？
		try {
			System.exit (EXIT_SUCCESS);
		} catch (SecurityException e) {
			System.exit (EXIT_FAILURE);
		}
	}

	@Override
	public void operate () {
		exit ();
	}
}

