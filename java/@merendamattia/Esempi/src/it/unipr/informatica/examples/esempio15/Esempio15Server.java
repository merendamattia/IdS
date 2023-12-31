/*
 * Example15Server
 *
 * (c) 2021-2022 Federico Bergenti. All Rights Reserved.
 */
package it.unipr.informatica.examples.esempio15;

import it.unipr.informatica.aspects.LoggingAspect;
import it.unipr.informatica.aspects.RemoteAspect;
import it.unipr.informatica.aspects.model.RemoteHandler;

public class Esempio15Server {
	private void go() {
		FileManager fileManager = new SimpleFileManager("src/it/unipr/informatica/examples");

		fileManager = LoggingAspect.attach(fileManager);

		try {
			RemoteHandler<FileManager> fileManagerHandler = RemoteAspect.attach(FileManager.class, fileManager, 1704);

			Thread.sleep(60000);

			fileManagerHandler.shutdown();
		} catch (Throwable throwable) {
			throwable.printStackTrace();
		}
	}

	public static void main(String[] args) {
		new Esempio15Server().go();
	}
}
