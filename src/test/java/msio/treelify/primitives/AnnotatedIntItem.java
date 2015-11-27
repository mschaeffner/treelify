package msio.treelify.primitives;

import msio.treelify.TreelifyId;
import msio.treelify.TreelifyParentId;

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
