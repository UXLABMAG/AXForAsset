package com.example.labux;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AlertDialog;

public class DetailLogic extends AppCompatActivity {

    // Declare all the components
    private ImageView imgSection;
    private ScrollView scrollImageSection, scrollDescriptionSection, scrollFormSection1, scrollFormSection2;
    private LinearLayout linearImageSection, linearDescriptionSection, linearFormSection1, linearFormSection2;
    private TextView tvTitle, tvDescription, tvHeadline, tvDetailedDescription;
    private TextView tvEmailLabel, tvPaymentMethodLabel;
    private EditText etEmail;
    private Spinner spinnerPaymentMethod;
    private Button btnNext1, btnNext2;

    private TextView tvTitle2, tvDescription2, tvEmailLabel2, tvEmailValue;
    private TextView tvPaymentMethodLabel2, tvPaymentMethodValue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detail);

        // Initialize all the components
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

        btnNext1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = etEmail.getText().toString().trim();
                String selectedPaymentMethod = spinnerPaymentMethod.getSelectedItem().toString();
                AlertDialog.Builder builder = new AlertDialog.Builder(DetailLogic.this);

                if (!email.isEmpty() && Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
                    if (!selectedPaymentMethod.equals("PayPal")) {
                        scrollFormSection1.setVisibility(View.GONE);
                        scrollFormSection2.setVisibility(View.VISIBLE);

                        tvEmailValue.setText(email);
                        tvPaymentMethodValue.setText(selectedPaymentMethod);
                    } else {
                        builder.setTitle("Payment Method Error")
                                .setMessage("Please select a payment method other than PayPal.")
                                .setPositiveButton("OK", null)
                                .show();
                    }
                } else {
                    builder.setTitle("Email Error")
                            .setMessage("Invalid email address.")
                            .setPositiveButton("OK", null)
                            .show();
                }
            }
        });

        btnNext2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(DetailLogic.this);
                builder.setTitle("Success")
                        .setMessage("Your order has been placed successfully.")
                        .setPositiveButton("OK", null)
                        .show();
            }
        });
    }
}
