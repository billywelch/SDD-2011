/*
<<<<<<< HEAD
 /*
=======
>>>>>>> d94100dfb59fd332934e527429c4e3a42d30392a
 * CourseInfoParser
 *
 * Version 0.3
 *
 */

package pro.SDD;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.net.MalformedURLException;
import java.net.URL;

import java.util.ArrayList;

/**
 * 
 * @author Billy Welch
 * 
 */
public class CourseInfoParser {
	ArrayList<String> course = new ArrayList<String>();
	ArrayList<String> courseinfo = new ArrayList<String>();
	ArrayList<String> coursetime = new ArrayList<String>();

	public void readFromWebsite() {
		// read from site
		try {
			// Create a URL for the desired page
<<<<<<< HEAD
			URL url = new URL("http://sdd2011.phpfogapp.com/courseinfo.xml");

			BufferedReader bufferedreader = new BufferedReader(new InputStreamReader(url.openStream()));
			String string;
			while ((string = bufferedreader.readLine()) != null) {
				// append to arraylist
				if(string.indexOf("<title>")>0)
				{
					string = string.replace("<title>","");
					string = string.replace("</title>", "");
					string = string.trim();
					course.add(string);
				}
				if(string.indexOf("<description>")>0)
				{
					string = string.replace("<description>","");
					string = string.replace("</description>","");
					string = string.trim();
					
					courseinfo.add(string);
					
				}
=======
			URL url = new URL("sdd2011.phpfogapp.com/courseinfo.xml");

			BufferedReader bufferedreader = new BufferedReader(new InputStreamReader(url.openStream()));
			String string;

			while ((string = bufferedreader.readLine()) != null) {
				// append to arraylist
				course.add(string);
				courseinfo.add((string = bufferedreader.readLine()));
>>>>>>> d94100dfb59fd332934e527429c4e3a42d30392a
			}

			bufferedreader.close();
		} catch (MalformedURLException e) {
		} catch (IOException e) {
		}
	}

	public ArrayList<String> getcourse() {
		return course;
	}

	public ArrayList<String> getcourseinfo() {
		return courseinfo;
	}
}
