package com.nscaleintermodal;

import java.util.ArrayList;
import java.util.List;

public class DirectoryNode implements node{

    private String name;
    private List<node> children;
    public DirectoryNode(String name) {
        this.name=name;
        children=new ArrayList<>();
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public long getSize() {
        return children.stream().map(o -> o.getSize()).reduce(0L,Long::sum);
    }

    public void add(node entry) {
        children.add(entry);
    }

    public List<node> getList() {
        return children;
    }

    public long calculate100KSum() {
        if(getSize()<100000) {
            return getSize() + children.stream()
                            .filter(o -> o instanceof DirectoryNode)
                            .filter(o -> o.getSize() <= 100000L)
                            .map(o -> ((DirectoryNode) o).calculate100KSum()).reduce(0L,Long::sum);

        }
        return children.stream()
                .filter(o -> o instanceof DirectoryNode)
                .map(o -> ((DirectoryNode) o).calculate100KSum()).reduce(0L,Long::sum);

    }

    public node getChildWithName(String name) {
        for(node n:children){
            if(n.getName().equals(name)){
                return n;
            }
        }
        return null;
    }

    public long findSmallestOver(long theshold) {
        if(getSize()>=theshold) {
            return Long.min(getSize(),
                    children.stream()
                            .filter(o -> o instanceof DirectoryNode)
                            .filter(o -> ((DirectoryNode) o).getSize() >=theshold )
                            .map(o -> ((DirectoryNode) o).findSmallestOver(theshold)).reduce(Long.MAX_VALUE,Long::min));
        }
        return Long.MAX_VALUE;
    }
}
