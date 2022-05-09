package com.group28.pojo;

/**
  * @author Yuyuan Cao
  */
public class Graph<T> {
    private int vertexNum;
    private T vertex[];
    private int arcNum;
    private int arc[][];
    public int getVertexNum() {
        return vertexNum;
    }
    public void setVertexNum(int vertexNum) {
        this.vertexNum = vertexNum;
    }
    public T[] getVertex() {
        return vertex;
    }
    public void setVertex(T[] vertex) {
        this.vertex = vertex;
    }
    public int getArcNum() {
        return arcNum;
    }
    public void setArcNum(int arcNum) {
        this.arcNum = arcNum;
    }
    public int[][] getArc() {
        return arc;
    }
    public void setArc(int[][] arc) {
        this.arc = arc;
    }



}
