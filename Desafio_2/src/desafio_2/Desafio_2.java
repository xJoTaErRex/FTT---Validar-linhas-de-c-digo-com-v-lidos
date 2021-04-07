package desafio_2;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.Stack;

/**
 *
 * @author jr13f
 */
public class Desafio_2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        try {

            Scanner in = new Scanner(new FileReader("prog.txt"));
            try (FileWriter arq = new FileWriter("prog-check.txt")) {
                while (in.hasNextLine()) {
                    Stack<Character> aux = new Stack<>();
                    String line = in.nextLine();
                    for (int j = 0; j < line.length(); j++) {
                        if (line.charAt(j) == '{' || line.charAt(j) == '(' || line.charAt(j) == '[') {
                            aux.push(line.charAt(j));
                        } else if (!aux.empty() && ((line.charAt(j) == '}' && aux.peek() == '{')
                                || (line.charAt(j) == ')' && aux.peek() == '(')
                                || (line.charAt(j) == ']' && aux.peek() == '['))){
                            aux.pop();
                        } else {
                            aux.push(line.charAt(j));
                            break;
                        }
                    }
                    
                    PrintWriter gravarArq = new PrintWriter(arq);
                    
                    if (aux.empty()) {
                        gravarArq.printf(line + " ok%n");
                        System.out.println(line + " ok");
                    } else {
                        gravarArq.printf(line + " invalido%n");
                        System.out.println(line + " invalido");
                    }   
                }
                System.out.println("\nArquivo prog-check.txt com o resultado acima gerado na pasta raiz");
            }

        } catch (IOException e) {
            System.err.printf("Erro na abertura do arquivo: %s.\n",e.getMessage());
        }

    }

}
