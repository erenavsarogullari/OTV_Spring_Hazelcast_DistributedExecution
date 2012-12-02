package com.onlinetechvision.executor.srv;

import java.util.Collection;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;

import org.apache.log4j.Logger;

import com.hazelcast.core.DistributedTask;
import com.hazelcast.core.Member;
import com.hazelcast.core.MultiTask;

/**
 * DistributedExecutorService Class is implementation of IDistributedExecutorService Interface.
 * 
 * @author onlinetechvision.com
 * @since 27 Nov 2012
 * @version 1.0.0
 *
 */
public class DistributedExecutorService implements IDistributedExecutorService {

	private static final Logger logger = Logger.getLogger(DistributedExecutorService.class);
	
	private ExecutorService hazelcastDistributedExecutorService;
	
	/**
     * Executes the callable object on stated member
     *
     * @param Callable callable
     * @param Member member
     * @throws InterruptedException
     * @throws ExecutionException
     * 
     */
	@SuppressWarnings("unchecked")
	public String executeOnStatedMember(Callable<String> callable, Member member) throws InterruptedException, ExecutionException {
		logger.debug("Method executeOnStatedMember is called...");
		ExecutorService executorService = getHazelcastDistributedExecutorService();
		FutureTask<String> task = (FutureTask<String>) executorService.submit( new DistributedTask<String>(callable, member));
		String result = task.get();
		logger.debug("Result of method executeOnStatedMember is : " + result);
		return result;
	}

	/**
     * Executes the callable object on member owning the key
     *
     * @param Callable callable
     * @param Object key
     * @throws InterruptedException
     * @throws ExecutionException
     * 
     */
	@SuppressWarnings("unchecked")
	public String executeOnTheMemberOwningTheKey(Callable<String> callable, Object key) throws InterruptedException, ExecutionException {
		logger.debug("Method executeOnTheMemberOwningTheKey is called...");
		ExecutorService executorService = getHazelcastDistributedExecutorService();
		FutureTask<String> task = (FutureTask<String>) executorService.submit(new DistributedTask<String>(callable, key));
		String result = task.get();
		logger.debug("Result of method executeOnTheMemberOwningTheKey is : " + result);
		return result;
	}

	/**
     * Executes the callable object on any member
     *
     * @param Callable callable
     * @throws InterruptedException
     * @throws ExecutionException
     * 
     */
	public String executeOnAnyMember(Callable<String> callable) throws InterruptedException, ExecutionException {
		logger.debug("Method executeOnAnyMember is called...");
		ExecutorService executorService = getHazelcastDistributedExecutorService();
		Future<String> task = executorService.submit(callable);
		String result = task.get();
		logger.debug("Result of method executeOnAnyMember is : " + result);
		return result;
	}

	/**
     * Executes the callable object on all members
     *
     * @param Callable callable
     * @param Set all members
     * @throws InterruptedException
     * @throws ExecutionException
     * 
     */
	public Collection<String> executeOnMembers(Callable<String> callable, Set<Member> members) throws ExecutionException, InterruptedException {
		logger.debug("Method executeOnMembers is called...");
		MultiTask<String> task = new MultiTask<String>(callable, members);
		ExecutorService executorService = getHazelcastDistributedExecutorService();
		executorService.execute(task);
		Collection<String> results = task.get();
		logger.debug("Result of method executeOnMembers is : " + results.toString());
		return results;
	}

	public ExecutorService getHazelcastDistributedExecutorService() {
		return hazelcastDistributedExecutorService;
	}

	public void setHazelcastDistributedExecutorService(ExecutorService hazelcastDistributedExecutorService) {
		this.hazelcastDistributedExecutorService = hazelcastDistributedExecutorService;
	}
	
}
