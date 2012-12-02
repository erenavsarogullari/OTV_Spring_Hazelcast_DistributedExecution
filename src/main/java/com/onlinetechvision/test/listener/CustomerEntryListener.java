package com.onlinetechvision.test.listener;

import com.hazelcast.core.EntryEvent;
import com.hazelcast.core.EntryListener;

/**
 * CustomerEntryListener Class listens entry changes on named cache object.
 * 
 * @author onlinetechvision.com
 * @since 27 Nov 2012
 * @version 1.0.0
 *
 */
@SuppressWarnings("rawtypes")
public class CustomerEntryListener implements EntryListener {

	/**
     * Invoked when an entry is added.
     *
     * @param EntryEvent
     * 
     */
	public void entryAdded(EntryEvent ee) {
		System.out.println("EntryAdded... Member : " + ee.getMember() + ", Key : "+ee.getKey()+", OldValue : "+ee.getOldValue()+", NewValue : "+ee.getValue());
	}
	
	/**
     * Invoked when an entry is removed.
     *
     * @param EntryEvent
     * 
     */
	public void entryRemoved(EntryEvent ee) {
		System.out.println("EntryRemoved... Member : " + ee.getMember() + ", Key : "+ee.getKey()+", OldValue : "+ee.getOldValue()+", NewValue : "+ee.getValue());
	}

	/**
     * Invoked when an entry is evicted.
     *
     * @param EntryEvent
     * 
     */
	public void entryEvicted(EntryEvent ee) {
		
	}	

	/**
     * Invoked when an entry is updated.
     *
     * @param EntryEvent
     * 
     */
	public void entryUpdated(EntryEvent ee) {
		
	}

}
