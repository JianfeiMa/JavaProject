package com.jianfei.objectsense;

import java.util.LinkedList;

/**
 * author: JianfeiMa
 * email: majianfei93@163.com
 * created date: 2019-10-14 12:55
 * add, subtract, multiply, divide
 */
public class TestObjectSense {
    private LinkedList<String> selfHelpSpotLinkedList;

    public TestObjectSense(LinkedList<String> selfHelpSpotLinkedList) {
        this.selfHelpSpotLinkedList = selfHelpSpotLinkedList;
    }

    public void addSelfHelpSpot(String selfHelpSpot) {
        selfHelpSpotLinkedList.add(selfHelpSpot);
        for (int i = 0; i < selfHelpSpotLinkedList.size(); selfHelpSpotLinkedList.size()) {
            System.out.println("增加之后遍历->" + selfHelpSpotLinkedList.get(i));
        }
    }

    public void subtract(String selfHelpSpot) {
        selfHelpSpotLinkedList.remove(selfHelpSpot);
    }
}
