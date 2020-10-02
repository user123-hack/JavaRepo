import java.util.ArrayList;

public class TreeNode<T> {
	T data;
	ArrayList<TreeNode<T>> children;
	
	public TreeNode(T data)
	{
		this.data=data;    //TO STORE DATA IN ITS PROPERTY DATA
		children=new ArrayList<>();   //CREATING A DEFAULT ARRAY OF SIZE ZERO IN ITS PROPERTY CHILDREN
		
	}

}
