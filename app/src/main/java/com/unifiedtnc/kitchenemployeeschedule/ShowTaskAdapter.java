package com.unifiedtnc.kitchenemployeeschedule;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.DialogInterface;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.media.session.MediaSession;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.unifiedtnc.kitchenemployeeschedule.RetrofitResponseModle.Datum;
import com.unifiedtnc.kitchenemployeeschedule.RetrofitResponseModle.InerstTaskResponse;
import com.unifiedtnc.kitchenemployeeschedule.RetrofitResponseModle.TaskResponce;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static android.graphics.Color.WHITE;

public class ShowTaskAdapter extends RecyclerView.Adapter<ShowTaskAdapter.ViewHolder> {

    Context context;
    List<Datum> list;

    public ShowTaskAdapter(Context context, List<Datum> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View  view = LayoutInflater.from(context).inflate(R.layout.inflater_row, parent, false);



        return new ViewHolder(view);
    }


    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        Datum taskResponce=list.get(position);
        holder.txt.setText(taskResponce.getTName());




        if (taskResponce.getDTaskStatus().equals("1")) {
            holder.checkBox.setChecked(true);
            holder.checkBox.setEnabled(false);
            holder.cardView.setCardBackgroundColor(Color.rgb(94,186,125));
            holder.txt.setTextColor(WHITE);
            holder.checkBox.setBackgroundColor(Color.parseColor("#5eba7d"));

                        } else {



            holder.checkBox.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    AlertDialog.Builder builder=new AlertDialog.Builder(context);
                    builder.setTitle("Check Box");
                    builder.setMessage("Message Box..!");
                    builder.create();
                    builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {

                            Toast.makeText(context, taskResponce.getTId(), Toast.LENGTH_SHORT).show();

                            Call<InerstTaskResponse> call1=RetrofitClient
                                    .getInstance()
                                    .getApi()
                                    .add_complete_task(taskResponce.getTId(),"TestEmploy",taskResponce.getTName(),taskResponce.getTDay());
                            call1.enqueue(new Callback<InerstTaskResponse>() {
                                @Override
                                public void onResponse(Call<InerstTaskResponse> call, Response<InerstTaskResponse> response) {
                                    InerstTaskResponse inerstTaskResponse=response.body();
                                    if (response.isSuccessful()){
                                        Toast.makeText(context, inerstTaskResponse.getMessage(), Toast.LENGTH_SHORT).show();


                                    }else
                                    {
                                        Toast.makeText(context, inerstTaskResponse.getMessage(), Toast.LENGTH_SHORT).show();

                                    }


                                }

                                @Override
                                public void onFailure(Call<InerstTaskResponse> call, Throwable t) {
                                    Toast.makeText(context, t.getMessage(), Toast.LENGTH_SHORT).show();

                                }
                            });

                        }
                    }).setNegativeButton("No",null);

                    builder.show();



                }
            });
            ///////////////
//            holder.checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
//                                @Override
//                                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
//
//                                    if (isChecked) {
//
//                                    }
//                                }
//
//                            });

                        }

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView txt;
        CheckBox checkBox;
        CardView cardView;
        public ViewHolder(@NonNull View itemView) {

            super(itemView);
             txt = itemView.findViewById(R.id.txt);
             checkBox = itemView.findViewById(R.id.checkBox);
             cardView = itemView.findViewById(R.id.cardView);
        }
    }
}
