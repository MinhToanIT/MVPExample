package com.toannm.mvpexample.signin;

/**
 * Created by Minh Toan on 14/03/2018.
 */

public interface SignInContract {
    interface View {
        void signInSuccess();

        void signInFailure(String error);
    }

    interface Presenter {
        void handleSignIn(String username, String password);
    }
}
