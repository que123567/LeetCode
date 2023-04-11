package medium;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class LeetCode341 {

    public interface NestedInteger {
        // @return true if this NestedInteger holds a single integer, rather than a nested list.
        public boolean isInteger();

        // @return the single integer that this NestedInteger holds, if it holds a single integer
        // Return null if this NestedInteger holds a nested list
        public Integer getInteger();

        // @return the nested list that this NestedInteger holds, if it holds a nested list
        // Return empty list if this NestedInteger holds a single integer
        public List<NestedInteger> getList();
    }

    public class NestedIterator implements Iterator<Integer> {
        private LinkedList<NestedInteger> mList;

        public NestedIterator(List<NestedInteger> nestedList) {
            mList = new LinkedList<>(nestedList);
        }

        @Override
        public Integer next() {
            return mList.get(0).getInteger();
        }

        @Override
        public boolean hasNext() {
            if (mList.size() > 0 && !mList.get(0).isInteger()) {
                List<NestedInteger> first = mList.remove().getList();
                mList.addAll(first);
            }
            return !mList.isEmpty();
        }
    }

    public static void main(String[] args) {
    }

}
