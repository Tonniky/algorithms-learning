package group_interview.beikezhaofang;

public class LRU {
    /**
     * lru design
     * @param operators int整型二维数组 the ops
     * @param k int整型 the k
     * @return int整型一维数组
     */
    public int[] LRU (int[][] operators, int k) {
        // write code here
        int resultLength = 0;
        for (int[] operator : operators) {
            if (operator[0] == 2) {
                resultLength++;
            }
        }
        int[] results = new int[resultLength];
        int index = 0;

        LruCache cache = new LruCache(k);
        for (int[] operator : operators) {
            switch (operator[0]) {
                case 1:
                    cache.put(operator[1], operator[2]);
                    break;
                case 2:
                    results[index++] = cache.get(operator[1]);
            }
        }
        return results;
    }

    final class LruCache {
        private final int bucketMark;
        private final int[] data;

        private int allocateIndex;

        private int lruHeadAddress;
        private int lruTailAddress;

        LruCache(int capacity) {
            if (capacity < 1) {
                throw new IllegalArgumentException();
            }
            int buckets = (int)(capacity / 0.75);
            this.data = new int[buckets + capacity * 5];
            this.allocateIndex = buckets;
            this.bucketMark = buckets - 1;
        }

        public void put(int key, int value) {
            int[] theData = data;
            int bucketIndex = bucketIndex(key);
            int nodeAddress = theData[bucketIndex];
            while (nodeAddress != 0 && theData[nodeAddress] != key) {
                nodeAddress = theData[nodeAddress + 2];
            }
            if (nodeAddress != 0) {
                theData[nodeAddress + 1] = value;
                touch(nodeAddress);
                return;
            }

            nodeAddress = allocate();
            theData[nodeAddress] = key;
            theData[nodeAddress + 1] = value;
            theData[nodeAddress + 2] = theData[bucketMark];
            theData[bucketIndex] = nodeAddress;
        }

        public int get(int key) {
            int[] theData = data;
            int bucketIndex = bucketIndex(key);
            int nodeAddress = theData[bucketIndex];
            while (nodeAddress != 0 && theData[nodeAddress] != key) {
                nodeAddress = theData[nodeAddress + 2];
            }
            if (nodeAddress == 0) {
                return -1;
            }

            touch(nodeAddress);

            return theData[nodeAddress + 1];
        }

        private void touch(int nodeAddress) {
            int[] theData = data;
            int lruNextAddress = theData[nodeAddress + 4];
            if (lruNextAddress == 0) {
                return;
            }

            int lruPreAddress = theData[nodeAddress + 3];
            if (lruPreAddress == 0) {
                lruHeadAddress = lruPreAddress;
                theData[lruHeadAddress + 3] = 0;
            } else {
                theData[lruPreAddress + 4] = lruNextAddress;
                theData[lruNextAddress + 3] = lruPreAddress;
            }
            theData[nodeAddress + 3] = lruTailAddress;
            theData[nodeAddress + 4] = 0;
            theData[nodeAddress + 4] = nodeAddress;
            lruTailAddress = nodeAddress;
        }

        private int allocate() {
            int[] theData = data;
            if (allocateIndex < theData.length) {
                if (lruTailAddress == 0) {
                    lruHeadAddress = allocateIndex;
                    lruTailAddress = allocateIndex;
                } else {
                    theData[lruTailAddress + 4] = allocateIndex;
                    theData[allocateIndex + 3] = lruTailAddress;
                    lruTailAddress = allocateIndex;
                }
                allocateIndex += 5;
                return lruTailAddress;
            }
            return lruTailAddress;
        }

        private int eviction() {
            int[] theData = data;
            int evictionAddress = lruHeadAddress;
            touch(evictionAddress);

            int key = theData[evictionAddress];
            int bucketIndex = bucketIndex(key);

            int curr = theData[bucketIndex];
            int last = 0;
            while (curr != 0 && curr != evictionAddress) {
                last = curr;
                curr = theData[curr + 2];
            }

            if (last == 0) {
                theData[bucketIndex] = theData[evictionAddress + 2];
            } else {
                theData[last + 2] = theData[evictionAddress + 2];
            }

            theData[evictionAddress + 2] = 0;
            return evictionAddress;
        }


        private int bucketIndex(int key) {
            return (key ^ (key >>> 16) & bucketMark);
        }

    }
}
