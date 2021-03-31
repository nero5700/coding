//
// Created by bytedance on 2021/3/26.
//


struct ListNode {
    int val;
    ListNode *next;

    ListNode() : val(0), next(nullptr) {}

    ListNode(int x) : val(x), next(nullptr) {}

    ListNode(int x, ListNode *next) : val(x), next(next) {}
};

class Solution {
public:
    ListNode *deleteDuplicates(ListNode *head) {
        auto *pt = head;
        while (pt && pt->next) {
            if (pt->next->val == pt->val) {
                pt->next=pt->next->next;
            } else{
                pt=pt->next;
            }
        }
        return head;
    }
};
