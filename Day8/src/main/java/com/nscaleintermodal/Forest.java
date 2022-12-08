package com.nscaleintermodal;

import java.util.ArrayList;
import java.util.List;

public class Forest {

    List<List<tree>> grid;
    public Forest(List<String> lines) {
        grid = new ArrayList<>();
        for(String s:lines){
            List<tree> row = new ArrayList<>();
            for(int i=0;i<s.length();i++){
                row.add(new tree(s.charAt(i)-'0'));
            }
            grid.add(row);
        }
    }

    tree getTree(int x, int y){
        return grid.get(x).get(y);
    }

    public int countVisible() {
        int count = 0;
        int rows = grid.size();
        int columns = grid.get(0).size();
        for(int x=0;x<rows;x++){
            for(int y=0;y<columns;y++){
                tree position = getTree(x,y);
                if(x==0 || y==0 || x==(rows-1) || y==(columns-1)){
                    position.setVisible(true);
                }

                for(int i=y-1;i>=0;i--){
                    if(i==0 && getTree(x,i).height() < position.height()){
                        position.setVisible(true);
                    } else  if(getTree(x,i).height()>= position.height()){
                        break;
                    }
                }

                for(int i=y+1;i<columns;i++){
                    if(i==columns-1 && getTree(x,i).height() < position.height()){
                        position.setVisible(true);
                    } else  if(getTree(x,i).height()>= position.height()){
                        break;
                    }
                }

                for(int i=x-1;i>=0;i--){
                    if(i==0 && getTree(i,y).height() < position.height()){
                        position.setVisible(true);
                    } else  if(getTree(i,y).height()>= position.height()){
                        break;
                    }
                }

                for(int i=x+1;i<rows;i++){
                    if(i==rows-1 && getTree(i,y).height() < position.height()){
                        position.setVisible(true);
                    } else  if(getTree(i,y).height()>= position.height()){
                        break;
                    }
                }



                if(position.isVisible()) {
                    count++;
                }
            }
        }
        return count;
    }


    private void calcScenicScores(){
        int rows = grid.size();
        int columns = grid.get(0).size();
        for(int x=0;x<rows;x++){
            for(int y=0;y<columns;y++){
                tree position = getTree(x,y);
                if(x==0 || y==0 || x==(rows-1) || y==(columns-1)){
                    position.setScenicScore(0);
                    continue;
                }

                int score = 1;

                for(int i=y-1;i>=0;i--){
                    if(i==0 && getTree(x,i).height() < position.height()){
                        score *=(y);
                    } else  if(getTree(x,i).height()>= position.height()){
                        score *=(y-i);
                        break;
                    }
                }

                for(int i=y+1;i<columns;i++){
                    if(i==columns-1 && getTree(x,i).height() < position.height()){
                        score*=(columns-1-y);
                    } else  if(getTree(x,i).height()>= position.height()){
                        score*=(i-y);
                        break;
                    }
                }

                for(int i=x-1;i>=0;i--){
                    if(i==0 && getTree(i,y).height() < position.height()){
                        score*=(x);
                    } else  if(getTree(i,y).height()>= position.height()){
                        score*=(x-i);
                        break;
                    }
                }

                for(int i=x+1;i<rows;i++){
                    if(i==rows-1 && getTree(i,y).height() < position.height()){
                        score*=(rows-1-x);
                    } else  if(getTree(i,y).height()>= position.height()) {
                        score*=(i-x);
                        break;
                    }
                }

                position.setScenicScore(score);
            }
        }

    }
    public int maxScenicScore() {
        calcScenicScores();
        return grid.stream().map(o -> o.stream().map(t->t.getScenicScore()).reduce(0,Integer::max)).reduce(0,Integer::max);
    }
}
