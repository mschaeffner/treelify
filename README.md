# treelify

[![Build Status](https://travis-ci.org/mschaeffner/treelify.svg?branch=master)](https://travis-ci.org/mschaeffner/treelify)

Treelify is a Java library that can be used to convert Java Collections into a tree structure representation. It can also be used to convert a tree structure back to an equivalent Java Collection.

*Usage*

```
Treelify treelify = new Treelify();
List<T> myList = new ArrayList<T>();
List<TreeNode<T>> nodes = treelify.toTree(myList);
Collection<T> result = treelify.fromTree(nodes);
```



*License*

Treelify is released under the [Apache 2.0 license](LICENSE).

```
Copyright 2015 Mathias Schaeffner

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

    http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
```
