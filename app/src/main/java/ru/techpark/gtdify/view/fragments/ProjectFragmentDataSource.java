package ru.techpark.gtdify.view.fragments;


import java.util.ArrayList;
import java.util.List;

public class ProjectFragmentDataSource {

    private final List<ProjectFragmentModel> mData;
    private static ProjectFragmentDataSource sInstance;

    public ProjectFragmentDataSource() {
        mData = new ArrayList<>();
        for (int i = 0; i < 100; i++){
            String title = Integer.toString(i);
            mData.add(new ProjectFragmentModel(title, false));
        }
    }

    public List<ProjectFragmentModel> getRemoteData(){
        return mData;
    }

    public synchronized static ProjectFragmentDataSource getInstance(){
        if (sInstance == null) {
            sInstance = new ProjectFragmentDataSource();
        }
        return sInstance;
    }
}
