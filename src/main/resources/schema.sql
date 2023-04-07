create table IF NOT EXISTS customer
(
    id       BIGINT GENERATED BY DEFAULT AS IDENTITY,
    name     VARCHAR(50) NOT NULL,
    password VARCHAR(50) NOT NULL,
    email    VARCHAR(50) NOT NULL
);
create table IF NOT EXISTS undirected_graph
(
    id          BIGINT GENERATED BY DEFAULT AS IDENTITY,
    graphName   VARCHAR(50) NOT NULL,
    numVertices INTEGER     NOT NULL,
    customerId  BIGINT      NOT NULL
);
create table IF NOT EXISTS unweighted_edge
(
    id       BIGINT GENERATED BY DEFAULT AS IDENTITY,
    graph_id BIGINT  NOT NULL,
    source   INTEGER NOT NULL,
    target   INTEGER NOT NULL
);
