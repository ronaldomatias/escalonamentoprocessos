package Classes;

import java.util.Collections;
import java.util.List;

public final class OrdenadorDeLista {
	
	public static List<Processo> ordenarPorMaiorPrioridadeEMenorTamanho(List<Processo> listaProcessos){
		
		Collections.sort(listaProcessos);
		
		return listaProcessos;
	}
	
}
