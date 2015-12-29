package org.mschaeffner.treelify.classtypes;

import org.mschaeffner.treelify.TreelifyId;
import org.mschaeffner.treelify.TreelifyParentId;

public class AnnotatedIntegerItem implements IAnnotatedItem<Integer> {

	@TreelifyId
	private Integer id;

	@TreelifyParentId
	private Integer parentId;

	public AnnotatedIntegerItem withId(int id) {
		this.id = id;
		return this;
	}

	public AnnotatedIntegerItem withParentId(int parentId) {
		this.parentId = parentId;
		return this;
	}
	
	public Integer getId() {
		return id;
	}
	
	public Integer getParentId() {
		return parentId;
	}

	@Override
	public int getIntId() {
		return id.intValue();
	}
	
	@Override
	public int getIntParentId() {
		return parentId.intValue();
	}

	@Override
	public String toString() {
		return "AnnotatedIntegerItem [id=" + id + ", parentId=" + parentId
				+ "]";
	}
	
}
