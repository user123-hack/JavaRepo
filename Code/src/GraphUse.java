import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class GraphUse {
	
	public static Scanner s= new Scanner(System.in);
	
	public static boolean haspath(HashMap<Integer, ArrayList<Integer>> adjacentlist,int src, int dest)
	{
    	HashMap<Integer, Boolean> visited= new HashMap<Integer, Boolean>();
		haspathHelper(adjacentlist, src,visited);
		return visited.containsKey(dest);
		
	}
	private static void haspathHelper(HashMap<Integer, ArrayList<Integer>> adjacentlist, int src,
			HashMap<Integer, Boolean> visited) {
		visited.put(src, true);
		ArrayList<Integer> adjacentvertices = adjacentlist.get(src);
		for(int adjvtx: adjacentvertices)
		{
			if(!visited.containsKey(adjvtx))
			{
				haspathHelper(adjacentlist, adjvtx, visited);
			}
		}
	}

	
    public static boolean isconnected(HashMap<Integer, ArrayList<Integer>> adjacentlist)
	{
		HashMap<Integer, Boolean> visited= new HashMap<Integer, Boolean>();
		isconnectedHelper(adjacentlist,0,visited);
		return visited.size()==adjacentlist.size();
	}
    private static void isconnectedHelper(HashMap<Integer, ArrayList<Integer>> adjacentlist, int current,HashMap<Integer, Boolean> visited) {
		visited.put(current, true);
		ArrayList<Integer> adjacentvertices = adjacentlist.get(current);
		for(int adjVtx: adjacentvertices) {
			if(!visited.containsKey(adjVtx)) {
				isconnectedHelper(adjacentlist, adjVtx, visited);
			}
		}
		
	}

    
    
    public static HashMap<Integer, ArrayList<Integer>> takeinput()
	{
		System.out.println("enter vetices:");
		int v= s.nextInt();    //no. of values to be entered as keys in hashmap
		System.out.println("enter edges:");
		int e=s.nextInt();     // no. of links 
		
		HashMap<Integer, ArrayList<Integer>> adjacencyList= new HashMap<>();  // declaring a hashmap
		for(int i=0;i<v;i++)         
		{
			ArrayList<Integer> list =new ArrayList<Integer>();   // value declaration for each key
			adjacencyList.put(i,list);   //putting key and value(empty arraylist) in hashmap
		}
		int count =1;
		while(count<=e) {
			int src=s.nextInt(); //source
			int dest= s.nextInt(); //destination
			ArrayList<Integer> srclist= adjacencyList.get(src);//getting src key arraylist(value)
			ArrayList<Integer> destlist= adjacencyList.get(dest);// getting destination key arraylist(value)
			srclist.add(dest);//putting destination in source
			destlist.add(src);// vice versa 
			count++;
		}
		return adjacencyList;
	}

	
	public static void printDFS(HashMap<Integer, ArrayList<Integer>> adjacentlist)
	{
		HashMap<Integer, Boolean> visited= new HashMap<>();
		for(int vertex:adjacentlist.keySet()) {
			if(!visited.containsKey(vertex)) {
				printDFShelper(adjacentlist,vertex, visited);
			}
		}
	}
	private static void printDFShelper(HashMap<Integer, ArrayList<Integer>> adjacentlist, int current, HashMap<Integer, Boolean> visited)
	{
		System.out.print(current+" ");
		visited.put(current,true);
		ArrayList<Integer> adjacentVertices= adjacentlist.get(current);
		for(int adjvtx:adjacentVertices) {
			if(!visited.containsKey(adjvtx)) {
				printDFShelper(adjacentlist, adjvtx, visited);
			}
		}
	}

	
	public static int[][] takeinputadjacencymatrix(){
		int v= s.nextInt();//vertices
		int e=s.nextInt();// edges
		int[][] matrix= new int [v][v];
		int count =1;
		while(count<=e)
		{
			int src=s.nextInt();
			int dest= s.nextInt();
		    matrix[src][dest]=1;
			matrix[dest][src]=1;
			count++;
		}
		return matrix;
	}
	
	

	public static void getpathusingadjacencymatrix(int[][] matrix, int src, int dest) {
		int [] visited= new int[matrix.length];
	    ArrayList<Integer> path = getpath(matrix , src,dest, visited);
		if(path!=null)
		{
			for(int val: path) {
				System.out.println(val+" ");
			}
		}
	}
	public static ArrayList<Integer> getpath(int[][] matrix, int src, int dest, int[] visited )
	{
		
		if(src==dest)
		{
			ArrayList<Integer> path= new ArrayList<Integer>();
			path.add(src);
			return path;
			
		}
		
		visited[src]=1;
		for(int j=0;j<matrix[0].length;j++)
		{
			if(matrix[src][j]==1&&visited[j]==0) {
				ArrayList<Integer> path=getpath(matrix,j,dest,visited);
				if(path!=null)
				{
					path.add(src);
					return path; 
				}
			}
		}
		return null;
	}
	

	
	public static void main(String[] args) {
		//Input: 6 6 0 1 0 2 0 3 1 2 2 3 4 5
		HashMap<Integer, ArrayList<Integer>> input = takeinput();
		System.out.println(isconnected(input));

	}

}
