package com.mycode.myjavatest.mvvm.base;

import android.os.Bundle;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import com.mycode.myjavatest.BR;
import com.mycode.myjavatest.mvvm.MvvmViewInject;

public abstract class BaseMvvmActivity<V extends ViewDataBinding> extends AppCompatActivity {

    protected V viewDataBinding;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        MvvmViewInject annotation = this.getClass().getAnnotation(MvvmViewInject.class);
        if(annotation != null) {
            int mainlayoutid = annotation.mainlayoutId();
            int[] ids = annotation.viewModelId();
            Class<? extends BaseMvvmModel>[] viewModelClass = annotation.viewModelClass();
            if(mainlayoutid > 0 && ids.length == viewModelClass.length) {
                bindView(mainlayoutid, ids, viewModelClass);
                /**
                 * 使用databinding 就不需要使用setContentView(mainlayoutid);
                 * */
                //setContentView(mainlayoutid);
                afterBindView();
            } else {
                throw new RuntimeException("mainlayoutid < 0");
            }
        } else {
            throw new RuntimeException("annotation = null");
        }
    }

    protected void bindView(int mainlayoutid, int[] ids, Class<? extends BaseMvvmModel>[] viewModelClass) {
        viewDataBinding = DataBindingUtil.setContentView(BaseMvvmActivity.this,mainlayoutid);
        /**
         * 如果采用LiveData替代Observable和DataBinding配合使用的话，需要加该句
         * */
        viewDataBinding.setLifecycleOwner(this);
        //viewDataBinding.setVariable(BR.mvvm)
        for(int i=0; i<ids.length; i++) {
            int id = ids[i];

            /**
             * 这里直接使用 Class<> clazz的话new ViewModelProvider()直接返回ViewModel viewModel的话，
             * getLifecycle().addObserver(viewModel)需要的类型为BaseMvvmModel类型的（BaseMvvmModel实现了LifecycleObserver）
             * 所以要用Class<? extends BaseMvvmModel>进行类型绑定，这样get(clazz)返回的是Class<? extends BaseMvvmModel>类型的，否则返回的是
             * ViewModel类型的
             * */
            Class<? extends BaseMvvmModel> clazz = viewModelClass[i];
            //ViewModel viewModel = new ViewModelProvider(this, new ViewModelProvider.AndroidViewModelFactory(getApplication())).get(clazz);
            BaseMvvmModel viewModel = new ViewModelProvider(this, new ViewModelProvider.AndroidViewModelFactory(getApplication())).get(clazz);
            viewDataBinding.setVariable(id,viewModel);
            getLifecycle().addObserver(viewModel);

            /**
             * 绑定ViewModel的livedata
             * */
            bindViewModel(viewModel);


        }
    }

    /**
     * 采用观察者的设计模式监听ViewModel层的数据变化
     * */
    protected void bindViewModel(BaseMvvmModel viewModel){
        viewModel.toastLiveData.observe(this, new Observer<String>() {
            @Override
            public void onChanged(String s) {
                Toast.makeText(BaseMvvmActivity.this,s,Toast.LENGTH_LONG).show();
            }
        });
    }

    protected abstract void afterBindView();
}
