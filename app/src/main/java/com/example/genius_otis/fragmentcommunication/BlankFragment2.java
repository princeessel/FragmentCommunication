package com.example.genius_otis.fragmentcommunication;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class BlankFragment2 extends Fragment {

    private TextView textView1;



    private EditText editText;
    private Button buttonSendMessage;

    private FragmentListener2 blankFragmentListener;


    public BlankFragment2() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_blank_fragment2, container, false);
        editText = view.findViewById(R.id.editText);
        buttonSendMessage = view.findViewById(R.id.buttonSendMessage);
        textView1=view.findViewById(R.id.anyNameTV);
        buttonSendMessage.setOnClickListener(e -> {
            if(blankFragmentListener != null){
                blankFragmentListener.setMessage(editText.getText().toString());
            }
        });
        return view;
    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        blankFragmentListener = (FragmentListener2)context;
    }

    public void onAttachBackup(Context context) {
        super.onAttach(context);
        if(context instanceof BlankFragmentListener){
            blankFragmentListener = (FragmentListener2)context;
        }
    }

    public void setText(String message) {
        textView1.setText(message);
    }
}

