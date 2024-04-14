
public class MultithreadedSingleton {
 private static MultithreadedSingleton instance = null;
 private MultithreadedSingleton() {
	 
 }
 
 
 public static MultithreadedSingleton getInstance() {
	 //just to check the if condition in multithreaded environment
	 //more number of threads will wait in queue to enter the synchronized block
	 //to reduce that we are using one more if condition before this synchronized block
	 if(instance == null) {
		 //since our method is static, we are providing class level lock, so this block will give access to only one thread
		 synchronized (MultithreadedSingleton.class) {
			if(instance==null) {
				instance = new MultithreadedSingleton();
			}
		}
	 }
	 return instance;
 }
}
