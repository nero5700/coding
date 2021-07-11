#include <vector>
#include <unordered_map>
#include <set>

using namespace std;

class Solution {
public:
    int leastBricks(vector<vector<int>> &wall) {
        unordered_map<int, int> wall_map;
        if (wall.empty()) {
            return 0;
        }
        for (auto &row : wall) {
            int loc = 0;
            for (int j = 0; j < row.size() - 1; ++j) {
                loc += row[j];
                wall_map[loc] += 1;
            }
        }
        int res = 0;
        for (auto &[_, count]:wall_map) {
            res = max(res, count);
        }
        return wall.size() - res;
    }
};