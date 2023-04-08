package com.example.algovisualizerbackend.repository;

import com.example.algovisualizerbackend.model.UndirectedGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface UndirectedGraphRepository extends JpaRepository<UndirectedGraph,Long> {
    @Query(nativeQuery = true,value = "select id, graphName,numVertices, customerId from undirected_graph  where customerId = ?1 and graphName = ?2 order by id DESC limit 1 ")
    UndirectedGraph getLastGraphByCustomerIdAndGraphName(Long customerId, String graphName);

    @Transactional
    @Modifying
    @Query(nativeQuery = true,value = "INSERT INTO undirected_graph (graphName,numVertices,customerId) values ( ?1,?2,?3 )")
    void saveGraph(String graphName,Integer numVertices, Long customerId);
}
