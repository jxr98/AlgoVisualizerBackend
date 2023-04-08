package com.example.algovisualizerbackend.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name="unweighted_edge")
public class UnweightedEdge {

    public UnweightedEdge(){}

    public UnweightedEdge(Integer source,Integer target){
        this.source=source;
        this.target=target;
    }

    @Id
    @Column(name="id")
    @GeneratedValue(strategy= GenerationType.SEQUENCE)
    private Long id;

    @Column(name="source")
    private Integer source;

    @Column(name="target")
    private Integer target;

    @Column(name = "graph_id")
    private Long graphId;

    public Long getGraphId() {
        return graphId;
    }

    public void setGraphId(Long graphId) {
        this.graphId = graphId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getSource() {
        return source;
    }

    public void setSource(Integer source) {
        this.source = source;
    }

    public Integer getTarget() {
        return target;
    }

    public void setTarget(Integer target) {
        this.target = target;
    }
}
