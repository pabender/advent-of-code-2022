package com.nscaleintermodal;

import org.jgrapht.graph.DefaultWeightedEdge;

public class edge extends DefaultWeightedEdge {

    @Override
    public double getWeight() {
        return getWeight(((node)getTarget()),((node)getSource()));
    }

    private double getWeight(node a, node b) {
        /*if(a.getHeight()=='\0' || b.getHeight()=='\0'){
            return Double.MAX_VALUE;
        }*/
        double weight=(a.value()-b.value());
        /*if(weight>1) {
            return Double.MAX_VALUE;
        }*/
        return weight;
    }

    @Override
    public String toString(){
        return super.toString() + " weight: " + getWeight();
    }

}