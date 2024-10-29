package Classes.FileReader.Application;

import java.io.File;
import java.util.Scanner;

import Classes.FileReader.Entities.Finder;
import Classes.FileReader.Entities.Reader;
import Classes.FileReader.Entities.Writer;
import Classes.FileReader.Services.Functions;

public class Program {
    
    public static void main(String[] args) throws InterruptedException {
        

        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println("\n*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*");
        System.out.println("                       FILE READER                   ");
        System.out.println("*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*\n");
        Functions function = new Functions();
        Scanner inn = new Scanner (System.in);
        boolean on = true;

        while (on == true){

            int menu = 0;
            System.out.println("\n      **********");
            System.out.println("      |  MENU  |");
            System.out.println("      **********\n");

            System.out.print("\n[1] Ler um arquivo de texto (txt)\n" +
            "[2] Escrever um arquivo de texto (txt)\n" +
            "[3] Copiar um arquivo de texto - TXT\n" +
            "[4] Organizar lista em ordem alfabética - TXT\n" +
            "[5] Ler uma tabela (csv)\n" +
            "[6] Copiar uma tabela em arquivo - CSV\n" +
            "[7] Pesquisar diretórios e arquivos\n"+
            "[8] Encerrar programa\n" +
            "\n> ");
            menu = inn.nextInt(); inn.nextLine();
            

            switch (menu) {

                case 1:
                    System.out.print("\n\nDigite o caminho do arquivo: ");
                    String arquivoStr = inn.nextLine();
                    Reader leitura = new Reader(arquivoStr);
                    leitura.leitorTexto();
                    function.waitLine();
                    break;
            
                case 2:

                    System.out.print("\nSelecione: \n" +
                    "[1] Criar novo diretório e novo arquivo \n" +
                    "[2] Criar novo arquivo \n" +
                    "[3] Utilizar arquivo existente\n"+
                    "> ");
                    int op = inn.nextInt(); inn.nextLine();

                    if (op == 1){

                        System.out.print("\nDigite o caminho raiz: ");
                        String raizStr = inn.nextLine();
                        System.out.print("\nDigite o novo diretório: ");
                        String diretorioStr = inn.nextLine();
                        System.out.print("\nDigite o nome do novo arquivo com extensão (arquivo.txt)\n> ");
                        String novoArquivo = inn.nextLine();
                        Writer gravador = new Writer(raizStr, diretorioStr, novoArquivo);
                        gravador.writeTxt();
                        function.waitLine();

                    } else if (op == 2){
                        
                        System.out.print("\nDigite o caminho raiz: ");
                        String raizStr = inn.nextLine();
                        
                        System.out.print("\nDigite o nome do novo arquivo com extensão (arquivo.txt)\n> ");
                        String novoArquivo = inn.nextLine();
                        Writer gravador = new Writer(raizStr, novoArquivo);
                        gravador.writeTxt();
                        function.waitLine();

                    } else {

                        System.out.print("\n\nDigite o caminho completo com extensão: ");
                        String raizStr = inn.nextLine();
                        Writer gravador = new Writer(raizStr);
                        gravador.writeTxt();
                        function.waitLine();

                    }
                    break;

                case 3:
                    System.out.print("\n\nDigite o diretorio do arquivo ORIGINAL: ");
                    String arquivoOriginal = inn.nextLine();
                    System.out.print("\n\nDigite o diretorio para receber a copia:\n> ");
                    String diretorioCopy = inn.nextLine();
                    System.out.print("\n\nDigite o nome do novo arquivo com extensão:\n> ");
                    String arquivoCopy = inn.nextLine();
                    File newCopy = new File(arquivoOriginal);
                    Writer copyTxt = new Writer(diretorioCopy, arquivoCopy);
                    copyTxt.copyTxt(newCopy);
                    function.waitLine();
                    break;

                case 4:

                    System.out.print("\n\nDigite o caminho do arquivo: ");
                    String arquivo = inn.nextLine();
                    Writer organizaTxt = new Writer(arquivo);
                    organizaTxt.orgaqnizadorDeTexto();
                    function.waitLine();
                    break;

                case 5:
                    System.out.print("\n\nDigite o caminho do arquivo: ");
                    String tabelaStr = inn.nextLine();
                    Reader leTabela = new Reader(tabelaStr);
                    leTabela.leitorMatriz();
                    function.waitLine();
                    break;

                case 6:
                    System.out.print("\n\nDigite o diretorio do arquivo ORIGINAL: ");
                    String tabelaOriginal = inn.nextLine();
                    System.out.print("\n\nDigite o diretorio para receber a copia:\n> ");
                    String dirTabelaCopy = inn.nextLine();
                    System.out.print("\n\nDigite o nome do novo arquivo com extensão:\n> ");
                    String arquivoTabelaCopy = inn.nextLine();
                    Writer copyTabela = new Writer(dirTabelaCopy, arquivoTabelaCopy);
                    copyTabela.copyTable(tabelaOriginal);
                    function.waitLine();
                    break;

                case 7:

                    System.out.print("\nSelecione: \n" +
                    "[1] Exibir apenas diretórios \n" +
                    "[2] Exibir apenas arquivos \n" +
                    "[3] Exibir diretorios e arquivos\n" +
                    "> ");
                    int opp = inn.nextInt(); inn.nextLine();

                    if (opp == 1){
                        System.out.print("\nDigite o caminho: ");
                        String buscaStr = inn.nextLine();
                        Finder busca = new Finder();
                        busca.findDirectory(buscaStr);
                        function.waitLine();
                    } else if (opp == 2){
                        System.out.print("\nDigite o caminho: ");
                        String buscaStr = inn.nextLine();
                        Finder busca = new Finder();
                        busca.findFile(buscaStr);
                        function.waitLine();
                    } else {
                        System.out.print("\nDigite o caminho: ");
                        String buscaStr = inn.nextLine();
                        Finder busca = new Finder();
                        busca.findDictFiles(buscaStr);
                        function.waitLine();
                    }
                    break;

                case 8:
                    on = false;
                    System.out.println("\n### VOLTE SEMPRE ###\n");
                    break;
            }
        }
        inn.close();
    }
}