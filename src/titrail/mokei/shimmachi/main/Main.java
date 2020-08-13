package titrail.mokei.shimmachi.main;

import titrail.mokei.shimmachi.commands.*;
import titrail.mokei.shimmachi.commands.cui.*;
import titrail.mokei.shimmachi.main.logger.*;
import titrail.mokei.shimmachi.railroad.*;

public class Main {
	public static void main (String[] args) 
		throws Exception
	{
		/*
		RailroadWiring wiring = LoggerCreater.createRailroadWiringLogger (3,
				LoggerCreater.SUPPRESS_STDOUT_LOGGER);
		*/
		int ntracks = 3;

		RailroadWiring wiring = new RailroadWiringWithList ();
		for (int i=0; i<ntracks; i++) {
			Track t = new ConcreteTrack (i+1);
			wiring.addTrack (t);
		}
		DisplayControlBoundary display = new CuiDisplayControlBoundary ();
		ObserverLogger ol = ObserverLogger.getObserverLogger (
				ObserverLogger.SUPPRESS_STDOUT_LOGGER);
		
		wiring.addObserver (display);
		wiring.addObserver (ol);
		CuiCommandsBoundary ccb = new CuiCommandsBoundary (display);
		CuiOperator operator = new CuiOperator (wiring,ccb);

		operator.mainLoop ();
	}
}

