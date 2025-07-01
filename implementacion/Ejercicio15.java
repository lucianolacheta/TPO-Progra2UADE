package implementacion;

import tda.*;
import imple.*;

/*
Ejercicio15
Grado de un vértice en GrafoTDA
Calcular, para un vértice `v`, la diferencia entre su número de aristas salientes y el número de aristas entrantes.
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