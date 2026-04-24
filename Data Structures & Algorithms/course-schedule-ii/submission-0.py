from collections import defaultdict, deque

class Solution:
    def findOrder(self, numCourses: int, prerequisites: List[List[int]]) -> List[int]:
        prereqs = defaultdict(set)
        adjacency_list = defaultdict(set)

        for prerequisite in prerequisites:
            prereq = prerequisite[1]
            next = prerequisite[0]
            prereqs[next].add(prereq)
            adjacency_list[prereq].add(next)
        
        course_ordering = []
        bfs_queue = deque()
        for course in range(numCourses):
            if not prereqs[course]:
                bfs_queue.append(course)

        while bfs_queue:
            course = bfs_queue.popleft()
            course_ordering.append(course)

            for next_course in adjacency_list[course]:
                prereqs[next_course].remove(course)
                if not prereqs[next_course]:
                    bfs_queue.append(next_course)
        
        if len(course_ordering) == numCourses:
            return course_ordering
        else:
            return []
        