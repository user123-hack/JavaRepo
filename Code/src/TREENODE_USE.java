import java.util.Queue;
import java.util.Scanner;
import java.util.LinkedList;

class maxnodepair{
	TreeNode<Integer> maxnode;
	int sum;
	public maxnodepair(TreeNode<Integer> maxnode,int sum) {
		this.maxnode=maxnode;
		this.sum= sum;

	}
}

class ans{       //class ans for second maximum problem 
	public TreeNode<Integer> max;  //to store maximum value of a tree
	public TreeNode<Integer> smax;  //to store second maximum value of the tree

}

public class TREENODE_USE {
	public static Scanner s=new Scanner(System.in);

	public static TreeNode<Integer> takeinput()
	{
		System.out.println("Enter root's data:");
		int data= s.nextInt();
		TreeNode<Integer> root = new TreeNode<>(data) ;
		System.out.println("enter no. of children of"+data);
		int numchildren= s.nextInt();
		for(int i=0;i<numchildren;i++)
		{
			TreeNode<Integer> child = takeinput();
			root.children.add(child);

		}
		return root;

	}

	public static int countNoOfNodes(TreeNode<Integer> root)
	{
		int count=1;

		/*for(int i=0; i<root.children.size();i++)       **one method using for loop**
		{
			count+= countNoOfNodes(root.children.get(i));

		}*/

		for(TreeNode<Integer> child: root.children)     // **one using for each loop**
		{
			count+= countNoOfNodes(child);
		}

		return count;
	}

	public static int sumOfnodes(TreeNode<Integer> root)
	{
		int sum=root.data;
		for(TreeNode<Integer> child: root.children)
		{
			sum+= sumOfnodes(child);
		}
		return sum;
	}

	public static TreeNode<Integer> maxOfNodes(TreeNode<Integer> root)
	{
		TreeNode<Integer> max= root;
		for(TreeNode<Integer> child: root.children)
		{   TreeNode<Integer> childmax=maxOfNodes(child);
		if(max.data<childmax.data)
		{
			max=childmax;
		}


		}

		return max;
	}

	public static TreeNode<Integer> takeinputlevelwise()
	{
		Queue<TreeNode<Integer>> pendingnodes =new LinkedList<>();//a queue of type treenode
		System.out.println("enter root's data");
		int data= s.nextInt();
		TreeNode<Integer> root= new TreeNode<>(data);
		pendingnodes.add(root); 
		while(!pendingnodes.isEmpty())
		{
			TreeNode<Integer> node = pendingnodes.remove();
			System.out.println("enter no. of children of"+ node.data);
			int numchildren=s.nextInt();

			for(int i=0;i<numchildren;i++)
			{
				System.out.println("enter the value of "+ i +"th children of"+ node.data);
				int childdata= s.nextInt();
				TreeNode<Integer> child=new TreeNode<Integer>(childdata);
				node.children.add(child);
				pendingnodes.add(child);
			}
		}
		return root;
	}

	public static void printTreeLevelWise1(TreeNode<Integer> root)
	{
		Queue<TreeNode<Integer>> pendingnodes =new LinkedList<>();

		pendingnodes.add(root);
		while(!pendingnodes.isEmpty())
		{
			TreeNode<Integer> node = pendingnodes.remove();
			String str = node.data + ":";
			//10 2 20 30 2 40 50 1 70 0 0 0 0
			for(TreeNode<Integer> child: node.children) {
				str+=child.data +",";
				pendingnodes.add(child);
			}
			String k=",";
			if(str.substring(str.length()-1).equals(k))
			{
				System.out.println(str.substring(0,str.length()-1));
			}

			else
			{
				System.out.println(str);
			}
		}
	}

	public static void nodesAtDepthK(TreeNode<Integer> root,int k)
	{
		if(k==0)
		{
			System.out.print(root.data+" ");
			return ;
		}

		for(int i=0;i<root.children.size();i++)
		{
			nodesAtDepthK(root.children.get(i),k-1);
		}

	}

	public static int countnodesgreaterthanX(TreeNode<Integer> root,int x)
	{
		int count=0;

		for(TreeNode<Integer> child : root.children)
		{
			count+=countnodesgreaterthanX(child, x);

		}

		if(root.data>x)
		{
			return count+1;
		}

		return count;
	}

	public static int countleafnodes(TreeNode<Integer> root)
	{
		int count=0;

		if(root.children.size()==0)
		{
			return 1;
		}


		for(TreeNode<Integer> child:root.children)
		{
			count+= countleafnodes(child);
		}
		return count;
	}

	public static void PrintTreeLEvelWise2(TreeNode<Integer> root)
	{
		Queue<TreeNode<Integer>> pendingnodes=new LinkedList<>();
		pendingnodes.add(root);
		pendingnodes.add(null);

		while(!pendingnodes.isEmpty())
		{
			TreeNode<Integer> node = pendingnodes.remove();
			if(node == null) {
				System.out.println();
				if(!pendingnodes.isEmpty()) {
					pendingnodes.add(null);
				}
			}
			else {
				System.out.print(node.data + " ");
				for(TreeNode<Integer> child : node.children) {
					pendingnodes.add(child);
				}
			}
		}
	}

	public static boolean iftreecontainX(TreeNode<Integer> root , int X)
	{
		if(root.data==X)
		{
			return true;
		}

		else
		{
			for(TreeNode<Integer> child: root.children)
			{
				boolean res=iftreecontainX(child, X);
				if(res==true)
				{
					return true;
				}
			}
		}
		return false;
	}

	public static boolean ifidentical(TreeNode<Integer> root1,TreeNode<Integer> root2)
	{
		if(root1.data!=root2.data)
		{
			return false;
		}
		int numchildren1=root1.children.size();
		int numchildren2=root2.children.size();
		if(numchildren1!=numchildren2)
		{
			return false;
		}
		else
		{
			for(int i=0;i<numchildren1;i++)
			{
				boolean res=ifidentical(root1.children.get(i),root2.children.get(i));
				if(res==false)
				{
					return res;
				}
			}
		}

		return true;

	}

	public static maxnodepair maxSumNode(TreeNode<Integer> root)

	{
		if(root==null)
		{
			return new maxnodepair(null, Integer.MIN_VALUE);
		}
		int sum= root.data;
		int numchildren= root.children.size();


		for(int i=0;i<numchildren;i++)
		{
			sum+=root.children.get(i).data;
		}
		maxnodepair ans= new maxnodepair(root, sum);
		for(int i=0;i<numchildren;i++) {
			maxnodepair x= maxSumNode(root.children.get(i));
			if(x.sum>ans.sum)
			{
				ans=x;
			}

		}

		return ans;
	}	

	public static void replaceNodesWithDepth(TreeNode<Integer> root , int k)
	{
		root.data=k;
		for(TreeNode<Integer> child: root.children) {
			replaceNodesWithDepth(child,k+1);
		}
	}

	public static TreeNode<Integer> nextlargernode(TreeNode<Integer> root, int x,int n)
	{
		TreeNode<Integer> ans=null;

		if(root.data>x && root.data<n)
		{
			n=root.data;
			ans=root;
		}
		for(int i=0;i<root.children.size();i++)
		{
			TreeNode<Integer> ans2=nextlargernode(root.children.get(i), x, n);
			if(ans==null) {
				return ans2;
			}
			if(ans2!=null&&ans2.data<ans.data)
			{
				ans=ans2;
			}

		}
		return ans;
	}

	public static ans secondlargestnode(TreeNode<Integer> root)
	{
		ans p=new ans();
		p.max=root;
		p.smax=null;

		for(TreeNode<Integer> child: root.children)
		{
			ans rec=secondlargestnode(child);

			if(rec.smax==null&&p.smax==null)
			{
				if(rec.max.data>p.max.data) {
					p.smax=p.max;
					p.max=rec.max;
				}
				else if(rec.max.data<p.max.data)
					p.smax=rec.max;
			}
			
			
			else if(p.smax==null)
			{
				if(rec.max.data==p.max.data) {
					p=rec;
				}
				else if(rec.max.data>p.max.data&&rec.smax.data>p.max.data)
					p=rec;
				else if(rec.max.data>p.max.data) {
					p.smax=p.max;
					p.max=rec.max;
				}
				else
					p.smax=rec.max;
			}

			else if(rec.smax==null)
			{
				if(p.max.data>rec.max.data&&p.smax.data<rec.max.data) {
					p.smax=rec.max;
				}
				else if(rec.max.data>p.max.data) {
					p.smax=p.max;
					p.max=rec.max;
				}
				
			}

			else {
				if(rec.max.data>p.max.data&&p.max.data>rec.smax.data) {
					p.smax=p.max;
					p.max=rec.max;
				}

				else if(rec.max.data>p.max.data&&p.max.data<rec.max.data) {
					p=rec;
				}
				else if(p.max.data>rec.max.data&&p.smax.data<rec.max.data) {
					p.smax=rec.max;
				}
			}
		}
		return p;

	}

	public static void main(String[] args) {
		//10 3 20 30 40 2 50 60 0 0 0 0 
		TreeNode<Integer> root = takeinputlevelwise();
		//int k=s.nextInt();
		//printTreeLevelWise1(root);
		//PrintTreeLevelWise2(root);
		//System.out.println(countleafnodes(root));
		// rootsAtDepthK(root, 2);
		//System.out.println(countnodesgreaterthanX(root, 10));
		//System.out.println(iftreecontainX(root, 80));
		//System.out.println(ifidentical(root1, root2));
		//nodesAtDepthK(root, k);
		//System.out.println(maxSumNode(root).maxnode.data);
		//System.out.println(nextlargernode(root,15,Integer.MAX_VALUE).data);
		System.out.println(secondlargestnode(root).smax.data);
	}



}


