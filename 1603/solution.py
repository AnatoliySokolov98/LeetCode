class ParkingSystem:
    def __init__(self, big: int, medium: int, small: int):
        self.cars = {1: big, 2: medium, 3: small}

    def addCar(self, carType: int) -> bool:
        if self.cars[carType] > 0:
            self.cars[carType] -= 1
            return True
        return False
