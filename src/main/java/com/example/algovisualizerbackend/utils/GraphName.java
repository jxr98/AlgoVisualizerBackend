package com.example.algovisualizerbackend.utils;

public enum GraphName {
    BFS,
    DFS;

    public String toString() {
        switch (this) {
            case BFS:
                return "BFS";
            case DFS:
                return "DFS";
        }
        return null;
    }
}
