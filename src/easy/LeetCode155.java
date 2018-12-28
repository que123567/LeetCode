package easy;

import java.util.Stack;

/**
 * 155. Min Stack
 * Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.
 * push(x) -- Push element x onto stack.
 * pop() -- Removes the element on top of the stack.
 * top() -- Get the top element.
 * getMin() -- Retrieve the minimum element in the stack.
 * Example:
 * MinStack minStack = new MinStack();
 * minStack.push(-2);
 * minStack.push(0);
 * minStack.push(-3);
 * minStack.getMin();   --> Returns -3.
 * minStack.pop();
 * minStack.top();      --> Returns 0.
 * minStack.getMin();   --> Returns -2.
 */
public class LeetCode155 {

    /**
     * Your MinStack object will be instantiated and called as such:
     * MinStack obj = new MinStack();
     * obj.push(x);
     * obj.pop();
     * int param_3 = obj.top();
     * int param_4 = obj.getMin();
     */
    class MinStack {
        int min = Integer.MAX_VALUE;
        Stack<Integer> mStack;
        /**
         * initialize your data structure here.
         */
        public MinStack() {
            mStack = new Stack<>();
        }

        /**
         * 每个最小值之下都存着次小值,保持min随时能得到更新
         * @param x
         */
        public void push(int x) {
            if (x <= min) {
                mStack.push(min);
                min = x;
            }
            mStack.push(x);
        }

        public void pop() {
            if (mStack.pop() == min) {
                min = mStack.pop();
            }
        }

        public int top() {
            return mStack.peek();
        }

        public int getMin() {
            return min;
        }
    }

}
