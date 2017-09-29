package src.in.gd;

import java.util.Random;
import java.util.concurrent.DelayQueue;
import java.util.concurrent.Delayed;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import org.junit.Test;

public class ClientServerTest {

    private DelayQueue<Job> queue = new DelayQueue<>();
    private Random rand = new Random(System.nanoTime());

    @Test
    public void testMultipleClientProcessTasks() {
	ExecutorService exec = Executors.newCachedThreadPool();
	for (int i = 0; i < 5; i++) {
	    exec.submit(new Runnable() {
		@Override
		public void run() {
		    Client client = new Client(queue);
		    client.addTask(new Runnable() {
			@Override
			public void run() {
			    try {
				TimeUnit.SECONDS.sleep(1);
			    } catch (InterruptedException e) {
				System.err.println(Thread.currentThread()
					.getId() + ": " + e.getMessage());
			    }
			    System.out.println(Thread.currentThread().getId());
			}
		    }, rand.nextInt(500), TimeUnit.MILLISECONDS);
		}

	    });
	}
	exec.submit(new Runnable() {
	    @Override
	    public void run() {
		Server server = new Server(queue);
		server.processTasks();
	    }
	});
	try {
	    TimeUnit.SECONDS.sleep(8);
	} catch (InterruptedException e) {
	}
	assert(queue.isEmpty());
	exec.shutdownNow();
    }
}

class Client {
    
    private DelayQueue<Job> queue;

    public Client(DelayQueue<Job> queue) {
	this.queue = queue;
    }

    public void addTask(Runnable job, long delay, TimeUnit timeUnit) {
	queue.put(new Job(job, delay, timeUnit));
    }

}

class Server {
    
    private DelayQueue<Job> queue;

    public Server(DelayQueue<Job> queue) {
	this.queue = queue;
    }

    public void processTasks() {
	while(!Thread.interrupted()) {
	    try {
		queue.take().job().run();
	    } catch (InterruptedException e) {
		System.err.println(e.getMessage());
	    }
	}
    }

}

class Job implements Delayed {
    
    private Runnable job;
    private TimeUnit timeUnit;
    private long delay;
    private long trigger;

    public Job(Runnable job, long delay, TimeUnit timeUnit) {
	this.job = job;
	this.delay = delay;
	this.timeUnit = timeUnit;
	this.trigger = System.nanoTime() + TimeUnit.NANOSECONDS.convert(delay, timeUnit);
    }

    @Override
    public int compareTo(Delayed o) {
	Job that = (Job)o;
	if (this.trigger - that.trigger < 0) {
	    return -1;
	} else if (this.trigger - that.trigger > 0) {
	    return 1;
	} else {
	    return 0;
	}
    }

    @Override
    public long getDelay(TimeUnit unit) {
	return unit.convert(trigger - System.nanoTime(), TimeUnit.NANOSECONDS);
    }

    public Runnable job() {
	return job;
    }
}