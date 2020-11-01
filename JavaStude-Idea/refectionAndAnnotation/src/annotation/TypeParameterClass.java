package annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.TYPE_PARAMETER)
@Retention(RetentionPolicy.RUNTIME)
@interface TypeParameterAnnotation {

}

/**
 *@ author吴云鹏
 * Date:2020/5/3
 * Time:4:14
 */
@SuppressWarnings("never used")
public class TypeParameterClass <@TypeParameterAnnotation T>{
    public <@TypeParameterAnnotation U> T foo(T t) {
        return null;
    }
}
