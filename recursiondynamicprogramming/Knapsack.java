package recursiondynamicprogramming;

import java.util.PriorityQueue;

class Knapsack {
    static class MaxProfit {
        final int profit;
        final int weight;
        int maxProfit;

        public MaxProfit(int profit, int weight) {
            this.profit = profit;
            this.weight = weight;
        }

        public int getMaxProfit() {
            this.maxProfit = profit * weight;
            return this.maxProfit;
        }

        @Override
        public String toString() {
            return "{ " + maxProfit + " }";
        }
    }

    public int solveKnapsack(int[] profits, int[] weights, int capacity) {
        //sort the queue descending
        PriorityQueue<MaxProfit> queue = new PriorityQueue<>((a, b) -> b.getMaxProfit() - a.getMaxProfit());
        for (int i = 0; i < profits.length; i++) {
            queue.offer(new MaxProfit(profits[i], weights[i]));
        }
        System.out.println(queue);
        int sum = 0;
        while (!queue.isEmpty() && capacity >= 0) {
            MaxProfit temp = queue.poll();
            if (capacity >= temp.weight) {
                sum += temp.profit;
                capacity -= temp.weight;
            }
        }
        return sum;
    }

    private int knapsackRecursive(int[] profits, int[] weights, int capacity, int currentIndex) {
        // base checks
        if (capacity <= 0 || currentIndex >= profits.length)
            return 0;

        // recursive call after choosing the element at the currentIndex
        // if the weight of the element at currentIndex exceeds the capacity, we shouldn't process this
        int profit1 = 0;
        if (weights[currentIndex] <= capacity)
            profit1 = profits[currentIndex] + knapsackRecursive(profits, weights,
                    capacity - weights[currentIndex], currentIndex + 1);

        // recursive call after excluding the element at the currentIndex
        int profit2 = knapsackRecursive(profits, weights, capacity, currentIndex + 1);

        return Math.max(profit1, profit2);
    }

    public static void main(String[] args) {
        Knapsack ks = new Knapsack();
        int[] profits = {1, 6, 10, 16};
        int[] weights = {1, 2, 3, 5};
        int maxProfit = ks.solveKnapsack(profits, weights, 7);
        System.out.println("Total knapsack profit ---> " + maxProfit);
        maxProfit = ks.solveKnapsack(profits, weights, 6);
        System.out.println("Total knapsack profit ---> " + maxProfit);
    }
}