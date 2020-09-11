package com.examplecompany.ebook;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.examplecompany.ebook.R;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;

public class myAdapter extends FirebaseRecyclerAdapter<com.examplecompany.ebook.Book, myAdapter.myViewHolder> {


    /**
     * Initialize a {@link RecyclerView.Adapter} that listens to a Firebase query. See
     * {@link FirebaseRecyclerOptions} for configuration options.
     *
     * @param options
     */
    public myAdapter(@NonNull FirebaseRecyclerOptions<com.examplecompany.ebook.Book> options) {
        super(options);
    }

    @Override
    protected void onBindViewHolder(@NonNull final myViewHolder holder, int position, @NonNull final com.examplecompany.ebook.Book model) {

        holder.header.setText(model.getFilename());

        holder.header.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(holder.header.getContext(), com.examplecompany.ebook.viewpdf.class);
                //if your filename and fileurl content holder is not named 'filename' and 'fileurl' then change the below name to exactly what it is named
                intent.putExtra("filename", model.getFilename());
                intent.putExtra("fileurl", model.getFileurl());

                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                holder.header.getContext().startActivity(intent);
            }
        });
    }

    @NonNull
    @Override
    public myViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item, parent, false);
        return new myViewHolder(view);
    }

    public class myViewHolder extends RecyclerView.ViewHolder{

        ImageView img1;
        TextView header;

        public myViewHolder(@NonNull View itemView){
            super(itemView);

            img1 = itemView.findViewById(R.id.img1);
            header = itemView.findViewById(R.id.header);
        }
    }
}
