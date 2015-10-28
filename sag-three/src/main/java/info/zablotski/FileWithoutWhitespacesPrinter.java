package info.zablotski;

import org.apache.commons.io.IOUtils;
import org.apache.commons.lang.StringUtils;

import java.io.*;

/**
 * CLI application that allow user for print filecontent without whitespaces
 *
 */
public class FileWithoutWhitespacesPrinter {
    public static void main( String[] args ) throws IOException {
        run();
    }

    public static void run() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter filename: ");
        String filename = br.readLine();
        FileWithoutWhitespacesPrinter fp = new FileWithoutWhitespacesPrinter();

        String output;
        try{
            output = fp.getFileContentWithoutWhitespaces(filename);
        } catch (NullPointerException e) {
            output = "Error. File '" + filename + "' does not exists";
        }

        System.out.println(output);
    }

    private String getFileContentWithoutWhitespaces(String filename) throws IOException {
        String output;
        ClassLoader classLoader = getClass().getClassLoader();

        output = IOUtils.toString(classLoader.getResourceAsStream(filename));

        return StringUtils.deleteWhitespace(output);
    }

}
