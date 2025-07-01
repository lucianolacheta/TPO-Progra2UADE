package implementacion;

import tda.DiccionarioMultipleTDA;
import tda.ColaTDA;
import imple.Cola;
import tda.ConjuntoTDA;
import imple.Conjunto;

/*
Ejercicio11
Valores únicos de DiccionarioMultipleTDA
A partir de un diccionario múltiple, extraer todos sus valores en una cola, 
sin repeticiones, manteniendo el orden en que se recorren las claves y sus 
valores.
*/

/*
Estrategia:
1. Recorro todas las claves del diccionario.
2. Para cada clave, recorro su conjunto de valores.
3. Mantengo un ConjuntoTDA 'vistos' para asegurar que sólo se agrega 
cada valor la primera vez.
4. Encolo los valores únicos en 'resultado' y devuelvo esa cola.
Complejidad: O(n²)
*/

public class Ejercicio11 {

    public static ColaTDA valoresUnicos(DiccionarioMultipleTDA dic) {
        ColaTDA resultado = new Cola();
        resultado.inicializarCola();

        ConjuntoTDA vistos = new Conjunto();
        vistos.inicializarConjunto();

        ConjuntoTDA claves = dic.claves();
        while (!claves.conjuntoVacio()) {    // O(k), k = claves
            int c = claves.elegir();
            claves.sacar(c);

            ConjuntoTDA vals = dic.recuperar(c);
            while (!vals.conjuntoVacio()) {   // O(m) por clave, m = valores de c
                int v = vals.elegir();
                vals.sacar(v);
                if (!vistos.pertenece(v)) {   // pertenece: O(n) en el peor caso
                    vistos.agregar(v);
                    resultado.acolar(v);
                }
            }
        }

        return resultado;
    }
}
