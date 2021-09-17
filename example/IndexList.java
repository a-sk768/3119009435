package org.example;

class Node{
    int headIndex;
    int tailIndex;
    Node next=null;
}
public class IndexList {//存储下表的链表

  private int size=0;
  private  Node head=new Node();
  public Node getHead(){
      if (this.size==0) return null;

      return this.head;
  }
  public void add(int headIndex,int tailIndex){
      Node newNode=new Node();
      newNode.headIndex=headIndex;
      newNode.tailIndex=tailIndex;
      newNode.next=this.head.next;
      this.head.next=newNode;
      this.size++;
  }
  public int getSize(){
      return  this.size;
  }


}
