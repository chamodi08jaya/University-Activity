/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package add;

/**
 *
 * @author Chamodi
 */
import java.util.Scanner;
public class Add {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner s=new Scanner(System.in);
        System.out.print("Enter the start no:");
        int x=s.nextInt();
          
        System.out.print("Enter the end no:");
         int y=s.nextInt();
       int total=0;
        for(int i=x;i<=y;i++){
            total=total+i;
        }
        System.out.println("Total="+total);
        }
        // TODO code application logic here
    }

