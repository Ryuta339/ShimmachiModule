package titrail.mokei.shimmachi.commands.cui;

import titrail.mokei.shimmachi.commands.*;
import titrail.mokei.shimmachi.railroad.*;

import java.util.HashMap;
import java.util.Scanner;

public class CuiOperator {
	private HashMap <String, Commands> _map;
	private RailroadWiring _wiring;
	private CuiCommandsBoundary _ccb;

	private static final String ERR_ILLEGAL_COMMAND = "Illegal command input";

	// Constructor
	public CuiOperator (RailroadWiring wiring, CuiCommandsBoundary ccb) {
		this._wiring = wiring;
		this._ccb = ccb;
		this._map = new HashMap <String, Commands> ();
		this._map.put ("change_speed", 
				new SpeedControl (wiring, 
					new CuiSpeedControlBoundary (ccb)));
		this._map.put ("display",
				new DisplayControl (wiring,
					ccb.getDisplay ()));
	}

	public void mainLoop () {
		Scanner sc = new Scanner (_ccb.getInputStream ());
		while (true) {
			Commands cmd = _map.get (sc.next ());
			try {
				cmd.operate ();
			} catch (NullPointerException e) {
				_ccb.printMessage (ERR_ILLEGAL_COMMAND);
			}
		}
	}
}
