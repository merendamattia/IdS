package it.unipr.informatica.concurrent.locks;

public interface Condition {
	public void await() throws InterruptedException;
	public void signal();
	public void signalAll();
}
