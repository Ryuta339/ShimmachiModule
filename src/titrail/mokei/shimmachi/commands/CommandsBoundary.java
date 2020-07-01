package titrail.mokei.shimmachi.commands;

import titrail.mokei.shimmachi.main.Boundary;

public interface CommandsBoundary extends Boundary {
	
	// 状態を表示する
	abstract public void printStatus ();
	
	// メッセージを表示する
	abstract public void printMessage (String message);
}
