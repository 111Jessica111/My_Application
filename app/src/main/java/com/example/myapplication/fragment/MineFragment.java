package com.example.myapplication.fragment;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

import com.example.myapplication.LoginActivity;
import com.example.myapplication.R;

public class MineFragment extends Fragment {

    private View rootView;
    private Button btn_finish;
    private ImageView edit_image;
    private ImageView head_change;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        rootView = inflater.inflate(R.layout.fragment_mine, container, false);

        btn_finish = rootView.findViewById(R.id.btn_finish);
        edit_image = rootView.findViewById(R.id.edit_image);
        head_change = rootView.findViewById(R.id.head_chage);

        btn_finish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Dialog dialog = new Dialog(getActivity());
                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));

                dialog.setContentView(R.layout.finish);
                dialog.show();

                Button btn_out = dialog.findViewById(R.id.btn_out);
                Button btn_stay = dialog.findViewById(R.id.btn_stay);

                btn_out.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        getActivity().finish();
                        Intent intent = new Intent(getActivity(), LoginActivity.class);
                        startActivity(intent);
                    }
                });

                btn_stay.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        dialog.dismiss();
                    }
                });
            }
        });

        edit_image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Dialog dialog = new Dialog(getActivity());
                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));

                dialog.setContentView(R.layout.head_chage);
                dialog.show();

                ImageView head_1 = dialog.findViewById(R.id.head_1);
                ImageView head_2 = dialog.findViewById(R.id.head_2);
                ImageView head_3 = dialog.findViewById(R.id.head_3);
                ImageView head_4 = dialog.findViewById(R.id.head_4);
                ImageView head_5 = dialog.findViewById(R.id.head_5);
                ImageView head_6 = dialog.findViewById(R.id.head_6);

                head_1.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        head_change.setImageResource(R.mipmap.head_1);
                        dialog.dismiss();
                    }
                });

                head_2.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        head_change.setImageResource(R.mipmap.head_2);
                        dialog.dismiss();
                    }
                });
                head_3.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        head_change.setImageResource(R.mipmap.head_3);
                        dialog.dismiss();
                    }
                });
                head_4.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        head_change.setImageResource(R.mipmap.head_4);
                        dialog.dismiss();
                    }
                });
                head_5.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        head_change.setImageResource(R.mipmap.head_5);
                        dialog.dismiss();
                    }
                });
                head_6.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        head_change.setImageResource(R.mipmap.head_6);
                        dialog.dismiss();
                    }
                });


            }
        });

        return rootView;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

    }
}