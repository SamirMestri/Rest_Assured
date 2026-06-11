package JavaBasics;

public class ReverseString {

    public static void main(String[] args) {

        String S = "Samir";
        String t ="";

        for (int i =S.length()-1; i>=0; i--) {

            t = t+S.charAt(i);

        }
        System.out.println(t);
    }
}