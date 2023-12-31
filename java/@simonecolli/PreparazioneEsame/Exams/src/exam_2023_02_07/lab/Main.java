package exam_2023_02_07.lab;

import exam_2023_02_07.lab.abstracts.ActorResourceAbstractFactory;
import exam_2023_02_07.lab.concrete.ActorResourceFactory;
import exam_2023_02_07.lab.dispatcher.ActorDispatcher;
import exam_2023_02_07.lab.dispatcher.ResourceDispatcher;

public class Main {
	public static void main(String[] args) {
		ActorResourceAbstractFactory factory = new ActorResourceFactory();

		for(int i = 0; i < 100; ++i)
			ResourceDispatcher.getInstance().addResource(factory.makeResource());
		
		for(int i = 0; i < 10; ++i)
			ActorDispatcher.getInstance().addActor(factory.makeActor());
		try {
			Thread.sleep(5000);
			ResourceDispatcher.getInstance().shoutdown();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
