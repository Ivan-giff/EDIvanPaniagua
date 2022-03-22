/*
*
* Desarrollar un programa en Java que permita jugar a un juego de preguntas y respuestas
* inspirado en el conocido concurso de televisión Saber y ganar..
*
*/

package ejercicioprogramacion;

/**
 *
 * @author Iván
 * 
 */

/* Declaramos los imports necesarios*/

import java.util.Scanner;

import javax.script.ScriptEngine;

import javax.script.ScriptEngineManager;

public class Paniagua_Ivan_PROG06_Practica {
    
   /* Declaracion de las variables globales necesarias */
    
   static String [] jugadores;
   
   static int [] puntuacion;
   
   static String expresion="";
   
   static String expresion2="";
   
   static String numCadena;
   
   static int resultado;
   
   
   /**
    * 
    * @param puntuacion
    * 
    * @return hueco 
    * 
    * La siguiente funcion es la ultima de todas y comprueba cual es el ganador
    * se le introduce el array de puntuaciones y calcula el ganador
    * 
    * 
    */
   
   
   public static int FinPartida(int [] puntuacion){
    
       /* Decalramos las variables necesarias */
       
       int punt=0;
       
       int hueco=0;
       
       /*Hacemos un bucle para comparar las puntuaciones*/
       
       for(int i=0;i<puntuacion.length;i++){
           
           /* Comprobamos si la puntuacion que hay en el hueco es mayor, y si es asi guardamos esa puntuacion y ese hueco */
           
           if(punt<puntuacion[i]){
               
               punt=puntuacion[i];
               
               hueco=i;
           }
           
           
       }
               
    /*Devolvemos el sitio del array donde esta el ganador */ 
       
    return hueco;
    
    }
   /**
    * 
    * @param expresion
    * 
    * @return valor
    * 
    * Funcion que al Introducir nuestro String nos devuelve el resultado
    * 
    */
   
   public static int evaluarExpresion (String expresion) {
        
       int valor = 0;
        
       try {
            
           ScriptEngineManager manager = new ScriptEngineManager();
            
           ScriptEngine engine = manager.getEngineByName("javascript");
            
           Object result = engine.eval(expresion);
            
           valor = Integer.decode(result.toString());
            
        } catch (Exception e) {
            
            e.getMessage();
        }
               
       return valor;
    }
   
   /**
    * 
    * Funcion que nos genera la expresion matematica que luego mandaremos a evaluar expresion y nos dara el resultado matematico
    * 
    * 
    */
   
   
   public static void Operaciones(){
       
       /*Generamos el numero de numeros que hay que generar*/
       
       int numeroDeNumeros = (int) (3+Math.random()*(7-3+1));
               
       /* Generamos un bucle el cual nos dara un numero aleatorio entre 2 y 12*/
       
       for (int i =0;i<numeroDeNumeros;i++){
           
           /* Generamos el numero */
           
           int numeroRandom = (int) (2+Math.random()*(12-2+1));
           
           /* Pasamos el valor generado a un string */
           
            numCadena= String.valueOf(numeroRandom);
           
            /* Lo sumamos a la cadena expresion*/
            
            expresion=expresion+numCadena;
            
            /* Generamos un numero aleatorio entre 1-3 para un operador */
            
            int operador =1+ (int) (Math.random()*3);
            
            /* Generamos un switch con los operadores + * - */
            
            switch(operador){
                
                /* El caso uno es la suma */
                
                case 1:
                    
                    /* Añadimos la suma a la expresion */
                    
                   expresion=expresion+"+";
                   
                   /* Finalizamos el switch */
                   
                   break;
                   
                /* El caso dos es el de la multiplicacion */   
                
                case 2:
                
                    /* Añadimos la multiplicacion a la xpresion */
                    
                   expresion=expresion+"*";
                   
                   /* Finalizamos el switch */
                   
                   break;
                   
                /* El caso tres es el de la resta */   
                   
                case 3:
                    
                   /* Guardamos la resta en la expresion */ 
                    
                   expresion=expresion+"-";
                   
                   /* Finalizamos el switch */
                   
                   break;
                
                
                
            }
            
            
       }
       
       /* Añadimos un numero mas para que la expresion no quede con un operador */
       
       expresion=expresion+numCadena;
       
       /* Copiamos la expresion a otra para enviarla a la funcion main */
       
       expresion2=expresion;
       
       /* Evaluamos la expresion con la funcion evaluarExpresion */
       
       resultado=evaluarExpresion(expresion);
       
       /* "Reseteamos" la expresion */
       
       expresion="";
       
       
       
     }
   
   /**
    * 
    * 
    * @param contRondas 
    * 
    * Esta funcion lleva acabo las rondas que incluye
    * la pregunta, guardar los puntos y pasar a la siguiente ronda
    * 
    * 
    */
   
   
   public static void Rondas(int contRondas){
    
    /* Requerimiento de la clase Scanner */   
       
    Scanner entrada=new Scanner (System.in);   
    
    /*Creamosun contador para saber el numero de la ronda */
       
    int cont=1;
    
    /* Creamos un bucle para hacer el numero de rondas que necesitemos */
    
    for(int i=0;i<contRondas;i++){
     
    System.out.println("=======================================================");
    
    /* Escribimos el numero de ronda que es */    
    
    System.out.println("Ronda "+cont+"");
    
    /* Creamos un bucle para que en la misma ronda juegen todos los jugadores */
    
    for(int j =0;j<jugadores.length;j++){ 
        
    /* Escribimos el turno del jugador */
        
    System.out.println("Le toca al jugador "+jugadores[j]+"");
    
    /* LLamamos a la funcion operaciones para crear la operacion que necesitamos */
    
    Operaciones();
    
    /* Escribimos la expresion matematica que obtenemos de la funcion operaciones */
    
    System.out.println("La pregunta es "+expresion2+" ");
    
    /* Pedimos la respesta del jugador */
    
    System.out.println("Escribe la respuesta :");
    
    /* ( Escribimos el resultado para hacer las pruebas mas sencillas ) */ 
    
    System.out.println("(La respuesta es : "+resultado+")");
    
    /* Recogemos la respuesta del jugador y la guaradamos */
    
    int respuesta=entrada.nextInt();
    
    /*  Comprobamos si la respuesta del jugador es la misma que el resultado obtenido de la funcion evaluarExpresion */
    
    if(respuesta==resultado){
        
        /* Si es que si escribimos correcto */
        
        System.out.println("Correcto");
        
        System.out.println("=======================================================");

        /* y sumamos un punto al jugador */
        
        puntuacion[j]++;
        
        
        
    }
    
    else{
        
        /* Si es que no escribimos que ha fallado y la respuesta correcta */ 
        
        System.out.println("Vaya has fallado, la respuesta correcta era : "+resultado+" ");
        
        System.out.println("=======================================================");    
        
    }
    
    }
    
    
    /* Una vez todos los jugadores terminen la ronda escribimos el fin de ronda */
    
    System.out.println("Fin de la ronda "+cont+" las puntuaciones son las siguientes : ");
    
    System.out.println("=======================================================");
    
    /* Creamos un bucle para acceder a la puntuacion y el nombre de todos os jugadores */
    
    for(int z=0 ; z<jugadores.length ; z++){
        
    /* Escribimos la puntuacion y el nombre de cada jugador */    
        
    System.out.println("===== La puntuacion de "+jugadores[z]+" es : "+puntuacion[z]+" ===== ");    
        
        
    }
    
    /* Sumamos uno al contador de rondas */
    
    cont++;
    
    System.out.println("=======================================================");

    }   
       
   }
   
   /**
    * 
    * @param a 
    * 
    * Esta funcion se encarga de crear el array de jugadores y el array de puntuaciones con el numero introducido
    * Una vez introducido el numero este preguntara poir el nombre de todos los jugadores y los guardara en el array jugadores
    * 
    * 
    * 
    */
   
   
   public static void guardarJugadores(int a){
       
    /* Requerimiento de la clase Scanner */   
       
    Scanner entrada=new Scanner (System.in);  
       
    /* Declaramos el numero de "huecos" que tendra el array jugadores */
    
    jugadores=new String[a];
    
    /* Declaramos el numero de "huecos" que tendra el array puntuaciones */
    
    puntuacion=new int [a];
    
    /* Creamos un bucle para aceder al arary de jugadoeres */
    
    for(int i =0;i<jugadores.length;i++){ 
        
        /* Preguntamos por el nombre del jugador que corresponda */
        
        System.out.println("Escribe el nombre del jugador "+(i+1));
        
        /* Guardamos el nombre en el "hueco" correspondiente */
        
        jugadores[i]=entrada.nextLine();
    }
    
    
    }
    
   /**
    * 
    * @param args
    * 
    * La funcion main la cual se encarga de enlazar todo 
    * y empezar el juego
    * 
    */
   
   public static void main(String [] args){
    
       /* Requerimiento de la clase Scanner */
       
       Scanner entrada=new Scanner (System.in);
       
       System.out.println("=======================================================");
       
       /* Escribimos un pequeño prologo */
       
       System.out.println("Bienvenido al juego del concurso de los números el cual \n"
                        + "trata de una serie de preguntas matemáticas\n" +
                          "donde solo habrá un ganador.");
       
        System.out.println("=======================================================");
        
        /* Preguntamos por el numero de jugadores que van a jugar */
        
        System.out.println("Elige el numero de jugadores de 1 a 6");
        
        /* Guardamoes el numero de jugadores */
        
        int a = entrada.nextInt();

            /* Comprobamos que el numero de jugadores no sea mayor de 6 */
        
            if(a>6){
                
                /* Si es mayor de 6 escribimos un "error" */
                
                System.out.println("Has introducido un numero de jugadores invalido");
                
            }
            
            /* Si no continuamos */
            
            else{
           
            /* Llamamos a la funcion jugadores para guardar los jugadores */    
                
            guardarJugadores(a);

            System.out.println("=======================================================");
            
            /* Pedimos el numero de rondas que queremos */ 
            
            System.out.println("Introduce el numero de rondas que quieres jugar siendo \n"
                             + "3 (Partida rapida) 5 (Partida corta)\n"
                             + "10 (Partida normal) 20 (Partida larga)");
            
            System.out.println("=======================================================");
            
            /* Guardamos el numero en una variable */
            
            int contRondas=entrada.nextInt();
                
            /* Llamamos a la funcion rondas con el valor de las rondas que son */
            
            Rondas(contRondas);
            
            /* LLamamos a la funion FinPartida con el array de puntuaciones para guardar el "hueco" del ganador */
            
            int hueco=FinPartida(puntuacion);
            
            /* Escribimos que es el fin de la partida */
            
            System.out.println("Fin de la partida las puntuaciones son :");
            
            /* Escribimos el ganador */
            
            System.out.println("========= El ganador es : "+jugadores[hueco]+" con una putuación de : "+puntuacion[hueco]+"");
            
            /* Creamos un bucle para escribir la puntuacion de cafa jugador al finalizar */
            
            for(int i=0; i<jugadores.length;i++){

                /* Escribimos la puntuacion de cada jugador */
                
                System.out.println("===== La puntuacion de "+jugadores[i]+" es : "+puntuacion[i]+" ===== ");
                
            }
            
            System.out.println("=======================================================");

            System.out.println("Gracias por jugar ^_^ ");
            
            }
       
   } 
    
    
}
