package com.swosti.costcalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;

import com.google.android.material.textfield.TextInputEditText;

public class MainActivity extends AppCompatActivity {


    private TextInputEditText edtNoOfUnit, edtPlatformCost, edtLicenseFeePerUnit, edtLicenseFeeTtl,
    dataMigPerUnit, dataMigTtl, trainingCostPerUnit, trainingCostTtl, ttlVariableCost,
    ttlCostOfPurchase;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        /**
         *  Hooks
         * */
        edtNoOfUnit = findViewById(R.id.edt_no_of_unit);
        edtPlatformCost = findViewById(R.id.edt_platform_cost);
        edtLicenseFeePerUnit = findViewById(R.id.edt_license_fee_per_unit);
        edtLicenseFeeTtl = findViewById(R.id.edt_license_fee_ttl);
        dataMigPerUnit = findViewById(R.id.edt_data_mig_cost_per_unit);
        dataMigTtl = findViewById(R.id.edt_data_mig_cost_ttl);
        trainingCostPerUnit = findViewById(R.id.edt_training_cost_per_unit);
        trainingCostTtl = findViewById(R.id.edt_training_cost_ttl);
        ttlVariableCost = findViewById(R.id.edt_ttl_variable_cost);
        ttlCostOfPurchase = findViewById(R.id.edt_ttl_cost_of_purchase);


        setActionListener();




        edtPlatformCost.setText(String.format("%,d", 50000000));
        edtLicenseFeePerUnit.setText(String.format("%,d", 50000));
        dataMigPerUnit.setText(String.format("%,d", 30000));
        trainingCostPerUnit.setText(String.format("%,d", 5000));
        edtNoOfUnit.setText("1");




    }

    private void setActionListener() {

        edtNoOfUnit.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {

                int noOfUnit = getInt(edtNoOfUnit);
                int licenseFeePerUnit = getInt(edtLicenseFeePerUnit);
                int dataFeePerUnit = getInt(dataMigPerUnit);
                int trainingFeePerUnit = getInt(trainingCostPerUnit);

                int licenseTotal = noOfUnit * licenseFeePerUnit;
                int dataTotal = noOfUnit * dataFeePerUnit;
                int trainingTotal = noOfUnit * trainingFeePerUnit;

                int totalVariableCost = licenseTotal + dataTotal + trainingTotal;

                edtLicenseFeeTtl.setText(String.format("%,d",licenseTotal));
                dataMigTtl.setText(String.format("%,d",dataTotal));
                trainingCostTtl.setText(String.format("%,d",trainingTotal));

                ttlVariableCost.setText(String.format("%,d",totalVariableCost));


            }
        });



        ttlVariableCost.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                int platformCost = getInt(edtPlatformCost);
                int totalVariableCost = getInt(ttlVariableCost);

                int costOfPurchase = platformCost+totalVariableCost;
                ttlCostOfPurchase.setText(String.format("%,d",costOfPurchase));

            }
        });


        edtPlatformCost.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                int platformCost = getInt(edtPlatformCost);
                int totalVariableCost = getInt(ttlVariableCost);
                int costOfPurchase = platformCost+totalVariableCost;
                ttlCostOfPurchase.setText(String.format("%,d",costOfPurchase));

            }
        });


        edtLicenseFeePerUnit.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                int noOfUnit = getInt(edtNoOfUnit);
                int licenseFeePerUnit = getInt(edtLicenseFeePerUnit);

                int licenseTotal = noOfUnit * licenseFeePerUnit;
                int dataTotal = getInt(dataMigTtl);
                int trainingTotal = getInt(trainingCostTtl);

                int totalVariableCost = licenseTotal + dataTotal + trainingTotal;

                edtLicenseFeeTtl.setText(String.format("%,d",licenseTotal));
                dataMigTtl.setText(String.format("%,d",dataTotal));
                trainingCostTtl.setText(String.format("%,d",trainingTotal));

                ttlVariableCost.setText(String.format("%,d",totalVariableCost));
            }
        });



        dataMigPerUnit.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                int noOfUnit = getInt(edtNoOfUnit);
                int dataFeePerUnit = getInt(dataMigPerUnit);

                int licenseTotal = getInt(edtLicenseFeeTtl); ;
                int dataTotal =  noOfUnit * dataFeePerUnit;
                int trainingTotal = getInt(trainingCostTtl); // noOfUnit * trainingFeePerUnit;

                int totalVariableCost = licenseTotal + dataTotal + trainingTotal;

                edtLicenseFeeTtl.setText(String.format("%,d",licenseTotal));
                dataMigTtl.setText(String.format("%,d",dataTotal));
                trainingCostTtl.setText(String.format("%,d",trainingTotal));

                ttlVariableCost.setText(String.format("%,d",totalVariableCost));
            }
        });




        trainingCostPerUnit.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                int noOfUnit = getInt(edtNoOfUnit);
                int trainingFeePerUnit = getInt(trainingCostPerUnit);

                int licenseTotal = getInt(edtLicenseFeeTtl); ;
                int dataTotal =  getInt(dataMigTtl);
                int trainingTotal = noOfUnit*trainingFeePerUnit; // noOfUnit * trainingFeePerUnit;

                int totalVariableCost = licenseTotal + dataTotal + trainingTotal;

                edtLicenseFeeTtl.setText(String.format("%,d",licenseTotal));
                dataMigTtl.setText(String.format("%,d",dataTotal));
                trainingCostTtl.setText(String.format("%,d",trainingTotal));

                ttlVariableCost.setText(String.format("%,d",totalVariableCost));
            }
        });

    }


    public static Integer getInt(TextInputEditText editText) {
        if (editText == null || editText.getText() == null) {
            return 0;
        }

        String value = editText.getText().toString().trim();
        value = value.replaceAll(",", "");

        if (value.isEmpty()) {
            return 0;
        }

        try {
            return Integer.parseInt(value);
        } catch (NumberFormatException e) {
            return 0;
        }
    }
}