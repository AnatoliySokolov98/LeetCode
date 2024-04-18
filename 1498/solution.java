class ParkingSystem {
    int[] cars;

    public ParkingSystem(int big, int medium, int small) {
        this.cars = new int[] { big, medium, small };
    }

    public boolean addCar(int carType) {
        if (this.cars[carType - 1] == 0)
            return false;
        this.cars[carType - 1]--;
        return true;
    }
}