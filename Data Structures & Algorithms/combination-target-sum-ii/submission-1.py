import copy

class Solution:
    def combinationSum2(self, candidates: List[int], target: int) -> List[List[int]]:
        res = []
        sorted_candidates = sorted(candidates)
        self.comboSum2(sorted_candidates, 0, target, [], res)
        return res
    
    def comboSum2(self, candidates, idx, target, currCombo, res):
        if target == 0:
            res.append(copy.deepcopy(currCombo))
            return
        elif target < 0:
            return
        for i in range(idx, len(candidates)):
            candidate = candidates[i]
            if i > idx and candidate == candidates[i-1]:
                continue
            currCombo.append(candidate)
            self.comboSum2(candidates, i + 1, target - candidate, currCombo, res)
            currCombo.pop()