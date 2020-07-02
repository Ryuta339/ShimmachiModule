package titrail.mokei.shimmachi.commands.cui;

import titrail.mokei.shimmachi.commands.*;

import java.io.InputStream;
import java.io.PrintStream;

public class CuiCommandsBoundary implements CommandsBoundary {
	private InputStream _inputStream;
	private PrintStream _printStream;

	// Constructor
	public CuiCommandsBoundary (InputStream inputStream, PrintStream printStream) {
		this._inputStream = inputStream;
		this._printStream = printStream;
	}

	protected InputStream getInputStream () {
		return _inputStream;
	}

	// 状態を表示する
	@Override
	public void printStatus () {
		// temporary
		_printStream.println ("Print Status");
	}

	// メッセージを表示する
	@Override
	public void printMessage (String message) {
		_printStream.println (message);
	}
}

