/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ejercicioprogramacion;

import static ejercicioprogramacion.Paniagua_Ivan_PROG06_Practica.FinPartida;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 *
 * @author madrid
 * 
 */

public class Paniagua_Ivan_PROG06_PracticaTest {
    
    public Paniagua_Ivan_PROG06_PracticaTest() {
    }

    /**
     * 
     * Test of FinPartida method, of class Paniagua_Ivan_PROG06_Practica.
     * 
     */
    
    @Test
    
    public void testFinPartida() {
        
        System.out.println("FinPartida");
        
        int[] puntuacion = {1,2,3,2,5};
        
        int  expResult = 4;
        
        int result = FinPartida(puntuacion);
        
        assertEquals(expResult, result);
        
    }

    /**
     * 
     * Test of evaluarExpresion method, of class Paniagua_Ivan_PROG06_Practica.
     * 
     */
    
    @Test
    
    public void testEvaluarExpresion() {
        
        System.out.println("evaluarExpresion");
        
        String expresion = "5*3-5-8+10";
        
        int expResult = 12;
        
        int result = Paniagua_Ivan_PROG06_Practica.evaluarExpresion(expresion);
        
        assertEquals(expResult, result);
        
        
    }

    /**
     * 
     * Test of Operaciones method, of class Paniagua_Ivan_PROG06_Practica.
     * 
     */
    
    @Test
    
    public void testMain() {
        
        System.out.println("main");
        
        String[] args = null;
        
        Paniagua_Ivan_PROG06_Practica.main(args);
        
        // TODO review the generated test code and remove the default call to fail.
        
    }
    
}
