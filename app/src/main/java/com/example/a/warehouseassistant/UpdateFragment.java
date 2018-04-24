package com.example.a.warehouseassistant;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 */
public class UpdateFragment extends Fragment {

    private EditText ProductBarcode,Name,Quantity,ShelfBarcode;
    private Button btn_Update;

    public UpdateFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_update, container, false);
        ProductBarcode=view.findViewById(R.id.btn_barc);
        Name=view.findViewById(R.id.btn_name);
        Quantity=view.findViewById(R.id.btn_qua);
        ShelfBarcode=view.findViewById(R.id.shel_btn);
        btn_Update=view.findViewById(R.id.DoIT);


        btn_Update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int bc=Integer.parseInt(ProductBarcode.getText().toString());
                String nm=Name.getText().toString();
                int qt=Integer.parseInt(Quantity.getText().toString());
                int sb=Integer.parseInt(ShelfBarcode.getText().toString());

                Stock stock = new Stock();
                stock.setBarcodeProduct(bc);
                stock.setName(nm);
                stock.setQuantity(qt);
                stock.setBarcodeShelf(sb);

                ManageDB.myAppDatabase.dao().updateProduct(stock);
                Toast.makeText(getActivity(),"Stock updated",Toast.LENGTH_SHORT).show();
                ProductBarcode.setText("");
                Name.setText("");
                Quantity.setText("");
                ShelfBarcode.setText("");
            }
        });
        return view;
    }



}
