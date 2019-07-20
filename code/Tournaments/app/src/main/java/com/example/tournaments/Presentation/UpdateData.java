package com.example.tournaments.Presentation;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import com.example.tournaments.R;
import com.example.tournaments.businessLogic.Controllers.UpdateController;


import android.content.Intent;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;
import com.example.tournaments.businessLogic.Controllers.SignupController;
import com.example.tournaments.dataAcces.models.User;
/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link UpdateData.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link UpdateData#newInstance} factory method to
 * create an instance of this fragment.
 */
public class UpdateData extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;


    private EditText et_name;
    private EditText et_username;
    private EditText et_password;
    private UpdateController updateController;
    LoginActivity loginActivity;
    String currentUsername;

    private OnFragmentInteractionListener mListener;

    public UpdateData() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment UpdateData.
     */
    // TODO: Rename and change types and number of parameters
    public static UpdateData newInstance(String param1, String param2) {
        UpdateData fragment = new UpdateData();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

/*
        et_name = (EditText) getActivity().findViewById(R.id.et_name);
        et_username = (EditText) getActivity().findViewById(R.id.et_username);
        et_password = (EditText) getActivity().findViewById(R.id.et_password);

        Bundle extras = getActivity().getIntent().getExtras();
        currentUsername = extras.getString("currentUser");


        Button btn_signup = (Button) getActivity().findViewById(R.id.btn_signup);
        btn_signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                updateController = new UpdateController();
                String name = et_name.getText().toString();
                String username = et_username.getText().toString();
                String password = et_password.getText().toString();
                try{
                    updateController.updateUser(currentUsername, name, username, password);
                    Toast.makeText(getActivity().getApplicationContext(), "Let's check!", Toast.LENGTH_SHORT).show();
                }catch(Exception e){
                    Toast.makeText(getActivity().getApplicationContext(), "The user could not be updated.", Toast.LENGTH_SHORT).show();
                }

            }
        });*/
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        TextView textView = new TextView(getActivity());
        textView.setText(R.string.hello_blank_fragment);
        et_name = (EditText) getActivity().findViewById(R.id.et_name);
        et_username = (EditText) getActivity().findViewById(R.id.et_username);
        et_password = (EditText) getActivity().findViewById(R.id.et_password);

        /*User userLoggedin = new User();
        loginActivity = new LoginActivity();
        userLoggedin = loginActivity.userstore;
        currentUsername = userLoggedin.getUsername();*/

        Bundle extras = getActivity().getIntent().getExtras();
        currentUsername = extras.getString("currentUser");
        View v = inflater.inflate(R.layout.activity_user_update_data, container, false);
        Button btn_signup = (Button) getActivity().findViewById(R.id.btn_signup);
        v.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                updateController = new UpdateController();
                String name = et_name.getText().toString();
                String username = et_username.getText().toString();
                String password = et_password.getText().toString();
                try{
                    updateController.updateUser(currentUsername, name, username, password);
                    Toast.makeText(getActivity().getApplicationContext(), "Let's check!", Toast.LENGTH_SHORT).show();
                }catch(Exception e){
                    Toast.makeText(getActivity().getApplicationContext(), "The user could not be updated.", Toast.LENGTH_SHORT).show();
                }

            }
        });
        return v ;
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
