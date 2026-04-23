from collections import defaultdict, deque
class Solution:
    def canFinish(self, numCourses: int, prerequisites: List[List[int]]) -> bool:
        dependents = defaultdict(set)
        prereq = defaultdict(set)
        for prerequisite in prerequisites:
            next = prerequisite[1]
            dependency = prerequisite[0]
            prereq[next].add(dependency)
            dependents[dependency].add(next)
        zero_prereqs = []
        completed_count = 0
        bfsQ = deque()
        for course in range(numCourses):
            if not prereq[course]:
                bfsQ.append(course)
        while bfsQ:
            course = bfsQ.popleft()
            completed_count += 1
            children = dependents[course]
            for child in children:
                prereq[child].remove(course)
                if not prereq[child]:
                    bfsQ.append(child)

        return completed_count == numCourses
        