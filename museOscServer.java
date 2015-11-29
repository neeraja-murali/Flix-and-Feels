//package example;

import oscP5.*;
public class MuseOscServer {

	static MuseOscServer museOscServer;
	OscP5 museServer;
	static int recvPort = 5000;
	

	public static void practice() {
			museOscServer = new MuseOscServer();
			museOscServer.museServer = new OscP5(museOscServer, recvPort);
	}
	void oscEvent(OscMessage msg) {
		float [] values=new float[400000];
		int k=0;
		if (msg.checkAddrPattern("/muse/eeg")==true) {  
		for (int j=0;j<100000;j++){
			for(int i = 0; i < 4; i++) {
				values[k]=msg.get(i).floatValue();
				k++;
				//System.out.print("EEG on channel " + i + ": " + msg.get(i).floatValue() + "\n");
			}
		}
			float average=0;
			for (int i=0;i<values.length;i++){
				average=average+values[i];
			}
			average=average/values.length;
			System.out.println("AVERAGE:"+average);
			
			int [] id=new int[5];
			EEGDictionary tree=new EEGDictionary();
			id=tree.getGenreId(average);
			for (int i=0;i<id.length;i++){
				System.out.println("ID: "+id[i]);
			}
			MovieGenre print=new MovieGenre();
			print.printGenre(id);
			
			museOscServer.museServer.stop();
		}
		
	
	}
}
