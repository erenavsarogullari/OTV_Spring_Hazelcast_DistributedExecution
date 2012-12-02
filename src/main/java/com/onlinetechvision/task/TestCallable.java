package com.onlinetechvision.task;

import java.io.Serializable;
import java.util.concurrent.Callable;

/**
 * TestCallable Class shows distributed tasks.
 * 
 * @author onlinetechvision.com
 * @since 27 Nov 2012
 * @version 1.0.0
 *
 */
public class TestCallable implements Callable<String>, Serializable{

	private static final long serialVersionUID = -1839169907337151877L;

	/**
     * Computes a result, or throws an exception if unable to do so.
     *
     * @return String computed result
     * @throws Exception if unable to compute a result
     */
	public String call() throws Exception {
		return "Second Member' s TestCallable Task is called...";
	}

}
