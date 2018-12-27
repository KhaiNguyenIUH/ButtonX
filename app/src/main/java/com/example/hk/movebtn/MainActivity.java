package com.example.hk.movebtn;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import net.yslibrary.android.keyboardvisibilityevent.KeyboardVisibilityEvent;
import net.yslibrary.android.keyboardvisibilityevent.KeyboardVisibilityEventListener;
import net.yslibrary.android.keyboardvisibilityevent.Unregistrar;
public class MainActivity extends AppCompatActivity {
    TextView mKeyboardStatus;
    EditText mTextField;
    Button mButtonUnregister;
    Unregistrar mUnregistrar;
    TextView mTxtView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mKeyboardStatus = findViewById(R.id.keyboard_status);
        mTextField = findViewById(R.id.edt1);
        mButtonUnregister = findViewById(R.id.button3);
        mKeyboardStatus.setMovementMethod(new ScrollingMovementMethod());
        mButtonUnregister.setMovementMethod(new ScrollingMovementMethod());
        //mKeyboardStatus.setText("asd asd ghlsdfjkghsdfjklghxdfjklghsdfjklghsdfjklghsdfjklghlsdfjikghsdfkjlghsdfjlkghsdfjklghsdfjklghsdfjklghsdfjklghsdfjklghsdfkjlgh" +"asd asd ghlsdfjkghsdfjklghxdfjklghsdfjklghsdfjklghsdfjklghlsdfjikghsdfkjlghsdfjlkghsdfjklghsdfjklghsdfjklghsdfjklghsdfjklghsdfkjlgh"+"asd asd ghlsdfjkghsdfjklghxdfjklghsdfjklghsdfjklghsdfjklghlsdfjikghsdfkjlghsdfjlkghsdfjklghsdfjklghsdfjklghsdfjklghsdfjklghsdfkjlgh"+ "ghlsdfjkghsdfjklghxdfjklghsdfjklghsdfjklghsdfjklghlsdfjikghsdfkjlghsdfjlkghsdfjklghsdfjklghsdfjklghsdfjklghsdfjklghsdfkjlghghlsdfjkghsdfjklghxdfjklghsdfjklghsdfjklghsdfjklghlsdfjikghsdfkjlghsdfjlkghsdfjklghsdfjklghsdfjklghsdfjklghsdfjklghsdfkjlghghlsdfjkghsdfjklghxdfjklghsdfjklghsdfjklghsdfjklghlsdfjikghsdfkjlghsdfjlkghsdfjklghsdfjklghsdfjklghsdfjklghsdfjklghsdfkjlghghlsdfjkghsdfjklghxdfjklghsdfjklghsdfjklghsdfjklghlsdfjikghsdfkjlghsdfjlkghsdfjklghsdfjklghsdfjklghsdfjklghsdfjklghsdfkjlgh"+"ghlsdfjkghsdfjklghxdfjklghsdfjklghsdfjklghsdfjklghlsdfjikghsdfkjlghsdfjlkghsdfjklghsdfjklghsdfjklghsdfjklghsdfjklghsdfkjlgh");
        mUnregistrar = KeyboardVisibilityEvent.registerEventListener(this, new KeyboardVisibilityEventListener() {
            @Override
            public void onVisibilityChanged(boolean isOpen) {
                //updateKeyboardStatusText(isOpen);
                if(KeyboardVisibilityEvent.isKeyboardVisible(MainActivity.this)==true)
                {
                    //Toast.makeText(MainActivity.this,"text",Toast.LENGTH_SHORT).show();
                    mButtonUnregister.setTranslationY(-050f);
                    //mTextField.setTranslationX(+200f);
                }
                else
                    mButtonUnregister.setTranslationY(0f);
            }
        });
        //updateKeyboardStatusText(KeyboardVisibilityEvent.isKeyboardVisible(this));

        mButtonUnregister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                unregister();
            }
        });
    }
    //private void updateKeyboardStatusText(boolean isOpen) {
        //mKeyboardStatus.setText(String.format("keyboard is %s", (isOpen ? "visible" : "hidden")));
    //}

    void unregister() {
        mUnregistrar.unregister();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        mUnregistrar.unregister();
    }
}
