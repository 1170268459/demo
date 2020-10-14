package dome8;

import java.lang.annotation.ElementType;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;

@Target({TYPE, FIELD,METHOD})
public @interface SelfAutowired {
}
