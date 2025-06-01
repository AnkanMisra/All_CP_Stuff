import java.util.*;

public class solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String word = sc.nextLine();
        if (word.length() == 0) {
            System.out.println("");
            return;
        }
        String capitalized = word.substring(0, 1).toUpperCase() + word.substring(1);
        System.out.println(capitalized);
    }
}
