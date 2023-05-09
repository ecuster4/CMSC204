import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.Set;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;


public class GraphTest_STUDENT {
	private GraphInterface<Town,Road> graph;
	private Town[] town;

	@Before
	public void setUp() throws Exception {
		 graph = new Graph();
		  town = new Town[12];
		  
		  for (int i = 1; i < 12; i++) {
			  town[i] = new Town("Town_" + i);
			  graph.addVertex(town[i]);
		  }
		  
		  graph.addEdge(town[1], town[2], 2, "Road_1");
		  graph.addEdge(town[1], town[3], 4, "Road_2");
		  graph.addEdge(town[1], town[5], 6, "Road_3");
		  graph.addEdge(town[3], town[7], 1, "Road_4");
		  graph.addEdge(town[3], town[8], 2, "Road_5");
		  graph.addEdge(town[4], town[8], 3, "Road_6");
		  graph.addEdge(town[6], town[9], 3, "Road_7");
		  graph.addEdge(town[9], town[10], 4, "Road_8");
		  graph.addEdge(town[8], town[10], 2, "Road_9");
		  graph.addEdge(town[5], town[10], 5, "Road_10");
		  graph.addEdge(town[10], town[11], 3, "Road_11");
		  graph.addEdge(town[2], town[11], 6, "Road_12");
	}

	@After
	public void tearDown() throws Exception {
		graph = null;
	}

	@Test
	public void testGetEdge() {
		assertEquals(new Road(town[1], town[5],6, "Road_3"), graph.getEdge(town[1], town[5]));
		assertEquals(new Road(town[5], town[10],5, "Road_10"), graph.getEdge(town[5], town[10]));
	}

	@Test
	public void testAddEdge() {
		assertEquals(false, graph.containsEdge(town[3], town[11]));
		graph.addEdge(town[3], town[5], 1, "Road_13");
		assertEquals(true, graph.containsEdge(town[5], town[10]));
	}

	@Test
	public void testAddVertex() {
		Town newTown = new Town("Town_14");
		assertEquals(false, graph.containsVertex(newTown));
		graph.addVertex(newTown);
		assertEquals(true, graph.containsVertex(newTown));
	}

	@Test
	public void testContainsEdge() {
		assertEquals(true, graph.containsEdge(town[1], town[5]));
		assertEquals(false, graph.containsEdge(town[6], town[11]));
	}

	@Test
	public void testContainsVertex() {
		assertEquals(true, graph.containsVertex(new Town("Town_6")));
		assertEquals(false, graph.containsVertex(new Town("Town_13")));
	}

	@Test
	public void testEdgeSet() {
		Set<Road> roads = graph.edgeSet();
		ArrayList<String> roadArrayList = new ArrayList<String>();
		for(Road road : roads)
			roadArrayList.add(road.getName());
		Collections.sort(roadArrayList);
		assertEquals("Road_11", roadArrayList.get(2));
		assertEquals("Road_12", roadArrayList.get(3));
		assertEquals("Road_10", roadArrayList.get(1));
		assertEquals("Road_3", roadArrayList.get(5));
		assertEquals("Road_4", roadArrayList.get(6));
		assertEquals("Road_7", roadArrayList.get(9));
	}

	@Test
	public void testEdgesOf() {
		Set<Road> roads = graph.edgesOf(town[3]);
		ArrayList<String> roadArrayList = new ArrayList<String>();
		for(Road road : roads)
			roadArrayList.add(road.getName());
		Collections.sort(roadArrayList);
		assertEquals("Road_4", roadArrayList.get(1));
		assertEquals("Road_5", roadArrayList.get(2));
		assertEquals("Road_2", roadArrayList.get(0));
	}
	
	@Test
	public void testRemoveEdge() {
		assertEquals(true, graph.containsEdge(town[3], town[8]));
		graph.removeEdge(town[10], town[11], 4, "Road_11");
		assertEquals(false, graph.containsEdge(town[10], town[11]));
	}
	
	@Test
	public void testRemoveVertex() {
		assertEquals(true, graph.containsVertex(town[4]));
		graph.removeVertex(town[4]);
		assertEquals(false, graph.containsVertex(town[4]));
	}

	@Test
	public void testVertexSet() {
		Set<Town> roads = graph.vertexSet();
		assertEquals(true,roads.contains(town[2]));
		assertEquals(true, roads.contains(town[5]));
		assertEquals(true, roads.contains(town[3]));
		assertEquals(true, roads.contains(town[4]));
		assertEquals(true, roads.contains(town[6]));
	}

	 @Test
	  public void testTown_4ToTown_10() {
		  String beginTown = "Town_4", endTown = "Town_10";
		  Town beginIndex=null, endIndex=null;
		  Set<Town> towns = graph.vertexSet();
		  Iterator<Town> iterator = towns.iterator();
		  while(iterator.hasNext())
		  {    	
			  Town town = iterator.next();
			  if(town.getName().equals(beginTown))
				  beginIndex = town;
			  if(town.getName().equals(endTown))
				  endIndex = town;		
		  }
		  if(beginIndex != null && endIndex != null)
		  {

			  ArrayList<String> path = graph.shortestPath(beginIndex,endIndex);
			  assertNotNull(path);
			  assertTrue(path.size() > 0);
			  assertEquals("Town_4 via Road_6 to Town_8 3 mi",path.get(0).trim());
			  assertEquals("Town_8 via Road_9 to Town_10 2 mi",path.get(1).trim());
		  }
		  else
			  fail("Town names are not valid");

	  }
	  
	  
	  @Test
	  public void testTown2ToTown_9() {
		  String beginTown = "Town_2", endTown = "Town_9";
		  Town beginIndex=null, endIndex=null;
		  Set<Town> towns = graph.vertexSet();
		  Iterator<Town> iterator = towns.iterator();
		  while(iterator.hasNext())
		  {    	
			  Town town = iterator.next();
			  if(town.getName().equals(beginTown))
				  beginIndex = town;
			  if(town.getName().equals(endTown))
				  endIndex = town;		
		  }
		  if(beginIndex != null && endIndex != null)
		  {

			  ArrayList<String> path = graph.shortestPath(beginIndex,endIndex);
			  assertNotNull(path);
			  assertTrue(path.size() > 0);
			  assertEquals("Town_2 via Road_12 to Town_11 6 mi",path.get(0).trim());
			  assertEquals("Town_11 via Road_11 to Town_10 3 mi",path.get(1).trim());
			  assertEquals("Town_10 via Road_8 to Town_9 4 mi",path.get(2).trim());
		  }
		  else
			  fail("Town names are not valid");

	  }
	  
	  @Test
	  public void testTown_3ToTown_11() {
		  String beginTown = "Town_3", endTown = "Town_11";
		  Town beginIndex=null, endIndex=null;
		  Set<Town> towns = graph.vertexSet();
		  Iterator<Town> iterator = towns.iterator();
		  while(iterator.hasNext())
		  {    	
			  Town town = iterator.next();
			  if(town.getName().equals(beginTown))
				  beginIndex = town;
			  if(town.getName().equals(endTown))
				  endIndex = town;		
		  }
		  if(beginIndex != null && endIndex != null)
		  {

			  ArrayList<String> path = graph.shortestPath(beginIndex,endIndex);
			  assertNotNull(path);
			  assertTrue(path.size() > 0);
			  assertEquals("Town_3 via Road_5 to Town_8 2 mi",path.get(0).trim());
			  assertEquals("Town_8 via Road_9 to Town_10 2 mi",path.get(1).trim());
			  assertEquals("Town_10 via Road_11 to Town_11 3 mi",path.get(2).trim());
		  }
		  else
			  fail("Town names are not valid");

	  }
}
