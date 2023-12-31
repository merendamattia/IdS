package it.informatica.unipr.examples;

import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.io.File;
import java.util.LinkedList;
import java.util.List;

import it.unipr.informatica.aspects.LoggingAspect;


/**
 * @author Di Agostino Manuel
 * https://github.com/manueldiagostino
 */
public class Example12 {
	public void go() {
		List<Integer> list = LoggingAspect.attach(new LinkedList<>());
		for (int i=0; i<10; ++i)
			list.add(i);
	}
	
	public void go1() {
		try {
			List<Integer> list2 = LoggingAspect.attach(new LinkedList<>(), "my.log");
			for (int i=10; i<20; ++i)
				list2.add(i);
			
			LoggingAspect.dispose();
			LoggingAspect.attach(list2, "my2.log");
			for (int i=20; i>10; --i)
				list2.add(i);
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		new Example12().go1();
	}
}
