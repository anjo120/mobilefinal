package a59070120.kmitl.ac.th.mobilefinal;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import a59070120.kmitl.ac.th.mobilefinal.Database.DBHelper;
import a59070120.kmitl.ac.th.mobilefinal.Database.User;

public class LoginFragment extends Fragment {

    User user = new User();
    private DBHelper userDB;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_login,container,false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        initLogin();
        initRegister();
    }

    void initLogin(){

        Button _login = (Button) getView().findViewById(R.id.login_login_btn);
        _login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                EditText _userID = (EditText) getView().findViewById(R.id.login_user_id);
                EditText _password = (EditText) getView().findViewById(R.id.login_pasword);
                String _userIDStr = _userID.getText().toString();
                String _passwordStr = _password.getText().toString();

                if (_userIDStr.isEmpty() || _passwordStr.isEmpty()) {
                    Toast.makeText(
                            getActivity(),
                            "กรุณาระบุ Username หรือ Password ",
                            Toast.LENGTH_SHORT
                    ).show();
                } else {
                    SignIn(_userIDStr, _passwordStr);
                }
            }
        });

    }

    void initRegister(){
        TextView _register = (TextView) getView().findViewById(R.id.login_register_btn);
        _register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getActivity().getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.main_view,new RegisterFragment())
                        .addToBackStack(null).commit();
                Log.d("USER","GO TO REGISTER");
            }
        });
    }

    void SignIn(String username,String password){
        Bundle bundle = getArguments();

        userDB = new DBHelper(getActivity());

        String dbUser = user.getUser();
        String dbPass = user.getPassword();
        if (username.equals(dbUser)&&password.equals(dbPass)){
            getActivity()
                    .getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.main_view, new HomeFragment())
                    .commit();
        }else {
            Toast.makeText(
                    getActivity(),
                    "User นี้ยังไม่ได้ทำการสมัครสมาชิก",
                    Toast.LENGTH_SHORT
            ).show();
            Log.d("USER", "ERROR LOGIN");
        }

    }
}
