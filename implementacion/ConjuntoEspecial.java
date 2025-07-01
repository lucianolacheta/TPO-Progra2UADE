package implementacion;

import interfaz.ConjuntoEspecialTDA;
import tda.ConjuntoTDA;
import imple.Conjunto;

/*
Ejercicio01
ConjuntoEspecialTDA
Extiende ConjuntoTDA para que sus operaciones (agregar, sacar, elegir) 
devuelvan un objeto Respuesta que indica si la operación fue exitosa y, 
cuando aplica, el valor involucrado.
*/

/*
Estrategia:
Se utiliza un ConjuntoTDA como base. Cada método verifica con pertenece() 
o conjuntoVacio() si la operación fue exitosa y devuelve una Respuesta con
un booleano de error y, si corresponde, un valor.
*/
public class ConjuntoEspecial implements ConjuntoEspecialTDA {
 private ConjuntoTDA conjunto;

 @Override
 public void inicializarConjunto() { // O(1)
     conjunto = new Conjunto();
     conjunto.inicializarConjunto();
 }

 @Override
 public Respuesta agregar(int valor) { // O(n)
     Respuesta res = new Respuesta();
     if (conjunto.pertenece(valor)) {
         res.error = true;
     } else {
         conjunto.agregar(valor);
         res.error = false;
     }
     return res;
 }

 @Override
 public Respuesta sacar(int valor) { // O(n)
     Respuesta res = new Respuesta();
     if (!conjunto.pertenece(valor)) {
         res.error = true;
     } else {
         conjunto.sacar(valor);
         res.error = false;
     }
     return res;
 }

 @Override
 public Respuesta elegir() { // O(1)
     Respuesta res = new Respuesta();
     if (conjunto.conjuntoVacio()) {
         res.error = true;
     } else {
         res.rta = conjunto.elegir();
         res.error = false;
     }
     return res;
 }

 @Override
 public boolean conjuntoVacio() { // O(1)
     return conjunto.conjuntoVacio();
 }
}
