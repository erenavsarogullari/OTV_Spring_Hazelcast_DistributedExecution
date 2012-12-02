package com.onlinetechvision.exe;

import java.util.Set;
import java.util.concurrent.ExecutionException;

import com.hazelcast.core.Hazelcast;
import com.hazelcast.core.HazelcastInstance;
import com.hazelcast.core.Member;
import com.onlinetechvision.cache.srv.ICacheService;
import com.onlinetechvision.customer.Customer;
import com.onlinetechvision.exception.AnotherAvailableMemberNotFoundException;
import com.onlinetechvision.executor.srv.IDistributedExecutorService;
import com.onlinetechvision.task.TestCallable;

/**
 * Starter Class loads Customers to cache and executes distributed tasks.
 * 
 * @author onlinetechvision.com
 * @since 27 Nov 2012
 * @version 1.0.0
 *
 */
public class Starter {
	
	private String hazelcastInstanceName;	
	private Hazelcast hazelcast;
	private IDistributedExecutorService distributedExecutorService;
	private	ICacheService cacheService;
	
	/**
     * Loads cache and executes the tasks
     *
     */
	public void start() {
		loadCache();
		executeTasks();
	}
	
	/**
     * Loads Customers to cache
     *
     */
	public void loadCache() {
		Customer firstCustomer = new Customer();
		firstCustomer.setId("3");
		firstCustomer.setName("Bruce");
		firstCustomer.setSurname("Willis");
		
		Customer secondCustomer = new Customer();
		secondCustomer.setId("4");
		secondCustomer.setName("Colin");
		secondCustomer.setSurname("Farrell");
		
		getCacheService().addToCache(firstCustomer.getId(), firstCustomer);
		getCacheService().addToCache(secondCustomer.getId(), secondCustomer);
	}
	
	/**
     * Executes Tasks
     *
     */
	public void executeTasks() {		
		try {
			getDistributedExecutorService().executeOnStatedMember(new TestCallable(), getAnotherMember());
			getDistributedExecutorService().executeOnTheMemberOwningTheKey(new TestCallable(), "3");
			getDistributedExecutorService().executeOnAnyMember(new TestCallable());
			getDistributedExecutorService().executeOnMembers(new TestCallable(), getAllMembers());
		} catch (InterruptedException | ExecutionException | AnotherAvailableMemberNotFoundException e) {
			e.printStackTrace();
		}		
	}
	
	/**
     * Gets cluster members
     *
     * @return Set<Member> Set of Cluster Members
	 *
     */
	private Set<Member> getAllMembers() {
		Set<Member> members = getHazelcastLocalInstance().getCluster().getMembers();
		
		return members;
	}
	
	/**
     * Gets an another member of cluster
     *
     * @return Member Another Member of Cluster
	 * @throws AnotherAvailableMemberNotFoundException An Another Available Member can not found exception
     */
	private Member getAnotherMember() throws AnotherAvailableMemberNotFoundException {
		Set<Member> members = getAllMembers();
		for(Member member : members) {
			if(!member.localMember()) {
				return member;
			}			
		}
		
		throw new AnotherAvailableMemberNotFoundException("No Other Available Member on the cluster. Please be aware that all members are active on the cluster");
	}
	
	/**
     * Gets Hazelcast local instance
     *
     * @return HazelcastInstance Hazelcast local instance
	 */
	@SuppressWarnings("static-access")
	private HazelcastInstance getHazelcastLocalInstance() {
		HazelcastInstance instance = getHazelcast().getHazelcastInstanceByName(getHazelcastInstanceName());
		return instance;
	}

	public String getHazelcastInstanceName() {
		return hazelcastInstanceName;
	}

	public void setHazelcastInstanceName(String hazelcastInstanceName) {
		this.hazelcastInstanceName = hazelcastInstanceName;
	}

	public Hazelcast getHazelcast() {
		return hazelcast;
	}

	public void setHazelcast(Hazelcast hazelcast) {
		this.hazelcast = hazelcast;
	}

	public IDistributedExecutorService getDistributedExecutorService() {
		return distributedExecutorService;
	}

	public void setDistributedExecutorService(IDistributedExecutorService distributedExecutorService) {
		this.distributedExecutorService = distributedExecutorService;
	}

	public ICacheService getCacheService() {
		return cacheService;
	}

	public void setCacheService(ICacheService cacheService) {
		this.cacheService = cacheService;
	}
	
}
