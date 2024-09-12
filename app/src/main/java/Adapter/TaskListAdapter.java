package Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import com.ucb.todolist.R;
import java.util.ArrayList;
import ModelClass.TaskItem;

public class TaskListAdapter extends ArrayAdapter<TaskItem> {
    public TaskListAdapter(Context context, ArrayList<TaskItem> tasks) {
        super(context, 0, tasks);
    }

    // Override the getView method to define how each item in the list will look
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Get the data item for this position
        TaskItem task = getItem(position);

        // Check if an existing view is being reused
        if (convertView == null) {
            // Inflate the custom layout for a list item
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.list_item, parent, false);
        }

        //  populate the data (CheckBox, TextView, ImageView)
        CheckBox checkBox = convertView.findViewById(R.id.checkBox);
        TextView taskText = convertView.findViewById(R.id.taskText);
        ImageView taskImage = convertView.findViewById(R.id.imageView);

        // Populate the data into the template view using the TaskItem object
        if (task != null) {
            checkBox.setChecked(task.isChecked());
            taskText.setText(task.getTaskName());
            taskImage.setImageResource(task.getImageResId());
        }
        // Return the completed view to render on screen
        return convertView;
    }
}
