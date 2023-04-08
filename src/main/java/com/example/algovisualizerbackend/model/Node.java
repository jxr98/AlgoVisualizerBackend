package com.example.algovisualizerbackend.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name="node")
public class Node {

    public Node(){}

    public Node(Integer index,Double x,Double y){
        this.index=index;
        this.x=x;
        this.y=y;
    }

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy=GenerationType.SEQUENCE)
    private Long id;

    @Column(name = "graph_id")
    private Long graphId;

    @Column(name="x")
    private Double x;

    @Column(name="y")
    private Double y;

    @Column(name="index")
    private Integer index;

    public Integer getIndex() {
        return index;
    }

    public void setIndex(Integer index) {
        this.index = index;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getGraphId() {
        return graphId;
    }

    public void setGraphId(Long graphId) {
        this.graphId = graphId;
    }

    public Double getX() {
        return x;
    }

    public void setX(Double x) {
        this.x = x;
    }

    public Double getY() {
        return y;
    }

    public void setY(Double y) {
        this.y = y;
    }
}
