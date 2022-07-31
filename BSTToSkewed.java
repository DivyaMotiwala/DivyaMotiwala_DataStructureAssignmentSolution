package problemstatement2;

public class BSTToSkewed {
	
	//BST Root Node
	Node node = null;
	
	//Pointer to head node when converting to skewed tree
	Node headNode = null;
	Node prevNode = null;
	
	public static void main(String[] args) {
		
		//Create BST
		
		BSTToSkewed tree = new BSTToSkewed();
		tree.node = new Node(50);
		tree.node.left = new Node(30);
		tree.node.left.left = new Node(10);
		tree.node.right = new Node(60);
		tree.node.right.left = new Node(55);
		
		tree.convertToSkewed(tree.node);
		tree.displayTree();
	}

	private void convertToSkewed(Node root)
	{
		if(root != null)
		{
			convertToSkewed(root.left);
			
			if(headNode == null)
			{
				headNode = root;
				headNode.left = null;
				prevNode = root;
						
			}
			else
			{
				root.left = null;
				prevNode.right = root;
				prevNode = root;
			}
		
			convertToSkewed(root.right);
		}
		
	}
	
	private void displayTree()
	{
		skewedTreeTraverse(headNode);
	}
	
	private void skewedTreeTraverse(Node root)
	{
		if(root != null)
		{
			System.out.printf(root.value + "\t");
			skewedTreeTraverse(root.right);
		}
		
	}
}
