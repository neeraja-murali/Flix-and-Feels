
public class EEGBinaryTree {
	private EEGNode root;
	private int nodeCount;
	
	public EEGBinaryTree(){
		this.root = null;
		nodeCount = 0;
	}
	
	public EEG findData(EEG data){
		EEGNode<EEG> newNode = findNode(root, data);
		if(newNode == null){
			return null;
		}
		else return newNode.getEEGData();
	}
	
	private EEGNode<EEG> findNode(EEGNode<EEG> root, EEG data){
		if(root == null){
			return null;
		}
		if(root.getEEGData() == data){
			return root;
		}
		else if(root.getEEGData().getEEGReading() > data.getEEGReading()){
			return findNode(root.getRightNode(), data);
		}
		else return findNode(root.getLeftNode(), data);
	}
	
	public void insertEEGData(EEG data){
		
		EEGNode<EEG> insertNode = new EEGNode<EEG>(data);
		if(root == null){
			root = insertNode;
			nodeCount++;
		}
		else{
			EEGNode<EEG> refRoot = root;
			boolean notInserted = true;
			while(notInserted){
				if(refRoot.getEEGData().getEEGReading() < insertNode.getEEGData().getEEGReading()){
					if(refRoot.getRightNode() == null){
						refRoot.setRightNode(insertNode);
						notInserted = false;
					}
					else{
						refRoot = refRoot.getRightNode();
					}
				}
				else{
					if(refRoot.getLeftNode() == null){
						refRoot.setLeftNode(insertNode);
						notInserted = false;
					}
					else{
						refRoot = refRoot.getLeftNode();
					}
				}
			}
		}
		nodeCount++;
	}
	
	public EEG smallest(){
		return smallestNode(root).getEEGData();
	}
	
	public EEGNode<EEG> smallestNode(EEGNode<EEG> targetNode){
		if(targetNode == null){
			return null;
		}
		else{
			while(targetNode.getLeftNode() != null){
				targetNode = targetNode.getLeftNode();
			}
			return targetNode;
		}
	}
	
	public EEG largest(){
			return largestNode(root).getEEGData();
		
	}
	
	public EEGNode<EEG> largestNode(EEGNode<EEG> targetNode){
		if(targetNode == null){
			return null;
		}
		else{
			while(targetNode.getRightNode() != null){
				targetNode = targetNode.getRightNode();
			}
			return targetNode;
		}
	}
	
	public EEG successor(EEG data){
		if(isLeafNode(root) || findData(data) == null || root.equals(findNode(root, data))){
			return null;
		}
		EEGNode<EEG> targetNode = findNode(root, data);
		EEGNode<EEG> rightTarget = targetNode.getRightNode();
		
		if(rightTarget != null){
			return smallestNode(targetNode.getRightNode()).getEEGData();
		}
		else{
			EEGNode<EEG> parentNode = targetNode.getParent();
			while(parentNode.getRightNode() != null && parentNode.getRightNode().equals(targetNode) && !root.equals(targetNode)){
			
				targetNode = parentNode;
				parentNode = targetNode.getParent();
			}
			if(root.equals(targetNode)){
				return null;
			}
			else{
				return targetNode.getEEGData();
			}
		}
	}
	
	public EEG predecessor(EEG data){
		if(isLeafNode(root) || findData(data) == null || root.equals(findNode(root, data))){
			return null;
		}
		EEGNode<EEG> targetNode = findNode(root, data);
		EEGNode<EEG> leftTarget = targetNode.getLeftNode();
		if(leftTarget != null){
			return smallestNode(targetNode.getLeftNode()).getEEGData();
		}
		else{
			EEGNode<EEG> parentNode = targetNode.getParent();
			while(parentNode.getLeftNode() != null && parentNode.getLeftNode().equals(targetNode) && !root.equals(targetNode)){
			
				targetNode = parentNode;
				parentNode = targetNode.getParent();
			}
			if(root.equals(targetNode)){
				return null;
			}
			else{
				return targetNode.getEEGData();
			}
		}
	}
	
	private boolean isLeafNode(EEGNode<EEG> root){
		if(root.getLeftNode() == null && root.getRightNode() == null){
			return false;
		}
		else{
			return true;
		}
	}
}
