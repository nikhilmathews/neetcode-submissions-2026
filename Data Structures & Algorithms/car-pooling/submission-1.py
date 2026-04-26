class Solution:
    def carPooling(self, trips: List[List[int]], capacity: int) -> bool:
        sorted_intervals = sorted(trips, key=lambda x: x[1])
        loaded_passengers = 0
        live_trips = []
        for sorted_interval in sorted_intervals:
            while live_trips and live_trips[0][0] <= sorted_interval[1]:
                loaded_passengers -= live_trips[0][1]
                heapq.heappop(live_trips)
            heapq.heappush(live_trips, (sorted_interval[2], sorted_interval[0]))
            loaded_passengers += sorted_interval[0]
            if loaded_passengers > capacity:
                return False
        return True

# [3,2,7], [8,3,9], [3,7,9]