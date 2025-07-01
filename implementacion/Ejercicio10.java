package implementacion;

import tda.PilaTDA;
import tda.DiccionarioSimpleTDA;
import tda.ConjuntoTDA;
import imple.Pila;
import imple.DiccionarioSimple;

/*
Ejercicio10
Frecuencias en PilaTDA → DiccionarioSimpleTDA
Recorrer una pila y generar un diccionario simple donde cada elemento 
de la pila es clave y el valor es la cantidad de veces que aparece.
 */

/*
Estrategia utilizada:
Se vacía la pila a una pila auxiliar contando frecuencias, y luego se 
restaura completamente para mantener la estructura original intacta.
*/

public class Ejercicio10 {
    
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
