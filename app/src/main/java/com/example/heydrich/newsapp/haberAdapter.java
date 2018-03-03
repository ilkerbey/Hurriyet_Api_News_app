package com.example.heydrich.newsapp;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

/**
 * Created by heydrich on 1.3.2018.
 */

public class haberAdapter extends BaseAdapter {
    private ArrayList<haberModel>haberListe;
    private LayoutInflater layoutInflater;

    public haberAdapter(Activity activity,ArrayList<haberModel> haberListe){
        layoutInflater = (LayoutInflater) activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        this.haberListe=haberListe;
    }


    @Override
    public int getCount() {
        return haberListe.size();
    }

    @Override
    public Object getItem(int i) {
        return haberListe.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        View Satir=layoutInflater.inflate(R.layout.custom_satir,null);
        haberModel habermodel=haberListe.get(i);

        ImageView imageView = Satir.findViewById(R.id.imageView);

        TextView baslikText = Satir.findViewById(R.id.adiText);
        TextView aciklamaText = Satir.findViewById(R.id.aciklamaText);

        baslikText.setText(habermodel.getBaslik());
        aciklamaText.setText(habermodel.getAciklama());

        ArrayList<haberGorsel>haberResim=habermodel.getFiles();
        if(haberResim.size()>0){
            Glide.with(imageView.getContext()).load(haberResim.get(0).getFileUrl()).into(imageView);
        }
        else {
            imageView.setVisibility(View.GONE);
        }

        return Satir;
    }
}
