package leetCode;

/**
 * Definition for singly-linked list. public class ListNode { int val; ListNode
 * next; ListNode(int x) { val = x; } }
 */
class Solution {

	public static ListNode addtoList(int data, ListNode head) {
		ListNode temp = new ListNode(data);
		temp.next = null;

		if (head == null) {
			head = temp;
		} else {
			ListNode last = head;
			while (last.next != null) {
				last = last.next;
			}
			last.next = temp;
		}

		return head;
	}

	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		int carry = 0, data = 0;
		ListNode head = null;

		while (l1 != null && l2 != null) {
			data = (l1.val + l2.val + carry) % 10;
			carry = (l1.val + l2.val + carry) / 10;
			head = addtoList(data, head);
			l1 = l1.next;
			l2 = l2.next;
		}

		while (l1 != null) {
			data = (l1.val + carry) % 10;
			carry = (l1.val + carry) / 10;
			head = addtoList(data, head);
			l1 = l1.next;
		}

		while (l2 != null) {
			data = (l2.val + carry) % 10;
			carry = (l2.val + carry) / 10;
			head = addtoList(data, head);
			l2 = l2.next;
		}

		if (carry > 0) {
			head = addtoList(carry, head);
		}

		return head;
	}

}