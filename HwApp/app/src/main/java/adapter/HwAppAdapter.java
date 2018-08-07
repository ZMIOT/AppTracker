package adapter;

import android.support.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.example.hwapp.R;

import java.util.List;

import bean.HwItem;

public class HwAppAdapter extends BaseQuickAdapter<HwItem,BaseViewHolder>{
    public HwAppAdapter(int layoutResId, @Nullable List data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, HwItem item) {
        helper.setText(R.id.troubleName,item.getTroubleName());
    }
}
