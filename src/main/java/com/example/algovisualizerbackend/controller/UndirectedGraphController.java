package com.example.algovisualizerbackend.controller;

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

import java.util.ArrayList;
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
        List<UnweightedEdge> edgesInGraph=mapper.readValue(edgesString,ArrayList.class);

        UndirectedGraph undirectedGraph = new UndirectedGraph(graphName,Long.valueOf(customerId),numVertices,edgesInGraph);
        undirectedGraphService.saveGraph(undirectedGraph);
        return Boolean.TRUE;
    }

    @PostMapping(value="/loadLastGraph",produces = "application/json")
    public @ResponseBody UndirectedGraph loadLastGraph(Map<String,String> payload){
        if(!GraphUtils.checkGraphName(payload.get("graphName"))){
            return null;
        }
        return undirectedGraphService.LoadLastGraph(Long.parseLong(payload.get("customerId")),payload.get("graphName"));
    }

}
