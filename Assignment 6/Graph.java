import java.util.ArrayList;
import java.util.Set;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/**
 * 
 * @author Andy Nguyen
 *
 */
public class Graph implements GraphInterface{
	private int[] distance;
	private ArrayList<String>town;
	private String[] previous;
	HashMap<String, HashMap<String,Road>> h = new HashMap<String, HashMap<String, Road>>();
	/**
	 * @param sourceVertex
	 * @param destinationVertex
	 * @return h or null
	 */
	public Object getEdge(Object sourceVertex, Object destinationVertex) {
		// TODO Auto-generated method stub
		Town sV = (Town) sourceVertex;
		Town dV = (Town) destinationVertex;
		try {
			return(Road) h.get((sV).getName()).get((dV).getName());
			
		}catch (Exception e) {
			return null;
		}
		
	}

	@Override
	/**
	 * @param sourceVertex
	 * @param destinationVertex
	 * @param weight
	 * @param 	public
	 * @throws IllegalArgumentException
	 * @throws NullPointerException
	 * @return edge
	 */
	public Object addEdge(Object sourceVertex, Object destinationVertex, int weight, String description) {
		// TODO Auto-generated method stub
		
		Town sV = (Town) sourceVertex;
		Town dV = (Town) destinationVertex;
		
	//	Object h1 = h.containsKey(sV.getName());
	//	Object h2 = h.containsKey(dV.getName());
		if(!h.containsKey(sV.getName()) && !h.containsKey(dV.getName())) {
			throw new IllegalArgumentException();
		}
		else if ( sV == null || dV == null)
		{
			throw new NullPointerException();
		}
		else {
			Road edge = new Road(sV,dV,weight,description);
			h.get(sV.getName()).put(dV.getName(), edge);
			h.get(dV.getName()).put(sV.getName(), edge);
			return edge;
		}
		
	}

	@Override
	/**
	 * @param v
	 * @throws NullPointerException
	 * @returns false or true
	 */
	public boolean addVertex(Object v) {
		// TODO Auto-generated method stub
		    if (v == null) {
		        throw new NullPointerException();
		    }
		    
		    Town town = (Town) v;
		    if (h.putIfAbsent(town.getName(), new HashMap<String, Road>()) != null) {
		        return false;
		    }
		    else {
		    h.get(town.getName()).put(town.getName(), null);
		    return true;
		    }
		
	}

	@Override
	/**
	 * @param sourceVertex
	 * @param destinationVertex
	 * @return true or false
	 */
	public boolean containsEdge(Object sourceVertex, Object destinationVertex) {
		// TODO Auto-generated method stub
		Town sV = (Town) sourceVertex;
		Town dV = (Town) destinationVertex;
		try {
			if (h.get((sV).getName()).get((dV).getName()) != null) {
				
			return true;}
		}catch (Exception e) {
			return false;
		}
		return false;
	}
		
	
	@Override
	/**
	 * @param v
	 * @return true or false
	 */
	public boolean containsVertex(Object v) {
		// TODO Auto-generated method stub
		Town t = (Town) v;
			if (h.containsKey((t).getName())) {
		return true;}
			return false;
	}

	@Override
	/**
	 * @return edges
	 */
	public Set<Road> edgeSet() {
	    Set<Road> edges = new HashSet<>();
	    for (Map<String, Road> map : h.values()) {
	        edges.addAll(map.values());
	    }
	    edges.remove(null);
	    return edges;
	}

	@Override
	/**
	 * @param vertex
	 * @throw NullPointerException
	 * @throw IllegalArgumentException
	 * @return edges
	 */
	public Set<Road> edgesOf(Object vertex) {
	    if (vertex == null) {
	        throw new NullPointerException("Vertex cannot be null");
	    }

	    if (!(vertex instanceof Town)) {
	        throw new IllegalArgumentException("Vertex must be an instance of Town");
	    }

	    Town town = (Town) vertex;

	    if (!h.containsKey(town.getName())) {
	        throw new IllegalArgumentException("Town not found in the adjacency matrix");
	    }

	    Map<String, Road> adjacentTowns = h.get(town.getName());
	    Set<Road> edges = new HashSet<>(adjacentTowns.values());
	    edges.removeIf(Objects::isNull);

	    return edges;
	}

	@Override
	/**
	 * @param sourceVertex
	 * @param destinationVertex
	 * @param weight
	 * @param description
	 * @return road or null
	 */
	public Object removeEdge(Object sourceVertex, Object destinationVertex, int weight, String description) {
		// TODO Auto-generated method stub
		
		if (weight > -1 && description != null) {
			Town sV = (Town) sourceVertex;
			Town dV = (Town) destinationVertex;
			Road road = h.get(sV.getName()).get(dV.getName());
			h.get(sV.getName()).put(dV.getName(), null);
			h.get(dV.getName()).put(sV.getName(), null);
			return road;
		}
		return null;

	}

	@Override
	/**
	 * @param v
	 * @return false or true
	 */
	public boolean removeVertex(Object v) {
		// TODO Auto-generated method stub
		Town t = (Town) v;
		if( v == null || !h.containsKey(t.getName())) {
		return false;
		}
		else 
			h.remove(t.getName());
			return true;
		
		
	}

	@Override
	/**
	 * @return road
	 */
	public Set vertexSet() {
		// TODO Auto-generated method stub
		Set<Town> road = new HashSet<Town>();
		for (String keys : h.keySet()) {
			road.add(new Town(keys));
		}
		return road;
	
	}

	@Override
	/**
	 * @param sourceVertex
	 * @param destinationVertex
	 * @return finalPath
	 */
	public ArrayList shortestPath(Object sourceVertex, Object destinationVertex) {
		// TODO Auto-generated method stub
		dijkstraShortestPath(sourceVertex);
		Town dV = (Town) destinationVertex;
	    List<String> pathway = new ArrayList<>();
	    List<Integer> pWeight = new ArrayList<>();
	    List<Town> vS = new ArrayList<>(vertexSet());
	    

	    int destIndex = vS.indexOf(dV);
	    pathway.add(dV.getName());
	    while (previous[destIndex] != null) {
	    	pathway.add(previous[destIndex]);
	        pWeight.add(distance[destIndex]);
	        destIndex = vS.indexOf(new Town(previous[destIndex]));
	    }

	    Collections.reverse(pathway);
	    Collections.reverse(pWeight);
	    ArrayList fin = new ArrayList<>();
	    int runningCount = 0;
	    for (int i = 0; i < pathway.size() - 1; i++) {
	        Town town1 = new Town(pathway.get(i));
	        Town town2 = new Town(pathway.get(i + 1));
	        Road road = (Road) this.getEdge(town1, town2);
	        int weight = pWeight.get(i) - runningCount;
	        fin.add(String.format("%s via %s to %s %d mi", town1.getName(), road.getName(), town2.getName(), weight));
	        runningCount += weight;
	    }

	    return fin;
	}

	@Override
	/**
	 * @param sourceVertex
	 * 
	 */
	public void dijkstraShortestPath(Object sourceVertex) {
		String sV = ((Town) sourceVertex).getName();
		List<Town> vS = new ArrayList<Town>(vertexSet());
		town = new ArrayList<String>();
		ArrayList<String> unvisited = new ArrayList<String>();
		for (Town vert : vS) {
			town.add(vert.getName());
			unvisited.add(vert.getName());
		}
		distance = new int[town.size()];
		previous = new String[town.size()];
		Arrays.fill(distance, Integer.MAX_VALUE);
		distance[town.indexOf(sV)] = 0;
		while (!unvisited.isEmpty()) {
			HashMap<String, Road> connected_nodes = h.get(sV);
			for (String t : connected_nodes.keySet()) {
				if (unvisited.indexOf(t) != -1 && connected_nodes.get(t) != null) {
					int i = town.indexOf(t);
					int cI = town.indexOf(sV);
					int weight = connected_nodes.get(t).getWeight();
					if (distance[cI] + weight < distance[i]) {
						distance[i] = weight + distance[cI];
						previous[i] = sV;
					}

				}

			}
			unvisited.remove(unvisited.indexOf(sV));
			if(unvisited.isEmpty()) {
				break;
			}
			int shortest = Integer.MAX_VALUE;
			int shortest_ind = -1;
			for (String t : unvisited) {
				int ind = town.indexOf(t);
				if (distance[ind] < shortest) {
					shortest = distance[ind];
					shortest_ind = ind;
				}
			}
			
			if(shortest_ind== -1) {
	
				break;
			}
			sV = town.get(shortest_ind);

		}

	}




}
