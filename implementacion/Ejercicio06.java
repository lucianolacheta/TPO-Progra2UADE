package implementacion;

import tda.*;
import imple.*;

/*
Ejercicio06
Porcentaje de pares en PilaTDA
Dado una pila de enteros, calcular el porcentaje de elementos que son 
pares sobre el total.
*/

/*
a) Estrategia:
Se utiliza una pila auxiliar para copiar la pila original, 
permitiendo restaurarla al final. Se recorre la pila auxiliar 
contando pares y el total de elementos.
*/

public class Ejercicio06 {

    public static float porcentajePares(PilaTDA pila) {
        PilaTDA copia = copiarPila(pila);

        int total = 0;
        int pares = 0;

        while (!copia.pilaVacia()) {
            int valor = copia.tope();
            if (valor % 2 == 0) pares++;
            total++;
            copia.desapilar();
        }

        if (total == 0) return 0;
        return (pares * 100f) / total;
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
}
