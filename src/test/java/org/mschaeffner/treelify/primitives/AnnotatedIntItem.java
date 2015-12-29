package org.mschaeffner.treelify.primitives;

import org.mschaeffner.treelify.TreelifyId;
import org.mschaeffner.treelify.TreelifyParentId;

public class AnnotatedIntItem {

	@TreelifyId
	private int id;

	@TreelifyParentId
	private int parentId;

	public AnnotatedIntItem withId(int id) {
		this.id = id;
		return this;
	}

	public AnnotatedIntItem withParentId(int parentId) {
		this.parentId = parentId;
		return this;
	}
	
	public int getId() {
		return id;
	}
	
	public int getParentId() {
		return parentId;
	}

}
