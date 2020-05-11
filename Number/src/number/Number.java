/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package number;

/**
 *
 * @author Chamodi
 */import java.util.Scanner;
public class Number {
  void getSum(int x,int y){
      int Total=0;
      for (int i=x;i<=y;i++){
          Total=Total+i;
      }
      System.out.println("Total="+Total);
  }
  
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner s=new Scanner(System.in);
        System.out.print("Enter the start no:");
        int x=s.nextInt();    
        System.out.print("Enter the end no:");
        int y=s.nextInt();    
Number n=new Number();
n.getSum(x, y);
        
        // TODO code application logic here
    }
}
