package com.nscaleintermodal;

import org.jgrapht.Graph;
import org.jgrapht.GraphPath;
import org.jgrapht.alg.shortestpath.AStarShortestPath;
import org.jgrapht.alg.shortestpath.AllDirectedPaths;
import org.jgrapht.alg.shortestpath.BFSShortestPath;
import org.jgrapht.alg.shortestpath.DijkstraShortestPath;
import org.jgrapht.graph.*;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Part1 {

    private Graph<node, edge> graph;

    private node startingPoint;
    private node endingPoint;
    public Part1(String fileName) {
        List<String> lines;
        graph = new SimpleDirectedWeightedGraph(edge.class);
        //graph = new SimpleDirectedWeightedGraph<>(edge.class);

        File f = new File(fileName);
        try {
            BufferedReader reader = new BufferedReader(new FileReader(f));
            lines = reader.lines().collect(Collectors.toList());
        } catch (java.io.FileNotFoundException fnfe) {
            lines = new ArrayList<>();
        }

        for(int y=0;y<lines.size();y++) {
            for(int x=0;x<lines.get(y).length();x++) {
                node a = new node(x,y);
                char h = lines.get(y).charAt(x);
                if(h=='S'){
                    startingPoint=a;
                    startingPoint.setHeight('a');
                } else if(h=='E'){
                    endingPoint=a;
                    endingPoint.setHeight('z');
                } else {
                  a.setHeight(h);
                }
                if(!graph.containsVertex(a))
                    graph.addVertex(a);
                if(x+1<lines.get(y).length()) {
                    node b = new node(x + 1, y);
                    b.setHeight(lines.get(y).charAt(x+1));
                    if (!graph.containsVertex(b))
                        graph.addVertex(b);
                    //if(getWeight(a,b)<28) {
                        graph.setEdgeWeight(graph.addEdge(a, b), getWeight(a, b));
                    //}
                }
                if(y+1 < lines.size()) {
                    node c = new node(x, y + 1);
                    c.setHeight(lines.get(y+1).charAt(x));
                    if (!graph.containsVertex(c))
                        graph.addVertex(c);
                    if(getWeight(a,c)<28) {
                        graph.setEdgeWeight(graph.addEdge(a, c), getWeight(a, c));
                    }
                }
                if(x-1>=0) {
                    node d = new node(x - 1, y);
                    d.setHeight(lines.get(y).charAt(x-1));
                    if (!graph.containsVertex(d))
                        graph.addVertex(d);
                    if(getWeight(a,d)<28) {
                        graph.setEdgeWeight(graph.addEdge(a, d), getWeight(a, d));
                    }

                }
                if(y-1>=0) {
                    node e = new node(x, y - 1);
                    e.setHeight(lines.get(y-1).charAt(x));
                    if (!graph.containsVertex(e))
                        graph.addVertex(e);
                    if(getWeight(a,e)<28) {
                        graph.setEdgeWeight(graph.addEdge(a, e), getWeight(a, e));
                    }
                }
            }
        }

    }

    private double getWeight(node a, node b) {
        double weight=(a.value()-b.value());
        if(weight>1) {
            return Double.MAX_VALUE;
        }
        return weight+26;
    }

    public int solution(){
        DijkstraShortestPath<node, edge> dijkstra = new DijkstraShortestPath<>(graph);
        System.out.println(dijkstra.getPath(startingPoint,endingPoint).toString());
        GraphPath<node, edge> dsp = dijkstra.getPath(startingPoint,endingPoint);
        System.out.println("length " + dsp.getLength() + " weight " + dsp.getWeight());

        AllDirectedPaths<node,edge> allDirectedPaths = new AllDirectedPaths<>(graph);
        List<GraphPath<node,edge>> allPaths= allDirectedPaths.getAllPaths(startingPoint,endingPoint,true,graph.vertexSet().size());
        for(GraphPath p:allPaths){
            System.out.println("length " + p.getLength() + " weight " + p.getWeight());
        }
        //allPaths.stream().map(o -> o.getLength()).collect(Collectors.toSet()).stream().sorted().forEach(o -> System.out.println(o));
  //     BFSShortestPath<node,edge> bfsShortestPath = new BFSShortestPath<>(graph);
  //      return bfsShortestPath.getPath(startingPoint,endingPoint).getLength();
        return dsp.getLength();
    }
}
