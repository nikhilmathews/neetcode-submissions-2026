class Solution:
    def carFleet(self, target: int, position: List[int], speed: List[int]) -> int:
        cars_by_position = sorted(zip(position, speed))
        fleets = []
        for i in range(len(cars_by_position) - 1, -1, -1):
            time_to_target = (target - cars_by_position[i][0]) / cars_by_position[i][1]
            if not fleets or time_to_target > fleets[-1]:
                fleets.append(time_to_target)
        return len(fleets)