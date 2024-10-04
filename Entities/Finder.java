package Classes.FileReader.Entities;

import java.io.File;

public class Finder {
    

    public Finder() {
    }


    public void findFile(String strPath){


        File path = new File(strPath);
        File [] files = path.listFiles(File::isFile);

        System.out.println("\n==========");
        System.out.println(  " ARQUIVOS ");
        System.out.println(  "==========\n");
        
        for (File file : files){
            System.out.println(file);
        }

    }

    public void findDirectory(String strPath){

        
        File path = new File(strPath);

        File[] folders = path.listFiles(File::isDirectory);

        System.out.println("\n============");
        System.out.println(  " DIRETÓRIOS ");
        System.out.println(  "============\n");

        for (File folder : folders){
            System.out.println(folder);
        }
        
    }

    public void findDictFiles(String strPath){
        File path = new File(strPath);

        File[] folders = path.listFiles(File::isDirectory);

        System.out.println("\n============");
        System.out.println(  " DIRETÓRIOS ");
        System.out.println(  "============\n");

        for (File folder : folders){
            System.out.println(folder);
        }
        

        System.out.println("\n==========");
        System.out.println(  " ARQUIVOS");
        System.out.println("==========\n");
        File [] files = path.listFiles(File::isFile);
        for (File file : files){
            System.out.println(file);
        }
    }




}
