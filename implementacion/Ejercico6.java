package implementacion;

import tda.*;
import imple.*;

//EJERCICIO 6
public class Ejercico6 {

    public static float porcentajePares(PilaTDA pila) {
        PilaTDA copia = copiarPila(pila);
  
        int total = 0;
        int pares = 0;
  
        while (!copia.pilaVacia()) {
            int valor = copia.tope();
            if (valor % 2 == 0) {
                pares++;
            }
            total++;
            copia.desapilar();
        }
  
        if (total == 0) return 0;
        return (pares * 100f) / total;
    }
  
    private static PilaTDA copiarPila(PilaTDA original) {
        PilaTDA temp = new Pila(); temp.inicializarPila();
        PilaTDA copia = new Pila(); copia.inicializarPila();
  
        // Paso 1: volcar a temporal para invertir
        PilaTDA aux = new Pila(); aux.inicializarPila();
        while (!original.pilaVacia()) {
            int e = original.tope();
            temp.apilar(e);
            aux.apilar(e);
            original.desapilar();
        }
        // Restaurar original
        while (!aux.pilaVacia()) {
            original.apilar(aux.tope());
            aux.desapilar();
        }
        // Invertir a copia
        while (!temp.pilaVacia()) {
            copia.apilar(temp.tope());
            temp.desapilar();
        }
        return copia;
    }
  }
  
  