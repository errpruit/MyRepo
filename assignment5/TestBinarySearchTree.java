import java.util.*;
import java.io.*;


public class TestBinarySearchTree {

  public static void main(String[] args) {

      Integer[] num = {67, 87, 55, 43, 48, 73, 91, 39, 59, 92, 34, 95, 81, 66, 40, 53, 84, 77};
      // Create an empty BinaryTree
      BinarySearchTree<Integer> tree = new BinarySearchTree<>(num);
     
      Scanner input = new Scanner(System.in);
      System.out.println("\nEnter an element to search");
      Integer key = input.nextInt();
      
      
      System.out.println("\nEnter an element to delete");
      key = input.nextInt();
      
      //complete the code as suggested in the Lab document.
     
  }
}
