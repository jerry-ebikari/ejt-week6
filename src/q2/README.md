# Question 2

#### Define a class that contains the following generic static methods for working with predicate objects. The name of the class should be Predicates, in analogy with the standard class Collections that provides various static methods for working with collections.

- public static <T> void remove(Collection<T> coll, Predicate<T> pred): Removes every object, obj, from coll for which pred.test(obj) is true.
- public static <T> void retain(Collection<T> coll, Predicate<T> pred): Removes every object, obj, from coll for which pred.test(obj) is false (that is, retain the objects for which the predicate is true)
- public static <T> List<T> collect(Collection<T> coll, Predicate<T> pred): Returns a List that contains all the objects, obj, from the collection, coll, such that pred.test(obj) is true.
- public static <T> int find(ArrayList<T> list, Predicate<T> pred): Return the index of the first item in list for which the predicate is true, if any. If there is no such item, return -1.