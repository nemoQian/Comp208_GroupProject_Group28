package com.group28.pojo;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class Prim<T> {
    private Map<Integer,ShortEdge> map = new HashMap<Integer, ShortEdge>();
    private Graph<T> graph;
    public Graph<T> getGraph() {
        return graph;
    }
    public void setGraph(Graph<T> graph) {
        this.graph = graph;
    }
    public Map<Integer,ShortEdge> prim() {
        initial();
        int arc[][]=graph.getArc();
        Map<Integer,ShortEdge> resultMap=new LinkedHashMap<Integer,ShortEdge>();
        while(map.size()>0) {
            int k = minEdge(map);
            resultMap.put(k,map.get(k) );
            map.remove(k);
            if(map.size()==0)
                break;
            for (int key:map.keySet()) {
                if (arc[key][k] < map.get(key).getLowCost())
                    map.get(key).setLowCost(arc[k][key]);
                map.get(key).setAdjvex(k);
            }
        }
        return resultMap;
    }
    private void initial() {
        int arc[][]=graph.getArc();
        for(int i = 1; i < graph.getVertexNum(); i++) {
            ShortEdge shortEdge = new ShortEdge();
            shortEdge.setAdjvex(0);
            if(arc[0][i]!=0)
                shortEdge.setLowCost(arc[0][i]);
            else
                shortEdge.setLowCost(Integer.MAX_VALUE);
            map.put(i,shortEdge);
        }
    }
    private int minEdge(Map<Integer,ShortEdge> map) {
        int min=Integer.MAX_VALUE;
        int found =0;
        for(Integer key: map.keySet()) {
            if(map.get(key).getLowCost()<min) {
                min=map.get(key).getLowCost();
                found=key;
            }
        }
        return found;
    }

}


