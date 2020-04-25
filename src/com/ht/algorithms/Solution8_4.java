package com.ht.algorithms;

import edu.princeton.cs.algs4.In;
import libs.Stack;

import java.util.ArrayList;

public class Solution8_4 {
    public Iterable<String> powerSet(int[] a) {
        Stack<String> powerSet = new Stack<>();
        calculatePowerSet(a, 0, "", powerSet);
        return powerSet;
    }



    private void calculatePowerSet(int[] a, int pos, String set, Stack<String> powerSets) {
        if(pos == a.length) return;
        powerSets.push(set);
        powerSets.push(set.concat(a[pos] + ""));

        calculatePowerSet(a, pos+1, set.concat(a[pos]+" "), powerSets);
        calculatePowerSet(a, pos+1, set, powerSets);
    }


    public ArrayList<ArrayList<Integer>> getSubsets(ArrayList<Integer> set, int index) {
        ArrayList<ArrayList<Integer>> allsubsets;
        if(set.size() == index) {
            allsubsets = new ArrayList<ArrayList<Integer>>();
            allsubsets.add(new ArrayList<Integer>());
        } else {
            allsubsets = getSubsets(set, index + 1);
            int item = set.get(index);
            ArrayList<ArrayList<Integer>> moresubsets = new ArrayList<ArrayList<Integer>>();
            for (ArrayList<Integer> subset : allsubsets) {
                ArrayList<Integer> newsubset = new ArrayList<Integer>();
                newsubset.addAll(subset);
                newsubset.add(item);
                moresubsets.add(newsubset);
            }
            allsubsets.addAll(moresubsets);
        }
        return allsubsets;
    }

    public static void main() {
        Solution8_4 sol = new Solution8_4();
//        for (String subset: sol.powerSet(new int[] {1,2,3})) {
//            System.out.printf("subset: %s \n", subset);
//        }

        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        list
                .add(2);
        list.add(3);
        list.add(4);
        ArrayList<ArrayList<Integer>> lista = sol.getSubsets(list, 0);
    System.out.println(lista);
    }
}
