package msio.treelify.classtypes;

import static org.hamcrest.Matchers.hasSize;
import static org.junit.Assert.assertThat;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import msio.treelify.TreeNode;
import msio.treelify.Treelify;

import org.junit.Test;

public class TreelifyTest {

	private Treelify treelify = new Treelify();

	private IAnnotatedItem<?> createItem(Class<?> type) {

		if (type.equals(Integer.class)) {
			return new AnnotatedIntegerItem();
		}

		if (type.equals(Long.class)) {
			return new AnnotatedLongItem();
		}

		if (type.equals(Date.class)) {
			return new AnnotatedDateItem();
		}

		if (type.equals(String.class)) {
			return new AnnotatedStringItem();
		}

		if (type.equals(Enum.class)) {
			return new AnnotatedEnumItem();
		}

		return null;
	}

	@Test
	public void testIntegerItem() throws Exception {
		runInternalTest(Integer.class);
	}

	@Test
	public void testLongItem() throws Exception {
		runInternalTest(Long.class);
	}

	@Test
	public void testDateItem() throws Exception {
		runInternalTest(Date.class);
	}

	@Test
	public void testStringItem() throws Exception {
		runInternalTest(String.class);
	}

	@Test
	public void testEnumItem() throws Exception {
		runInternalTest(Enum.class);
	}

	private <T> void runInternalTest(Class<?> type) throws Exception {

		Collection<IAnnotatedItem<?>> items = new ArrayList<IAnnotatedItem<?>>();

		items.add(createItem(type).withId(1).withParentId(0));
		items.add(createItem(type).withId(2).withParentId(1));
		items.add(createItem(type).withId(3).withParentId(1));
		items.add(createItem(type).withId(4).withParentId(1));
		items.add(createItem(type).withId(5).withParentId(2));
		items.add(createItem(type).withId(6).withParentId(2));
		items.add(createItem(type).withId(7).withParentId(6));
		items.add(createItem(type).withId(8).withParentId(7));
		items.add(createItem(type).withId(9).withParentId(0));
		items.add(createItem(type).withId(10).withParentId(0));

		List<TreeNode<IAnnotatedItem<?>>> result = treelify.toTree(items);

		assertThat(result, hasSize(3));

		TreeNode<IAnnotatedItem<?>> item1 = result.stream()
				.filter(i -> i.getObject().getIntId() == 1)
				.findFirst()
				.get();

		assertThat(item1.getChildren(), hasSize(3));
	}

}
