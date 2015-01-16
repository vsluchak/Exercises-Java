package com.plachester.test;
import java.util.ArrayList;


//NOTE: we are aware that there is a PriorityQueue in
//java.util. Please do not use this. 
//If you are doing this test at home, please do not use any containers from
//java.util in your solution, as this is a test of data
//structure knowledge, rather than a test of java library knowledge.
//If you are doing it in the office, please ask the person testing you if you are going to
//use any built in collections other than arrays.

/*
* The task is as follows: implement this class as you see fit, and get the unit test in
* src/test/com/placester/test/PriorityQueueTest to pass. This class
* must allow dynamic resizing as elements are added. What the
* strategy is to do this is entirely up to you modulo the previously
* stated constraints.
* 
* Feel free to use anything from Java.util.Arrays (e.g., you don't need to implement
* your own sort if you don't want to).
*/
public class ThreadSafePriorityQueue<X> implements SimpleQueue<Priority<X>>
{
	private ArrayList<Priority<X>> queue ;
	
 public ThreadSafePriorityQueue()
 {
     initialize();
 }
 
 
 public void initialize()
 {
     queue = new ArrayList<Priority<X>>(0);
	 
 }
 
 
 @Override
 public int size()
 {
     // TODO Auto-generated method stub
     return queue.size();
	 
 }

 @Override
 public boolean isEmpty()
 {
    if (this.size() == 0) return true;
     return false;
 }

 @Override
 public void clear()
 {
	 queue.clear();
     // TODO Auto-generated method stub
     
 }

 private synchronized void moveNodeUp(int index , Priority<X> e) {
	 
	 if (index == 0 ) return;
	 int parentIndex = index/2; //<---integer division 
	 Priority<X> parent = queue.get(parentIndex);
	 if (e.priority() >= parent.priority()) return;
     queue.set(parentIndex, e);
	 queue.set(index, parent);
	 moveNodeUp(parentIndex,e);
 }
 
 @Override
 public synchronized boolean add(Priority<X> e)
 {
     // TODO Auto-generated method stub
     if (queue.add(e)) 
    //move the item up if needed
     {
    	 int index = queue.size() - 1;
    	 moveNodeUp(index,e);
    	 return true;
     }
     	 return false;
 }

 @Override
 public Priority<X> poll()
 {
     // TODO Auto-generated method stub
     Priority<X> p = queue.get(0);
	 queue.remove(0);
	 return p;
 }

 @Override
 public Priority<X> peek()
 {
     return queue.get(0);
     
 }

 @Override
 public boolean contains(Priority<X> x)
 {
     // TODO Auto-generated method stub
     if (queue.contains(x)) return true;
	 return false;
 }
}
