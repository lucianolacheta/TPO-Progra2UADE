package implementacion;


import tda.*;
import imple.*;
import interfaz.*;

//EJERCICIO 3
public class MultiPila implements MultiPilaTDA {
    private PilaTDA pila;
  
    @Override
    public void inicializarPila() {
        pila = new Pila();
        pila.inicializarPila();
    }
  
    @Override
    public boolean pilaVacia() {
        return pila.pilaVacia();
    }
  
    @Override
    public void apilar(PilaTDA valores) {
        PilaTDA temp = copiarPila(valores);
        PilaTDA inversa = invertirPila(temp);
  
        while (!inversa.pilaVacia()) {
            pila.apilar(inversa.tope());
            inversa.desapilar();
        }
    }
  
    @Override
    public void desapilar(PilaTDA valores) {
        PilaTDA copiaMultipila = copiarPila(pila);
        PilaTDA copiaValores = copiarPila(valores);
  
        boolean coincide = true;
        while (!copiaValores.pilaVacia()) {
            if (copiaMultipila.pilaVacia() || copiaMultipila.tope() != copiaValores.tope()) {
                coincide = false;
                break;
            }
            copiaMultipila.desapilar();
            copiaValores.desapilar();
        }
  
        if (coincide) {
            // Si coincide, desapilamos desde la original
            PilaTDA aux = copiarPila(valores);
            while (!aux.pilaVacia()) {
                pila.desapilar();
                aux.desapilar();
            }
        }
    }
  
    @Override
    public PilaTDA tope(int cantidad) {
        PilaTDA resultado = new Pila();
        resultado.inicializarPila();
  
        PilaTDA copia = copiarPila(pila);
        PilaTDA temp = new Pila();
        temp.inicializarPila();
  
        int count = 0;
        while (!copia.pilaVacia() && count < cantidad) {
            temp.apilar(copia.tope());
            copia.desapilar();
            count++;
        }
  
        while (!temp.pilaVacia()) {
            resultado.apilar(temp.tope());
            temp.desapilar();
        }
  
        return resultado;
    }
  
    //Auxiliar;
    private PilaTDA copiarPila(PilaTDA original) {
        PilaTDA temp = new Pila(); temp.inicializarPila();
        PilaTDA copia = new Pila(); copia.inicializarPila();
  
        PilaTDA aux = new Pila(); aux.inicializarPila();
  
        PilaTDA aux2 = new Pila(); aux2.inicializarPila();
  
        PilaTDA tempOriginal = new Pila(); tempOriginal.inicializarPila();
  
        while (!original.pilaVacia()) {
            int e = original.tope();
            temp.apilar(e);
            tempOriginal.apilar(e);
            original.desapilar();
        }
        while (!tempOriginal.pilaVacia()) {
            original.apilar(tempOriginal.tope());
            tempOriginal.desapilar();
        }
        while (!temp.pilaVacia()) {
            aux.apilar(temp.tope());
            temp.desapilar();
        }
        while (!aux.pilaVacia()) {
            copia.apilar(aux.tope());
            aux.desapilar();
        }
  
        return copia;
    }
  
    private PilaTDA invertirPila(PilaTDA pilaOriginal) {
        PilaTDA invertida = new Pila(); invertida.inicializarPila();
        PilaTDA temp = copiarPila(pilaOriginal);
  
        while (!temp.pilaVacia()) {
            invertida.apilar(temp.tope());
            temp.desapilar();
        }
        return invertida;
    }
  }
  