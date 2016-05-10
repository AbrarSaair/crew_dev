1. What is the major difference between an abstract class and an interface?

Abstract class can have method implementations but methods in interface are implicitly abstract.
Variables in interface are by default final but abstract class can have non final data members

2. Why is Java 7’s class inheritance flawed?

  I don't know

3. What are the major differences between Activities and Fragments?

Fragments are reusable components which have similar life cycle as of an activity.
Fragments are not stand alone components and are added in some activity
Multiple fragments can be added in an activity but Activity can not be added in an activity

4. When using Fragments, how do you communicate back to their hosting Activity?

There are multiple ways to communicate from fragment to activity. Android's recommended method is to use interface. To achieve this functionality Activity containing fragment implements the interface and contained fragment has an instance of that interface. when data is needed to be sent to activity interface method is called from fragment and required data is passed in it.

5. Can you make an entire app without ever using Fragments? Why or why not? Are there any special cases when you absolutely have to use or should use Fragments?

Yes. we can build complete app without using any fragment. there is no dependency of application with fragments. To make app robust and reuse components across different screen, we can use fragment. like using same list view across different screens.
  
6. What makes an AsyncTask such an annoyance to Android developers? Detail some of the issues with AsyncTask, and how to potentially solve them.

issues with asyncTask includes

AsyncTask is implicitly linked to the enclosing Activity. AsyncTask have methods which can run on UI thread and methods which   run on worker threads and it keeps reference to calling activity. Therefore if activity is destroyed AsyncTask would keep invalid reference of and might crash.

If we cancel the asyncTask even then it will keep on running and completes its "doInBackground" but don't call the "onPostExecute". Its "onCancel" method takes boolean pram to interrupt the on going thread. Therefore if we have hit a network api. it will be send data to server event we think asyncTask it canceled.

There are few changes in the the execution of asyncTask in different android api's therefore it is difficult to manage for different api's
