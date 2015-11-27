package msio.treelify.classtypes;

import java.util.Date;

import msio.treelify.TreelifyId;
import msio.treelify.TreelifyParentId;

public class AnnotatedDateItem implements IAnnotatedItem<Date> {

	@TreelifyId
	private Date id;

	@TreelifyParentId
	private Date parentId;

	public AnnotatedDateItem withId(int id) {
		this.id = (id == 0) ? null : new Date(id);
		return this;
	}

	public AnnotatedDateItem withParentId(int parentId) {
		this.parentId = (parentId == 0) ? null : new Date(parentId);
		return this;
	}
	
	public Date getId() {
		return id;
	}
	
	public Date getParentId() {
		return parentId;
	}

	@Override
	public int getIntId() {
		return (int)id.getTime();
	}
	
	@Override
	public int getIntParentId() {
		return (int)parentId.getTime();
	}

	@Override
	public String toString() {
		return "AnnotatedDateItem [id=" + id + ", parentId=" + parentId
				+ "]";
	}
	
}
