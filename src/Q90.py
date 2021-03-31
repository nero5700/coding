from typing import List, Set, Tuple


class Solution(object):
    def gen(self, cur_nums: Tuple[int], left_nums: List[int], res_set: Set[Tuple[int]]):
        if left_nums:
            cur_nums_select = list(cur_nums)
            cur_nums_select.append(left_nums[0])
            res_set.add(tuple(cur_nums_select))
            self.gen(tuple(cur_nums_select), left_nums[1:], res_set)
            self.gen(cur_nums, left_nums[1:], res_set)
        res_set.add(cur_nums)

    def subsetsWithDup(self, nums: List[int]):
        """
        :type nums: List[int]
        :rtype: List[List[int]]
        """
        res_set = set()
        nums.sort()
        self.gen(tuple(), nums, res_set)
        return list(res_set)


print(Solution().subsetsWithDup([4, 4, 4, 1, 4]))
