package com.example.algovisualizerbackend.repository;

import com.example.algovisualizerbackend.model.UnweightedEdge;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UnweightedEdgeRepository extends JpaRepository<UnweightedEdge,Long> {

    @Query(nativeQuery = true, value="select * from unweighted_edge e where e.graph_id=?1")
    List<UnweightedEdge> searchEdgesByGraphId(Long graphId);

    @Transactional
    @Modifying
    @Query(nativeQuery = true,value = "insert into unweighted_edge (source, target,graph_id) values (?1, ?2, ?3) ")
    void saveGraphEdge(Integer source,Integer target, Long graphId);
}
