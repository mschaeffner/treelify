package msio.treelify;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import msio.treelify.util.AnnotationUtils;

public class Builder<T> {

	private final List<TreeNode<T>> rootNodes = new ArrayList<TreeNode<T>>();

	private Map<Object, TreeNode<T>> nodes = new HashMap<Object, TreeNode<T>>();

	public List<TreeNode<T>> build(Collection<T> lines) throws Exception {

		for (T line : lines) {

			// TODO move this outside of loop to get better performance
			Field idField = AnnotationUtils.getAnnotatedField(line.getClass(), TreelifyId.class);
			idField.setAccessible(true);
			final Object lineId = idField.get(line);
			idField.setAccessible(false);
			
			
			Field parentIdField = AnnotationUtils.getAnnotatedField(line.getClass(), TreelifyParentId.class);
			parentIdField.setAccessible(true);
			final Object lineParentId = parentIdField.get(line);
			parentIdField.setAccessible(false);

			
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

		return rootNodes;
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
