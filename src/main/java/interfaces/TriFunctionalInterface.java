package interfaces;

import java.util.function.Function;

@FunctionalInterface
public interface TriFunctionalInterface<F, S, T, R> {

    public R apply(F first, S second, T third);

}
