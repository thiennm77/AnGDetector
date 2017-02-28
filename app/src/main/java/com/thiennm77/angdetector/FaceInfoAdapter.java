package com.thiennm77.angdetector;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by nmthi on 28/10/2016.
 */

class ViewHolder
{
    public ImageView face;
    public TextView age;
    public TextView gender;
    public int id;
}

public class FaceInfoAdapter extends ArrayAdapter<FaceInfo> {

    private ArrayList<FaceInfo> faces;
    private Context context;

    public FaceInfoAdapter(Context context, ArrayList<FaceInfo> objects) {
        super(context, R.layout.layout_face_info, objects);

        this.context = context;
        faces = objects;
    }

    @Nullable
    @Override
    public FaceInfo getItem(int position) {
        return faces.get(position);
    }

    public long getItemId(int position)
    {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent)
    {
        ViewHolder holder;
        if (convertView == null)
        {
            LayoutInflater inflater = ((Activity) context).getLayoutInflater();
            convertView = inflater.inflate(R.layout.layout_face_info, parent, false);

            holder = new ViewHolder();
            holder.face = (ImageView) convertView.findViewById(R.id.face);
            holder.age = (TextView) convertView.findViewById(R.id.age);
            holder.gender = (TextView) convertView.findViewById(R.id.gender);

            convertView.setTag(holder);
        }
        else
            holder = (ViewHolder) convertView.getTag();

        holder.age.setId(position);
        holder.gender.setId(position);
        holder.face.setId(position);

        FaceInfo faceInfo = faces.get(position);

        holder.age.setText(new StringBuilder().append("Age: ").append(faceInfo.getAge()).toString());
        holder.gender.setText("Gender: " + faceInfo.getGender());
        holder.face.setImageBitmap(faceInfo.getBitmap());
        holder.id = position;

        return convertView;
    }
}
