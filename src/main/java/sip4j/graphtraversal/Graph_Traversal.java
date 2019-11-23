package sip4j.graphtraversal;

import sip4j.graphconstruction.LabeledEdge;
import sip4j.graphstructure.E_ClassGraphs;
import sip4j.graphstructure.E_MethodGraph;
import sip4j.graphstructure.E_MVertice;
import sip4j.graphstructure.E_PackGraphs;
import sip4j.graphutilities.Graph_Generator;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Set;

import org.jgrapht.DirectedGraph;


public class Graph_Traversal {
	
public static void TraverseGraph(){
		 
	E_PackGraphs gpkg = Graph_Generator.getPackage();

	LinkedList<E_ClassGraphs> _gclass = gpkg.getClasses();
	
	for(E_ClassGraphs _class: _gclass){
		
		LinkedList<E_MethodGraph> mgraphs = _class.getMethodgraphs();
	
		for(E_MethodGraph graph: mgraphs){
		
		//System.out.println("Graph Which is going to be traversed = "+graph.getMgraphName());
		
		DirectedGraph<E_MVertice, LabeledEdge> gg = graph.getMethodgraph();
		
		Iterator<E_MVertice> it = gg.vertexSet().iterator();
	
		if(it != null){
			
			while(it.hasNext()) {	
				
				 //E_MVertice obj = null;

				 //obj  = new E_MVertice();
			
		 	       E_MVertice vertex = it.next();
		 	     
			 	   /* if(vertex.equalsIgnoreCase("foo") || vertex.equalsIgnoreCase("context")){
						
					}
			 	    else{*/
			 	    	//obj.setVName(vertex);
			 	    	
			 	    	//System.out.println(""+vertex.values().toString());
			 	    	
						if(gg.outgoingEdgesOf(vertex) != null){
							
							Set<LabeledEdge> outEdges = gg.outgoingEdgesOf(vertex);
							
							//obj.setOutgoingEdges(outEdges);
						}
						if(gg.incomingEdgesOf(vertex) != null){
							
							Set<LabeledEdge> inEdges = gg.incomingEdgesOf(vertex);
						
							//obj.setIncomingEdges(inEdges);
						}
						// AddGraphVertex(graph, obj);	
			 	    }
			 	 }
		 }
	  }
	}
   

	/*private static void AddGraphVertex(E_MethodGraph graph, E_MVertice obj) {
	
		graph.addVertices(obj);
		
	}*/
}