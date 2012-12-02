package com.onlinetechvision.cache.srv;

import com.hazelcast.core.IMap;
import com.onlinetechvision.customer.Customer;

/**
 * A new ICacheService Interface is created for service layer to expose cache functionality.
 *  
 * @author onlinetechvision.com
 * @since 27 Nov 2012
 * @version 1.0.0
 *
 */
public interface ICacheService {

	/**
     * Adds Customer entries to cache
     *
     * @param String key
     * @param Customer customer
     * 
     */
	void addToCache(String key, Customer customer);
	
	/**
     * Deletes Customer entries from cache
     *
     * @param String key
     * 
     */
	void deleteFromCache(String key);
	
	/**
     * Gets Customer cache
     *
     * @return IMap Coherence named cache
     */
	IMap<String, Customer> getCache();
}
