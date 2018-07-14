import java.util.HashMap;
import java.util.Map;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import org.junit.Test;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

import static org.junit.Assert.*;

public class Solution {
    
    private static String[] rePath(Map<String, String> previousNodes,
    String startNode, String endNode) {

    List<String> reversePath = new ArrayList<>();
    String currentNode = endNode;

    while (currentNode != null) {
        reversePath.add(currentNode);
        currentNode = previousNodes.get(currentNode);
    }
    Collections.reverse(reversePath);
    return reversePath.toArray(new String[reversePath.size()]);
}

    public static String[] getPath(Map<String, String[]> graph, String startNode, String endNode) {

       if (!graph.containsKey(startNode)) {
        throw new IllegalArgumentException("Start node not present");
    }
    if (!graph.containsKey(endNode)) {
        throw new IllegalArgumentException("End node not present");
    }

    Queue<String> visit = new ArrayDeque<>();
    visit.add(startNode);

    Map<String, String> reach = new HashMap<>();
    reach.put(startNode, null);

    while (!visit.isEmpty()) {
        String currentNode = visit.remove();

        
        if (currentNode.equals(endNode)) {
            return rePath(reach, startNode, endNode);
        }

        for (String neighbor : graph.get(currentNode)) {
            if (!reach.containsKey(neighbor)) {
                visit.add(neighbor);
                reach.put(neighbor, currentNode);
            }
        }
    }
    return null;
}