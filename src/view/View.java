package view;

import java.util.Scanner;
import java.util.function.BiConsumer;
import java.util.function.Consumer;

import model.logic.Modelo;

public class View 
{
	Scanner lector;

	public View()
	{
		lector = new Scanner(System.in);
	}

	public void close()
	{
		lector.close();
	}
	
	public int showMenu()
	{
		System.out.println("1. Cargar datos");
		System.out.println("2. Componentes conectados");
		System.out.println("3. Encontrar landings interconexión");
		System.out.println("4. Ruta mínima");
		System.out.println("5. Red de expansión mínima");
		System.out.println("6. Fallas en conexión");
		System.out.println("7. Exit");
		System.out.println("Dar el numero de opcion a resolver, luego oprimir tecla Return: (e.g., 1):");

		return lector.nextInt();
	}

	public void printMessage(String mensaje) {

		System.out.println(mensaje);
	}		
	
	public void printModelo(Modelo modelo)
	{
		System.out.println(modelo);
	}

	public void showDialogComponentesConectados(BiConsumer<String, String> callback) {
		printMessage("--------- \nIngrese el nombre del primer punto de conexión");
		String punto1 = lector.next();
		lector.nextLine();
		
		printMessage("--------- \nIngrese el nombre del segundo punto de conexión");
		String punto2 = lector.next();
		lector.nextLine();
		
		callback.accept(punto1, punto2);
	}

	public void showDialogRutaMinima(BiConsumer<String, String> callback) {
		printMessage("--------- \nIngrese el nombre del primer país");
		String pais1 = lector.next();
		lector.nextLine();
		
		printMessage("--------- \nIngrese el nombre del segundo país");
		String pais2 = lector.next();
		lector.nextLine();
		
		callback.accept(pais1, pais2);
	}

	public void showDialogFallaEnConexion(Consumer<String> callback) {
		printMessage("--------- \nIngrese el nombre del punto de conexión");

		String landing = lector.next();
		lector.nextLine();

		callback.accept(landing);
	}
}
