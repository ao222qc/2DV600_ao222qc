package ao222qc_assign1;

/**
 * Created by Adam on 2016-08-31.
 */
import java.util.Scanner;
import java.io.File;
import java.io.FilenameFilter;
import java.util.ArrayList;
import java.util.List;
import java.io.FileNotFoundException;

public class CountJava
{
    static List<File> javaFiles = new ArrayList<File>();

    public static void main(String args[]) throws Exception
    {
        String path = "";

        try
        {
            if(args.length > 0)
            {
                getFilePaths(args[0]);
            }
            else
            {
                throw new Exception("Folder path not provided.");
            }

        }
        catch(Exception e)
        {
            System.out.println(e.getMessage());
        }

    }

    private static void getFilePaths(String path)
    {
        File directory = new File(path);
        if(!directory.isDirectory())
        {
            return;
        }
        for(File x : directory.listFiles())
        {
            if (x.isDirectory())
            {
                getFilePaths(x.getAbsolutePath());  //Call itself with path of folder.
            }
            else if(x.isFile() && x.getName().endsWith(".java"))
            {
                javaFiles.add(x);
            }
        }

        for(int i = 0; i < javaFiles.size(); i++)
        {
            System.out.println(i+1 + ". " + javaFiles.get(i).getName() +  " lines: "+getFileLineNumbers((javaFiles.get(i))));

        }
    }

    private static int getFileLineNumbers(File file)
    {
        int amountOfLines = 0;
        try
        {
            Scanner scanner = new Scanner(file);

           while(scanner.hasNextLine())
            {
                amountOfLines++;
                scanner.nextLine();
            }
            scanner.close();

            return amountOfLines;
        }
        catch(Exception e)
        {
            System.out.println("Something unexpected happened while reading line numbers of java file.");
            return 0;
        }
    }
}
