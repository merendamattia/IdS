package it.unipr.informatica.design_patterns.creational.abstract_factory.devices.interfaces;

public interface DeviceFactory {
	public Media createMedia();
	public Player createPlayer();
	public Recorder createRecorder();
}
