/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ujd.calculator;

/**
 *
 * @author Tcwik
 */
public class CalculatorModel {

    double pre;
    double aft;
    char operator;
    double solution;

    public void calculate() {
        switch (operator) {
            case '+':
                solution = pre + aft;
                break;
            case '-':
                solution = pre - aft;
                break;
            case 'x':
                solution = pre * aft;
                break;
            case '/':
                solution = pre / aft;
                break;
            default:
            // code block
                
        }
        
    }
}
