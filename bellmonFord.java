import java.util.*;
import java.lang.*;
public class bellmonFord 
{
	class Edge
	{
		int src;
		int des;
		int weight;
		Edge()
		{
		src=weight=des=0;
		}
	};
   int v,e;
   Edge edge[];
	  bellmonFord(int v,int e)
	  {
		  this.v=v;
		  this.e=e;
		  edge=new Edge[e];
		  for(int i=0;i<e;i++)
			  edge[i]=new Edge();
	  }
	  
	public void BellmonFord(bellmonFord graph,int s)
	{
		int dist[]=new int[v];
		for(int i=0;i<v;i++)
			dist[i]=Integer.MAX_VALUE;
		dist[s]=0;
		
		for(int i=1;i<v;i++)
		{
			for(int j=0;j<e;j++)
			{
				int u=edge[j].src;
			    int v=edge[j].des;
			    int w=edge[j].weight;
			    
			    if(dist[u]!=Integer.MAX_VALUE && dist[u]+w<dist[v])
			    	dist[v]=dist[u]+w;
			    
			}
		}
		
		for(int i=1;i<v;i++)
		{
			for(int j=0;j<e;j++)
			{
				int u=edge[j].src;
			    int v=edge[j].des;
			    int w=edge[j].weight;
			    
			    if(dist[u]!=Integer.MAX_VALUE && dist[u]+w<dist[v])
			    {
			    	System.out.println("negative cylce");
			    	return;
			    }
			    
			}
		}
		
		 printArr(dist, v); 
	}
	
	public void printArr(int []dist ,int V)
	{
		  System.out.println("Vertex Distance from Source"); 
	        for (int i = 0; i < V; ++i) 
	            System.out.println(i + "\t\t" + dist[i]); 
	}
	
	public static void main(String args[])
	{
	    int v=5;
	    int e=8;
	    bellmonFord b=new bellmonFord(v,e);
	    
	    b.edge[0].src=0;
	    b.edge[0].des=1;
	    b.edge[0].weight=-1;
	    
	    b.edge[1].src=0;
	    b.edge[1].des=2;
	    b.edge[1].weight=4;
	    
	    b.edge[2].src=1;
	    b.edge[2].des=2;
	    b.edge[2].weight=3;
	    
	    b.edge[3].src=1;
	    b.edge[3].des=3;
	    b.edge[3].weight=2;
	    
	    b.edge[4].src=1;
	    b.edge[4].des=4;
	    b.edge[4].weight=2;
	    
	    b.edge[5].src=3;
	    b.edge[5].des=2;
	    b.edge[5].weight=5;
	    
	    b.edge[6].src=3;
	    b.edge[6].des=1;
	    b.edge[6].weight=1;
	    
	    b.edge[7].src=4;
	    b.edge[7].des=3;
	    b.edge[7].weight=-3;
	  
	    b.BellmonFord(b,0);
	}
}
