import java.util.*;
import java.lang.*;
import java.io.*;
import java.util.Scanner;


public class p3230718_BFS
{
    public static void main (String[] args)
    {
        Scanner s = new Scanner(System.in);

        int n = s.nextInt(), k = s.nextInt(),
                start = s.nextInt() - 1, end = s.nextInt() - 1;

        ArrayList<ArrayList<Integer>> g = new ArrayList<ArrayList<Integer>> (n);
        for (int i = 0; i < n; i++){
            g.add(new ArrayList<Integer>());
        }

        int curr1, curr2;
        for (int i = 0; i < k; i++){
            curr1 = s.nextInt() - 1;
            curr2 = s.nextInt() - 1;
            g.get(curr1).add(curr2);
            g.get(curr2).add(curr1);
        }

        LinkedList <Integer> plan = new LinkedList<Integer>();
        boolean used [] = new boolean [n];
        int parent[] = new int [n];

        plan.add(start);
        used[start] = true;
        parent[start] = start;

        int point = start;
        while (point != end && !plan.isEmpty()){
            point = plan.get(0);
            plan.removeFirst();

            for (int x: g.get(point)){
                if(!used[x]){
                    used[x] = true;
                    plan.add(x);
                    parent[x] = point;
                }
            }
        }

        if (point == end){
            ArrayList<Integer> path = new ArrayList();
            path.add(point);

            while (point != start){
                point = parent[point];
                path.add(point);
            }

            Collections.reverse(path);

            System.out.println(path.size() - 1);
            for(int x : path)
                System.out.print(x + 1 + " ");
        }else{
            System.out.println(-1);
        }
    }
}