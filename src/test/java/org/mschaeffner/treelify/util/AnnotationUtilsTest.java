package org.mschaeffner.treelify.util;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import java.lang.reflect.Field;

import org.junit.Test;
import org.mschaeffner.treelify.TreelifyId;
import org.mschaeffner.treelify.TreelifyParentId;
import org.mschaeffner.treelify.util.AnnotatedFieldNotFoundException;
import org.mschaeffner.treelify.util.AnnotatedFieldNotUniqueException;
import org.mschaeffner.treelify.util.AnnotationUtils;

public class AnnotationUtilsTest {

	@Test
	public void testValidTestEntity() throws Exception {
		Field field = AnnotationUtils.getAnnotatedField(ValidTestEntity.class, TreelifyId.class);
		assertThat(field.getName(), is("id"));
	}

	@Test(expected=AnnotatedFieldNotUniqueException.class)
	public void testInvalidTestEntityWithFieldNotUnique() throws Exception {
		AnnotationUtils.getAnnotatedField(InvalidTestEntityWithFieldNotUnique.class, TreelifyId.class);
	}

	@Test(expected=AnnotatedFieldNotFoundException.class)
	public void testInvalidTestEntityWithFieldNotFound() throws Exception {
		AnnotationUtils.getAnnotatedField(InvalidTestEntityWithFieldNotFound.class, TreelifyId.class);
	}

	private static class ValidTestEntity {

		@TreelifyId
		int id;

		@TreelifyParentId
		int parentId;

	}

	private static class InvalidTestEntityWithFieldNotUnique {

		@TreelifyId
		int id;

		@TreelifyId
		int parentId;

	}

	private static class InvalidTestEntityWithFieldNotFound {

	}

}
