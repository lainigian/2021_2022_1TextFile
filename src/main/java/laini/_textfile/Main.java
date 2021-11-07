/*
 *Esempio di utilizzo della classe TextFile per leggere/scrivere da/su file di testo
 */
package laini._textfile;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author User
 */
public class Main 
{
    public static void main(String[] args) 
    {
        //scriviamo il pathname del file da scrivere
        //String filePathname="F:\\OneDrive - Istituto Olivelli Putelli\\Scuola\\AS 2020 2021\\Materiale 4 Informatica\\Laini_Workspace_2020_20201\\25_TextFile\\file1.txt";
        String filePathname="fileProva.txt";
        //scriviamo 3 righe sul file
        try 
        {  
            TextFile f1=new TextFile(filePathname,'W');
            f1.toFile("Riga 1");
            f1.toFile("Riga 2");
            f1.toFile("Riga 3");
            f1.close();
            System.out.println("File scritto correttamente");
        } 
        catch (IOException ex) 
        {
            System.out.println("Impossibile aprire il file in scrittura");
        } 
        catch (FileException ex) 
        {
            System.out.println(ex.toString());
        }
        
        //scriviamo una riga sul file in append
         try 
        {  
            //apriamo il file in modalità scrittura in append
            TextFile f1=new TextFile(filePathname,'W', true);  
            f1.toFile("Riga in append");
            f1.close();
            System.out.println("File scritto correttamente");
        } 
        catch (IOException ex) 
        {
            System.out.println("Impossibile aprire il file in scrittura");
        } 
        catch (FileException ex) 
        {
            System.out.println(ex.toString());
        }
                      
        //leggiamo le righe del file una alla volta
        //mettiamo ogni riga in una variabile String e la stampiamo sul monitor
        String rigaLetta;
        try 
        {

            TextFile f1= new TextFile(filePathname,'R');
            try
            {
                while(true)
                {
                    rigaLetta=f1.fromFile();
                    System.out.println(rigaLetta);   
                } 
            }
            catch(FileException fineFile)       //questa eccezione viene sollevata quando tutto il file è stato letto
            {
                System.out.println(fineFile.toString());
                f1.close();
            }           
        } 
        catch (IOException ex) //Questa eccezione viene sollevata in caso di errore nell'accesso al file
        {
            System.out.println("Impossibile aprire il file in lettura");
        }             
    }           
}


