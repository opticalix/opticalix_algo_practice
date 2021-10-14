package com.opticalix.problem.cmcc;

import com.opticalix.lib.Utils;

import java.util.*;

public class Game2020 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        scanner.nextInt();
        scanner.nextLine();

        scanner.nextLine();
        System.out.println(1);
    }

    /**
     * 2 2 5
     * 1 2
     * 1 2
     * 1 2 1
     * 2 1
     * 1 1 2
     * 2 2
     * 1 2 1
     */
    private static void t6() {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int q = scanner.nextInt();
        scanner.nextLine();

        int[] eIndex = new int[m];
        ArrayList<Node> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            //prepare nodes
            graph.add(new Node(i + 1));
        }
        for (int i = 0; i < m; i++) {
            int thisEId = i + 1;
            StringTokenizer st = new StringTokenizer(scanner.nextLine());
            int nId1 = Integer.valueOf(st.nextToken());
            int nId2 = Integer.valueOf(st.nextToken());
            int nId = Math.min(nId1, nId2);
            Node node1 = graph.get(nId - 1);
            node1.addEdge(thisEId, Math.max(nId1, nId2));
            eIndex[i] = nId - 1;
//            Node node2 = graph.get(nId2 - 1);
//            node2.addEdge(thisEId, nId1);
        }

        //opt
        for (int i = 0; i < q; i++) {
            String optLine = scanner.nextLine();
            StringTokenizer st = new StringTokenizer(optLine);
            if (st.nextToken().equals("1")) {
                //judge
                Integer nId1 = Integer.valueOf(st.nextToken());
                Integer nId2 = Integer.valueOf(st.nextToken());
                if (graph.get(nId1 - 1).isConnection(nId1, nId2)
                    || graph.get(nId2 - 1).isConnection(nId1, nId2)) {
                    System.out.println("Yes");
                } else {
                    System.out.println("No");
                }
//                boolean found = false;
//                for (int j = 0; j < graph.size(); j++) {
//                    Node node = graph.get(j);
//                    if (node.isConnection(nId1, nId2)) {
//                        System.out.println("Yes");
//                        found = true;
//                        break;
//                    }
//                }
//                if (!found) {
//                    System.out.println("No");
//                }
            } else {
                Integer eId = Integer.valueOf(st.nextToken());
                //remove
//                for (int k = 0; k < graph.size(); k++) {
//                    Node node = graph.get(k);
//                    node.removeEdge(eId);
//                }
                graph.get(eIndex[eId - 1]).removeEdge(eId);
            }
        }
    }


    static class Node {
        public int nId;
        public List<Edge> edges = new ArrayList<>();

        public Node(int nId) {
            this.nId = nId;
        }

        public boolean isConnection(int nId1, int nId2) {
            for (int i = 0; i < edges.size(); i++) {
                Edge e = edges.get(i);
                if (e.nId == nId1 && this.nId == nId2
                    || e.nId == nId2 && this.nId == nId1) {
                    return true;
                }
            }
            return false;
        }

        public void addEdge(int eId, int destNodeId) {
            Edge edge = new Edge();
            edge.eId = eId;;
            edge.nId = destNodeId;
            edges.add(edge);
        }

        public void removeEdge(int eId) {
//            ArrayList<Edge> newEdges = new ArrayList<>();
//            for (int i = 0; i < edges.size(); i++) {
//                Edge e = edges.get(i);
//                if (e.eId != eId) {
//                    newEdges.add(e);
//                }
//            }
//            this.edges = newEdges;
            Iterator<Edge> iterator = edges.iterator();
            while (iterator.hasNext()) {
                Edge edge = iterator.next();
                if (edge.eId == eId) {
                    iterator.remove();
                }
            }
        }
    }

    static class Edge {
        public int eId;
        public int nId;
        public int cnt;
    }


    private static void t4() {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        int max = 0;
        int cnt = 0;
        boolean flag = false;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == 'A') {
                if (!flag) {
                    flag = true;
                } else {
                    flag = false;
                    cnt = 0;
                }
            } else if (c == 'B') {
                if (flag) {
                    cnt++;
                    flag = false;
                } else {
                    flag = false;
                    cnt = 0;
                }
            }
            if (!flag && cnt > max) {
                max = cnt;
            }
        }
        if (!flag && cnt > max) {
            max = cnt;
        }
        System.out.println(max * 2);
    }

    private static void t3() {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        String[] absent = {"Jack", "Rose"};
        final String tom = "Tom";
        s = s.replace(absent[0], tom);
        s = s.replace(absent[1], tom);
        System.out.println(s);
    }

    private static void t2() {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int k = scanner.nextInt();
        scanner.nextLine();
        String line = scanner.nextLine();
        HashSet<String> set = new HashSet<>();
        for (int i = 0; i < line.length(); i++) {
            for (int j = i; j < Math.min(i + k, line.length()); j++) {
                String sub = line.substring(i, j + 1);
                if (sub.length() == k) {
                    set.add(sub);
                }
            }
        }
        System.out.println(set.size());
    }

    private static void t1() {
        //n<=1000 m<=10000
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        scanner.nextLine();
        String line = scanner.nextLine();
        StringTokenizer st = new StringTokenizer(line);
        int cnt = st.countTokens();
        int[] arr = new int[cnt];
        for (int i = 0; i < cnt; i++) {
            arr[i] = Integer.valueOf(st.nextToken());
        }
        Arrays.sort(arr);
        int ret = 0;
        int k = 0;
        boolean flag = false;
        for (int i = arr.length - 1; i >= 0; i--) {
            int num = arr[i];
            if (ret == m) {
                flag = true;
                break;
            }
            if (num > m || (ret + num) > m) {
                continue;
            } else {
                ret += num;
                k++;
            }
        }
        if (ret == m) {
            flag = true;
        }
        if (flag) {
            System.out.println(k);
        } else {
            System.out.println("No solution");
        }
    }

    private static void t1_1() {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        scanner.nextLine();
        String line = scanner.nextLine();
        StringTokenizer st = new StringTokenizer(line);

        ArrayList<Integer> intList = new ArrayList<>();
        while (st.hasMoreTokens()) {
            intList.add(Integer.valueOf(st.nextToken()));
        }
        Collections.sort(intList);
        Collections.reverse(intList);

        ArrayList<Integer> candidates = new ArrayList<>();
        for (int i = 0; i < intList.size(); i++) {
            int k = 0;
            int cnt = 1;
            for (int j = 0; j < intList.size(); j++) {
                int num = intList.get(j);
                k = k + num;
                if (k == m) {
                    candidates.add(cnt);
                } else if (k > m) {
                    k = k - num;
                } else {
                    cnt++;
                }
            }
        }

        if (candidates.size() == 0) {
            System.out.println("No solution");
        } else {
            System.out.println(Collections.min(candidates));
        }
    }

}
