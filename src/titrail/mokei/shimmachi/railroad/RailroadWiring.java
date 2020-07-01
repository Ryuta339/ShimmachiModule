package titrail.mokei.shimmachi.railroad;

public interface RailroadWiring {
	// 線路が配線略図にあるかを判定する
	abstract public boolean isIn (int trackNumber);
	abstract public boolean isIn (Track track);

	// 速さが非負かつ上限以下か判定する
	abstract public boolean isInRange (int speed);

	// 速さを変更する
	abstract public void changeSpeed (int trackNumber, int newSpeed);
	abstract public void changeSpeed (Track track, int newSpeed);
}	
