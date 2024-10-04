package Classes.FileReader.Entities;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Reader {
    
    private Scanner inn;
    private String path;

    
    

    public Reader() {
    }
    
    public Reader(String path) {
        this.path = path;
    }


    public String getPath() {
        return path;
    }






    public void leitorMatriz() {

        List<List<String>> matriz = new ArrayList<>();
        boolean ok = true;

        try{

            File arquivo = new File(getPath());
            inn = new Scanner(arquivo);

            int linhaNum = 1;

            while (inn.hasNextLine()){
                String linha = inn.nextLine();
                String[] separador = linha.split(";");
                int colunasSep = separador.length;

                int index = 0;

                for (int i = 0; i < linhaNum; i++) {
                    List<String> newLinha = new ArrayList<>(); 
                    for (int j = 0; j < colunasSep; j++) {
                        if (index < separador.length) {
                            newLinha.add(separador[index]); 
                            index++;
                        }
                    }
                    matriz.add(newLinha); 
                }
            }


        } catch (IOException error){
            System.out.println("Ops! " + error.getMessage());
            ok = false;
        } 
        
        if (ok == true){
            System.out.println();
            for (int i = 0; i < matriz.size(); i++){
                System.out.print("  ");
                for(int j = 0; j < matriz.get(i).size(); j++){
                    System.out.printf(" %s  ", matriz.get(i).get(j));
                }
                System.out.println();
            }
        } else {
            System.out.println(" ");
        }

    }

    public List<List<String>> leitorMatrizExt(String originalPath) {

        
        List<List<String>> matriz = new ArrayList<>();
        boolean ok = true;

        try{

            File arquivo = new File(originalPath);
            inn = new Scanner(arquivo);

            int linhaNum = 1;

            while (inn.hasNextLine()){
                String linha = inn.nextLine();
                String[] separador = linha.split(";");
                int colunasSep = separador.length;

                // Índice para acessar as palavras da string
                int index = 0;

                // Preenchendo a matriz com dados usando dois laços for
                for (int i = 0; i < linhaNum; i++) {
                    List<String> newLinha = new ArrayList<>(); // Nova linha (ArrayList de Strings)
                    for (int j = 0; j < colunasSep; j++) {
                        if (index < separador.length) {
                            newLinha.add(separador[index]); // Adiciona a palavra correspondente
                            index++;
                        }
                    }
                    matriz.add(newLinha); // Adiciona a linha à matriz
                }
            }


        } catch (IOException error){
            System.out.println("Ops! " + error.getMessage());
            ok = false;
        } 
        
        if (ok == true){
            return matriz;
        } else {
            return null;
        }

    }

    public void leitorTexto() {

        try{
            File arquivo = new File (getPath());
            inn = new Scanner(arquivo);
            System.out.println("\n\t\t\t\t      ### INICIO DO ARQUIVO ###\n");
            String charI = "-".repeat(108);
            String charE = " ".repeat(100);
            System.out.printf("-%-102.102s-%n", charI);
            System.out.printf("| %-100.100s |%n", charE);
            while (inn.hasNextLine()){
                String linha = inn.nextLine();
                System.out.printf("| %-100.100s |%n", linha);
            }
            System.out.printf("| %-100.100s |%n", charE);
            System.out.printf("-%-102.102s-%n", charI);
            System.out.println("\n\t\t\t\t      ### FIM DO ARQUIVO ###\n");
        } catch (IOException error){
            System.out.println("\n****************************");
            System.out.println(  "Ops! " + error.getMessage());
            System.out.println("****************************\n");
        } 

    }

    public void leitorTextoExterno(File original) {

        try{
            
            inn = new Scanner(original);
            System.out.println("\n\t### INICIO DO ARQUIVO ###\n");
            while (inn.hasNextLine()){
                String linha = inn.nextLine();
                System.out.println("| " + linha + " |");
            }
            System.out.println("\n\t### FIM DO ARQUIVO ###\n");
        } catch (IOException error){
            System.out.println("\n****************************");
            System.out.println(  "Ops! " + error.getMessage());
            System.out.println("****************************\n");
        } 

    }

}
