package ir.pegahtech.saas.client.shared.threading;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadManager {
	private final static int NUMBER_OF_CORES = Runtime.getRuntime().availableProcessors();
	final static private ExecutorService pool = Executors.newFixedThreadPool(NUMBER_OF_CORES * 4);
	
	public static void exec(Runnable r){
		pool.execute(r);
	}
}