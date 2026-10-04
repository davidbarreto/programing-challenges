/**
 * Solution very similar to solution 1, but changing the first prioriy queue by a sorted list.
 * It makes sense because enqueue time will not change.
 * Although time complexitiy is the same, in practice the work done to produce the enqueue order is not.
 *
 * Time Complexity: O(n*log(n))
 *
 * Runtime: 173 ms
 * Memory: 273.01 MB
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

        Collections.sort(tasksObj);
        PriorityQueue<CpuTask> availableTasks = new PriorityQueue<>((a, b) ->
                a.processingTime() != b.processingTime()
                        ? Integer.compare(a.processingTime(), b.processingTime())
                        : Integer.compare(a.id(), b.id())
        );

        long start = tasksObj.get(0).availableAt();
        int i = 0;
        int next = 0;
        do {
            while (next < n && tasksObj.get(next).availableAt() <= start) {
                availableTasks.offer(tasksObj.get(next++));
            }
            var t = availableTasks.poll();
            if (t != null) {
                start += t.processingTime();
                executionOrder[i++] = t.id();
            } else {
                start = tasksObj.get(next).availableAt();
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
