package implementacion;

import tda.ColaTDA;
import imple.Cola;
import tda.ConjuntoTDA;
import imple.Conjunto;

public class Ejercicio08 {

    /**
     * Estrategia:
     * 1. Crear tres estructuras auxiliares:
     *    - resultado: nueva cola donde iremos encolando sólo la primera aparición de cada elemento.
     *    - vistos: conjunto que registra qué valores ya procesamos.
     *    - aux: cola auxiliar para vaciar y luego restaurar la cola original.
     * 2. Recorrer original hasta vaciarla:
     *      a. Desencolar frente → elem.
     *      b. Encolar elem en aux (para reconstruir original más tarde).
     *      c. Si elem no está en vistos:
     *           i.   agregar elem a vistos.
     *           ii.  encolar elem en resultado.
     * 3. Reconstruir original desencolando todo de aux y reenfilándolo de nuevo.
     * 4. Devolver resultado, que contiene los elementos únicos en el orden de su primera aparición.
     *
     */
	
    public static ColaTDA inRepetidos(ColaTDA original) { //O(n²)
        ColaTDA resultado = new Cola();
        resultado.inicializarCola();

        ConjuntoTDA vistos = new Conjunto();
        vistos.inicializarConjunto();

        ColaTDA aux = new Cola();
        aux.inicializarCola();

        // 1) Recorrer original y filtrar
        while (!original.colaVacia()) {
            int elem = original.primero();
            original.desacolar();
            aux.acolar(elem);

            if (!vistos.pertenece(elem)) {
                vistos.agregar(elem);
                resultado.acolar(elem);
            }
        }

        // 2) Restaurar original desde aux
        while (!aux.colaVacia()) {
            int x = aux.primero();
            aux.desacolar();
            original.acolar(x);
        }

        return resultado;
    }
}
