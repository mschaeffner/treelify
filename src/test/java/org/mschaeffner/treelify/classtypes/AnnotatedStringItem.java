package org.mschaeffner.treelify.classtypes;

import org.mschaeffner.treelify.TreelifyId;
import org.mschaeffner.treelify.TreelifyParentId;

public class AnnotatedStringItem implements IAnnotatedItem<String> {

	@TreelifyId
	private String id;

	@TreelifyParentId
	private String parentId;

	public AnnotatedStringItem withId(int id) {
		this.id = (id == 0) ? null : ""+ id;
		return this;
	}

	public AnnotatedStringItem withParentId(int parentId) {
		this.parentId = (parentId == 0) ? null : ""+ parentId;
		return this;
	}
	
	public String getId() {
		return id;
	}
	
	public String getParentId() {
		return parentId;
	}

	@Override
	public int getIntId() {
		return Integer.valueOf(id).intValue();
	}

	@Override
	public int getIntParentId() {
		return Integer.valueOf(parentId).intValue();
	}

	@Override
	public String toString() {
		return "AnnotatedStringItem [id=" + id + ", parentId=" + parentId + "]";
	}
	
}
