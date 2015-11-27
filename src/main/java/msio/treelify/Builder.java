package msio.treelify;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import msio.treelify.util.AnnotationUtils;

public class Builder<T> {

	private final List<TreeNode<T>> rootNodes = new ArrayList<TreeNode<T>>();

	private Map<Object, TreeNode<T>> nodes = new HashMap<Object, TreeNode<T>>();

	public List<TreeNode<T>> build(Collection<T> lines) throws Exception {

		Iterator<T> it = lines.iterator();
		if(it.hasNext()) {
			
			Class<?> clazz = it.next().getClass();
			
			Field idField = getIdField(clazz);
			Field parentIdField = getParentIdField(clazz);

			idField.setAccessible(true);
			parentIdField.setAccessible(true);
	
			
			for (T line : lines) {
	
				final Object lineId = idField.get(line);
				final Object lineParentId = parentIdField.get(line);
	
				
				TreeNode<T> curNode = nodes.get(lineId);
				if (curNode == null) {
					TreeNode<T> newNode = new TreeNode<T>();
					newNode.setObject(line);
					nodes.put(lineId, newNode);
					curNode = newNode;
				} else {
					curNode.setObject(line);
				}
	
				if (isAbsent(lineParentId)) {
					rootNodes.add(curNode);
				} else {
					TreeNode<T> parentNode = nodes.get(lineParentId);
					if (parentNode == null) {
						parentNode = new TreeNode<T>();
						nodes.put(lineParentId, parentNode);
					}
					parentNode.getChildren().add(curNode);
				}
	
			}
	
			
			idField.setAccessible(false);
			parentIdField.setAccessible(false);

		
		}

		
		return rootNodes;
	}
	
	private Field getIdField(Class<?> clazz) throws Exception {
		return AnnotationUtils.getAnnotatedField(clazz, TreelifyId.class);
	}

	private Field getParentIdField(Class<?> clazz) throws Exception {
		return AnnotationUtils.getAnnotatedField(clazz, TreelifyParentId.class);
	}
	
	private boolean isAbsent(Object o) {
		// FIXME check for user defined "absent value"

		if (o == null) {
			return true;
		} else if (o instanceof Number && o.equals(0)) {
			return true;
		} else {
			return false;
		}
		
	}

}
