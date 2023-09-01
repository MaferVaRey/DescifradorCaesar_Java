import java.util.Scanner;
public class DescifradorCaesar {
    public static void main(String[] args) {
        Scanner lector = new Scanner(System.in);
        System.out.println("Ingresa el mensaje ya cifrado");
        String mensaje = lector.next();
        System.out.println("¿Cuántas veces se movió la letra en el mensaje original?");
        int veces = lector.nextInt();

        String mensajeDescifrado = "";

        for (int i = 0; i < mensaje.length(); i++) {
            char letra = mensaje.charAt(i);
            boolean minuscula = (letra >= 'a' && letra <= 'z');
            boolean mayuscula = (letra >= 'A' && letra <= 'Z');
            if (!(minuscula || mayuscula))
                mensajeDescifrado += letra;
            else {
                int ascii = (int) letra;
                int baseAscii = (int) 'a';
                if (mayuscula)
                    baseAscii = (int) 'A';
                int nuevoAscii = Math.floorMod(ascii - baseAscii - veces, 26) + baseAscii;
                char nuevaLetra = (char) nuevoAscii;
                mensajeDescifrado += nuevaLetra;
            }
        }
        System.out.println(mensajeDescifrado);
    }
}