package demo.dagger_mvp.screens.splash.splashmvp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

import butterknife.ButterKnife;
import demo.dagger_mvp.R;
import demo.dagger_mvp.screens.splash.SplashScreenActivity;

/**
 * Created by sony on 27-04-2018.
 */

public class SplashView  {

    private View view;

    public SplashView(SplashScreenActivity context) {
        FrameLayout parent = new FrameLayout(context);
        parent.setLayoutParams(new FrameLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
        view = LayoutInflater.from(context).inflate(R.layout.activity_splash, parent, true);
        ButterKnife.bind(view, context);
    }

    public View constructView() {
        return view;
    }

}
