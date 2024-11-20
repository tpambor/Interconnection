package controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import model.logic.Modelo;
import view.View;

public class Controller {
	private Modelo modelo;
	private View view;

	private Map<Integer, Runnable> menuTable = new HashMap<>();
	private boolean fin = false;

	public Controller ()
	{
		view = new View();

		menuTable.put(1, this::menuCargarDatos);
		menuTable.put(2, this::menuComponentesConectados);
		menuTable.put(3, this::menuEncontrarLandings);
		menuTable.put(4, this::menuRutaMinima);
		menuTable.put(5, this::menuRedExpansionMinima);
		menuTable.put(6, this::menuFallasEnConexion);
		menuTable.put(7, this::menuExit);
	}

	private void menuCargarDatos() {
		view.printMessage("--------- \nCargar datos");

		modelo = new Modelo(1); 
		try 
		{
			modelo.cargar();
		} catch (IOException e) {

			e.printStackTrace();
		}

		view.printModelo(modelo);	
	}

	private void menuComponentesConectados() {
		view.showDialogComponentesConectados((String punto1, String punto2) -> {
			String res = modelo.reqComponentesConectados(punto1, punto2);
			view.printMessage(res);
		});
	}

	private void menuEncontrarLandings() {
		String res = modelo.reqEncontrarLandings();
		view.printMessage(res);
	}

	private void menuRutaMinima() {
		view.showDialogRutaMinima((String pais1, String pais2) -> {
			String res = modelo.reqRutaMinima(pais1, pais2);
			view.printMessage(res);
		});
	}

	private void menuRedExpansionMinima() {
		String res = modelo.reqRedExpansionMinima();
		view.printMessage(res);
	}

	private void menuFallasEnConexion() {
		view.showDialogFallaEnConexion((String landing) -> {
			String res = modelo.reqFallaEnConexion(landing);
			view.printMessage(res);
		});
	}

	private void menuExit() {
		fin = true;

		view.printMessage("--------- \n Hasta pronto !! \n---------"); 
	}

	private void menuInvalid() {
		view.printMessage("--------- \n Opcion Invalida !! \n---------");
	}

	public void run() 
	{
		while(!fin)
		{
			int option = view.showMenu();

			menuTable.getOrDefault(option, this::menuInvalid).run();
		}

		view.close();
	}	
}
