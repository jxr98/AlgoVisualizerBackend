package com.example.algovisualizerbackend.model;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name = "undirected_graph")
public class UndirectedGraph {

    public UndirectedGraph() {
    }

    public UndirectedGraph(String graphName, Long customerId, Integer numVertices, List<UnweightedEdge> edges, List<Node> nodes) {
        this.graphName = graphName;
        this.customerId = customerId;
        this.numVertices = numVertices;
        this.edges = edges;
        this.nodes = nodes;
    }

    public UndirectedGraph(Long id, String graphName, Integer numVertices, Long customerId) {
        this.graphName = graphName;
        this.customerId = customerId;
        this.numVertices = numVertices;
        this.id = id;
    }

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(name = "graphName")
    private String graphName;

    @Column(name = "numVertices")
    private Integer numVertices;

    @Column(name = "customerId")
    private Long customerId;

    @Transient
    private List<UnweightedEdge> edges;

    @Transient
    private List<Node> nodes;

    public String getGraphName() {
        return graphName;
    }

    public void setGraphName(String graphName) {
        this.graphName = graphName;
    }

    public List<Node> getNodes() {
        return nodes;
    }

    public void setNodes(List<Node> nodes) {
        this.nodes = nodes;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getNumVertices() {
        return numVertices;
    }

    public void setNumVertices(Integer numVertices) {
        this.numVertices = numVertices;
    }

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public List<UnweightedEdge> getEdges() {
        return edges;
    }

    public void setEdges(List<UnweightedEdge> edges) {
        this.edges = edges;
    }
}
