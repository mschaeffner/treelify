package org.mschaeffner.treelify.primitives;

import static org.hamcrest.Matchers.hasSize;
import static org.junit.Assert.assertThat;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.junit.Test;
import org.mschaeffner.treelify.TreeNode;
import org.mschaeffner.treelify.Treelify;

public class TreelifyTest {

	private Treelify treelify = new Treelify();

	@Test
	public void testIntType() throws Exception {
		
		Collection<AnnotatedIntItem> items = new ArrayList<AnnotatedIntItem>();

		items.add(new AnnotatedIntItem().withId(1).withParentId(0));
		items.add(new AnnotatedIntItem().withId(2).withParentId(1));
		items.add(new AnnotatedIntItem().withId(3).withParentId(1));
		items.add(new AnnotatedIntItem().withId(4).withParentId(1));
		items.add(new AnnotatedIntItem().withId(5).withParentId(2));
		items.add(new AnnotatedIntItem().withId(6).withParentId(2));
		items.add(new AnnotatedIntItem().withId(7).withParentId(6));
		items.add(new AnnotatedIntItem().withId(8).withParentId(7));
		items.add(new AnnotatedIntItem().withId(9).withParentId(0));
		items.add(new AnnotatedIntItem().withId(10).withParentId(0));
	
		List<TreeNode<AnnotatedIntItem>> result = treelify.toTree(items);
		
		assertThat(result, hasSize(3));

		TreeNode<AnnotatedIntItem> item1 = result.stream()
				.filter(i -> i.getObject().getId() == 1)
				.findFirst()
				.get();

		assertThat(item1.getChildren(), hasSize(3));
	}

}
