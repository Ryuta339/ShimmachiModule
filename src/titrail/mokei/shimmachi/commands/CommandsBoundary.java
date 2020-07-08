package titrail.mokei.shimmachi.commands;

import titrail.mokei.shimmachi.main.Boundary;
import titrail.mokei.shimmachi.railroad.RailroadWiring;

public interface CommandsBoundary extends Boundary {
	
	// 状態を表示する
	abstract public void printStatus (RailroadWiring railroadWiring);
	
	// メッセージを表示する
	abstract public void printMessage (String message);
}
