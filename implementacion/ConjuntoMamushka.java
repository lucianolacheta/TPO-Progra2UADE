package implementacion;

import interfaz.ConjuntoMamushkaTDA;
import tda.DiccionarioSimpleTDA;
import imple.DiccionarioSimple;
import tda.ConjuntoTDA;

//Estrategia:
//Se usa un DiccionarioSimpleTDA para almacenar la cantidad de veces que se agregó cada valor.
//La clave es el valor y el contenido es la cantidad de repeticiones. Los métodos ajustan ese contador según corresponda.


public class ConjuntoMamushka implements ConjuntoMamushkaTDA {
 private DiccionarioSimpleTDA repeticiones;

 @Override
 public void inicializar() { // O(1)
     repeticiones = new DiccionarioSimple();
     repeticiones.inicializarDiccionario();
 }

 @Override
 public void guardar(int dato) { // O(n)
     if (repeticiones.claves().pertenece(dato)) {
         int actual = repeticiones.recuperar(dato);
         repeticiones.agregar(dato, actual + 1);
     } else {
         repeticiones.agregar(dato, 1);
     }
 }

 @Override
 public void sacar(int dato) { // O(n)
     if (repeticiones.claves().pertenece(dato)) {
         int actual = repeticiones.recuperar(dato);
         if (actual == 1) {
             repeticiones.eliminar(dato);
         } else {
             repeticiones.agregar(dato, actual - 1);
         }
     }
 }

 @Override
 public int elegir() { // O(n)
     ConjuntoTDA claves = repeticiones.claves();
     if (!claves.conjuntoVacio()) {
         return claves.elegir();
     } else {
         return -1;
     }
 }

 @Override
 public int perteneceCant(int dato) { // O(n)
     if (repeticiones.claves().pertenece(dato)) {
         return repeticiones.recuperar(dato);
     } else {
         return 0;
     }
 }

 @Override
 public boolean estaVacio() { // O(1)
     return repeticiones.claves().conjuntoVacio();
 }
}
