package com.example.shapes;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class OverviewFragment extends Fragment {

    private OverviewFragmentActivityListener listener;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_overview, container, false);

        View.OnClickListener clickListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (v.getId()){
                    case R.id.button1fragment:
                        updateDetail("Szczegółowe informacje o elemencie pierwszym.");
                        break;
                    case R.id.button2fragment:
                        updateDetail("Szczegółowe informacje o elemencie drugim.");
                        break;
                    default:
                        break;
                }
            }
        };

        Button button1 = (Button) view.findViewById(R.id.button1fragment);
        Button button2 = (Button) view.findViewById(R.id.button2fragment);

        button1.setOnClickListener(clickListener);
        button2.setOnClickListener(clickListener);
        return view;
    }

    public interface OverviewFragmentActivityListener {
        public void onItemSelected(String msg);
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        if (activity instanceof OverviewFragmentActivityListener) {
            listener = (OverviewFragmentActivityListener) activity;
        } else {
            throw new ClassCastException( activity.toString() + " musi implementować interfejs: OverviewFragment.OverviewFragmentActivityListener");
        }
    }

    // metoda wysyła dane do aktywności
    public void updateDetail(String msg) {
        listener.onItemSelected(msg);
    }

}
