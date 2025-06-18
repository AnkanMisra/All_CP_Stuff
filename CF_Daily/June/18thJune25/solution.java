import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        String result = "";
        String vowels = "AOYEUIaoeyui";

        for (char c : s.toCharArray()) {
            if (vowels.indexOf(c) == -1) {
                result += ".";
                result += Character.toLowerCase(c);
            }
        }
        System.out.println(result);
    }
}
