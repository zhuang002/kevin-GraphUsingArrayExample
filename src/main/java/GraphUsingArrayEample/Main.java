/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GraphUsingArrayEample;

import java.util.ArrayList;
import java.util.Random;
import java.util.Stack;

/**
 *
 * @author zhuan
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        boolean[][] graph=buildGraph(9);
        int[] values=new int[9];
        Random rand=new Random();
        for (int i=0;i<9;i++) {
            values[i]=rand.nextInt(9);
        }
        
        ArrayList<Integer> nodes1=getAllAchievableNodesBFS(graph,0);
        ArrayList<Integer> nodes2=getAllAchievableNodesDFS(graph,0);
        int node0=getNodeByValue(graph,values, 8);
        Integer node1=getNodeByValueBFS(graph,values,0,8);
        Integer node2=getNodeByValueDFS(graph,values,0,8);
        
        

        
    }

    private static boolean[][] buildGraph(int size) {
        boolean[][] graph=new boolean[size][size]; //graph[0][2]=true, false
        for (int i=0;i<9;i++) {
            for (int j=0;j<9;j++)
                graph[i][j]=false;
        }
        
        graph[0][1]=true;
        graph[0][2]=true;
        graph[0][5]=true;
        graph[1][2]=true;
        graph[2][6]=true;
        graph[2][8]=true;
        graph[2][9]=true;
        graph[3][6]=true;
        graph[4][8]=true;
        graph[5][6]=true;
        graph[6][7]=true;
        
        graph[1][0]=true;
        graph[2][0]=true;
        graph[5][0]=true;
        graph[2][1]=true;
        graph[6][2]=true;
        graph[8][2]=true;
        graph[9][2]=true;
        graph[6][3]=true;
        graph[8][4]=true;
        graph[6][5]=true;
        graph[7][6]=true;
        

        
        return graph;
        
    }

    private static ArrayList<Integer> getAllAchievableNodesBFS(boolean[][] graph, int node) {
        ArrayList<Integer> nodes=new ArrayList();
        
        ArrayList<Integer> nodesHaveProcessed=new ArrayList<>();
        ArrayList<Integer> currentProcessingNodes=new ArrayList<>();
        ArrayList<Integer> nextProcessingNodes=new ArrayList();
        currentProcessingNodes.add(node);
        while (!currentProcessingNodes.isEmpty()) {
            for (Integer n:currentProcessingNodes) {
                for (int i=0;i<graph.length;i++) {
                    if (i==n) continue;
                    if (graph[n][i]) {
                        if (!nodesHaveProcessed.contains(i))
                            nextProcessingNodes.add(i);
                    } 
                }
                if (!nodesHaveProcessed.contains(n))
                    nodesHaveProcessed.add(n);
            }
            currentProcessingNodes=nextProcessingNodes;
            nextProcessingNodes=new ArrayList<>();
        }
        return nodesHaveProcessed;
    }

    private static ArrayList<Integer> getAllAchievableNodesDFS(boolean[][] graph, int node) {
        ArrayList<Integer> haveProcessed=new ArrayList();
        Stack<Integer> stack=new Stack();
        
        stack.add(node);
        
        while (!stack.isEmpty()) {
            Integer n=stack.pop();
            for (int i=0;i<graph.length;i++) {
                if (i==n) continue;
                if (graph[n][i]) {
                    if (!haveProcessed.contains(i)) {
                        stack.push(i);
                    }
                }
            }
            haveProcessed.add(n);
        }
        return haveProcessed;
    }

    private static Integer getNodeByValueBFS(boolean[][] graph, int[] values,int root, int v) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private static Integer getNodeByValueDFS(boolean[][] graph, int[] values, int root, int v) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private static Integer getNodeByValue(boolean[][] graph, int[] values, int v) {
        for (int i=0;i<values.length;i++) {
            if (values[i]==v) return i;
        }
        return -1;
    }
    
}
