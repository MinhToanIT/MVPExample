package com.toannm.mvpexample.signin;

/**
 * Created by Minh Toan on 14/03/2018.
 */

public class SignInPresenter implements SignInContract.Presenter {

    private SignInContract.View mView;

    public void setView(SignInContract.View view) {
        mView = view;
    }

    @Override
    public void handleSignIn(String username, String password) {
        if (username.equals("mvpexample") && password.equals("1234")) {
            mView.signInSuccess();
            return;
        }

        mView.signInFailure("Username or Password not true!");
    }
}
