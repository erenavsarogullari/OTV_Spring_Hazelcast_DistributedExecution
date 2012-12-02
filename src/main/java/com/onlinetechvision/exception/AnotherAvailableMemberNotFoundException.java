package com.onlinetechvision.exception;

/**
 * AnotherAvailableMemberNotFoundException is thrown when another available member is not found. 
 * To avoid this exception, first node should be started before the second node.
 *  
 * @author onlinetechvision.com
 * @since 27 Nov 2012
 * @version 1.0.0
 *
 */
public class AnotherAvailableMemberNotFoundException extends Exception {

	private static final long serialVersionUID = -3954360266393077645L;

	/**
     * Constructor of AnotherAvailableMemberNotFoundException
     *
     * @param  String Exception message
	 *
     */
	public AnotherAvailableMemberNotFoundException(String message) {
		super(message);
	}
	
}
