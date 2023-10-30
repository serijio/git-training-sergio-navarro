package main;

import hilitos.ControlCarrera;
import hilitos.HilosCoches;

public class MainUwU {

	public static void main(String[] args) {
		
		ControlCarrera control = new ControlCarrera();
		int cant = 4;
		
		for (int i = 1; i <= cant; i++) {
			HilosCoches cochecarrera = new HilosCoches(control, i);
			control.getCoches().add(cochecarrera);
			cochecarrera.start();
		}

		System.out.println("START!!");
						
		while (control.isSigue() == true) {
			try {
				Thread.sleep(1000);
				control.setExecute(true);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
