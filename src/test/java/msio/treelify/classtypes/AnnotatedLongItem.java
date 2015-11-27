package msio.treelify.classtypes;

import msio.treelify.TreelifyId;
import msio.treelify.TreelifyParentId;

public class AnnotatedLongItem implements IAnnotatedItem<Long> {

	@TreelifyId
	private Long id;

	@TreelifyParentId
	private Long parentId;

	public AnnotatedLongItem withId(int id) {
		this.id = (id == 0) ? null : new Long(id);
		return this;
	}

	public AnnotatedLongItem withParentId(int parentId) {
		this.parentId = (parentId == 0) ? null : new Long(parentId);
		return this;
	}
	
	public Long getId() {
		return id;
	}
	
	public Long getParentId() {
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
		return "AnnotatedLongItem [id=" + id + ", parentId=" + parentId
				+ "]";
	}
	
}
