package org.mschaeffner.treelify;

import java.util.ArrayList;
import java.util.List;

public class TreeNode<T> {

	private T object = null;

	private List<TreeNode<T>> children = new ArrayList<TreeNode<T>>();

	public void setObject(T object) {
		this.object = object;
	}

	public T getObject() {
		return object;
	}
	
	public List<TreeNode<T>> getChildren() {
		return children;
	}

}
