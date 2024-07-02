package Lesson7;
class Bowl {
    private int foodAmount;

    public Bowl(int foodAmount) {
        this.foodAmount = foodAmount;
    }

    public int getFoodAmount() {
        return foodAmount;
    }

    public void addFood(int amount) {
        foodAmount += amount;
    }
}
