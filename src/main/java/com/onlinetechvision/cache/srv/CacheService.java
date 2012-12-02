package com.onlinetechvision.cache.srv;

import com.hazelcast.core.IMap;
import com.onlinetechvision.customer.Customer;
import com.onlinetechvision.test.listener.CustomerEntryListener;

/**
 * CacheService Class is implementation of ICacheService Interface.
 * 
 * @author onlinetechvision.com
 * @since 27 Nov 2012
 * @version 1.0.0
 *
 */
public class CacheService implements ICacheService {

	private IMap<String, Customer> customerMap;
	
	/**
     * Constructor of CacheService
     *
     * @param IMap customerMap
	 *
     */
	@SuppressWarnings("unchecked")
	public CacheService(IMap<String, Customer> customerMap) {
		setCustomerMap(customerMap);
		getCustomerMap().addEntryListener(new CustomerEntryListener(), true);
	}

	/**
     * Adds Customer entries to cache
     *
     * @param String key
     * @param Customer customer
     * 
     */
	@Override
	public void addToCache(String key, Customer customer) {
		getCustomerMap().put(key, customer);
	}

	/**
     * Deletes Customer entries from cache
     *
     * @param String key
     * 
     */
	@Override
	public void deleteFromCache(String key) {
		getCustomerMap().remove(key);
	}
	
	/**
     * Gets Customer cache
     *
     * @return IMap Coherence named cache
     */
	@Override
	public IMap<String, Customer> getCache() {
		return getCustomerMap();
	}

	public IMap<String, Customer> getCustomerMap() {
		return customerMap;
	}

	public void setCustomerMap(IMap<String, Customer> customerMap) {
		this.customerMap = customerMap;
	}

	
}
