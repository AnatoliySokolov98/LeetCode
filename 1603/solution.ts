class ParkingSystem {
  cars: number[];
  constructor(big: number, medium: number, small: number) {
    this.cars = [big, medium, small];
  }

  addCar(carType: number): boolean {
    if (!this.cars[carType - 1]) {
      return false;
    }
    this.cars[carType - 1]--;
    return true;
  }
}
