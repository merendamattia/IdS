/*
 * RemoteException
 *
 * (c) 2021-2023 Federico Bergenti. All Rights Reserved.
 */
package it.unipr.informatica.aspects.exceptions;

public class RemoteException extends RuntimeException {
	private static final long serialVersionUID = -587659957946875703L;

	public RemoteException(Throwable cause) {
		super(cause);
	}
}
