package mik.microsoft;

import java.util.HashMap;
import java.util.Map;

public class Fraction {
    public static void main(String[] args) {
        int[] x1 = {1, 1, 2}, y1 = {3, 2, 3};
        int[] x2 = {1, 1, 1}, y2 = {2, 2, 2};
        int[] x3 = {1, 2, 3, 1, 2, 12, 8, 4}, y3 = {5, 10, 15, 2, 4, 15, 10, 5};
        System.out.println(solve(x1, y1));
        System.out.println(solve(x2, y2));
        System.out.println(solve(x3, y3));
    }

    private static int solve(int[] x, int[] y) {
        int mod = (int) 1e9 + 7;
        int res = 0;
        Map<Node, Integer> map = new HashMap<>();
        for (int i = 0; i < x.length; i++) {
            int gcd = gcd(x[i], y[i]);
            Node node = new Node(x[i]/gcd, y[i]/gcd);
            if (map.containsKey(new Node(y[i]/gcd - x[i]/gcd, y[i]/gcd)))
                res = (res + map.get(new Node(y[i]/gcd - x[i]/gcd, y[i]/gcd))) % mod;
            map.put(node, map.getOrDefault(node, 0) + 1);
        }
        return res;
    }

    static int gcd(int a, int b) {
        if (b == 0)
            return a;
        return gcd(b, a % b);
    }

    static class Node {
        int x, y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public int hashCode() {
            final int prime = 31;
            int result = 1;
            result = prime * result + x;
            result = prime * result + y;
            return result;
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj)
                return true;
            if (obj == null)
                return false;
            if (getClass() != obj.getClass())
                return false;
            Node other = (Node) obj;
            if (x != other.x)
                return false;
            if (y != other.y)
                return false;
            return true;
        }
    }
}
