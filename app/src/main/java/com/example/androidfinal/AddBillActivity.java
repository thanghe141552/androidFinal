package com.example.androidfinal;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.androidfinal.Adapter.BookDropdownAdapter;
import com.example.androidfinal.Adapter.UserDropdownAdapter;
import com.example.androidfinal.Adapter.BillAdapter;
import com.example.androidfinal.DAO.BillDAO;
import com.example.androidfinal.DAO.UserDAO;
import com.example.androidfinal.DAO.BookDAO;
import com.example.androidfinal.Model.Bill;
import com.example.androidfinal.Model.User;
import com.example.androidfinal.Model.Book;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

public class AddBillActivity extends AppCompatActivity implements DatePickerDialog.OnDateSetListener, Serializable {
    private Spinner spin_user,spin_book;
    private BookDropdownAdapter bookDropdownAdapter;
    private UserDropdownAdapter userDropdownAdapter;
    private EditText txtBillCode,txtDate, txtQuantity;
    private TextView txtTotalPrice;
    private UserDAO userDAO;
    private BillDAO billDAO;
    private Book book;
    private User user;
    private Button btn_back;
    SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_bill);
        txtDate = findViewById(R.id.txt_add_date);
        txtBillCode = findViewById(R.id.billCode);
        txtQuantity = findViewById(R.id.txtQuantity);
        spin_user = findViewById(R.id.spin_user);
        spin_book = findViewById(R.id.spin_book);
        txtTotalPrice = findViewById(R.id.total_money);
        userDropdownAdapter = new UserDropdownAdapter(this, R.layout.item_user_selecteed, getListUser());

        btn_back = findViewById(R.id.btn_back);
        btn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                back();
            }
        });

        spin_user.setAdapter(userDropdownAdapter);
        spin_user.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                user = userDropdownAdapter.getItem(position);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        bookDropdownAdapter = new BookDropdownAdapter(this, getListBook());
        spin_book.setAdapter(bookDropdownAdapter);
        spin_book.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                book = (Book) bookDropdownAdapter.getItem(position);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        txtQuantity.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                int quantity = Integer.parseInt(s+"");
                double price = quantity * book.getPrice();
                txtTotalPrice.setText(price+"");
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
    }

    private List<User> getListUser() {
        UserDAO userDAO = new UserDAO(AddBillActivity.this);
        return userDAO.getAll();
    }
    private List<Book> getListBook(){
        BookDAO bookDAO = new BookDAO(AddBillActivity.this);
        return bookDAO.getListBook();
    }

    @Override
    public void onDateSet(DatePicker view, int year, int month, int day) {
        Calendar cal = new GregorianCalendar(year, month, day);
        setDate(cal);
    }

    private void setDate(final Calendar calendar) {
        txtDate.setText(sdf.format(calendar.getTime()));
    }

    public static class DatePickerFragment extends DialogFragment {
        @Override
        public Dialog onCreateDialog(Bundle savedInstanceState) {
            final Calendar c = Calendar.getInstance();
            int year = c.get(Calendar.YEAR);
            int month = c.get(Calendar.MONTH);
            int day = c.get(Calendar.DAY_OF_MONTH);
            return new DatePickerDialog(getActivity(),
                    (DatePickerDialog.OnDateSetListener)
                            getActivity(), year, month, day);
        }
    }

    public void datePicker(View view) {
        DatePickerFragment fragment = new DatePickerFragment();
        fragment.show(getSupportFragmentManager(), "date");
    }
    public void AddBill(View view) {
        billDAO = new BillDAO(AddBillActivity.this);
        try {
            if (validation() == false) {
                Toast.makeText(getApplicationContext(), "Please input all value", Toast.LENGTH_SHORT).show();
            } else {
                Bill bill = new Bill(Integer.parseInt(txtBillCode.getText().toString()),sdf.parse(txtDate.getText().toString()),
                        user.getUserName(),Integer.parseInt(txtQuantity.getText().toString()),book.getName(),
                        Double.parseDouble(String.valueOf(txtTotalPrice.getText())),false);
                if (billDAO.insertBill(bill)) {
                    Toast.makeText(getApplicationContext(), "Add successful", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(AddBillActivity.this,ListBillActivity.class);
                    startActivity(intent);
                } else {
                    Toast.makeText(getApplicationContext(), "Add Failed", Toast.LENGTH_SHORT).show();
                }
            }
        } catch (Exception ex) {
            Log.e("Error", ex.toString());
        }
    }
    public void back(){
        Intent intent = new Intent(AddBillActivity.this,ListBillActivity.class);
        startActivity(intent);
    }

    public boolean validation() {
        if (txtDate.getText().toString().isEmpty()||txtQuantity.getText().length() == 0
                || txtBillCode.getText().length() == 0 || book.getName().isEmpty() || user.getUserName().isEmpty()) {
            return false;
        }
        return true;
    }

}