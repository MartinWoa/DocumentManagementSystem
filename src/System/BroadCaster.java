package System;

import java.util.Vector;

public abstract class BroadCaster {
    
	static Vector<Receiver> receivers=new Vector<Receiver>();
static void regist(Receiver r)
{
	receivers.add(r);
	}
static void remove(Receiver r)
{
	receivers.remove(r);
}

static void broadcast()
{   
	for(Receiver r:receivers)
	{
		r.update();
	}
}
	
}
