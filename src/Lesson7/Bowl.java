package Lesson7;
import java.util.Random;

public class Bowl {
    private int foodAmount;

    public Bowl() {
        this.foodAmount = foodAmountInBowl();
    }

    private int foodAmountInBowl() {
        Random random = new Random();
        return random.nextInt(100);
    }

    public void food() {
        System.out.println("Еды в миске: " + getFoodAmount());
    }

    public void putFood() {
        Random random = new Random();
        int foodAdded = random.nextInt(25) + 1;
        setFoodAmount(foodAmount + foodAdded);
        System.out.println("Миска наполнена на " + foodAdded);
    }

    public int getFoodAmount() {
        return foodAmount;
    }

    public void setFoodAmount(int foodAmount) {
        this.foodAmount = foodAmount;
    }
}
