import java.util.Stack;
import java.util.ArrayList;
import java.util.Queue;
import java.util.Scanner;
import java.util.LinkedList;


class BalancePair
{
	int height;
	boolean isbalanced;
}
class DiameterPair
{
	int height;
	int diameter;
}

class largestbstpair{
	int min;
	int max;
	boolean isbst;
	int height;
}

public class BinaryTreeUse {

	public static Scanner s=new Scanner(System.in);

	public static BinaryTreeNode<Integer> takeinput()
	{
		Queue<BinaryTreeNode<Integer>> queue =new LinkedList<BinaryTreeNode<Integer>>();
		System.out.println("enter root's data:");
		int data=s.nextInt();
		BinaryTreeNode<Integer> root = new BinaryTreeNode<Integer>(data);
		queue.add(root);
		while(!queue.isEmpty())
		{
			BinaryTreeNode<Integer> node= queue.remove();
			System.out.println("enter left child data for "+ node.data+":");
			int leftchilddata= s.nextInt();
			if(leftchilddata!=-1)
			{
				BinaryTreeNode<Integer> leftchild= new BinaryTreeNode<Integer>(leftchilddata);
				node.left=leftchild;
				queue.add(leftchild);
			}


			System.out.println("enter right child data for "+ node.data+":");
			int rightchilddata= s.nextInt();
			if(rightchilddata!=-1)
			{
				BinaryTreeNode<Integer> rightchild= new BinaryTreeNode<Integer>(rightchilddata);
				node.right=rightchild;
				queue.add(rightchild);
			}
		}
		return root;
	}

	//PREORDER TRAVERSAL: PRINTING FASHION IS - ROOT LEFT_TREE RIGHT_TREE
	public static void preorder(BinaryTreeNode<Integer> root)
	{
		if(root==null)
		{
			return ;
		}

		System.out.print(root.data+" ");
		preorder(root.left);
		preorder(root.right);
	}

	//INORDER TRAVERSAL: PRINTING FASHION IS - LEFT_TREE  ROOT  RIGHT_TREE 
	public static void inorder(BinaryTreeNode<Integer> root)
	{
		if(root==null)
		{
			return ;
		}

		inorder(root.left);
		System.out.print(root.data+" ");
		inorder(root.right);
	}

	//POSTORDER TRAVERSAL: PRINTING FASHION IS - LEFT_TREE  RIGHT_TREE  ROOT
	public static void postorder(BinaryTreeNode<Integer> root)
	{
		if(root==null)
		{
			return;
		}

		postorder(root.left);
		postorder(root.right);
		System.out.print(root.data+" ");
	}

	public static int sumallnodes(BinaryTreeNode<Integer> root)
	{
		if(root==null)
		{
			return 0;
		}
		int sum=root.data;
		sum+=sumallnodes(root.left);
		sum+=sumallnodes(root.right);
		return sum;
	}

	public static int countallnodes(BinaryTreeNode<Integer> root)
	{
		if(root==null)
		{
			return 0;
		}
		int count=1;
		count+=countallnodes(root.left);
		count+=countallnodes(root.right);
		return count;

	}

	public static boolean isPresent(BinaryTreeNode<Integer> root,int x)
	{   if(root==null)
	{
		return false;
	}
	if(root.data==x)
	{
		return true;
	}
	else
	{
		boolean ans=isPresent(root.left, x);
		if(ans==true)
		{
			return true;
		}
		if(ans==false)
		{
			boolean m= isPresent(root.right,x);
			return m;
		}
	}

	return false;

	}
	//LEAF NODE IS A NODE WHICH HAS NO CHILDREN OR ITS LEFT NODE AND RIGHT NODE BOTH ARE NULL
	public static int countleafs(BinaryTreeNode<Integer> root)
	{
		if(root==null)
		{
			return 0;
		}
		else if(root.left==null&& root.right==null)
		{
			return 1;
		}
		else
		{
			int count =0;
			count+= countleafs(root.left);
			count+= countleafs(root.right);
			return count;
		}

	}

	public static void mirror(BinaryTreeNode<Integer> root)
	{
		if(root==null)
		{
			return;
		}

		mirror(root.left);
		mirror(root.right);
		BinaryTreeNode<Integer> temp = root.left;
		root.left=root.right;
		root.right=temp;
	}

	public static int height(BinaryTreeNode<Integer> root)
	{
		if(root==null)
		{
			return 0;
		}

		int leftheight= height(root.left);
		int rightheight=height(root.right);
		return Math.max(leftheight, rightheight)+1;

	}

	public static boolean isbalancedtree(BinaryTreeNode<Integer> root)
	{
		if(root==null)
		{
			return true;
		}

		int left_h= height(root.left);
		int right_h=height(root.right);
		if(Math.abs(left_h-right_h)<=1)
		{
			if(isbalancedtree(root.right)&&isbalancedtree(root.left))
			{
				return true;
			}

			else 
			{
				return false;
			}
		}
		return true;

     }

	public static void removeleaf(BinaryTreeNode<Integer> root)
	{
		if(root==null)
		{
			return ;
		}
		if(root.left==null&&root.right==null)
		{
			root=null;
			return;
		}
		else
			removeleaf(root.left);
			removeleaf(root.right);
	}
	
	public static  BalancePair isbalance2(BinaryTreeNode<Integer> root)
	{
		if(root==null)
		{
			BalancePair pair =new BalancePair();
			pair.height=0;
			pair.isbalanced=true;
			return pair;
		}

		BalancePair leftpair = isbalance2(root.left);
		BalancePair rightpair = isbalance2(root.right);
		BalancePair retval= new BalancePair();
		retval.height= Math.max(leftpair.height, rightpair.height)+1;
		if(Math.abs(leftpair.height-rightpair.height)<=1)
		{
			if(leftpair.isbalanced&& rightpair.isbalanced)
			{
				retval.isbalanced=true;
			}
			else
				retval.isbalanced=false;
		}

		return retval;
	}

	public static int diameter(BinaryTreeNode<Integer> root)//BEKAR CODE (SAME NODE IS VISITED MMULTIPLE TIME)
	{ if(root==null)
	{
		return 0;
	}
	int option1= height(root.left)+height(root.right)+1;
	int option2= height(root.right);
	int option3= height(root.left);
	return Math.max(option1, Math.max(option2,option3));
	}

	public static DiameterPair diameterbetter(BinaryTreeNode<Integer> root)
	{
		if(root==null)
		{
			DiameterPair pair= new DiameterPair();
			pair.height=0;
			pair.diameter=0;
			return pair;
		}

		DiameterPair leftpair = diameterbetter(root.left);
		DiameterPair rightpair= diameterbetter(root.right);
		DiameterPair retval=new DiameterPair();
		retval.height=Math.max(leftpair.height, rightpair.height)+1;
		retval.diameter=Math.max(leftpair.height+rightpair.height+1,Math.max(leftpair.diameter, rightpair.diameter));
		return retval;
	}

	public static BinaryTreeNode<Integer> constructPreIn(int[] pre,int spre,int epre,int[] in,int sIn,int eIn)
	{
		//basecase
		if(spre>epre||sIn>eIn)
		{
			return null;
		}

		int rootelement=pre[spre];
		BinaryTreeNode<Integer> root = new BinaryTreeNode<Integer>(rootelement);
		int rootpos =-1;
		for(int i=sIn;i<=eIn;i++)
		{
			if(in[i]==rootelement)
			{
				rootpos=i;
			}
		}
		int count= rootpos-spre;
		BinaryTreeNode<Integer> leftroot=constructPreIn(pre, spre+1, spre+count, in, sIn, rootpos-1);
		BinaryTreeNode<Integer> rightroot=constructPreIn(pre, spre+count+1, epre, in, rootpos+1, eIn);
		root.left=leftroot;
		root.right=rightroot;
		return root;
	}

	public static int nodesgreaterThanX(BinaryTreeNode<Integer> root, int X)
	{
		int count =0;

		if(root==null)
		{
			return 0;
		}

		int rightcount= nodesgreaterThanX(root.right, X);
		int leftcount=nodesgreaterThanX(root.left, X);
		count+=rightcount+leftcount;
		if(root.data>X)
		{
			count++;
		}
		return count;	
	}

	public static BinaryTreeNode<Integer> maxdatanode(BinaryTreeNode<Integer> root)
	{
		if(root==null)
		{
			return null;
		}

		BinaryTreeNode<Integer> rightmax= maxdatanode(root.right);
		BinaryTreeNode<Integer> leftmax= maxdatanode(root.left);

		if(rightmax!=null&&leftmax!=null)
		{
			if(root.data>rightmax.data&&root.data>leftmax.data)
			{
				return root;
			}
			else if(rightmax.data>root.data&&rightmax.data>leftmax.data)
			{
				return rightmax;
			}
			else
			{
				return leftmax;
			}

		}

		else if(rightmax==null&leftmax!=null)
		{
			if(leftmax.data>root.data)
			{
				return leftmax;
			}
			else
			{
				return root;
			}
		}

		else if(leftmax==null&&rightmax!=null)
		{
			if(rightmax.data>root.data)
			{
				return rightmax;
			}
			else
			{
				return root;
			}
		}

		return root;

	}

	public static void printlevelwise(BinaryTreeNode<Integer> root)
	{
		Queue<BinaryTreeNode<Integer>> q= new LinkedList<>();

		q.add(root);
		while(!q.isEmpty())
		{
			BinaryTreeNode<Integer> node=q.remove();
			String str=node.data+":";
			if(node.left!=null)
			{
				str+="L:"+node.left.data+",";
				q.add(node.left);
			}
			else
			{
				str+="L:-1,";
			}
			if(node.right!=null)
			{
				str+="R:"+node.right.data+",";
				q.add(node.right);
			}
			else
			{
				str+="R:-1,";
			}

			System.out.println(str);

		}


	}

	public static void printlevelwise2(BinaryTreeNode<Integer> root)
	{
		if(root==null) {
			System.out.println();
			return;
		}
		Queue<BinaryTreeNode<Integer>> q=new LinkedList<>();
		q.add(root);
		q.add(null);
		while(!q.isEmpty()) 
		{
			BinaryTreeNode<Integer> node = q.remove();
			if(node==null) {
				System.out.println();
				if(!q.isEmpty())
				{
					q.add(null);
				}
			}
			else 
			{
				System.out.print(node.data+" ");
			    if(node.left!=null)
			    {
				q.add(node.left);
			    }
			    if(node.right!=null)
			    {
			    	q.add(node.right);
			    }
			}
			
		}
		return;
	}

	public static void zigzag(Stack<BinaryTreeNode<Integer>> s1,Stack<BinaryTreeNode<Integer>> s2) {

		if(s1.empty()&&s2.empty()) {
			return ;
		}

		while(!s1.isEmpty())
		{	if(s1.peek()!=null) {
			s2.push(s1.peek().right);
			s2.push(s1.peek().left);
			System.out.print(s1.pop().data+" ");
		}
		else
			s1.pop();
		}
		System.out.println();
		while(!s2.isEmpty())
		{	if(s2.peek()!=null)
		{s1.push(s2.peek().left);
		s1.push(s2.peek().right);
		System.out.print(s2.pop().data+" ");
		}
		else
			s2.pop();
		}
		System.out.println();

		zigzag(s1, s2);
	}
	
	public static void nodesWithoutSiblings(BinaryTreeNode<Integer> root)
	{
		if(root==null)
		{
			return ;
		}
		if(root.right==null&&root.left!=null) 
		{
			System.out.println(root.left.data);

		}
		else if(root.left==null&&root.right!=null)
		{
			System.out.println(root.right.data);
		}
		nodesWithoutSiblings(root.left);
		nodesWithoutSiblings(root.right);

	}
	
	public static ArrayList<LinkedListNode<BinaryTreeNode<Integer>>> LLofeachlevel(BinaryTreeNode<Integer> root)
	{
		if(root==null) 
		{
	    ArrayList<LinkedListNode<BinaryTreeNode<Integer>>> k=new ArrayList<>();
		return k;
		}
		
		Queue<BinaryTreeNode<Integer>> q=new LinkedList<>();
		q.add(root);
		q.add(null);
		LinkedListNode<BinaryTreeNode<Integer>> head= null;
		LinkedListNode<BinaryTreeNode<Integer>> temp= null;
		ArrayList<LinkedListNode<BinaryTreeNode<Integer>>> ans=new ArrayList<>();
		while(!q.isEmpty()) 
		{
			BinaryTreeNode<Integer> node = q.remove();
			
			
			if(node==null) {
				
				ans.add(head);
				head=null;
				temp=null;
				
				if(!q.isEmpty())
				{
					q.add(null);
				}
			}
			else if(node!=null)
			{
			 LinkedListNode<BinaryTreeNode<Integer>> head2=new LinkedListNode<BinaryTreeNode<Integer>>(node);
			    if(node.left!=null)
			    {
				q.add(node.left);
			    }
			    if(node.right!=null)
			    {
			    q.add(node.right);
			    }
				if(head==null) {
					head=head2;
					temp=head2;
					
				}
				else if(head!=null)
				{
					temp.next=head2;
					temp=temp.next;
				}
			   
			
			
		}
		}
		return ans;

		
	}
	
	public static BinaryTreeNode<Integer> removeleafnodes(BinaryTreeNode<Integer> root)
	{
		if(root==null)
		{
			return null;
		}
		if(root.left==null&&root.right==null)
		{
			return null;
		}
		else {
		root.left=	removeleafnodes(root.left);
		root.right=	removeleafnodes(root.right);
		}
		
		return root;
	}
	
	public static int LCAofBinarytree(BinaryTreeNode<Integer> root, int n1, int n2)
	{ //LCA= lowest common ancestor
		//Base case ---if element is not fount return -1
		if(root==null)
		{
			return -1;
		}
		//if root data equals any of the two number ...toh wo khud hi ancestor hoga
		if(root.data==n1||root.data==n2)
		{
			return root.data;
		}
		//otherwise
		int ans1=LCAofBinarytree(root.left, n1, n2);//left subtree ka ancestor mangwaya
		int ans2=LCAofBinarytree(root.right, n1, n2);// right subtree ka ancestor mangwaya
		
		if(ans1==-1)
		{
			return ans2;     //agar ek bhi ans -1 hua toh matlab ek element present ni hai toh 
		}					// dusra ans hi ancestor hoga
							//or agr dono ans1 or ans2 -1 aaye toh mtlab n1 or n2 dono element 
		else if(ans2==-1)	//nhi hai tree mei or -1 return hoga
		{
			return ans1; 
		}
		
		else				 	//agar dono ans1 and asn2 -1 ni aaye toh matlab dono element hai 
		{						//ek left subtree mei or dusra right subtree mei hai or 
			return root.data;	//un dono ka ancestor hoga root khud hence we will return its data
		}
		
		
	}


	public static void duplicate(BinaryTreeNode<Integer> root)
	{
		if(root==null)
		{
			return;
		}
		 BinaryTreeNode<Integer> node= new BinaryTreeNode<Integer>(root.data);
		 BinaryTreeNode<Integer> left= root.left;
		 root.left=node;
		 node.left=left;
		 duplicate(root.left.left);
		 duplicate(root.right);
	}
	
	//*************************************BST*********************************************

 	public static BinaryTreeNode<Integer> SearchInBST(BinaryTreeNode<Integer> root,int n)
	{
		if(root==null)
		{
			return null;
		}

		if(root.data==n)
		{
			return root;
		}
		else if(n<root.data)
		{BinaryTreeNode<Integer> leftsearch=SearchInBST(root.left,n);
		return leftsearch;
		}

		else {
			return SearchInBST(root.right, n);
		}
	}
	
 	//TO DISPLAY THE PATH OF THE ELEMENT K IN BST (IT WILL RETURN A ARRAY LIST OF ELEMENTS WHICH COMES IN THE PATH 
	// STARTING FROM THAT ELEMENT TO ROOT)
	public static ArrayList<Integer> BSTNodePath(BinaryTreeNode<Integer> root, int k)
	{
		if(root==null)
		{
			return null;
		}
		if(root.data==k)
		{
			ArrayList<Integer> path= new ArrayList<Integer>();
			path.add(root.data);
			return path;

		}

		else if(k<root.data)
		{
			ArrayList<Integer> path = BSTNodePath(root.left,k);
			if(path!=null)
			{
				path.add(root.data);
			}
			return path;
		}

		else 
		{
			ArrayList<Integer> path = BSTNodePath(root.right,k);
			if(path!=null)
			{
				path.add(root.data);
			}
			return path;
		}

	}	

	//TO CONSTRUCT BST FROM A GIVEN SORTED ARRAY 
	public static BinaryTreeNode<Integer>  constructBST(int[]arr,int si,int ei)
	// si=strt index, ei=end index
	{
		if(si>ei)
		{
			return null;
		}
		int mid=(si+ei)/2;
		BinaryTreeNode<Integer> root= new BinaryTreeNode<Integer>(arr[mid]);
		root.left=constructBST(arr, si, mid-1);
		root.right= constructBST(arr, mid+1, ei);
		return root;

	}

	//TO CONSTRUCT A SORTED LINKED LIST FROM A BST AND RETURN THAT LINKED LIST
	public static LinkedListNode<Integer> convertBSTtosortedLL(BinaryTreeNode<Integer> root)
	{
		if(root==null)
		{
			return null;
		}
		LinkedListNode<Integer> rootnode= new LinkedListNode<Integer>(root.data);
		LinkedListNode<Integer> head=rootnode;
		LinkedListNode< Integer> lefthead = convertBSTtosortedLL(root.left);
		if(lefthead!=null)
		{
			head=lefthead;
			while(lefthead.next!=null)
			{
				lefthead=lefthead.next;
			}
			lefthead.next=rootnode;
		}

		LinkedListNode<Integer> righthead= convertBSTtosortedLL(root.right);
		rootnode.next=righthead;
		return head;
	}

	public static boolean isBST(BinaryTreeNode<Integer> root, int min, int max)
	{
		if(root==null)
			return true;

		if(root.data>min&&root.data<=max)
		{
			return isBST(root.left,min,root.data-1)&&isBST(root.right,root.data,max);
		}
		else 
		{
			return false;
		}
	}

	public static void nodesinrange(BinaryTreeNode<Integer> root, int k1, int k2)
	{
		if(root==null)
		{
			return ;
		}
		 if(root.data>k1)
			{
				nodesinrange(root.left, k1, k2);
			}
		 if(root.data>=k1&&root.data<=k2) {
				System.out.print(root.data+" ");
		}
		
	    if(root.data<k2)
		{
			nodesinrange(root.right, k1, k2);
		}
		
		 
	}

	public static void bubblesort(int[] arr)
	{for(int r=0;r<arr.length;r++)
	{for(int i=0;i<arr.length-1;i++)
	{if(arr[i]>arr[i+1])
	{ int temp=arr[i];
	arr[i]=arr[i+1];
	arr[i+1]=temp;
	}
	}
	}
	}
	
	static int i=0;
	public static void arrayfromtree(BinaryTreeNode<Integer> root,int[] arr)
	{
    	if(root==null)
		{
			return;
		}
		arr[i++]=root.data;
		arrayfromtree(root.left,arr);
		arrayfromtree(root.right,arr);
	}
	
	public static void pairsumnodes(BinaryTreeNode<Integer> root, int sum)
	{
		int k=countallnodes(root);
		System.out.println(k);
		int[] arr= new int[k];
		arrayfromtree(root,arr);
		bubblesort(arr);
		int i=0;
		int j=arr.length-1;
		while(i<=j)
		{
			if(arr[i]+arr[j]==sum)
			{
				System.out.println(arr[i]+" "+arr[j]);
				i++;j--;
			}
			else if(arr[i]+arr[j]<sum)
				i++;
			else
				j--;
		}
		
		
    }

	public static int replacewithlargernodesum(BinaryTreeNode<Integer> root,int sum)
	{
		if(root==null)
		{
			return 0;
		}
		int righttreesum=replacewithlargernodesum(root.right, sum);
        int temp=root.data;
        root.data+=sum+righttreesum;
        int lefttreesum=replacewithlargernodesum(root.left, root.data);
		return temp+righttreesum+lefttreesum;
		
	}
	
	public static largestbstpair largestBST(BinaryTreeNode<Integer> root)
	{
		largestbstpair a = new largestbstpair();
		if(root==null)
		{
			a.max=Integer.MIN_VALUE;
			a.min=Integer.MAX_VALUE;
			a.isbst=true;
			a.height=0;
			return a;
		}
		
		largestbstpair left=largestBST(root.left);
		largestbstpair right= largestBST(root.right);
		if(left.isbst&&right.isbst)
		{
			if(root.data>left.max&&root.data<right.min)
			{   a.max=right.max;
			    a.min=left.min;
			    if(root.left==null)
			    {
			    	a.min=root.data;
			    }
			    if(root.right==null)
			    {
			    	a.max=root.data;
			    }
				
				a.isbst= true;
				a.height=Math.max(left.height, right.height)+1;
			}
			else
			{
				a.isbst=false;
				a.height=Math.max(left.height, right.height);
				a.max=Math.max(root.data,Math.max(right.max,left.max));
				a.min=Math.min(root.data, Math.min(right.min, left.min));
			}
			
		}
		
		else if(left.isbst||right.isbst)
		{
			a.isbst=false;
			a.height=Math.max(left.height, right.height);
			a.max=Math.max(root.data,Math.max(right.max,left.max));
			a.min=Math.min(root.data, Math.min(right.min, left.min));
		}
		
		return a;
		
	}
	
	public static void roottoleafpathtosumk(BinaryTreeNode<Integer> root, int k,String s)
	{
		if(root==null&&k==0)
		{
			System.out.println(s);
			return;
		}
		
		else if(root==null)
		{
			return;
		}
		
		else if(k==0&&root!=null)
		{
			return;
		}
		
		
	
		if(root.data<=k)
		{
			s+=root.data+" ";
			if(root.data-k==0)
			{
				roottoleafpathtosumk(root.left, k-root.data, s );
			}
			else {
			roottoleafpathtosumk(root.left, k-root.data, s );
			roottoleafpathtosumk(root.right, k-root.data, s );
			}
		}
	}
	
	public static void printnodesatDepthx(BinaryTreeNode<Integer> root, int x)
	{
		if(root==null)
		{
			return;
		}
		else if(x==0)
		{
			System.out.println(root.data);
			return;
		}
		printnodesatDepthx(root.right, x-1);
		printnodesatDepthx(root.left, x-1);
	}
	public static int printnodesatdistanceK(BinaryTreeNode<Integer> root, int k,int ele)
	{
		if(root==null)
		{
			return -1;
		}
		if(root.data==ele)
		{
			printnodesatDepthx(root, k);
			return 0;
		}
		int leftdistance=printnodesatdistanceK(root.left, k, ele);
		if(leftdistance+1==k && leftdistance!=-1)
		{
			System.out.println(root.data);
			return leftdistance+1;
		}
		else if(leftdistance!=-1)
		{
			printnodesatDepthx(root.right, k-leftdistance-2);
			return leftdistance+1;
		}
		else
		{
			int rightdistance=printnodesatdistanceK(root.right, k, ele);
			if(rightdistance==-1)
			{
				return -1;
			}
			else if(rightdistance+1==k)
			{
				System.out.println(root.data);
				return rightdistance+1;
			}
			else {
				printnodesatDepthx(root.left, k-rightdistance-2);
				return rightdistance+1;
			}
		}
	}
	

	
	
	public static void main(String[] args) {

		//INPUT :10 20 30 80 50 60 70 -1 -1 -1 -1 -1 -1 -1 -1
		BinaryTreeNode<Integer> root = takeinput();
		//preorder(root);
		//System.out.println();
		//inorder(root);
		//System.out.println();
		//postorder(root);
		//System.out.println(isPresent(root,90));
		//System.out.println(countleafs(root));
		//System.out.println(nodesgreaterThanX(root, 30));
		//System.out.println(maxdatanode(root).data);
		//printlevelwise(root);
		//Stack<BinaryTreeNode<Integer>> s1=new Stack<>();.......605-608 zigzag code in main body 
		//Stack<BinaryTreeNode<Integer>> s2=new Stack<>();
		//s1.add(root);
		//zigzag(s1,s2);
		//nodesWithoutSiblings(root);
		//printlevelwise2(root);
	
		//-------linked list of each level --------
	/*	ArrayList<LinkedListNode<BinaryTreeNode<Integer>>> output= LLofeachlevel(root);
		for(LinkedListNode<BinaryTreeNode<Integer>> head : output){
			LinkedListNode<BinaryTreeNode<Integer>> temp = head;
			while(temp!= null){
				System.out.print(temp.data.data + " ") ;
				temp = temp.next;
			}
			System.out.println();
		
	}*/
		
		//printlevelwise2(removeleafnodes(root));
		//nodesinrange(root, 6, 10);
		//removeleaf(root);
		//printlevelwise2(root);
		//pairsumnodes(root, 80);
		//System.out.println(largestBST(root).height);
		//String s="";
		//roottoleafpathtosumk(root, 13, s);
		int a=printnodesatdistanceK(root, 1, 3);
	}
}


