package com.awesomedevelop.recyclerview;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * Created by Taras on 30.01.2015.
 */
public class HeroAdapter extends RecyclerView.Adapter<HeroAdapter.MyViewHolder> {

    private ArrayList<HeroData> heroDataSet;
    public Context mContext;
    private int lastPosition = -1;
    public static class MyViewHolder extends RecyclerView.ViewHolder  {
        TextView textName;
        TextView textUniverse;
        ImageView imageHero;

        public MyViewHolder(View itemView){
            super (itemView);
            this.imageHero = (ImageView)itemView.findViewById(R.id.image);
            this.textName = (TextView)itemView.findViewById(R.id.hero_name);
            this.textUniverse = (TextView)itemView.findViewById(R.id.hero_universe);
        }
    }



    public HeroAdapter(Context context, ArrayList<HeroData> heroes){
        this.heroDataSet= heroes;
        mContext=context;
    }


    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent,
                                           int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.hero_card, parent, false);
        MyViewHolder myViewHolder = new MyViewHolder(view);

        return myViewHolder;
    }




    @Override
    public void onBindViewHolder(final MyViewHolder holder, final int listPosition) {

        final TextView textViewName = holder.textName;
        final TextView textViewUniverse = holder.textUniverse;
        ImageView imageViewHero = holder.imageHero;
        textViewName.setText(heroDataSet.get(listPosition).getName());
        textViewUniverse.setText(heroDataSet.get(listPosition).getUniverse());

        String src = heroDataSet.get(listPosition).getImage();
        Picasso.with(mContext)
                .load("file:///android_asset/images/"+src+".jpg")
                .resize(300, 300)
                .into(imageViewHero);
    }

    @Override
    public int getItemCount() {
        return heroDataSet.size();
    }

}

