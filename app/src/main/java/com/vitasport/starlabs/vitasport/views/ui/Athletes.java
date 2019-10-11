package com.vitasport.starlabs.vitasport.views.ui;

import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.vitasport.starlabs.vitasport.R;
import com.vitasport.starlabs.vitasport.adapters.AthletesAdapter;
import com.vitasport.starlabs.vitasport.models.AthletesModel;
import com.vitasport.starlabs.vitasport.view_models.AthletesViewModel;
import com.vitasport.starlabs.vitasport.view_models.adapters.AthletesViewAdapter;
import com.vitasport.starlabs.vitasport.views.core.BaseFragment;

import java.util.ArrayList;

import butterknife.BindView;

public class Athletes extends BaseFragment {
    private AthletesViewModel athletesViewModel = null;
    private AthletesAdapter adapter;


    private AthletesAdapter.IAthletesAdapterListener adapterListener = new AthletesAdapter.IAthletesAdapterListener() {

        @Override
        public void onToggle(int position) {

        }

        @Override
        public void onSelected(int position, AthletesModel athletes) {
            if (isAdded() && isVisible() && getActivity() != null) {
                Intent intent = new Intent(getActivity(), UserDetail.class);
                intent.putExtra("identifier",athletes.identifier);
                startActivity(intent);
            }
        }
    };


    private AthletesViewAdapter athletesViewAdapter = new AthletesViewAdapter() {
            @Override
            public void getAthletesList(ArrayList<AthletesModel> list) {
                super.getAthletesList(list);
                if (isAdded() && getActivity() != null) {
                    if (adapter != null && list != null)
                        adapter.setItemList(list);
                }
            }
        };

        @BindView(R.id.athletes_list_rvResult) protected RecyclerView rvResult;

        @Override
        protected int getLayoutId() {
            return R.layout.athletes;
        }

        @Override
        protected void init(@NonNull View itemView, @Nullable Bundle savedInstanceState) {
            if (isAdded() && getActivity() != null) {

                athletesViewModel = ViewModelProviders.of(getActivity()).get(AthletesViewModel.class);
                athletesViewModel.setAthletesViewAdapter(athletesViewAdapter);

                adapter = new AthletesAdapter();
                adapter.setListener(adapterListener);

                rvResult.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false));
                rvResult.setItemAnimator(new DefaultItemAnimator());
                DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(rvResult.getContext(),
                        LinearLayoutManager.VERTICAL);
                rvResult.addItemDecoration(dividerItemDecoration);
                rvResult.setAdapter(adapter);

                athletesViewModel.getAthletesModelList();
            }
        }
}
