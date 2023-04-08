package com.example.algovisualizerbackend.service;

import com.example.algovisualizerbackend.model.UnweightedEdge;
import com.example.algovisualizerbackend.repository.UnweightedEdgeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UnweightedEdgeService {
    @Autowired
    private UnweightedEdgeRepository unweightedEdgeRepository;

    public void saveEdges(List<UnweightedEdge> edges){
        for(UnweightedEdge edge:edges){
            unweightedEdgeRepository.saveGraphEdge(edge.getSource(),edge.getTarget(),edge.getGraphId());
        }
    }

    public List<UnweightedEdge> searchEdgesByGraphId(Long graphId){
        return unweightedEdgeRepository.searchEdgesByGraphId(graphId);
    }
}
