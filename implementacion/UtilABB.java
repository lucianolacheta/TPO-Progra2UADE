package implementacion;

import tda.ABBTDA;

//EJERCICIO 12
public class UtilABB {

    public static int sumaImpares(ABBTDA arbol) {
        if (arbol.arbolVacio()) return 0;
  
        int suma = 0;
        int valor = arbol.raiz();
  
        if (valor % 2 != 0) suma += valor;
  
        suma += sumaImpares(arbol.hijoIzq());
        suma += sumaImpares(arbol.hijoDer());
  
        return suma;
    }
  }
  
  