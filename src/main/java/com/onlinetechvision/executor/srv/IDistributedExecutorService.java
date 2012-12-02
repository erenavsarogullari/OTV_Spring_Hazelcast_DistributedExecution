package com.onlinetechvision.executor.srv;

import java.util.Collection;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;

import com.hazelcast.core.Member;

/**
 * A new IDistributedExecutorService Interface is created for service layer to expose distributed execution functionality.
 *  
 * @author onlinetechvision.com
 * @since 27 Nov 2012
 * @version 1.0.0
 *
 */
public interface IDistributedExecutorService {

	/**
     * Executes the callable object on stated member
     *
     * @param Callable callable
     * @param Member member
     * @throws InterruptedException
     * @throws ExecutionException
     * 
     */
	String executeOnStatedMember(Callable<String> callable, Member member) throws InterruptedException, ExecutionException;
	
	/**
     * Executes the callable object on member owning the key
     *
     * @param Callable callable
     * @param Object key
     * @throws InterruptedException
     * @throws ExecutionException
     * 
     */
	String executeOnTheMemberOwningTheKey(Callable<String> callable, Object key) throws InterruptedException, ExecutionException;
	
	/**
     * Executes the callable object on any member
     *
     * @param Callable callable
     * @throws InterruptedException
     * @throws ExecutionException
     * 
     */
	String executeOnAnyMember(Callable<String> callable) throws InterruptedException, ExecutionException;
	
	/**
     * Executes the callable object on all members
     *
     * @param Callable callable
     * @param Set all members
     * @throws InterruptedException
     * @throws ExecutionException
     * 
     */
	Collection<String> executeOnMembers(Callable<String> callable, Set<Member> members) throws InterruptedException, ExecutionException;
}
