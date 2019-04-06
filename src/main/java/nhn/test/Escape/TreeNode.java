package nhn.test.Escape;

import java.util.LinkedList;
import java.util.List;

public class TreeNode<T>{
    private T data;
    private TreeNode<T> parent;
    private List<TreeNode<T>> children;
    
    public T getData(){
        return data;
    }
    
    public TreeNode<T> getParent(){
        return parent;
    }
 
    public TreeNode(T data) {
        this.data = data;
        this.children = new LinkedList<>();
    }
 
    public TreeNode<T> addChild(T child) {
        TreeNode<T> childNode = new TreeNode<T>(child);
        childNode.parent = this;
        this.children.add(childNode);
        return childNode;
    }
    
    public TreeNode<T> searchNode(T child){
        if(this.data == child) return this;
        if(this.children.isEmpty()) return null;
        TreeNode<T> ret;
        for(TreeNode<T> node : this.children){
            if((ret = node.searchNode(child)) != null){
                return ret;
            }
        }
        return null;
    }
        
    public TreeNode<T> removeNode(){
        if(this.parent != null){
            this.parent.children.remove(this);
            return this;
        }
        return null;
    }   
}
    