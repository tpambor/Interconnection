package model.data_structures;

import java.text.DecimalFormat;

public abstract class TablaHash<K extends Comparable<K>, V extends Comparable <V>, T extends Comparable <T>> implements ITablaSimbolos<K, V> {
    
    ILista<T> listaNodos;
	protected int tamanoAct;
	protected int minicial;
	protected int tamanoTabla;
	protected int cantidadRehash;

	public void rehash()
	{
		try
		{
			ILista<NodoTS<K,V>> nodos= darListaNodos();
			
			tamanoAct=0;
			tamanoTabla*=2;
			int m = nextPrime(tamanoTabla);
			tamanoTabla=m;
			listaNodos=new ArregloDinamico<>(tamanoTabla);
			
			for(int i=1; i<=tamanoTabla; i++)
			{
				listaNodos.insertElement(null, size()+1);
			}
			
			NodoTS<K,V> actual= null;
			for(int i=1; i<= nodos.size();i++)
			{
				actual=nodos.getElement(i);
				put(actual.getKey(), actual.getValue());
			}
		}
		catch (NullException| VacioException| PosException e)
		{
			e.printStackTrace();
		}
		
		cantidadRehash++;
		
	}

	@Override
	public int size() 
	{
		return tamanoAct;
	}

	static boolean isPrime(int n)
	{

		if (n <= 1) return false;

		if (n > 1 && n <= 3) return true;


		if (n % 2 == 0 || n % 3 == 0) return false;

		for (int i = 5; i * i <= n; i = i + 6)

			if (n % i == 0 || n % (i + 2) == 0)

				return false;

		return true;
	}

	static int nextPrime(int number) {
	    if (number <= 1)
	        return 2;
	    int prime = number;
	    boolean found = false;
	    while (!found) {
	        prime++;
	        if (isPrime(prime))
	            found = true;
	    }
	    return prime;
	}

	public String toString() {
		String retorno = "";
		retorno += "La cantidad de duplas: " + keySet().size();
		retorno += "\nEl m inicial es: " + minicial;
		retorno += "\nEl m final es: " + tamanoTabla;
		double tam = tamanoAct;
		double tam2 = tamanoTabla;
		DecimalFormat df = new DecimalFormat("###.##");
		double tamanoCarga = tam / tam2;
		retorno += "\nEl factor de carga es: " + df.format(tamanoCarga);
		retorno += "\nLa cantidad de rehash es: " + cantidadRehash;

		return retorno;
	}
	
	public void initializeTable(int tamInicial) {
		int m = nextPrime(tamInicial);
		minicial = m;
		listaNodos = new ArregloDinamico<>(m);
		tamanoAct = 0;
		tamanoTabla = m;

		for (int i = 1; i <= tamanoTabla; i++) {
			try {
				listaNodos.insertElement(null, i);
			} catch (PosException | NullException e) {
				e.printStackTrace();
			}
		}
    }
}