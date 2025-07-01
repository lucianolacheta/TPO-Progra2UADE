package implementacion;

import tda.*;
import imple.*;

/*
Ejercicio15
Grado de un vértice en GrafoTDA
Calcular, para un vértice `v`, la diferencia entre su número de aristas salientes y el número de aristas entrantes.
 */

/*
 Estrategia:
 1. Clonar el conjunto de vértices del grafo para poder iterar sin alterar 
 el original.
 2. Inicializar dos contadores: `salidas` y `entradas` a 0.
 3. Mientras la copia no esté vacía:
    a. Elegir un vértice `otro` y sacarlo de la copia.
    b. Si existe arista de `v` a `otro`, incrementar `salidas`.
    c. Si existe arista de `otro` a `v`, incrementar `entradas`.
 4. Devolver la diferencia `salidas - entradas`, que es el grado de `v`.

 Complejidad: O(n) donde n = número de vértices (cada verifica existeArista es O(1) en la implementación estándar).
*/

public class Ejercicio15 {

    public static int gradoVertice(GrafoTDA grafo, int v) {
        ConjuntoTDA vertices = grafo.vertices();

        ConjuntoTDA copia = copiarConjunto(vertices);
        int salidas = 0;
        int entradas = 0;

        while (!copia.conjuntoVacio()) {
            int otro = copia.elegir();
            copia.sacar(otro);

            if (grafo.existeArista(v, otro)) salidas++;
            if (grafo.existeArista(otro, v)) entradas++;
        }

        return salidas - entradas;
    }

    private static ConjuntoTDA copiarConjunto(ConjuntoTDA original) {
        ConjuntoTDA copia = new Conjunto(); copia.inicializarConjunto();
        ConjuntoTDA aux = new Conjunto(); aux.inicializarConjunto();

        while (!original.conjuntoVacio()) {
            int val = original.elegir();
            original.sacar(val);
            copia.agregar(val);
            aux.agregar(val);
        }

        while (!aux.conjuntoVacio()) {
            int val = aux.elegir();
            aux.sacar(val);
            original.agregar(val);
        }

        return copia;
    }
}