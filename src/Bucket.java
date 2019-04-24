import java.util.Random;

public class Bucket {
    private int capacity;
    private int currentWater;
/*Даны три бидона – 8-ми литровый, 5-ти литровый и 3-х литровый. В начале 8-ми литровый бидон наполнен водой,
остальные – пустые. Найти последовательность действий, в результате которых в 8-ми литровом бидоне и в 5-ти
литровом бидоне останутся ровно по 4 литра воды. Допустимые действия: вода может быть перелита из одного бидона
 в другой до тех пор, пока первый не опустошился или второй не наполнился.
* */
    public Bucket(int capacity, int currentWater) {
        setCapacity(capacity);
        setCurrentWater(currentWater);
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public int getCurrentWater() {
        return currentWater;
    }

    public void setCurrentWater(int currentWater) {
        this.currentWater = currentWater;
    }

    public void incrementLiter(){
        setCurrentWater(getCurrentWater() + 1);
    }

    public void decrementLiter(){
        setCurrentWater(getCurrentWater() - 1);
    }

    public void moveWater(Bucket to){
        while(getCurrentWater() > 0 && to.getCapacity() != to.getCurrentWater()){
            to.incrementLiter();
            decrementLiter();
        }
    }

    @Override
    public String toString() {
        return "[ "+getCurrentWater() + " / " + getCapacity() + " ]";
    }

    public static void main(String[] args) {
        Bucket big = new Bucket(8,8);
        Bucket mid = new Bucket(5,0);
        Bucket lit = new Bucket(3,0);

        System.out.println("Big " + big);
        System.out.println("Mid " + mid);
        System.out.println("Lit " + lit);

        System.out.println("big to mid");
        big.moveWater(mid);

        System.out.println("Big " + big);
        System.out.println("Mid " + mid);
        System.out.println("Lit " + lit);

        System.out.println("mid to lit");
        mid.moveWater(lit);

        System.out.println("Big " + big);
        System.out.println("Mid " + mid);
        System.out.println("Lit " + lit);

        Bucket [] buckets = new Bucket[3];

        buckets[0] = big;
        buckets[1] = mid;
        buckets[2] = lit;

        int counter = 0;
        boolean done = false;
        Random rand = new Random();

        StringBuilder result = new StringBuilder();
        while(counter < 13 && !done){

            // step 1:
            int index = rand.nextInt(1) + 1;
            result.append("Big to " + (index == 1?"mid":"lit"));
            big.moveWater(buckets[rand.nextInt(1) + 1]);

        }
    }
}
