
public class EEG {
	private int EEGData;
	private String movieTitle;
	
	public EEG(int newData, String newMovie){
		this.EEGData = newData;
		this.movieTitle = newMovie;
	}
	
	public int getEEGReading(){
		return this.EEGData;
	}
	
	public void setEEGReading(int newEEGData){
		this.EEGData = newEEGData;
	}
	
	public String getMovieTitle(){
		return this.movieTitle;
	}
	
	public void setMovieTitle(String newMovieTitle){
		this.movieTitle = newMovieTitle;
	}
}
