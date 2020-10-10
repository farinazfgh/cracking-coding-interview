package systemdesignscalability;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

/*
Alternatively, I could do what's called a bidirectional breadth-first search. This means doing two breadth
first searches, one from the source and one from the destination. When the searches collide, we know we've
found a path.
BFS
time: E + V
space: V

 */
public class SocialNetworks {
    LinkedList<Person> findPathBYBFS(HashMap<Integer, Person> people, int source, int destination) {
        BFSData sourceData = new BFSData(people.get(source));
        BFSData destData = new BFSData(people.get(destination));

        while (!sourceData.isFinished() && !destData.isFinished()) {
            /* Search out from source. */
            Person collision = searchLevel(people, sourceData, destData);
            if (collision != null) {
                return mergePaths(sourceData, destData, collision.getID());
            }

            /* Search out from destination. */
            collision = searchLevel(people, destData, sourceData);
            if (collision != null) {
                return mergePaths(sourceData, destData, collision.getID());
            }
        }
        return null;
    }

    /* Search one level and return collision, if any. */
    Person searchLevel(HashMap<Integer, Person> people, BFSData primary,
                       BFSData secondary) {
        /* We only want to search one level at a time. Count how many nodes are
         * cu r rently in the primary's level and only do that many nodes. We'll continue
         * to add nodes to the end. */
        int count = primary.toVisit.size();
        for (int i = 0; i < count; i++) {
            /* Pullout first node. */
            Node node = primary.toVisit.poll();
            assert node != null;
            int personld = node.getPerson().getID();

            /* Check if it's already been visited. */
            if (secondary.visited.containsKey(personld)) {
                return node.getPerson();
            }

            /* Add friends to queue. */
            Person person = node.getPerson();
            ArrayList<Integer> friends = person.getFriends();
            for (int friendld : friends) {
                if (!primary.visited.containsKey(friendld)) {
                    Person friend = people.get(friendld);
                    Node next = new Node(friend, node);
                    primary.visited.put(friendld, next);
                    primary.toVisit.add(next);
                }
            }
        }
        return null;
    }

    LinkedList<Person> mergePaths(BFSData bfs1, BFSData bfs2, int connection) {
        Node source = bfs1.visited.get(connection); // end1 -> source
        Node target = bfs2.visited.get(connection); // end2 -> dest
        LinkedList<Person> pathOne = source.collapse(false);
        LinkedList<Person> pathTwo = target.collapse(true); // reverse
        pathTwo.removeFirst(); // remove connection
        pathOne.addAll(pathTwo); // add second path
        return pathOne;
    }
  
    /*
    Merge paths  where searches  met at  connection . */

    static class Person {
        ArrayList<Integer> friends;
        Integer ID;

        public Integer getID() {
            return ID;
        }

        public ArrayList<Integer> getFriends() {
            return friends;
        }

        public void setFriends(ArrayList<Integer> friends) {
            this.friends = friends;
        }
    }

    static class Node {
        private final Person person;
        private final Node previousNode;

        public Node(Person p, Node previous) {
            person = p;
            previousNode = previous;
        }

        public Person getPerson() {
            return person;
        }

        public LinkedList<Person> collapse(boolean startsWithRoot) {
            LinkedList<Person> path = new LinkedList<>();
            Node node = this;
            while (node != null) {
                if (startsWithRoot) {
                    path.addLast(node.person);
                } else {
                    path.addFirst(node.person);
                }
                node = node.previousNode;
            }
            return path;
        }
    }

    static class BFSData {
        public Queue<Node> toVisit = new LinkedList<>();
        public HashMap<Integer, Node> visited = new HashMap<>();

        public BFSData(Person root) {
            Node sourcePath = new Node(root, null);
            toVisit.add(sourcePath);
            visited.put(root.getID(), sourcePath);
        }

        public boolean isFinished() {
            return toVisit.isEmpty();
        }
    }
}
