class Solution:
    def partitionLabels(self, s: str) -> List[int]:
        last_index = {}
        for i in range(len(s)):
            last_index[s[i]] = i
        start = 0
        curr_max_idx = 0
        partitions = []
        for i in range(len(s)):
            c = s[i]
            curr_max_idx = max(curr_max_idx, last_index[c])
            if i == curr_max_idx:
                partitions.append(curr_max_idx - start + 1)
                start = i + 1
        if not partitions:
            partitions.append(len(s))
        return partitions
        