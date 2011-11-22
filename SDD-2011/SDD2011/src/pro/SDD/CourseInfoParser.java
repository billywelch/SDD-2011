/*
 /*
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
	ArrayList<String> courseTitle = new ArrayList<String>();
	ArrayList<String> courseInfo = new ArrayList<String>();
	ArrayList<String> courseTime = new ArrayList<String>();
	ArrayList<String> courseNumber = new ArrayList<String>();
	ArrayList<String> courseRoom = new ArrayList<String>();
	ArrayList<String> startTime = new ArrayList<String>();
	ArrayList<String> endTime = new ArrayList<String>();
	ArrayList<String> courseInstructor = new ArrayList<String>();
	ArrayList<String> meetingDays = new ArrayList<String>();
	ArrayList<String> temp = new ArrayList<String>();
	
	public void readFromWebsite() {
		// read from site
		try {
			// Create a URL for the desired page
			URL url = new URL("http://sdd2011.phpfogapp.com/courseinfo.xml");

			//open the file and read from it
			BufferedReader bufferedreader = new BufferedReader(new InputStreamReader(url.openStream()));
			String string;
			while ((string = bufferedreader.readLine()) != null) {
				// append to the courseTitle arraylist
				if(string.indexOf("<title>")>0)
				{
					string = string.replace("<title>","");
					string = string.replace("</title>", "");
					string = string.trim();
					courseTitle.add(string);
				}
				// append to the courseDescription arraylist
				if(string.indexOf("<description>")>0)
				{
					string = string.replace("<description>","");
					string = string.replace("</description>","");
					string = string.trim();
					
					courseInfo.add(string);
					
				}
				
				//append to the startTime arraylist
				if(string.indexOf("<begintime>")>0)
				{
					string = string.replace("<begintime>","");
					string = string.replace("</begintime>", "-");
					string = string.trim();
					startTime.add(string);
				}
				
				//append to the courseNumber arraylist
				if(string.indexOf("<number>")>0)
				{
					string = string.replace("<number>","CMSC");
					string = string.replace("</number>", "\t");
					string = string.trim();
					courseNumber.add(string);
				}
				
				//append to the endTime arraylist
				if(string.indexOf("<endtime>")>0)
				{
					string = string.replace("<endtime>","");
					string = string.replace("</endtime>", "\n");
					string = string.trim();
					endTime.add(string);
				}
				
				//append to the instructor arraylist
				if(string.indexOf("<instructor>")>0)
				{
					string = string.replace("<instructor>","");
					string = string.replace("</instructor>", "");
					string = string.trim();
					courseInstructor.add(string);
				}
				
				//append to the meetingDays arraylist
				if(string.indexOf("<days>")>0)
				{
					string = string.replace("<days>"," ");
					string = string.replace("</days>", "");
					string = string.trim();
					meetingDays.add(string);
				}
			}

			bufferedreader.close();
		} catch (MalformedURLException e) {
		} catch (IOException e) {
		}
	}

	public ArrayList<String> getcoursetitle() {
		return courseTitle;
	}

	public ArrayList<String> getcourseinfo() {
		
		//format the data collected from the cloud
		//into an easily displayed arraylist
		for (int k = 0; k < courseTitle.size(); k++) {
			StringBuilder sb = new StringBuilder();
			sb.append("CMSC ");
			sb.append(courseNumber.get(k));
			sb.append("\t");
			sb.append(startTime.get(k));
			sb.append(endTime.get(k));
			sb.append(" ");
			sb.append(meetingDays.get(k));
			sb.append("\n");
			sb.append(courseInstructor.get(k));
			sb.append("\n\n");
			sb.append(courseInfo.get(k));
			temp.add(sb.toString());
		}
		//return formatted arraylist
		return temp;
	}
	
}