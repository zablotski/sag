package info.zablotski;

import org.apache.commons.io.IOUtil;
import org.apache.commons.lang.StringUtils;

import java.io.*;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter string: ");
        String filename = br.readLine();
        App app = new App();
        app.printFileContent(filename);
    }

    private void printFileContent(String filename){
        String output = "";
        ClassLoader classLoader = getClass().getClassLoader();
        try{
            output = IOUtil.toString(classLoader.getResourceAsStream(filename));
        } catch (IOException e) {
            e.printStackTrace();
        }
        output = StringUtils.deleteWhitespace(output);
        System.out.println(output);
    }
}
