package com.example.algovisualizerbackend.service;

import com.example.algovisualizerbackend.model.Node;
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
    private UnweightedEdgeService unweightedEdgeService;

    @Autowired
    private NodeService nodeService;

    public void saveGraph(UndirectedGraph graph){
        undirectedGraphRepository.saveGraph(graph.getGraphName(),graph.getNumVertices(),graph.getCustomerId());
        UndirectedGraph newGraph=undirectedGraphRepository.getLastGraphByCustomerIdAndGraphName(graph.getCustomerId(),graph.getGraphName());
        for(UnweightedEdge edge:graph.getEdges()){
            edge.setGraphId(newGraph.getId());
        }
        unweightedEdgeService.saveEdges(graph.getEdges());

        for(Node node: graph.getNodes()){
            node.setGraphId(newGraph.getId());
        }
        nodeService.saveNodes(graph.getNodes());
    }

    public UndirectedGraph LoadLastGraph(Long customerId, String graphName){
        UndirectedGraph graph=undirectedGraphRepository.getLastGraphByCustomerIdAndGraphName(customerId, graphName);
        List<UnweightedEdge> edges=unweightedEdgeService.searchEdgesByGraphId(graph.getId());
        graph.setEdges(edges);
        List<Node> nodes=nodeService.searchNodesByGraphId(graph.getId());
        graph.setNodes(nodes);
        return graph;
    }
}
