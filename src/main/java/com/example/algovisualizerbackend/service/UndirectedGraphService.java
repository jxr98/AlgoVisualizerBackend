package com.example.algovisualizerbackend.service;

import com.example.algovisualizerbackend.model.UndirectedGraph;
import com.example.algovisualizerbackend.model.UnweightedEdge;
import com.example.algovisualizerbackend.repository.UndirectedGraphRepository;
import com.example.algovisualizerbackend.repository.UnweightedEdgeRepository;
import com.example.algovisualizerbackend.utils.GraphName;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UndirectedGraphService {
    @Autowired
    private UndirectedGraphRepository undirectedGraphRepository;

    @Autowired
    private UnweightedEdgeRepository unweightedEdgeRepository;

    public void saveGraph(UndirectedGraph graph){
        undirectedGraphRepository.saveGraph(graph.getGraphName(),graph.getNumVertices(),graph.getCustomerId());
        UndirectedGraph newGraph=undirectedGraphRepository.getLastGraphByCustomerIdAndGraphName(graph.getCustomerId(),graph.getGraphName());
        for(UnweightedEdge edge:newGraph.getEdges()){
            edge.setGraphId(newGraph.getId());
        }
        unweightedEdgeRepository.saveAll(newGraph.getEdges());
    }

    public UndirectedGraph LoadLastGraph(Long customerId, String graphName){
        UndirectedGraph graph=undirectedGraphRepository.getLastGraphByCustomerIdAndGraphName(customerId, graphName);
        List<UnweightedEdge> edges=unweightedEdgeRepository.searchEdgesByGraphId(graph.getId());
        graph.setEdges(edges);
        return graph;
    }
}
