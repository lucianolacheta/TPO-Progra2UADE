package implementacion;

import interfaz.MultiPilaTDA;
import tda.PilaTDA;
import imple.Pila;

/*
Ejercicio03
MultiPilaTDA
Extiende PilaTDA para que sus operaciones (apilar, desapilar, tope) 
reciban un parámetro adicional: la cantidad de elementos a procesar.
 */

/*
Estrategia:
Trabajar sobre copias de las pilas de entrada (o de la multipila) para 
no alterar las originales.
Procesar esa copia según la lógica específica de cada operación.
Aplicar finalmente los cambios (sólo si corresponde) sobre la multipila real, 
o bien generar una estructura resultado a partir de la copia procesada. 
*/

public class MultiPila implements MultiPilaTDA {

    private PilaTDA multipila;

    @Override
    public void inicializarPila() {       // O(1)
        multipila = new Pila();
        multipila.inicializarPila();
    }

    @Override
    public boolean pilaVacia() {         // O(1)
        return multipila.pilaVacia();
    }

    @Override
    public void apilar(PilaTDA valores) { // O(m) donde m = |valores|
        PilaTDA copia     = copiarPila(valores);
        PilaTDA invertida = invertirPila(copia);
        while (!invertida.pilaVacia()) {
            multipila.apilar(invertida.tope());
            invertida.desapilar();
        }
    }

    @Override
    public void desapilar(PilaTDA valores) { // O(n + m), n = |multipila|, m = |valores|
        PilaTDA copiaM = copiarPila(multipila);
        PilaTDA copiaV = copiarPila(valores);
        boolean coincide = true;

        while (!copiaV.pilaVacia()) {
            if (copiaM.pilaVacia() || copiaM.tope() != copiaV.tope()) {
                coincide = false;
                break;
            }
            copiaM.desapilar();
            copiaV.desapilar();
        }

        if (coincide) {
            PilaTDA aux = copiarPila(valores);
            while (!aux.pilaVacia()) {
                multipila.desapilar();
                aux.desapilar();
            }
        }
    }

    @Override
    public PilaTDA tope(int cantidad) {      // O(n) donde n = |multipila|
        PilaTDA resultado = new Pila();
        resultado.inicializarPila();
        PilaTDA copia     = copiarPila(multipila);
        PilaTDA temp      = new Pila();
        temp.inicializarPila();

        int count = 0;
        while (!copia.pilaVacia() && count < cantidad) {
            temp.apilar(copia.tope());
            copia.desapilar();
            count++;
        }

        while (!temp.pilaVacia()) {
            resultado.apilar(temp.tope());
            temp.desapilar();
        }
        return resultado;
    }

    // ---------------------------------------------------
    // Métodos auxiliares

    /** Clona una pila sin modificar la original. */     // O(k)
    private PilaTDA copiarPila(PilaTDA original) {
        PilaTDA temp = new Pila(); temp.inicializarPila();
        PilaTDA copia = new Pila(); copia.inicializarPila();
        PilaTDA aux = new Pila(); aux.inicializarPila();

        while (!original.pilaVacia()) {
            int v = original.tope();
            temp.apilar(v);
            aux.apilar(v);
            original.desapilar();
        }
        // restoura original
        while (!aux.pilaVacia()) {
            original.apilar(aux.tope());
            aux.desapilar();
        }
        // construye la copia
        while (!temp.pilaVacia()) {
            copia.apilar(temp.tope());
            temp.desapilar();
        }
        return copia;
    }

    /** Devuelve una copia invertida de la pila dada. */  // O(k)
    private PilaTDA invertirPila(PilaTDA pilaOriginal) {
        PilaTDA invertida = new Pila(); invertida.inicializarPila();
        PilaTDA copia      = copiarPila(pilaOriginal);
        while (!copia.pilaVacia()) {
            invertida.apilar(copia.tope());
            copia.desapilar();
        }
        return invertida;
    }
}
