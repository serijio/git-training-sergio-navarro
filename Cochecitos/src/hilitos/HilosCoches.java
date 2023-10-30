package hilitos;

import java.util.Random;

public class HilosCoches extends Thread {
	private ControlCarrera control;
	private String cod;
	private int laps;
	
	public HilosCoches(ControlCarrera control, int codnumero) {
		this.control = control;
		this.cod = "C" + codnumero;
	}

	public void run () {
		int finlap = 10;
		Random random = new Random();
	
		while (laps < finlap) {
			try {
				Thread.sleep(random.nextLong(500, 3000)); //recordar que esto está en milisegundos, por eso los números del random son tan grandes
				laps = laps + 1;
				control.otravuelta(this); //pasar la info de lo que ha sucedido al método "otravuelta" de la clase intermedia
				
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	public String getCod() {
		return cod;
	}

	public void setCod(String cod) {
		this.cod = cod;
	}

	public int getLaps() {
		return laps;
	}

	public void setLaps(int laps) {
		this.laps = laps;
	}

	public ControlCarrera getControl() {
		return control;
	}

	public void setControl(ControlCarrera control) {
		this.control = control;
	}	
}