import java.util.Scanner;
import java.util.Stack;

public class ReverseStack {

   public static void reverseStack(Stack<Integer> stack) {
        if (stack.isEmpty()) return;
        
         int top = stack.pop();
        
        reverseStack(stack);
        
        pushToBottom(stack, top);
    }

    public static void pushToBottom(Stack<Integer> stack, int value) {
        if (stack.isEmpty()) {
            stack.push(value);
        } else {
            int top = stack.pop();
            pushToBottom(stack, value);
            stack.push(top);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Stack<Integer> stack = new Stack<>();
        
        System.out.println("Enter the number of elements in the stack:");
        int n = sc.nextInt();
        
        System.out.println("Enter the elements:");
        for (int i = 0; i < n; i++) {
            stack.push(sc.nextInt());
        }

        System.out.println("Original Stack: " + stack);
        
        reverseStack(stack);
        
        System.out.println("Reversed Stack: " + stack);
        sc.close();
    }
}
