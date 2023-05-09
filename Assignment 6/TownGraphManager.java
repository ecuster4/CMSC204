import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class TownGraphManager implements TownGraphManagerInterface {
	private Graph graph = new Graph();
	
	@Override
	public boolean addRoad(String town1, String town2, int weight, String roadName) {
		// TODO Auto-generated method stub
		Town t1 = new Town(town1);
		Town t2 = new Town(town2);
		if(graph.addEdge(t1,t2,weight,roadName) !=null) {
			return true;
		}
		return false;
	}
	
	
	@Override
	public String getRoad(String town1, String town2) {
		// TODO Auto-generated method stub
		Town t1 = new Town(town1);
		Town t2 = new Town(town2);
		return ((Road) graph.getEdge(t1,t2)).getName();
	}

	
	@Override
	public boolean addTown(String v) {
		// TODO Auto-generated method stub
		Town t = new Town(v);
		boolean g = graph.addVertex(t);
		return g;
	}
	
	@Override
	public Town getTown(String name) {
		// TODO Auto-generated method stub
		Town n = new Town(name);
		return n;
	}
	
	@Override
	public boolean containsTown(String v) {
		// TODO Auto-generated method stub
		Town t = new Town(v);
		boolean g = graph.containsVertex(t);
		return g;
		
	}
	
	@Override
	public boolean containsRoadConnection(String town1, String town2) {
		// TODO Auto-generated method stub
		Town t1 = new Town(town1);
		Town t2 = new Town(town2);
		boolean g = graph.containsEdge(t1, t2);
		return g;
	}

	@Override
	public ArrayList<String> allRoads() {
		// TODO Auto-generated method stub
		ArrayList<Road> rRoad = new ArrayList<Road>(graph.edgeSet());
		ArrayList<String>sRoad = new ArrayList<String>();
		for(Road road : rRoad) {
			sRoad.add(road.getName());
		}
		Collections.sort(sRoad);
		return sRoad;
	}

	@Override
	public boolean deleteRoadConnection(String town1, String town2, String road) {
		// TODO Auto-generated method stub\
		Town t1 = new Town(town1);
		Town t2 = new Town(town2);
		int weight = 0;
		if (graph.removeEdge(t1, t2, weight, road)!=null) {
			return true;
		}
		else
		 return false;
	}

	@Override
	public boolean deleteTown(String v) {
		// TODO Auto-generated method stub
		Town t = new Town(v);
		boolean g = graph.removeVertex(t);
		return g;
	}

	@Override
	public ArrayList<String> allTowns() {
		// TODO Auto-generated method stub
		ArrayList<Town> tTown = new ArrayList<Town>(graph.vertexSet());
		ArrayList<String>sTown = new ArrayList<String>();
		for(Town town : tTown) {
			sTown.add(town.getName());
		}
		Collections.sort(sTown);
		return sTown;
		
	}

	@Override
	public ArrayList<String> getPath(String town1, String town2) {
		// TODO Auto-generated method stub
		Town t1 = new Town(town1);
		Town t2 = new Town(town2);
		ArrayList g = graph.shortestPath(t1,t2);
		return g;
	}
	
	public void populateTownGraph(File selectedFile) throws FileNotFoundException, IOException{
		Scanner i=new Scanner(selectedFile);
		Town t1,t2;
		String l="";
		String[] s;
		while(i.hasNext()) {
			l=i.nextLine();
			s=l.split("[,;]");
			t2=new Town(s[3]);
			t1=new Town(s[2]);
			graph.addVertex(t1);
			graph.addVertex(t2);
			graph.addEdge(t1, t2, Integer.parseInt(s[1]), s[0]);
		}
	}
}
