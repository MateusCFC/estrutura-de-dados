package p3;

import java.util.LinkedList;

/**
 * Created by Mateus Antonio on 21/03/2016.
 */

public class Traversal {

    static final Ocean ocean = new Ocean(0);
    static final int pathColor = 200;
    static final int deadEndColor = 100;
    static int alfa = 0;
    static void slow() {
        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
        }
    }


    ///////////// Metodos a serem completados /////////////


    static void q21() {
        LinkedList<Cell> q = new LinkedList<>();
        q.add(ocean.marlin);
        ocean.setMark(ocean.marlin);
        int flag = 0;
        while (!(q.isEmpty())) {
            Cell v = q.getFirst();
            LinkedList<Cell> u = v.neighbors();
            for (int i = 0; i < u.size(); i++) {
                Cell atual = u.get(i);
                if (ocean.isNemo(atual)){
                    ocean.setMark(ocean.nemo);
                    flag = 1;
                    break;
                }
                if (!ocean.isShark(atual) && !ocean.isWall(atual) && !ocean.isMarked(atual)) {
                    q.addLast(atual);
                    ocean.setMark(atual);
                }
            }
            if (flag == 1) break;
            q.removeFirst();
            Traversal.slow();
        }
    }

    static void q22() {
        LinkedList<Cell> q = new LinkedList<>();
        q.add(ocean.marlin);
        ocean.setMark(ocean.marlin);
        int flag = 0;
        while (!(q.isEmpty())) {
            Cell v = q.getFirst();
            LinkedList<Cell> u = v.neighbors();
            for (int i = 0; i < u.size(); i++) {
                Cell atual = u.get(i);
                if (ocean.isNemo(atual)){
                    ocean.setMark(ocean.nemo,ocean.getMark(v)+1);
                    flag = 1;
                    break;
                }
                if (!ocean.isShark(atual) && !ocean.isWall(atual) && !ocean.isMarked(atual)) {
                    q.addLast(atual);
                    ocean.setMark(atual,ocean.getMark(v)+1);
                }
            }
            if (flag == 1) break;
            q.removeFirst();
            Traversal.slow();
        }
        alfa = ocean.getMark(ocean.nemo);
    }

    // convenções de marca: 1 (WEST), 2(SOUTH), 3(EAST), 4(NORTH)
    static final int WEST = 1, SOUTH = 2, EAST = 3, NORTH = 4;

    static void q23() {
        LinkedList<Cell> q = new LinkedList<>();
        q.add(ocean.marlin);
        ocean.setMark(ocean.marlin);
        int flag = 0;
        while (!(q.isEmpty())) {
            Cell v = q.getFirst();
            int aux = 0;
            LinkedList<Cell> u = v.neighbors();
            for (int i = 0; i < u.size(); i++) {
                Cell atual = u.get(i);
                if (ocean.isNemo(atual)){
                    ocean.setMark(ocean.nemo);
                    flag = 1;
                    break;
                }
                if (!ocean.isShark(atual) && !ocean.isWall(atual) && !ocean.isMarked(atual)) {
                    q.addLast(atual);
                    aux = i;
                }
                switch (aux){
                    case 0:
                        ocean.setMark(atual,EAST);
                        break;
                    case 1:
                        ocean.setMark(atual,NORTH);
                        break;
                    case 2:
                        ocean.setMark(atual,WEST);
                        break;
                    case 3:
                        ocean.setMark(atual,SOUTH);
                        break;
                }
            }
            if (flag == 1) break;
            q.removeFirst();
            Traversal.slow();
        }
        alfa = ocean.getMark(ocean.nemo);
    }


    static void backTrack() {
        q22();
        LinkedList<Cell> q = new LinkedList<>();
        q.add(ocean.nemo);
        while (q.getFirst() != ocean.marlin && alfa > ocean.getMark(ocean.marlin)){
            Cell v = q.getFirst();
            LinkedList<Cell> u = v.neighbors();
            for (int i=0;i<u.size();i++){
                Cell atual = u.get(i);
                if (alfa - ocean.getMark(atual) == 1){
                    q.removeFirst();
                    q.addLast(atual);
                    ocean.setMark(atual,pathColor);
                    break;
                }
            }
            alfa--;
            Traversal.slow();
        }
    }


    public static void main(String[] args) {
        q21();
    }

}