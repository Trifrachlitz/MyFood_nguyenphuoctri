package com.example.myfood_nguyenphuoctri;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class RegisterActivityTri extends AppCompatActivity {

    EditText edtUsername, edtPassword, edtRePassword;
    Button btnRegister;
    TextView tvToLogin;
    UserDatabaseHelperTri dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_register_phuoctri);

        dbHelper = new UserDatabaseHelperTri(this);

        edtUsername = findViewById(R.id.edtUsername);
        edtPassword = findViewById(R.id.edtPassword);
        edtRePassword = findViewById(R.id.edtRePassword);
        btnRegister = findViewById(R.id.btnRegister);
        tvToLogin = findViewById(R.id.tvToLogin);

        btnRegister.setOnClickListener(v -> {
            String user = edtUsername.getText().toString().trim();
            String pass = edtPassword.getText().toString().trim();
            String rePass = edtRePassword.getText().toString().trim();

            if (user.isEmpty() || pass.isEmpty() || rePass.isEmpty()) {
                Toast.makeText(this, "Vui lòng nhập đầy đủ", Toast.LENGTH_SHORT).show();
            } else if (!pass.equals(rePass)) {
                Toast.makeText(this, "Mật khẩu không khớp", Toast.LENGTH_SHORT).show();
            } else if (dbHelper.checkUsernameExists(user)) {
                Toast.makeText(this, "Tên đăng nhập đã tồn tại", Toast.LENGTH_SHORT).show();
            } else {
                boolean inserted = dbHelper.insertUser(user, pass);
                if (inserted) {
                    Toast.makeText(this, "Đăng ký thành công", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(this, LoginActivityTri.class));
                    finish();
                } else {
                    Toast.makeText(this, "Lỗi khi đăng ký", Toast.LENGTH_SHORT).show();
                }
            }
        });

        tvToLogin.setOnClickListener(v -> {
            startActivity(new Intent(this, LoginActivityTri.class));
            finish();
        });
    }
}
