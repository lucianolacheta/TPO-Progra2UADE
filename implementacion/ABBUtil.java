package implementacion;

import interfaz.ABBUtilTDA;
import tda.ABBTDA;

/**
 * a) Estrategia utilizada:
 *    Para calcular la cantidad de hojas pares, se recorre el árbol mediante recursión
 *    identificando nodos que no tienen hijos (hojas) y verificando si su valor es par.
 *    La estructura del árbol recibida no se modifica durante el proceso.
 */
public class ABBUtil implements ABBUtilTDA {

    @Override
    public int cantidadHojasPares(ABBTDA arbol) {

        if (arbol.arbolVacio()) {
            return 0;
        }
        
        if (arbol.hijoIzq().arbolVacio() && arbol.hijoDer().arbolVacio()) {
            if (arbol.raiz() % 2 == 0) {
                return 1;
            } else {
                return 0;
            }
        }
        
        return cantidadHojasPares(arbol.hijoIzq()) + cantidadHojasPares(arbol.hijoDer());
    }
}
