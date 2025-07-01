package implementacion;

import tda.*;
import imple.*;

/*
Ejercicio09
Intersección Pila- Cola
Dada una pila y una cola, devolver un ConjuntoTDA con los valores comunes 
a ambas estructuras.
 */

/*
 Estrategia:
 1. Clonar la pila y la cola de entrada (copiarPila y copiarCola) para 
 no modificar las originales.
 2. Vaciar la copia de la cola en un ConjuntoTDA (`conjuntoCola`), de 
 modo que podamos consultar pertenencia.
 3. Recor­r cada elemento de la copia de la pila; si ese valor existe en 
 `conjuntoCola`, lo agregamos al Conjunto resultado.
 4. Devolver el Conjunto resultado con todos los valores que estaban 
 tanto en la pila como en la cola.
*/

public class Ejercicio09 {

    public static ConjuntoTDA elementosComunes(PilaTDA pila, ColaTDA cola) {
        PilaTDA copiaPila = copiarPila(pila);
        ColaTDA copiaCola = copiarCola(cola);

        ConjuntoTDA conjuntoCola = new Conjunto();
        conjuntoCola.inicializarConjunto();

        while (!copiaCola.colaVacia()) {
            int valor = copiaCola.primero();
            conjuntoCola.agregar(valor);
            copiaCola.desacolar();
        }

        ConjuntoTDA resultado = new Conjunto();
        resultado.inicializarConjunto();

        while (!copiaPila.pilaVacia()) {
            int valor = copiaPila.tope();
            if (conjuntoCola.pertenece(valor)) {
                resultado.agregar(valor);
            }
            copiaPila.desapilar();
        }

        return resultado;
    }

    private static PilaTDA copiarPila(PilaTDA original) {
        PilaTDA temp = new Pila(); temp.inicializarPila();
        PilaTDA copia = new Pila(); copia.inicializarPila();
        PilaTDA aux = new Pila(); aux.inicializarPila();

        while (!original.pilaVacia()) {
            int val = original.tope();
            temp.apilar(val);
            aux.apilar(val);
            original.desapilar();
        }

        while (!aux.pilaVacia()) {
            original.apilar(aux.tope());
            aux.desapilar();
        }

        while (!temp.pilaVacia()) {
            copia.apilar(temp.tope());
            temp.desapilar();
        }

        return copia;
    }

    private static ColaTDA copiarCola(ColaTDA original) {
        ColaTDA copia = new Cola(); copia.inicializarCola();
        ColaTDA aux = new Cola(); aux.inicializarCola();

        while (!original.colaVacia()) {
            int val = original.primero();
            copia.acolar(val);
            aux.acolar(val);
            original.desacolar();
        }

        while (!aux.colaVacia()) {
            original.acolar(aux.primero());
            aux.desacolar();
        }

        return copia;
    }
}
