package com.example.myfood_nguyenphuoctri;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import android.database.sqlite.SQLiteDatabase;
import com.example.myfood_nguyenphuoctri.SQLite_Phuoctri.Database_Phuoctri;


public class MainActivity extends AppCompatActivity {
    Database_Phuoctri dbHelper;
    SQLiteDatabase db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        dbHelper = new Database_Phuoctri(this);
        db = dbHelper.getWritableDatabase();
        db.execSQL("INSERT INTO User(Name, Gender, DateOfBirth, Phone, Username, Password) VALUES" +
                "('Nguyễn Phước Trí', 'Nam', '2005-03-23', '0764627401', 'Tri', '123'),"
                +"('Nguyễn Thị Yến Nhi', 'Nữ', '2005-09-26', '0987654321', 'Nhi', '456'),"
                +"('Nguyễn Tào Lao', 'Nam', '2004-03-03', '0948334310', 'Lao' , '123'),"
                +"('Nguyễn Văn Nương', 'Nữ', '2004-03-04', '0948334560', 'Nuong' , '456'),"
                +"('Nguyễn Văn Màu', 'Nam', '2006-03-07', '0948341020', 'Mau' , '789')");

        db.execSQL("INSERT INTO Restaurant(Name, Address, Phone, Image) VALUES" +
                "('Nhà hàng Minh Tâm', 'TP.HCM', '0456789410', 'minhtam.png'),"
                +"('Nhà hàng Phước Trí', 'TP.HCM', '0435437998', 'theanh.png'),"
                +"('Nhà hàng Secret', 'TP.HCM', '0435437998', 'secret.png'),"
                +"('Nhà hàng Tào Lao', 'TP.HCM', '0956436580', 'theanh.png'),"
                +"('Nhà hàng Tịnh Tâm', 'Hà Nội', '098765432', 'tinhtam.png')");

        db.execSQL("INSERT INTO Food(Name, Type, Description, Image, ResID) VALUES" +
                "('Phở', 'Món chính', 'Phở bò thơm ngon', 'pho.png', 1),"
                +"('Bún chả', 'Món chính', 'Đặc sản Hà Nội', 'buncha.png', 2),"
                +"('Cơm tấm', 'Món chính', 'Ngon mê li', 'comtam.png', 3),"
                +"('Canh chua', 'Món chính', 'Chua kinh khủng', 'canhchua.png', 4),"
                +"('Thịt kho tàu', 'Món chính', 'Ăn không ngán', 'thitkhotau.png', 5),"
                +"('Trứng chiên nước mắm', 'Món chính', 'Bổ, rẻ', 'trungchiennuocmam.png', 1),"
                +"('Sữa chua', 'Ăn nhẹ', 'Ăn tốt cho tiêu hóa', 'suachua.png', 3),"
                +"('Trứng chiên nước mắm', 'Món chính', 'Bổ, rẻ', 'trungchiennuocmam.png', 2),"
                +"('Kiwi', 'Ăn tráng mồm', 'Ngon mà hơi mắt', 'kiwi.png', 3),"
                +"('Bánh mì', 'Ăn nhẹ', 'Bánh mì thịt', 'banhmi.png', 4)");
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}