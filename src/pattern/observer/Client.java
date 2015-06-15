package pattern.observer;

import java.util.ArrayList;
import java.util.List;


//subject
interface Subject{
	
	void registerListeners(Listener listener);
	//void unregisterListeners();
	String getUpdate();
	void notifyListeners();
	void eventHandler(String newMessage);
}

class MyTopic implements Subject{
	List<Listener> list;
	Object LOCK = new Object();
	String message = null;
	boolean isUpdated = false;
	
	public void registerListeners(Listener listener){
		synchronized(LOCK){
			if(list == null){
				list = new ArrayList<Listener>();
			}
			list.add(listener);
		}
	}
	
	public void notifyListeners(){
		List<Listener> tempList;
		synchronized(LOCK){
			if(!isUpdated){
				return;
			}
			tempList = list;
		}
		for(Listener listener:tempList){
			listener.update();
		}
	}
	
	public String getUpdate(){
		return message;
	}
	
	public void eventHandler(String newMessage){
		this.message = newMessage;
		this.isUpdated = true;
		notifyListeners();
	}
}

abstract class Listener{
	Subject subject;
	public abstract void update();
}

class SubjectListener1 extends Listener{

	SubjectListener1(Subject subject){
		this.subject = subject;
	}
	
	public void update(){
		if(subject.getUpdate() == null) {
			System.out.println("No new message.");
		} else {
			System.out.println("consuming new message: " + subject.getUpdate());
		}
	}
	
	void setSubject(Subject subject){
		this.subject = subject;
	}
}
/*
class SubjectListener2 extends Listener{
	//implementation
}

class SubjectListener3 extends Listener{
	//implementation
}*/

public class Client{
	public static void main(String[] args){
		Subject subject = new MyTopic();
		Listener listener1 = new SubjectListener1(subject);
		/*Listener listener2 = new SubjectListener2(subject);
		Listener listener3 = new SubjectListener3(subject);
		subject.addListeners(listener2);
		subject.addListeners(listener3);
		*/
		
		subject.registerListeners(listener1);
		
		listener1.update();
		
		subject.eventHandler("NEW MESSAGE");
		
	}
}