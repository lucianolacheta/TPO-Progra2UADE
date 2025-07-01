package implementacion;

import tda.*;

/*
Ejercicio12
Suma de impares en ABB
Recorrer un árbol binario de búsqueda (ABB) y calcular la suma de 
todos sus nodos con valor impar.
 */

/*
Estrategia:
Se utiliza una técnica recursiva para recorrer el ABB. 
En cada llamada, se verifica si el valor actual es impar y se suma 
a la suma total si es así. Luego, se realizan llamadas recursivas 
para los subárboles izquierdo y derecho.
*/

public class Ejercicio12 {

    public static int sumaImpares(ABBTDA arbol) {
        if (arbol.arbolVacio()) return 0;

        int suma = 0;

        if (arbol.raiz() % 2 != 0) {
            suma += arbol.raiz();
        }

        suma += sumaImpares(arbol.hijoIzq());
        suma += sumaImpares(arbol.hijoDer());

        return suma;
    }
}