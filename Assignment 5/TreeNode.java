public class TreeNode<T> 
{
	private T data;
	protected TreeNode<T> right, left;
	
	public TreeNode(T dataNode) 
	{
		this.data = dataNode;
		right = left = null;
	}
	
	public TreeNode(TreeNode<T> node) 
	{
		this.data = node.data;
		left = node.left;
		right = node.right;
	}
	

	public T getData() 
	{
		return this.data;
	}
}
