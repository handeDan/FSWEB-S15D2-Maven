package org.example;

import org.example.entity.Priority;
import org.example.entity.Status;
import org.example.entity.Task;
import org.example.entity.TaskData;

import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        Task task1 = new Task("PROJECT-1", "description-1","ann", Status.IN_QUEUE, Priority.MED);
        Set<Task> annsTasks = new HashSet<>();
        annsTasks.add(task1);

        Task task2 = new Task("PROJECT-2", "description-2","bob", Status.IN_PROGRESS, Priority.LOW);
        Set<Task> bobsTasks = new HashSet<>();
        bobsTasks.add(task2);

        Task task3 = new Task("PROJECT-3", "description-3","CAROL", Status.ASSIGNED, Priority.HIGH);
        Set<Task> carolsTasks = new HashSet<>();
        carolsTasks.add(task3);

        Set<Task> unassignedTasks = new HashSet<>();

        TaskData taskData = new TaskData(annsTasks, bobsTasks, carolsTasks, unassignedTasks);

        //getTasks methods:
        System.out.println("Ann's Tasks: " + taskData.getTasks("Ann"));
        System.out.println("Bob's Tasks: " + taskData.getTasks("Bob"));
        System.out.println("Carol's Tasks: " + taskData.getTasks("Carol"));
        System.out.println("All Tasks: " + taskData.getTasks("All"));
        System.out.println("Non-Existing User's Tasks: " + taskData.getTasks("Dave"));

        //union, intersection and difference methods:
        Set<Task> set1 = new HashSet<>();
        set1.add(task1);
        set1.add(task2);

        Set<Task> set2 = new HashSet<>();
        set2.add(task2);
        set2.add(task3);

        Set<Task> set3 = new HashSet<>();
        set3.add(task1);
        set3.add(task2);
        set3.add(task3);

        // Union Test
        Set<Task> unionResult1 = taskData.getUnion(set1, set2);
        System.out.println("Union of Set1 and Set2: " + unionResult1);

        Set<Task> unionResult2 = taskData.getUnion(set2, set3);
        System.out.println("Union of Set1, Set2 and Set3: " + unionResult2);

        // Intersection Test
        Set<Task> intersectionResult1 = taskData.getIntersection(set1, set2);
        System.out.println("Intersection of Set1 and Set2: " + intersectionResult1);

        Set<Task> intersectionResult2 = taskData.getIntersection(set2, set3);
        System.out.println("Intersection of Set2 and Set3: " + intersectionResult2);

        // Difference Test
        Set<Task> differenceResult1 = taskData.getDifferences(set1, set2);
        System.out.println("Difference between Set1 and Set2: " + differenceResult1);

        Set<Task> differenceResult2 = taskData.getDifferences(set2, set3);
        System.out.println("Difference between Set2 and Set3: " + differenceResult2);

        Set<Task> differenceResult3 = taskData.getDifferences(set3, set2);
        System.out.println("Difference between Set3 and Set2: " + differenceResult3);
    }
}