package com.example.androidfinal;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.androidfinal.Adapter.BillAdapter;
import com.example.androidfinal.DAO.BillDAO;
import com.example.androidfinal.DAO.UserDAO;
import com.example.androidfinal.Model.Bill;
import com.example.androidfinal.Model.User;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

public class AddBillActivity extends AppCompatActivity implements DatePickerDialog.OnDateSetListener{
    private Spinner spin_user;
    private BillAdapter billAdapter;
    private EditText txt_bill_id,txtDate,txt;
    private UserDAO userDAO;
    private BillDAO billDAO;
    SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_bill);


        txtDate = findViewById(R.id.txt_add_date);
        spin_user = findViewById(R.id.spin_user);
        billAdapter = new BillAdapter(this, R.layout.item_user_selecteed, getListUser());
        spin_user.setAdapter(billAdapter);
        spin_user.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(AddBillActivity.this, billAdapter.getItem(position).getUserName(), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

    private List<User> getListUser() {
        List<User> listUser = new ArrayList<>();
        UserDAO userDAO = new UserDAO(AddBillActivity.this);
        List<User> users = userDAO.getAll();
        for (User u: users) {
            listUser.add(u);
        }
        Log.i("", "getListUserName: " + listUser);
        return listUser;
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
    public void datePicker(View view){
        DatePickerFragment fragment = new DatePickerFragment();
        fragment.show(getSupportFragmentManager(),"date");
    }
    public void AddBill(View view) {
        billDAO = new BillDAO(AddBillActivity.this);
        try {
            if (validation() == false) {
                Toast.makeText(getApplicationContext(), "Vui lòng nhập đầy đủ thông tin", Toast.LENGTH_SHORT).show();
            } else {
                Bill bill = new Bill(Integer.parseInt(txt_bill_id.getText().toString()),sdf.parse(txtDate.getText().toString()),String.valueOf(spin_user.getSelectedItem()) );
                if (billDAO.insertBill(bill)) {
                    Toast.makeText(getApplicationContext(), "Add successful", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(AddBillActivity.this,DetailBillActivity.class);
                    startActivity(intent);
                } else {
                    Toast.makeText(getApplicationContext(), "Add Failed", Toast.LENGTH_SHORT).show();
                }
            }
        } catch (Exception ex) {
            Log.e("Error", ex.toString());
        }
    }
    public boolean validation(){
        if (txt_bill_id.getText().toString().isEmpty()||txtDate.getText().toString().isEmpty() ){
            return false;
        }
        return true;
    }

}