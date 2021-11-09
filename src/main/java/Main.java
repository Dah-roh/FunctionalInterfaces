import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class Main {

    //imperative programming style predicate
    public static boolean stringedPredicate2 (String sen1){
        if(sen1.length()>10){
            return true;
        }
        return false;
    }

    //imperative programming style supplier

    public static void main(String[] args) {
//        String namdesu = "";
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


        stringConsumer.accept("BLAHBLAHBLAH");
        System.out.println(stringedPredicate.test("blahblahblah"));
        System.out.println(stringSupplier.get());
        System.out.println(stringedPredicate2("blahblahblah"));

    }
}
