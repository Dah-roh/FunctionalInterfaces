import interfaces.PureFunctionalInterface;
import interfaces.PureTriFunctionalInterface;

import java.util.function.*;

import static interfaces.PureFunctionalInterface.*;
import static interfaces.PureTriFunctionalInterface.*;

public class Main {

    //imperative programming style predicate
    public static boolean stringedPredicate2 (String sen1){
        return sen1.length() > 10;
    }

    //imperative programming style supplier

    public static void main(String[] args) {
        //declarative programming style
        Predicate<String> stringedPredicate = sen->{
            return sen.length() > 10;
        };

        Supplier<String> stringSupplier = () -> {
            String namdesu = "blahblahblah";
            return namdesu.toUpperCase();
        };

        Consumer<String> stringConsumer = (sensei) -> {
            System.out.println(sensei.toLowerCase());
        };

        BiPredicate<String, Boolean> isBoy = (name, hasHair) -> {
            return name.startsWith("P") && hasHair;
        };

        Function<String, Boolean> stringFunction = names-> names.startsWith("P");

        Function<String, Boolean> stringFunction1 = (names)->{
            return  names.startsWith("P");
        };




        System.out.println(stringFunction.apply("Paloma"));//our functional program

        String name =  "Pablo@www";


        //Implementation of the PureFunctional interface for NIO
        String result = PureFunctionalInterface
//                .readFromFile()
//                .and(readFromFile())                              /*REMOVE COMMENT TO USE IT*/
//                .apply("src/main/resources/ReadThisFile");

                                                                  /*ADD COMMENT TO LINE BELOW TO USE THE ABOVE COMMENTED OUT CODE*/
                .with(readFromFile())
                .apply("src/main/resources/ReadThisFile");

        String word = "I";

        Integer resultForTheTriFunctionImpl2 = PureTriFunctionalInterface
                .combineString()
                .and(addFifty(combineString()))
                .apply(word, word, word);

        System.out.println(resultForTheTriFunctionImpl2);

        Integer resultForTheTriFunctionImpl = PureTriFunctionalInterface
                .addFifty(combineString())
                .apply(word,word,word);

        System.out.println(resultForTheTriFunctionImpl);

        System.out.println(result);// the in-built functional program

        stringConsumer.accept("BLAHBLAHBLAH");

        System.out.println(isBoy.test("Paulo", false));

        System.out.println(stringedPredicate.test("blahblahblah"));

        System.out.println(stringSupplier.get());

        System.out.println(stringedPredicate2("blahblahblah"));

    }

}
