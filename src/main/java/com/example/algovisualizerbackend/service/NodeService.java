package com.example.algovisualizerbackend.service;

import com.example.algovisualizerbackend.model.Node;
import com.example.algovisualizerbackend.repository.NodeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NodeService {
    @Autowired
    private NodeRepository nodeRepository;

    public void saveNodes(List<Node> nodes){
        for(Node node:nodes){
            nodeRepository.saveGraphNodes(node.getGraphId(), node.getX(), node.getY(),node.getIndex());
        }
    }

    public List<Node> searchNodesByGraphId(Long graphId){
        return nodeRepository.searchNodesByGraphId(graphId);
    }
}
