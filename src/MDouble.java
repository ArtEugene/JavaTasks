import java.util.Arrays;
import java.util.Random;

public class MDouble{
    private Double value;

    public MDouble(Double value){
       setValue(value);
    }
    
    public void setValue(Double value){
        try {
            if (value.isInfinite ()) {
                throw new WhiteException ("infinite");
            } else if (value.isNaN ()) {
                throw new WhiteException ("NaN");
            } else {
                this.value = value;
            }
        } catch (WhiteException wexc){
            System.err.println ("Exception caught by " + wexc.getMessage () + " value");
            switch (wexc.getMessage ()){
                case "NaN" : this.value = 0d; break;
                case "infinite": this.value = 99999.9; break;
                default: //throw new WhiteException ("Error!");
            }
        }
    }
    
    public Double getValue() {
        return value;
    }

    @Override
    public String toString() {
        return getValue() + "";
    }

    public static void main(String[] args) {
        System.out.println("[LOG] Create new MDouble object with POSITIVE_INFINITY");
        MDouble test = new MDouble (Double.POSITIVE_INFINITY);
        System.out.println("[LOG] Value of MDouble object is : " + test.getValue () + "\n");

        int randSize = new Random().nextInt(10) + 1;
        MDouble [] X = new MDouble[randSize];
        MDouble [] Y = new MDouble[randSize];
        MDouble [] Z = new MDouble[randSize];

        for (int i = 0 ; i < randSize ; i++){
            X[i] = new MDouble(rand.nextDouble() * 100);
            Y[i] = new MDouble(rand.nextDouble() * 100);
            Z[i] = new MDouble(X[i].getValue() / Y[i].getValue());
        }

        System.out.println("X: " + Arrays.asList(X));
        System.out.println("Y: " + Arrays.asList(Y));
        System.out.println("Z: " + Arrays.asList(Z));
    }
}
