package com.example.algovisualizerbackend.controller;

import com.example.algovisualizerbackend.model.Node;
import com.example.algovisualizerbackend.model.UndirectedGraph;
import com.example.algovisualizerbackend.model.UnweightedEdge;
import com.example.algovisualizerbackend.service.UndirectedGraphService;
import com.example.algovisualizerbackend.utils.GraphUtils;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("undirectedGraph")
@CrossOrigin
public class UndirectedGraphController {
    @Autowired
    private UndirectedGraphService undirectedGraphService;

    @PostMapping(value="/save")
    public @ResponseBody Boolean saveGraph(@RequestParam(value = "edges") List edges,
                             @RequestParam(value="nodes") List nodes,
                             @RequestParam(value = "customerId") int customerId,
                             @RequestParam(value = "numVertices") int numVertices,
                             @RequestParam(value = "graphName") String graphName) throws JsonProcessingException {
        if(!GraphUtils.checkGraphName(graphName)){
            return Boolean.FALSE;
        }

        String edgesString="";
        for(Object edge: edges){
            edgesString+=edge;
            edgesString+=",";
        }
        ObjectMapper mapper = new ObjectMapper();
        List<LinkedHashMap<String,Integer>> edgesTemp=mapper.readValue(edgesString,List.class);
        List<UnweightedEdge> edgesInGraph=new ArrayList<>();
        for(LinkedHashMap<String,Integer> edge:edgesTemp){
            edgesInGraph.add(new UnweightedEdge(edge.get("source"),edge.get("target")));
        }

        String nodesString="";
        for(Object node:nodes){
            nodesString+=node;
            nodesString+=",";
        }
        List<LinkedHashMap<String,Object>> nodesTemp=mapper.readValue(nodesString,List.class);
        List<Node> nodesInGraph=new ArrayList<>();
        for(LinkedHashMap<String,Object> node:nodesTemp){
            nodesInGraph.add(new Node((Integer) node.get("index"), (Double) node.get("x"), (Double) node.get("y")));
        }

        UndirectedGraph undirectedGraph = new UndirectedGraph(graphName,Long.valueOf(customerId),numVertices,edgesInGraph,nodesInGraph);
        undirectedGraphService.saveGraph(undirectedGraph);
        return Boolean.TRUE;
    }

    @PostMapping(value="/loadLastGraph",produces = "application/json")
    public @ResponseBody UndirectedGraph loadLastGraph( @RequestParam(value = "customerId") int customerId,
                                                        @RequestParam(value = "graphName") String graphName){
        if(!GraphUtils.checkGraphName(graphName)){
            return null;
        }
        return undirectedGraphService.LoadLastGraph(Long.valueOf(customerId),graphName);
    }

}
