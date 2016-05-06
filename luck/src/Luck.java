import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import javax.swing.JOptionPane;

/**
 *
 * @author jonatan
 * App simples para palpites de jogos de loteria! :)
 * 
 */
public class Luck {

    public static void main(String[] args) {
        try {
            ArrayList<Integer> luckNumbers = new ArrayList<Integer>();

            Random r = new Random();

            int totalNumbers = Integer.parseInt(JOptionPane.showInputDialog("digite a quantidade total de numeros"));
            int bet = Integer.parseInt(JOptionPane.showInputDialog("digite a quantidade de numeros à apostar"));

            int currentShot = 0;

            for (int i = 1; i <= bet; i++) {
                currentShot = Luck.giveMeShot(totalNumbers, r);
                while (luckNumbers.contains(currentShot)) {
                    currentShot = Luck.giveMeShot(totalNumbers, r);
                }
                luckNumbers.add(currentShot);
            }

            Collections.sort(luckNumbers);
            String result = "";
            result += "[";
            for (int i : luckNumbers) {
                result += i + " ";
            }
            result += "]";
            JOptionPane.showMessageDialog(null, result);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "\"Para correta utilização, é necessário quantidade na ordem:\n"
                    + " - quantidade total de numeros.\n"
                    + " - quantidade de numeros a escolher\n"
                    + " OBS: deve ser digitado apenas numeros inteiros");
        }
    }

    public static int giveMeShot(int totalNumbers, Random r) {
        return r.nextInt(totalNumbers) + 1;
    }

}

