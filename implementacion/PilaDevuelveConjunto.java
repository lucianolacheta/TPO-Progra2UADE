package implementacion;

import interfaz.PilaDevuelveConjuntoTDA;
import tda.PilaTDA;
import tda.ConjuntoTDA;
import imple.Pila;
import imple.Conjunto;

/**
 * a) Estrategia utilizada:
 *    Para identificar elementos repetidos en una pila, se recorre la pila una única vez
 *    manteniendo dos conjuntos: uno con elementos vistos y otro con repetidos. Si un
 *    elemento ya está en "vistos", se añade a "repetidos". La pila original se preserva
 *    intacta usando una pila auxiliar.
 */
public class PilaDevuelveConjunto implements PilaDevuelveConjuntoTDA {

    @Override
    public ConjuntoTDA elementosRepetidos(PilaTDA pila) {
        // O(n) donde n es el número de elementos en la pila
        
        if (pila.pilaVacia()) {
            ConjuntoTDA conjuntoVacio = new Conjunto();
            conjuntoVacio.inicializarConjunto();
            return conjuntoVacio;
        }
        
        PilaTDA pilaAux = new Pila();
        pilaAux.inicializarPila();
        
        ConjuntoTDA elementosVistos = new Conjunto();
        elementosVistos.inicializarConjunto();
        
        ConjuntoTDA elementosRepetidos = new Conjunto();
        elementosRepetidos.inicializarConjunto();
        
        while (!pila.pilaVacia()) {
            int elemento = pila.tope();
            pilaAux.apilar(elemento);
            
            if (elementosVistos.pertenece(elemento)) {
                elementosRepetidos.agregar(elemento);
            } else {
                elementosVistos.agregar(elemento);
            }
            
            pila.desapilar();
        }
        
        while (!pilaAux.pilaVacia()) {
            pila.apilar(pilaAux.tope());
            pilaAux.desapilar();
        }
        
        return elementosRepetidos;
    }
}
