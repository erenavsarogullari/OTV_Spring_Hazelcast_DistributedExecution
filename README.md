Hazelcast Distributed Execution with Spring

The ExecutorService feature had come with Java 5 and is under java.util.concurrent package. It extends the Executor interface and provides a thread pool functionality to execute asynchronous short tasks. Java Executor Service Types is suggested to look over basic ExecutorService implementation.

Also ThreadPoolExecutor is a very useful implementation of ExecutorService ýnterface. It extends AbstractExecutorService providing default implementations of ExecutorService execution methods. It provides improved performance when executing large numbers of asynchronous tasks and maintains basic statistics, such as the number of completed tasks. How to develop and monitor Thread Pool Services by using Spring is also suggested to investigate how to develop and monitor Thread Pool Services.

So far, we have just talked Undistributed Executor Service implementation. Let us also investigate Distributed Executor Service.

Hazelcast Distributed Executor Service feature is a distributed implementation of java.util.concurrent.ExecutorService. It allows to execute business logic in cluster. There are four alternative ways to realize it :

1) The logic can be executed on a specific cluster member which is chosen.
2) The logic can be executed on the member owning the key which is chosen.
3) The logic can be executed on the member Hazelcast will pick.
4) The logic can be executed on all or subset of the cluster members.

This article shows how to develop Distributed Executor Service via Hazelcast and Spring.

Used Technologies : JDK 1.7.0_09, Spring 3.1.3, Hazelcast 2.4 and Maven 3.0.4