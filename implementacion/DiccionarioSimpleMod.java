package implementacion;

import interfaz.DiccionarioSimpleModTDA;
import tda.ConjuntoTDA;
import imple.Conjunto;
/**
 * a) Estrategia utilizada:
 *    Se extiende el concepto de diccionario tradicional añadiendo un contador "factorMod" 
 *    que registra las modificaciones de cada clave. Cuando se agrega una clave nueva, 
 *    su factorMod es 0, y se incrementa en 1 cada vez que se modifica su valor.
 */
public class DiccionarioSimpleMod implements DiccionarioSimpleModTDA {

    private class Elemento {
        int clave;
        int valor;
        int factorMod;
    }
    
    private Elemento[] elementos;
    private int cantidad;
    
    @Override
    public void inicializarDiccionario() {
        // O(1) - operación de complejidad constante
        elementos = new Elemento[100];
        cantidad = 0;
    }
    
    @Override
    public void agregar(int clave, int valor) {
        // O(n) donde n es la cantidad de elementos en el diccionario
        int posicion = obtenerPosicion(clave);
        
        if (posicion == -1) {
            Elemento nuevo = new Elemento();
            nuevo.clave = clave;
            nuevo.valor = valor;
            nuevo.factorMod = 0;
            
            elementos[cantidad] = nuevo;
            cantidad++;
        } else {
            elementos[posicion].factorMod++;
            elementos[posicion].valor = valor;
        }
    }
    
    @Override
    public void eliminar(int clave) {
        // O(n) donde n es la cantidad de elementos en el diccionario
        int posicion = obtenerPosicion(clave);
        
        if (posicion != -1) {
            elementos[posicion] = elementos[cantidad - 1];
            cantidad--;
        }
    }
    
    @Override
    public int recuperar(int clave) {
        // O(n) donde n es la cantidad de elementos en el diccionario
        int posicion = obtenerPosicion(clave);
        return elementos[posicion].valor;
    }
    
    @Override
    public int recuperarMod(int clave) {
        // O(n) donde n es la cantidad de elementos en el diccionario
        int posicion = obtenerPosicion(clave);
        return elementos[posicion].factorMod;
    }
    
    @Override
    public ConjuntoTDA claves() {
        // O(n) donde n es la cantidad de elementos en el diccionario
        ConjuntoTDA conjunto = new Conjunto();
        conjunto.inicializarConjunto();
        
        for (int i = 0; i < cantidad; i++) {
            conjunto.agregar(elementos[i].clave);
        }
        
        return conjunto;
    }

    private int obtenerPosicion(int clave) {
        // O(n) donde n es la cantidad de elementos en el diccionario
        int i = 0;
        while (i < cantidad && elementos[i].clave != clave) {
            i++;
        }
        
        if (i < cantidad) {
            return i;
        } else {
            return -1;
        }
    }
}
