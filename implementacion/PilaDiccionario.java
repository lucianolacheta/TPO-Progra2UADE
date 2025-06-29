package org.example.implementacion;

import org.example.interfaz.PilaDiccionarioTDA;
import tda.PilaTDA;
import tda.DiccionarioSimpleTDA;
import tda.ConjuntoTDA;
import imple.Pila;
import imple.DiccionarioSimple;

/**
 * a) Estrategia utilizada:
 *    Para contar la frecuencia de aparición de elementos en una pila, se usa un diccionario
 *    donde las claves son los elementos y los valores su frecuencia. Se vacía la pila a una
 *    pila auxiliar contando frecuencias, y luego se restaura completamente para mantener
 *    la estructura original intacta.
 */
public class PilaDiccionario implements PilaDiccionarioTDA {
    

    @Override
    public DiccionarioSimpleTDA contarFrecuencias(PilaTDA pila) {
        // O(n) donde n es el número de elementos en la pila
        
        DiccionarioSimpleTDA frecuencias = new DiccionarioSimple();
        frecuencias.inicializarDiccionario();
        
        if (pila.pilaVacia()) {
            return frecuencias;
        }
        
        PilaTDA pilaAux = new Pila();
        pilaAux.inicializarPila();
        
        while (!pila.pilaVacia()) {
            int elemento = pila.tope();
            pilaAux.apilar(elemento);
            
            ConjuntoTDA claves = frecuencias.claves();
            
            if (claves.pertenece(elemento)) {
                int frecuenciaActual = frecuencias.recuperar(elemento);
                frecuencias.eliminar(elemento);
                frecuencias.agregar(elemento, frecuenciaActual + 1);
            } else {
                frecuencias.agregar(elemento, 1);
            }
            
            pila.desapilar();
        }
        
        while (!pilaAux.pilaVacia()) {
            pila.apilar(pilaAux.tope());
            pilaAux.desapilar();
        }
        
        return frecuencias;
    }
}
