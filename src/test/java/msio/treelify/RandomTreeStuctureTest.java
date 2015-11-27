package msio.treelify;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.junit.Test;

public class RandomTreeStuctureTest {

	static class Project implements Comparable<Project> {

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

		@Override
		public int compareTo(Project o) {
			return Integer.compare(id, o.id);
		}

	}
	
	@Test
	public void test() throws Exception {

		Treelify treelify = new Treelify();

		final int numberOfProjects = 100000;

		List<Project> projectList = new ArrayList<Project>();
		Random random = new Random();
		
		IntStream.rangeClosed(1, numberOfProjects).forEach(i -> {
			
			int parentId = random.nextInt(i);
			projectList.add(new Project(i, parentId));
			
		});
		

		List<TreeNode<Project>> nodes = treelify.toTree(projectList);
		Collection<Project> result = treelify.fromTree(nodes);


		assertThat(result.size(), is(numberOfProjects));
		
		Set<Project> inputSet = projectList.stream().collect(Collectors.toSet());
		Set<Project> outputSet = result.stream().collect(Collectors.toSet());
		assertThat(outputSet, is(inputSet));
		
	}

}
