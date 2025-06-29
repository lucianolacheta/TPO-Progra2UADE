package org.example;

import org.example.implementacion.PilaDevuelveConjunto;
import org.example.interfaz.PilaDevuelveConjuntoTDA;
import tda.PilaTDA;
import tda.ConjuntoTDA;
import imple.Pila;
import imple.Conjunto;


public class PilaDevuelveConjuntoTest {

    public static void main(String[] args) {
        System.out.println("Prueba de método elementosRepetidos");
        System.out.println("==================================\n");
        
        // Inicializamos el utilitario de pilas
        PilaDevuelveConjuntoTDA pilaUtil = new PilaDevuelveConjunto();
        
        // Caso 1: Pila con elementos repetidos
        PilaTDA pila1 = new Pila();
        pila1.inicializarPila();
        
        // Creamos una pila con algunos elementos repetidos
        pila1.apilar(10);
        pila1.apilar(20);
        pila1.apilar(30);
        pila1.apilar(20); // Repetido
        pila1.apilar(40);
        pila1.apilar(50);
        pila1.apilar(30); // Repetido
        pila1.apilar(10); // Repetido
        
        System.out.println("Caso 1: Pila con elementos repetidos");
        mostrarPila("Contenido de la pila:", pila1);
        
        // Obtenemos los elementos repetidos
        ConjuntoTDA repetidos1 = pilaUtil.elementosRepetidos(pila1);
        mostrarConjunto("Elementos repetidos:", repetidos1);
        
        // Verificamos que la pila original no haya sido modificada
        System.out.println("Verificamos que la pila original no haya sido modificada:");
        mostrarPila("Contenido de la pila después de procesar:", pila1);
        
        System.out.println("\n----------------------------------\n");
        
        // Caso 2: Pila sin elementos repetidos
        PilaTDA pila2 = new Pila();
        pila2.inicializarPila();
        
        pila2.apilar(5);
        pila2.apilar(15);
        pila2.apilar(25);
        pila2.apilar(35);
        
        System.out.println("Caso 2: Pila sin elementos repetidos");
        mostrarPila("Contenido de la pila:", pila2);
        
        ConjuntoTDA repetidos2 = pilaUtil.elementosRepetidos(pila2);
        mostrarConjunto("Elementos repetidos:", repetidos2);
        
        System.out.println("\n----------------------------------\n");
        
        // Caso 3: Pila vacía
        PilaTDA pila3 = new Pila();
        pila3.inicializarPila();
        
        System.out.println("Caso 3: Pila vacía");
        mostrarPila("Contenido de la pila:", pila3);
        
        ConjuntoTDA repetidos3 = pilaUtil.elementosRepetidos(pila3);
        mostrarConjunto("Elementos repetidos:", repetidos3);
    }
    
    /**
     * Método auxiliar para mostrar el contenido de una pila
     */
    private static void mostrarPila(String mensaje, PilaTDA pila) {
        System.out.println(mensaje);
        
        if (pila.pilaVacia()) {
            System.out.println("La pila está vacía");
            return;
        }
        
        // Guardamos los valores en un arreglo temporal
        int[] valores = new int[100]; // Tamaño máximo
        int cantidad = 0;
        
        PilaTDA pilaAux = new Pila();
        pilaAux.inicializarPila();
        
        // Extraemos todos los valores
        while (!pila.pilaVacia()) {
            valores[cantidad] = pila.tope();
            pilaAux.apilar(valores[cantidad]);
            cantidad++;
            pila.desapilar();
        }
        
        // Restauramos la pila original
        while (!pilaAux.pilaVacia()) {
            pila.apilar(pilaAux.tope());
            pilaAux.desapilar();
        }
        
        // Mostramos los valores en orden de tope a base
        System.out.print("Tope -> ");
        for (int i = 0; i < cantidad; i++) {
            System.out.print(valores[i]);
            if (i < cantidad - 1) {
                System.out.print(" -> ");
            }
        }
        System.out.println(" <- Base");
    }
    
    /**
     * Método auxiliar para mostrar el contenido de un conjunto
     */
    private static void mostrarConjunto(String mensaje, ConjuntoTDA conjunto) {
        System.out.println(mensaje);
        
        if (conjunto.conjuntoVacio()) {
            System.out.println("El conjunto está vacío");
            return;
        }
        
        System.out.print("{ ");
        
        // Creamos un conjunto auxiliar para no modificar el original
        ConjuntoTDA conjuntoAux = new Conjunto();
        conjuntoAux.inicializarConjunto();
        
        while (!conjunto.conjuntoVacio()) {
            int elemento = conjunto.elegir();
            System.out.print(elemento + " ");
            
            // Guardamos el elemento en el auxiliar
            conjuntoAux.agregar(elemento);
            conjunto.sacar(elemento);
        }
        
        // Restauramos el conjunto original
        while (!conjuntoAux.conjuntoVacio()) {
            int elemento = conjuntoAux.elegir();
            conjunto.agregar(elemento);
            conjuntoAux.sacar(elemento);
        }
        
        System.out.println("}");
    }
}
