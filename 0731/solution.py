from sortedcontainers import SortedDict


class MyCalendarTwo:

    def __init__(self):
        self.bookings = SortedDict()

    def book(self, start: int, end: int) -> bool:
        self.bookings[start] = self.bookings.get(start, 0) + 1
        self.bookings[end] = self.bookings.get(end, 0) - 1
        count = 0
        for val in self.bookings.values():
            count += val
            if count > 2:
                self.bookings[start] = self.bookings.get(start, 0) - 1
                self.bookings[end] = self.bookings.get(end, 0) + 1
                return False
        return True
