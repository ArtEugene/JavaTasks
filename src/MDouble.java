import java.util.Arrays;
import java.util.Random;

public class MDouble{
    private Double value;

    public MDouble(Double value){
        if (value.isInfinite()){
            this.value = 99999d;
        } else if (value.isNaN()){
            this.value = 0d;
        } else {
            this.value = value;
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
        int randSize = new Random().nextInt(10) + 1;
        MDouble [] X = new MDouble[randSize];
        MDouble [] Y = new MDouble[randSize];
        MDouble [] Z = new MDouble[randSize];

        for (int i = 0 ; i < randSize ; i++){
            X[i] = new MDouble(new Random().nextDouble() * 100);
            Y[i] = new MDouble(new Random().nextDouble() * 100);
            Z[i] = new MDouble(X[i].getValue() / Y[i].getValue());
        }

        System.out.println("X: " + Arrays.asList(X));
        System.out.println("Y: " + Arrays.asList(Y));
        System.out.println("Z: " + Arrays.asList(Z));
    }
}
