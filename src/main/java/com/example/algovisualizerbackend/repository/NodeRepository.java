package com.example.algovisualizerbackend.repository;

import com.example.algovisualizerbackend.model.Node;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface NodeRepository extends JpaRepository<Node,Long> {

    @Query(nativeQuery = true,value = "select * from node where graph_id=?1 ")
    List<Node> searchNodesByGraphId(Long graphId);

    @Transactional
    @Modifying
    @Query(nativeQuery = true,value = "insert into node(graph_id,x,y,index) values (?1, ?2, ?3, ?4 ) ")
    void saveGraphNodes(Long graphId,Double x, Double y, Integer index);
}
