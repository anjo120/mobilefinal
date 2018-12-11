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
import android.widget.Toast;

import a59070120.kmitl.ac.th.mobilefinal.Database.User;
import a59070120.kmitl.ac.th.mobilefinal.Database.DBHelper;

public class RegisterFragment extends Fragment {

    private DBHelper userDB;
    private int ID;
    User user = new User();

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_register,container,false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Button _registerBtn = (Button) getView().findViewById(R.id.register_btn);
        _registerBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText _userID = (EditText) getView().findViewById(R.id.register_userid);
                EditText _name = (EditText) getView().findViewById(R.id.register_name);
                EditText _age = (EditText) getView().findViewById(R.id.register_age);
                EditText _password = (EditText) getView().findViewById(R.id.register_password);

                String _userIDStr = _userID.getText().toString();
                String _nameStr = _userID.getText().toString();
                String _ageStr = _userID.getText().toString();
                String _passwordStr = _password.getText().toString();

                if (_userIDStr.isEmpty()
                        || _passwordStr.isEmpty()
                        || _ageStr.isEmpty()
                        || _nameStr.isEmpty()) {
                    Toast.makeText(
                            getActivity(),
                            "กรุณากรอกข้อมูลให้ครบถ้วน",
                            Toast.LENGTH_SHORT
                    ).show();
                    Log.d("REGISTER", "SOME FIELDS ARE EMPTY");

                }else if(_userIDStr.length() < 6 || _userIDStr.length() > 12){
                    Toast.makeText(
                            getActivity(),
                            "User ID ต้องมีความยาวตั้งแต่ 6 - 12 ตัวอักษร",
                            Toast.LENGTH_SHORT
                    ).show();
                    Log.d("REGISTER", "SMALLER USERNAME");
               /* } else if (_nameStr.contains(" ")==false){
                    Toast.makeText(
                            getActivity(),
                            "กรุณาระบุชื่อและนามสกุลให้ถูกต้อง",
                            Toast.LENGTH_SHORT
                    ).show();
                    Log.d("REGISTER", "ERROR NAME AND SURNAME");*/
                }else{
                    user.setUser(_userIDStr);
                    user.setPassword(_passwordStr);
                    user.setName(_nameStr);
                    user.setAge(_ageStr);
                    Log.d("REGISTER", user.getUser());

                    getActivity().getSupportFragmentManager()
                            .beginTransaction()
                            .replace(R.id.main_view,new LoginFragment())
                            .addToBackStack(null).commit();
                    Log.d("REGISTER","GO TO LOGIN");
                }
            }
        });

    }


}
