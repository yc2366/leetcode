package leetcode;


// Definition for singly-linked list.


public class T206_ReverseLinkedList {
	/*Iterative method*/
	public ListNode reverseList(ListNode head) {
        if(head == null) return head;
        ListNode prev = null;
        while(head.next!=null && head.next.next!=null){
            ListNode newHead = head.next.next;//save 3 first
            ListNode newTail = head.next;//save 2
            head.next.next = head;// change 2-->3 to 2-->1
            head.next = prev;// change 1-->2 to 1-->null
            prev = newTail; // prev = 2
            head = newHead;// head = 3
        }
        if(head.next==null){  
            head.next = prev;
        }else{
            ListNode temp = head.next;
            temp.next = head;
            head.next = prev;
            head = temp;
        }
        return head;
    }
	
	/**
	 * take an example to think about this question
	 * 1-->2-->3-->4-->5-->null
	 * 5-->4-->3-->2-->1-->null
	 * 
	 * after first iteration: 
	 * 1<--2   3-->4-->5-->null
	 * 
	 * after the second iteration:
	 * 1<--2<--3<--4   5-->null
	 *            pre  new
	 * consider two case when reach the last iteration
	 * 5-->null
	 * 
	 * 5-->6-->null
	 * 
	 */
	
	/*recursive method*/
    public ListNode reverseList2(ListNode head) {
        if(head==null){
            return head;
        }
        if(head.next==null){
            return head;
        }
        ListNode r = reverseList2(head.next);
        if(r.next==null){ 
            r.next = head; 
        }else{
            head.next.next = head;
        }
        head.next = null; // free the pointer to next node.
        return r;
    }
    
    /**
     * first check the return condition
     * 
     * the recursion gives back the reversed linked list's head
     * 
     * 1-->2<--3<--4<--5
     *     |
     *     null
     *     
     * then change the 2-->null to 2-->1
     * 
     */
	
	
	public class ListNode {
	    int val;
	    ListNode next;
	    ListNode(int x) { val = x; }
	}
}












