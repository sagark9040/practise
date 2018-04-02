package leet.linkedlist;

import java.util.Stack;

public class LC445M_AddTwoNumbersII {
	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		Stack<Integer> num1 = getStack(l1), num2 = getStack(l2);
		return toList(num1, num2);
	}

	public Stack<Integer> getStack(ListNode l) {
		Stack<Integer> stk = new Stack<Integer>();
		while (l != null) {
			stk.push(l.val);
			l = l.next;
		}
		return stk;
	}

	public ListNode toList(Stack<Integer> num1, Stack<Integer> num2) {

		int carry = 0;
		Stack<Integer> res = new Stack<Integer>();

		while (!num1.isEmpty() || !num2.isEmpty()) {
			int dig1 = num1.isEmpty() ? 0 : num1.pop(), dig2 = num2.isEmpty() ? 0 : num2.pop();
			int val = dig1 + dig2 + carry;
			res.push(val % 10);
			carry = val > 9 ? 1 : 0;
		}

		if (carry == 1) {
			res.push(1);
		}

		// res = reverseStack(res);

		ListNode l = new ListNode(res.pop()), head = l;
		while (!res.isEmpty()) {
			l.next = new ListNode(res.pop());
			l = l.next;
		}

		return head;
	}

	public Stack<Integer> reverseStack(Stack<Integer> inp) {
		Stack<Integer> result = new Stack<Integer>();
		while (!inp.isEmpty()) {
			result.push(inp.pop());
		}
		return result;
	}

	// 7243
	// 7
	// 70 + 2
	// 720 + 4
	// 7240 + 3

}