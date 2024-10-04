package Classes.FileReader.Entities;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Writer {
    
    private Scanner inn;
    private String nomeArquivo;
    private String pathStr;
    private File path;



    public Writer() {
    }
    
    public Writer(String pathStr) {
        this.pathStr = pathStr;
        this.path = new File(pathStr);
    }

    public Writer(String pathStr, String novoArquivo) {
        this.pathStr = pathStr;
        this.nomeArquivo = novoArquivo;
        this.path = new File(pathStr, nomeArquivo);
    }

    public Writer(String pathStr, String novoDiretorio, String novoArquivo) {
        this.pathStr = pathStr;
        this.nomeArquivo = novoArquivo;
         
        
        boolean sucess = new File(pathStr + "\\" + novoDiretorio).mkdir();
        if (sucess == true){
            System.out.println("\n======================================================");
            System.out.println(  " Diretório " + novoDiretorio + " criado com sucesso!");
            System.out.println("======================================================\n");
        } else {
            System.out.println("\n======================================================");
            System.out.println("\n Diretório " + novoDiretorio + " não foi criado!");
            System.out.println("======================================================\n");
        }
        String newPath = pathStr + "\\" + novoDiretorio;
        this.path = new File(newPath, nomeArquivo);
    }



    public String getNomeArquivo() {
        return nomeArquivo;
    }

    public String getPathStr() {
        return pathStr;
    }

    public File getPath() {
        return path;
    }



    


    public void copyTable(String originalPath){

        Reader copyTableExt = new Reader(originalPath);
        List<List<String>> matrizOriginal = copyTableExt.leitorMatrizExt(originalPath);
        
        List<List<String>> matrizCopiada = new ArrayList<>();

        for (List<String> linha : matrizOriginal) {
            List<String> novaLinha = new ArrayList<>(linha);
            matrizCopiada.add(novaLinha);
        }
        
        System.out.println();

        boolean ok = true;

        try (BufferedWriter bfwrt = new BufferedWriter(new FileWriter(getPath(), true))){
            

            for (int i = 0; i < matrizCopiada.size(); i++){
                
                for(int j = 0; j < matrizCopiada.get(i).size(); j++){
                    bfwrt.write(matrizCopiada.get(i).get(j) + ";");
                }
                bfwrt.newLine();
            }


        } catch (IOException err){
            System.out.println("Error = " + err.getMessage());
            err.printStackTrace();
            ok = false;
        }
        if (ok == true){
            System.out.println("\n### TABELA COPIADA ###\n");
        }

    }

    public void writeTxt(){

        boolean ok = true;

        try (BufferedWriter bfwrt = new BufferedWriter(new FileWriter(getPath(), true))){
              
            boolean text = true;
            System.out.println("\nPara encerrar o texto digite [&&&] e pressione [ENTER]\n");
            System.out.println("### INICIO...\n");
            inn = new Scanner (System.in);
            while (text == true){
                System.out.print("> ");
                String linha = inn.nextLine();
                if (linha.contains("&&&")){
                    text = false;
                    break;
                } else {
                    bfwrt.write(linha);
                    bfwrt.newLine();
                }
            }
            System.out.println("\n...FIM ###");

        } catch (IOException err){
            System.out.println("Error = " + err.getMessage());
            err.printStackTrace();
            ok = false;
        }
        if (ok == true){
            System.out.println("\n*** Texto encerrado ***\n");
        } 
    }

    public void copyTxt(File original){

        List <String> novoArquivo = new ArrayList<>();
        boolean ok = true;

        try{

            inn = new Scanner(original);
            
            while (inn.hasNextLine()){
                String linha = inn.nextLine();
                novoArquivo.add(linha);
            }
            System.out.println("\n### TEXTO ORIGINAL LIDO ###");
        } catch (IOException error){
            ok = false;
            System.out.println("\n****************************");
            System.out.println(  "Ops! " + error.getMessage());
            System.out.println("****************************\n");
        } 

        if (ok = true){
            
            try (BufferedWriter bfwrt = new BufferedWriter(new FileWriter(getPath(), true))){
    
                for (int i = 0; i < novoArquivo.size(); i++){
                    bfwrt.write(novoArquivo.get(i));
                    bfwrt.newLine();
                }
                
                System.out.println("\n### TEXTO ORIGINAL ESCRITO ###");
    
            } catch (IOException err){
                System.out.println("Error = " + err.getMessage());
                err.printStackTrace();
                ok = false;
            }
            if (ok == true){
                System.out.println("\n### ARQUIVO COPIADO COM SUCESSO ###\n");
            }
        }
         
    }

}
