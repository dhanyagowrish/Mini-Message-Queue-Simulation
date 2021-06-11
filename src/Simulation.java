package messagequeue;

public class Simulation {

    public static void main(String[] args) throws InterruptedException {
    	
    
        final MessageQueue queue = new MessageQueue();
        
        final Topic topic1 = queue.create_topic("t1");
        final Topic topic2 = queue.create_topic("t2");
        
        final Subscriber sub1 = new Subscriber(1,"sub1", 10000);
        final Subscriber sub2 = new Subscriber(2,"sub2", 10000);
        
        queue.add_poll_subscriber(sub1, topic1);
        queue.add_poll_subscriber(sub2, topic2);

        /*final Subscriber sub3 = new Subscriber(3,"sub3", 5000);
        queue.add_subscriber(sub3, topic1); */

        queue.publish("m1",topic1);
        queue.publish("m2",topic1);
        
        queue.poll(sub1, topic1);

        /*queue.publish("m3",topic2);
		
        Thread.sleep(15000);
        queue.publish("m4",topic2);*/
        
        //Thread.sleep(15000);
        queue.publish("m5",topic1);
        queue.publish("m6",topic1);
        queue.publish("m7",topic1);
        queue.publish("m8",topic1);


        //queue.disconnect(sub1,topic1, 0);
        
        queue.poll(sub1, topic1);
        //queue.poll(sub2, topic1);
        
        
        
    }
    
}
