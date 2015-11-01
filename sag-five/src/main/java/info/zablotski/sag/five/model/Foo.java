package info.zablotski.sag.five.model;

import java.lang.annotation.*;

/**
 * Created by zhenya on 11/1/15.
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface Foo {
    String value();
}
