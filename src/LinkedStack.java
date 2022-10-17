public class LinkedStack {
    class Stack:
            '''Implements an efficient last-in first-out Abstract Data Type using a Linked List'''

    def __init__(self, capacity):
            '''Creates and empty stack with a capacity'''
    self.capacity = capacity
    self.top = None
    self.num_items = 0

    def is_empty(self):
            '''Returns True if the stack is empty, and False otherwise
    MUST have O(1) performance'''
            if self.num_items == 0:
            return True
        else:
                return False

    def is_full(self):
            '''Returns True if the stack is full, and False otherwise
    MUST have O(1) performance'''
            if (self.capacity == self.num_items):
            return True
        else:
                return False

    def push(self, item):
            '''If stack is not full, pushes item on stack.
    If stack is full when push is attempted, raises IndexError
    MUST have O(1) performance'''
    n = Node(item)
        if (self.is_full() == False):
    n.data = item
    n.next = self.top
    self.top = n
    self.num_items += 1
            else:
    raise IndexError

    def pop(self):
            '''If stack is not empty, pops item from stack and returns item.
    If stack is empty when pop is attempted, raises IndexError
    MUST have O(1) performance'''
            if (self.is_empty() == False):
    top = self.top.data
    self.top = self.top.next
    self.num_items -= 1
            return top
        else:
    raise IndexError

    def peek(self):
            '''If stack is not empty, returns next item to be popped (but does not pop the item)
    If stack is empty, raises IndexError
    MUST have O(1) performance'''
            if self.is_empty() == False:
            return self.top.data
        else:
    raise IndexError

    def size(self):
            '''Returns the number of elements currently in the stack, not the capacity
    MUST have O(1) performance'''
            return self.num_items
}
