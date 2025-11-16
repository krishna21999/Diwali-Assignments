import java.util.*;

// ========================= Q1 MyStack ==========================
class MyStack {
    private char[] arr;
    private int top;

    MyStack(int size) {
        arr = new char[size];
        top = -1;
    }

    boolean isEmpty() { return top == -1; }
    boolean isFull() { return top == arr.length - 1; }

    void push(char ch) { if (!isFull()) arr[++top] = ch; }
    char pop() { return isEmpty() ? '\0' : arr[top--]; }

    static boolean isPalindrome(String s) {
        MyStack st = new MyStack(s.length());
        for (char c : s.toCharArray()) st.push(c);

        for (int i = 0; i < s.length(); i++)
            if (s.charAt(i) != st.pop()) return false;

        return true;
    }
}

// ========================= Q2 Replace Array ==========================
class ReplaceArray {
    static void execute() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter n: ");
        int n = sc.nextInt();
        int[] a = new int[n];

        for (int i = 0; i < n; i++) a[i] = sc.nextInt();

        for (int i = 0; i < n; i++) {
            int sum = 0;
            for (int j = 0; j < n; j++)
                if (j != i) sum += a[j];
            a[i] = sum;
        }

        System.out.println("Modified array: " + Arrays.toString(a));
    }
}

// ======================== Q3 Circular Queue ==========================
class CircularQueue {
    int[] q;
    int front = -1, rear = -1, size;

    CircularQueue(int n) { q = new int[n]; size = n; }

    boolean isFull() { return (rear + 1) % size == front; }
    boolean isEmpty() { return front == -1; }

    void add(int x) {
        if (isFull()) {
            System.out.println("Queue full — removing front element: " + remove());
        }
        if (isEmpty()) front = 0;
        rear = (rear + 1) % size;
        q[rear] = x;
    }

    int remove() {
        int val = q[front];
        if (front == rear) front = rear = -1;
        else front = (front + 1) % size;
        return val;
    }

    static void execute() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter queue size: ");
        int n = sc.nextInt();
        CircularQueue cq = new CircularQueue(n);

        System.out.println("Enter numbers (-1 to stop):");
        int x;
        while ((x = sc.nextInt()) != -1) cq.add(x);

        System.out.println("Done.");
    }
}

// ========================= Q4 Sorted Linked List ==========================
class SNode {
    int data; SNode next;
    SNode(int d) { data = d; }
}

class SortedList {
    SNode head;

    void insert(int x) {
        SNode n = new SNode(x);
        if (head == null || x < head.data) {
            n.next = head;
            head = n;
            return;
        }
        SNode t = head;
        while (t.next != null && t.next.data < x) t = t.next;
        n.next = t.next;
        t.next = n;
    }

    void display() {
        SNode t = head;
        while (t != null) { System.out.print(t.data + " "); t = t.next; }
        System.out.println();
    }

    static void execute() {
        Scanner sc = new Scanner(System.in);
        SortedList sl = new SortedList();

        System.out.println("Enter numbers (-1 to stop):");
        int x;
        while ((x = sc.nextInt()) != -1) sl.insert(x);

        System.out.print("Sorted List: ");
        sl.display();
    }
}

// ========================= Q5 Circular Linked List ==========================
class CNode {
    int data; CNode next;
    CNode(int d) { data = d; }
}

class CircularLL {
    CNode head;

    void insertAtHead(int x) {
        CNode n = new CNode(x);
        if (head == null) { head = n; n.next = n; return; }

        CNode t = head;
        while (t.next != head) t = t.next;
        n.next = head;
        t.next = n;
        head = n;
    }

    void insertAtEnd(int x) {
        CNode n = new CNode(x);
        if (head == null) { head = n; n.next = n; return; }

        CNode t = head;
        while (t.next != head) t = t.next;
        t.next = n;
        n.next = head;
    }

    void insertAtPos(int x, int pos) {
        if (pos == 1) { insertAtHead(x); return; }

        CNode t = head;
        for (int i = 1; i < pos - 1 && t.next != head; i++) t = t.next;
        CNode n = new CNode(x);
        n.next = t.next;
        t.next = n;
    }

    static void execute() {
        Scanner sc = new Scanner(System.in);
        CircularLL cl = new CircularLL();

        System.out.println("1) Insert at head");
        System.out.println("2) Insert at end");
        System.out.println("3) Insert at position");
        int ch = sc.nextInt();

        System.out.print("Enter value: ");
        int x = sc.nextInt();

        switch (ch) {
            case 1 -> cl.insertAtHead(x);
            case 2 -> cl.insertAtEnd(x);
            case 3 -> {
                System.out.print("Enter position: ");
                int p = sc.nextInt();
                cl.insertAtPos(x, p);
            }
        }
        System.out.println("Inserted successfully.");
    }
}

// ========================= Q6 Double Linked List ==========================
class DNode {
    int data; DNode next, prev;
    DNode(int d) { data = d; }
}

class DLinkedList {
    DNode head;

    void add(int x) {
        DNode n = new DNode(x);
        if (head == null) { head = n; return; }

        DNode t = head;
        while (t.next != null) t = t.next;
        t.next = n;
        n.prev = t;
    }

    void displayReverseFrom(int pos) {
        DNode t = head;
        for (int i = 1; i < pos && t != null; i++) t = t.next;

        if (t == null) {
            System.out.println("Wrong position!");
            return;
        }

        while (t != null) {
            System.out.print(t.data + " ");
            t = t.prev;
        }
        System.out.println();
    }

    static void execute() {
        Scanner sc = new Scanner(System.in);
        DLinkedList dl = new DLinkedList();

        System.out.println("Enter elements (-1 to stop):");
        int x;
        while ((x = sc.nextInt()) != -1) dl.add(x);

        System.out.print("Enter position to reverse display: ");
        int pos = sc.nextInt();

        dl.displayReverseFrom(pos);
    }
}

// ========================= Q7 Insertion Sort ==========================
class InsertionSort {
    static void execute() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter n: ");
        int n = sc.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) a[i] = sc.nextInt();

        for (int i = 1; i < n; i++) {
            int key = a[i], j = i - 1, shifts = 0;
            while (j >= 0 && a[j] > key) {
                a[j + 1] = a[j];
                j--;
                shifts++;
            }
            a[j + 1] = key;
            System.out.println("Iteration " + i + ": shifted " + shifts);
        }
    }
}

// ========================= Q8 Bubble Sort ==========================
class BubbleSort {
    static void execute() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter n: ");
        int n = sc.nextNextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) a[i] = sc.nextInt();

        for (int i = 0; i < n - 1; i++) {
            int swaps = 0;
            for (int j = 0; j < n - 1 - i; j++) {
                if (a[j] > a[j + 1]) {
                    int t = a[j]; a[j] = a[j + 1]; a[j + 1] = t;
                    swaps++;
                }
            }
            System.out.println("Iteration " + (i + 1) + ": swaps = " + swaps);
        }
    }
}

// ========================= Q9 Binary Tree ==========================
class TNode {
    int data;
    TNode left, right;
    TNode(int d) { data = d; }
}

class BinaryTree {
    TNode root;

    void insert(int x) {
        root = insertRec(root, x);
    }

    TNode insertRec(TNode r, int x) {
        if (r == null) return new TNode(x);
        if (x < r.data) r.left = insertRec(r.left, x);
        else r.right = insertRec(r.right, x);
        return r;
    }

    void inorder(TNode r) {
        if (r == null) return;
        inorder(r.left);
        System.out.print(r.data + " ");
        inorder(r.right);
    }

    boolean search(TNode r, int x) {
        if (r == null) return false;
        if (r.data == x) return true;
        return x < r.data ? search(r.left, x) : search(r.right, x);
    }

    static void execute() {
        Scanner sc = new Scanner(System.in);
        BinaryTree bt = new BinaryTree();

        System.out.println("Enter elements (-1 to stop):");
        int x;
        while ((x = sc.nextInt()) != -1) bt.insert(x);

        System.out.print("Inorder traversal: ");
        bt.inorder(bt.root);

        System.out.print("\nEnter number to search: ");
        int key = sc.nextInt();
        System.out.println(bt.search(bt.root, key) ? "Found" : "Not found");
    }
}

// ========================= Q10 Check BST ==========================
class CheckBST {
    boolean isBST(TNode r) {
        return isBSTUtil(r, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    boolean isBSTUtil(TNode n, int min, int max) {
        if (n == null) return true;
        if (n.data <= min || n.data >= max) return false;
        return isBSTUtil(n.left, min, n.data) &&
               isBSTUtil(n.right, n.data, max);
    }

    static void execute() {
        Scanner sc = new Scanner(System.in);
        BinaryTree bt = new BinaryTree();

        System.out.println("Enter tree elements (-1 to stop):");
        int x;
        while ((x = sc.nextInt()) != -1) bt.insert(x);

        CheckBST c = new CheckBST();
        System.out.println(c.isBST(bt.root) ? "Tree is BST" : "Tree is NOT BST");
    }
}

// ========================= MAIN MENU ==========================
public class DSA_Menu {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n========= DSA MENU =========");
            System.out.println("1. Check Palindrome using MyStack");
            System.out.println("2. Replace array elements (no subtraction)");
            System.out.println("3. Circular Queue");
            System.out.println("4. Sorted Singly Linked List");
            System.out.println("5. Circular Linked List Insert");
            System.out.println("6. Doubly Linked List Reverse from Position");
            System.out.println("7. Insertion Sort (count shifts)");
            System.out.println("8. Bubble Sort (count swaps)");
            System.out.println("9. Binary Tree + Search");
            System.out.println("10. Check if tree is BST");
            System.out.println("0. EXIT");
            System.out.print("Enter choice: ");

            int ch = sc.nextInt();
            switch (ch) {
                case 1 -> {
                    System.out.print("Enter string: ");
                    String s = sc.next();
                    System.out.println(MyStack.isPalindrome(s) ? "Palindrome" : "Not Palindrome");
                }
                case 2 -> ReplaceArray.execute();
                case 3 -> CircularQueue.execute();
                case 4 -> SortedList.execute();
                case 5 -> CircularLL.execute();
                case 6 -> DLinkedList.execute();
                case 7 -> InsertionSort.execute();
                case 8 -> BubbleSort.execute();
                case 9 -> BinaryTree.execute();
                case 10 -> CheckBST.execute();
                case 0 -> { 
                    System.out.println("Exiting...");
                    return; 
                }
                default -> System.out.println("Invalid choice!");
            }
        }
    }
}
