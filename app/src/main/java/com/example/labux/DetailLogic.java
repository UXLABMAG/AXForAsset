package com.example.labux;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.Spinner;
import android.widget.TextView;
import androidx.appcompat.app.AlertDialog;
import androidx.core.content.ContextCompat;

import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.WindowManager;

public class DetailLogic extends MainActivity {

    // Deklarasi semua komponen
    private ImageView imgSection;
    private ScrollView scrollDescriptionSection, scrollFormSection1, scrollFormSection2;
    private LinearLayout linearDescriptionSection, linearFormSection1, linearFormSection2;
    private TextView tvTitle, tvDescription, tvHeadline, tvDetailedDescription;
    private TextView tvEmailLabel, tvPaymentMethodLabel;
    private EditText etEmail;
    private Spinner spinnerPaymentMethod;
    private Button btnNext1, btnNext2;
    private LinearLayout btn_back;

    private TextView tvTitle2, tvDescription2, tvEmailLabel2, tvEmailValue;
    private TextView tvPaymentMethodLabel2, tvPaymentMethodValue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detail);

        getSupportActionBar().setTitle("Game Assets Detail");

        // Inisialisasi semua komponen
        imgSection = findViewById(R.id.imgSection);
        scrollDescriptionSection = findViewById(R.id.scrollDescriptionSection);
        scrollFormSection1 = findViewById(R.id.scrollFormSection1);
        scrollFormSection2 = findViewById(R.id.scrollFormSection2);

        linearDescriptionSection = findViewById(R.id.linearDescriptionSection);
        linearFormSection1 = findViewById(R.id.linearFormSection1);
        linearFormSection2 = findViewById(R.id.linearFormSection2);

        tvTitle = findViewById(R.id.tvTitle);
        tvDescription = findViewById(R.id.tvDescription);
        tvHeadline = findViewById(R.id.tvHeadline);
        tvDetailedDescription = findViewById(R.id.tvDetailedDescription);

        tvEmailLabel = findViewById(R.id.tvEmailLabel);
        etEmail = findViewById(R.id.etEmail);
        tvPaymentMethodLabel = findViewById(R.id.tvPaymentMethodLabel);
        spinnerPaymentMethod = findViewById(R.id.spinnerPaymentMethod);
        btnNext1 = findViewById(R.id.btnNext1);

        tvTitle2 = findViewById(R.id.tvTitle2);
        tvDescription2 = findViewById(R.id.tvDescription2);
        tvEmailLabel2 = findViewById(R.id.tvEmailLabel2);
        tvEmailValue = findViewById(R.id.tvEmailValue);
        tvPaymentMethodLabel2 = findViewById(R.id.tvPaymentMethodLabel2);
        tvPaymentMethodValue = findViewById(R.id.tvPaymentMethodValue);
        btnNext2 = findViewById(R.id.btnNext2);


//        Set Text
        Intent intent = getIntent();
        Item item = intent.getParcelableExtra("item");

        tvTitle.setText(item.getItem_name());
        tvDescription2.setText(item.getItem_desc());
        tvEmailValue.setText(etEmail.getText().toString());
        tvPaymentMethodValue.setText(spinnerPaymentMethod.getSelectedItem().toString());

//        // Set onClickListener
        btnNext1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btnNext1.setBackground(getDrawable(R.drawable.rounded_button_pressed));

                // Create a Handler to revert the color back after 500 milliseconds
                new Handler(Looper.getMainLooper()).postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        btnNext1.setBackground(getDrawable(R.drawable.rounded_button));
                    }
                }, 100);

                String email = etEmail.getText().toString().trim();
                String selectedPaymentMethod = spinnerPaymentMethod.getSelectedItem().toString();
                if (!email.isEmpty() && Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
                    if (!selectedPaymentMethod.equals("SUPERMAN")) {
                        scrollFormSection1.setVisibility(View.GONE);
                        scrollFormSection2.setVisibility(View.VISIBLE);
                        tvEmailValue.setText(email);
                        tvPaymentMethodValue.setText(selectedPaymentMethod);
                    }
//                    else {
//                        // Tampilkan dialog error dengan warna kustom
//                        showAlertDialog("Form Validation", "Please select a payment method other than PayPal.", "red");
//                    }
                } else if (email.isEmpty()){
                    // Tampilkan dialog error dengan warna kustom
                    showAlertDialog("Form Validation", "Email must be filled!", "red");
                } else if (!Patterns.EMAIL_ADDRESS.matcher(email).matches())
                {
                    showAlertDialog("Form Validation", "Invalid email format!", "red");
                }
            }
        });

        tvTitle2.setText(item.getItem_name());
        tvDescription.setText(item.getItem_desc());
        tvDetailedDescription.setText(item.getItem_detail_desc());
        imgSection.setImageResource(item.getItem_image());

        btnNext2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btnNext2.setBackground(getDrawable(R.drawable.rounded_button_pressed));

                // Create a Handler to revert the color back after 500 milliseconds
                new Handler(Looper.getMainLooper()).postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        btnNext2.setBackground(getDrawable(R.drawable.rounded_button));
                    }
                }, 100);
                // Tampilkan dialog sukses dengan warna kustom
                showSuccessDialog("Order Successful", "Your game asset has been sent to " + etEmail.getText().toString(),"green");
            }
        });

        btn_back = findViewById(R.id.back_section);
        btn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), DashboardActivity.class);
                v.getContext().startActivity(intent);
            }
        });
    }

    private void showAlertDialog(String title, String message,String Collor) {
        // Inflater untuk custom alert dialog layout
        LayoutInflater inflater = getLayoutInflater();
        View dialogView = inflater.inflate(R.layout.custom_alert_dialog, null);

        // Mengubah teks dan tampilan dari custom dialog
        TextView tvAlertTitle = dialogView.findViewById(R.id.tvAlertTitle);
        TextView tvAlertMessage = dialogView.findViewById(R.id.tvAlertMessage);
        Button btnAlertOk = dialogView.findViewById(R.id.btnAlertOk);

        tvAlertTitle.setText(title);
        tvAlertTitle.setBackgroundColor(Color.parseColor(Collor));
        tvAlertMessage.setText(message);


        AlertDialog.Builder builder = new AlertDialog.Builder(DetailLogic.this);
        builder.setView(dialogView);

        AlertDialog alertDialog = builder.create();

        // Center-kan tombol OK
        btnAlertOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                alertDialog.dismiss();
            }
        });
        alertDialog.getWindow().setBackgroundDrawable(ContextCompat.getDrawable(this, R.drawable.tag2));


        // Tampilkan dialog
        alertDialog.show();

        // Set ukuran dialog agar sesuai
        WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
        layoutParams.copyFrom(alertDialog.getWindow().getAttributes());
        layoutParams.width = WindowManager.LayoutParams.WRAP_CONTENT;
        layoutParams.height = WindowManager.LayoutParams.WRAP_CONTENT;
        alertDialog.getWindow().setAttributes(layoutParams);
    }

    private void showSuccessDialog(String title, String message,String Collor) {
        // Inflater untuk custom alert dialog layout
        LayoutInflater inflater = getLayoutInflater();
        View dialogView = inflater.inflate(R.layout.custom_success_dialog, null);

        // Mengubah teks dan tampilan dari custom dialog
        TextView tvAlertTitle = dialogView.findViewById(R.id.tvAlertTitle);
        TextView tvAlertMessage = dialogView.findViewById(R.id.tvAlertMessage);
        Button btnAlertOk = dialogView.findViewById(R.id.btnSuccessOk);

        tvAlertTitle.setText(title);
        tvAlertTitle.setBackgroundColor(Color.parseColor(Collor));
        tvAlertMessage.setText(message);


        AlertDialog.Builder builder = new AlertDialog.Builder(DetailLogic.this);
        builder.setView(dialogView);

        AlertDialog alertDialog = builder.create();

        // Center-kan tombol OK
        btnAlertOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                alertDialog.dismiss();
                Intent intent = new Intent(v.getContext(), ItemActivity.class);
                v.getContext().startActivity(intent);
            }
        });
        alertDialog.getWindow().setBackgroundDrawable(ContextCompat.getDrawable(this, R.drawable.tag2));


        // Tampilkan dialog
        alertDialog.show();

        // Set ukuran dialog agar sesuai
        WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
        layoutParams.copyFrom(alertDialog.getWindow().getAttributes());
        layoutParams.width = WindowManager.LayoutParams.WRAP_CONTENT;
        layoutParams.height = WindowManager.LayoutParams.WRAP_CONTENT;
        alertDialog.getWindow().setAttributes(layoutParams);
    }
}
