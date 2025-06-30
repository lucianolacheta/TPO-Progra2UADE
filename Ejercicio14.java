package Implementaciones;

import tda.GrafoTDA;
import tda.ConjuntoTDA;
import imple.Conjunto;

public class Ejercicio14 {

    /**
     * Estrategia:
     * 1. Crear un ConjuntoTDA 'puentes' vacío para acumular los vértices puente.
     * 2. Obtener el ConjuntoTDA 'vertices' con todos los vértices del grafo: g.vertices().
     * 3. Mientras 'vertices' no esté vacío:
     *      a. Elegir un vértice p.
     *      b. Sacar p de 'vertices' para avanzar en el recorrido.
     *      c. Si existe arista de o→p y de p→d en el grafo:
     *           i.   Agregar p a 'puentes'.
     * 4. Devolver 'puentes', que contiene todos los vértices p tales que o→p y p→d.
     */
    public static ConjuntoTDA verticesPuente(GrafoTDA g, int o, int d) { // O(n)
        ConjuntoTDA puentes = new Conjunto();
        puentes.inicializarConjunto();

        ConjuntoTDA vertices = g.vertices();
        while (!vertices.conjuntoVacio()) {
            int p = vertices.elegir();
            vertices.sacar(p);
            if (g.existeArista(o, p) && g.existeArista(p, d)) {
                puentes.agregar(p);
            }
        }

        return puentes;
    }
}
