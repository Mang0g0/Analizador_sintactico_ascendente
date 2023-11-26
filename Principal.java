/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package cr.principal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

public class Principal {
    static boolean existenErrores=false;
    public static void main(String[] args)throws IOException{
         ejecutarPrompt();   
    }
    public static void ejecutarPrompt()throws IOException{
        InputStreamReader input= new InputStreamReader(System.in);
        BufferedReader reader= new BufferedReader(input);

        for(;;){
            System.out.print(">>>");
            String linea=reader.readLine();
            if(linea==null) break;
            ejecutar(linea);
            existenErrores=false;
        }
    }
    public static void ejecutar(String source){
       Scanner scanner= new Scanner(source);
        List<Token> tokens= scanner.scanTokens();
        /* 
        for(Token token : tokens){
            System.out.println(token);
        }
         */
        
        Parser parser = new ASA(tokens);
        boolean exito = parser.parse(); // Llama al método parse y almacena el resultado
     
        if(exito){
            System.out.println("Consulta correcta.");
        }
        
    }
}