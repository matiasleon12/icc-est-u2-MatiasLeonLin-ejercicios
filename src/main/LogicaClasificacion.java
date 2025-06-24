package main;

import java.util.*;

public class LogicaClasificacion {

    

    /**
     * Invierte una cadena de texto utilizando una pila (Stack).
     *
     * @param texto Cadena original a invertir.
     * @return Cadena invertida
     *
     *         Ejemplo:
     *         Entrada: "Hola Mundo"
     *         Salida: "odnuM aloH"
     */
    public String invertirCadena(String texto) {

        Stack<Character> pila = new Stack<>();
        StringBuilder resultado = new StringBuilder();

        for (char c : texto.toCharArray()) {
            pila.push(c);
        }

        while (!pila.isEmpty()) {
            resultado.append(pila.pop());
        }

        return resultado.toString();


    
    }

    /**
     * Verifica si los símbolos de paréntesis, corchetes y llaves están bien
     * balanceados
     *
     * @param expresion Cadena con símbolos.
     * @return true si está balanceada, false en caso contrario.
     *
     *         Ejemplo:
     *         Entrada: "{[()]}"
     *         Salida: true
     */
    public boolean validarSimbolos(String expresion) {

        Stack<Character> pila = new Stack<>();
        Map<Character, Character> pares = Map.of(
            ')', '(', 
            '}', '{', 
            ']', '['
        );

        for (char c : expresion.toCharArray()) {
            if (pares.containsValue(c)) {
                pila.push(c);
            } else if (pares.containsKey(c)) {
                if (pila.isEmpty() || pila.pop() != pares.get(c)) {
                    return false;
                }
            }
        }

        return pila.isEmpty();
        
    }

    /**
     * Ordena una pila de enteros en orden ascendente usando otra pila auxiliar.
     *
     * @return Lista ordenada.
     *
     *         Ejemplo:
     *         Entrada: [3, 1, 4, 2]
     *         Salida: [1, 2, 3, 4]
     */
    public List<Integer> ordenarPila(Stack<Integer> pila) {
        Stack<Integer> num = new Stack<>();

        while (!pila.isEmpty()) {
            int temp = pila.pop();

            while (!num.isEmpty() && num.peek() < temp) {
                pila.push(num.pop());
            }

            num.push(temp);
        }
        List<Integer> resultado = new ArrayList<>();
        while (!num.isEmpty()) {
            resultado.add(num.pop());
        }
        
            
        
        return new ArrayList<>(resultado);
    }

    /**
     * Clasifica una lista de enteros separando pares e impares.
     * Usa LinkedList para mantener el orden de inserción.
     *
     * @return Lista con pares primero, luego impares.
     *
     *         Ejemplo:
     *         Entrada: [1, 2, 3, 4, 5, 6]
     *         Salida: [2, 4, 6, 1, 3, 5]
     */
    public List<Integer> clasificarPorParidad(LinkedList<Integer> original) {

        LinkedList<Integer> par = new LinkedList<>();
        LinkedList<Integer> impar = new LinkedList<>();

        for (int numero : original) {
            if (numero % 2 == 0) {
                par.add(numero);
            } else {
                impar.add(numero);
            }
        }

        LinkedList<Integer> resultado = new LinkedList<>();
        resultado.addAll(par);
        resultado.addAll(impar);

    

        return new ArrayList<>(resultado);
    }
}
