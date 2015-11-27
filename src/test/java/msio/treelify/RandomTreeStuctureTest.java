package msio.treelify;

import static org.hamcrest.Matchers.hasItem;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;

import msio.treelify.TreeNode;
import msio.treelify.Treelify;
import msio.treelify.TreelifyId;
import msio.treelify.TreelifyParentId;

import org.junit.Test;

public class RandomTreeStuctureTest {

	static class Project {

		@TreelifyId
		private final int id;
		
		@TreelifyParentId
		private final int parentId;
		
		public Project(int id, int parentId) {
			this.id = id;
			this.parentId = parentId;
		}
		
		public int getId() {
			return id;
		}
		
		public int getParentId() {
			return parentId;
		}

	}
	
	@Test
	public void test() throws Exception {

		final int numberOfProjects = 10000;

		Collection<Project> projectList = new ArrayList<Project>();

		
		IntStream.rangeClosed(1, numberOfProjects).forEach(i -> {
			
			int parentId = new Random().nextInt(i);
			projectList.add(new Project(i, parentId));
			
		});
		

		Treelify treelify = new Treelify();
		List<TreeNode<Project>> nodes = treelify.toTree(projectList);
		Collection<Project> result = treelify.fromTree(nodes);

		
		assertThat(result.size(), is(numberOfProjects));
		projectList.forEach(p -> assertThat(result, hasItem(p)));

	}

}
