/* 
 * Homework 6
 * Graph.java - contains methods Nearest Neighbor and Brute Force
 */

import java.util.Collection; 
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.stream.Collectors;

public class Graph {

	// Keep a fast index to nodes in the map
	private Map<Integer, Vertex> vertexNames;

	/**
	 * Construct an empty Graph with a map. The map's key is the name of a vertex
	 * and the map's value is the vertex object.
	 */
	public Graph() {
		vertexNames = new HashMap<>();
	}

	/**
	 * Adds a vertex to the graph. Throws IllegalArgumentException if two vertices
	 * with the same name are added.
	 * 
	 * @param v
	 *          (Vertex) vertex to be added to the graph
	 */
	public void addVertex(Vertex v) {
		if (vertexNames.containsKey(v.name))
			throw new IllegalArgumentException("Cannot create new vertex with existing name.");
		vertexNames.put(v.name, v);
	}

	/**
	 * Gets a collection of all the vertices in the graph
	 * 
	 * @return (Collection<Vertex>) collection of all the vertices in the graph
	 */
	public Collection<Vertex> getVertices() {
		return vertexNames.values();
	}

	/**
	 * Gets the vertex object with the given name
	 * 
	 * @param name
	 *          (String) name of the vertex object requested
	 * @return (Vertex) vertex object associated with the name
	 */
	public Vertex getVertex(int name) {
		return vertexNames.get(name);
	}

	/**
	 * Adds a directed edge from vertex u to vertex v
	 * 
	 * @param nameU
	 *          (String) name of vertex u
	 * @param nameV
	 *          (String) name of vertex v
	 * @param cost
	 *          (double) cost of the edge between vertex u and v
	 */
	public void addEdge(int nameU, int nameV, Double cost) {
		if (!vertexNames.containsKey(nameU))
			throw new IllegalArgumentException(nameU + " does not exist. Cannot create edge.");
		if (!vertexNames.containsKey(nameV))
			throw new IllegalArgumentException(nameV + " does not exist. Cannot create edge.");
		Vertex sourceVertex = vertexNames.get(nameU);
		Vertex targetVertex = vertexNames.get(nameV);
		Edge newEdge = new Edge(sourceVertex, targetVertex, cost);
		sourceVertex.addEdge(newEdge);
	}

	/**
	 * Adds an undirected edge between vertex u and vertex v by adding a directed
	 * edge from u to v, then a directed edge from v to u
	 * 
	 * @param name
	 *          (String) name of vertex u
	 * @param name2
	 *          (String) name of vertex v
	 * @param cost
	 *          (double) cost of the edge between vertex u and v
	 */
	public void addUndirectedEdge(int name, int name2, double cost) {
		if (!vertexNames.get(name).adjacentEdges.contains(vertexNames.get(name2)))
			addEdge(name, name2, cost);
		if (!vertexNames.get(name2).adjacentEdges.contains(vertexNames.get(name)))
			addEdge(name2, name, cost);
	}


	/**
	 * Computes the euclidean distance between two points as described by their
	 * coordinates
	 * 
	 * @param ux
	 *          (double) x coordinate of point u
	 * @param uy
	 *          (double) y coordinate of point u
	 * @param vx
	 *          (double) x coordinate of point v
	 * @param vy
	 *          (double) y coordinate of point v
	 * @return (double) distance between the two points
	 */
	public double computeEuclideanDistance(double ux, double uy, double vx, double vy) {
		return Math.sqrt(Math.pow(ux - vx, 2) + Math.pow(uy - vy, 2));
	}

	/**
	 * Computes euclidean distance between two vertices as described by their
	 * coordinates
	 * 
	 * @param u
	 *          (Vertex) vertex u
	 * @param v
	 *          (Vertex) vertex v
	 * @return (double) distance between two vertices
	 */
	public double computeEuclideanDistance(Vertex u, Vertex v) {
		return computeEuclideanDistance(u.x, u.y, v.x, v.y);
	}

	/**
	 * Calculates the euclidean distance for all edges in the map using the
	 * computeEuclideanCost method.
	 */
	public void computeAllEuclideanDistances() {
		for (Vertex u : getVertices()){
			for (Edge uv : u.adjacentEdges) {
				Vertex v = uv.target;
				uv.distance = computeEuclideanDistance(u.x, u.y, v.x, v.y);
			}
		}
	}

	// STUDENT CODE STARTS HERE
	public List<Vertex> allVerticesNotVisited;

	public void generateRandomVertices(int n) {
		vertexNames = new HashMap<>(); // reset the vertex hashmap
		allVerticesNotVisited = new ArrayList<>();
		for (int i = 0; i < n; i++){
			int x = (int) (Math.random() * 101);
			int y = (int) (Math.random() * 101);
			Vertex vertex = new Vertex(i+1, x, y);
			addVertex(vertex);
		}
		for (int u : vertexNames.keySet()){
			for (int k : vertexNames.keySet()){
				if (k != u){
					Vertex i = vertexNames.get(k);
					Vertex j = vertexNames.get(u);
					double tmp = computeEuclideanDistance(i,j);
					addUndirectedEdge(u,k,tmp);
				}
			}
		}

		for (Vertex u : vertexNames.values()){
			allVerticesNotVisited.add(u);
		}
		System.out.println(allVerticesNotVisited);
	}


	public List<Edge> nearestNeighborTsp() {

		//Removes double adjacent edges from adjacentEdges List for each vertex
		for (int k = 0; k < allVerticesNotVisited.size(); k++){
			Vertex ver = allVerticesNotVisited.get(k);
			for (int j = 0; j < ver.adjacentEdges.size(); j++){
				Edge check = ver.adjacentEdges.get(j);
				for (int i = j+1; i < ver.adjacentEdges.size(); i++){
					Edge repeated = ver.adjacentEdges.get(i);
					if (repeated.distance == check.distance){
						ver.adjacentEdges.remove(repeated);
					}
				}
			}
		}

		List<Vertex> vertices = new ArrayList<>(allVerticesNotVisited);
		List<Vertex> allVertices = new ArrayList<>(allVerticesNotVisited);
		List<Edge> path = new ArrayList<>();
		List<Double> costs = new ArrayList<>();

		Vertex nextVertex = null;
		double smallestSoFar = 100000000;

		for (int i = 0; i < allVertices.size(); i++){
			Vertex start = allVertices.get(i);
			//clear path for next permutation
			path.clear();

			//reset nextVertex
			nextVertex = null;
			//get first nearest vertex
			for (int k = 0; k < start.adjacentEdges.size(); k++){
				if (start.adjacentEdges.get(k).distance < smallestSoFar && 
						!start.adjacentEdges.get(k).target.visited){
					nextVertex = start.adjacentEdges.get(k).target;
					smallestSoFar = start.adjacentEdges.get(k).distance;
				}
			}

			//Mark nextVertex as visited
			nextVertex.visited = true;

			//Remove the nextVertex from the list of vertices
			vertices.remove(nextVertex);

			//Add edge to list of paths
			for (int k = 0; k < start.adjacentEdges.size(); k++){
				if (start.adjacentEdges.get(k).target.equals(nextVertex)){
					path.add(0, start.adjacentEdges.get(k));
				}  
			}

			Vertex nextVertex2 = null;

			while (vertices.size() > 1){
				//get nearest vertex to that one
				nextVertex2 = getNearestVertex(nextVertex, start);
				//mark as visited
				nextVertex2.visited = true;
				//remove it from the list
				vertices.remove(nextVertex2);

				//Add edge to list of paths
				for (int k = 0; k < nextVertex.adjacentEdges.size(); k++){
					if (nextVertex.adjacentEdges.get(k).target.equals(nextVertex2)){
						path.add(path.size(), nextVertex.adjacentEdges.get(k));
					}
				}
				nextVertex = nextVertex2;
			}

			//now vertices.size() is 1
			//Add edge from last vertex to start vertex
			for (int k = 0; k < nextVertex.adjacentEdges.size(); k++){
				if (nextVertex.adjacentEdges.get(k).target.equals(start))
					path.add(path.size(), nextVertex.adjacentEdges.get(k));
			}

			//Calculate distance cost of path and add to list
			costs.add(costs.size(), calculateDistance(path));

			//remove start vertex from vertices
			vertices.clear();

			//set start vertex to not visited, jic
			start.visited = false;

			vertices.addAll(allVerticesNotVisited);
			//make all vertices not visited (reset) and add them all to vertices again
			for (int w = 0; w < vertices.size(); w++){
				vertices.get(w).visited = false;
			}
			//reset smallestSoFar
			smallestSoFar = 100000000;
		}

		/* Iterate through costs list, and get the same index of the smallest cost 
		 * from the lists of lists of paths, and im done :) 
		 */
		smallestSoFar = 10000000;
		int idxToremove = 0;
		for (int i = 0; i < costs.size(); i++){
			if (costs.get(i) < smallestSoFar){
				smallestSoFar = costs.get(i);
				idxToremove = i;
			}
		}

		//index to remove + 1 = starting vertex of path.
		//get path for that vertex (or rather, create path)

		nextVertex = null;
		smallestSoFar = 100000000;
		vertices.clear();
		vertices.addAll(allVerticesNotVisited);

		//make all vertices not visited (reset)
		for (int w = 0; w < vertices.size(); w++){
			vertices.get(w).visited = false;
		}

		Vertex start = allVertices.get(idxToremove);
		//clear path for next permutation
		path.clear();

		//reset nextVertex
		nextVertex = null;
		//get first nearest vertex
		for (int k = 0; k < start.adjacentEdges.size(); k++){
			if (start.adjacentEdges.get(k).distance < smallestSoFar && 
					!start.adjacentEdges.get(k).target.visited){
				nextVertex = start.adjacentEdges.get(k).target;
				smallestSoFar = start.adjacentEdges.get(k).distance;
			}
		}

		//Mark nextVertex as visited
		nextVertex.visited = true;

		//Remove the nextVertex from the list of vertices
		vertices.remove(nextVertex);

		//Add edge to list of paths
		for (int k = 0; k < start.adjacentEdges.size(); k++){
			if (start.adjacentEdges.get(k).target.equals(nextVertex)){
				path.add(0, start.adjacentEdges.get(k));
			}  
		}

		Vertex nextVertex2 = null;

		while (vertices.size() > 1){
			//get nearest vertex to that one
			nextVertex2 = getNearestVertex(nextVertex, start);
			//mark as visited
			nextVertex2.visited = true;
			//remove it from the list
			vertices.remove(nextVertex2);

			//Add edge to list of paths
			for (int k = 0; k < nextVertex.adjacentEdges.size(); k++){
				if (nextVertex.adjacentEdges.get(k).target.equals(nextVertex2)){
					path.add(path.size(), nextVertex.adjacentEdges.get(k));
				}
			}
			nextVertex = nextVertex2;
		}

		//now vertices.size() is 1
		//Add edge from last vertex to start vertex
		for (int k = 0; k < nextVertex.adjacentEdges.size(); k++){
			if (nextVertex.adjacentEdges.get(k).target.equals(start))
				path.add(path.size(), nextVertex.adjacentEdges.get(k));
		}
		return path;
	}

	public double calculateDistance(List<Edge> path){
		double cost = 0;
		for (int i = 0; i < path.size(); i++){
			Edge u = path.get(i);
			cost = cost + u.distance;
		}
		return cost;
	}

	public Vertex getNearestVertex (Vertex v, Vertex start){
		double smallestSoFar = 10000000;
		Vertex nextVertex = null;

		Edge addBack = null;
		//Remove starting vertex from adjacent edges
		//Go through v's adjacent edges until the target vertex is the start
		for (int i = 0; i < v.adjacentEdges.size(); i++){
			if (v.adjacentEdges.get(i).target.equals(start)){
				addBack = v.adjacentEdges.remove(i);
			}
		}

		//get nearest vertex	  
		for (int k = 0; k < v.adjacentEdges.size(); k++){
			if (v.adjacentEdges.get(k).distance < smallestSoFar && !v.adjacentEdges.get(k).target.visited){
				nextVertex = v.adjacentEdges.get(k).target;
				smallestSoFar = v.adjacentEdges.get(k).distance;
			}
		}
		//add edge back
		v.adjacentEdges.add(addBack);

		return nextVertex;
	}

	public List<Edge> bruteForceTsp() {
	    List<Edge> path = new ArrayList<>();
	    List<Vertex> vertices = new ArrayList<>();

	    //Add all the vertices into vertices list
	    for (Vertex v: getVertices()) {
	      vertices.add(v);
	    }
	 
	    List<Vertex> smallestPath = null;
	    List<List<Vertex>> perM = calcPerM(vertices);
	    List<List<Vertex>> perMwEnd = addEndPos(perM);
	    Double smallestDistance = 1000000000.0;
	    Double distance = 0.0;

	    //next we loop through the list of perM and calculate the distances between all the vertices in each list
	    //after we finish calculating the distances, we compare and save the list that had the smallest path and save it
	    for (int i = 0; i < perM.size(); i++) {
	      List<Vertex> vertex = perM.get(i);
	      for (int j = 0; j < vertex.size() - 1; j++) {
	        distance = distance + computeEuclideanDistance(vertex.get(j), vertex.get(j+1));
	      }
	      if (distance < smallestDistance) {
	        smallestDistance = distance;
	        smallestPath = vertex;
	      }
	    }

	    //Go through the smallest path list
	    for (int i = 0; i < smallestPath.size() - 1; i++) {
	      Vertex vertex1 = smallestPath.get(i);
	      Vertex vertex2 = smallestPath.get(i + 1);
	      //make edges btwn vertices
	      Edge e = new Edge(vertex1, vertex2, computeEuclideanDistance(vertex1,vertex2));
	      path.add(e);
	    }
	    return path;
	  }


  public List<List<Vertex>> calcPerM(List<Vertex> list) {
    if (list.size() == 0) {
      List<List<Vertex>> result = new ArrayList<>();
      result.add(new ArrayList<>());
      return result;
    }

    Vertex firstElement = list.remove(0);
    List<List<Vertex>> returnValue = new ArrayList<>();

    List<List<Vertex>> perM = calcPerM(list);

    for (List<Vertex> smaller: perM) {
      for (int index = 0; index <= smaller.size(); index++) {
        List<Vertex> temp = new ArrayList<>(smaller);
        temp.add(index, firstElement);
        returnValue.add(temp);
      }
    }
    return returnValue;
  }

  public List<List<Vertex>> addEndPos(List<List<Vertex>> v) {
    for (int i = 0; i < v.size(); i++) {
      List<Vertex> indList = v.get(i);
      Vertex end = indList.get(0);
      indList.add(indList.size(), end);
    }
    return v;
  }

	// STUDENT CODE ENDS HERE

	/**
	 * Prints out the adjacency list of the graph for debugging
	 */
	public void printAdjacencyList() {
		for (int u : vertexNames.keySet()) {
			StringBuilder sb = new StringBuilder();
			sb.append(u);
			sb.append(" -> [ ");
			for (Edge e : vertexNames.get(u).adjacentEdges) {
				sb.append(e.target.name);
				sb.append("(");
				sb.append(e.distance);
				sb.append(") ");
			}
			sb.append("]");
			System.out.println(sb.toString());
		}
	}
}
