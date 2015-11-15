package Path;

import java.util.*;

class TSHPATH
{
	public static void main (String[] args){
		Scanner leo = new Scanner(System.in);        
        int t = leo.nextInt();
        
        for(int i = 0; i < t; i++)
        {
            HashMap<String, Integer> ciudades = new HashMap<String,Integer>();
            HashMap<Integer, Integer>  caminoMasCorto = new HashMap<Integer,Integer>();
            HashMap<Integer, HashMap<Integer, Integer>>  vecinos = new HashMap<Integer,HashMap<Integer, Integer>>();
            HashSet<Integer> vConocidos = new HashSet<Integer>();
            
            
            int cantCiudades = leo.nextInt();
            PriorityQueue<Integer> q = new PriorityQueue<Integer>(cantCiudades, new Comparator<Integer>()
            {
                public int compare(Integer p, Integer q)
                {
                    return caminoMasCorto.get(p) - caminoMasCorto.get(q);
                }
            });
            
            for(int j = 1; j <= cantCiudades; j++)
            {               
            	ciudades.put(leo.next(), j);
                int nVecino = leo.nextInt();
                HashMap<Integer, Integer> pesos = new HashMap<Integer, Integer>(); 
                for(int k = 0; k < nVecino; k++)
                {
                    
                	pesos.put(leo.nextInt(), leo.nextInt());
                }

                vecinos.put(j, pesos);
            }
            int vRestantes = leo.nextInt();
            
            for(int j = 0; j < vRestantes; j++)
            {
                for(int k = 1; k <= cantCiudades; k++)
                {
                	caminoMasCorto.put(k, Integer.MAX_VALUE);
                }
                vConocidos.clear();
                String from = leo.next();
                caminoMasCorto.put(ciudades.get(from), 0);
                q.add(ciudades.get(from));
                String to = leo.next();
                int v2 = ciudades.get(to);

                while(!q.isEmpty())
                {

                    int vActual = q.remove();
                    if(vActual == v2)
                    {
                     break;   
                    }
                    vConocidos.add(vActual);
                    HashMap<Integer, Integer> weights = vecinos.get(vActual);
                    
                    for(int vecino : weights.keySet())
                    {
                        int fromHereToNeighbour = caminoMasCorto.get(vActual) + weights.get(vecino);
                        if(fromHereToNeighbour < caminoMasCorto.get(vecino))
                        {
                        	caminoMasCorto.put(vecino, fromHereToNeighbour);
                        }
                        if(!vConocidos.contains(vecino))
                        {
                        q.add(vecino);
                        }
                        
                    }
                    
                }

                System.out.println(caminoMasCorto.get(v2));
                
            }
            
        }leo.close();
	}
}