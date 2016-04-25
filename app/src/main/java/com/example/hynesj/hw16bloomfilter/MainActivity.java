package com.example.hynesj.hw16bloomfilter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity
{
    private Button hashButton;
    private EditText strTextInput;
    private TextView arrayOutput;
    private boolean[] bitArray = new boolean[18];

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.hashButton = (Button)this.findViewById(R.id.hashButton);
        this.strTextInput = (EditText)this.findViewById(R.id.strTextInput);
        this.arrayOutput = (TextView)this.findViewById(R.id.arrayOutput);
        this.hashButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                doSomething(v);
            }
        });
    }
    public void doSomething(View sender)
    {
        bitArray = new boolean[18];
        if (sender == this.hashButton)
        {
            hash(strTextInput.getText().toString());
            char[] chArr = new char[bitArray.length];
            for (int i = 0; i < bitArray.length; i++)
            {
                if (bitArray[i])
                    chArr[i] = '1';
                else
                    chArr[i] = '0';
            }
            arrayOutput.setText(chArr, 0, chArr.length);
            System.out.println(chArr);
        }
    }

    private void hash(String str)
    {
        k1(str, bitArray);
        k2(str, bitArray);
        k3(str, bitArray);
    }
    private void k1(String str, boolean[] bitArr)
    {
        for (int i = 0; i < str.length(); i++)
        {
            if (str.charAt(i) % 2 == 1)
            {
                bitArr[i % 18] = true;
            }
        }
    }
    private void k2(String str, boolean[] bitArr)
    {
        for (int i = 0; i < str.length(); i++)
        {
            if (str.charAt(i) + 11 % 3 == 2)
            {
                bitArr[i % 18] = true;
            }
        }
    }
    private void k3(String str, boolean[] bitArr)
    {
        for (int i = 0; i < str.length(); i++)
        {
            if (str.charAt(i) * 7 % 3 == 2)
            {
                bitArr[i % 18] = true;
            }
        }
    }
}
