package it.polito.tdp.metroparis.model;

import java.util.*;

import org.jgrapht.*;
import org.jgrapht.graph.DefaultEdge;
import org.jgrapht.graph.SimpleGraph;

public class ProvaGrafo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Graph<String,DefaultEdge> grafo = new SimpleGraph<>(DefaultEdge.class);
		
		grafo.addVertex("UNO");
		grafo.addVertex("DUE");
		grafo.addVertex("TRE");
		
		grafo.addEdge("UNO", "TRE");
		grafo.addEdge("DUE", "TRE");
		grafo.addEdge("UNO", "DUE");
		
		System.out.println(grafo);
		
		Model m = new Model();
		
		m.creaGrafo();
		
		Fermata p = m.trovaFermata("La Fourche");
		if(p==null) {
			System.out.println("fermata non trovata");
		}else {
			List<Fermata> raggiungibiliBFV = m.fermateRaggiungibiliBFV(p);
		//	List<Fermata> raggiungibiliDFV = m.fermateRaggiungibiliDFV(p);
			System.out.println(raggiungibiliBFV);
		//	System.out.println(raggiungibiliDFV);
		}
		// e li stampa ovviamente per livello : PERCHE NOI ABBIAMO FATTO UNA VISITA IN AMPIEZZZA ( BreadthFirstIterator() )
		// 1,1,1,2,2,2,3,3,3,3,3,4,4,4,.....
		// e li stampa ovviamente non per livello : PERCHE NOI ABBIAMO FATTO UNA VISITA IN PROFONDITà ( DepthFirstIterator() )
				// 1,2,3,4,5,6,7,1,2,3,4,5,1,2,3,1,2,3,4,5,6,7,8,9....
		Fermata a = m.trovaFermata("Temple");
		
		List<Fermata> percorso = m.trovaCammino(p, a);
		System.out.println(percorso);
	}

}
