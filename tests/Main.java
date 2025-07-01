package tests;

import tda.*;
import imple.*;
import implementacion.*;

public class Main {
    public static void main(String[] args) {
        System.out.println("---------- Ejercicio06: porcentajePares ----------");
        PilaTDA pila06 = new Pila(); pila06.inicializarPila();
        pila06.apilar(1); pila06.apilar(2); pila06.apilar(3); pila06.apilar(4);
        float res06 = Ejercicio06.porcentajePares(pila06);
        System.out.println("Resultado: " + res06 + " (Esperado: 50.0)");

        System.out.println("\n---------- Ejercicio07: elementosRepetidos ----------");
        Ejercicio07 ej7 = new Ejercicio07();
        PilaTDA pila7 = new Pila(); pila7.inicializarPila();
        pila7.apilar(1); pila7.apilar(2); pila7.apilar(2); pila7.apilar(3); pila7.apilar(3); pila7.apilar(4);
        ConjuntoTDA rep7 = ej7.elementosRepetidos(pila7);
        System.out.print("Repetidos: ");
        while (!rep7.conjuntoVacio()) {
            int v = rep7.elegir(); rep7.sacar(v);
            System.out.print(v + " ");
        }
        System.out.println(" (Esperado: 2 3 )");

        System.out.println("\n---------- Ejercicio08: inRepetidos ----------");
        ColaTDA cola8 = new Cola(); cola8.inicializarCola();
        cola8.acolar(1); cola8.acolar(2); cola8.acolar(2); cola8.acolar(3); cola8.acolar(1);
        ColaTDA res8 = Ejercicio08.inRepetidos(cola8);
        System.out.print("Sin repetidos: ");
        while (!res8.colaVacia()) {
            System.out.print(res8.primero() + " ");
            res8.desacolar();
        }
        System.out.println(" (Esperado: 1 2 3 )");

        System.out.println("\n---------- Ejercicio09: elementosComunes ----------");
        PilaTDA pila9 = new Pila(); pila9.inicializarPila();
        pila9.apilar(1); pila9.apilar(2); pila9.apilar(3);
        ColaTDA cola9 = new Cola(); cola9.inicializarCola();
        cola9.acolar(3); cola9.acolar(4); cola9.acolar(1);
        ConjuntoTDA com9 = Ejercicio09.elementosComunes(pila9, cola9);
        System.out.print("Comunes: ");
        while (!com9.conjuntoVacio()) {
            int v = com9.elegir(); com9.sacar(v);
            System.out.print(v + " ");
        }
        System.out.println(" (Esperado: 1 3 )");

        System.out.println("\n---------- Ejercicio10: contarFrecuencias ----------");
        Ejercicio10 ej10 = new Ejercicio10();
        PilaTDA pila10 = new Pila(); pila10.inicializarPila();
        pila10.apilar(5); pila10.apilar(5); pila10.apilar(6); pila10.apilar(7); pila10.apilar(6);
        DiccionarioSimpleTDA freq10 = ej10.contarFrecuencias(pila10);
        ConjuntoTDA claves10 = freq10.claves();
        System.out.println("Frecuencias:");
        while (!claves10.conjuntoVacio()) {
            int k = claves10.elegir(); claves10.sacar(k);
            System.out.println(k + ": " + freq10.recuperar(k));
        }
        System.out.println("(Esperado: 5:2, 6:2, 7:1)");

        System.out.println("\n---------- Ejercicio11: valoresUnicos ----------");
        DiccionarioMultipleTDA dic11 = new DiccionarioMultiple(); dic11.inicializarDiccionario();
        dic11.agregar(1, 10); dic11.agregar(1, 20); dic11.agregar(2, 20); dic11.agregar(2, 30);
        ColaTDA res11 = Ejercicio11.valoresUnicos(dic11);
        System.out.print("Valores unicos: ");
        while (!res11.colaVacia()) {
            System.out.print(res11.primero() + " ");
            res11.desacolar();
        }
        System.out.println(" (Esperado: 10 20 30 )");

        System.out.println("\n---------- Ejercicio12: sumaImpares ----------");
        ABBTDA arbol12 = new ABB(); arbol12.inicializarArbol();
        arbol12.agregarElem(5); arbol12.agregarElem(10); arbol12.agregarElem(3);
        int sum12 = Ejercicio12.sumaImpares(arbol12);
        System.out.println("Resultado: " + sum12 + " (Esperado: 8)");

        System.out.println("\n---------- Ejercicio13: cantidadHojasPares ----------");
        Ejercicio13 ej13 = new Ejercicio13();
        ABBTDA arbol13 = new ABB(); arbol13.inicializarArbol();
        arbol13.agregarElem(1); arbol13.agregarElem(2); arbol13.agregarElem(3); arbol13.agregarElem(4);
        int res13 = ej13.cantidadHojasPares(arbol13);
        System.out.println("Resultado: " + res13 + " (Esperado: 1)");

        System.out.println("\n---------- Ejercicio14: verticesPuente ----------");
        GrafoTDA g14 = new Grafo(); g14.inicializarGrafo();
        g14.agregarVertice(1); g14.agregarVertice(2); g14.agregarVertice(3);
        g14.agregarArista(1,2,1); g14.agregarArista(2,3,1);
        ConjuntoTDA puentes = Ejercicio14.verticesPuente(g14, 1, 3);
        System.out.print("Puentes: ");
        while (!puentes.conjuntoVacio()) {
            int p = puentes.elegir(); puentes.sacar(p);
            System.out.print(p + " ");
        }
        System.out.println(" (Esperado: 2)");

        System.out.println("\n---------- Ejercicio15: gradoVertice ----------");
        GrafoTDA g15 = new Grafo(); g15.inicializarGrafo();
        g15.agregarVertice(1); g15.agregarVertice(2); g15.agregarVertice(3);
        g15.agregarArista(1,2,1); g15.agregarArista(3,1,1);
        int grado = Ejercicio15.gradoVertice(g15, 1);
        System.out.println("Grado neto: " + grado + " (Esperado: 0)");
    }
}