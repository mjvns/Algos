import java.util.Scanner;
public class BST{
	BSTNode root = null;
	public static void main(String args[]) {
		Scanner scan = new Scanner(System.in);
		BST obj = new BST();
		System.out.println("Welcome to BST Demo:");
		while(true) {
			System.out.println("Press 1 to insert value");
			System.out.println("Press 2 to delete value");
			System.out.println("Press 3 to search value");
			System.out.println("Press 4 for inorder traversal");
			int choice = scan.nextInt();
		switch(choice) {
		case 1: System.out.println("Enter the value to be inserted:");
				int x = scan.nextInt();
				obj.insert(x);
				break;
		case 2: break;
		case 3: break;
		case 4: System.out.println("Inorder traversal gives: ");
				obj.inorder(obj.root);
				break;
		default: System.exit(0);
		}
		}
	}
	
	private void insert(int data) {
		BSTNode current = root;
		BSTNode parent = root;
		if(root == null) {
			root = new BSTNode(data);
			System.out.println("Insertion successful!");
			System.out.println("Root node has been created");
		}else {
			while(current!=null) {
				parent = current;
				if(data<=current.data) {
					current = current.leftchild;
				}else {
					current = current.rightchild;
				}
			}
			if(parent.data<data) {
				parent.rightchild = new BSTNode(data);
			}else {
				parent.leftchild = new BSTNode(data);
			}
		}
	}
	
	private void inorder(BSTNode node) {
		if(node == null) {
			return;
		}else {
			System.out.print(node.data+" ");
			inorder(node.leftchild);
			inorder(node.rightchild);
		}
	}
}
