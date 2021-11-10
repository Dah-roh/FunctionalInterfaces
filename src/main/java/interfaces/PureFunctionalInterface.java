package interfaces;

import java.util.function.Function;
import static interfaces.PureFunctionalInterface.*;
public interface PureFunctionalInterface extends Function<String, String> {
    static PureFunctionalInterface isName() {
        return pure -> pure.contains("@") ? "your name is not correct": lengthOfName().apply(pure);
    }

    static PureFunctionalInterface lengthOfName () {
        return pure-> "Your name is correct";

    }

    default PureFunctionalInterface and (PureFunctionalInterface anotherFunction) {
        return name -> name.contains("not")? anotherFunction.apply(name) : anotherFunction.apply(name);
    }

    @Override
    String apply(String s);
}
