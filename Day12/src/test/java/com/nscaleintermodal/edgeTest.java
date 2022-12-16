package com.nscaleintermodal;

import org.jgrapht.Graph;
import org.jgrapht.graph.SimpleDirectedWeightedGraph;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class edgeTest {

    @Test
    public void weightTest(){
        node a = new node(1,1);
        node b = new node(1,2);
        a.setHeight('a');
        b.setHeight('b');
        Graph<node,edge> g = new SimpleDirectedWeightedGraph(edge.class);
        g.addVertex(a);
        g.addVertex(b);
        g.addEdge(a,b);
        g.addEdge(b,a);
        assertThat(g.getEdge(a,b).getWeight()).isEqualTo(1);
        assertThat(g.getEdge(b,a).getWeight()).isEqualTo(-1);
    }

    @Test
    public void weightTest2(){
        node a = new node(1,1);
        node b = new node(1,2);
        a.setHeight('z');
        b.setHeight('f');
        Graph<node,edge> g = new SimpleDirectedWeightedGraph(edge.class);
        g.addVertex(a);
        g.addVertex(b);
        g.addEdge(a,b);
        g.addEdge(b,a);
        assertThat(g.getEdge(a,b).getWeight()).isEqualTo(-20);
        assertThat(g.getEdge(b,a).getWeight()).isEqualTo(Double.MAX_VALUE);
    }

}
