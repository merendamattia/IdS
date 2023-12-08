
```table-of-contents
```
---
# Argomenti principali

## Concorrenza

### Wait & Notify
### Blocking queue
```java
public interface BlockingQueue<T> {
	public T take();
	public void put(T value);
	public void clear();
	public boolean isEmpty();
	public boolean isFull();
	public int remainingCapacity();
	public void print();
}
```
### Locks & Conditions
```java
public interface Condition {
	public void await() throws InterruptedException;
	public void signal();
	public void signalAll();
}
```
```java
public interface Lock {
	public void lock();
	public void unlock();
	public Condition newCondition();
}
```
#### Array blocking queue
```java
public class ArrayBlockingQueue<T> implements BlockingQueue<T> {
	private Object[] queue;
	private int size;
	private int capacity;
	private Lock lock;
	private Condition isNotEmpty;
	private Condition isNotFull;
	
	public ArrayBlockingQueue(int maxCapacity){
		if(maxCapacity > Integer.MAX_VALUE)
			throw new IllegalArgumentException("maxCapacity > Integer.MAX_VALUE");
		if(maxCapacity < 1)
			throw new IllegalArgumentException("maxCapacity < 1");
		this.capacity = maxCapacity;
		this.size = 0;
		this.queue = new Object[maxCapacity];
		this.lock = new ReentrantLock();
		this.isNotEmpty = lock.newCondition();
		this.isNotFull = lock.newCondition();
	}

	@Override
	public T take(){
		lock.lock();
		try {
			while (size == 0)
				isNotEmpty.await();
		} catch (InterruptedException e) {
			new IllegalAccessException("isNotEmpty.await()");
		}
		@SuppressWarnings("unchecked")
		T result = (T) queue[0];
		for(int i = 0; i < size - 1; ++i)
			queue[i] = queue[i + 1];
		queue[size - 1] = null;
		--size;
		isNotFull.signal();
		lock.unlock();
		return result;
	}

	@Override
	public void put(T value) {
		lock.lock();
		try {
			while (size == capacity)
				isNotFull.await();
		} catch (InterruptedException e) {
			new IllegalAccessException("isNotEmpty.await()");
		}
		queue[size] = value;
		++size;
		isNotEmpty.signal();
		lock.unlock();
	}

	@Override
	public void clear() {
		lock.lock();
		for(int i = 0; i < capacity; ++i)
			queue[i] = null;
		size = 0;
		lock.unlock();
	}

	@Override
	public boolean isEmpty() {
		lock.lock();
		boolean result = (size == 0);
		lock.unlock();
		return result;
	}

	@Override
	public boolean isFull() {
		lock.lock();
		boolean result = (size == capacity);
		lock.unlock();
		return result;
	}

	@Override
	public int remainingCapacity() {
		lock.lock();
		int result = capacity - size;
		lock.unlock();
		return result;
	}

	@Override
	public void print() {
		lock.lock();
		System.out.print("[");
		for(int i = 0; i < size; ++i) {
			System.out.print(queue[i]);
			if((i + 1) != size)
				System.out.print(", ");
		}
		System.out.println("]");
		lock.unlock();
	}
}
```
#### Reentrant Lock
### Atomic References
### Thread Pools
### Executors
#### Callable
```java
public interface Callable<T, A> {
	public T call();
	public T call(A arg);
}
```
#### Callbacks
```java
public interface Callback<T> {
	public void onSuccess(T value);
	public default void onFailure(Throwable t) {
		t.printStackTrace();
	}
}
```
#### Futures
```java
public interface Future<T> {
	public T get() throws InterruptedException, Throwable;
	public boolean isDone();
}
```

## Reflection
### Class Object
### Introspection
### Proxy

## SCM

### Todo
## AOP

### Shared
### Logging
### Persistent
### Other

#### Active
#### Remote
#### Relodable

## UML

### Class diagram

## Design Patterns

### Creational
### Todo


---