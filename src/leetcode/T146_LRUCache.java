package leetcode;

import java.util.HashMap;
import java.util.Map;

public class T146_LRUCache {

 /**   
  * hash map with key and node---> cache slot
  * double linked list---> cache priority
  * capacity

     插入：1，不存在 -> capacity -> 1,head = null 2,head != null
          2，存在
     取出：1，不存在
          2，存在
     => 排序


  */  
    
    class Node{
        int key;
        int value;
        Node next;
        Node prev;
        Node(int key, int value){
            this.key = key;
            this.value = value;
        }
    }
    
    private HashMap<Integer, Node> map;
    private int capacity;
    private Node head;
    private Node tail;
        
        
    public T146_LRUCache(int capacity) {
        map = new HashMap<>();
        this.capacity = capacity;
        head = null;
        tail = null;
    }
    
    public int get(int key) {
        Node node = map.get(key);
        if(node == null) return -1;
        //remove the node and put it to the end;-----change priority1
        if(node != tail){
            if(node == head){
                head = head.next;
            }else{
                node.prev.next = node.next;
                node.next.prev = node.prev;
            }
        //add to the end------------change priority2
            tail.next = node;
            node.prev = tail;
            tail = node; 
        }
        return map.get(key).value;
    }
    
    public void put(int key, int value) {
        Node node = map.get(key);
        if(node!=null){
            //update the value 
            //upgrade the priority
            node.value = value;
            //remove this node
            if(node != tail){
                if(node == head){
                    head = head.next;
                }else{
                    node.prev.next = node.next;
                    node.next.prev = node.prev;
                }
            //add to the end
                tail.next = node;
                node.prev = tail;
                tail = node; 
            }
             
        }else{// doesn't exist before
            // check the capacity
            // still free: add 
            // full: add and delete
            if(capacity == 0) {//delete the least used node, (head node)
                Node temp = head;
                head = head.next;
                map.remove(temp.key);//remove that node
                capacity++;
            }
            Node newNode = new Node(key,value);
            if(head == null && tail == null){//empty list now
                head = newNode;
                tail = newNode;
            }else{//append to the freq list
                tail.next = newNode;
                newNode.prev = tail;
                tail = newNode;
            }
            map.put(key,newNode);
            capacity--;
        }
    }
}

	/**
	 * Your LRUCache object will be instantiated and called as such:
	 * LRUCache obj = new LRUCache(capacity);
	 * int param_1 = obj.get(key);
	 * obj.put(key,value);
	 */

