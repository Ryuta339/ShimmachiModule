package titrail.mokei.shimmachi.main;

import titrail.mokei.shimmachi.commands.*;
import titrail.mokei.shimmachi.commands.cui.*;
import titrail.mokei.shimmachi.main.logger.*;
import titrail.mokei.shimmachi.railroad.*;

public class Main {
	public static void main (String[] args) 
		throws Exception
	{
		RailroadWiring wiring = LoggerCreater.createRailroadWiringLogger (3,
				LoggerCreater.SUPPRESS_STDOUT_LOGGER);
		DisplayControlBoundary display = new CuiDisplayControlBoundary ();
		CuiCommandsBoundary ccb = new CuiCommandsBoundary (display);
		CuiOperator operator = new CuiOperator (wiring,ccb);

		operator.mainLoop ();
	}
}

