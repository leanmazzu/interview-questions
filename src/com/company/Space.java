package com.company;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class Space {

    private static final String TREE = "T";
    private static final String HOUSE = "H";

    private String type;

    private Space up;
    private Space down;
    private Space right;
    private Space left;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Space getUp() {
        return up;
    }

    public void setUp(Space up) {
        this.up = up;
    }

    public Space getDown() {
        return down;
    }

    public void setDown(Space down) {
        this.down = down;
    }

    public Space getRight() {
        return right;
    }

    public void setRight(Space right) {
        this.right = right;
    }

    public Space getLeft() {
        return left;
    }

    public void setLeft(Space left) {
        this.left = left;
    }

    public ArrayList<Space> findAll() {
        ArrayList<Space> result = new ArrayList<>();
        HashSet<Space> visited = new HashSet<>();
        findAll(this, result, visited);
        return result;
    }

    private void findAll(Space node, ArrayList<Space> result, HashSet<Space> visited) {
        if (node == null) {
            return;
        }

        visited.add(node);

        if (TREE.equals(node.type) || HOUSE.equals(node.type)) {
            result.add(node);
        }

        if (!visited.contains(node.up)) {
            findAll(node.up, result, visited);
        }
        if (!visited.contains(node.right)) {
            findAll(node.right, result, visited);
        }
        if (!visited.contains(node.down)) {
            findAll(node.down, result, visited);
        }
        if (!visited.contains(node.left)) {
            findAll(node.left, result, visited);
        }
    }


    @Override
    public String toString() {
        return "Space{" +
                "type='" + type + '\'' +
                '}';
    }

    public static Space constructGraph() {
        Space sp1 = new Space();
        sp1.setType(TREE);
        Space sp2 = new Space();
        Space sp3 = new Space();
        Space sp4 = new Space();
        sp4.setType(HOUSE);
        Space sp5 = new Space();
        Space sp6 = new Space();
        Space sp7 = new Space();
        Space sp8 = new Space();
        Space sp9 = new Space();
        Space sp10 = new Space();
        Space sp11 = new Space();
        sp11.setType(HOUSE);
        Space sp12 = new Space();
        sp12.setType(HOUSE);
        Space sp13 = new Space();
        sp13.setType(TREE);
        Space sp14 = new Space();
        sp14.setType(HOUSE);
        Space sp15 = new Space();

        sp1.setRight(sp2);
        sp1.setDown(sp6);

        sp2.setLeft(sp1);
        sp2.setDown(sp7);
        sp2.setRight(sp3);

        sp3.setLeft(sp2);
        sp3.setDown(sp8);
        sp3.setRight(sp4);

        sp4.setLeft(sp3);
        sp4.setDown(sp9);
        sp5.setRight(sp5);

        sp5.setDown(sp10);
        sp5.setLeft(sp4);

        sp6.setUp(sp1);
        sp6.setRight(sp7);
        sp6.setDown(sp11);

        sp7.setLeft(sp6);
        sp7.setUp(sp2);
        sp7.setDown(sp12);
        sp7.setRight(sp8);

        sp8.setLeft(sp7);
        sp8.setUp(sp3);
        sp8.setDown(sp13);
        sp8.setRight(sp9);

        sp9.setLeft(sp8);
        sp9.setDown(sp14);
        sp9.setRight(sp10);
        sp9.setUp(sp4);

        sp10.setLeft(sp9);
        sp10.setUp(sp5);
        sp10.setDown(sp15);

        sp11.setUp(sp6);
        sp11.setRight(sp12);

        sp12.setLeft(sp11);
        sp12.setRight(sp13);
        sp12.setUp(sp7);

        sp13.setRight(sp14);
        sp13.setLeft(sp12);
        sp13.setUp(sp8);

        sp14.setLeft(sp13);
        sp14.setRight(sp15);
        sp14.setUp(sp9);

        sp15.setLeft(sp14);
        sp15.setUp(sp10);

        return sp7;
    }
}
