package info.zablotski;

import javax.servlet.ServletException;

/**
 * Created by zhenya on 11/1/15.
 */
public class FooWorldException extends ServletException{
    public String getMessage(){
        return "Given url is not allowed";
    }
}
