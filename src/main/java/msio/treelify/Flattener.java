package msio.treelify;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Flattener<T> {

	public Collection<T> flatten(List<TreeNode<T>> nodes) throws Exception {

		Collection<T> result = new ArrayList<T>();

		for (TreeNode<T> node : nodes) {

			result.add(node.getObject());
			result.addAll(flatten(node.getChildren()));

		}

		return result;
	}

}
