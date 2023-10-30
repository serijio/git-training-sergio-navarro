import java.util.ArrayList;

public class ControlCarrera  { //clase media, como si alguien estuviera en la línea de meta y fuera haciendo fotos pa pasarle al main lo que ve
	ArrayList<HilosCoches> coches = new ArrayList<HilosCoches>(); //array que almacena los coches
	int pos = 4;
	boolean execute = true;
	boolean sigue = true;
			
	public ArrayList<HilosCoches> getCoches() {
		return coches;
	}
	
	public void setCoches(ArrayList<HilosCoches> coches) {
		this.coches = coches;
	}

	public int getPos() {
		return pos;
	}

	public void setPos(int pos) {
		this.pos = pos;
	}

	public boolean isExecute() {
		return execute;
	}

	public void setExecute(boolean execute) {
		this.execute = execute;
	}

	public boolean isSigue() {
		return sigue;
	}

	public void setSigue(boolean sigue) {
		this.sigue = sigue;
	}

	public synchronized void otravuelta(HilosCoches coche) { //pa que los hilos vayan ejecutando uno a uno el método otravuelta
		
		for (int i = 0; i < coches.size(); i++) {
			if (coche.getCod().equals(coches.get(i).getCod())) { //lo del equal es pa que vaya cogiendo los valores de i y vaya buscando si coinciden con algun valor del "cod" de los coches
				coches.remove(i); //pa que cuando un coche se actualice, se quite la info de antes y se ponga la nueva sin añadirse como elemento adicional
			}
		}
		
		coches.add(coche);
		
		coches.sort((c1, c2) -> Integer.compare(c2.getLaps(), c1.getLaps())); //comando pa ordenar los coches según la posición de llegada
		
		if (execute == true) {
			System.out.println("\n\nCAR\tLAP\tPOSITION\n-------------------------");
			for (int i = 0; i < coches.size(); i++) {
				System.out.println(coches.get(i).getCod() + "\t" + coches.get(i).getLaps() + "\t" + (i+1)); //el i+1 es pa imprimir las posiciones según el número de coches
				
				if (coches.get(i).getLaps() < 10) {
					sigue = true;
				} else {
					sigue = false;
				}
			}
		}
	}	
}
