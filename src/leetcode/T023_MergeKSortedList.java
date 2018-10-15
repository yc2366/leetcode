package leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class T023_MergeKSortedList {
/*brute force
 * time complexity: O(n*k*log(nk))
 * 
 * space complexity: O(n*k)
 * 
 * notice merge sort/quick sort is O(nlog(n))
 * 
 * */
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists == null || lists.length == 0){
            return null;
        }
        List<Integer> all_nodes = new ArrayList<Integer>();
        for(ListNode node: lists){
            while(node!=null){
                all_nodes.add(node.val);
                node = node.next;
            }
        }
        
        Collections.sort(all_nodes);
        
        // turn an arraylist to single linked list
        ListNode ret = new ListNode(0);
        ListNode cur = ret;
        for(int node_val : all_nodes){
            ListNode temp = new ListNode(node_val);
            cur.next = temp;
            cur = cur.next;
        }
        return ret.next;
    }
    

//     Definition for singly-linked list.
     public class ListNode {
         int val;
         ListNode next;
         ListNode(int x) { val = x; }
     }
     
    
    
    
    
}

/**
 * Use this method Collections.sort(List,Comparator) . Implement a Comparator and pass it to Collections.sort().

class RecipeCompare implements Comparator<Recipe> {

    @Override
    public int compare(Recipe o1, Recipe o2) {
        // write comparison logic here like below , it's just a sample
        return o1.getID().compareTo(o2.getID());
    }
}
Then use the Comparator as

Collections.sort(recipes,new RecipeCompare());


default: The sort(List<T>) method is used to sort the specified list into ascending order, 
		 according to the natural ordering of its element.
 */
