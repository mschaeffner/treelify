package org.mschaeffner.treelify.classtypes;

public interface IAnnotatedItem<T> {

	IAnnotatedItem<T> withId(int id);

	IAnnotatedItem<T> withParentId(int parentId);
	
	T getId();
	
	T getParentId();
	
	int getIntId();
	
	int getIntParentId();

}
