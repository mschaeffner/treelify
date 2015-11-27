package msio.treelify.util;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class AnnotationUtils {

	public static Field getAnnotatedField(Class<?> clazz, Class<? extends Annotation> annotation)
			throws AnnotatedFieldNotFoundException, AnnotatedFieldNotUniqueException {

		List<Field> fields = getAnnotatedFields(clazz, annotation);

		if (fields.isEmpty()) {
			throw new AnnotatedFieldNotFoundException(clazz, annotation);
		}

		if (fields.size() > 1) {
			throw new AnnotatedFieldNotUniqueException(clazz, annotation);
		}

		return fields.get(0);
	}

	private static List<Field> getAnnotatedFields(Class<?> clazz,
			Class<? extends Annotation> annotation) {

		return Stream.of(clazz.getDeclaredFields())
				.filter(f -> f.isAnnotationPresent(annotation))
				.collect(Collectors.toList());

	}

}
