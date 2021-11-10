package interfaces;

public interface PureTriFunctionalInterface extends TriFunctionalInterface<String, String, String, Integer> {
    static PureTriFunctionalInterface combineString(){
      return  (word1, word2, word3) -> (word1 + word2 + word3).length();
    }

    static PureTriFunctionalInterface addFifty(PureTriFunctionalInterface anotherArgument){
        return (word1, word2, word3) -> anotherArgument.apply(word1, word2, word3)+497;
    }

    default PureTriFunctionalInterface and (PureTriFunctionalInterface anotherInterface){
        return (tri1, tri2, tri3) -> addFifty(anotherInterface).apply(tri1, tri2, tri3);
    }


    @Override
    Integer apply(String first, String second, String third);


}
