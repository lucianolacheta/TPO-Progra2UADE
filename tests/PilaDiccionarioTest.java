package tests;

import implementacion.PilaDiccionario;
import interfaz.PilaDiccionarioTDA;
import tda.PilaTDA;
import tda.DiccionarioSimpleTDA;
import tda.ConjuntoTDA;
import imple.Pila;



public class PilaDiccionarioTest {

    public static void main(String[] args) {
        System.out.println("Prueba de método contarFrecuencias");
        System.out.println("==================================\n");
        
        PilaDiccionarioTDA pilaDiccionario = new PilaDiccionario();
        
        PilaTDA pila1 = new Pila();
        pila1.inicializarPila();
        
        // Creamos una pila con algunos elementos repetidos
        pila1.apilar(10);
        pila1.apilar(20);
        pila1.apilar(30);
        pila1.apilar(20); // Repetido
        pila1.apilar(40);
        pila1.apilar(10); // Repetido
        pila1.apilar(10); // Repetido
        pila1.apilar(50);
        
        System.out.println("Caso 1: Pila con elementos repetidos");
        mostrarPila("Contenido de la pila:", pila1);
        
        // Obtenemos el diccionario de frecuencias
        DiccionarioSimpleTDA frecuencias1 = pilaDiccionario.contarFrecuencias(pila1);
        mostrarDiccionario("Frecuencias:", frecuencias1);
        
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
        
        DiccionarioSimpleTDA frecuencias2 = pilaDiccionario.contarFrecuencias(pila2);
        mostrarDiccionario("Frecuencias:", frecuencias2);
        
        System.out.println("\n----------------------------------\n");
        
        // Caso 3: Pila vacía
        PilaTDA pila3 = new Pila();
        pila3.inicializarPila();
        
        System.out.println("Caso 3: Pila vacía");
        mostrarPila("Contenido de la pila:", pila3);
        
        DiccionarioSimpleTDA frecuencias3 = pilaDiccionario.contarFrecuencias(pila3);
        mostrarDiccionario("Frecuencias:", frecuencias3);
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
     * Método auxiliar para mostrar el contenido de un diccionario
     */
    private static void mostrarDiccionario(String mensaje, DiccionarioSimpleTDA diccionario) {
        System.out.println(mensaje);
        
        ConjuntoTDA claves = diccionario.claves();
        
        if (claves.conjuntoVacio()) {
            System.out.println("El diccionario está vacío");
            return;
        }
        
        System.out.println("Elemento\tFrecuencia");
        System.out.println("------------------------");
        
        // Creamos un array auxiliar para almacenar todas las claves primero
        int[] todasLasClaves = new int[100]; // Asumimos un máximo de 100 claves
        int cantidadClaves = 0;
        
        // Recolectamos todas las claves primero
        while (!claves.conjuntoVacio()) {
            int clave = claves.elegir();
            todasLasClaves[cantidadClaves++] = clave;
            claves.sacar(clave);
        }
        
        // Ahora recorremos el array de claves
        for (int i = 0; i < cantidadClaves; i++) {
            int clave = todasLasClaves[i];
            int valor = diccionario.recuperar(clave);
            
            System.out.println(clave + "\t\t" + valor);
        }
    }
}
