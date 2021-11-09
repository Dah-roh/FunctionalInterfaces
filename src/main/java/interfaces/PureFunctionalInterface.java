package interfaces;

import java.util.function.Function;
import static interfaces.PureFunctionalInterface.*;
public interface PureFunctionalInterface extends Function<String, Boolean> {
    static PureFunctionalInterface isName(String name) {
        return pure-> name.contains("P");
    }

    static PureFunctionalInterface lengthOfName (String name) {
        return pure-> name.length()<15;
    }

    default PureFunctionalInterface and (PureFunctionalInterface anotherFunction) {
        return name -> isName(name).apply(name).equals(true) ? anotherFunction.apply(name) : isName(name).apply(name);
    }

    @Override
    Boolean apply(String s);
}
