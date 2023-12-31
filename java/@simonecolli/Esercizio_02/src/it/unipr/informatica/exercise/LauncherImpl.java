package it.unipr.informatica.exercise;

public class LauncherImpl implements Launcher {
	
//	due launcher causano attesa
//	private boolean flag_ = false;
	
	private boolean flag_ = true;
	
	@Override
	public void start(Task[] tasks) {

		System.out.println("************************* LauncherImpl *************************");
		
//		flag_ = false;
		if (tasks == null)
			throw new IllegalArgumentException("tasks");
		
		
		Object mutex = new Object();
		Object flagMutex = new Object();
		
		
		
		synchronized (mutex) {
			
			for (int i = 0; i < tasks.length; i++) {
				
				int tmp = i;
			
				Runnable runnable = new Runnable() {
					
					@Override
					public void run() {
						
						tasks[tmp].perform();
						
						synchronized (flagMutex) {
							System.out.println("Task " + tmp +  " enter flagMutex");
							
							if(flag_) {
								System.out.println("Task " + tmp +  " has enter if");
								
								synchronized (mutex) {
									System.out.println("---- Task " + tmp + " notify ----");
									mutex.notifyAll();
								}
								flag_ = false;
							}
						}
	
					}
				};
				
				new Thread(runnable).start();
			}
		

			try {
				mutex.wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
				return;
			}
		}
		
	}

}
