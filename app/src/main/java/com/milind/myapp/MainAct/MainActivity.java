package com.milind.myapp.MainAct;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.milind.myapp.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity implements MainContract.View {

    MainPresenter mainPresenter;
    @BindView(R.id.imageView)
    ImageView imageView;
    @BindView(R.id.btn_wildcard)
    Button btnWildcard;
    @BindView(R.id.btn_whatTeam)
    Button btnWhatTeam;
    @BindView(R.id.btn_whatColor)
    Button btnWhatColor;

    @BindView(R.id.btn_makeApiCall)
    Button btnMakeApiCall;
    @BindView(R.id.tv_ApiCallResult)
    TextView tvApiCallResult;
    static MainComponent mainComponent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        imageView.setImageResource(R.drawable.gsw);
        mainPresenter = new MainPresenter();
        mainPresenter.setViewer(this);
        mainComponent = DaggerMainComponent.builder().
                mainModule(new MainModule(this))
                .build();

    }


    @Override
    public boolean isItAWildCard() {
        return true;
    }

    @Override
    public void getData(String data) {
        tvApiCallResult.setText(data);
    }

    @Override
    public void whichTeam(String teamName) {
        Toast.makeText(this, teamName, Toast.LENGTH_SHORT).show();

    }

    @Override
    public void whichColor(String color) {
        Toast.makeText(this, color, Toast.LENGTH_SHORT).show();
    }

    @OnClick({R.id.btn_wildcard, R.id.btn_whatTeam, R.id.btn_whatColor,R.id.btn_makeApiCall})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btn_wildcard:
                mainPresenter.onWildcardClick();
                break;
            case R.id.btn_whatTeam:
                mainPresenter.onWhichTeamClick();
                break;
            case R.id.btn_whatColor:
                mainPresenter.onWhichColorClick();
                break;
            case R.id.btn_makeApiCall:
                mainPresenter.onApiCallClick();
                break;
        }
    }



}
