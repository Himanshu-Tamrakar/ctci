package com.ht.algorithms;

public class Sulution3_1 {
    private static class FixedMultiStack {
        private int sizeOfEachStack;
        private int totalStacks;
        private int[] individualStackSize;
        private int[] stack;

        public FixedMultiStack(int sizeOfEachStack, int totalStacks) {
            this.sizeOfEachStack = sizeOfEachStack;
            this.totalStacks = totalStacks;
            this.stack = new int[totalStacks * sizeOfEachStack];
            this.individualStackSize = new int[totalStacks];
        }

        /**
         *
         * @param putOnStack alway starts with zero
         * @param item
         */
        public void push(int putOnStack, int item) throws Exception {
            int index = getActualIndex(putOnStack);
            if(!isValidIndex(putOnStack, index)) throw new Exception("Stack Overflow");

            this.stack[index] = item;
            this.individualStackSize[putOnStack]++;
        }

        private boolean isValidIndex(int onStack, int index) {
            if(index >= this.sizeOfEachStack * onStack && index <this.sizeOfEachStack * (onStack + 1)) return true;
            return false;
        }

        private int getActualIndex(int onStack) {
            int indexfrom = (onStack) * this.sizeOfEachStack;
            int offset = this.individualStackSize[onStack];
            return indexfrom + offset;
        }

        @Override
        public String toString() {
            int i = 0;

            while (i < this.totalStacks) {
                for (int j = 0; j < this.sizeOfEachStack; j++) {
                    System.out.printf("Stack no. %d - %d \n", i, this.stack[i * this.sizeOfEachStack + j]);
                }
                i++;
            }
            return "";
        }

    }


    private static class MultiStack {
       private int[] values;
       private StackInfo[] info;

       private class StackInfo {
           public int start, size, capacity;
           public boolean lookingForInsert = false;
           public StackInfo(int start, int capacity) {
               this.start = start;
               this.capacity = capacity;
           }

           public boolean isWithinStackCapacity(int index) {
               if(index < 0 || index >= values.length) {
                   return false;
               }

               int contigeosIndex = index < start ? index + values.length : index;
               int end = start + capacity;
               return start <= contigeosIndex && contigeosIndex < end;
           }

           public int lastCapacitylndex() {
               return adjustlndex(start + capacity - 1);
           }
           public int lastElementIndex() {
               return adjustlndex(start + size - 1);
           }
           public boolean iSFull() { return size == capacity; }
           public boolean isEmpty() { return size == 0; }


       }

       public MultiStack(int defaultStackSize, int totalStack) {
           this.info = new StackInfo[totalStack];
           for (int i = 0; i < totalStack; i++) {
               info[i] = new StackInfo(defaultStackSize * i,  defaultStackSize);
           }
           this.values = new int[defaultStackSize * totalStack];
       }

       public void push(int onStack, int value) throws Exception {
           if(allStacksAreFull()) {
                throw new Exception("Stack is full");
           }

           StackInfo stack = this.info[onStack];
           stack.lookingForInsert = true;
           if(stack.iSFull()) {
            this.shift(onStack);
           }
           stack.size++;
           this.values[stack.lastElementIndex()] = value;
           stack.lookingForInsert = false;
       }

       private void shift(int onStack) {
           StackInfo stack = this.info[onStack];
           if(stack.size == stack.capacity) {
               int nextStack = (onStack + 1) % info.length;
               shift(nextStack);
               stack.capacity++;
           }
           if(!stack.lookingForInsert) {
               int index = stack.lastCapacitylndex();
               while (stack.isWithinStackCapacity(index)) {
                   values[index] = values[previouslndex(index)];
                   index = previouslndex(index);
               }
               values[stack.start] = 0;
               stack.start = nextlndex(stack.start);
               stack.capacity--;
           }

       }

       private int nextlndex(int index) {
            return adjustlndex(index + 1);
        }

       private int previouslndex(int index) {
            return adjustlndex(index - 1);
        }

       private int adjustlndex(int index) {
           int max = values.length;
           return ((index % max) + max) % max;
       }

       private boolean allStacksAreFull() {
           return numberOfElements() == values.length;
       }

       private int numberOfElements() {
           int size = 0;
           for (StackInfo info: this.info) {
               size += info.size;
           }
           return size;
       }

        @Override
        public String toString() {
           int i = 0;
            for (StackInfo info: this.info) {
                for (int j = 0; j < info.size; j++) {
                    System.out.println(this.values[info.start + j]);
                }
            }
            return "";
        }
    }

    public static void main() {
        MultiStack fms = new MultiStack(3, 3);
        try {
            fms.push(0, 1);
            fms.push(1, 4);
            fms.push(0, 2);
            fms.push(0, 3);
            fms.push(0, 5);
            fms.push(1, 15);
            fms.push(0, 6);
            fms.push(1, 7);
            fms.push(2, 8);
            fms.push(2, 9);
        } catch (Exception ex) {
            System.out.printf("%s", ex);
        }
        System.out.printf("%s", fms);
    }
}
