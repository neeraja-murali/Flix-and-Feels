import java.awt.BorderLayout;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Random;
import java.util.regex.Pattern;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
public class MovieGenre {
	String value;
	public MovieGenre(){
		value=" ";
	}
	public boolean getRandomBoolean() {
	    Random random = new Random();
	    return random.nextBoolean();
	}
	
	public static String getHTML(String urlToRead)throws Exception{
		StringBuilder result=new StringBuilder(); 
		URL url=new URL(urlToRead);
		HttpURLConnection conn=(HttpURLConnection)url.openConnection(); 
		conn.setRequestMethod("GET");
		BufferedReader rd=new BufferedReader(new InputStreamReader(conn.getInputStream()));
		int count=0;
		String line; 
		while (((line=rd.readLine())!=null)&&(count<3)){
			result.append(line);
			count++;
		}
		rd.close(); 
		return result.toString();
	}
	public void printGenre(int[]id){
		for (int n=0;n<id.length;n++){
			String html_id=String.valueOf(id[n]);
			String string=" ";
			try {
				string = (getHTML("http://api.themoviedb.org/3/genre/"+html_id+"/movies?api_key=506a9505acef1b559fc71be929180f37"));
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}			   String[] parts = string.split(Pattern.quote("},"));
			   for (int i=1;i<parts.length;i++){
				   String[] partstwo=parts[i].split(Pattern.quote("\",\""));
				   for (int j=0;j<partstwo.length;j++){
					   if ((j==2)&&(getRandomBoolean())){
						   System.out.println("Here is a movie!\n");
						   System.out.println(partstwo[j]);
						   System.out.println("-------------------------");
						   value=value+"<br>"+partstwo[j]+"<br>";
					   }
				   }
			  }
		}
		String genre=" ";
		String title=" ";
		if (id[0]==53){
			title="You seem calm today!";
			genre="<br>Your genres are: Action,comedy,drama,romance<br>";
		}
		else if (id[0]==28){
			title="You seem happy today!";
			genre="<br>Your genres are: Adventure,sci-fi,family<br>";
		}
		else{
			title="You seem sad/tired today";
			genre="<br>Your genres are: romantic,action,comedy,animated<br>";
		}
		JFrame frame = new JFrame(title);
		JLabel label = new JLabel("My label");
		label.setText("<html>Welcome to Flix and Feels"+genre+value+"Why don't you try these movies?</html>");
		frame.getContentPane().add(label, BorderLayout.PAGE_START);
		frame.setSize(700, 700);
		//JScrollPane pane = new JScrollPane(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		//frame.setContentPane(pane);
		//5. Show it.
		frame.setVisible(true);

	}
}
	

	


