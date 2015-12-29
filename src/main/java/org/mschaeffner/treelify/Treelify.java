package org.mschaeffner.treelify;

import java.util.Collection;
import java.util.List;

public class Treelify {

	public <T> Collection<T> fromTree(List<TreeNode<T>> tree) throws Exception {
		Flattener<T> flattener = new Flattener<T>();
		return flattener.flatten(tree);
	}

	public <T> List<TreeNode<T>> toTree(Collection<T> collection)
			throws Exception {
		Builder<T> builder = new Builder<T>();
		return builder.build(collection);
	}

}
