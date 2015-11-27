package MDijkstra;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class TestDijkstraAlgorithm {

  private static List<Nodo> nodos;
  private static List<Arista> aristas;
  private static Scanner sc = new Scanner(System.in);
  private static int s,n,p,nr,cost,r;
  private static String name;
  

	// @Test
	public static void main(String[] args) {

		// Agregar cantidad de testeos
		// s = sc.nextInt();

		System.out.println("Cantidad de ciudades: ");
		// Agregar cantidad de ciudades
		n = sc.nextInt();

		nodos = new ArrayList<Nodo>();
		aristas = new ArrayList<Arista>();

		// Se Agrega cantidad de ciudades
		// Name
		
		for (int i = 0; i < n; i++) {
			System.out.println("Name");
			name = sc.next();
			Nodo locations = new Nodo(name , name );
			nodos.add(locations);
		}

		// Se carga el Grafo
		for (int i = 0; i < nodos.size(); i++) {

			// Vecinos
			System.out.println("CantDeVecinos de " + nodos.get(i).getName());
			p = sc.nextInt();

			for (int j = 0; j < p; j++) {
				// Destino
				nr = sc.nextInt();
				// Costo
				cost = sc.nextInt();
				addDirectionalLane("Arista: " + i + "." + j, i, nr, cost);
			}

		}

		// Lets check from location Loc_1 to Loc_10
		Grafo g = new Grafo(nodos, aristas);
		DijkstraAlgorithm dijkstra = new DijkstraAlgorithm(g);

		// Cantidad de caminos a elegir
		//System.out.println("Ingrese la cantidad de caminos a buscar");
		//r = sc.nextInt();
		//for (int i = 0; i < r; i++) {
			
		
		// Elegir nodo incio
			System.out.println("Agregar Nodo Inicio");
			name=sc.next();
			dijkstra.execute(nodos.get(getNombre(name,n)));

			// Elegir nodo final
			System.out.println("Agregar Nodo Destino");
			name=sc.next();
			LinkedList<Nodo> path = dijkstra.getPath(nodos.get(getNombre(name,n)));
						
			for (Nodo nodo : path) {
				System.out.println(nodo);
			}
			
		//}
	}
  private static void addNotDirLane(String laneId, int d, int h, int arista){
	  //
	  addDirectionalLane(laneId, d, h, arista);
	  //
	  addDirectionalLane(laneId, h, d, arista);
	  
  }
  
  private static void addDirectionalLane(String laneId, int sourceLocNo, int destLocNo,
      int duration) {
    Arista lane = new Arista(laneId,nodos.get(sourceLocNo), nodos.get(destLocNo), duration);
    aristas.add(lane);
  }
  
  private static int getNombre(String name, int N) {
	  int a = 0;
	  for (int i = 0; i < N; i++) {
		  if(nodos.get(i).getName().equals(name)){
		  	a=i;
		  }
	  }
		return a;
	}

} 
