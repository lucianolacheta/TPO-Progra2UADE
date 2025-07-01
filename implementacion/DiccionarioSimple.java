package implementacion;

import tda.DiccionarioSimpleTDA;
import tda.ColaPrioridadTDA;
import imple.ColaPrioridad;
import tda.ConjuntoTDA;
import imple.Conjunto;

/*
Ejercicio05
DiccionarioSimple con ColaPrioridadTDA
Implementar DiccionarioSimpleTDA (métodos agregar, eliminar, recuperar, claves) 
usando solo una ColaPrioridadTDA para guardar los pares clave→valor.
*/

/*
Estrategia:
Como no se puede modificar directamente la cola, para cada operación se 
recorren todos los elementos, se los almacena temporalmente y se vuelve 
a construir la cola con los cambios aplicados.
*/

public class DiccionarioSimple implements DiccionarioSimpleTDA {

 private ColaPrioridadTDA datos;

 @Override
 public void inicializarDiccionario() { // O(1)
     datos = new ColaPrioridad();
     datos.inicializarCola();
 }

 @Override
 public void agregar(int clave, int valor) { // O(n)
     ColaPrioridadTDA aux = new ColaPrioridad();
     aux.inicializarCola();
     boolean actualizado = false;

     while (!datos.colaVacia()) {
         int elem = datos.primero();
         int prio = datos.prioridad();
         datos.desacolar();

         if (prio == clave) {
             aux.acolarPrioridad(valor, clave); // reemplaza
             actualizado = true;
         } else {
             aux.acolarPrioridad(elem, prio);
         }
     }

     if (!actualizado) {
         aux.acolarPrioridad(valor, clave); // nuevo par
     }

     datos = aux;
 }

 @Override
 public void eliminar(int clave) { // O(n)
     ColaPrioridadTDA aux = new ColaPrioridad();
     aux.inicializarCola();

     while (!datos.colaVacia()) {
         int elem = datos.primero();
         int prio = datos.prioridad();
         datos.desacolar();

         if (prio != clave) {
             aux.acolarPrioridad(elem, prio);
         }
     }

     datos = aux;
 }

 @Override
 public int recuperar(int clave) { // O(n)
     ColaPrioridadTDA aux = new ColaPrioridad();
     aux.inicializarCola();
     int valor = -1;

     while (!datos.colaVacia()) {
         int elem = datos.primero();
         int prio = datos.prioridad();
         datos.desacolar();

         if (prio == clave) {
             valor = elem;
         }

         aux.acolarPrioridad(elem, prio);
     }

     datos = aux;
     return valor;
 }

 @Override
 public ConjuntoTDA claves() { // O(n)
     ConjuntoTDA claves = new Conjunto();
     claves.inicializarConjunto();

     ColaPrioridadTDA aux = new ColaPrioridad();
     aux.inicializarCola();

     while (!datos.colaVacia()) {
         int elem = datos.primero();
         int prio = datos.prioridad();
         datos.desacolar();

         claves.agregar(prio);
         aux.acolarPrioridad(elem, prio);
     }

     datos = aux;
     return claves;
 }
}