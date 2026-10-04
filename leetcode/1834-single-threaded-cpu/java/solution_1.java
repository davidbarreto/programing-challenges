/**
 * The idea is to have one priority queue to retrieve tasks sorted by "enqueue time"
 * and another to populate with the available tasks (tasks which equeue time is <= current time),
 * that will keep tasks sorted by processing time, then index (regardless of enqueue time).
 *
 * Time complexity: O(n*log(n))
 *
 * Runtime: 363 ms
 * Memory: 274.78 MB
 */
class Solution {
    public int[] getOrder(int[][] tasks) {

        var n = tasks.length;
        List<CpuTask> tasksObj = new ArrayList(n);
        for (int i = 0; i < n; i++) {
            int[] task = tasks[i];
            tasksObj.add(new CpuTask(i, task[0], task[1]));
        }

        int[] executionOrder = new int[n];

        PriorityQueue<CpuTask> queue = new PriorityQueue<>(tasksObj);
        PriorityQueue<CpuTask> availableTasks = new PriorityQueue<>((a, b) ->
                a.processingTime() != b.processingTime()
                        ? Integer.compare(a.processingTime(), b.processingTime())
                        : Integer.compare(a.id(), b.id())
        );

        long start = queue.peek().availableAt();
        int i = 0;
        do {
            while (!queue.isEmpty() && queue.peek().availableAt() <= start) {
                availableTasks.offer(queue.poll());
            }
            var t = availableTasks.poll();
            if (t != null) {
                start += t.processingTime();
                executionOrder[i++] = t.id();
            } else {
                start = queue.peek().availableAt();
            }

        } while (i < n);

        return executionOrder;
    }
}

record CpuTask (int id, int availableAt, int processingTime) implements Comparable<CpuTask> {
    public int compareTo(CpuTask other) {
        var availableCmp = Integer.compare(this.availableAt(), other.availableAt());
        var processingCmp = Integer.compare(this.processingTime(), other.processingTime());
        return availableCmp == 0 ?
                (processingCmp == 0 ? Integer.compare(this.id(), other.id()) : processingCmp)
                : availableCmp;
    }
}

