package implementacion;


import tda.*;
import imple.*;

//EJERCICIO 15
public class Ejercicio15 {

    public static int gradoVertice(GrafoTDA grafo, int v) {
        ConjuntoTDA vertices = grafo.vertices();
  
        int salidas = 0;
        int entradas = 0;
  
        ConjuntoTDA aux = copiarConjunto(vertices);
  
        while (!aux.conjuntoVacio()) {
            int otro = aux.elegir();
            aux.sacar(otro);
  
            if (grafo.existeArista(v, otro)) salidas++;
            if (grafo.existeArista(otro, v)) entradas++;
        }
  
        return salidas - entradas;
    }
  
    private static ConjuntoTDA copiarConjunto(ConjuntoTDA original) {
        ConjuntoTDA copia = new Conjunto(); // o dinámico
        copia.inicializarConjunto();
  
        ConjuntoTDA aux = new Conjunto();
        aux.inicializarConjunto();
  
        while (!original.conjuntoVacio()) {
            int e = original.elegir();
            original.sacar(e);
            copia.agregar(e);
            aux.agregar(e);
        }
  
        // Restaurar original
        while (!aux.conjuntoVacio()) {
            int e = aux.elegir();
            aux.sacar(e);
            original.agregar(e);
        }
  
        return copia;
    }
  }