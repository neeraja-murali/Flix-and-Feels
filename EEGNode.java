
public class EEGNode<EEG>{
	
	private EEG EEGdata;
	//private String movie;
	private EEGNode<EEG> left, right, parent;
	
	public EEGNode(EEG newData){
		this.left = null;
		this.right = null;
		this.parent = null;
		this.EEGdata = newData;
	}
	
	public EEGNode<EEG> getParent(){
		return this.parent;
	}
	
	public void setParent(EEGNode<EEG> parentNode){
		this.parent = parentNode;
	}
	
	public EEGNode<EEG> getRightNode(){
		return this.right;
	}
	
	public void setRightNode(EEGNode<EEG> rightNode){
		this.right = rightNode;
	}
	
	public EEGNode<EEG> getLeftNode(){
		return this.left;
	}
	
	public void setLeftNode(EEGNode<EEG> leftNode){
		this.left = leftNode;
	}
	
	public EEG getEEGData(){
		return this.EEGdata;
	}
	
	public void setEEGData(EEG newEEGData){
		this.EEGdata = newEEGData;
	}

}
