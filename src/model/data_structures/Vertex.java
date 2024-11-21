package model.data_structures;

import java.util.Comparator;

public class Vertex<K extends Comparable<K>,V  extends Comparable <V>> implements Comparable<Vertex<K, V>>
{
	private K key;
	private V value;
	private ILista<Edge<K, V>> arcos;
	private boolean marked;
	
	public Vertex(K id, V value)
	{
		this.key = id;
		this.value = value;
		this.arcos = new ArregloDinamico<Edge<K, V>>(1);
	}
	
	public K getId()
	{
		return key;
	}
	
	public V getInfo()
	{
		return value;
	}
	
	public boolean getMark()
	{
		return marked;
	}
	
	public void mark()
	{
		marked = true;
	}
	
	public void unmark()
	{
		marked = false;
	}

	public void addEdge(Edge<K, V> edge)
	{
		try {
			arcos.insertElement(edge, arcos.size() + 1);
		} catch (PosException | NullException e) {
			e.printStackTrace();
		}
	}
	
	public Edge<K,V> getEdge(K vertex)
	{
		Edge<K,V> retorno=null;

		for(int i=1; i<=arcos.size(); i++)
		{
			try 
			{
				if(arcos.getElement(i).getDestination().getId().compareTo(vertex)==0)
				{
					retorno= arcos.getElement(i);
				}
			} 
			catch (PosException | VacioException e) 
			{
				e.printStackTrace();
			}
		}
		
		return retorno;
	}

	public ILista<Edge<K,V>> edges()
	{
		return arcos;
	}
	
	public ILista<Vertex<K,V>> vertices()
	{
		ILista<Vertex<K,V>> retorno=new ArregloDinamico<>(1);
		for(int i=1; i<=arcos.size(); i++)
		{
			try {
				retorno.insertElement(arcos.getElement(i).getDestination(), retorno.size()+1);
			} catch (PosException | NullException | VacioException e) {
				e.printStackTrace();
			}
		}
		
		return retorno; 
	}
	
	public void topologicalOrder(ColaEncadenada<Vertex<K, V>> pre, ColaEncadenada<Vertex<K, V>> post, PilaEncadenada<Vertex<K, V>> reversePost)
	{
		mark();
		pre.enqueue(this);
		
		for(int i=1; i<= arcos.size(); i++ )
		{
			Vertex<K, V> destino;
			try {
				destino = arcos.getElement(i).getDestination();
				if(!destino.getMark())
				{
					destino.topologicalOrder(pre, post, reversePost);
				}
			} catch (PosException | VacioException e) {
				e.printStackTrace();
			}
		}
		
		post.enqueue(this);
		reversePost.push(this);
	}

	@Override
	public int compareTo(Vertex<K, V> o) 
	{
		return key.compareTo(o.getId());
	}
	
	public static class ComparadorXKey implements Comparator<Vertex<String, Landing>>
	{
		/**
		 * Comparador alterno de acuerdo al número de likes
		 * 
		 * @return valor 0 si video1 y video2 tiene los mismos likes.
		 *         valor negativo si video1 tiene menos likes que video2.
		 *         valor positivo si video1 tiene más likes que video2.
		 */
		public int compare(Vertex<String, Landing> vertice1, Vertex<String, Landing> vertice2) 
		{
			return vertice1.getId().compareToIgnoreCase(vertice2.getId());
		}
	}
}
