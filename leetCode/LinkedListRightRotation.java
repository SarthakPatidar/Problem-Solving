package leetCode;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class ListNode {
	int val;
	ListNode next;

	ListNode(int x) {
		val = x;
	}
}

public class LinkedListRightRotation {
	public static int[] stringToIntegerArray(String input) {
		input = input.trim();
		input = input.substring(1, input.length() - 1);
		if (input.length() == 0) {
			return new int[0];
		}

		String[] parts = input.split(",");
		int[] output = new int[parts.length];
		for (int index = 0; index < parts.length; index++) {
			String part = parts[index].trim();
			output[index] = Integer.parseInt(part);
		}
		return output;
	}

	public static ListNode stringToListNode(String input) {
		// Generate array from the input
		int[] nodeValues = stringToIntegerArray(input);

		// Now convert that list into linked list
		ListNode dummyRoot = new ListNode(0);
		ListNode ptr = dummyRoot;
		for (int item : nodeValues) {
			ptr.next = new ListNode(item);
			ptr = ptr.next;
		}
		return dummyRoot.next;
	}

	public static String listNodeToString(ListNode node) {
		if (node == null) {
			return "[]";
		}

		String result = "";
		while (node != null) {
			result += Integer.toString(node.val) + ", ";
			node = node.next;
		}
		return "[" + result.substring(0, result.length() - 2) + "]";
	}

	/*
	 * Implement this function
	 */
	public static ListNode rotateRight(ListNode head, int k) {

		ListNode temp = head;
		int length = 0;

		while (temp != null) {
			length += 1;
			temp = temp.next;
		}

		temp = head;

		if (temp == null || temp.next == null || k % length == 0)
			return temp;

		for (int i = 0; i < length - (k % length) - 1; i++) {
			temp = temp.next;
		}

		ListNode temp1 = temp.next;
		temp.next = null;

		ListNode head1 = temp1;

		while (temp1.next != null) {
			temp1 = temp1.next;
		}

		temp1.next = head;
		return head1;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String line;
		while ((line = in.readLine()) != null) {
			ListNode head = stringToListNode(line);
			line = in.readLine();
			int k = Integer.parseInt(line);

			ListNode ret = rotateRight(head, k);

			String out = listNodeToString(ret);

			System.out.print(out);
		}
	}
}