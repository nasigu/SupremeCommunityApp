package com.example.supremecommunityapp.ui.abstracts;

public class BaseContract {

    public interface Presenter<T> {
        public void subscribe();
        public void unsubscribe();
        public void attach(T view);

    }

    public interface View {
        public void bind();
    }
}
