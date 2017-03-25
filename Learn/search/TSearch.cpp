//三分搜索
#include <iostream>
using namespace std;
int Tsearch(int *str, int n, int target);
int main(int argc, char const *argv[])
{
	int a[] = {1,2,3,4,5,6,7,8,9,10};
	cout << Tsearch(a, 10, 7);
	return 0;
}
int Tsearch(int *str, int n, int target) {
	int left = 0;
	int right = n - 1;
	int leftMid;
	int rightMid;
	while (left < right) {
		// cout << "left = " << left << "  right = " << right << endl;
		leftMid = left + (right - left) / 3;
		rightMid = left + 2*(right - left)/3;
		// cout << "leftMid = " << leftMid << "  rightMid = " << rightMid << endl;

		if (target == str[leftMid]) {
			return leftMid;
		}
		else if (target == str[rightMid]) {
			return rightMid;
		}
		else if (leftMid == rightMid) {
		    if (target == str[left]) {
				return left;
		    }
		    else if (target == str[right]) {
			    return right;
			}
		    break;
		}
		else if (target < str[leftMid]) {
			right = leftMid;
		}
		else if (target > str[leftMid] && target < str[rightMid]) {
			left = leftMid;
			right = rightMid;
		}
		else if (target > str[rightMid]) {
			left = rightMid;
		}
	}
	return -1;
}