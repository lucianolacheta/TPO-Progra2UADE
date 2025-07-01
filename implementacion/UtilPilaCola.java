package implementacion;

import tda.*;
import imple.*;

//EJERCICIO 9
public class UtilPilaCola {

    public static ConjuntoTDA elementosComunes(PilaTDA pila, ColaTDA cola) {
        // Copias para no modificar las originales
        PilaTDA copiaPila = copiarPila(pila);
        ColaTDA copiaCola = copiarCola(cola);
  
        // Conjunto para elementos de la cola
        ConjuntoTDA conjuntoCola = new Conjunto(); // o Dinamico si usás otra implementación
        conjuntoCola.inicializarConjunto();
  
        // Llenar conjuntoCola con los elementos de la cola
        while (!copiaCola.colaVacia()) {
            int valor = copiaCola.primero();
            conjuntoCola.agregar(valor);
            copiaCola.desacolar();
        }
  
        // Conjunto resultado
        ConjuntoTDA resultado = new Conjunto();
        resultado.inicializarConjunto();
  
        // Verificar coincidencias en la pila
        while (!copiaPila.pilaVacia()) {
            int valor = copiaPila.tope();
            if (conjuntoCola.pertenece(valor)) {
                resultado.agregar(valor);
            }
            copiaPila.desapilar();
        }
  
        return resultado;
    }
  
    // Copia de pila
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
        while (!aux.pilaVacia()) original.apilar(aux.tope()); aux.desapilar();
        while (!temp.pilaVacia()) copia.apilar(temp.tope()); temp.desapilar();
  
        return copia;
    }
  
    // Copia de cola
    private static ColaTDA copiarCola(ColaTDA original) {
        ColaTDA copia = new Cola(); copia.inicializarCola();
        ColaTDA aux = new Cola(); aux.inicializarCola();
  
        while (!original.colaVacia()) {
            int val = original.primero();
            copia.acolar(val);
            aux.acolar(val);
            original.desacolar();
        }
        while (!aux.colaVacia()) original.acolar(aux.primero()); aux.desacolar();
  
        return copia;
    }
  }
  
  
