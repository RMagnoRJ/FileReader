package Classes.FileReader.Services;

import java.util.Scanner;

public class Functions {
    
    Scanner inn = new Scanner (System.in);

    
    
    public Functions() {
    }



    public void waitLine(){
        System.out.print("\nPressione qualquer tecla para continuar... ");
        @SuppressWarnings("unused")
        String wait = inn.nextLine();
        System.out.println();
    }
    
}
