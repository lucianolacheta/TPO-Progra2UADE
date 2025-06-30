package tests;


import implementacion.ABBUtil;
import interfaz.ABBUtilTDA;
import tda.ABBTDA;
import imple.ABB;

/**
 * Clase de prueba para el método cantidadHojasPares
 */
public class ABBUtilTest {

    public static void main(String[] args) {
        System.out.println("Prueba de método cantidadHojasPares");
        System.out.println("==================================\n");
        
        // Inicializamos el utilitario para ABB
        ABBUtilTDA abbUtil = new ABBUtil();
        
        // Caso 1: Árbol con varias hojas pares e impares
        System.out.println("Caso 1: Árbol con varias hojas");
        ABBTDA arbol1 = new ABB();
        arbol1.inicializarArbol();
        arbol1.agregarElem(50);   // Raíz
        arbol1.agregarElem(30);   // Hijo izquierdo
        arbol1.agregarElem(70);   // Hijo derecho
        arbol1.agregarElem(20);   // Hoja (par)
        arbol1.agregarElem(40);   // Hoja (par)
        arbol1.agregarElem(60);   // Hoja (par)
        arbol1.agregarElem(85);   // Hoja (impar)
        
        mostrarArbol("Árbol 1:", arbol1);
        int hojasPares1 = abbUtil.cantidadHojasPares(arbol1);
        System.out.println("Cantidad de hojas pares: " + hojasPares1);
        System.out.println("Valor esperado: 3\n");
        
        // Caso 2: Árbol sólo con hojas impares
        System.out.println("Caso 2: Árbol con hojas impares");
        ABBTDA arbol2 = new ABB();
        arbol2.inicializarArbol();
        arbol2.agregarElem(51);   // Raíz
        arbol2.agregarElem(31);   // Hijo izquierdo
        arbol2.agregarElem(71);   // Hijo derecho
        arbol2.agregarElem(21);   // Hoja (impar)
        arbol2.agregarElem(41);   // Hoja (impar)
        
        mostrarArbol("Árbol 2:", arbol2);
        int hojasPares2 = abbUtil.cantidadHojasPares(arbol2);
        System.out.println("Cantidad de hojas pares: " + hojasPares2);
        System.out.println("Valor esperado: 0\n");
        
        // Caso 3: Árbol sólo con un nodo (raíz) par
        System.out.println("Caso 3: Árbol con un solo nodo (par)");
        ABBTDA arbol3 = new ABB();
        arbol3.inicializarArbol();
        arbol3.agregarElem(10);   // Raíz y única hoja (par)
        
        mostrarArbol("Árbol 3:", arbol3);
        int hojasPares3 = abbUtil.cantidadHojasPares(arbol3);
        System.out.println("Cantidad de hojas pares: " + hojasPares3);
        System.out.println("Valor esperado: 1\n");
        
        // Caso 4: Árbol vacío
        System.out.println("Caso 4: Árbol vacío");
        ABBTDA arbol4 = new ABB();
        arbol4.inicializarArbol();
        
        mostrarArbol("Árbol 4:", arbol4);
        int hojasPares4 = abbUtil.cantidadHojasPares(arbol4);
        System.out.println("Cantidad de hojas pares: " + hojasPares4);
        System.out.println("Valor esperado: 0\n");
    }
    
    /**
     * Método auxiliar para mostrar el árbol (representación simplificada)
     * Este método muestra el árbol en un recorrido inorder (izquierda, raíz, derecha)
     */
    private static void mostrarArbol(String mensaje, ABBTDA arbol) {
        System.out.println(mensaje);
        
        if (arbol.arbolVacio()) {
            System.out.println("Árbol vacío");
            return;
        }
        
        System.out.print("Elementos (inorder): ");
        mostrarInorder(arbol);
        System.out.println();
        
        System.out.print("Hojas: ");
        mostrarHojas(arbol);
        System.out.println();
    }
    
    /**
     * Método recursivo para mostrar los elementos del árbol en inorder
     */
    private static void mostrarInorder(ABBTDA arbol) {
        if (!arbol.arbolVacio()) {
            mostrarInorder(arbol.hijoIzq());
            System.out.print(arbol.raiz() + " ");
            mostrarInorder(arbol.hijoDer());
        }
    }
    
    /**
     * Método recursivo para mostrar las hojas del árbol
     */
    private static void mostrarHojas(ABBTDA arbol) {
        if (!arbol.arbolVacio()) {
            // Si es una hoja
            if (arbol.hijoIzq().arbolVacio() && arbol.hijoDer().arbolVacio()) {
                System.out.print(arbol.raiz() + " ");
            }
            
            mostrarHojas(arbol.hijoIzq());
            mostrarHojas(arbol.hijoDer());
        }
    }
}
