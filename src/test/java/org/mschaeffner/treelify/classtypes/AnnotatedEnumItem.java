package org.mschaeffner.treelify.classtypes;

import org.mschaeffner.treelify.TreelifyId;
import org.mschaeffner.treelify.TreelifyParentId;

public class AnnotatedEnumItem implements IAnnotatedItem<AnnotatedEnumItem.KEY> {

	public enum KEY {
		E1, E2, E3, E4, E5, E6, E7, E8, E9, E10;
	}

	@TreelifyId
	private KEY id;

	@TreelifyParentId
	private KEY parentId;

	public AnnotatedEnumItem withId(int id) {
		this.id = (id == 0) ? null : KEY.valueOf("E" + id);
		return this;
	}

	public AnnotatedEnumItem withParentId(int parentId) {
		this.parentId = (parentId == 0) ? null : KEY.valueOf("E" + parentId);
		return this;
	}

	public KEY getId() {
		return id;
	}

	public KEY getParentId() {
		return parentId;
	}

	@Override
	public int getIntId() {
		return Integer.valueOf(id.name().substring(1)).intValue();
	}

	@Override
	public int getIntParentId() {
		return Integer.valueOf(parentId.name().substring(1)).intValue();
	}

	@Override
	public String toString() {
		return "AnnotatedEnumItem [id=" + id + ", parentId=" + parentId + "]";
	}

}
