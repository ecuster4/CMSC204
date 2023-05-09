import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;


public class TownGraphManagerTest_STUDENT {
	private TownGraphManagerInterface graph;
	private String[] town;
	  
	@Before
	public void setUp() throws Exception {
		  graph = new TownGraphManager();
		  town = new String[12];
		  
		  for (int i = 1; i < 12; i++) {
			  town[i] = "Town_" + i;
			  graph.addTown(town[i]);
		  }
		  
		  graph.addRoad(town[1], town[2], 2, "Road_1");
		  graph.addRoad(town[1], town[3], 4, "Road_2");
		  graph.addRoad(town[1], town[5], 6, "Road_3");
		  graph.addRoad(town[3], town[7], 1, "Road_4");
		  graph.addRoad(town[3], town[8], 2, "Road_5");
		  graph.addRoad(town[4], town[8], 3, "Road_6");
		  graph.addRoad(town[6], town[9], 3, "Road_7");
		  graph.addRoad(town[9], town[10], 4, "Road_8");
		  graph.addRoad(town[8], town[10], 2, "Road_9");
		  graph.addRoad(town[5], town[10], 5, "Road_10");
		  graph.addRoad(town[10], town[11], 3, "Road_11");
		  graph.addRoad(town[2], town[11], 6, "Road_12");
		 
	}

	@After
	public void tearDown() throws Exception {
		graph = null;
	}

	@Test
	public void testAddRoad() {
		ArrayList<String> roads = graph.allRoads();
		assertEquals("Road_3", roads.get(5));
		assertEquals("Road_4", roads.get(6));
		assertEquals("Road_5", roads.get(7));
		assertEquals("Road_6", roads.get(8));
		graph.addRoad(town[5], town[1], 3,"Road_15");
		roads = graph.allRoads();
		assertEquals("Road_2", roads.get(5));
		assertEquals("Road_6", roads.get(8));
		assertEquals("Road_7", roads.get(9));
		assertEquals("Road_10", roads.get(1));
		assertEquals("Road_15", roads.get(4));
		
	}

	@Test
	public void testGetRoad() {
		assertEquals("Road_7", graph.getRoad(town[6], town[9]));
		assertEquals("Road_3", graph.getRoad(town[1], town[5]));
	}

	@Test
	public void testAddTown() {
		assertEquals(false, graph.containsTown("Town_15"));
		graph.addTown("Town_15");
		assertEquals(true, graph.containsTown("Town_15"));
	}
	
	@Test
	public void testDisjointGraph() {
		assertEquals(false, graph.containsTown("Town_13"));
		graph.addTown("Town_13");
		ArrayList<String> path = graph.getPath(town[1],"Town_13");
		assertFalse(path.size() > 0);
	}

	@Test
	public void testContainsTown() {
		assertEquals(true, graph.containsTown("Town_3"));
		assertEquals(false, graph.containsTown("Town_14"));
	}

	@Test
	public void testContainsRoadConnection() {
		assertEquals(true, graph.containsRoadConnection(town[2], town[11]));
		assertEquals(false, graph.containsRoadConnection(town[3], town[5]));
	}

	@Test
	public void testAllRoads() {
		ArrayList<String> roads = graph.allRoads();
		assertEquals("Road_1", roads.get(0));
		assertEquals("Road_10", roads.get(1));
		assertEquals("Road_11", roads.get(2));
		assertEquals("Road_8", roads.get(10));
		assertEquals("Road_9", roads.get(11));
	}

	@Test
	public void testDeleteRoadConnection() {
		assertEquals(true, graph.containsRoadConnection(town[8], town[10]));
		graph.deleteRoadConnection(town[2], town[11], "Road_12");
		assertEquals(false, graph.containsRoadConnection(town[5], town[7]));
	}

	@Test
	public void testDeleteTown() {
		assertEquals(true, graph.containsTown("Town_1"));
		graph.deleteTown(town[1]);
		assertEquals(false, graph.containsTown("Town_1"));
	}
	
	@Test
	public void testAllTowns() {
		ArrayList<String> roads = graph.allTowns();
		assertEquals("Town_3", roads.get(4));
		assertEquals("Town_5", roads.get(6));
		assertEquals("Town_4", roads.get(5));
		assertEquals("Town_7", roads.get(8));
		assertEquals("Town_6", roads.get(7));
	}

	@Test
	public void testGetPath() {
		ArrayList<String> path = graph.getPath(town[2],town[8]);
		  assertNotNull(path);
		  assertTrue(path.size() > 0);
		  assertEquals("Town_2 via Road_1 to Town_1 2 mi",path.get(0).trim());
		  assertEquals("Town_1 via Road_2 to Town_3 4 mi",path.get(1).trim());

	}
	
	@Test
	public void testGetPathA() {
		ArrayList<String> path = graph.getPath(town[1],town[7]);
		  assertNotNull(path);
		  assertTrue(path.size() > 0);
		  assertEquals("Town_1 via Road_2 to Town_3 4 mi",path.get(0).trim());
		  assertEquals("Town_3 via Road_4 to Town_7 1 mi",path.get(1).trim());
	}
	
	@Test
	public void testGetPathB() {
		ArrayList<String> path = graph.getPath(town[2],town[9]);
		  assertNotNull(path);
		  assertTrue(path.size() > 0);
		  assertEquals("Town_2 via Road_12 to Town_11 6 mi",path.get(0).trim());
		  assertEquals("Town_11 via Road_11 to Town_10 3 mi",path.get(1).trim());
		  assertEquals("Town_10 via Road_8 to Town_9 4 mi",path.get(2).trim());
	}

}
