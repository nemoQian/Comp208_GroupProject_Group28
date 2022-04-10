package com.group28.pojo;

import org.junit.Test;

import java.util.Map;

public class primTest {
    @Test
    public void primAlgotest() {
        Graph<String> graph = new Graph<String>();
        graph.setVertexNum(4);
        graph.setArcNum(5);
        int arc[][] = new int[5][5];
        arc[0][1]=19;
        arc[1][0]=19;
        arc[1][2]=25;
        arc[2][1]=25;
        arc[1][3]=25;
        arc[3][1]=25;
        arc[2][3]=17;
        arc[3][2]=17;
        arc[2][0]=46;
        arc[0][2]=46;
        graph.setArc(arc);
        String vertex[]=new String[4];
        for (int i= 0;i<4;i++) {
            vertex[i]="vertex"+i;
        }
        graph.setVertex(vertex);
        Prim<String> prim =new Prim<String>();
        prim.setGraph(graph);
        Map<Integer,ShortEdge> resultMap=prim.prim();
        for(int key:resultMap.keySet()) {
            System.out.format("Edge%d"+"-"+"%d,"+"Value：%d\n",key,resultMap.get(key).getAdjvex(),
                    resultMap.get(key).getLowCost());
        }

    }
}
