package com.example.CustomerDetails.task;

import lombok.extern.slf4j.Slf4j;
import java.util.ArrayList;
import java.util.List;

@Slf4j
public class ProblemExercise {
    private Object mergeLists(List<String> fruitsA, List<String> fruitsB){
        log.info("Input fruits A::"+fruitsA);
        log.info("Input fruits B::"+fruitsB);

        List<String> commonFruits = new ArrayList<>(fruitsA);
        commonFruits.retainAll(fruitsB);

        fruitsA.removeAll(commonFruits);
        fruitsB.removeAll(commonFruits);

        log.info("Extracted from common fruits::"+commonFruits);
        log.info("Extracted Uncommon fruits A::"+fruitsA);
        log.info("Extracted Uncommon fruits B::"+fruitsB);

        List<List<String>> allFruits = new ArrayList<>();
        allFruits.add(commonFruits);
        allFruits.add(fruitsA);
        allFruits.add(fruitsB);

        log.info("Merged Common & UnCommon Fruits::"+allFruits);
        return allFruits;
    }

    public static void main(String[] args) {
        List<String> fruitsA = new ArrayList<>();
        fruitsA.add("lemon");
        fruitsA.add("apple");
        fruitsA.add("orange");
        fruitsA.add("grapes");

        List<String> fruitsB = new ArrayList<>();
        fruitsB.add("lemon");
        fruitsB.add("apple");
        fruitsB.add("watermelon");
        ProblemExercise problemExercise = new ProblemExercise();
        problemExercise.mergeLists(fruitsA,fruitsB);
    }
}


