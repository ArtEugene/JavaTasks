public class ThrowClass {
    private static void throwIt(String msg ) throws WhiteException {
        throw new WhiteException(msg);
    }

    public static void catchIt(String msg) {
        try{
            throwIt(msg);
        } catch (WhiteException wexc){
            System.out.println("WhiteException caught with message: " + wexc.getMessage());
        }
    }

    public static void main(String [] args){
        catchIt("test");
    }
}

