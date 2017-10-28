package org.bitandee.threads;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import org.bitandee.objects.GenericAPIResponse;

public class ThrreadManager {

	private static ExecutorService cachedThreadPool = Executors.newCachedThreadPool();

	public Future<GenericAPIResponse> runJob(Callable<GenericAPIResponse> task) {
		return cachedThreadPool.submit(task);
	}

	public void runJob(Runnable task) {
		cachedThreadPool.execute(task);
	}
}
