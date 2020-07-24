/**
 * Observer パターンのサブジェクトクラス
 **/

package titrail.mokei.shimmachi.main.observer;

import java.util.concurrent.CopyOnWriteArraySet;
import java.util.Set;

public class Subject {
	private Set<Observer> observerSet = new CopyOnWriteArraySet<Observer>();

	public boolean addObserver (Observer observer) {
		return observerSet.add (observer);
	}

	public void notifyObservers () {
		for (Observer observer: observerSet) {
			observer.update ();
		}
	}
}
