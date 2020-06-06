package abi.projectH.skullcandy;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class CaptionedImagesAdapter extends RecyclerView.Adapter<CaptionedImagesAdapter.ViewHolder> {



    ArrayList<StoreModelClass>  storeModelClassArrayList;

    Context context;


    //Define the view to be used for each data item
    public static class ViewHolder extends RecyclerView.ViewHolder
    {


        private CardView cardView;

        //to display cardviews so viewholder contains cardview
        public ViewHolder (CardView v)
        {
            super(v);
            cardView = v;
        }

    }

    public CaptionedImagesAdapter( ArrayList<StoreModelClass>  storeModelClassArrayList)
    {
        this.storeModelClassArrayList = storeModelClassArrayList;


    }

    @Override
    public int getItemCount(){
        //the length of the captions array equals the number of data items in the recycler view
        return storeModelClassArrayList.size();

    }

    @Override  //This method gets called when the recycler iew needs to create a view holder
    public CaptionedImagesAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType)
    {
        // code to instantiate the viewholder
        CardView cv = (CardView) LayoutInflater.from(parent.getContext())
                .inflate(R.layout.card_captioned_image, parent, false);
        return new ViewHolder(cv);
    }

    @Override // the recycler view calls this method when it wants to use(or reuse) a view holder for a new piece of data
    public void onBindViewHolder(ViewHolder holder, int position)
    {

        StoreModelClass objModelClass = storeModelClassArrayList.get(position);

        CardView cardView = holder.cardView;

        ImageView imageView = (ImageView) cardView.findViewById(R.id.info_image);

        imageView.setImageBitmap(objModelClass.getImage());

//        Glide
//                .with(holder.itemView.getContext())
//                .load(objModelClass.getImage())
//                .into(imageView);
////
//        imageView.setImageBitmap(ImageNicer.decodeSampledBitmapFromResource(context.getResources(),
//                objModelClass.getImage(),100,100));


        TextView textView = (TextView) cardView.findViewById(R.id.info_text);

        textView.setText(objModelClass.getName());

        TextView textPriceView = (TextView) cardView.findViewById(R.id.info_price);

        textPriceView.setText(objModelClass.getPrice());

    }




}
