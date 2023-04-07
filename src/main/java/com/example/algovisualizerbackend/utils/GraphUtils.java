package com.example.algovisualizerbackend.utils;

public class GraphUtils {
    public static boolean checkGraphName(String graphName){
        if(graphName.equals(GraphName.BFS.toString())||graphName.equals(GraphName.DFS.toString())){
            return true;
        }else return false;
    }
}
