package implementacion;

import tda.ABBTDA;

/*
Ejercicio13
Hojas pares en ABB
Contar cuántas hojas de un ABB tienen un valor par.
 */

/*
Estrategia:
Para calcular la cantidad de hojas pares, se recorre el árbol mediante 
recursión identificando nodos que no tienen hijos (hojas) y verificando 
si su valor es par. La estructura del árbol recibida no se modifica 
durante el proceso.
*/
public class Ejercicio13 {

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
