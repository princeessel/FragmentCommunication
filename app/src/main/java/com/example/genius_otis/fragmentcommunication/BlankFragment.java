package com.example.genius_otis.fragmentcommunication;



import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class BlankFragment extends Fragment {

    private EditText editText;
    private Button buttonSendMessage;
    private TextView textView1;
    private BlankFragmentListener blankFragmentListener;
    private FragmentListener2 fragmentListener2;


    public BlankFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_blank, container, false);
        editText = view.findViewById(R.id.editText);
        buttonSendMessage = view.findViewById(R.id.buttonSendMessage);
        textView1=view.findViewById(R.id.NameTV);
        buttonSendMessage.setOnClickListener(e -> {
            if(blankFragmentListener != null){
                blankFragmentListener.getMessage(editText.getText().toString());
            }
        });
        return view;
    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        blankFragmentListener = (BlankFragmentListener)context;
    }

    public void onAttachBackup(Context context) {
        super.onAttach(context);
        if(context instanceof BlankFragmentListener){
            blankFragmentListener = (BlankFragmentListener)context;
        }
    }

    public void setText(String message) {
        textView1.setText(message);
    }
}