package tests;

import implementacion.DiccionarioSimpleMod;
import interfaz.DiccionarioSimpleModTDA;
import tda.ConjuntoTDA;

/**
 * Clase para probar la implementación de DiccionarioSimpleModTDA
 */
public class DiccionarioSimpleModTest {
    public static void main(String[] args) {
        System.out.println("Prueba de la implementación de DiccionarioSimpleMod");
        System.out.println("=======================================");
        
        // Inicializamos el diccionario
        DiccionarioSimpleModTDA diccionario = new DiccionarioSimpleMod();
        diccionario.inicializarDiccionario();
        
        // Agregamos elementos
        System.out.println("\n1. Agregando elementos:");
        diccionario.agregar(10, 100);
        diccionario.agregar(20, 200);
        diccionario.agregar(30, 300);
        
        // Mostramos el diccionario completo
        mostrarDiccionario("Diccionario inicial:", diccionario);
        
        // Modificamos algunos valores
        System.out.println("\n2. Modificando valores:");
        diccionario.agregar(10, 150); // Primera modificación de clave 10
        mostrarDiccionario("Después de modificar clave 10 (primera vez):", diccionario);
        
        diccionario.agregar(20, 250); // Primera modificación de clave 20
        diccionario.agregar(10, 175); // Segunda modificación de clave 10
        mostrarDiccionario("Después de más modificaciones:", diccionario);
        
        // Eliminamos un elemento
        System.out.println("\n3. Eliminando un elemento:");
        diccionario.eliminar(20);
        mostrarDiccionario("Después de eliminar clave 20:", diccionario);
        
        // Probamos recuperar el factor de modificación específicamente
        System.out.println("\n4. Verificando factor de modificación:");
        System.out.println("Clave 10 - Valor: " + diccionario.recuperar(10) + 
                         ", Factor de modificación: " + diccionario.recuperarMod(10));
        System.out.println("Clave 30 - Valor: " + diccionario.recuperar(30) + 
                         ", Factor de modificación: " + diccionario.recuperarMod(30));
        
        // Agregamos más elementos y modificaciones para probar
        System.out.println("\n5. Más operaciones:");
        diccionario.agregar(40, 400);
        diccionario.agregar(10, 180); // Tercera modificación de clave 10
        diccionario.agregar(30, 350); // Primera modificación de clave 30
        diccionario.agregar(30, 375); // Segunda modificación de clave 30
        mostrarDiccionario("Estado final del diccionario:", diccionario);
    }
    
    /**
     * Método auxiliar para mostrar el contenido completo del diccionario
     */
    private static void mostrarDiccionario(String mensaje, DiccionarioSimpleModTDA diccionario) {
        System.out.println(mensaje);
        
        ConjuntoTDA claves = diccionario.claves();
        
        // Usamos el método conjuntoVacio() directamente en lugar de try-catch
        if (claves.conjuntoVacio()) {
            System.out.println("El diccionario está vacío");
            return;
        }
        
        System.out.println("Clave\tValor\tFactor Mod");
        System.out.println("---------------------");
        
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
            int factorMod = diccionario.recuperarMod(clave);
            
            System.out.println(clave + "\t" + valor + "\t" + factorMod);
        }
        System.out.println();
    }
}
