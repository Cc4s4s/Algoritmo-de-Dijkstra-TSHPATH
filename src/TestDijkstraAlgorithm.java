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
		System.out.println("Name");
		name = sc.next();
		for (int i = 0; i < n; i++) {

			Nodo locations = new Nodo(name + i, name + i);
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

		/*
		 * 
		 * // Grafo no direccional addNotDirLane(name, 0, 1, 85);
		 * addNotDirLane("Arista_1", 0, 2, 217); addNotDirLane("Arista_2", 0, 4,
		 * 173); addNotDirLane("Arista_3", 2, 6, 186); addNotDirLane("Arista_4",
		 * 2, 7, 103); addNotDirLane("Arista_5", 3, 7, 183);
		 * addNotDirLane("Arista_6", 5, 8, 250); addNotDirLane("Arista_7", 8, 9,
		 * 84); addNotDirLane("Arista_8", 7, 9, 167); addNotDirLane("Arista_9",
		 * 4, 9, 502); addNotDirLane("Arista_10", 9, 10, 40);
		 * addNotDirLane("Arista_11", 1, 10, 600);
		 */

		/*
		 * //Grafo direccional
		 * 
		 * addNotDirLane("Arista_0", 0, 1, 85); addNotDirLane("Arista_1", 0, 2,
		 * 217); addNotDirLane("Arista_2", 0, 4, 173); addNotDirLane("Arista_3",
		 * 2, 6, 186); addNotDirLane("Arista_4", 2, 7, 103);
		 * addNotDirLane("Arista_5", 3, 7, 183); addNotDirLane("Arista_6", 5, 8,
		 * 250); addNotDirLane("Arista_7", 8, 9, 84); addNotDirLane("Arista_8",
		 * 7, 9, 167); addNotDirLane("Arista_9", 4, 9, 502);
		 * addNotDirLane("Arista_10", 9, 10, 40); addNotDirLane("Arista_11", 1,
		 * 10, 600);
		 * 
		 * //Grafo direccional volteado
		 * 
		 * addDirectionalLane("Arista_0", 1, 0, 85);
		 * addDirectionalLane("Arista_1", 2, 0, 217);
		 * addDirectionalLane("Arista_2", 4, 0, 173);
		 * addDirectionalLane("Arista_3", 6, 2, 186);
		 * addDirectionalLane("Arista_4", 7, 2, 103);
		 * addDirectionalLane("Arista_5", 7, 3, 183);
		 * addDirectionalLane("Arista_6", 8, 5, 250);
		 * addDirectionalLane("Arista_7", 9, 8, 84);
		 * addDirectionalLane("Arista_8", 9, 7, 167);
		 * addDirectionalLane("Arista_9", 9, 4, 502);
		 * addDirectionalLane("Arista_10", 10, 9, 40);
		 * addDirectionalLane("Arista_11", 10, 1, 600);
		 */

		// //

		// Lets check from location Loc_1 to Loc_10
		Grafo g = new Grafo(nodos, aristas);
		DijkstraAlgorithm dijkstra = new DijkstraAlgorithm(g);

		// Cantidad de caminos a elegir
		System.out.println("Ingrese la cantidad de caminos a buscar");
		r = sc.nextInt();

		for (int i = 0; i < r; i++) {
			// Elegir nodo incio
			//System.out.println("Agregar Nodo Inicio");
			//name=sc.next();
			dijkstra.execute(nodos.get(0));

			// Elegir nodo final
			//System.out.println("Agregar Nodo Destino");
			//name=sc.next();
			LinkedList<Nodo> path = dijkstra.getPath(nodos.get(3));

		
			for (Nodo nodo : path) {
				System.out.println(nodo);
			}
		}
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

  private static Nodo getName(String name, int N) {
	  Nodo a = null;
	  for (int i = 0; i < N; i++) {
			if (nodos.get(i).getName()   name) {
				a = nodos.get(i);
			}
	  }
		return a;
	}
} 
