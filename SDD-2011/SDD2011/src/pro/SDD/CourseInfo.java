/*
 * CourseInfo
 *
 * Version 0.8
 *
 */

package pro.SDD;

import java.util.ArrayList;

import android.app.AlertDialog;
import android.app.ListActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ContextMenu.ContextMenuInfo;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.AdapterView.OnItemClickListener;

/**
 * 
 * @author Billy Welch
 * 
 */
public class CourseInfo extends ListActivity {
	private TextView debugTv;
	ArrayList<String> courseTitle = new ArrayList<String>();
	ArrayList<String> courseInfo = new ArrayList<String>();

	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		setDebugTv((TextView) this.findViewById(R.id.courses));

		try {
	
			CourseInfoParser courseinfoparser = new CourseInfoParser();
			courseinfoparser.readFromWebsite();
			this.setListAdapter(new ArrayAdapter<String>(this, R.layout.list_item, courseinfoparser.getcoursetitle()));
			
			//get course info and title from courseinfoparser.java
			courseInfo = courseinfoparser.getcourseinfo();
			courseTitle = courseinfoparser.getcoursetitle();
			
			this.setSelection(0);
			final ListView listview = getListView();
			listview.setTextFilterEnabled(true);
			listview.setOnItemClickListener(new OnItemClickListener() {
				// listen for click, pair event and event info (via parser, not present
				// at the moment
				public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
					try {
						for (int k = 0; k < courseTitle.size(); k++) {
						/*	StringBuilder sb = new StringBuilder();
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
							*/
							if (((TextView) view).getText() == courseTitle.get(k)) {
								AlertDialog.Builder adb = new AlertDialog.Builder(CourseInfo.this);
								adb.setTitle(courseTitle.get(k));
								adb.setMessage(courseInfo.get(k));
								adb.setPositiveButton("Ok", null);
								adb.show();
							}
						}

					} catch (Exception exception) {
						exception.printStackTrace();
					}
				}
			});
		} catch (Exception e) {
		}
	}


	public void setDebugTv(TextView debugTv) {
		this.debugTv = debugTv;
	}

	public TextView getDebugTv() {
		return debugTv;
	}

}
