public class Solution {
    public static void main(String[] args) {
        java.util.Scanner scanner = new java.util.Scanner(System.in);
        String s = scanner.nextLine();

        int uppercase = 0;
        int lowercase = 0;

        for (char c : s.toCharArray()) {
            if (Character.isUpperCase(c)) {
                uppercase++;
            } else {
                lowercase++;
            }
        }

        if (uppercase > lowercase) {
            System.out.println(s.toUpperCase());
        } else {
            System.out.println(s.toLowerCase());
        }

        scanner.close();
    }
}
