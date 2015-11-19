package ap.adm.phd.utilities;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Calendar;

/*
 * @author Rounaq Jhunjhunu Wala 2014089
 * @author Ambar Pal 2014012
 */
public class EnrollmentNoGenerator {
	public int seed = 0;
	public EnrollmentNoGenerator() {
		try{
			BufferedReader fi = new BufferedReader(new FileReader("data/enrollCounter.adm"));
			seed = fi.read();
			fi.close();
			
			BufferedWriter fo = new BufferedWriter(new FileWriter("data/enrollCounter.adm"));
			fo.write(seed + 1);
			fo.close();
			
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	public String next(){
		Calendar c = Calendar.getInstance();
		String res = String.valueOf(c.get(Calendar.YEAR));
		res += (String.valueOf(seed + 10000)).substring(1);
		return res;
	}
}
