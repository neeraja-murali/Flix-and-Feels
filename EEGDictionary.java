
public class EEGDictionary {
	EEGBinaryTree bstree=new EEGBinaryTree();
	
	public EEGDictionary(){
		bstree=null;
	}
	public int[]getGenreId(float average_EEG){
		int [] genre_id=new int[5];
		String genre=" ";
		if ((average_EEG>700)&&(average_EEG<900)){
			genre="calm";
			genre_id[0]=53;
			genre_id[1]=28;
			genre_id[2]=35;
			genre_id[3]=18; 
			genre_id[4]=10749;
		}
		else if (average_EEG>900){
			genre="happy";
			genre_id[0]=28;
			genre_id[1]=10749;
			genre_id[2]=878;
			genre_id[3]=27; 
			genre_id[4]=10751;
		}
		else if (average_EEG<700){
			genre="sad";
			genre_id[0]=35;
			genre_id[1]=10749;
			genre_id[2]=28;
			genre_id[3]=16; 
			genre_id[4]=10751;
		}
		System.out.println("Genre: "+genre);
		return genre_id;
	}
}
