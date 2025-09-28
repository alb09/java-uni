import java.util.Random;

// Node class
class Node {
    int item;
    Node left, right;

    public Node(int key) {
        item = key;
        left = right = null;
    }
}




// BinaryTree class with traversal methods
class BinaryTree {
    Node root;

    BinaryTree() {
        root = null;
    }
    
    Random random = new Random();


    void printTree(Node node, String prefix, boolean isLeft) {
        if (node == null) {
            return;
        }
        if (node.right != null) {
            printTree(node.right, prefix + (isLeft ? "│   " : "    "), false);
        }
        System.out.println(prefix + (isLeft ? "└── " : "┌── ") + node.item);
        if (node.left != null) {
            printTree(node.left, prefix + (isLeft ? "    " : "│   "), true);
        }
    }

    Node generateRandomTree(int currentLevel, int maxLevel) {
        if (currentLevel > maxLevel) {
            return null;
        }
        // Generate a random value for the node
        int value = random.nextInt(100);
        Node newNode = new Node(value);

        // Recursively generate left and right child nodes for next level
        newNode.left = generateRandomTree(currentLevel + 1, maxLevel);
        newNode.right = generateRandomTree(currentLevel + 1, maxLevel);

        return newNode;
    }


    void inorder(Node node) {
        if (node == null)
            return;
        inorder(node.left);
        System.out.print(node.item + " ");
        inorder(node.right);
    }

    void preorder(Node node) {
        if (node == null)
            return;
        System.out.print(node.item + " ");
        preorder(node.left);
        preorder(node.right);
    }

    void postorder(Node node) {
        if (node == null)
            return;
        postorder(node.left);
        postorder(node.right);
        System.out.print(node.item + " ");
    }

    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();

        tree.root = new Node(1);
        tree.root.left = new Node(12);
        tree.root.right = new Node(9);

        tree.root.left.left = new Node(5);
        tree.root.left.right = new Node(6);

	tree.root.right.left = new Node(8);
	tree.root.right.right = new Node(10);


	// tree.printTree(tree.root, "", true);
	// System.out.println("\n");

        // System.out.println("Inorder traversal:");
        // tree.inorder(tree.root);
        // System.out.println("\nPreorder traversal:");
        // tree.preorder(tree.root);
        // System.out.println("\nPostorder traversal:");
        // tree.postorder(tree.root);
	

	System.out.println("\n");
	BinaryTree randomTree = new BinaryTree();

	// Generate a random tree with 3 levels
        randomTree.root = randomTree.generateRandomTree(1, 3);

        System.out.println("Graphic representation of the random tree:");
        randomTree.printTree(randomTree.root, "", true);
	
	
	System.out.println("\n");
	
	System.out.println("Inorder traversal:");
        randomTree.inorder(randomTree.root);
        System.out.println("\nPreorder traversal:");
        randomTree.preorder(randomTree.root);
        System.out.println("\nPostorder traversal:");
        randomTree.postorder(randomTree.root);
	
	System.out.println("\n");

    }
}

